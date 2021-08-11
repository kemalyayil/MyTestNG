package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;


// This method will convert WebElement list into String List and return the String List.
    public class ReusableMethods extends BaseDriver_Sikintili {
    public static List<String> webElementListToStringList(List<WebElement> webElementList) {
        List<String> convertedList = new ArrayList<>();

        for (WebElement element : webElementList) {
            convertedList.add(element.getText());
        }
        return convertedList;
    }

    // This method will compare two string List and will fail if there is assertion error.
    public static void validateTwoStringList(List<String> actualItems, List<String> expectedItems) {
        for (int i = 0; i < expectedItems.size(); i++) {
            Assert.assertEquals(actualItems.get(i), expectedItems.get(i));
        }

    }

//    public void verifySuccessMessage(WebDriver driver) { hocanin kodu

//        WebElement successMessage = driver.findElement  (By.xpath("//div[@class='alert alert-success alert-dismissible']"));
//
//        Assert.assertTrue(successMessage.getText().toLowerCase().contains("success"));

    public  void verifySuccessMessage(WebDriver driver){
        // success mesajlarinin icerikleri farkli oldugu icin sadece 'success' i lowercase yaparak aratip, pass
        // veya fail olup olmadigiina bakiyoruz
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertTrue(successMessage.getText().toLowerCase().contains("success"));
    }

    }

