package Day_DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class _02_SearchFunctionWithDataProvider {

    @Test(dataProvider = "SearchData")
    public void searchTest(String searchItem){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zeynep\\Google Drive\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("http://opencart.abstracta.us/index.php?route=common/home");

        WebElement myAccountButton = driver.findElement(By.xpath("//a[@title='My Account']"));
        myAccountButton.click();

        WebElement loginButton = driver.findElement(By.linkText("Login"));
        loginButton.click();

            WebElement advancedButton = driver.findElement(By.xpath("//button[@id='details-button']"));
            advancedButton.click();

            WebElement proceedLink = driver.findElement(By.xpath("//a[@id='proceed-link']"));
            proceedLink.click();

        WebElement username = driver.findElement(By.id("input-email"));
        username.sendKeys("test@techno.com");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("Test12345.");

        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();

        WebElement homePageButton = driver.findElement(By.xpath("//a[text()='Your Store']"));
        homePageButton.click();

        WebElement searchInput = driver.findElement(By.xpath("//input[@name='search']"));
        searchInput.sendKeys(searchItem);

        WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
        searchButton.click();

        List<WebElement> searchItemsResult = driver.findElements(By.xpath("//div[@class='caption']//h4"));

        System.out.println(searchItemsResult);

        for (WebElement item: searchItemsResult) {
            System.out.println(item.getText());
            Assert.assertTrue(item.getText().toLowerCase().contains(searchItem.toLowerCase()));
        }

    }


    @DataProvider(name = "SearchData")
    public Object[][] searchDataProvider(){

        return new Object[][]{
                {"Mac"}, {"HP"}, {"Sony"}
        };
    }

}
