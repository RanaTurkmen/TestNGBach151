package tests.US13_US14.US013;

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

public class TC_01 {

    @Test
    public void test001() {
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
        page.vendor1.click();

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


        //Emaile gelen doğrulma kodunu Verification Code text kutusuna gir.
        ReusableMethods.bekle(10);
        ReusableMethods.window(1);
        ReusableMethods.bekle(5);
        page.fakeEmailCode.click();
        ReusableMethods.bekle(2);
        Driver.getDriver().switchTo().frame("iframeMail");
        actions.doubleClick().doubleClick(page.code2).perform();
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

        page.notRightNow.click();
        Assert.assertTrue(page.welcomeDashboard.isDisplayed());

        Driver.closeDriver();



    }

    @Test
    public void test02() {
        Driver.getDriver().get("https://allovercommerce.com/");
        Page page=new Page();
        page.signIn.click();
        page.kayitliUsername.sendKeys("naaman.laden");
        page.kayitliPassword.sendKeys("techpro.41");
        page.login.click();
        page.singOut.click();
        page.adresses.click();
        page.shippingAdd.click();
        page.shippingName.sendKeys("ilyas");
        page.shippingLastName.sendKeys("Çnz");
        ReusableMethods.scroll(page.region);
        ReusableMethods.bekle(2);
        ReusableMethods.ddmIndex(page.region,3);
        page.street.sendKeys("Cumhuriyet");
        page.city.sendKeys("Amasya");
        ReusableMethods.scroll(page.country);
        ReusableMethods.ddmIndex(page.country,5);
        page.zipCode.sendKeys("1234");
        page.save.click();
        ReusableMethods.bekle(2);
        Assert.assertTrue(page.succefully.isDisplayed());

    }
}
