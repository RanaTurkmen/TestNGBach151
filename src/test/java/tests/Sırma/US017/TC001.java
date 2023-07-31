package tests.Sırma.US017;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC001 extends ExtentReport {
    @Test
    public void test01() {
        extentTest=extentReports.createTest("Sırma","Allovercommerce Test Edebilmeli");
        //Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Allovercommerce sayfasına gidildi");

        //"Sign In" ikonuna  tıkla
         Page page=new Page();
         page.signIn.click();

        //Vendor olarak kayıt olunan e-mailini veya kullanıcı adını gir
        //Passwordunu gir
        //"Sign In" butonuna tıkla
        page.emailAdres.sendKeys(ConfigReader.getProperty("emailAdres"), Keys.TAB,
                                 ConfigReader.getProperty("sifre"),Keys.TAB,Keys.ENTER);
        extentTest.info("Vendor giriş yapıldı");

         ReusableMethods.bekle(2);
        //Arama bölümüne satın alınmak istenen ürünü yaz
        //Klavyede "Enter" tuşuna bas
        page.search.sendKeys(ConfigReader.getProperty("ilkÜrün"),Keys.ENTER);
        extentTest.info("Satın alınmak istenen ürün aratıldı");
        ReusableMethods.tumSayfaResmi("p1");


        //Satın almak istenen ürün altındaki "Add to Cart" butonuna tıkla
        ReusableMethods.click(page.addToCartApple);

        ReusableMethods.visibleWait(page.popupMesaj,5);
        //Ekranın sol altında açılan Popup mesajında  "has been added to cart"  içerdiğini doğrula
        System.out.println(page.popupMesaj.getText());
        Assert.assertTrue(page.popupMesaj.getText().contains("has been added to cart"));

        extentTest.info("Açılan Popup mesajında  has been added to cart  içerdiği doğrulandı");
        ReusableMethods.tumSayfaResmi("p2");


        //Popup mesajındaki "CHECKOUT" butonuna tıkla
        page.checkoutPopup.click();

        //Başlığın "Checkout" yazısı içerdiğini doğrula
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Checkout"));
        ReusableMethods.tumSayfaResmi("p3");

        extentTest.info("Ödeme sayfasına gidildi");
        extentTest.info("Başlığın Checkout yazısı içerdiğini  doğrulandı");

        //"BILLING DETAILS" bölümü altındaki yıldızlı alanları doldur
       //"First name"  bilgisini gir
       //"Last name " bilgisini gir
       //"Country / Region  " dropdown'undan ülke bilgisini seç
       //İkinci adres kutucuğunu boş bırak
        Faker faker=new Faker();
        page.firstName.sendKeys(faker.name().firstName(),Keys.TAB,
                                           faker.name().lastName(), Keys.TAB,Keys.TAB,
                                           "Turkey",Keys.ENTER);
                                            ReusableMethods.bekle(1);

        //"Street address" bölümüne  adres bilgilerini gir
        //Postcode / ZIP" bölümüne  posta kodunu gir
        //"Town / City " bölümüne  şehir ismini  gir
        //"Province"  dropdown'undan vilayet ismini  seç
        page.bilingDetails.sendKeys(faker.address().streetAddress(),Keys.TAB, Keys.TAB,
                                               faker.address().zipCode(),Keys.TAB,
                                               faker.address().city(),Keys.TAB,
                                               "İstanbul",Keys.ENTER);
                                               ReusableMethods.bekle(1);

        //"Phone" bölümüne  telefon numarasını gir
        //"Orders Note" bölümüne not yaz
        page.phoneName.sendKeys(faker.phoneNumber().cellPhone(),Keys.TAB,Keys.TAB,Keys.TAB,
                                          "Ürün faturasını unutmayınız",Keys.TAB);
                                           ReusableMethods.bekle(1);

        extentTest.info("Ödeme için adres bilgileri girildi");
        ReusableMethods.tumSayfaResmi("p4");


        //"Email address" bölümündeki adresin girilen vendor mail ile aynı olduğunu doğrula
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String valueAttributeDegeri = js.executeScript("return document.getElementById('billing_email').value").toString();
        System.out.println("deger"+valueAttributeDegeri);

        Assert.assertEquals(ConfigReader.getProperty("emailAdres"),valueAttributeDegeri);
        extentTest.info("Email address bölümündeki adresin girilen vendor mail ile aynı olduğunu doğrulandı");
        ReusableMethods.tumSayfaResmi("p5");

        //Seçilen ürün bilgilerinin  "YOUR ORDER" bölümü altında olduğunu doğrula
         Assert.assertTrue(page.yourOrder.getText().contains(page.multiFoncTel.getText()));
        extentTest.info("Seçilen ürün bilgilerinin  YOUR ORDER bölümü altında olduğunu doğrulandı");
        ReusableMethods.tumSayfaResmi("p6");

        //"Payment Methods" bölümü altındaki "Pay at the door" radio butonunu işaretle
        ReusableMethods.click(page.payAddTheDoor);

        //Radio butonunun seçilebilir olduğunu doğrula
        Assert.assertTrue(page.payAddTheDoor.isSelected());
        extentTest.info("Pay at the door radio butonunu işaretlendiği doğrulandı");
        ReusableMethods.tumSayfaResmi("p7");

        //"PLACE ORDER" butonuna tıkla
        ReusableMethods.click(page.placeOrder);
        ReusableMethods.bekle(2);

        //"Thank you. Your order has been received." mesajının çıktığını doğrula
        Assert.assertEquals("Thank you. Your order has been received.",page.thankYou.getText());
        extentTest.info("Şiparişin basarılı bir gerceklestiği yapıldığı doğrulandı");
        ReusableMethods.webElementResmi(page.thankYou);

        ReusableMethods.bekle(2);
        //Sayfanın sonuna kadar git ve "My Account" butonuna tıkla
        ReusableMethods.click(page.myAccount);
        page.myAccount.click();

        //"Orders" butonuna tıkla
        ReusableMethods.click(page.orders);

        //Çıkan sayfada "Orders" altındaki ilk sipariş koduna tıkla
        ReusableMethods.click(page.siparisKodu2);
        ReusableMethods.bekle(2);

        //"Add yor note" yazısının üstünde "is currently Processing." yazısı içerdiğini doğrula
        Assert.assertTrue(page.baslıkSiparis.getText().contains("is currently Processing."));
        extentTest.info("Alısversin ayrıntılarının görülebildiği doğrulandı");
        ReusableMethods.tumSayfaResmi("p8");

        //Toplam ödenecek tutarı doğrula
        ReusableMethods.click(page.ürünNote);
        Assert.assertEquals(page.ordersTotalFiyat.getText(),(page.billingTotalFiyat.getText()));
        extentTest.info("Faturadaki tutar ile ödeme sayfasındaki tutarın aynı olduğu doğrulandı");


        //"ORDER DETAILS" bölümü altında sipariş verilen ürünlerin " Shipment Tracking " sevkiyat bilgileri
        // yazısı içerdiğini doğrula
        Assert.assertTrue(page.sevkiyat.getText().contains("Shipment Tracking"));
        extentTest.info("Fatura detaylarında ürün sevkiyat bilgisinin içerdiği doğrulandı");



    }
}
