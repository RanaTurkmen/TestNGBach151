package tests.Oguzhan.US_15;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC01_VendorMenuTesti extends ExtentReport{

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

//        "Store Manager" sayfasının açıldığını doğrula
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Store"));
        extentTest.pass("Store Manager sayfası açıldı");

//        Sol Menüde "Products" bölümünün görünür olduğunu doğrula
        Assert.assertTrue(page.products.isDisplayed());
        extentTest.pass("Products bölümü görünürlüğü doğrulandı");

//        "Products" bölümüne tıkla
        page.products.click();
        extentTest.info("Products bölümüne tıklandı");

//        Açılan sayfada "Add New" butonuna tıkla
        page.addNewProduct.click();
        extentTest.info("Add New butonuna tıklandı");

//        Sayfanın altına in
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();

//        Inventory menüsünün görülebilir olduğunu doğrula
        Assert.assertTrue(page.idventory.isDisplayed());
        extentTest.pass("Idventory menüsünün görünürlüğü doğrulandı");

//        Shipping menüsünün görülebilir olduğunu doğrula
        Assert.assertTrue(page.shipping.isDisplayed());
        extentTest.pass("Shipping menüsünün görünürlüğü doğrulandı");

//        Attributes menüsünün görülebilir olduğunu doğrula
        Assert.assertTrue(page.attributes.isDisplayed());
        extentTest.pass("Attributes menüsünün görünürlüğü doğrulandı");

//        Link menüsünün görülebilir olduğunu doğrula
        Assert.assertTrue(page.linked.isDisplayed());
        extentTest.pass("Link menüsünün görünürlüğü doğrulandı");

//        SEO menüsünün görülebilir olduğunu doğrula
        Assert.assertTrue(page.seo.isDisplayed());
        extentTest.pass("SEO menüsünün görünürlüğü doğrulandı");

//        Advanced menüsünün görülebilir olduğunu doğrula
        Assert.assertTrue(page.advanced.isDisplayed());
        extentTest.pass("Advanced menüsünün görünürlüğü doğrulandı");

        Driver.closeDriver();
        extentTest.info("Driver kapatıldı");
    }
}
