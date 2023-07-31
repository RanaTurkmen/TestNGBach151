package tests.kubra.US005;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC001  extends ExtentReport {
    @Test
    public void test01() {

        extentTest = extentReports.createTest("TestNGProje", "Test Raporu");

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

        //Sayfaya basarili giris yaptıgını gosteren mesajin  gorundugunu dogrula
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(page.mesajVerify.isDisplayed());
        ReusableMethods.bekle(3);
        extentTest.pass("Sayfaya basarili giris yapıldigi dogrulandi");
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
        extentTest.pass("Account Details sayfasi dogrulandi");
        ReusableMethods.tumSayfaResmi("Sayfa resmi alindi");

        //Firstname alanini sil ve yeni "Firstname" gir
        page.firstnameClear.clear();
        page.newFirstname.sendKeys("techpro");
        ReusableMethods.bekle(2);
        extentTest.info("Firstname silindi ve yeni Firstname girildi");

        //Lastname alanini sil ve yeni "lastname" gir
        page.lastnameClear.clear();
        page.newLastname.sendKeys("education");
        ReusableMethods.bekle(2);
        extentTest.info("Lastname silindi ve yeni Lastname girildi");

        //Display name alanini sil ve yeni "Display name" gir
        page.displayNameClear.clear();
        page.newDisplayName.sendKeys("Techpro");
        ReusableMethods.bekle(2);
        extentTest.info("Display name silindi yeni display name girildi");

        //Email Address alnini sil ve yeni "Email" gir
        page.emailClear.clear();
        extentTest.info("Email silindi");
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[1].toString());
        Driver.getDriver().get(ConfigReader.getProperty("fakeEmailUrl"));
        page.fakeMailCopy.click();
        extentTest.info("Fakemail sayfasina gidildi veni email alindi ");

       Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[0].toString());
       ReusableMethods.bekle(2);
       page.newEmail.sendKeys(Keys.CONTROL , "v");
       ReusableMethods.bekle(2);
       extentTest.info("Yeni emal girildi");

       //Biography alani
        Driver.getDriver().switchTo().frame("user_description_ifr");
        page.metinAlani.clear();
        ReusableMethods.bekle(2);
        page.metinAlani.sendKeys("When you seize the present, you take the best step for your future.");
        ReusableMethods.bekle(2);
        ReusableMethods.tumSayfaResmi("Sayfa resmi alindi");
        Driver.getDriver().switchTo().parentFrame();
        Driver.getDriver().switchTo().defaultContent();
        extentTest.info("Biography alanina gidildi silinip yazi eklendi ");

        //"Current password" alanina gecerli passwordu gir
        page.currentPassword.sendKeys(ConfigReader.getProperty("currentPassword"), Keys.TAB);
        ReusableMethods.bekle(2);
        extentTest.info("Current password alanina onayli password girildi");

        //"New Password" alanina yeni passwordu gir
        page.newPassword.sendKeys(ConfigReader.getProperty("newPassword"));
        ReusableMethods.bekle(2);
        extentTest.info("New password alanina yeni password girildi");

        //"Confirm Password" alaninda yeni passwordu onayla
        page.confirmPassword.sendKeys(ConfigReader.getProperty("confirmPassword"));
        ReusableMethods.bekle(2);
        extentTest.info("Confirm password alaninda yeni password onaylandi");

        //"Save Changes" butonuna tikla
        page.saveChangesButton.click();
        ReusableMethods.bekle(3);
        extentTest.info("Sve changes butonuna tiklandi");

        //"Account details changed successfully" yazisinin gorundugunu dogrulayin
        softAssert.assertTrue(page.accountDetailsVerify.isDisplayed());
        ReusableMethods.bekle(2);
        extentTest.pass("Account details changed successfully yazisinin gorundugu dogrulandi");
        ReusableMethods.tumSayfaResmi("Sayfa resmi alindi");

        //Sayfayi kapat
        Driver.closeDriver();
        extentTest.info("Sayfa kapatildi");
        extentReports.flush();









    }
}
