package Day4_;

import Utils.BaseDriver;
import Utils.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class _02_EditAccount extends BaseDriver {
    @Test
    public void editAccountTest(){
        ReusableMethods reusableMethods =new ReusableMethods();

        WebElement myAccountIcon = driver.findElement(By.xpath("//a[@title='My Account']"));
        myAccountIcon.click();

        WebElement myAccountButton = driver.findElement(By.xpath("(//a[text()='My Account'])[1] "));
        myAccountButton.click();

        WebElement editAccountButton = driver.findElement(By.xpath("//li//a[text()='Edit Account']"));
        editAccountButton.click();

        WebElement inputFirstName = driver.findElement(By.id("input-firstname"));
        WebElement inputLastName = driver.findElement(By.id("input-lastname"));

        inputFirstName.clear();
        inputLastName.clear();

        inputFirstName.sendKeys("Mrrrr");
        inputLastName.sendKeys("Kemal");

        WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
        continueButton.click();

//        WebElement successMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
//
//        Assert.assertEquals(successMessage.getText(), "Success: Your account has been successfully updated.");
        //yukardakinin yerine , olusturdugumuz metotdan cagiricaz

        reusableMethods.verifySuccessMessage(driver);
    }

}
