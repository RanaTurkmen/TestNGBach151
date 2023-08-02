package tests.Fatih.US001;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC01_KayitIslemi extends ExtentReport {
    @Test
    public void test01() {
        extentTest = extentReports.createTest("Fatih" , "Allovercommerce Test Edebilmeli");

        Page page = new Page();
        SoftAssert softAssert = new SoftAssert();
        Faker faker= new Faker();

        //Anasayfaya gittigini dogrula
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        softAssert.assertTrue(page.anaSayfa.isDisplayed());
        extentTest.info("Ana Sayfaya gidildi ve dogrulandi");

        //Register butonuna tıkla
        page.registerButton.click();
        extentTest.info("Register butonuna tiklandi");

        //Username alanına tıkla  username gir
        page.username.sendKeys(faker.name().firstName());
        extentTest.info("Username alanina tiklandi ve bir username girildi");

        //Email alanına tıkla  email gir
        ReusableMethods.fakeMail();
        extentTest.info("Email alanina tiklandi ve gecerli bir Email girildi");

        //Password en az 12 karakterli harf ve rakam içeren bir password gir
        page.passwordClick.sendKeys(ConfigReader.getProperty("password"));
        extentTest.info("Password kriterlerine uygun bir password girildi");

        //"I agree to the privacy policy" seçenegine tıkla
        page.IAgreeButton.click();
        extentTest.info("I Agree butonuna tiklandi");

        //SIGN UP butonuna tıkla
        page.signUp.click();
        ReusableMethods.bekle(10);
        extentTest.info("Sign Up butonuna tiklandi");

        //Giris yapildigini dogrula
        ReusableMethods.tumSayfaResmi("US001-TC01 Giris");
        softAssert.assertTrue(page.signOutButton.isDisplayed());
        softAssert.assertAll();
        extentTest.pass("Hesaba basarili bir sekilde giris yapildi ve SignOut'un gorunurlugu test edildi");
        extentReports.flush();
    }
}
