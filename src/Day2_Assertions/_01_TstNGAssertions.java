package Day2_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class _01_TstNGAssertions {
    /*
    Assert.assertEquals     ==> values ayni olup olmadigini karsilastiriyor
    Assert.assertSame       ==> object in ayni olup olmadigini karsilastiriyor

    assertEquals    : Asserts that two objects are equal.
    assertSame      : Asserts that two objects refer to the same object.

     */


    @Test
    public void assertEquals() {
        String expected = "Hello";
        String actual = "hello";

        // 1st actual , 2nd expected
        Assert.assertEquals(actual, expected, "Actual should be equal to Expected");      // sona string messaji ekleyebiliriz
        // mesajimiz test gecmezse gorunur.
    }

    @Test
    public void assertEquals2() {
        String expected = "Hello";
        String actual = "hello";

        // burda mesajimizi yazdiracak. cunku ayni deiller
        Assert.assertEquals(actual, expected, "Actual should be equal to Expected");
    }

    @Test
    public void assertEquals3(){
        String[] expected = {"Hello","2"};
        String[] actual = {"Hello","2"};

        Assert.assertEquals(actual,expected,"Actual should be equal to Expected");
    }

    @Test
    public void assertEqualsNoOrder(){              // it will not care the order.
        String[] expected = {"Hello","2"};
        String[] actual = {"2","Hello"};

        Assert.assertEqualsNoOrder(actual,expected,"Actual should be equal to Expected");
    }

    @Test
    public void assertNotEquals(){
        String[] expected = {"Hello","2"};
        String[] actual = {"Hello","2"};

        Assert.assertNotEquals(actual,expected,"Actual should not be equal to Expected");
    }

    @Test
    public void assertNotEquals2(){
        String[] expected = {"Hello","1"};
        String[] actual = {"Hello","2"};

        Assert.assertNotEquals(actual,expected,"Actual should not be equal to Expected");
    }


    @Test
    public void assertSame(){
        String[] expected = {"Hello"};
        String[] actual = {"Hello"};

        Assert.assertSame(actual,expected,"Actual and Expected should point to same object!");
    }

    @Test
    public void assertSame2(){
        String[] expected = {"Hello"};
        String[] actual = expected;         // we are coping it by the reference. bu yuzden hata vermiycek

        Assert.assertSame(actual,expected,"Actual and Expected should point to same object!");
    }

    @Test
    public void assertNotSame(){
        String[] expected = {"Hello"};
        String[] actual = {"Hello"};

        Assert.assertNotSame(actual,expected,"Actual and Expected should not point to same object!");

    }
    @Test
    public void assertNotSame2(){
        String[] expected = {"Hello"};
        String[] actual = expected;

        Assert.assertNotSame(actual,expected,"Actual and Expected should  point to same object");
    }

    @Test
    public void assertNotNull1(){
        String nullString = null;
        Assert.assertNotNull(nullString);       // will fail cuz it is null
    }

    @Test
    public void assertNotNull12(){
        String nullString = "STH";
        Assert.assertNotNull(nullString);       // will pass cuz it is not null
    }

    @Test
    public void assertTrue(){                   // if a condition true or false
        boolean actual = isDataAvailable();
        Assert.assertTrue(actual);
    }
    public  boolean isDataAvailable(){
        return new Random().nextBoolean();
    }

    @Test
    public void assertFalse(){
        boolean actual = isDataAvailable();
        Assert.assertFalse(actual);
    }

    @Test
    public void assertFail(){
        // bu line varsa, test will fail. hangi durumlarda kullaniriz bunu ==>
        // Assert.fail();

        if (!isDataAvailable()){        // bu sekilde olursa , if condition saglanmasi durumunda test gecer, aksi taktirde fail
            Assert.fail("Condition is false");
        }
    }

    @Test
    public void assertFail2() {
        try{
            throw new Exception();
        }catch (Exception e){
            Assert.fail("Test failed because we caught an exception");
        }
    }
}