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

public class TC001  {
    @Test
    public void test01() {

        //Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        //Register butonuna tikla
        Page page=new Page();
        page.registion.click();
        ReusableMethods.bekle(2);

        //Çıkan ekranda "Become a Vendor" yazısının göründüğünü doğrula.
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(page.BecomeVendor.isDisplayed());
        //extentTest.pass("Çıkan ekranda 'Become a Vendor' yazısının göründüğü doğrulandı.");

        //Çıkan ekranda "Become a Vendor" butonuna tıkla.
        page.BecomeVendor.click();

        //Vendor Registration sayfasını doğrula.
        softAssert.assertEquals(ConfigReader.getProperty("vendorSayfasi"),page.VendorRegistrationYazisi.getText());

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

        //Email alanı dışında boşluğa tıkla.
        page.bosluk.click();


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
        //Password alanina en az 6 karakterli kucuk harf, büyük harf, rakam ve special karakter içeren password gir.
        //Confirm Password alanina aynı password gir.
        //Register butonuna tikla
        page.veryficationCodeKutusu.sendKeys(Keys.PAGE_DOWN);
        page.veryficationCodeKutusu.sendKeys(Keys.TAB,Keys.TAB,
                ConfigReader.getProperty("gecerliPassword"),
                Keys.TAB,
                ConfigReader.getProperty("gecerliPassword"),Keys.ENTER);


        //"Registration Successfully Completed. "Yazısın çıktığını doğrula
        ReusableMethods.bekle(2);
        softAssert.assertEquals(ConfigReader.getProperty("registionSuccess"),page.successlogin.getText());


        //Yeni açılan sayfada "Welcome to Allover Commerce!" yazısını görüdüğünü doğrula
        ReusableMethods.bekle(2);
        softAssert.assertEquals(ConfigReader.getProperty("WelcometoAllover"),page.welcome.getText());

        softAssert.assertAll();

    }
}
