package Day2_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

// bu interview sorusu
public class _02_SoftAssertVsHardAssert {

    //Hard Assert
    //When you do hard assert if Assertion fails code execution will stop
    @Test
    public void hardAssert(){
        System.out.println("Before Assertion");
        Assert.fail();
        System.out.println("After Assertion");              // bunu yazdirmadi
    }

    // Soft Assert
    // Use soft assert if you want to continue testing although some assertion failed already.
    @Test
    public void softAssert(){
        SoftAssert sf = new SoftAssert();
        System.out.println("Before Assertion");
        sf.fail();
        System.out.println("After Assertion");              // bunu da yazdirdi hata vermesine ragmen
        sf.assertAll();                             // this will check every assertion and throw an exception if any assertion failed
        // line 27 yi comment out yapinca, passed yaziyor. ama bu hepsini check ettiginden dolayi exception verdiriyor
    }

}
