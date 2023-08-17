package tests.US09_US10.US010;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC001 extends ExtentReport {
    @DataProvider
    public static Object[][] sifre() {
        return new Object[][]{
                {ConfigReader.getProperty("sort"),
                 ConfigReader.getProperty("Weak01"),
                 ConfigReader.getProperty("Good01"),
                 ConfigReader.getProperty("Strong01")},

                 {ConfigReader.getProperty("sort2"),
                 ConfigReader.getProperty("Weak02"),
                 ConfigReader.getProperty("Good03"),
                 ConfigReader.getProperty("Strong04")}

        };
    }

    /*
    Password seviyeleri görülebilmeli (Vendor Kaydı için)
    too short
    weak
    good
    strong
     */

    @Test(dataProvider = "sifre")
    public void test01(String sort,String weak,String good,String strong) {
        ReusableMethods.venderKayit();
        extentTest = extentReports.createTest("Vendor Kaydı US010 TC01", "Password seviyeleri görülebilmeli (Vendor Kaydı için)");

        extentTest.info("Anasayfaya gidildi.");
        extentTest.info("Tum sayfa resmi alındı");
        extentTest.info("Register butonuna tiklandı");
        extentTest.pass("Çıkan ekranda 'Become a Vendor' yazısının göründüğü doğrulandı.");
        extentTest.info("Become a Vendor butonuna tıklandı.");
        extentTest.pass("Vendor Registration sayfasının göründüğü doğrulandı");

        //Password alanina 6 karakterden az bir password gir.
        Page page = new Page();
        page.password.sendKeys(sort);
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
        page.password.sendKeys(weak);
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
        page.password.sendKeys(good);
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
        //page.password.sendKeys(ConfigReader.getProperty("Good03"));
        //extentTest.info("Password 6 karakterli en az bir büyük harf, küçük harf, rakam içeren bir password girildi.");

          //"Good" mesajının göründüğünü doğrula.
        //Assert.assertEquals("Good",page.verifyPassword.getText());
        //extentTest.pass("Good mesajının göründüğü doğrulandı.");
        //ReusableMethods.webElementResmi(page.verifyPassword);
        //extentTest.info("Webelement resmi alındı.(Good)");
        //Passwordu alanındaki passwordu sil.
        page.password.clear();
        extentTest.info("Passwordu alanındaki password silindi.");

        //Password 6 karakterli en az bir büyük harf ,küçük harf ve sayı içeren ve (*,?,&,%,!,#,$,^,',',_) karakterlerinden en az birini içeren bir password gir.
        page.password.sendKeys(strong);
        extentTest.info("Password 6 karakterli en az bir büyük harf ,küçük harf ve sayı içeren ve (*,?,&,%,!,#,$,^,',',_) karakterlerinden en az birini içeren bir password girildi.");

        //"Strong" mesajının göründüğünü doğrula.
        Assert.assertEquals("Strong",page.verifyPassword.getText());
        extentTest.pass("Strong mesajının göründüğü doğrulandı.");
        ReusableMethods.webElementResmi(page.verifyPassword);
        extentTest.info("Webelement resmi alındı.(Strong)");

          //Passwordu alanındaki passwordu sil.
        //page.password.clear();
        //extentTest.info("Passwordu alanındaki password silindi.");

          //Password 8 karakterli en az bir büyük harf ,küçük harf rakam ve special karakter içeren bir password gir.
        //page.password.sendKeys(ConfigReader.getProperty("Strong04"));
        //extentTest.info("Password 8 karakterli en az bir büyük harf ,küçük harf rakam ve special karakter içeren bir password girildi.");

          //"Strong" mesajının göründüğünü doğrula.
        //Assert.assertEquals("Strong",page.verifyPassword.getText());
        //extentTest.pass("Strong mesajının göründüğü doğrulandı.");
        //ReusableMethods.webElementResmi(page.verifyPassword);
        //extentTest.info("Webelement resmi alındı.(Strong)");

    }
}
