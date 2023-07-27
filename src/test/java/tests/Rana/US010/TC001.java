package tests.Rana.US010;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;

public class TC001 extends ExtentReport {

    @BeforeMethod
    public void setUp() {
        //Anasayfaya git .
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        //Register butonuna tikla.
        Page page = new Page();
        page.registion.click();
        //Çıkan ekranda "Become a Vendor" butonuna tıkla.
        page.BecomeVendor.click();
        //Vendor Registration sayfasının göründüğünü doğrula.
        Assert.assertEquals(ConfigReader.getProperty("vendorSayfasi"), page.VendorRegistrationYazisi.getText());

    }

    @Test
    public void test01() {

        //Password alanina 6 karakterden az bir password gir.
        Page page = new Page();
        page.password.sendKeys(ConfigReader.getProperty("gecersizPassword"));

        //"Too short" mesajının göründüğünü doğrula.
        Assert.assertEquals(ConfigReader.getProperty("short"),page.verifyPassword.getText());

        //Passwordu alanındaki passwordu sil.
        page.password.clear();

        //"Password alanina 6 karakterli sadece rakam veya küçük harf veya büyük harf veya special karakter içeren bir password gir.
        //(4 kriter aynı anda kullanılmayacak)"
        page.password.sendKeys(ConfigReader.getProperty("Weak01"));

        //"Weak" mesajının göründüğünü doğrula.
        Assert.assertEquals("Weak",page.verifyPassword.getText());

        //Passwordu alanındaki passwordu sil.
        page.password.clear();

        //Password 6 karakterli en az bir büyük harf, küçük harf, rakam ve special karakter içeren bir password gir.
        page.password.sendKeys(ConfigReader.getProperty("Good01"));

        //"Good" mesajının göründüğünü doğrula.
        Assert.assertEquals("Good",page.verifyPassword.getText());

        //Passwordu alanındaki passwordu sil.
        page.password.clear();

        //Password 6 karakterli en az bir büyük harf, küçük harf, rakam içeren bir password gir.
        page.password.sendKeys(ConfigReader.getProperty("Good03"));

        //"Good" mesajının göründüğünü doğrula.
        Assert.assertEquals("Good",page.verifyPassword.getText());

        //Passwordu alanındaki passwordu sil.
        page.password.clear();

        //Password 6 karakterli en az bir büyük harf ,küçük harf ve sayı içeren ve (*,?,&,%,!,#,$,^,',',_) karakterlerinden en az birini içeren bir password gir.
        page.password.sendKeys(ConfigReader.getProperty("Strong01"));

        //"Strong" mesajının göründüğünü doğrula.
        Assert.assertEquals("Strong",page.verifyPassword.getText());

        //Passwordu alanındaki passwordu sil.
        page.password.clear();

        //Password 8 karakterli en az bir büyük harf ,küçük harf rakam ve special karakter içeren bir password gir.
        page.password.sendKeys(ConfigReader.getProperty("Strong04"));

        //"Strong" mesajının göründüğünü doğrula.
        Assert.assertEquals("Strong",page.verifyPassword.getText());
    }
}
