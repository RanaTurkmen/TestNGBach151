package tests.US17_US18.US017;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC007 extends ExtentReport {
    @Test
    public void test01() {
        extentTest=extentReports.createTest("Sırma","Allovercommerce Test Edebilmeli");
        // Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        //Sayfaya Vendor olarak giriş yap
        Page page = new Page();
        page.singIns.click();
        page.emailAdres.sendKeys("derik.barrick@fixedfor.com", Keys.TAB,
                "Bb123456", Keys.TAB, Keys.ENTER);
        extentTest.info("Vendor giriş yapıldı");


        ReusableMethods.bekle(2);
        //Sayfanın sonuna kadar git ve "My Account" butonuna tıkla
        ReusableMethods.click(page.myAccount1);
        page.myAccount1.click();

        //"Orders" butonuna tıkla
        ReusableMethods.click(page.orders);

        //"Browse Product" butonuna tıkla
        ReusableMethods.click( page.browseProduct);

        //Ekranın sağındaki dropdown sekmesinden  "show 36"  seçeneğini işaretle
        ReusableMethods.ddmIndex(page.selecttt,3);

        //Ürünleri liste şeklinde görebilmek için listele ikonuna tıkla
        ReusableMethods.click( page.ikonListe);

        //Satın alınmak istenen sayfadaki ürünü seç
        ReusableMethods.click(page.cantaÜrün2);
        extentTest.info("Sayfa sonundaki seçilmek istenen sayfaya tıklandı");

        //"ADD TO CART" butonuna tıkla
        ReusableMethods.click(page.addToCart);

        //Ürünün sepete eklendiğini doğrula
        Assert.assertTrue(page.shoppingCartÜrünAdetleri.getText().contains(page.sepetUstSayı.getText()));
        extentTest.fail("Ürünün sepete eklendiğini doğrulanamadı");
    }
}
