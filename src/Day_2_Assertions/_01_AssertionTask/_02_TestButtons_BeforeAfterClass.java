package Day_2_Assertions._01_AssertionTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class _02_TestButtons_BeforeAfterClass {
    // bu daha hizli cunku beforeMethod da her biri teker teker aciliyor ve check ediliyor.
    // ama beforeClass ta sadece ilkinde aciliyor
    // ama hepsiuni kontrol ediyor daha hizli sekilde...


    WebDriver driver;

    /**
     * Interview Question
     * how to priorities your @Test in TestNG? ==> I use priority keyword after @Test annotation and I can prioritise

     * ayni zamanda (enabled = false) yazarsak @Test in yanina, o testi atlar, test etmez. ve bu kelimeyi girdikten
     * sonra "Run Button" kaybolur. line 74
     */
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zeynep\\Google Drive\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://demoqa.com/buttons");
    }


    @AfterClass
    public  void tearDown(){
        driver.quit();
    }

    // Testler tamamlandiginda, bizim order a gore sonuc cikmiyor. kronolojik olarak siralaniyor
    // ondan dolayi test in yanina priority yazip , rakam yaziyoruz.
    @Test(priority = 1)
    public void clickMeButtonTest() {
        WebElement clickMeButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
        clickMeButton.click();

        WebElement dynamicClickMessage = driver.findElement(By.id("dynamicClickMessage"));
        String actualResult = dynamicClickMessage.getText();

        String expectedResult = "You have done a dynamic click";

        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test(priority = 2)
    public void rightClickMeButtonTest() {
        WebElement rightClickMeButton = driver.findElement(By.xpath("//button[text()='Right Click Me']"));
        Actions action = new Actions(driver);

        action.contextClick(rightClickMeButton).perform();

        WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));
        String actualResult = rightClickMessage.getText();

        String expectedResult = "You have done a right click";
        Assert.assertEquals(actualResult, expectedResult);

    }

    // enable keyword is to ignore the @Test.
    @Test(enabled = false)
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
