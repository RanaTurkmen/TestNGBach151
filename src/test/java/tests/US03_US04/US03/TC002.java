package tests.US03_US04.US03;



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



        ReusableMethods.bekle(2);


        page.billingStreetAdress.clear();
        page.billingCity.clear();
        page.billingPostcode.clear();
        page.billingState.clear();
        page.billingFirstName.clear();
        page.billingPhone.clear();
        page.billingLastName.clear();

        extentTest.info("Billing Adresses kısmından Street address, Town / City, State, Zip Code, Phone boş bırakıldı");


        //Kayıtlı e-posta adresini otomatik olarak görüntüle
        String mail = ReusableMethods.getValueByJS("billing_email","value");
        Assert.assertEquals(ConfigReader.getProperty("email"),mail);
        extentTest.pass("Kayıtlı e-posta adresini otomatik olarak görüntülendiği doğrulandı");

        //Fatura Adresini kaydetmek için "Save Address" düğmesine tıkla
        ReusableMethods.scroll(page.billingSaveAdress);
        ReusableMethods.click(page.billingSaveAdress);
        extentTest.info("Fatura Adresini kaydetmek için Save Address düğmesine tıklandı");

        ReusableMethods.bekle(2);



        //Fatura Adresinin başarıyla kaydedilmediğini doğrula
        Assert.assertTrue(page.billingFirstNameAlert.isDisplayed());
        Assert.assertTrue(page.billingLastNameAlert.isDisplayed());
        Assert.assertTrue(page.billingStreetAdresAlert.isDisplayed());
        extentTest.pass("Fatura Adresinin zorunlu alanlara giriş yapılmadan kaydedilmediği doğrulandı");



    }
}





