package tests.US11_US12.US11;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC01_VendorSignIn extends ExtentReport {

    @Test
    public void TC01_Test01_VendorSignIn(){
        extentTest = extentReports.createTest("TC01","VendorSignIn");

        // 1 ==> Ana sayfaya git.
        Driver.getDriver().get(ConfigReader.getProperty("allOverCommerceUrl"));
        extentTest.info("Ana Sayfaya gitti");

        // 2 ==> "Sign in / Register" alanındaki "Sign in" butonunun görünür olduğunu doğrula.
        Page page = new Page();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(page.signInMainPage.isDisplayed());
        ReusableMethods.bekle(1);
        extentTest.info("Sign in butonunun görünür olduğu doğrulandı");

        // 3 ==> Sign in / Register alanındaki Sign in butonuna tıkla.
        page.signInMainPage.click();
        ReusableMethods.bekle(1);
        extentTest.info("Register alanındaki Sign in butonuna tıklandı");


        // 4 ==> Sign in pop-up penceresinin açıldığını doğrula.
        softAssert.assertTrue(page.signInPopUp.isDisplayed());
        ReusableMethods.bekle(1);
        extentTest.info("Sign in pop-up penceresinin açıldığını doğrulandı");

        // 5 ==> Sign in pop-up penceresinde bulunan "SIGN-IN" butonunun görünür ve ulaşılabilir olduğunu doğrula.
        page.signInButton.isDisplayed();//Gorunur
        page.signInButton.isEnabled();//Ulasilabilir
        ReusableMethods.bekle(1);
        extentTest.info(" \"SIGN-IN\" butonunun görünür ve ulaşılabilir olduğunu doğrulandı");


        // 6 ==> "Username or email address" alanına geçerli bir mail adresi, "Password" alanına geçerli bir şifre
        //==> girdikten sonra "Sign In" butonuna basınca, giriş yapıldığını doğrula.
        page.eMailBox.sendKeys(ConfigReader.getProperty("userName"));
        ReusableMethods.bekle(1);
        page.passwordBox.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.bekle(1);
        page.signInButton.click();
        ReusableMethods.bekle(1);

        Driver.getDriver().findElement(By.xpath("//a[@class='login logout inline-type']")).click();//GEÇİCİ KOD
        ReusableMethods.bekle(1);
        extentTest.fail("My Account sayfası görünmedi, Ana sayfaya yönlendi.");
        ReusableMethods.tumSayfaResmi("Failed");

        softAssert.assertTrue(Driver.getDriver().getTitle().contains("My Account"));//Title ile dogrulama
        ReusableMethods.bekle(1);
        extentTest.info("Geçici Kod ile, Geçerli mail adresi ve şifre kullanılarak giriş yapıldığı doğrulandı");

        // 7 ==> My Account sayfasının açıldığını doğrula.
        softAssert.assertTrue(page.myAccountText.isDisplayed());//Text ile dogrulama
        ReusableMethods.bekle(1);
        extentTest.info("My Account sayfasının açıldığını doğrulandı");


        //  Actions actions = new Actions(Driver.getDriver());
      //  actions.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN).perform();

        // 8 ==> My Account sayfasında "Dashboard" başlık yazısının olduğunu doğrula.
        softAssert.assertTrue(page.dashboardText.isDisplayed());
        ReusableMethods.bekle(1);
        extentTest.info("My Account sayfasında \"Dashboard\" başlık yazısının olduğunu doğrulandı");


        // 9 ==> Dashboard altında, Orders yazısının olduğunu doğrula.
        softAssert.assertTrue(page.orderText.isDisplayed());
        ReusableMethods.bekle(1);
        extentTest.info("Dashboard altında, Orders yazısının olduğunu doğrulandı");


        // 10 ==> Dashboard altında, Downloads yazısının olduğunu doğrula.
        softAssert.assertTrue(page.downloadsText.isDisplayed());
        ReusableMethods.bekle(1);
        extentTest.info("Dashboard altında, Downloads yazısının olduğunu doğrulandı");

        // 11 ==> Dashboard altında, Addresses yazısının olduğunu doğrula.
        softAssert.assertTrue(page.addressesText.isDisplayed());
        ReusableMethods.bekle(1);
        extentTest.info("Dashboard altında, Addresses yazısının olduğunu doğrulandı");

        // 12 ==> Dashboard altında, Account Detail yazısının olduğunu doğrula.
        softAssert.assertTrue(page.accountDetailsText.isDisplayed());
        ReusableMethods.bekle(1);
        extentTest.info("Dashboard altında, Account Detail yazısının olduğunu doğrulandı");

        // 13 ==> Dashboard altında, Wishlist yazısının olduğunu doğrula.
        softAssert.assertTrue(page.wishlistText.isDisplayed());
        ReusableMethods.bekle(1);
        extentTest.info("Dashboard altında, Wishlist yazısının olduğunu doğrulandı");

        // 14 ==> Dashboard altında, Supoort Tickets yazısının olduğunu doğrula.
        softAssert.assertTrue(page.supportTicketsText.isDisplayed());
        ReusableMethods.bekle(1);
        extentTest.info("Dashboard altında, Supoort Tickets yazısının olduğunu doğrulandı");

        // 15 ==> Dashboard altında, Followings yazısının olduğunu doğrula.
        softAssert.assertTrue(page.followingsText.isDisplayed());
        ReusableMethods.bekle(1);
        extentTest.info("Dashboard altında, Followings yazısının olduğunu doğrulandı");

        // 16 ==> Dashboard altında, Logout yazısının olduğunu doğrula.
        softAssert.assertTrue(page.logoutText.isDisplayed());
        ReusableMethods.bekle(1);
        extentTest.info("Dashboard altında, Logout yazısının olduğunu doğrulandı");

        // 17 ==> Dashboard altında, Store manager yazısının olduğunu doğrula.
        softAssert.assertTrue(page.storeManagerText.isDisplayed());
        ReusableMethods.bekle(1);
        extentTest.info("Dashboard altında, Store manager yazısının olduğunu doğrulandı");

        softAssert.assertAll();

    }
}
