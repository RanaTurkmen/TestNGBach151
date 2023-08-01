package tests.Rana.US010;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC001 extends ExtentReport {
    /*
    Password seviyeleri görülebilmeli (Vendor Kaydı için)
    too short
    weak
    good
    strong
     */

    @BeforeMethod
    public void setUp() {
        extentTest=extentReports.createTest("Vendor Kaydı US010 TC01","Password seviyeleri görülebilmeli (Vendor Kaydı için)");

        //Anasayfaya git .
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Anasayfaya gidildi.");
        ReusableMethods.tumSayfaResmi("Anasayfa resmi");
        extentTest.info("Tum sayfa resmi alındı.");

        //Register butonuna tikla.
        Page page = new Page();
        page.registion.click();
        extentTest.info("Register butonuna tiklandı.");

        //Çıkan ekranda "Become a Vendor" butonuna tıkla.
        page.BecomeVendor.click();
        extentTest.info("Çıkan ekranda Become a Vendor butonuna tıklandı");

        //Vendor Registration sayfasının göründüğünü doğrula.
        Assert.assertEquals(ConfigReader.getProperty("vendorSayfasi"), page.VendorRegistrationYazisi.getText());
        extentTest.pass("Vendor Registration sayfasının göründüğünü doğrulandı.");
    }

    @Test
    public void test01() {

        //Password alanina 6 karakterden az bir password gir.
        Page page = new Page();
        page.password.sendKeys(ConfigReader.getProperty("kisa"));
        extentTest.info("Password alanina 6 karakterden az bir password girildi.");

        //"Too short" mesajının göründüğünü doğrula.
        Assert.assertEquals(ConfigReader.getProperty("short"),page.verifyPassword.getText());
        extentTest.info("Too short mesajının göründüğü doğrulandı.");
        ReusableMethods.webElementResmi(page.verifyPassword);
        extentTest.info("Webelement resmi alındı.(Too short)");

        //Passwordu alanındaki passwordu sil.
        page.password.clear();
        extentTest.info("Passwordu alanındaki password sililndi.");

        //"Password alanina 6 karakterli sadece rakam veya küçük harf veya büyük harf veya special karakter içeren bir password gir.
        //(4 kriter aynı anda kullanılmayacak)"
        page.password.sendKeys(ConfigReader.getProperty("Weak01"));
        extentTest.info("Password alanina 6 karakterli sadece rakam veya küçük harf veya büyük harf veya special karakter içeren bir password girildi");

        //"Weak" mesajının göründüğünü doğrula.
        Assert.assertEquals("Weak",page.verifyPassword.getText());
        extentTest.pass("Weak mesajının göründüğü doğrulandı.");
        ReusableMethods.webElementResmi(page.verifyPassword);
        extentTest.info("Webelement resmi alındı.(Weak)");
        //Passwordu alanındaki passwordu sil.
        page.password.clear();
        extentTest.info("Passwordu alanındaki password silindi.");

        //Password 6 karakterli en az bir büyük harf, küçük harf, rakam ve special karakter içeren bir password gir.
        page.password.sendKeys(ConfigReader.getProperty("Good01"));
        extentTest.info("Password 6 karakterli en az bir büyük harf, küçük harf, rakam ve special karakter içeren bir password girildi.");

        //"Good" mesajının göründüğünü doğrula.
        Assert.assertEquals("Good",page.verifyPassword.getText());
        extentTest.pass("Good mesajının göründüğü doğrulandı.");
        ReusableMethods.webElementResmi(page.verifyPassword);
        extentTest.info("Webelement resmi alındı.(Good)");
        //Passwordu alanındaki passwordu sil.
        page.password.clear();
        extentTest.info("Passwordu alanındaki password silindi.");

        //Password 6 karakterli en az bir büyük harf, küçük harf, rakam içeren bir password gir.
        page.password.sendKeys(ConfigReader.getProperty("Good03"));
        extentTest.info("Password 6 karakterli en az bir büyük harf, küçük harf, rakam içeren bir password girildi.");

        //"Good" mesajının göründüğünü doğrula.
        Assert.assertEquals("Good",page.verifyPassword.getText());
        extentTest.pass("Good mesajının göründüğü doğrulandı.");
        ReusableMethods.webElementResmi(page.verifyPassword);
        extentTest.info("Webelement resmi alındı.(Good)");
        //Passwordu alanındaki passwordu sil.
        page.password.clear();
        extentTest.info("Passwordu alanındaki password silindi.");

        //Password 6 karakterli en az bir büyük harf ,küçük harf ve sayı içeren ve (*,?,&,%,!,#,$,^,',',_) karakterlerinden en az birini içeren bir password gir.
        page.password.sendKeys(ConfigReader.getProperty("Strong01"));
        extentTest.info("Password 6 karakterli en az bir büyük harf ,küçük harf ve sayı içeren ve (*,?,&,%,!,#,$,^,',',_) karakterlerinden en az birini içeren bir password girildi.");

        //"Strong" mesajının göründüğünü doğrula.
        Assert.assertEquals("Strong",page.verifyPassword.getText());
        extentTest.pass("Strong mesajının göründüğü doğrulandı.");
        ReusableMethods.webElementResmi(page.verifyPassword);
        extentTest.info("Webelement resmi alındı.(Strong)");

        //Passwordu alanındaki passwordu sil.
        page.password.clear();
        extentTest.info("Passwordu alanındaki password silindi.");

        //Password 8 karakterli en az bir büyük harf ,küçük harf rakam ve special karakter içeren bir password gir.
        page.password.sendKeys(ConfigReader.getProperty("Strong04"));
        extentTest.info("Password 8 karakterli en az bir büyük harf ,küçük harf rakam ve special karakter içeren bir password girildi.");

        //"Strong" mesajının göründüğünü doğrula.
        Assert.assertEquals("Strong",page.verifyPassword.getText());
        extentTest.pass("Strong mesajının göründüğü doğrulandı.");
        ReusableMethods.webElementResmi(page.verifyPassword);
        extentTest.info("Webelement resmi alındı.(Strong)");

    }
}
