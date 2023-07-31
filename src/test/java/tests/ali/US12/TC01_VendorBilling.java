package tests.ali.US12;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC01_VendorBilling extends ExtentReport {

    @Test
    public void TC01_VendorBilling() {
        extentTest = extentReports.createTest("TC01","VendorBilling");
        // 1 ==> Ana sayfaya git.
        Driver.getDriver().get(ConfigReader.getProperty("allOverCommerceUrl"));
        extentTest.info("Ana Sayfaya gitti");

        // 2 ==> "Sign in / Register" alanındaki "Sign in" butonuna tıkla.
        Page page = new Page();
        SoftAssert softAssert = new SoftAssert();
        page.signInMainPage.click();
        ReusableMethods.bekle(2);
        extentTest.info("Ana Sayfaya gitti");

        // 3 ==> "Username or email address" alanına geçerli bir mail adresi, "Password" alanına geçerli bir şifre
        //  girdikten sonra "Sign In" butonuna basınca, giriş yapıldığını ve My Account sayfasına girdiğini doğrula.
        page.eMailBox.sendKeys(ConfigReader.getProperty("userName"));
        ReusableMethods.bekle(1);
        page.passwordBox.sendKeys(ConfigReader.getProperty("password"));
        ReusableMethods.bekle(1);
        page.signInButton.click();
        ReusableMethods.bekle(1);
        softAssert.assertTrue(page.signOutButton.isDisplayed());
        extentTest.info("Geçerli mail ve geçerli şifre ile My Account sayfasına gitti.");

        if (!Driver.getDriver().getCurrentUrl().contains("My Account")) {//Eger My Account'u açmamışsa, SignOut'a bas.
            page.signOutButton.click();
            extentTest.fail("Geçerli mail ve geçerli şifre ile My Account sayfasına gitmedi, Ana sayfaya gitti.");
        }

        // 4 ==> "My Account" yazısının görüldüğnüı doğrula.
        softAssert.assertTrue(Driver.getDriver().getTitle().equals("My Account"));//Title ile dogrulama
        ReusableMethods.bekle(1);
        softAssert.assertTrue(page.myAccountText.isDisplayed());//Text ile dogrulama
        ReusableMethods.bekle(1);
        extentTest.info("My Account yazısı görüldü");

        // 5 ==> "My Account" sayfasında "Dashboard" Menüsünde "Addresses" yazısının olduğunu doğrula.
        softAssert.assertTrue(page.addressesText.isDisplayed());
        extentTest.info("Addresses yazısı görüldü");

        // 6 ==> My Account sayfasında Dashboard Menüsünde Addresses yazısına tıkla.
        page.adressesText.click();
        extentTest.info("Addresses yazısına tıklandı");

        // 7 ==> Adresses sayfasının açıldığını doğrula.
        softAssert.assertTrue(page.adressesPage.isDisplayed());
        ReusableMethods.bekle(1);
        extentTest.info("Addresses sayfası açıldı");

        // 8 ==> Billing Address alanında ADD yazısına tıkla.
        page.addText.click();
        ReusableMethods.bekle(3);
        extentTest.info("ADD yazısına tıklandı");

        // 9 ==> Billing adresses sayfasının açıldığını doğrula.
        page.billingAddressPage.isDisplayed();
        extentTest.info("Billing adresses sayfası açıldı");

        // 10 ==> First Name alanına isim gir.
        // 11 ==> Last Name alanına soyisim gir.
        Faker faker = new Faker();
        String name = faker.name().firstName();
        String lastName = faker.name().lastName();
        page.billingFirstName.sendKeys(name, Keys.TAB, lastName, Keys.TAB, ConfigReader.getProperty("company"));
        extentTest.info("First name ve Last name girildi");

        // 12 ==> Country / Region menüsünden ülke seç.
        ReusableMethods.ddmVisibleText(page.countryDdm, "Turkey");
        extentTest.info("Ülke seçimi yapıldı");

        // 13 ==> Street address alanına adres bilgilerini gir.
        // 14 ==> Street address alanının devamına adres bilgilerini gir.
        String addres1 = faker.address().fullAddress();
        String addres2 = faker.address().fullAddress();
        page.streetAddress.sendKeys(addres1);
        page.streetAddress2.sendKeys(addres2);
        extentTest.info("Adres bilgisi girildi");

        // 15 ==> Postcode/zip alanına posta kodu gir.
        page.postcode.sendKeys(ConfigReader.getProperty("postcode"));
        extentTest.info("posta kodu girldi");

        // 16 ==> Town / City alanina şehir bilgisi gir.
        page.town.sendKeys(ConfigReader.getProperty("town"));
        extentTest.info("City alanina Şehir bilgisi girildi");

        // 17 ==>  Province alanına şehir bilgisi gir.
        ReusableMethods.ddmVisibleText(page.provinceDdm, "Ankara");
        extentTest.info("Province alanına şehir bilgisi girildi");

        // 18 ==>  Phone alanına telefon numarası gir.
        page.phoneNumber.sendKeys(ConfigReader.getProperty("phoneNum"));
        extentTest.info("Phone alanına telefon numarası girildi");

        // 19 ==> e-mail adress alanında, kayıt olunan e-mail adresinin otomatik olarak geldiğini doğrula.
        softAssert.assertTrue(page.billingMail.getText().equals(ConfigReader.getProperty("userName")));
        extentTest.info("kayıt olunan e-mail adresinin otomatik olarak geldiğini doğrulandı");

        // 20 ==> save addres butonuna tıkla.
        page.saveAddressButton.submit();
        extentTest.info("save addres butonuna tıklandı");

        // 21 ==> "Address changed successufly" yazısının görüldüğnü doğrula.
        softAssert.assertTrue(page.addressChanged.isDisplayed());
        extentTest.info("Address changed successufly yazısı görüldü");

        // 22 ==> Billing Address ekranında name bilgisinin, kayıt olurken girilen isim olduğunu doğrula.
        softAssert.assertTrue(page.billingName.getText().contains(name));
        extentTest.info("name bilgisinin, kayıt olurken girilen isim olduğunu doğrulandı");

        // 23 ==> Billing Address ekranında address bilgisinin, kayıt olurken girilen adres olduğunu doğrula.
        softAssert.assertTrue(page.billingAddress.getText().contains(addres1));
        extentTest.info("address bilgisinin, kayıt olurken girilen adres olduğunu doğrulandı");

        // 24 ==> Billing Address ekranında city bilgisinin, kayıt olurken girilen şehir olduğunu doğrula.
        softAssert.assertTrue(page.billingCity.getText().contains(ConfigReader.getProperty("province")));
        extentTest.info("city bilgisinin, kayıt olurken girilen şehir olduğunu doğrulandı");

        // 25 ==> Billing Address ekranında Country bilgisinin, kayıt olurken girilen Country olduğunu doğrula.
        softAssert.assertTrue(page.billingCountry.getText().contains("Turkey"));
        extentTest.info("Country bilgisinin, kayıt olurken girilen Country olduğunu doğrulandı");

        // 26 ==> Billing Address ekranında Postcode bilgisinin, kayıt olurken girilen Postcode olduğunu doğrula.
        softAssert.assertTrue(page.billingPostCode.getText().contains(ConfigReader.getProperty("postcode")));
        extentTest.info("Postcode bilgisinin, kayıt olurken girilen Postcode olduğunu doğrulandı");

        // 27 ==> Billing Address ekranında Phone bilgisinin, kayıt olurken girilen Phone olduğunu doğrula.
        softAssert.assertTrue(page.billingPhone.getText().contains(ConfigReader.getProperty("phoneNum")));
        ReusableMethods.tumSayfaResmi("TumSayfaKontrolResmi");
        extentTest.info("Phone bilgisinin, kayıt olurken girilen Phone olduğunu doğrulandı");



    }
}
