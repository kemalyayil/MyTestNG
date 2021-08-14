package Day_DataProvider;

import Utils.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class _03_SearchTestWithDataProviderAndXML extends BaseDriver {

    @Test (dataProvider = "searchData")
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
    @DataProvider(name = "searchData")
    public Object[][] searchDate(){
        return new Object[][]{
                {"Mac"},{"Hp"},{"Sony"}
        };
    }


}
