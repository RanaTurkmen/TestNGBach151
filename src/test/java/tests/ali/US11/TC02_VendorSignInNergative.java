package tests.ali.US11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.List;

public class TC02_VendorSignInNergative extends ExtentReport {

    @Test
    public void TC02_Test01_VendorSignInNegative() {
        extentTest = extentReports.createTest("TC01", "VendorSignInNergative");
        // 1 ==> Ana sayfaya git.
        Driver.getDriver().get(ConfigReader.getProperty("allOverCommerceUrl"));
        extentTest.info("Ana sayfaya gidildi");


        // 2 ==> "Sign in / Register" alanındaki "Sign in" butonunun görünür olduğunu doğrula.
        Page page = new Page();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(page.signInMainPage.isDisplayed());
        extentTest.info("\"Sign in\" butonunun görünür olduğunu doğrulandı");


        // 3 ==> Sign in / Register alanındaki Sign in butonuna tıkla.
        page.signInMainPage.click();
        ReusableMethods.bekle(1);
        extentTest.info("Sign in butonuna tıklandı");

        // 4 ==> Sign in pop-up penceresinin açıldığını doğrula.
        softAssert.assertTrue(page.signInPopUp.isDisplayed());
        extentTest.info("Sign in pop-up penceresinin açıldığını doğrulandı");

        // 5 ==> Sign in pop-up penceresinde bulunan "SIGN-IN" butonunun görünür ve ulaşılabilir olduğunu doğrula.
        softAssert.assertTrue(page.signInButton.isDisplayed());//Gorunur
        softAssert.assertTrue(page.signInButton.isEnabled());//Ulasilabilir
        ReusableMethods.bekle(1);
        extentTest.info("\"SIGN-IN\" butonunun görünür ve ulaşılabilir olduğunu doğrulandı");

//        // 6 ==> "Password" alanı boş bırakılarak sadece "Username or email address" alanına geçerli bir mail
//        // adresi girip, sign-in butonuna basınca uyarı verdiğini ve giriş yapılamadığını doğrula.
//        page.eMailBox.sendKeys(ConfigReader.getProperty("userName"));
//        page.signInButton.click();
//        String msgPassword = Driver.getDriver().findElement(By.id("password")).getAttribute("validationMessage");
//        softAssert.assertTrue(msgPassword.contains("Lütfen bu alanı doldurun."));
//        extentTest.fail("\"Wrong username or password.\" uyarısı görüldü,giriş yapılamadığı doğrulandı.");
//
//        // 7 ==> "Username or email address" alanı boş bırakılarak sadece geçerli bir password girip, sign-in
//        // butonuna basınca uyarı verdiğini ve giriş yapılamadığını doğrula.
//        page.eMailBox.clear();
//        page.passwordBox.sendKeys(ConfigReader.getProperty("password"));
//        page.signInButton.click();
//        String msgUser = Driver.getDriver().findElement(By.id("username")).getAttribute("validationMessage");
//        softAssert.assertTrue(msgUser.contains("Lütfen bu alanı doldurun."));
//        extentTest.fail("\"Wrong username or password.\" uyarısı görüldü,giriş yapılamadığı doğrulandı.");
//
//
//        // 8 ==> "Username or email address" alanı ve password alanı boş bırakılıp, sign-in butonuna basınca
//        // uyarı verdiğini ve giriş yapılamadığını doğrula.
//        page.eMailBox.clear();
//        ReusableMethods.bekle(1);
//        page.passwordBox.clear();
//        ReusableMethods.bekle(1);
//        page.signInButton.click();
//        softAssert.assertTrue(msgUser.contains("Lütfen bu alanı doldurun."));
//        extentTest.fail("\"Wrong username or password.\" uyarısı görüldü,giriş yapılamadığı doğrulandı.");
//
//        // 9 ==> "Username or email address" alanına geçerli bir mail adresi, "Password" alanına geçersiz bir bir
//        // şifre girip, signin butonuna basınca uyarı verdiğini ve giriş yapılamadığını doğrula.
//        page.eMailBox.clear();
//        ReusableMethods.bekle(1);
//        page.passwordBox.clear();
//        page.eMailBox.sendKeys(ConfigReader.getProperty("userName"));
//        ReusableMethods.bekle(1);
//        page.passwordBox.sendKeys(ConfigReader.getProperty("invalidPassword1"));
//        ReusableMethods.bekle(1);
//        page.signInButton.click();
//        ReusableMethods.bekle(2);
//        softAssert.assertTrue(page.alertTextWrongUser.isDisplayed());
//        extentTest.fail("\"Wrong username or password.\" uyarısı görüldü, Şifre ve mail'den hangisinin hatalı olduğu belirtilmedi.");
//
//        // 10 ==> "Username or email address" alanına geçersiz bir mail adresi, "Password" alanına geçerli bir bir
//        // şifre girip, signin butonuna basınca uyarı verdiğini ve giriş yapılamadığını doğrula.
//        page.eMailBox.clear();
//        ReusableMethods.bekle(1);
//        page.passwordBox.clear();
//        page.eMailBox.sendKeys(ConfigReader.getProperty("invalidUserName"));
//        ReusableMethods.bekle(1);
//        page.passwordBox.sendKeys(ConfigReader.getProperty("password"));
//        ReusableMethods.bekle(1);
//        page.signInButton.click();
//        ReusableMethods.bekle(2);
//        softAssert.assertTrue(page.alertTextWrongUser.isDisplayed());
//        extentTest.fail("\"Wrong username or password.\" uyarısı görüldü, Şifre ve mail'den hangisinin hatalı olduğu belirtilmedi.");
//        // 11 ==> "Username or email address" alanına geçerli bir mail adresi, "Password" alanına geçerli bir şifre
        // girip, signin butonuna basınca giriş yapıldığını ve My Account sayfasına girdiğini doğrula.
        page.eMailBox.clear();
        ReusableMethods.bekle(1);
        page.passwordBox.clear();
        page.eMailBox.sendKeys(ConfigReader.getProperty("userName"));
        ReusableMethods.bekle(1);
        page.passwordBox.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.bekle(1);
        page.signInButton.click();
        ReusableMethods.bekle(1);
        softAssert.assertTrue(page.signOutButton.isDisplayed());
        extentTest.info("Geçerli şifre ve mail adresi ile giriş yapıldı, My Account görüldü");
        if (!Driver.getDriver().getCurrentUrl().contains("My Account")) {//Eger My Account'u açmamışsa, SignOut'a bas.
            page.signOutButton.click();
            extentTest.fail("Geçerli şifre ve mail adresi ile giriş yapıldı, My Account görülmedi, Ana sayfaya yönlendirdi");
        }

        // 12 ==> My Account sayfasının açıldığını doğrula.
        softAssert.assertTrue(page.myAccountText.isDisplayed());//Text ile dogrulama
        ReusableMethods.bekle(1);
        extentTest.info("My Account sayfasının açıldığını doğrulaandı");

        // 13 ==> My Account sayfasında "Dashboard" başlık yazısının olduğunu doğrula.
        softAssert.assertTrue(page.dashboardText.isDisplayed());
        ReusableMethods.bekle(1);
        extentTest.info(" \"Dashboard\" başlık yazısının olduğunu doğrulandı");

        // 14 ==> Dashboard altında, Store manager, orders, downloads, addresses , account details, wishlist,
        // Support tickets, followings ve log out başlıklarından başka başlık olmadığını doğrula.
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN).perform();
        ReusableMethods.bekle(2);
        ReusableMethods.tumSayfaResmi("TC02TumSayfaResmi");
        int i = 0;
        for (WebElement w : page.dashboardMenuList) {
            System.out.println(i + 1 + ". başlık :" + w.getText());
            i++;
        }
        // 1. başlık :Dashboard
        // 2. başlık :Store Manager
        // 3. başlık :Orders
        // 4. başlık :Downloads
        // 5. başlık :Addresses
        // 6. başlık :Account details
        // 7. başlık :Wishlist
        // 8. başlık :Support Tickets
        // 9. başlık :Followings
        // 10. başlık :Logout

        softAssert.assertTrue(page.dashboardMenuList.get(0).getText().contains("Dashboard"));
        extentTest.info("Dashboard Başlığının var olduğu görüldü");
        softAssert.assertTrue(page.dashboardMenuList.get(1).getText().contains("Store Manager"));
        extentTest.info("Store Manager Başlığının var olduğu görüldü");
        softAssert.assertTrue(page.dashboardMenuList.get(2).getText().contains("Orders"));
        extentTest.info("Orders Başlığının var olduğu görüldü");
        softAssert.assertTrue(page.dashboardMenuList.get(3).getText().contains("Downloads"));
        extentTest.info("Downloads Başlığının var olduğu görüldü");
        softAssert.assertTrue(page.dashboardMenuList.get(4).getText().contains("Addresses"));
        extentTest.info("Addresses Başlığının var olduğu görüldü");
        softAssert.assertTrue(page.dashboardMenuList.get(5).getText().contains("Account details"));
        extentTest.info("Account details Başlığının var olduğu görüldü");
        softAssert.assertTrue(page.dashboardMenuList.get(6).getText().contains("Wishlist"));
        extentTest.info("Wishlist Başlığının var olduğu görüldü");
        softAssert.assertTrue(page.dashboardMenuList.get(7).getText().contains("Support Tickets"));
        extentTest.info("Support Tickets Başlığının var olduğu görüldü");
        softAssert.assertTrue(page.dashboardMenuList.get(8).getText().contains("Followings"));
        extentTest.info("Followings Başlığının var olduğu görüldü");
        softAssert.assertTrue(page.dashboardMenuList.get(9).getText().contains("Logout"));
        extentTest.info("Logout Başlığının var olduğu görüldü");

        softAssert.assertAll();
    }
}

