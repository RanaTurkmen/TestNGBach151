package tests.Rana.US009;

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

public class TC002 extends ExtentReport {
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
        extentTest = extentReports.createTest("Vendor Kaydı US009 TC02", "Vendor (Satıcı) olarak, siteye kayıt yapılabilmeli.(Vendor Registration)");

        //Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Anasayfaya gidildi.");
        ReusableMethods.tumSayfaResmi("Anasayfa resmi");
        extentTest.info("Tum sayfa resmi alındı.");
        //Sign In butonuna tıkla.
        Page page = new Page();
        page.signIn.click();
        extentTest.info("Sign In butonuna tıklandı.");
        //SIGN UP butonuna tıkla.
        page.signUp.click();
        //Çıkan ekranda "Become a Vendor" butonuna tıkla.
        Assert.assertTrue(page.BecomeVendor.isDisplayed());
        page.BecomeVendor.click();
        extentTest.info("Çıkan ekranda Become a Vendor butonuna tıklandı.");

        //Vendor Registration sayfasının göründüğünü doğrula.
        Assert.assertEquals(ConfigReader.getProperty("vendorSayfasi"), page.VendorRegistrationYazisi.getText());
        extentTest.pass("Vendor Registration sayfasının göründüğü doğrulandı.");
        //Registration alanındaki REGISTER butonuna tikla
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        page.submit.click();
        ReusableMethods.bekle(2);
        extentTest.info("Registration alanındaki REGISTER butonuna tiklandı.");

        //"Email: This field is required." mesajın göründüğünü doğrula.
        Assert.assertTrue(page.erroremail.getText().contains(ConfigReader.getProperty("emailRequired")));
        extentTest.pass("Email: This field is required. mesajın göründüğü doğrulandı.");
        ReusableMethods.webElementResmi(page.erroremail);
        extentTest.info("Webelement resmi alındı.");
        //"Email Verification Code: This field is required." mesajın göründüğünü doğrula.
        Assert.assertTrue(page.erroremail.getText().contains(ConfigReader.getProperty("verificationCodeRequired")));
        extentTest.pass("Email Verification Code: This field is required. mesajın göründüğü doğrulandı.");
        ReusableMethods.webElementResmi(page.erroremail);
        extentTest.info("Webelement resmi alındı.");
        //"Password: This field is required." mesajın göründüğünü doğrula.
        Assert.assertTrue(page.erroremail.getText().contains(ConfigReader.getProperty("passwordRequired")));
        extentTest.pass("Password: This field is required. mesajın göründüğü doğrulandı.");
        ReusableMethods.webElementResmi(page.erroremail);
        extentTest.info("Webelement resmi alındı.");
        //"Confirm Password: This field is required." mesajın göründüğünü doğrula.
        Assert.assertTrue(page.erroremail.getText().contains(ConfigReader.getProperty("confirmPasswordRequired")));
        extentTest.pass("Confirm Password: This field is required. mesajın göründüğü doğrulandı.");
        ReusableMethods.webElementResmi(page.erroremail);
        extentTest.info("Webelement resmi alındı.");
        //Email alanina geçersiz email gir.
        page.email.sendKeys(ConfigReader.getProperty("gecersizemail"));
        extentTest.info("Email alanina geçersiz email girildi.");

        //Email alanı dışında boşluğa tıkla.
        page.bosluk.click();
        extentTest.info("Email alanı dışında boşluğa tıklandı.");

        //"Please provide a valid email address." mesajın göründüğünü doğrula.
        ReusableMethods.bekle(3);
        Assert.assertEquals(ConfigReader.getProperty("provideValidEmail"), page.erroremail.getText());
        extentTest.pass("Please provide a valid email address. mesajın göründüğü doğrulandı.");
        ReusableMethods.webElementResmi(page.erroremail);
        extentTest.info("Webelement resmi alındı.(Please provide a valid email address.)");

        //Email alanindaki emaili sil.
        page.email.clear();
        extentTest.info("Email alanindaki emaili silndi.");

        //Email alanina kayıtlı bir e-mail adresi gir.
        page.email.sendKeys(ConfigReader.getProperty("kayitliEmail"));
        extentTest.info("Email alanina kayıtlı bir e-mail adresi girildi.");

        //Email alanı dışında boşluğa tıkla.
        page.bosluk.click();
        extentTest.info("Email alanı dışında boşluğa tıklandı.");

        //Mesajın "Verification code sent to your email: " içerdiğini doğrula.
        ReusableMethods.bekle(1);
        Assert.assertTrue(page.verification.getText().contains(ConfigReader.getProperty("VerificationCode")));
        extentTest.pass("Mesajın Verification code sent to your email:  içerdiği doğrulandı.");
        ReusableMethods.webElementResmi(page.verification);
        extentTest.info("Webelement resmi alındı.(Verification code sent to your email:)");
        //Emaile gelen doğrulma kodunu Verification Code text kutusuna gir.
        page.veryficationCodeKutusu.sendKeys(ConfigReader.getProperty("gecersizVerification"));
        extentTest.info("Emaile gelen doğrulma kodu Verification Code text kutusuna girildi.");

        //Password  alanina geçerli password  gir.
        page.password.sendKeys(ConfigReader.getProperty("gecerliPassword"));
        extentTest.info("Password  alanina geçerli password  girildi.");

        //Confirm Password alanina aynı password  gir.//Register butonuna tikla
        page.confirmPassword.sendKeys(ConfigReader.getProperty("gecerliPassword"), Keys.ENTER);
        extentTest.info("Confirm Password alanina aynı password  girildi.");
        extentTest.info("Register butonuna tiklandı.");


        //"This Email already exists. Please login to the site and apply as vendor." mesajını aldığını doğrula.
        ReusableMethods.bekle(2);

        Assert.assertEquals(ConfigReader.getProperty("ThisEmailexists"), page.messageError.getText());
        extentTest.pass("This Email already exists. Please login to the site and apply as vendor. mesajını aldığı doğrulandı.");
        ReusableMethods.webElementResmi(page.messageError);
        extentTest.info("Webelement resmi alındı.(This Email already exists. Please login to the site and apply as vendor.)");

        // Email alanindaki emaili sil.
        page.email.clear();
        extentTest.info("Email alanindaki email silindi.");

        // Email alanina geçerli email gir.
        Driver.getDriver().switchTo().newWindow(WindowType.WINDOW);
        ReusableMethods.window(1);
        Driver.getDriver().get(ConfigReader.getProperty("fakeEmailUrl"));
        ReusableMethods.bekle(2);
        page.fakeEmailCopy.click();
        ReusableMethods.window(0);
        ReusableMethods.bekle(2);
        page.email.click();
        actions.keyDown(Keys.CONTROL).sendKeys("v").release().perform();
        ReusableMethods.bekle(2);
        extentTest.info("Email alanina geçerli email girildi.");

        //"re-send code" butonuna tıkla.
        page.resendCode.click();
        extentTest.info("re-send code butonuna tıklandı.");

        //Mesajın "Verification code sent to your email: " içerdiğini doğrula.
        ReusableMethods.visibleWait(page.verification, 10);
        Assert.assertTrue(page.verification.getText().contains(ConfigReader.getProperty("sentToYourEmail")));
        extentTest.pass("Mesajın Verification code sent to your email:  içerdiği doğrulandı.");
        ReusableMethods.webElementResmi(page.verification);
        extentTest.info("Webelement resmi alındı.(Verification code sent to your email:)");
        //Register butonuna tikla
        page.submit.click();
        extentTest.info("Register butonuna tiklandı.");

        //"Email verification code invalid." yazının göründüğünü doğrula.
        ReusableMethods.bekle(3);
        Assert.assertEquals(ConfigReader.getProperty("codeInvalid"), page.messageError.getText());
        extentTest.pass("Email verification code invalid. yazının göründüğü doğrulandı.");
        ReusableMethods.webElementResmi(page.messageError);
        extentTest.info("Webelement resmi alındı.(Email verification code invalid.)");


    }

    @Test
    public void test02() {
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


        //Çıkan ekranda "Become a Vendor" butonuna tıkla.
        page.BecomeVendor.click();
        extentTest.info("Become a Vendor butonuna tıklandı.");


        //Vendor Registration sayfasını doğrula.
        softAssert.assertEquals(ConfigReader.getProperty("vendorSayfasi"), page.VendorRegistrationYazisi.getText());
        extentTest.pass("Vendor Registration sayfasının göründüğü doğrulandı");


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
        extentTest.info("Emaile gelen doğrulma kodunu Verification Code text kutusuna girildi.");

        page.veryficationCodeKutusu.click();
        actions.keyDown(Keys.CONTROL).sendKeys("v").perform();
        //extentTest.info("Emaile gelen doğrulma kodu Verification Code text kutusuna girildi.");
        //Password alanina en az 6 karakterli kucuk harf, büyük harf, rakam ve special karakter içeren password gir.
        //Confirm Password alanina aynı password gir.
        //Register butonuna tikla
        page.veryficationCodeKutusu.sendKeys(Keys.PAGE_DOWN);
        page.veryficationCodeKutusu.sendKeys(Keys.TAB, Keys.TAB,
                ConfigReader.getProperty("gecerliPassword"),
                Keys.TAB,
                ConfigReader.getProperty("gecersizPassword"), Keys.ENTER);
        extentTest.info("Password alanina en az 6 karakterli kucuk harf, büyük harf, rakam ve special karakter içeren password girildi.");
        extentTest.info("Confirm Password alanina aynı password girildi.");
        extentTest.info("Emaile gelen doğrulma kodunu Verification Code text kutusuna girildi.");

        //Password and Confirm-password are not same."Yazısın çıktığını doğrula
        ReusableMethods.bekle(2);
        Assert.assertEquals(ConfigReader.getProperty("PasswordConfirmPassword"), page.messageError.getText());
        extentTest.info("Password and Confirm-password are not same. Yazısın çıktığı doğrulandı");
        ReusableMethods.webElementResmi(page.messageError);
        extentTest.info("Webelement resmi alındı.");
        //Password  alanina girilen passwordu Confirm Password alanina  gir.
        //Register butonuna tikla.
        page.confirmPassword.clear();
        page.confirmPassword.sendKeys("Techpro.41", Keys.ENTER);
        ReusableMethods.bekle(4);
        extentTest.info("Password  alanina girilen passwordu Confirm Password alanina  girildi.");
        extentTest.info("Register butonuna tiklandı.");

        //"Registration Successfully Completed. "Yazısın çıktığını doğrula.
        Assert.assertEquals(ConfigReader.getProperty("registionSuccess"), page.successlogin.getText());
        extentTest.info("Registration Successfully Completed. Yazısın çıktığı doğrulandı.");
        ReusableMethods.bekle(3);
        //Yeni açılan sayfada "Welcome to Allover Commerce!" yazısını görüdüğünü doğrula.
        Assert.assertEquals(ConfigReader.getProperty("welcome"), page.welcome.getText());
        extentTest.pass("Yeni açılan sayfada Welcome to Allover Commerce! yazısını görüdüğünü doğrula");
        ReusableMethods.webElementResmi(page.welcome);
        extentTest.info("Webelement resmi alındı.");

        softAssert.assertAll();

    }


    @Test
    public void test03() {
        extentTest = extentReports.createTest("Extent Report", "Allover test raporu");
        //Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Anasayfaya gidildi.");
        ReusableMethods.tumSayfaResmi("AnaSayfa");
        extentTest.info("Tum sayfa resmi alındı");

        //Register butonuna tikla
        Page page = new Page();
        page.registion.click();
        ReusableMethods.bekle(2);
        extentTest.info("Register butonuna tiklandı");

        //Çıkan ekranda "Become a Vendor" yazısının göründüğünü doğrula.
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(page.BecomeVendor.isDisplayed());

        extentTest.pass("Çıkan ekranda 'Become a Vendor' yazısının göründüğü doğrulandı.");

        //Çıkan ekranda "Become a Vendor" butonuna tıkla.
        page.BecomeVendor.click();
        extentTest.info("Become a Vendor butonuna tıklandı.");

        //Vendor Registration sayfasını doğrula.
        softAssert.assertEquals(ConfigReader.getProperty("vendorSayfasi"), page.VendorRegistrationYazisi.getText());
        extentTest.pass("Vendor Registration sayfasının göründüğü doğrulandı");

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

        //Gecersiz sifre ile "Password strength should be atleast "Good"" message'ını doğrula
        page.veryficationCodeKutusu.sendKeys(Keys.PAGE_DOWN);
        page.veryficationCodeKutusu.sendKeys(Keys.TAB, Keys.TAB,
                ConfigReader.getProperty("gecersizPassword"),
                Keys.TAB,
                ConfigReader.getProperty("gecersizPassword"), Keys.ENTER);

        ReusableMethods.bekle(2);
        softAssert.assertEquals(ConfigReader.getProperty("goodMessage"), page.messageError.getText(),"Password strength should be atleast Good message'ı görülmedi");
        extentTest.fail("Gecersiz password ile giriş yapılamamalı");
        extentTest.info("Password alanina en az 6 karakterli kucuk harf, büyük harf, rakam ve special karakter içermeyen password girildi.");
        extentTest.info("Confirm Password alanina aynı password girildi.");
        extentTest.info("Password strength should be atleast Good message'ı doğrulandı");
        ReusableMethods.webElementResmi(page.messageError);
        extentTest.info("Webelement resmi alındı.");
        softAssert.assertAll();


    }
}
