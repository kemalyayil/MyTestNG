package Day5_FrameWorks_xmlFile;

import org.testng.annotations.Test;

public class _03_Groups {

    @Test(groups = "Regression")
    public void Test1(){
        System.out.println("Test1");
    }

    @Test(groups = "SmokeTest")
    public void Test2(){
        System.out.println("Test2");
    }

    @Test(groups = "Regression")
    public void Test3(){
        System.out.println("Test3");
    }

    @Test(groups = "SmokeTest")
    public void Test4(){
        System.out.println("Test4");
    }

    @Test(groups = "Regression")
    public void Test5(){
        System.out.println("Test5");
    }

    @Test(groups = "SmokeTest")
    public void Test6(){
        System.out.println("Test6");
    }


}
