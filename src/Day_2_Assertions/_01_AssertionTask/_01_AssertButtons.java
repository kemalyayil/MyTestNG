package Day_2_Assertions._01_AssertionTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_AssertButtons {

    @Test
    public void clickMeButtonTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zeynep\\Google Drive\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/buttons");

        WebElement clickMeButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
        clickMeButton.click();

        WebElement dynamicClickMessage = driver.findElement(By.id("dynamicClickMessage"));
        String actualResult = dynamicClickMessage.getText();

        String expectedResult = "You have done a dynamic click";

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }

    @Test
    public void rightClickMeButtonTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zeynep\\Google Drive\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/buttons");

        WebElement rightClickMeButton = driver.findElement(By.xpath("//button[text()='Right Click Me']"));
        Actions action = new Actions(driver);

        action.contextClick(rightClickMeButton).perform();

        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));
        String actualResult = rightClickMessage.getText();

        String expectedResult = "You have done a right click";
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }
    @Test
    public void doubleClickMeButtonTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zeynep\\Google Drive\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/buttons");

        WebElement doubleClickMeButton = driver.findElement(By.xpath("//button[text()='Double Click Me']"));
        Actions action = new Actions(driver);

        action.doubleClick(doubleClickMeButton).perform();

        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));
        String actualResult = doubleClickMessage.getText();

        String expectedResult = "You have done a double click";
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }
}
