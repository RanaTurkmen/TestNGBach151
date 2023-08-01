package tests.mesut.US020;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC01 extends ExtentReport {
    @Test
    public void testUsingCouponAsAVendor() {
        extentTest=extentReports.createTest("UsingCouponAsACostumer","Vendor kuponlari kullanarak alisveris yapabilmeli");
        Page page = new Page();
        Faker faker = new Faker();
        Actions actions = new Actions(Driver.getDriver());
//        Ana sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        ReusableMethods.tumSayfaResmi("HomePage");
        extentTest.info("Anasayfaya gidildi");
//        "Sign in" butonuna tıkla
        page.signInButtonHP.click();
        extentTest.info("Sign in butonuna tiklandi");
//        Email satirina tıkla ve e-posta gir, password gir
        page.emailBox.sendKeys(ConfigReader.getProperty("vendorEmail"), Keys.TAB, ConfigReader.getProperty("vendorPassword"));
        extentTest.info("email ve password alanina veriler girildi");
        //        "Sign in" butonuna tıkla
        page.signIn.click();
        extentTest.info("Sign in butonuna tiklandi");
//        Searchbox alanina urun gir
        ReusableMethods.bekle(5);
        page.searchBox.sendKeys(ConfigReader.getProperty("product1"));
        extentTest.info("Arama kutusunda'macbook air' isminde urun aratildi" );
//        Arama düğmesine tıkla
        page.searchButton.click();
        extentTest.info("search butonuna tiklandi");
        ReusableMethods.bekle(2);
        ReusableMethods.scroll(page.macbookAir);
        ReusableMethods.tumSayfaResmi("searchedProduct");
        page.macbookAir.click();
        extentTest.info("macbook air urun resmine tiklandi");
//        ADD TO CART butonuna tikla
        page.addToCart.click();
        extentTest.info("add to cart butonuna tiklandi");
//        Searchbox alanina tıkla
        ReusableMethods.bekle(3);
        page.searchBox.sendKeys(ConfigReader.getProperty("product2"), Keys.ENTER);
        extentTest.info("Arama kutusunda'purse' isminde urun aratildi" );
        ReusableMethods.bekle(2);
        ReusableMethods.tumSayfaResmi("searchedProduct1");
//        ADD TO CART butonuna tikla
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
        page.addToCart.click();
        extentTest.info("add to cart butonuna tiklandi");
//        Sag ust kosede bulunan "Cart" butonuna tikla
        ReusableMethods.bekle(2);
        page.cartLogo.click();
        extentTest.info("Alisveris arabasi logosuna tiklandi");
//        CHECKOUT butonuna tikla
        ReusableMethods.bekle(3);
        page.checoutButton1.click();
        extentTest.info("checkout butonuna tiklandi");
        // Checkout sayfasinda oldugumuzu dogrula
        String actualResult = Driver.getDriver().getTitle();
        ReusableMethods.tumSayfaResmi("checkoutPage");
        String expectedResult = "Checkout";
        Assert.assertTrue(actualResult.contains(expectedResult));
        extentTest.pass("Checkout sayfasinda bulunuldugu dogrulandi");
//        "ENTER YOUR CODE" yazisina tikla
        page.enterYourCodeButton.click();
        extentTest.info("enter your code butonuna tiklandi");
//        Coupon code alanina kodu yaz
        page.couponCodeTextArea.sendKeys(ConfigReader.getProperty("coupon1"), Keys.ENTER);
        extentTest.info("Coupon code yazildi");
//        Coupon'un uygulandigini dogrula
        ReusableMethods.bekle(5);
        String actualResult1 = page.verifyCoupon.getText();
        ReusableMethods.webElementResmi(page.verifyCoupon);
        String expectedResult1 = "Coupon code applied successfully.";
        Assert.assertEquals(actualResult1, expectedResult1);
        extentTest.pass("Coupon code basariyla uygulandi");
//        "ENTER YOUR CODE" yazisina tikla
        page.enterYourCodeButton.click();
        extentTest.info("enter your code butonuna tiklandi");
        page.couponCodeTextArea.clear();
        extentTest.info("coupon code text area'si temizlendi");
        ReusableMethods.bekle(3);
//        Coupon code alanina ayni codu gir
        page.couponCodeTextArea.sendKeys(ConfigReader.getProperty("coupon1"), Keys.ENTER);
        extentTest.info("ayni copuon code tekrar girildi");
//        Ayni Codun tekrar girilemedigini dogrula
        ReusableMethods.bekle(4);
        String actualResult2 = page.usedCouponVerifying.getText();
        ReusableMethods.webElementResmi(page.usedCouponVerifying);
        String expectedResult2 = "Coupon code already applied!";
        Assert.assertEquals(actualResult2, expectedResult2);
        extentTest.pass("Ayni coupon code'un tekrardan girilemedigi dogrulandi");
//        First name gir,Last name gir,Company name gir
        page.firstNameTextArea.sendKeys(faker.name().firstName(), Keys.TAB, faker.name().lastName(), Keys.TAB, faker.company().name());
//        Street address girPostcode ,City gir ,ZIP gir  ,     Town / City gir ,Phone gir
        extentTest.info("name,lastname, company name girildi");
        page.streetAdress.sendKeys(faker.address().streetAddress(), Keys.TAB, Keys.TAB, faker.address().city(), Keys.TAB, Keys.TAB, faker.address().zipCode(), Keys.TAB, faker.phoneNumber().cellPhone());
        extentTest.info("adres bilgileri girildi");
        //        Payment Methods bolumunden "Wire transfer/EFT" sec(default olarak geliyor)
        extentTest.info("Odeme bolumunden wire transfer/EFT secildi");
//        Toplam odenecek rakami gor
        ReusableMethods.webElementResmi(page.totalAmount);
        Assert.assertTrue(page.totalAmount.isDisplayed());
        extentTest.info("Toplam odenecek tutarin gorundugu dogrulandi");
        ReusableMethods.bekle(2);
//        PLACE ORDER butonuna tikla
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        page.placeOrderButton.click();
        extentTest.info("place order butona tiklandi");
        ReusableMethods.bekle(10);
//        Order'in verildigini dogrula
        String actualResult3 = page.verifyOrder.getText();
        ReusableMethods.tumSayfaResmi("orderVerificationVendor");
        String expectedResult3 = "Thank you. Your order has been received.";
        Assert.assertEquals(actualResult3, expectedResult3);
        extentTest.pass("Basarili bir siparis verildigi dogrulandi");
//        Sayfanin en altinda bulunan My Orders butonuna tikla
        page.myOrdersButton.click();
        extentTest.info("Sayfanin en altinda bulunan myOrder butonuna tiklandi");
//        VIEW butonuna tikla
        page.viewButton.click();
        extentTest.info("order details'i gormek icin view butonuna tiklandi");
//        ORDER DETAILS yazinin goruntulendigini dogrula
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.tumSayfaResmi("Order Details");
        Assert.assertTrue(page.orderDetails.isDisplayed());
        extentTest.pass("Siparis detaylarinin goruntulendigi dogrulandi");
        extentReports.flush();

    }
}
