package Day2_Assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestForFirefox {

    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\zeynep\\Google Drive\\DRIVER KURULUM DOSYALARI&LIB\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("https://github.com/mozilla/geckodriver/releases");
    }
}

