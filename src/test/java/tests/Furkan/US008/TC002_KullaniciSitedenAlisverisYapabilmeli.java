package tests.Furkan.US008;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;

public class TC002_KullaniciSitedenAlisverisYapabilmeli extends ExtentReport {

    @Test
    public void test01() throws InterruptedException {

        extentTest=extentReports.createTest("US_008","Allower Comerse sitesi test edilebilmeli");

//        AnaSayfaya Git
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Page page = new Page();
        extentTest.info("Anasayfaya gidildi");

//       Search bolumunde urun arat
        page.searchButtonUrunAra.sendKeys("Laptop" + Keys.ENTER);
        extentTest.info("Search bolumunde urun aratildi");

//      Urunlerden birinin uzerine gel sepete ekle butonuna tikla
        page.pc2SepeteEkle.click();
        extentTest.info("Urunlerden birinin uzerine gel sepete ekle butonuna tiklatildi");

//      Sol alt tarafta acilan pencere CHECKOUT butonuna tikla
        Thread.sleep(2000);
        page.checkoutButton.click();
        extentTest.info("Sol alt tarafta acilan pencere CHECKOUT butonuna tiklandi");

//      Checkout sayfasinin gorundugunu dogrula
        Assert.assertTrue(page.billingDetails.isDisplayed());
        extentTest.pass("Checkout sayfasinin gorundugunu dogrulandi");

//      Bir onceki sayfaya geri gel
        Driver.getDriver().navigate().back();
        extentTest.info("Bir onceki sayfaya geri gelindi");

//      Urunlerden birine tikla
        page.mackbookTikla.click();
        extentTest.info("Urunlerden birine tiklandi");

//      Add to Cart' butonuna tikla
        page.mackbookAddToCart.click();
        extentTest.info("Add to Cart' butonuna tiklandi");

//      Urunlerin eklendingini dogrula
        Assert.assertTrue(page.viewCartIsDisplayed.isDisplayed());
        extentTest.pass("Urunlerin eklendingini dogrulandi");

//      Sag ust kosedeki Cart tikla
        page.cartButtonTiklaa.click();
        extentTest.info("Sag ust kosedeki Cart tiklandi");

//      VIEW CART butonuna tikla
        page.viewCartButton2.click();
        extentTest.info("VIEW CART butonuna tiklandi");

//      Shopping Cart sayfasinda oldugunu dogrula
        Assert.assertTrue(page.shoppingCartIsDisplay.isDisplayed());
        extentTest.pass("Shopping Cart sayfasinda oldugunu dogrulandi");

//      Bir onceki sayfaya geri gel
        Driver.getDriver().navigate().back();
        extentTest.info("Bir onceki sayfaya geri gelindi");

//      CHECKOUT Butonuna tikla
        page.checkoutButton2.click();
        extentTest.info("CHECKOUT Butonuna tiklandi");

//      Checkout sayfasinin gorundugunu dogrula
        Assert.assertTrue(page.billingDetails.isDisplayed());
        extentTest.pass("Checkout sayfasinin gorundugunu dogrulandi");

//      First name gir
        page.firstName.sendKeys("First name" + Keys.TAB + "Last name" + Keys.TAB + Keys.TAB + Keys.TAB +
                "Street" + Keys.TAB + Keys.TAB + "Town" + Keys.TAB + Keys.TAB + "10001" + Keys.TAB + "11128563064" +
                Keys.TAB + "hehehrerrhre@hotmail.com" + Keys.ENTER);

//      Last name gir
//      Country / Region gir
//      Street address gir
//      Postcode / ZIP gir
//      Town / City gir
//      Province gir
//      Phone gir
//      Email address gir
//      Wire transfer/EFT secengine tikla
//      Place order butonuna tikla
        Thread.sleep(3000);
        page.placeOrder.click();
        page.placeOrder.sendKeys(Keys.ENTER);
        extentTest.info("First name girildi...");

//      "Thank you. Your order has been received" Gor
        Thread.sleep(10000);
        Assert.assertTrue(page.thankYou.isDisplayed());
        extentTest.pass("Thank you. Your order has been received Goruldu");

    }
}
