package tests.US15_US16.US_15;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC03_VendorShippingTesti extends ExtentReport {
    @Test
    public void test01() {
        extentTest=extentReports.createTest("Extent Report","Allover test raporu");

//        Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Allover websitesine gidildi");

//        Sign in butonuna tıkla
        Page page = new Page();
        page.signIn.click();
        extentTest.info("Sign In butonuna tıklandı");

//        Siteye giriş yap ve profil sayfasına giriş yap
        page.username.sendKeys(ConfigReader.getProperty("username"), Keys.TAB, ConfigReader.getProperty("password"), Keys.ENTER);
        ReusableMethods.bekle(2);
        page.profileButton.click();
        ReusableMethods.bekle(3);
        extentTest.pass("Başarılı bir şekilde giriş yapıldı");

//        Sol Menüden "Store Manager" bölümüne tıkla
        page.storeManager.click();
        extentTest.info("Store Manager bölümüne tıklandı");

//        "Products" bölümüne tıkla
        page.products.click();
        extentTest.info("Products bölümüne tıklandı");

//        Açılan sayfada "Add New" butonuna tıkla
        page.addNewProduct.click();
        extentTest.info("Add New butonuna tıklandı");

//        Shipping menüsünün görülebilir olduğunu doğrula ve üzerine tıkla
        Assert.assertTrue(page.shipping.isDisplayed());
        page.shipping.click();
        extentTest.pass("Shipping menüsünün görünebilir olduğu doğrulandı ve üzerine tıklandı");

//        Weight alanına kilo değerini gir -  Dimensions alanına cm olarak değerler gir
        page.weight.sendKeys("20", Keys.TAB, "50", Keys.TAB, "10", Keys.TAB, "50");
        extentTest.info("Weight ve Dimensions alanlarına gerekli değerler girildi");

//        Shipping dropdown menüden seçim yap
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.ddmIndex(page.shippingClass, 0);
        extentTest.info("Shipping dropdown menüden seçim yapıldı");

//        Processing Time dropdown menüsünden seçim yap
        ReusableMethods.ddmIndex(page.processingTime, 4);
        extentTest.info("Processing Time dropdown menüden seçim yapıldı");

        Driver.closeDriver();
        extentTest.info("Driver kapatıldı");
    }
}
