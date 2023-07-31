package tests.Oguzhan.US_16;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC01_VendorSimpleProductEklemeTesti extends ExtentReport {
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

//        Üst dropdown menüde Simple Product seçili olduğunu doğrula
        Assert.assertTrue(page.productType.getText().contains("Simple Product"));
        extentTest.pass("Üst dropdown menüde Simple Product seçiili olduğu doğrulandı");

//        Virtual ve Downloadable kutucuklarını seç
        page.virtualCheckbox.click();
        page.downloadableCheckbox.click();
        extentTest.info("Virtual ve Downloadable kutucukları seçildi");

//        Product Title alanına ürün başlığı gir - //Price ve Sale price alanlarını doldur
        page.productTitleInput.sendKeys("mavi ceket", Keys.TAB, "38", Keys.TAB, "29");
        extentTest.info("Product Title alanına ürün başlığı girildi Price ve Sale price alanları dolduruldu");

//        Schedule seçeneğinden tarih aralığı seç
        page.schedule.click();
        page.dateFrom.sendKeys("2023-08-10", Keys.TAB, "2023-08-25");
        extentTest.info("Tarih aralığı seçildi");

        //Short Description alanına  bir yazı gir
        page.descriptionAddMedia.click();
        page.mediaLibrary.click();
        ReusableMethods.bekle(3);
        page.firstLibraryPicture.click();
        page.insertPictureIntoPostButton.click();
        page.shortDescriptonInput.click();
        extentTest.info("Short Description alanına bir metin yazıldı");

        //Description alanına resim ekle
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys("bu bir cekettir", Keys.TAB, Keys.ENTER).perform();
        extentTest.info("Description alanına resim eklendi");

//        Sağ menüden büyük ve küçük resim olmak üzere bilgisayardan iki resim ekle
        ReusableMethods.bekle(2);
        page.addBigPicture.click();
        page.bigPicture.click();
        ReusableMethods.bekle(3);
        page.bigPictureSelectFileButton.click();
        page.addSmallPicture.click();
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB, Keys.TAB,Keys.TAB, Keys.ENTER).perform();
        ReusableMethods.bekle(3);
        page.smallPictureAddToGalleryButton.click();
        extentTest.info("Sağ menüdeki resim ekleme alanına 2 adet ürün resmi eklendi");

//        Categories bölümünden ürünün kategorilerini seç
        page.vakkoCheckBox.click();
        extentTest.info("Ürünün kategorisi seçildi");

//        Product Brands kısmından ürünün markasını seç
        page.lcwCheckBox.click();
        extentTest.info("Ürünün markası seçildi");

//        Tags kısmından birkaç tag seç
        page.productTags.sendKeys("#lcw #jeans");
        extentTest.info("Ürünün tagleri seçildi");

//        Catalog Visibility dropdown menüsünden seçim yap
        ReusableMethods.ddmIndex(page.catalogVisibility, 2);
        extentTest.info("Catalog visibility dropdown menüsünden seçim yapıldı");

        //        Zorunlu alanları doldurmadan ürünü satışa sun
        page.submitProductButton.click();
        ReusableMethods.bekle(3);
        Assert.assertTrue(page.failMessage.isDisplayed());
        extentTest.pass("Zorunlu alanlar doldurulmadan submit'e tıklandı ve hata alındı");

//        Gerekli alanları doldurduktan sonra ürünü satışa sun
        page.downloadable.click();
        page.downloadableName.sendKeys("urun bilgisi");
        page.downloadableUpload.click();
        ReusableMethods.bekle(3);
        actions.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB, Keys.TAB,Keys.TAB, Keys.ENTER).perform();
        page.downloadableSelect.click();
        page.submitProductButton.click();
        ReusableMethods.bekle(2);
        extentTest.pass("Zorunlu alanlar doldurulduktan sonra ürün satışa sunuldu ve success mesajı alındı");

//        Sol Menüden Products sekmesine tıkla
        page.products.click();
        ReusableMethods.bekle(5);
        extentTest.info("Products sekmesine tıklandı");

//        Satışa sunduğumuz ürünün eklendiğini doğrula
        Assert.assertTrue(page.publishedMessage.isDisplayed());
        extentTest.pass("Ürünün satışa sunulduğu doğrulandı");

        Driver.closeDriver();
        extentTest.info("Driver kapatıldı");
    }
}
