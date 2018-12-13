import org.junit.Test;

public class TestMain {
    @Test
    public void test(){
        String testPath = "start.node.end";
        String[] split = testPath.split("\\.");

        for(int i=0; i<split.length; i++){
            System.out.println(split[i]);
        }

    }
}
