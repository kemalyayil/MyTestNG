package Day_2_Assertions._01_AssertionTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _02_TestButtons {
    WebDriver driver;               // bu driver i buraya yazmazsak, asagida hata veriyor
    @BeforeMethod                   // bu da her test den once tekrarlanmasi icin koyduk
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zeynep\\Google Drive\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/buttons");
    }


    @AfterMethod                    // bunu da her test sonunda quit yapsin diye koyduk
    public  void tearDown(){
        driver.quit();
    }
    @Test
    public void clickMeButtonTest() {
        WebElement clickMeButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
        clickMeButton.click();

        WebElement dynamicClickMessage = driver.findElement(By.id("dynamicClickMessage"));
        String actualResult = dynamicClickMessage.getText();

        String expectedResult = "You have done a dynamic click";

        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void rightClickMeButtonTest() {
        WebElement rightClickMeButton = driver.findElement(By.xpath("//button[text()='Right Click Me']"));
        Actions action = new Actions(driver);

        action.contextClick(rightClickMeButton).perform();

        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));
        String actualResult = rightClickMessage.getText();

        String expectedResult = "You have done a right click";
        Assert.assertEquals(actualResult, expectedResult);

    }
    @Test
    public void doubleClickMeButtonTest() {
        WebElement doubleClickMeButton = driver.findElement(By.xpath("//button[text()='Double Click Me']"));
        Actions action = new Actions(driver);

        action.doubleClick(doubleClickMeButton).perform();

        WebElement doubleClickMessage = driver.findElement(By.id("doubleClickMessage"));
        String actualResult = doubleClickMessage.getText();

        String expectedResult = "You have done a double click";
        Assert.assertEquals(actualResult, expectedResult);

    }
}
