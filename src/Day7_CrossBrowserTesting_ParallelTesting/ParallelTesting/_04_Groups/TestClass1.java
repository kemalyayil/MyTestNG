package Day7_CrossBrowserTesting_ParallelTesting.ParallelTesting._04_Groups;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestClass1 {
   @Test(groups = "functional")
    public void test1() throws InterruptedException {
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\zeynep\\Google Drive\\Selenium\\chromedriver.exe");
       WebDriver driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       driver.get("http://www.facebook.com/");

       Thread.sleep(3000);
    }
    @Test(groups = "smoke")
    public void test2() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\zeynep\\Google Drive\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://www.google.com/");

        Thread.sleep(3000);
    }
}
