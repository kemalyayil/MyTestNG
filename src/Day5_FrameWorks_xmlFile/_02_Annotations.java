package Day5_FrameWorks_xmlFile;

import org.testng.annotations.*;

public class _02_Annotations {

    @BeforeSuite
    public void beforeSuit(){
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }

    @BeforeTest // This will get executed before <test> tag not @Test
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @AfterTest // This will get executed before <test> tag not @Test
    public void afterTest(){
        System.out.println("After Test");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }
    @Test
    public void test(){
        System.out.println("Test");
    }

    @Test
    public void test2(){
        System.out.println("Test2");
    }
    /**
     * Before Suite
     * Before Test
     * Before Class
     * Before Method
     * Test
     * After Method
     * Before Method
     * Test2
     * After Method
     * After Class
     * After Test
     * After Suite
     */
}
