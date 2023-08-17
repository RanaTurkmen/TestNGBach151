package tests.US03_US04.US04;


import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC002 extends ExtentReport {



    @Test
    public void test001() {

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

        ReusableMethods.bekle(2);

        //Shipping Adress bölümünde girilmesi zorunlu alanları boş bırak
        page.shippingFirstName.clear();
        page.shippingLastName1.clear();
        page.shippingState.clear();
        page.shippingStreetAdress.clear();
        page.shippingCity.clear();
        page.shippingPostcode.clear();
        extentTest.info("Shipping Adress bölümünde girilmesi zorunlu alanlar boş bırakıldı");

        //Teslimat Adresini kaydetmek için "Save Address" düğmesine tıkla
        ReusableMethods.scroll(page.shippingSaveAdress);
        ReusableMethods.click(page.shippingSaveAdress);
        extentTest.info("Teslimat Adresini kaydetmek için Save Address düğmesine tıklandı");

        ReusableMethods.bekle(2);

        //Girilmesi zorunlu alanların girilmesi gerektiğini doğrula
        Assert.assertTrue(page.shippingFirstNameAllert.isDisplayed());
        Assert.assertTrue(page.shippingLastNameAllert.isDisplayed());
        Assert.assertTrue(page.shippingStreetAdressAllert.isDisplayed());

        extentTest.pass("Girilmesi zorunlu alanların girilmesi gerektiği doğrulandı");




    }
}



