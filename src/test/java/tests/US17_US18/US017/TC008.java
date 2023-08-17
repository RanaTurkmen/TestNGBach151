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

public class TC008 extends ExtentReport {
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
        page.search.sendKeys("bag");
        page.imleç.click();
        extentTest.info("Satın alınmak istenen ürün aratıldı");

        //Satın alınmak istenen ürünü seç
        ReusableMethods.click(page.cantaÜrün);
        ReusableMethods.bekle(2);
        extentTest.info("Satın alınmak istenen ürün seçildi");

        //"ADD TO CART" butonuna tıkla
        ReusableMethods.click(page.addToCart);
        extentTest.info("Ürün sepete eklendi");

        //"Cart" ikonuna tıkla
        page.sepet.click();
        ReusableMethods.bekle(2);

        //Açılan popup penceresinde  "CHECKOUT" butonuna tıkla
        page.checkoutButton.click();

        //"BILLING DETAILS" bölümü altındaki yıldızlı alanları doldur
        //"First name"  bilgisini gir
        //"Last name " bilgisini gir
        //"Country / Region  " dropdown'undan ülke bilgisini seç
        //İkinci adres kutucuğunu boş bırak
        Faker faker=new Faker();
        page.firstName.sendKeys(Keys.CONTROL,"A",Keys.CONTROL,faker.name().firstName(),Keys.TAB,
                Keys.CONTROL,"A",Keys.CONTROL,faker.name().lastName(), Keys.TAB,
                Keys.CONTROL,"A",Keys.CONTROL," ",Keys.TAB,
                "Turkey",Keys.ENTER);
        ReusableMethods.bekle(1);

        //"Street address" bölümüne  adres bilgilerini gir
        //Postcode / ZIP" bölümüne  posta kodunu gir
        //"Town / City " bölümüne  şehir ismini  gir
        //"Province"  dropdown'undan vilayet ismini  seç
        page.bilingDetails.sendKeys(Keys.CONTROL,"A",Keys.CONTROL,faker.address().streetAddress(),Keys.TAB, Keys.TAB,
                Keys.CONTROL,"A",Keys.CONTROL,faker.address().zipCode(),Keys.TAB,
                Keys.CONTROL,"A",Keys.CONTROL,faker.address().city(),Keys.TAB,
                "İstanbul",Keys.ENTER);
        ReusableMethods.bekle(1);

        //"Phone" bölümüne  telefon numarasını gir
        //"Orders Note" bölümüne not yaz
        page.phoneName.sendKeys(Keys.CONTROL,"A",Keys.CONTROL,"77777777777777777777555555",Keys.TAB,Keys.TAB,Keys.TAB,
                Keys.CONTROL,"A",Keys.CONTROL," ","Bug var",Keys.TAB);
        ReusableMethods.bekle(1);

        extentTest.info("Ödeme için adres bilgileri girildi");
        ReusableMethods.tumSayfaResmi("p4");

        //"Payment Methods" bölümü altındaki "Pay at the door" radio butonunu işaretle
        ReusableMethods.click(page.payAddTheDoor);

        //"PLACE ORDER" butonuna tıkla
        ReusableMethods.click(page.placOrder);
        ReusableMethods.bekle(2);

        //Sayfanın üstünde "Billing Phone is a required field." mesajı çıktığını doğrula
        Assert.assertTrue(page.hata1.getText().contains("Billing Phone is a required field."));
        extentTest.fail("Sayfanın üstünde Billing Phone is a required field. mesajı çıktığı doğrulanamadı");

    }
}
