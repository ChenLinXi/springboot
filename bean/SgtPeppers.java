@Component
@Qualifier("SgtPeppers")
public class SgtPeppers implements CompactDisc{
    public void test() {
        System.out.println("test");
    }
    @Override
    public void play() {
        System.out.println("Hello Bean!");
    }
}
