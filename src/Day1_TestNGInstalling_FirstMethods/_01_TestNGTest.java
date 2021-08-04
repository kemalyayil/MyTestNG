package Day1_TestNGInstalling_FirstMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_TestNGTest {
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
