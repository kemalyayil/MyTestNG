package Day3_AutomationFrameWork;

import Utils.BaseDriver;
import Utils.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class _01_ValidateMenu extends BaseDriver {

    @Test
    public void validateMenuTest(){

        List<String>expectedMenuItems = new ArrayList<>();      // burada sitede menu kisminda gorulen elementleri yazdik
        expectedMenuItems.add("Desktops");
        expectedMenuItems.add("Laptops & Notebooks");
        expectedMenuItems.add("Components");
        expectedMenuItems.add("Tablets");
        expectedMenuItems.add("Software");
        expectedMenuItems.add("Phones & PDAs");
        expectedMenuItems.add("Cameras");
        expectedMenuItems.add("MP3 Players");



        List<WebElement> actualResult = driver.findElements(By.cssSelector("ul[class='nav navbar-nav']>li"));
        // kontrol etmek icin ==> line 27 webelement, line 15 teki string array. nasil compare edilir, ikisi farkli data type...
        // line 32 yi olusturup for each loop kullanarak

//       List<String> actualMenuItems = new ArrayList<>();
//        for (WebElement element: actualResult){
//            actualMenuItems.add(element.getText());
//        }
//
//
//        // bu sekilde her bir elementi(actual & expected)karsilastirmis olacagiz
//        for (int i = 0; i < expectedMenuItems.size(); i++) {
//            Assert.assertEquals(actualMenuItems.get(i),expectedMenuItems.get(i));
//
//        }

        // yukardakiler icin method olusturduk. ReusableMethods' da . cunku sonradan tekrar tekrar kullanmak icin
        List<String> actualMenuItems = ReusableMethods.webElementListToStringList(actualResult);
        ReusableMethods.validateTwoStringList(actualMenuItems,expectedMenuItems);
    }

}
