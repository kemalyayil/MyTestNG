package Day4_;

import Utils.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_Subscribe extends BaseDriver {

    @Test
    public void subscribeFunctionTest() throws InterruptedException {
        WebElement subscribeNewsletter = driver.findElement(By.linkText("Newsletter"));
        subscribeNewsletter.click();

        String textOfChecked = driver.findElement(By.xpath("//input[@checked='checked']/parent::label")).getText();

        //asagida yapacagimiz sey, radio ozelligi olan elementi, yes ve no opsiyonlari arasinda;
        // yes ise no yu, no ise yes i secmek. boylelikle ikisini beraber ayni anda check etmis olucaz
        if (textOfChecked.equals("Yes")){
            Thread.sleep(2000);
            WebElement noSubscribeButton = driver.findElement(By.xpath("//input[@value='0']"));
            noSubscribeButton.click();
        }else if (textOfChecked.equals("No")){
            Thread.sleep(2000);
            WebElement yesSubscribeButton = driver.findElement(By.xpath("//input[@value='1']"));
            yesSubscribeButton.click();
        }else {
            throw new IllegalStateException();
        }

        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals(successMessage.getText(),"Success: Your newsletter subscription has been successfully updated!");

    }




}
