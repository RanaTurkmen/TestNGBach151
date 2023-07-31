package tests.Hanife.US04;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC002 {



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





        // page.billingFirstName.click();
        // page.billingFirstName.sendKeys("Bahri"+Keys.TAB+"Can");


        ReusableMethods.bekle(2);



        page.shippingFirstName.clear();
        page.shippingLastName1.clear();
        page.shippingState.clear();
        page.shippingStreetAdress.clear();
        page.shippingCity.clear();
        page.shippingPostcode.clear();






        ReusableMethods.scroll(page.shippingSaveAdress);


        ReusableMethods.click(page.shippingSaveAdress);

        ReusableMethods.bekle(2);




        Assert.assertTrue(page.shippingFirstNameAllert.isDisplayed());
        Assert.assertTrue(page.shippingLastNameAllert.isDisplayed());
        Assert.assertTrue(page.shippingStreetAdressAllert.isDisplayed());





    }
}






