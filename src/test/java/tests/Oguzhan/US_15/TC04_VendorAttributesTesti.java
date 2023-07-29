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

public class TC04_VendorAttributesTesti extends ExtentReport {
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

//        Attributes menüsünün görülebilir olduğunu doğrula ve üzerine tıkla
        Assert.assertTrue(page.attributes.isDisplayed());
        page.attributes.click();
        extentTest.pass("Attributes menüsünün görünür olduğu doğrulandı ve üzerine tıklandı");

//        Color seçeneğinin görünür olduğunu doğrula ve üzerine tıkla
        ReusableMethods.bekle(2);
        Assert.assertTrue(page.colorCheckbox.isDisplayed());
        page.colorCheckbox.click();
        extentTest.pass("Color menüsünün görünür olduğu doğrulandı ve üzerine tıklandı");

//        Color alanında input alanına bir renk gir.
        page.colorDropDown.sendKeys("yellow", Keys.TAB);
        extentTest.info("Color alanına bir değer girildi");
//       Select all, select none ve add new butonlarının görünür olduğunu doğrula
        Assert.assertTrue(page.attributesSelectAllButton.isDisplayed());
        Assert.assertTrue(page.attributesAddNewButton.isDisplayed());
        Assert.assertTrue(page.attributesSelectNoneButton.isDisplayed());
        extentTest.pass("Select all, select none ve add new butonlarının görünür olduğu doğrulandı");

//        Visible on the product page kutucuğuna tıkla
        page.attributesVisibleOnProductPageCheckbox.click();
        extentTest.info("Visible on the product page kutucuğuna tıklandı");

//        Active kutucuğunun tikini kaldır
        page.sizeCheckbox.click();
        extentTest.info("Active kutucuğunun seçimi kaldırıldı");

//        Size seçeneğinin görünür olduğunu doğrula
        Assert.assertTrue(page.sizeCheckbox.isDisplayed());
        extentTest.pass("Size seçeneğinin görünür olduğu doğrulandı");

//        Size alanında input alanına bir boyut gir.
        ReusableMethods.bekle(2);
        page.sizeInput.click();
        ReusableMethods.bekle(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).perform();
        extentTest.info("Size alanına değer girildi");

//        Select all, select none ve add new butonlarının görünür olduğunu doğrula
        Assert.assertTrue(page.sizeSelectAllButton.isDisplayed());
        Assert.assertTrue(page.sizeAddNewButton.isDisplayed());
        Assert.assertTrue(page.sizeSelectNoneButton.isDisplayed());
        extentTest.pass("Select all, select none ve add new butonlarının görünür olduğu doğrulandı");

//        Visible on the product page kutucuğuna tıkla
        page.sizeVisibleOnProductPageCheckbox.click();
        extentTest.info("Visible on the product page kutucuğuna tıklandı");

//        Add attribute dropdown seçeneğini seç ve add butonuna tıkla
        page.addAttributeButton.click();
        extentTest.info("Add Attribute dropdownu seçildi ve add butonuna tıklandı");

//        Add attribute penceresinden gerekli alanları doldur
        page.addAttributeName.sendKeys("jeans", Keys.TAB, "%80 pamuk");
        extentTest.info("Add attribute penceresinden gerekli alanlar dolduruldu");

        Driver.closeDriver();
        extentTest.info("Driver kapatıldı");
    }
}
