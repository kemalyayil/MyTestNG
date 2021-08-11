package Day6;

import Utils.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _02_SearchFunctionality extends BaseDriver {

    @Test(groups = "Regression")
    @Parameters({"searchItem"})
    public void searchTest(String searchItem){

        WebElement searchInput = driver.findElement(By.xpath("//input[@name='search']"));
        searchInput.sendKeys(searchItem);

        WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
        searchButton.click();

        List<WebElement> searchItemsResult = driver.findElements(By.xpath("//div[@class='caption']//h4"));

        System.out.println(searchItemsResult);

        for (WebElement item: searchItemsResult) {
            System.out.println(item.getText());
//            Assert.assertTrue(item.getText().contains(searchItem));
            Assert.assertTrue(item.getText().toLowerCase().contains(searchItem.toLowerCase()));
        }

    }

}
