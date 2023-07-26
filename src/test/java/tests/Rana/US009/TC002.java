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
import utilities.ReusableMethods;

public class TC002 {
    @Test
    public void test01() {
        //Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        //Sign In butonuna tıkla.
        Page page=new Page();
        page.signIn.click();
        //SIGN UP butonuna tıkla.
        page.signUp.click();
        //Çıkan ekranda "Become a Vendor" butonuna tıkla.
        Assert.assertTrue(page.BecomeVendor.isDisplayed());
        page.BecomeVendor.click();

        //Vendor Registration sayfasının göründüğünü doğrula.
        Assert.assertEquals(ConfigReader.getProperty("vendorSayfasi"), page.VendorRegistrationYazisi.getText());
        //Registration alanındaki REGISTER butonuna tikla
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        page.submit.click();
        ReusableMethods.bekle(2);
        //"Email: This field is required." mesajın göründüğünü doğrula.
        Assert.assertTrue(page.erroremail.getText().contains(ConfigReader.getProperty("emailRequired")));

        //"Email Verification Code: This field is required." mesajın göründüğünü doğrula.
        Assert.assertTrue(page.erroremail.getText().contains(ConfigReader.getProperty("verificationCodeRequired")));

        //"Password: This field is required." mesajın göründüğünü doğrula.
        Assert.assertTrue(page.erroremail.getText().contains(ConfigReader.getProperty("passwordRequired")));

        //"Confirm Password: This field is required." mesajın göründüğünü doğrula.
        Assert.assertTrue(page.erroremail.getText().contains(ConfigReader.getProperty("confirmPasswordRequired")));

        //Email alanina geçersiz email gir.
        page.email.sendKeys(ConfigReader.getProperty("gecersizemail"));
        //Email alanı dışında boşluğa tıkla.
        page.bosluk.click();
        //"Please provide a valid email address." mesajın göründüğünü doğrula.
        ReusableMethods.bekle(3);
        Assert.assertEquals(ConfigReader.getProperty("provideValidEmail"), page.erroremail.getText());
        //Email alanindaki emaili sil.
        page.email.clear();
        //Email alanina kayıtlı bir e-mail adresi gir.
        page.email.sendKeys(ConfigReader.getProperty("kayitliEmail"));
        //Email alanı dışında boşluğa tıkla.
        page.bosluk.click();

        //Mesajın "Verification code sent to your email: " içerdiğini doğrula.
        ReusableMethods.bekle(2);
        Assert.assertTrue(page.verification.getText().contains(ConfigReader.getProperty("VerificationCode")));
        //Emaile gelen doğrulma kodunu Verification Code text kutusuna gir.
        page.veryficationCodeKutusu.sendKeys(ConfigReader.getProperty("gecersizVerification"));

        //Password  alanina geçerli password  gir.
        page.password.sendKeys(ConfigReader.getProperty("gecerliPassword"));

        //Confirm Password alanina aynı password  gir.//Register butonuna tikla
        page.confirmPassword.sendKeys(ConfigReader.getProperty("gecerliPassword"),Keys.ENTER);


        //"This Email already exists. Please login to the site and apply as vendor." mesajını aldığını doğrula.
        ReusableMethods.bekle(2);

        Assert.assertEquals(ConfigReader.getProperty("ThisEmailexists"), page.messageError.getText());

        // Email alanindaki emaili sil.
        page.email.clear();
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
        //"re-send code" butonuna tıkla.
        page.resendCode.click();
        //Mesajın "Verification code sent to your email: " içerdiğini doğrula.
        ReusableMethods.visibleWait(page.verification, 10);
        Assert.assertTrue(page.verification.getText().contains(ConfigReader.getProperty("sentToYourEmail")));
        //Register butonuna tikla
        page.submit.click();
        //"Email verification code invalid." yazının göründüğünü doğrula.
        ReusableMethods.bekle(3);
        Assert.assertEquals(ConfigReader.getProperty("codeInvalid"), page.messageError.getText());


    }

    @Test
    public void test02() {
        //Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        //extentTest.info("Anasayfaya gidildi.");

        //Register butonuna tikla
        Page page=new Page();
        page.registion.click();
        ReusableMethods.bekle(2);
        //extentTest.info("Register butonuna tiklandi.");

        //Çıkan ekranda "Become a Vendor" yazısının göründüğünü doğrula.
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(page.BecomeVendor.isDisplayed());
        //extentTest.pass("Çıkan ekranda 'Become a Vendor' yazısının göründüğü doğrulandı.");

        //Çıkan ekranda "Become a Vendor" butonuna tıkla.
        page.BecomeVendor.click();
        //extentTest.info("Become a Vendor butonuna tiklandi.");

        //Vendor Registration sayfasını doğrula.
        softAssert.assertEquals(ConfigReader.getProperty("vendorSayfasi"),page.VendorRegistrationYazisi.getText());
        //extentTest.pass("Vendor Registration sayfasina gidildiği doğrulandı.");

        //Email alanina email gir.
        Driver.getDriver().switchTo().newWindow(WindowType.WINDOW);
        ReusableMethods.window(1);
        Driver.getDriver().get(ConfigReader.getProperty("fakeEmailUrl"));
        ReusableMethods.bekle(2);
        page.fakeEmailCopy.click();
        ReusableMethods.window(0);
        ReusableMethods.bekle(2);
        page.email.click();
        Actions actions =new Actions(Driver.getDriver());
        actions.keyDown(Keys.CONTROL).sendKeys("v").release().perform();
        ReusableMethods.bekle(2);
        //extentTest.info("Email alanina email girildi.");

        //Email alanı dışında boşluğa tıkla.
        page.bosluk.click();
        //extentTest.info("Email alanı dışında boşluğa tıklandı.");

        //mesajın "Verification code sent to your email: " içerdiğini doğrula.
        ReusableMethods.visibleWait(page.verification,10);
        System.out.println(page.verification.getText());
        softAssert.assertTrue(page.verification.getText().contains(ConfigReader.getProperty("sentToYourEmail")));

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
        //extentTest.info("Emaile gelen doğrulma kodu Verification Code text kutusuna girildi.");
        //Password alanina en az 6 karakterli kucuk harf, büyük harf, rakam ve special karakter içeren password gir.
        //Confirm Password alanina aynı password gir.
        //Register butonuna tikla
        page.veryficationCodeKutusu.sendKeys(Keys.PAGE_DOWN);
        page.veryficationCodeKutusu.sendKeys(Keys.TAB,Keys.TAB,
                ConfigReader.getProperty("gecerliPassword"),
                Keys.TAB,
                ConfigReader.getProperty("gecersizPassword"),Keys.ENTER);
        //Password and Confirm-password are not same."Yazısın çıktığını doğrula
        ReusableMethods.bekle(2);
        Assert.assertEquals(ConfigReader.getProperty("PasswordConfirmPassword"),page.messageError.getText());

        //Password  alanina girilen passwordu Confirm Password alanina  gir.
        //Register butonuna tikla.
        page.confirmPassword.clear();
        page.confirmPassword.sendKeys("techpro.41",Keys.ENTER);

        //"Registration Successfully Completed. "Yazısın çıktığını doğrula.
        ReusableMethods.bekle(2);
        Assert.assertEquals(ConfigReader.getProperty("registionSuccess"),page.successlogin.getText());
        ReusableMethods.bekle(2);
        //Yeni açılan sayfada "Welcome to Allover Commerce!" yazısını görüdüğünü doğrula.
        Assert.assertEquals(ConfigReader.getProperty("welcome"),page.welcome.getText());

    }
}
