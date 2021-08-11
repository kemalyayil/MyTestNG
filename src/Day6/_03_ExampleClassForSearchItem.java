package Day6;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _03_ExampleClassForSearchItem {
    @Test
    @Parameters({"searchItem"})
    public void exampleMethod(String searchItem){
        System.out.println("Example Class parameter: " + searchItem);
    }
}
