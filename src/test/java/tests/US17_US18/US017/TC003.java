package tests.US17_US18.US017;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC003 extends ExtentReport{
    @Test
    public void test01() {
        extentTest=extentReports.createTest("Sırma","Allovercommerce Test Edebilmeli");
        Faker faker=new Faker();
        Page page=new Page();

        //Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Allovercommerce sayfasına gidildi");

        //Sayfaya Vendor olarak giriş yap
        page.singIns.click();
        page.emailAdres.sendKeys(ConfigReader.getProperty("emailAdres3"), Keys.TAB,
                ConfigReader.getProperty("sifre3"),Keys.TAB,Keys.ENTER);
        ReusableMethods.bekle(5);
        extentTest.info("Vendor giriş yapıldı");

        //Arama bölümüne  tıkla ve satın alınmak istenen ürünü yaz
        //"Seach" imlecine tıkla
        page.search.sendKeys(ConfigReader.getProperty("Ürün2"));
        page.imleç.click();

        extentTest.info("Satın alınmak istenen ürün aratıldı");

        //Satın alınmak istenen ürünü seç
        ReusableMethods.click(page.ürün2);
        ReusableMethods.bekle(2);
        extentTest.info("Satın alınmak istenen ürün seçildi");


        //"ADD TO CART" butonuna tıkla
        // "Please select some product options before adding this product to your cart." mesajı çıktığını doğrula
        ReusableMethods.click(page.addToCart);
        ReusableMethods.bekle(1);
        Assert.assertEquals("Please select some product options before adding this product to your cart.",
                Driver.getDriver().switchTo().alert().getText());
        ReusableMethods.bekle(2);
        ReusableMethods.alertAccept();

        extentTest.info("ADD TO CART butonuna tıklanmadığı test edildi");

        //"Color" bölümünden istenilen rengi seç
        ReusableMethods.click(page.yellow);
        ReusableMethods.bekle(2);

        extentTest.info("Satın alınacak ürünün rengi seçildi");
        ReusableMethods.webElementResmi(page.addToCart);

        //"ADD TO CART" butonuna tıkla "Please select some product options before adding this
        // product to your cart." mesajı çıktığını doğrula
        ReusableMethods.click(page.addToCart);
        Assert.assertEquals("Please select some product options before adding this product to your cart.",
                Driver.getDriver().switchTo().alert().getText());
        ReusableMethods.bekle(2);
        ReusableMethods.alertAccept();

        extentTest.info("ADD TO CART butonuna tıklanmadığı test edildi");


        //"Size" bölümünden mevcut bedeni seç
        ReusableMethods.click(page.mideum);


        extentTest.info("Satın alınacak ürünün size'ı seçildi");

        //"ADD TO CART" butonuna tıkla
        ReusableMethods.bekle(2);
        ReusableMethods.click(page.addToCart);

        extentTest.info("Satın alınacak ürün sepete eklendi");

        //Ürünün üst kısmında  "has been added to your cart." yazısı içerdiğini doğrula
        Assert.assertEquals("VIEW CART “Women’s Summer Casual Dress” has been added to your cart.",
                page.viewCartMesaj.getText());

        extentTest.pass("Satın alınacak ürün sepete eklendiği doğrulandı");

        //Ürün üzerine çıkan "VIEW CART" butonuna tıkla
        ReusableMethods.click(page.viewCart);


        //"CONTINUE SHOPPING" butonuna tıkla
        ReusableMethods.click(page.continueShopping);
        ReusableMethods.bekle(2);

        //Açılan sayfadan bir ürün daha  seç
        ReusableMethods.click(page.macPro);
        ReusableMethods.bekle(2);


        extentTest.info("Satın alınacak başka bir ürün seçildi");

        //"ADD TO CART" butonuna tıkla
        ReusableMethods.click(page.addToCart);

        //Ürün üzerine çıkan "VIEW CART" butonuna tıkla
        ReusableMethods.click(page.viewCart);

        extentTest.info("Satın alınacak diğer ürün sepete eklendi");

        //"PROCEED TO CHECKOUT" butonuna tıkla
        ReusableMethods.bekle(2);
        ReusableMethods.click(page.proceedToCheckout);

        extentTest.info("Ödeme sayfasına gidildi");

        //" Checkout" sayfasına gidildiğini test et
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Checkout"));

        ReusableMethods.tumSayfaResmi("p4");
        extentTest.info("Ödeme sayfasına gidildiği test edildi");

        //"BILLING DETAILS" bölümü altındaki tüm alanları doldur
        // "First name"  bilgisini gir
        //"Last name " bilgisini gir
        //"Country / Region  " dropdown'undan ülke bilgisini seç


        page.firstName.sendKeys(Keys.CONTROL,"A",Keys.CONTROL,faker.name().firstName(),Keys.TAB,
                                           Keys.CONTROL,"A",Keys.CONTROL,faker.name().lastName(), Keys.TAB,
                                           Keys.CONTROL,"A",Keys.CONTROL,faker.company().name(),Keys.TAB,
                                           "United States",Keys.ENTER);
                                           ReusableMethods.bekle(2);


        //"Street address" bölümüne  adres bilgilerini gir
        //"Town / City " bölümüne  şehir ismini  gir
        //"State" dropdown'undan  vilayet ismini  seç
        page.bilingDetails.sendKeys( Keys.CONTROL,"A",Keys.CONTROL,faker.address().streetAddress(),Keys.TAB,
                                                Keys.CONTROL,"A",Keys.CONTROL,faker.address().city(),Keys.TAB,
                                                Keys.CONTROL,"A",Keys.CONTROL,faker.address().city(),Keys.TAB,"New york");
        ReusableMethods.bekle(2);


         //"Postcode / ZIP" bölümüne  posta kodunu noktalama işareti içerecek şekilde gir
        //"Phone" bölümüne  telefon numarası harf içerecek şekilde gir
        //"Order notes " kısmına not yaz

        ReusableMethods.click(page.zipKod);
        page.zipKod.sendKeys(Keys.CONTROL,"A",Keys.CONTROL,"1001?",Keys.TAB,
                                        Keys.CONTROL,"A",Keys.CONTROL,"212937076k",Keys.TAB,Keys.TAB,Keys.TAB,
                                        Keys.CONTROL,"A",Keys.CONTROL,"Ürünleri hediye paketi yaparsanız memnun olurum",Keys.TAB);
                                          ReusableMethods.bekle(2);

        extentTest.info("Ödeme için adres bilgileri girildi");
        ReusableMethods.tumSayfaResmi("p5");

        //"PLACE ORDER" butonuna tıkla
        ReusableMethods.click(page.placOrder);
        ReusableMethods.bekle(3);


        //Sayfanın üstünde "Billing ZIP Code is a required field." mesajı içerdiğini  doğrula
        Assert.assertTrue(page.hata8.getText().contains("BILLING ZIP CODE is not a valid postcode"));
        ReusableMethods.tumSayfaResmi("p6");
        extentTest.pass("Posta kodunun noktalama içermemesi gerektiği doğrulandı");

        //Sayfanın üstünde "Billing Phone  is a required field." mesajı içerdiğini doğrula
        Assert.assertTrue(page.hata9.getText().contains("BILLING PHONE is not a valid phone number."));
        extentTest.pass("Telefon numarasının harf içermemesi gerektiği doğrulandı");


        //Sayfayı kapat
        Driver.closeDriver();
        extentTest.info("Sayfa kapatıldı");


    }
}


