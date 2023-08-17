package tests.US19_US20.US019;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;


public class TC01 extends ExtentReport{

    @Test
    public void testUsingCouponAsACostumer () {
        extentTest=extentReports.createTest("UsingCouponAsACostumer","Musteri kuponlari kullanarak alisveris yapabilmeli");
        Page page = new Page();
        Faker faker = new Faker();


//        Ana sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        ReusableMethods.tumSayfaResmi("HomePage");
        extentTest.info("Anasayfaya gidildi");
        page.signInButtonHP.click();
        extentTest.info("Sign in butonuna tiklandi");
//        Username or email address gir , Password gir
        page.emailBox.sendKeys(ConfigReader.getProperty("email"), Keys.TAB, ConfigReader.getProperty("password"));
        extentTest.info("email ve password alanina veriler girildi");
//        SIGN IN tikla
        page.signIn.click();
        extentTest.info("sign in butonuna tiklandi");
//        SearchBox satırında urun arat(pencil),Entera tikla
        ReusableMethods.bekle(5);
        page.searchBox.sendKeys(ConfigReader.getProperty("product"), Keys.ENTER);
        extentTest.info("Arama kutusunda'pencil' isminde urun aratildi" );
//        pencil6 urun resmine tikla
        ReusableMethods.bekle(3);
        ReusableMethods.tumSayfaResmi("searchedProduct");
        page.pencil6.click();
        extentTest.info("'pencil6' isimli urune tiklandi");
//        "ADD TO CART" butonuna tıkla
        page.addToCart.click();
        extentTest.info("add to cart butonuna tiklandi");
//        "pencil6" urununun sepete eklendigini dogrula
        ReusableMethods.visibleWait(page.verifyingOfAddingProductToCart, 10);
        String actualResult = page.verifyingOfAddingProductToCart.getText();
        ReusableMethods.webElementResmi(page.verifyingOfAddingProductToCart);
        String expectedResult = "“Pencil6” has been added to your cart.";
        Assert.assertTrue(actualResult.contains(expectedResult));
        extentTest.pass("'Pencil6' urunu sepete eklendi");
//        Sag ust kosede "Cart" butonuna tıkla
        page.cartLogo.click();
        extentTest.info("Alisveris arabasi logosuna tiklandi");
//        "View cart" butonuna tıkla
        ReusableMethods.bekle(3);
        page.viewCart.click();
        extentTest.info("viewCart butonuna tiklandi");
        int numOfPreviousProducts = Integer.parseInt(page.cartQuantity.getText());//eski urun sayisi
        extentTest.info("urun sayisi belirlendi");
        ReusableMethods.webElementResmi(page.cartLogo);
//        Miktar artı(+) butonuna tikla
        page.plusIcon.click();
        extentTest.info("'+' butonuna tiklandi");
//        "Update cart" butonuna tıkla
        ReusableMethods.bekle(3);
        page.updateCart.click();
        extentTest.info("updateCart butonuna tiklandi");
        ReusableMethods.bekle(10);
//        Sag ust kosede bulunan Cart butonundan urun sayisinin 2 oldugunu dogrula
        int numOfNewProducts = Integer.parseInt(page.cartQuantity.getText());//yeni urun sayisi
        extentTest.info("yeni urun sayisi belirlendi");
        ReusableMethods.webElementResmi(page.cartLogo);
        Assert.assertTrue(numOfNewProducts > numOfPreviousProducts);
        extentTest.pass("Urun sayisinin bir arttigi dogrulandi");
//        Miktar artı(-) butonuna tikla
        page.minusIcon.click();
        extentTest.info("'-' butonuna basildi");
//        "Update cart" butonuna tıkla
        page.updateCart.click();
        extentTest.info("updateCart butonuna tiklandi");
        ReusableMethods.bekle(10);
//        Sag ust kosede bulunan Cart butonundan urunun 1 azaldigini dogrula
        int numOfNewerProducts = Integer.parseInt(page.cartQuantity.getText());
        extentTest.info("yeni urun sayisi belirlendi");
        ReusableMethods.webElementResmi(page.cartLogo);
        Assert.assertEquals(numOfPreviousProducts, numOfNewerProducts);
        extentTest.pass("Urun sayisinin bir azaldigi dogrulandi");
//        Miktar artı(-) butonuna tikla
        page.minusIcon.click();
        extentTest.info("'-' butonuna basildi");
        int numOfNewerProducts1 = Integer.parseInt(page.cartQuantity.getText());
        extentTest.info("yeni urun sayisi belirlendi");
        ReusableMethods.webElementResmi(page.cartQuantity);
//        Miktarin 0 olmadigini dogrula
        Assert.assertEquals(numOfNewerProducts, numOfNewerProducts1);
        extentTest.pass("Urun sayisinin degismedigi dogrulandi");
//        COUPON DISCOUNT altina bir coupon gir
        page.couponCodeTextArea.sendKeys(ConfigReader.getProperty("coupon"));
        extentTest.info("Coupon code girildi");
        ReusableMethods.webElementResmi(page.couponCodeTextArea);
//        "APPLY COUPON" butonuna tikla
        page.applyCoupon.click();
        extentTest.info("apply Coupon tusuna basildi");
//        Coupon code'unun basariyla girildigini dogrula
        ReusableMethods.bekle(5);
        String actualResult1 = page.verifyCoupon.getText();
        String expectedResult1 = "Coupon code applied successfully.";
        ReusableMethods.tumSayfaResmi("couponApplied");
        Assert.assertEquals(actualResult1, expectedResult1);
        extentTest.pass("coupon code'un basariyla uygulandigi dogrulandi");
//        CART TOTALS alanindan [Remove] yap
        page.removeCoupon.click();
        extentTest.info("removeCoupon tusuna basildi");
//        Coupon'un kaldirildigini dogrula
        ReusableMethods.bekle(3);
        String actualResult2 = page.verifyCoupon.getText();
        String expectedResult2 = "Coupon has been removed.";
        ReusableMethods.tumSayfaResmi("couponRemoved");
        Assert.assertEquals(actualResult2, expectedResult2);
        extentTest.pass("Coupon Code'un kaldirildigi dogrulandi");
//        "PROCEED TO CHECKOUT" butonuna tıkla
        ReusableMethods.bekle(3);
        page.checkoutButton.click();
        extentTest.info("checkout butonuna tiklandi");
        ReusableMethods.bekle(2);
//        Checkout sayfasinda oldugunu dogrula
        ReusableMethods.tumSayfaResmi("checkoutPage");
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Checkout"));
        extentTest.pass("Checkout sayfasinda bulunuldugu dogrulandi");

//        "ENTER YOUR CODE" yazisina tikla
        page.enterYourCodeButton.click();
        extentTest.info("enter your code butonuna tiklandi");
//        Coupon code alanina kodu yaz,Entera bas
        page.couponCodeTextArea.sendKeys(ConfigReader.getProperty("coupon"), Keys.ENTER);
        extentTest.info("Coupon code yazildi");
        ReusableMethods.bekle(5);
//        coupon code'unun basariyla girildigini dogrula
        String actualResult3 = page.verifyCoupon.getText();
        String expectedResult3 = "Coupon code applied successfully.";
        ReusableMethods.tumSayfaResmi("couponAppliedAgain");
        Assert.assertEquals(actualResult3, expectedResult3);
        extentTest.pass("Coupon code tekrardan uygulandi");
//        First name gir,Last name gir,Company name gir
        page.firstNameTextArea.sendKeys(faker.name().firstName(), Keys.TAB, faker.name().lastName(), Keys.TAB, faker.company().name());
        extentTest.info("name,lastname, company name girildi");
//        Street address girPostcode ,City gir ,ZIP gir  ,     Town / City gir ,Phone gir
        page.streetAdress.sendKeys(faker.address().streetAddress(), Keys.TAB, Keys.TAB, faker.address().city(), Keys.TAB, Keys.TAB, faker.address().zipCode(), Keys.TAB, faker.phoneNumber().cellPhone());
        extentTest.info("adres bilgileri girildi");
        //        Payment Methods bolumunden "Pay at the door" sec
        ReusableMethods.bekle(5);
        page.payAtTheDoor.click();
        extentTest.info("pay at the door odeme secenegi secildi");
        ReusableMethods.bekle(2);
//        PLACE ORDER butonuna tikla
        page.placeOrderButton.click();
        extentTest.info("place order butona tiklandi");
        ReusableMethods.bekle(10);
//        Siparisin verildigini dogrula
        String actualResult4 = page.verifyOrder.getText();
        String expectedResult4 = "Thank you. Your order has been received.";
        ReusableMethods.tumSayfaResmi("orderVerification");
        Assert.assertEquals(actualResult4, expectedResult4);
        extentTest.pass("Basarili bir siparis verildigi dogrulandi");
        extentReports.flush();

    }
}
