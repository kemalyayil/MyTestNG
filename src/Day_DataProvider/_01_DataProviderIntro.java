package Day_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _01_DataProviderIntro {
    /*
    DataProvider is working as parameters
        It will help us to send data to our test methods
        to test the same test with multiple data multiple times
     */

    @Test(dataProvider = "TestData")            // burdaki TestData yi asagidaki ile bulup calistiriyor, line 17
    public void test(String data){
        System.out.println(data);
    }

    @DataProvider(name="TestData")              // dataprividers should be Object [] [] (multiArray)
    public Object[][] testData(){

        return  new Object[][]{
                {"Test1"},{"Test2"},{"Test3"},{"Test4"},
        };
    }

    @Test(dataProvider = "NameProvider")
    public void printFullName(String firstName, String lastName){
        System.out.println(firstName + " " + lastName);
    }

    @DataProvider(name="NameProvider")
    public Object[][] fullNameProvider(){
        return  new Object[][]{
                {"Mark","Gerrard"},{"Andre","Pirlo"},{"Frank","Lampard"}
        };
    }



}
