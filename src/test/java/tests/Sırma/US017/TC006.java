package tests.Sırma.US017;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC006 extends ExtentReport {
    @Test
    public void test01() {
        extentTest=extentReports.createTest("Sırma","Allovercommerce Test Edebilmeli");
        Page page=new Page();
        //Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Allovercommerce sayfasına gidildi");

        //Sayfaya Vendor olarak giriş yap
        page.singIns.click();
        page.emailAdres.sendKeys(ConfigReader.getProperty("emailAdres7"), Keys.TAB,
                ConfigReader.getProperty("sifre7"),Keys.TAB,Keys.ENTER);
        ReusableMethods.bekle(5);
        extentTest.info("Vendor giriş yapıldı");


        //Arama bölümüne  tıkla ve satın alınmak istenen ürünü yaz
        //"Seach" imlecine tıkla
        page.search.sendKeys("Apple");
        page.imleç.click();
        extentTest.info("Arama bölümün yazıldı  ve satın alınmak istenen ürün aratıldı");


        //Satın alınmak istenen ürünü seç
        ReusableMethods.click(page.ürünApple);
        extentTest.info(" Satın alınmak istenen ürün seçildi");

        //Ürün yanında  stock yazısının  yazdığını  doğrula
        Assert.assertTrue(page.stokAdedi.getText().contains("in stock"));
        extentTest.pass("Ürün yanında  stock yazısının  yazdığı  doğrulandı");

        //"ADD TO CART" butonuna tıkla
        ReusableMethods.click(page.addToCart);

        //"Quantity" bölümünün yazmadığını doğrula
        Assert.assertFalse(page.quantity.isDisplayed());
        extentTest.pass("Quantity bölümünün yazmadığın doğrulandı");


        //"ADD TO CART" butonuna tıkla
        ReusableMethods.click(page.addToCart);

        //Ürünün sepete eklendiğini doğrula
        Assert.assertTrue(page.shoppingCartÜrünAdetleri.getText().contains(page.sepetUstSayı.getText()));
        extentTest.fail("Ürünün sepete eklendiğini doğrulanamadı");
    }
}
