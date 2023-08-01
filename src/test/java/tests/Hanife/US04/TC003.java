package tests.Hanife.US04;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC003 extends ExtentReport {


    @Test
    public void test01() {
        extentTest=extentReports.createTest("Hanife", "Shipping Adress Ekleme- Negative Test");

        // Ana sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        Page page=new Page();
        extentTest.info("Ana sayfaya gidildi");

        // Sign In butonuna tıkla
        page.sıgnIn.click();
        extentTest.info("Sign In butonuna tıklandı");

        //Username ve password girip giriş yap
        page.username1.click();
        page.username1.sendKeys("Bahri"+ Keys.TAB+"Bahri1977."+Keys.ENTER);
        extentTest.info("Username ve password girilip, giriş yapıldı");

        ReusableMethods.scrollEnd();
        ReusableMethods.bekle(2);

        //"My Account" buttonunu tıkla
        page.account.click();
        extentTest.info("My account butonuna tıklandı");

        //"Addresses" seçeneğini seç
        page.adress.click();
        extentTest.info("Adress seçeneği seçildi");

        ReusableMethods.bekle(2);

        //"Shipping Adresses" bölümünün altındaki "Edit" butonunu tıkla
        page.shippingEditAdress.click();
        extentTest.info("Shipping adress altında Edit butonuna tıklandı ");

        page.shippingFirstName.clear();
        page.shippingLastName1.clear();
        page.shippingState.clear();
        page.shippingStreetAdress.clear();
        page.shippingCity.clear();
        page.shippingPostcode.clear();

        //"Shipping Adresses" kısmına "First Name" Last name boş bırak gir
        page.shippingFirstName.click();
        page.shippingFirstName.sendKeys("Bahri");
        extentTest.info("Shipping Adress kısmına First Name girildi, Last Name boş bırakıldı ");


        // "Shipping Adresses" kısmından "Country"seç
        WebElement countrySelect = page.shippingCountry;
        Select select = new Select(countrySelect);
        select.selectByVisibleText("Russia");
        extentTest.info("Shipping Adresses kısmından Country seçildi");

        //"Shipping Adresses" kısmına "Street address","Town / City","State","Zip Code","Phone"gir
        page.shippingStreetAdress.sendKeys("Armani"+ Keys.TAB+ Keys.TAB+"Newput" +Keys.TAB+"Moskova"+Keys.TAB+"1234"+Keys.TAB+"123456");
        extentTest.info("Shipping Adresses kısmına Street address, Town / City, State, Zip Code, Phone girildi");



        ReusableMethods.bekle(2);

        page.shippingLastName1.clear();

        //Teslimat Adresini kaydetmek için "Save Address" düğmesine tıkla
        ReusableMethods.scroll(page.shippingSaveAdress);
        ReusableMethods.click(page.shippingSaveAdress);
        extentTest.info("Teslimat Adresini kaydetmek için Save Address düğmesine tıklandı");

        //Last Name kısmının girilmesinin zorunlu olduğunu doğrula
        Assert.assertTrue(page.shippingLastNameAllert.isDisplayed());

        extentTest.pass("Last Name kısmının girilmesinin zorunlu olduğunu doğrula");





    }
}















