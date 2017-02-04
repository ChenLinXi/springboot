@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {
    /*
        测试自动装配
        在CDPlayerConfig中加载配置
     */
    @Autowired
    @Qualifier("SgtPeppers")
    private CompactDisc compactDisc;    //装配接口类Bean
    
    @Autowired
    @Qualifier("SgtPeppers")
    private SgtPeppers sgtPeppers;      //装配接口实现类Bean
    
    @Test   //接口类Bean
    public void compactDiscPlay() {
        compactDisc.play(); //bean接口实现方法
    }
    
    @Test   //接口实现类Bean
    public void sgtPeppersPlay() {
        sgtPeppers.play();  //bean接口实现方法
        sgtPeppers.test();  //类方法
    }
}
