package Day15_TestNGInstalling_FirstMethods;

import org.testng.Assert;
import org.testng.annotations.*;

public class _02_TestNGBeforeAfterClass {

    @BeforeClass        // it will get executed once before any test executed. first that will be executed
   public void beforeAllTest(){
       System.out.println("Do sth before all the tests");
   }



   @AfterClass       // that will be executed in the end (only 1 time).
   public void afterEachTest(){
       System.out.println("Do sth after all the tests");
   }


    @Test
    public void test1(){
        String url = "www.techno.study";

        //Each test should have at least one Assertion.
        Assert.assertEquals("www.techno.study",url);            //passed
    }

    @Test
    public void test2(){
        String url = "www.techno.study";
        Assert.assertEquals("techno.study",url);                // fail
    }

    @Test
    public void test3() throws Exception{        // throw exception koydugumuzda,otomatik olarak testimiz fail olacak.
        // automatic exception handling
        // any exception here will fail the test

        // assume that sth wrong with the code
        throw new Exception();

    }
}
