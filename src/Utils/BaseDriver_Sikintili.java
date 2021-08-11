package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseDriver_Sikintili {

    // Webdriver driver - Access Modifier:
    // should be public or protected
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zeynep\\Google Drive\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //bunu halit hoca ile beraber yaptik. zira AddressBookFunction 'da State "New York" secerken hata veriyordu.
        // Hata nin country secerken refresh yapilmasi esnasinda selenium un hizli calisip
        // united states i secememesinden kaynaklandigini anlayip, bu wait i buraya koyduk.
        // sonrasinda kendi kodunda bulunan for loop u da comment out yaptik.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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
        username.sendKeys("kk@kk.com");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("11111");

        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();

        WebElement homePageButton = driver.findElement(By.xpath("//a[text()='Your Store']"));
        homePageButton.click();
    }

    @AfterMethod(alwaysRun = true)
    public void quit(){
        driver.quit();
    }

}



