package tests.US05_US06.US005;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC002  extends ExtentReport{

    @Test
    public void test01() {
        extentTest = extentReports.createTest("TestNGProje", "AlloverCommerce Test Raporu");

        //Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("alloverURL"));
        extentTest.info("Anasayfaya gidildi");

        //Sign in butonuna tikla
        Page page = new Page();
        page.signInButton.click();
        ReusableMethods.bekle(2);
        extentTest.info("Sign in butonuna tiklandi");

        //Username alanına "Username" gir
        page.username.sendKeys(ConfigReader.getProperty("username"), Keys.TAB);
        ReusableMethods.bekle(2);
        extentTest.info("Username girildi");

        //Password alanina "password" gir
        page.password.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.bekle(2);
        extentTest.info("Password girildi");

        //"Remember me" kutusunu tikla
        page.rememberButton.click();
        ReusableMethods.bekle(2);
        extentTest.info("Remember me kutusuna tiklandi");

        //Sign in butonuna tikla
        page.signIn.click();
        ReusableMethods.bekle(3);
        extentTest.info("Sign in butonuna tiklandi");

        //Sayfaya basarili giris yaptıgını gosteren mesajın gorundugunu dogrula
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(page.mesajVerify.isDisplayed());
        ReusableMethods.bekle(3);
        extentTest.pass("Sayfaya basarili giriş yapidigi dogrulandi");
        ReusableMethods.tumSayfaResmi("Sayfa resmi alindi");

        //Sign out butonuna tikla
        page.signOut.click();
        ReusableMethods.bekle(2);
        extentTest.info("Sign out butonuna tiklandi");

        //My Account sayfasinin gorundugunu dogrula
        softAssert.assertTrue(page.myAccount.isDisplayed());
        ReusableMethods.bekle(2);
        extentTest.pass("My Account sayfasinin gorundugu dogrulandi");
        ReusableMethods.tumSayfaResmi("Sayfa resmi alindi");

        //Account Details butonuna tikla
        page.accountDetails.click();
        ReusableMethods.bekle(2);
        extentTest.info("Account Details butonuna tiklandi");

        //Account Details sayfasinin gorundugunu dogrula
        softAssert.assertTrue(page.accountDetailsYazisi.isDisplayed());
        ReusableMethods.bekle(2);
        extentTest.pass("Account Details sayfasinin gorundugu dogrulandi");
        ReusableMethods.tumSayfaResmi("Sayfa resmi alindi");

        //Firstname alanini sil ve Save Changes butonuna tikla
        page.firstnameClear.clear();
        ReusableMethods.bekle(3);
        extentTest.info("Firstname alani silindi");

        page.saveChangesButton.submit();
        ReusableMethods.bekle(3);
        extentTest.info("Save Changes butonuna tiklandi");

        //"First name is a required field " yazisini dogrula
        softAssert.assertEquals(ConfigReader.getProperty("errorFirstnameYazisi"), page.errorYazisi.getText());
        ReusableMethods.bekle(2);
        extentTest.pass("First name is a required field  yazisinin gorundugu dogrulandi");
        ReusableMethods.tumSayfaResmi("Sayfa resmi alindi");

        //Lastname alanini sil ve Save Changes butonuna tikla
        page.lastnameClear.clear();
        ReusableMethods.bekle(2);
        extentTest.info("Lastname alanini silindi");

        page.saveChangesButton.submit();
        ReusableMethods.bekle(2);
        extentTest.info("Save Changes butonuna tiklandi");

        //"Last name is a required field" yazisini dogrula
         softAssert.assertEquals(ConfigReader.getProperty("errorLastnameYazisi"), page.errorYazisi.getText());
         ReusableMethods.bekle(2);
         extentTest.pass("Last name is a required field yazisinin gorundugu dogrulandi");
        ReusableMethods.tumSayfaResmi("Sayfa resmi alindi");

        //Display name alanini sil ve Save Changes butonuna tikla
        page.displayNameClear.clear();
        ReusableMethods.bekle(2);
        extentTest.info("Display name alanini silindi");

        page.saveChangesButton.submit();
        extentTest.info("Save Changes butonuna tiklandi");

        //"Display name is a required field" yazisini dogrula
        softAssert.assertEquals(ConfigReader.getProperty("errorDisplayYazisi"), page.errorYazisi.getText());
        ReusableMethods.bekle(2);
        extentTest.pass("Display name is a required field yazisinin gorundugu dogrulandi");
        ReusableMethods.tumSayfaResmi("Sayfa resmi alindi");

        //Email Address alanini sil ve Save Changes butonuna tikla
        page.emailClear.clear();
        ReusableMethods.bekle(2);
        extentTest.info("Email Address alanini silindi");

        page.saveChangesButton.submit();
        ReusableMethods.bekle(2);
        extentTest.info("Save Changes butonuna tiklandi");

        //"Email Address is a required field" yazisini dogrula
        softAssert.assertEquals(ConfigReader.getProperty("errorEmailYazisi"), page.errorYazisi.getText());
        ReusableMethods.bekle(2);
        extentTest.pass("Email Address is a required field yazisinin gorundugu dogrulandi");


        //Current password yanlis gir ve Save Changes butonuna tikla
        page.currentPassword.sendKeys(ConfigReader.getProperty("yanlisPassword"), Keys.TAB);
        ReusableMethods.bekle(2);
        page.newPassword.sendKeys(ConfigReader.getProperty("password"), Keys.TAB);
        ReusableMethods.bekle(2);
        page.confirmPassword.sendKeys(ConfigReader.getProperty("password"), Keys.TAB);
        ReusableMethods.bekle(2);

        page.saveChangesButton.submit();
        ReusableMethods.bekle(2);
        extentTest.info("Password eksik girildi ve Save Changes butonuna tiklandi");

        //"Your current password is incorrect" yazisini dogrula
        softAssert.assertEquals(ConfigReader.getProperty("errorPasswordYazisi"), page.errorPassword.getText());
        ReusableMethods.bekle(2);
        extentTest.pass("Your current password is incorrect yazisinin gorundugu dogrulandi");
        ReusableMethods.tumSayfaResmi("Sayfa resmi alindi");

        //Sayfayi Kapat
        Driver.closeDriver();
        extentTest.info("Sayfa kapatildi");
        extentReports.flush();


    }
}
