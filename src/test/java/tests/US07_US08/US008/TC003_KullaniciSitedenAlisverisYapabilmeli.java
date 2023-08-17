package tests.US07_US08.US008;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;

public class TC003_KullaniciSitedenAlisverisYapabilmeli extends ExtentReport {


    @Test
    public void test01() throws InterruptedException {

        extentTest=extentReports.createTest("US_008","Allower Comerse sitesi test edilebilmeli");

//        AnaSayfaya Git
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Page page = new Page();
        extentTest.info("Anasayfaya gidildi");

//      Urunlerden birinin uzerine gel sepete ekle butonuna tikla
        page.addToCartMens.click();
        extentTest.info("Urunlerden birinin uzerine gel sepete ekle butonuna tiklandi");

//      Sol alt kosede acilan pencere de VIEW CART butonuna tikla
        page.viewCartButton.click();
        extentTest.info("Sol alt kosede acilan pencere de VIEW CART butonuna tiklandi");

//      Shopping Cart sayfasinda oldugunu dogrula
        Assert.assertTrue(page.shoppingCartIsDisplay.isDisplayed());
        extentTest.pass("Shopping Cart sayfasinda oldugunu dogrulandi");

//      Sag alt kosede bulunan PROCEED TO CHECKOUT butonuna tikla
        page.proceedToCheckout.click();
        extentTest.info("Sag alt kosede bulunan PROCEED TO CHECKOUT butonuna tiklandi");

//      Bir onceki sayfaya geri gel
        Thread.sleep(2000);
        Driver.getDriver().navigate().back();
        extentTest.info("Bir onceki sayfaya geri gelindi");

//      Shopping Cart sayfasinda oldugunu dogrula
        Assert.assertTrue(page.shoppingCartIsDisplay.isDisplayed());
        extentTest.pass("Shopping Cart sayfasinda oldugunu dogrulandi");

//      Checkout yazisinin uzerine tikla
        page.checkoutUzerineTikla.click();
        extentTest.info("Checkout yazisinin uzerine tiklandi");

//      Checkout sayfasini dogrula
        Assert.assertTrue(page.billingDetails.isDisplayed());
        extentTest.pass("Checkout sayfasini dogrulandi");

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
//     "Pay at the door " secengine tikla
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
