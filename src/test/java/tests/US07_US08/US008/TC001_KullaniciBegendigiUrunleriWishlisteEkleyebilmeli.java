package tests.US07_US08.US008;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC001_KullaniciBegendigiUrunleriWishlisteEkleyebilmeli extends ExtentReport {

    @Test
    public void test01() throws InterruptedException {

        extentTest=extentReports.createTest("US_008","Allower Comerse sitesi test edilebilmeli");

//        AnaSayfaya Git
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Page page = new Page();
        extentTest.info("Anasayfaya gidildi");

//      Ana sayfa da bulunan bir urunun Kalp butonuna tikla
        page.mensClothingTikla.click();
        page.kalpButtonTikla.click();
        extentTest.info("Ana sayfa da bulunan bir urunun Kalp butonuna tiklandi");

//      Sag ust kosede bulunan Wishlist butonuna tikla
        Thread.sleep(3000);
        page.wishListButton.click();
        extentTest.info("Sag ust kosede bulunan Wishlist butonuna tiklandi");

//      Wishlist sayfasini dogrula
        Assert.assertTrue(page.wishListDogrula.isDisplayed());
        extentTest.pass("Wishlist sayfasini dogrulandi");

//      Sol tarafta bulunan HOME yazisina tikla
        Thread.sleep(2000);
        page.homeButtonTikla.click();
        extentTest.info("Sol tarafta bulunan HOME yazisina tiklandi");

//      Search bolumunde urun arat
        page.serachButton.sendKeys("Phone" + Keys.ENTER);
        extentTest.info("Search bolumunde urun aratildi");

//      Cikan ilk urune tikla,
        page.cikanIlkUrunTikla.click();
        extentTest.info("Cikan ilk urune tiklandi");

//      Açılan sayfada ürün özellikleri altındaki (kalp) butonuna tıkla
        Thread.sleep(2000);
        page.kalpButtonTikla.click();
        extentTest.info("Açılan sayfada ürün özellikleri altındaki (kalp) butonuna tıklandi");

//      Açılan sayfada ürün özellikleri altındaki (kalp) butonuna tekrar tıkla
        Thread.sleep(3000);
        page.kalpButtonTikla2.click();
        extentTest.info("Açılan sayfada ürün özellikleri altındaki (kalp) butonuna tekrar tıklandi");

//      ilk urunun Quick wiev butonuna tikla
        page.quickviewClick.click();
        extentTest.info("ilk urunun Quick wiev butonuna tiklandi");

//      Acilan pencerede urun ozelliklerinin goruntulendigini dogrula
        Thread.sleep(5000);
        Assert.assertTrue(page.urunOzellikDogrulaCase.isDisplayed());
        extentTest.pass("Acilan pencerede urun ozelliklerinin goruntulendigini dogrulandi");

//      Acilan pencerede Add to Cart' butonuna tikla
        page.addToCartButton.click();
        extentTest.info("Acilan pencerede Add to Cart' butonuna tiklandi");

//      has been added to cart yazinin gorunur oldugunu dogrula
        ReusableMethods.visibleWait(page.hasBeenVerify,10);
        Assert.assertTrue(page.hasBeenVerify.isDisplayed());
        extentTest.pass("has been added to cart yazinin gorunur oldugunu dogrulandi");

//      Sol alt tarafta acilan pencere VIEW CART butonuna tikla
        Thread.sleep(1000);
        page.viewCartButton.click();
        extentTest.info("Sol alt tarafta acilan pencere VIEW CART butonuna tiklandi");

//      Shopping Cart yazisinin gorundugunu dogrula
        Assert.assertTrue(page.shoppingCartIsDisplay.isDisplayed());
        extentTest.pass("Shopping Cart yazisinin gorundugunu dogrulandi");

//      Urunlerin sepete eklendigini dogrula
        Assert.assertTrue(page.urunSepeteEklendiginiDogrula.isDisplayed());
        extentTest.pass("Urunlerin sepete eklendigini dogrulandi");

//      Bir onceki sayfaya geri gel
        Driver.getDriver().navigate().back();
        extentTest.info("Bir onceki sayfaya geri gelindi");

//      X butonuna tikla
        page.xButtonTikla.click();
        extentTest.info("X butonuna tiklandi");

//      Add to Cart' butonun gorunurlulugunu dogrula
        Assert.assertTrue(page.addToCartButtonDogrula.isDisplayed());
        extentTest.pass("Add to Cart' butonun gorunurlulugunu dogrulandi");

//      Add to Cart' butonuna tikla
        Thread.sleep(2000);
        page.addToCartButtonDogrula.click();
        extentTest.info("Add to Cart' butonuna tiklandi");

//      has been added to your cart. Yazisini dogrula
        ReusableMethods.visibleWait(page.hasBeenVerifyyy,10);
        Assert.assertTrue(page.hasBeenVerifyyy.getText().contains("has been added to your cart."));
        extentTest.pass("has been added to your cart. Yazisini dogrulandi");


//      VIEW CART butonuna tikla
        page.viewCartButtonTikla.click();
        extentTest.info("VIEW CART butonuna tiklandi");

//      Shopping Cart yazisinin gorundugunu dogrula
        Assert.assertTrue(page.shoppingCartIsDisplay.isDisplayed());
        extentTest.pass("Shopping Cart yazisinin gorundugunu dogrulandi");

    }
}
