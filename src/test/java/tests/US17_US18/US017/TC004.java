package tests.US17_US18.US017;


import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC004 extends ExtentReport {
    @Test
    public void test01() {
        extentTest = extentReports.createTest("Sırma", "Allovercommerce Test Edebilmeli");

        //Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Allovercommerce sayfasına gidildi");

        //Sayfaya Vendor olarak giriş yap
        Page page = new Page();
        page.singIns.click();
        page.emailAdres.sendKeys(ConfigReader.getProperty("emailAdres4"), Keys.TAB,
                ConfigReader.getProperty("sifre4"), Keys.TAB, Keys.ENTER);
        extentTest.info("Vendor giriş yapıldı");


        ReusableMethods.bekle(2);
        //Sayfanın sonuna kadar git ve "My Account" butonuna tıkla
        ReusableMethods.click(page.myAccount1);
        page.myAccount1.click();

        //"Orders" butonuna tıkla
        ReusableMethods.click(page.orders);

        //"Browse Product" butonuna tıkla
        page.browseProduct.click();

        //Sayfa sonundaki seçilmek istenen sayfaya tıkla
        ReusableMethods.click(page.next3);
        ReusableMethods.bekle(2);
        ReusableMethods.click(page.next);
        ReusableMethods.bekle(2);
        ReusableMethods.click(page.next5);
        extentTest.info("Sayfa sonundaki oklar ile istenilen sayfa seçildi");
        ReusableMethods.tumSayfaResmi("p1");


        //Satın alınmak istenen ürünü seç
        ReusableMethods.bekle(3);
        ReusableMethods.click(page.pattern);
        extentTest.info("Satın alınmak istenen ürün seçildi");

        //"Quantity" bölümündeki "+" ikonuna bir kez tıkla
        ReusableMethods.click(page.artı);

        //"Quantity" bölümündeki "-" ikonuna bir kez tıkla
        ReusableMethods.click(page.eksi);

        //"Quantity" bölümünün üzerinde"in stock" yazısı icerdiğini   doğrula
        Assert.assertTrue(page.stokAdedi.getText().contains("in stock"));
        ReusableMethods.tumSayfaResmi("p2");

        //"Add to Cart" butonuna tıkla
        ReusableMethods.click(page.addToCart);

        //"Quantity" bölümündeki kutucuktaki sayıya "2" yaz
        ReusableMethods.sendKeysJS(page.ürünAdedi, "2");

        //"Add to Cart" butonuna tıkla
        ReusableMethods.click(page.addToCart);

        //Sayfa başındaki "Cart"  butonuna tıkla
        ReusableMethods.click(page.sepet);

        //Sepete eklenen ürün  sayısı ile Cart ikonu üzerindeki sayının aynı olduğunu doğrula
        Assert.assertTrue(page.shoppingCartÜrünAdetleri.getText().contains(page.sepetUstSayı.getText()));
        extentTest.pass("Sepete eklenen ürün  sayısı ile Cart ikonu üzerindeki sayının aynı olduğunu doğrulandı");

        //Sepete eklenen ürünün listeye eklendiğini doğrula
        System.out.println(page.popupBabyPattern.getText());
        Assert.assertEquals("Ebby Paten", page.popupBabyPattern.getText());
        extentTest.pass("Sepete eklenen ürünün listeye eklendiğini doğrulandı");
        ReusableMethods.tumSayfaResmi("p3");

        //"VIEW CART" butonuna tıkla
        ReusableMethods.click(page.viewCart);

        //Sayfayı kapat
        Driver.closeDriver();
        extentTest.info("Sayfa kapatıldı");


    }

}
