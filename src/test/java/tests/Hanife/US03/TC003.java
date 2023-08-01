package tests.Hanife.US03;



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
    public void test001() {
        extentTest=extentReports.createTest("Hanife", "Billing Adress Ekleme-Negative Test");

        // Ana sayfaya git

        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        Page page=new Page();
        extentTest.info("Anasayfaya gidildi");


        //Sign In butonuna tıkla
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
        //"Billing Adresses" bölümünün altındaki "Edit" butonunu tıkla
        page.editAdress.click();
        extentTest.info("Billing adress altında Edit butonuna tıklandı ");


        //"Billing Adresses" kısmına "First Name"in otomatik geldiğini doğrula
        //"Billing Adresses" kısmına "Last Name"in otomatik geldiğini doğrula
        String isim = ReusableMethods.getValueByJS("billing_first_name","value");
        Assert.assertEquals(ConfigReader.getProperty("firstName"),isim);
        extentTest.pass("Billing Adresses kısmına First Name in otomatik geldiği doğrulandı");

        String soyisim = ReusableMethods.getValueByJS("billing_last_name","value");
        Assert.assertEquals(ConfigReader.getProperty("lastName"),soyisim);
        extentTest.pass("Billing Adresses kısmına Last Name in otomatik geldiği doğrulandı");

        // "Billing Adresses" kısmından "Country"seç
        WebElement countrySelect = page.billingCountrySelect;
        Select select = new Select(countrySelect);
        select.selectByVisibleText("Russia");
        extentTest.info("Billing Adresses kısmından Country seçildi");

        //"Billing Adresses" kısmına "Street address"gir
        //"Billing Adresses" kısmına "Town / City"gir
        //"Billing Adresses" kısmına "State"gir
        //"Billing Adresses" kısmına "Zip Code"gir
        //"Billing Adresses" kısmına Phone numarasına rakam dışı değer gir
        page.billingStreetAdress.click();

        page.billingStreetAdress.clear();

        page.billingStreetAdress.sendKeys("Armani"+ Keys.TAB+ Keys.TAB+"Newput" +Keys.TAB+"Moskova"+Keys.TAB+"1234"+Keys.TAB+"awsx");
        extentTest.info("Billing Adresses kısmına Street address, Town / City, State, Zip Code girildi. Phone numarası rakam dışı değer girildi");




        ReusableMethods.bekle(2);

        //Kayıtlı e-posta adresini otomatik olarak görüntüle
        String mail = ReusableMethods.getValueByJS("billing_email","value");
        Assert.assertEquals(ConfigReader.getProperty("email"),mail);
        extentTest.pass("Kayıtlı e-posta adresini otomatik olarak görüntülendiği doğrulandı");

        //Fatura Adresini kaydetmek için "Save Address" düğmesine tıkla
        ReusableMethods.scroll(page.billingSaveAdress);
        ReusableMethods.click(page.billingSaveAdress);
        extentTest.info("Fatura Adresini kaydetmek için Save Address düğmesine tıklandı");

        //Phone numarasına rakam dışı değer girilemeyeceğini doğrula
        ReusableMethods.visibleWait(page.billingPhoneAlert, 3);

        Assert.assertTrue(page.billingPhoneAlert.isDisplayed());

        extentTest.pass("Phone numarasına rakam dışı değer girilemeyeceğini doğrulandı");


    }
}



