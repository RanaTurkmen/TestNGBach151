package tests.US05_US06.US006;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC001 extends ExtentReport {
    @Test
    public void test01() {
        extentTest = extentReports.createTest("TestNGProje", "AlloverCommerce Test Raporu");

        //Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("alloverURL"));
        extentTest.info("Anasayfaya gidildi");

        //Sign in butonuna tikla
        Page page = new Page();
        page.signInButton.click();
        ReusableMethods.bekle(2);
        extentTest.info("ign in butonuna tiklandi");

        //Username alanına "Username" gir
        page.username.sendKeys(ConfigReader.getProperty("username"), Keys.TAB);
        ReusableMethods.bekle(2);
        extentTest.info("Username girildi");

        //Password alanina "password" gir
        page.password.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.bekle(2);
        extentTest.info("Password girildi");

        //"Remember me" kutusunu tikla
        page.rememberButton.click();
        ReusableMethods.bekle(2);
        extentTest.info("Remember me kutusuna tiklandi");

        //Sign in butonuna tikla
        page.signIn.click();
        ReusableMethods.bekle(3);
        extentTest.info("Sign in butonuna tiklandi");

        //Sayfaya basarili giris yaptıgını gosteren mesajın gorundugunu dogrula
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(page.mesajVerify.isDisplayed());
        ReusableMethods.bekle(3);
        extentTest.pass("Sayfaya basarili giris yapildigi dogrulandi");
        ReusableMethods.tumSayfaResmi("Sayfa resmi alindi");

        //"Search Box" kutusuna urun adi yazin ve aratin
         page.searchBox.sendKeys(ConfigReader.getProperty("metin"), Keys.ENTER);
         ReusableMethods.bekle(2);
         extentTest.info("Search Box kutusuna urun adi yazildi ve arama yapildi");

        //Arama sonucunun gorunur olup olmadigini test edin
        softAssert.assertTrue(page.aramaSonucYazisi.isDisplayed());
        ReusableMethods.bekle(2);
        extentTest.pass("Arama sonucunun gorunur oldugu test edildi");
        ReusableMethods.tumSayfaResmi("Sayfa resmi alindi");

        //Arama sonucunun T-shirt icerip icermedigini test edin
        softAssert.assertTrue(page.aramaSonucYazisi.getText().contains("T-shirt"));
        ReusableMethods.bekle(2);
        extentTest.pass("Arama sonucunun T-shirt icerdigi test edildi");
        ReusableMethods.tumSayfaResmi("Sayfa resmi alindi");


        //İlk urunu tiklayalim
        page.ilkUrun.click();
        ReusableMethods.bekle(2);
        extentTest.info("Ilk urune tiklandi");

        //sayfanin error verdigini dogrulayalim
        softAssert.assertFalse(page.hataVerify.isDisplayed());
        ReusableMethods.bekle(2);
        extentTest.pass("sayfanin error verdigi dogrulandi");
        ReusableMethods.tumSayfaResmi("Sayfa resmi alindi");

        //Sayfada geri donun ve ikinci urunu tiklayin
        Driver.getDriver().navigate().back();
        page.ikinciUrun.click();
        ReusableMethods.bekle(2);
        extentTest.info("Sayfada geri donuldu ve ikinci urune tiklandi");

        //Secilen urunun rengini secip "Add to cart" butonuna tiklayip sepete ekleyin
        page.urunRengi.click();
        ReusableMethods.bekle(2);
        extentTest.info("Secilen urunun rengi secildi");

        page.addToCartButton.submit();
        ReusableMethods.bekle(2);
        extentTest.info("Add to cart butonuna tiklanip sepete eklendi");

        //Urunun sepete eklendigini dogrulayin
        softAssert.assertTrue(page.urunVerify.isDisplayed());
        ReusableMethods.bekle(2);
        extentTest.pass("Urunun sepete eklendigi dogrulandi");
        ReusableMethods.tumSayfaResmi("Sayfa resmi alindi");

        //Sepet ikonuna tikla ve Urunun sepete eklendigini dogrulayin
        page.sepetIkonu.click();
        ReusableMethods.bekle(2);
        extentTest.info("Sepet ikonuna tiklanip Urunun sepete eklendigi dogrulandi");

        //Sepet ikon sayfasinin acildigini dogrula
        softAssert.assertTrue(page.sepetIkonu.isDisplayed());
        ReusableMethods.bekle(2);
        extentTest.pass("Sepet ikon sayfasinin acildigi dogrulandi");
        ReusableMethods.tumSayfaResmi("Sayfa resmi alindi");

        //"View Cart" butonuna tiklayin
        page.viewCartButton.click();
        ReusableMethods.bekle(2);
        extentTest.info("View Cart butonuna tiklandi");

        //Sayfada urun miktarini arttirmak icin "+" isaretine tiklayin
        page.urunArtirmaButton.click();
        ReusableMethods.bekle(2);
        extentTest.info("Sayfada urun miktarini arttirmak icin "+" isaretine tiklandi");

        //Urun miktarinin arttigini dogrulayin
        softAssert.assertTrue(page.urunArtirmaButton.isDisplayed());
        ReusableMethods.bekle(2);
        extentTest.pass("Urun miktarinin arttigi dogrulandi");
        ReusableMethods.tumSayfaResmi("Sayfa resmi alindi");

        //Sayfada urun miktarini azaltmak icin "-" isaretine tiklayin
        page.urunAzaltmaButton.click();
        ReusableMethods.bekle(2);
        extentTest.info("Sayfada urun miktarini azaltmak icin - isaretine tiklandi");

        //Urun miktarinin azaldigini dogrula
        softAssert.assertTrue(page.urunAzaltmaButton.isDisplayed());
        ReusableMethods.bekle(2);
        extentTest.pass("Urun miktarinin azaldigi dogrulandi");
        ReusableMethods.tumSayfaResmi("Sayfa resmi alindi");

        //"Proced To Checkout" butonuna tikla
        page.checkOutButton.click();
        ReusableMethods.bekle(2);
        extentTest.info("Proced To Checkout butonuna tiklandi");

        //"Billing Details" bilgilerinin gorunur oldugunu dogrula
        softAssert.assertTrue(page.billingDetails.isDisplayed());
        ReusableMethods.bekle(2);
        extentTest.pass("Billing Details bilgilerinin gorunur oldugu dogrulandi");
        ReusableMethods.tumSayfaResmi("Sayfa resmi alindi");

        // Odeme yontemi "Wire transfer/EFT" secili ise dogrula
        softAssert.assertTrue(page.eftVerify.isDisplayed());
        ReusableMethods.bekle(2);
        extentTest.pass("Odeme yonteminin Wire transfer/EFT secili oldugu dogrulandi");
        ReusableMethods.tumSayfaResmi("Sayfa resmi alindi");

        //Odeme yontemini "Pay at the door" olarak sec
        page.wireTransferEFT.sendKeys("Pay at the door", Keys.DOWN);
        ReusableMethods.bekle(2);
        extentTest.info("Odeme yontemini Pay at the door olarak secildi");

        // Odeme yontemi "Pay at the door" secili ise dogrula
        softAssert.assertTrue(page.payAtTheDoor.isDisplayed());
        ReusableMethods.bekle(2);
        extentTest.pass("Odeme yontemi Pay at the door secildigi dogrulandi");
        ReusableMethods.tumSayfaResmi("Sayfa resmi alindi");

        //"Place Order" butonuna tikla siparisi onayla
        page.placeOrderButton.click();
        ReusableMethods.bekle(2);
        extentTest.info("Place Order butonuna tiklandi ve siparis onaylandi");

        //Verilen siparis mesajinin gorundugunu dogrula
        softAssert.assertTrue(page.siparisMesajVerify.isDisplayed());
        ReusableMethods.bekle(2);
        extentTest.pass("Verilen siparis mesajinin gorundugu dogrulandi");
        ReusableMethods.tumSayfaResmi("Sayfa resmi alindi");

        //Sipariş detayinin gorundugunu dogrula
        softAssert.assertTrue(page.orderDetails.isDisplayed());
        ReusableMethods.bekle(2);
        extentTest.pass("Sipariş detayinin gorundugu dogrulandi");
        ReusableMethods.tumSayfaResmi("Sayfa resmi alindi");

        //Siparis adresini gorundugunu dogrula
        softAssert.assertTrue(page.billingDetailss.isDisplayed());
        ReusableMethods.bekle(2);
        extentTest.pass("Siparis adresinin gorundugu dogrulandi");
        ReusableMethods.tumSayfaResmi("Sayfa resmi alindi");

        //Sayfayi kapat
        Driver.closeDriver();
        extentTest.info("Sayfa kapatildi");
        extentReports.flush();


    }
}
