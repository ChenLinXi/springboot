
import communication.ClientInfo;
import configcenterweb.model.ConfigData;
import configcenterweb.model.ConfigInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 
 */
public interface IConfigCenterController {
    //测试Controller，无repository & service
    @RequestMapping(method = RequestMethod.GET, value = "/")
    String Hello();

    //测试存储数据
    @RequestMapping(method = RequestMethod.POST, value = "/set/{projectName:[a-zA-Z0-9\\\\._,]+}")
    @ResponseBody
    String setConfigInfo(@PathVariable String projectName) throws Exception;

    @RequestMapping(method = RequestMethod.GET, value = "/getconfiglist/{projectNames:[a-zA-Z0-9\\\\._,]+}/{env:[a-zA-Z0-9\\\\._,]+}")
    @ResponseBody
    Map<String, List<ConfigData>> getConfigList(@PathVariable String projectNames, @PathVariable String envs);

    @RequestMapping(method = RequestMethod.GET, value = "/getconfiglist/{projectNames:[a-zA-Z0-9\\\\._,]+}/{publicProjectNames:[a-zA-Z0-9\\\\._,]+}")
    @ResponseBody()
    Map<String, List<ConfigData>> getConfigList(@PathVariable String projectNames, @PathVariable String publicProjectNames);

    @RequestMapping(method = RequestMethod.GET, value = "/getconfiglist/{projectNames:[a-zA-Z0-9\\\\._,]+}")
    @ResponseBody()
    Map<String, List<ConfigData>> getConfigList(@PathVariable String projectNames);

    @RequestMapping(method = RequestMethod.GET, value = "/getconfigversion/{projectName:[a-zA-Z0-9\\\\._]+}")
    @ResponseBody()
    long getConfigVersion(@PathVariable String projectName);

    @RequestMapping(method = RequestMethod.GET, value = "/getconfiglist/private/{projectName:[a-zA-Z0-9\\\\._]+}")
    @ResponseBody()
    List<ConfigData> getConfigListByPrivate(@PathVariable String projectName);

    @RequestMapping(method = RequestMethod.GET, value = "/getconfiginfo/private/{projectName:[a-zA-Z0-9\\\\._]+}")
    @ResponseBody()
    List<ConfigInfo> getConfigInfoByPrivate(@PathVariable String projectName);

    @RequestMapping(method = RequestMethod.GET, value = "/getconfiglist/public/{projectName:[a-zA-Z0-9\\\\._]+}")
    @ResponseBody()
    List<ConfigData> getConfigListByPublic(@PathVariable String projectName);

    @RequestMapping(method = RequestMethod.POST, value = "/modifyconfig")
    void modifyConfig(@RequestBody ModifyInfo info);

    @RequestMapping(method = RequestMethod.GET, value = "/getmodifyconfig/{projectName:[a-zA-Z0-9\\\\._]+}/{userName}")
    List<ModifyInfo> getModifyConfig(@PathVariable String projectName, @PathVariable String userName);

    //UI推送数据到服务器端,让服务器更新数据
    @RequestMapping(method = RequestMethod.POST, value = "push/{projectName:[a-zA-Z0-9\\\\._]+}/{userName}")
    List<String> pushConfig(@PathVariable String projectName, @PathVariable String userName) throws Exception;

    @RequestMapping(method = RequestMethod.GET, value = "getcurrentclient/{projectName:[a-zA-Z0-9\\\\._]+}")
    List<String> getCurrentClient(@PathVariable String projectName);

    @RequestMapping(method = RequestMethod.POST, value = "resetmodify/{projectName:[a-zA-Z0-9\\\\._]+}/{key:[a-zA-Z0-9\\\\._]+}/{userName}")
    void resetModifyCache(@PathVariable String projectName, @PathVariable String key, @PathVariable String userName);

    @RequestMapping(method = RequestMethod.POST, value = "modifyandpush")
    List<String> modifyAndPush(@RequestBody List<ModifyInfo> modifyInfoList) throws Exception;

    @RequestMapping(method = RequestMethod.GET, value = "clientstatus/{projectName:[a-zA-Z0-9\\\\._]+}")
    List<ClientInfo> getClientStatus(@PathVariable String projectName);
}
