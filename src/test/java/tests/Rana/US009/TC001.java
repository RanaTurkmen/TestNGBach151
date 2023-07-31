package tests.Rana.US009;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC001 extends ExtentReport {
    /*
    "Vendor (Satıcı) olarak, siteye kayıt yapılabilmeli.(Vendor Registration)"

    Register ekranından, Sign Up sekmesini kullanarak "Become a Vendor" linki ile giriş yapılabilmeli
    e-mail adresi girmeli
    Verification Code text kutusuna geldiğinde "Verification code sent to your email: abc@abc.com." mesajını görmeli
    Mail adresine gelen konu Verification Code text kutusuna girmeli
    Password yazmalı. Password: kucuk harf, büyük harf, rakam ve special karakter içermeli
    Password'ü tekrar yazmalı
    Register butonuna tıklayarak vendor olarak kayıtı tamamlamalı
    Kayıtlı bir e-mail adresi ile kayıt olmaya çalıştığında "This Email already exists. Please login to the site and apply as vendor." mesajını almalı
     */
    @Test
    public void test01() {
        extentTest = extentReports.createTest("Extent Report", "Allover test raporu");

        //Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Anasayfaya gidildi.");

        //Register butonuna tikla
        Page page = new Page();
        page.registion.click();
        ReusableMethods.bekle(2);
        extentTest.info("Register butonuna tiklandı");

        //Çıkan ekranda "Become a Vendor" yazısının göründüğünü doğrula.
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(page.BecomeVendor.isDisplayed());
        extentTest.pass("Become a Vendor yazısının göründüğünü doğrulandı.");
        ReusableMethods.webElementResmi(page.become);

        //Çıkan ekranda "Become a Vendor" butonuna tıkla.
        page.BecomeVendor.click();
        extentTest.info("Become a Vendor butonuna tıklandı.");

        //Vendor Registration sayfasını doğrula.
        softAssert.assertEquals(ConfigReader.getProperty("vendorSayfasi"), page.VendorRegistrationYazisi.getText());
        extentTest.pass("Vendor Registration sayfasının göründüğü doğrulandı");
        ReusableMethods.tumSayfaResmi("VendorRegistration");
        extentTest.info("Ekran görüntüsü alındı.");

        //Email alanina email gir.
        Driver.getDriver().switchTo().newWindow(WindowType.WINDOW);
        ReusableMethods.window(1);
        Driver.getDriver().get(ConfigReader.getProperty("fakeEmailUrl"));
        ReusableMethods.bekle(2);
        page.fakeEmailCopy.click();
        ReusableMethods.window(0);
        ReusableMethods.bekle(2);
        page.email.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.keyDown(Keys.CONTROL).sendKeys("v").release().perform();
        ReusableMethods.bekle(2);
        extentTest.info("Email alanina email girildi.");

        //Email alanı dışında boşluğa tıkla.
        page.bosluk.click();
        extentTest.info("Email alanı dışında boşluğa tıklandı.");

        //mesajın "Verification code sent to your email: " içerdiğini doğrula.
        ReusableMethods.visibleWait(page.verification, 10);
        System.out.println(page.verification.getText());
        softAssert.assertTrue(page.verification.getText().contains(ConfigReader.getProperty("sentToYourEmail")));
        extentTest.pass("mesajın Verification code sent to your email: içerdiği doğrulandı.");
        ReusableMethods.webElementResmi(page.verification);
        extentTest.info("Webelement resmi alındı.");
        //Emaile gelen doğrulma kodunu Verification Code text kutusuna gir.
        ReusableMethods.bekle(10);
        ReusableMethods.window(1);
        ReusableMethods.bekle(5);
        page.fakeEmailCode.click();
        ReusableMethods.bekle(2);
        Driver.getDriver().switchTo().frame("iframeMail");
        actions.doubleClick().doubleClick(page.code).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("c").release().perform();
        ReusableMethods.bekle(5);
        ReusableMethods.window(0);

        page.veryficationCodeKutusu.click();
        actions.keyDown(Keys.CONTROL).sendKeys("v").perform();
        extentTest.info("Emaile gelen doğrulma kodunu Verification Code text kutusuna girildi.");

        //Password alanina en az 6 karakterli kucuk harf, büyük harf, rakam ve special karakter içeren password gir.
        //Confirm Password alanina aynı password gir.
        //Register butonuna tikla
        page.veryficationCodeKutusu.sendKeys(Keys.PAGE_DOWN);
        page.veryficationCodeKutusu.sendKeys(Keys.TAB, Keys.TAB,
                ConfigReader.getProperty("gecerliPassword"),
                Keys.TAB,
                ConfigReader.getProperty("gecerliPassword"), Keys.ENTER);

        extentTest.info("Password alanina en az 6 karakterli kucuk harf, büyük harf, rakam ve special karakter içeren password girildi.");
        extentTest.info("Confirm Password alanina aynı password girildi.");
        extentTest.info("Emaile gelen doğrulma kodunu Verification Code text kutusuna girildi.");

        //"Registration Successfully Completed. "Yazısın çıktığını doğrula
        ReusableMethods.bekle(1);
        softAssert.assertEquals(ConfigReader.getProperty("registionSuccess"), page.successlogin.getText());
        extentTest.pass("Registration Successfully Completed. Yazısın çıktığını doğrula");
        ReusableMethods.webElementResmi(page.successlogin);
        extentTest.info("Webelement resmi alındı.");

        //Yeni açılan sayfada "Welcome to Allover Commerce!" yazısını görüdüğünü doğrula
        ReusableMethods.bekle(2);
        softAssert.assertEquals(ConfigReader.getProperty("WelcometoAllover"), page.welcome.getText());
        extentTest.pass("Yeni açılan sayfada Welcome to Allover Commerce! yazısını görüdüğünü doğrula");
        ReusableMethods.webElementResmi(page.welcome);
        extentTest.info("Webelement resmi alındı.");
        softAssert.assertAll();

    }
}
