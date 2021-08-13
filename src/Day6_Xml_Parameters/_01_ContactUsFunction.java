package Day6_Xml_Parameters;

import Utils.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _01_ContactUsFunction extends BaseDriver {
    @Test
    @Parameters({"enquiry"}) // with this @Parameter tag, testNg.xml file is able to understand enquiry data need to be send to this@Test
    public void contactUsTest(String enquiry) throws InterruptedException {
        WebElement contactUsButton = driver.findElement(By.linkText("Contact Us"));
        contactUsButton.click();

        WebElement enquiryInput = driver.findElement(By.id("input-enquiry"));
        enquiryInput.sendKeys(enquiry);

        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();



        //Assert.assertTrue(driver.getCurrentUrl().contains("success"));
        // burda bi sikinti var. baseDriver a bak

    }
}
