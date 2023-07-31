package tests.Hanife.US04;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC001 {

    @Test
    public void test001() {


        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        Page page=new Page();



        page.sıgnIn.click();

        page.username1.click();

        page.username1.sendKeys("Bahri"+ Keys.TAB+"Bahri1977."+Keys.ENTER);



        ReusableMethods.scrollEnd();

        ReusableMethods.bekle(2);
        page.account.click();


        page.adress.click();

        ReusableMethods.bekle(2);
        // alloverPage01.addBilling.click();

        page.shippingEditAdress.click();

        page.shippingFirstName.clear();
        page.shippingLastName1.clear();
        page.shippingState.clear();
        page.shippingStreetAdress.clear();
        page.shippingCity.clear();
        page.shippingPostcode.clear();




        page.shippingFirstName.click();
        page.shippingFirstName.sendKeys("Bahri"+Keys.TAB+"Can");




        WebElement countrySelect = page.shippingCountry;
        Select select = new Select(countrySelect);
        select.selectByVisibleText("Russia");

        page.shippingStreetAdress.click();


        page.shippingStreetAdress.sendKeys("Armani"+ Keys.TAB+ Keys.TAB+"Newput" +Keys.TAB+"Moskova"+Keys.TAB+"1234"+Keys.TAB+"9876543");



        ReusableMethods.bekle(2);




        ReusableMethods.scroll(page.shippingSaveAdress);


        ReusableMethods.click(page.shippingSaveAdress);

        ReusableMethods.bekle(2);




        ReusableMethods.visibleWait(page.shippingAllert, 10);
        Assert.assertTrue(page.shippingAllert.getText().contains("Address changed successfully."));




    }
}




