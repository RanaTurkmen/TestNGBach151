package tests.Hanife.US03;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC004 {


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





        WebElement countrySelect = page.billingCountrySelect;
        Select select = new Select(countrySelect);
        select.selectByVisibleText("Russia");

        page.billingStreetAdress.click();

        page.billingStreetAdress.clear();

        page.billingStreetAdress.sendKeys("Armani"+ Keys.TAB+ Keys.TAB+"Newput" +Keys.TAB+"Moskova"+Keys.TAB+"1234"+Keys.TAB+"9876543");



        ReusableMethods.bekle(2);



        page.billingEmail.clear();

        page.billingEmail.sendKeys("Bahri@gmail");



//    Click the "SAVE ADDRESS" button

        ReusableMethods.scroll(page.billingSaveAdress);


        ReusableMethods.click(page.billingSaveAdress);

        ReusableMethods.bekle(2);



       // ReusableMethods.visibleWait(page.billingEmailBoxAlert, 3);
        Assert.assertTrue(page.billingEmailBoxAlert.isDisplayed());









    }
}




