package tests.Oguzhan.US_15;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC02_VendorIdventoryTesti extends ExtentReport {
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

//        Inventory menüsünün görülebilir olduğunu doğrula
        Assert.assertTrue(page.idventory.isDisplayed());
        extentTest.pass("Idventory menüsünün görünürlüğü doğrulandı");
        ReusableMethods.bekle(2);
        ReusableMethods.webElementResmi(page.idventory);

//        SKU alanına girdi gir
        page.skuInput.sendKeys("JNS");
        extentTest.info("SKU alanına girdi girildi");

//        "Manage Stock?" kutucuğunu işaretle
        page.manageSkuCheckbox.click();
        extentTest.info("Manage Stock? kutucuğu işaretlendi");

//        "Manage Stock?" kutucuğu işaretlenince "Stock Qty" alanının görünür olduğunu doğrula
        Assert.assertTrue(page.stockQty.isDisplayed());
        extentTest.pass("Stock Qty görünür hale geldiği doğrulandı");
        ReusableMethods.bekle(2);
        ReusableMethods.webElementResmi(page.stockQty);

//        "Stock Qty" alanına değer gir.
        page.stockQty.sendKeys("12");
        extentTest.info("Stock Qty alanına değer girildi");

        //"Allow Backorders" dropdown menü itemlerinin seçilebilir olduğunu doğrula
        ReusableMethods.ddmIndex(page.allowBackorders, 1);
        ReusableMethods.ddmIndex(page.allowBackorders, 2);
        extentTest.pass("Allow Backorders dropdown menülerin seçilebilir olduğu doğrulandı");

//        "Manage Stock" kutucuğunun tikini kaldır ve "Stock Qty" alanının kaybolduğunu doğrula
        page.manageSkuCheckbox.click();
        Assert.assertFalse(page.stockQty.isDisplayed());
        extentTest.pass("Manage Stock kutucuğunun tiki kaldırıldı ve Stock Qty alanının kaybolduğu doğrulandı");

//        "Sold Individually" kutucunun seçilebilir ve seçimin kaldırılabilir olduğunu doğrula
        page.soldIndividuallyCheckbox.click();
        page.soldIndividuallyCheckbox.click();
        extentTest.pass("Sold Individually kutucuğunun seçilebilir ve seçimin kaldırılabilir olduğu doğrulandı");

        Driver.closeDriver();
        extentTest.info("Driver kapatıldı");
    }
}
