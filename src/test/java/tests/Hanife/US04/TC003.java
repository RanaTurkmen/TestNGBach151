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

public class TC003 {


    @Test
    public void test01() {
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



    String isim = ReusableMethods.getValueByJS("shipping_first_name","value");
        Assert.assertEquals(ConfigReader.getProperty("firstName"),isim);



    String soyisim = ReusableMethods.getValueByJS("shipping_last_name","value");
        Assert.assertEquals(ConfigReader.getProperty("lastName"),soyisim);


    WebElement countrySelect = page.shippingCountry;
    Select select = new Select(countrySelect);
        select.selectByVisibleText("Russia");



        page.shippingStreetAdress.sendKeys("Armani"+ Keys.TAB+ Keys.TAB+"Newput" +Keys.TAB+"Moskova"+Keys.TAB+"1234"+Keys.TAB+"123456");




        ReusableMethods.bekle(2);

        page.shippingLastName1.clear();




        ReusableMethods.scroll(page.shippingSaveAdress);


        ReusableMethods.click(page.shippingSaveAdress);

    // ReusableMethods.bekle(2);



        Assert.assertTrue(page.shippingLastNameAllert.isDisplayed());








}
}
























