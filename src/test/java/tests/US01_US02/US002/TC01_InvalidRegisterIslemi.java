package tests.US01_US02.US002;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC01_InvalidRegisterIslemi extends ExtentReport {

    @Test
    public void test01() {
        extentTest = extentReports.createTest("Fatih" , "Allovercommerce Test Edebilmeli");

        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        Page page = new Page();
        SoftAssert softAssert = new SoftAssert();
        Actions actions = new Actions(Driver.getDriver());
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //Anasayfaya gittigini dogrula
        softAssert.assertTrue(page.anaSayfa.isDisplayed());
        ReusableMethods.bekle(2);
        extentTest.pass("Ana Sayfaya gidildi ve dogrulandi");

        //Register butonuna tıkla
        page.registerButton.click();
        ReusableMethods.bekle(2);
        extentTest.info("Register butonuna tiklandi");

        //Username alanına tıkla ve kayıtlı username gir
        page.username.sendKeys(ConfigReader.getProperty("kayitliusername"));
        ReusableMethods.bekle(2);
        extentTest.info("Kayitli bir username girildi");

        //Email alanına tıkla  ve kayıtlı email gir
        page.emailClick.sendKeys(ConfigReader.getProperty("kayitliMail"));
        ReusableMethods.bekle(2);
        extentTest.info("Kayitli bir email girildi");

        //Password alanına tıkla geçerli password gir
        page.passwordClick.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.bekle(2);
        extentTest.info("Password kriterlerine uygun bir password girildi");

        //"I agree to the privacy policy" seçenegine tıkla
        page.IAgreeButton.click();
        ReusableMethods.bekle(2);
        extentTest.info("I Agree butonuna tiklandi");

        //SIGN UP butonuna tıkla
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        js.executeScript("arguments[0].click();", page.signUp);
        ReusableMethods.bekle(3);
        extentTest.info("Sign Up butonuna tiklandi");

        //An account is already registered with your email address mesajının göründüğünü doğrula.
        softAssert.assertTrue(page.kayitliHesap.isDisplayed());
        ReusableMethods.tumSayfaResmi("US002-TC01 Email");
        ReusableMethods.bekle(2);
        extentTest.pass("Hata mesaji alindi ve test edildi");

        // Email alanına tıkla  ve kayıtlı olmayan email gir
        page.emailClick.clear();
        ReusableMethods.bekle(2);
        ReusableMethods.fakeMail();
        ReusableMethods.bekle(2);
        extentTest.info("Email alanina tiklandi ve gecerli bir Email girildi");

        //SIGN UP butonuna tıkla
        page.signUp.click();
        ReusableMethods.bekle(2);
        extentTest.info("Sign Up butonuna tiklandi");

        //"An account is already registered with that username. Please choose another." mesajının göründüğünü doğrula.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.tumSayfaResmi("US002-TC01 Username");
        softAssert.assertTrue(page.kayitliHesap.isDisplayed());
        softAssert.assertAll();
        extentTest.pass("Hata mesaji alindi ve test edildi");
        extentReports.flush();
    }
}
