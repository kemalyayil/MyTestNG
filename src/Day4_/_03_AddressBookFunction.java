package Day4_;

import Utils.BaseDriver;
import Utils.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class _03_AddressBookFunction extends BaseDriver {

    ReusableMethods reusableMethods = new ReusableMethods();

    @Test
    public void addNewAddress() throws InterruptedException {

        WebElement myAccountIcon = driver.findElement(By.xpath("//a[@title='My Account']"));
        myAccountIcon.click();

        WebElement myAccountButton = driver.findElement(By.xpath("(//a[text()='My Account'])[1] "));
        myAccountButton.click();

        WebElement addressBookButton = driver.findElement(By.xpath("//li//a[text()='Address Book']"));
        addressBookButton.click();

        WebElement newAddressButton = driver.findElement(By.linkText("New Address"));
        newAddressButton.click();

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("Arya");

        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Stark");

        WebElement inputCompany = driver.findElement(By.id("input-company"));
        inputCompany.sendKeys("TechnoStudy");

        WebElement inputAddress1 = driver.findElement(By.id("input-address-1"));
        inputAddress1.sendKeys("100 Winterfell Road");

        WebElement inputAddress2 = driver.findElement(By.id("input-address-2"));
        inputAddress2.sendKeys("Apt A");

        WebElement inputCity = driver.findElement(By.id("input-city"));
        inputCity.sendKeys("North");

        WebElement inputPostCode = driver.findElement(By.id("input-postcode"));
        inputPostCode.sendKeys("11111");


        WebElement countryDropdown = driver.findElement(By.id("input-country"));
        Select select = new Select(countryDropdown);
        select.selectByVisibleText("United States");


        WebElement stateDropdown = driver.findElement(By.id("input-zone"));
        Select select1 = new Select(stateDropdown);
        select1.selectByVisibleText("New York");

//        for (int i = 0; i < 3; i++){
//            try {
//                Select select1 = new Select(stateDropdown);
//                select1.selectByVisibleText("New York");
//                break;
//            } catch (Exception e){
//                System.out.println(e.getMessage());
//            }
//        }

        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        reusableMethods.verifySuccessMessage(driver);

    }

    @Test(dependsOnMethods = "addNewAddress")
    public  void editAddress(){
        WebElement myAccountIcon = driver.findElement(By.xpath("//a[@title='My Account']"));
        myAccountIcon.click();

        WebElement myAccountButton = driver.findElement(By.xpath("(//a[text()='My Account'])[1] "));
        myAccountButton.click();

        WebElement addressBookButton = driver.findElement(By.xpath("//li//a[text()='Address Book']"));
        addressBookButton.click();

        List<WebElement> editOptions = driver.findElements(By.xpath("//a[text()='Edit']"));
        editOptions.get(editOptions.size()-1).click();      // last element

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.clear();
        firstName.sendKeys("Adem");

        WebElement inputAddress1 = driver.findElement(By.id("input-address-1"));
        inputAddress1.clear();
        inputAddress1.sendKeys("200 Winterfell Road");


        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        reusableMethods.verifySuccessMessage(driver);
    }
    @Test(dependsOnMethods = "editAddress")
    public void deleteAddress(){

        WebElement myAccountIcon = driver.findElement(By.xpath("//a[@title='My Account']"));
        myAccountIcon.click();

        WebElement myAccountButton = driver.findElement(By.xpath("(//a[text()='My Account'])[1] "));
        myAccountButton.click();

        WebElement addressBookButton = driver.findElement(By.xpath("//li//a[text()='Address Book']"));
        addressBookButton.click();

        List<WebElement> deleteOptions = driver.findElements(By.xpath("//a[text()='Delete']"));
        deleteOptions.get(deleteOptions.size()-1).click();

    }



}
