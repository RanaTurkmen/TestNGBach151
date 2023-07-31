package tests.Hanife.US03;

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

        page.editAdress.click();



        String isim = ReusableMethods.getValueByJS("billing_first_name","value");
        Assert.assertEquals(ConfigReader.getProperty("firstName"),isim);



        String soyisim = ReusableMethods.getValueByJS("billing_last_name","value");
        Assert.assertEquals(ConfigReader.getProperty("lastName"),soyisim);




        // page.billingFirstName.click();
        // page.billingFirstName.sendKeys("Bahri"+Keys.TAB+"Can");


        ReusableMethods.bekle(2);


        page.billingStreetAdress.clear();
        page.billingCity.clear();
        page.billingPostcode.clear();
        page.billingState.clear();
        page.billingFirstName.clear();
        page.billingPhone.clear();
        page.billingLastName.clear();



        String mail = ReusableMethods.getValueByJS("billing_email","value");
        Assert.assertEquals(ConfigReader.getProperty("email"),mail);




        ReusableMethods.scroll(page.billingSaveAdress);


        ReusableMethods.click(page.billingSaveAdress);

        ReusableMethods.bekle(2);





        Assert.assertTrue(page.billingFirstNameAlert.isDisplayed());
        Assert.assertTrue(page.billingLastNameAlert.isDisplayed());
        Assert.assertTrue(page.billingStreetAdresAlert.isDisplayed());



    }
}



