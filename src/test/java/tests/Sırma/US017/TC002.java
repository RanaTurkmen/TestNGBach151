package tests.Sırma.US017;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC002 extends ExtentReport {
    @Test
    public void test01() {
        extentTest=extentReports.createTest("Sırma","Allovercommerce Test Edebilmeli");

        //Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Allovercommerce sayfasına gidildi");

        //Sayfaya Vendor olarak giriş yap
        Page page=new Page();
        page.signIn.click();
        page.emailAdres.sendKeys(ConfigReader.getProperty("emailAdres2"), Keys.TAB,
                ConfigReader.getProperty("sifre2"),Keys.TAB,Keys.ENTER);
        extentTest.info("Vendor giriş yapıldı");


        ReusableMethods.bekle(5);
        //"Woman" dropdown'u altındaki "Bags" seçeneğini seç
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(page.woman).perform();
        actions.moveToElement(page.bags).perform();
        page.bags.click();

        extentTest.info("Woman dropdown'u altındaki Bags seçeneğini seç");

        //Satın almak istenen ürün üzerindeki "sepet" ikonuna tıkla
        //Satın almak istenen  diğer ürün üzerindeki "sepet" ikonuna tıkla
        ReusableMethods.bekle(2);
        actions.moveToElement(page.bag1).perform();
        page.bag1.click();
        ReusableMethods.bekle(2);
        actions.moveToElement(page.bag2).perform();
        ReusableMethods.tumSayfaResmi("tc1-1");
        page.bag2.click();
        extentTest.info("Satın alınmak istenen ürünler seçildi");


        //Ürünün resmi üzerindeki "Sepet" ikonu altında "View cart" yazısı çıktığını doğrula
        actions.moveToElement(page.bag1).perform();
        Assert.assertEquals("View cart",page.bagViewCart.getText());
        extentTest.info("Seçilen ürünlerin Sepet ikonu altında View cart yazısı çıktığını doğrulandı");
        ReusableMethods.tumSayfaResmi("tc1-2");

        //"Cart" ikonuna tıkla
        page.sepet.click();

        ReusableMethods.bekle(2);
        //Açılan popup penceresinde  "CHECKOUT" butonuna tıkla
        page.checkoutButton.click();

        //BILLING DETALIS alanindan first name kısmını boş bırak
        //"Last name " bilgisini boş bırak
        //"Country / Region  " dropdown'undan seçim yapma
        //"Street address" bölümüne  adres bilgilerini boş bırak
        //"Town / City " bölümüne  şehir ismini  boş bırak
        //"State"  dropdown'undan seçim yapma
        //"Postcode / ZIP" bölümüne  posta kodunu boş bırak
        //"Phone" bölümüne  telefon numarasını boş bırak
        //"Payment Methods" bölümü altındaki "Pay at the door" radio butonunu işaretle
        //"PLACE ORDER" butonuna tıkla

       ReusableMethods.click(page.placOrder);

        //Sayfanın üstünde "Billing First name  is a required field." mesajı çıktığını doğrula
        //Sayfanın üstünde "Billing Last name  is a required field." mesajı çıktığını doğrula
        //Sayfanın üstünde "Billing Street address is a required field." mesajı çıktığını doğrula
        //Sayfanın üstünde "Billing Town / City  is a required field." mesajı çıktığını doğrula
        //Sayfanın üstünde "Billing ZIP Code is a required field." mesajı çıktığını doğrula
        //Sayfanın üstünde "Billing Phone  is a required field." mesajı çıktığını doğrula

        extentTest.info("Ödeme bilgilerinin tümü boş bırakıldı");
        ReusableMethods.tumSayfaResmi("tc1-3");

         ReusableMethods.bekle(2);
        Assert.assertEquals("BILLING FIRST NAME is a required field.",page.hata1.getText());
        Assert.assertEquals("BILLING LAST NAME is a required field.",page.hata2.getText());
        Assert.assertEquals("BILLING STREET ADDRESS is a required field.",page.hata3.getText());
        Assert.assertEquals("BILLING TOWN / CITY is a required field.",page.hata4.getText());
        Assert.assertEquals("BILLING ZIP CODE is a required field.",page.hata5.getText());
        Assert.assertEquals("BILLING PHONE is a required field.",page.hata6.getText());


        extentTest.info("Zoronlu doldurulması gereken ve doldurulmayan alanların hata mesajları doğrulandı");
        ReusableMethods.tumSayfaResmi("tc1-4");




    }


}
