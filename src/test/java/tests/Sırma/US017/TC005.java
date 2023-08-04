package tests.Sırma.US017;


import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC005 extends ExtentReport {
    @Test
    public void test01() {
        extentTest=extentReports.createTest("Sırma","Allovercommerce Test Edebilmeli");
        Page page=new Page();
        //Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Allovercommerce sayfasına gidildi");

        //Sayfaya Vendor olarak giriş yap
        page.singIns.click();
        page.emailAdres.sendKeys(ConfigReader.getProperty("emailAdres7"), Keys.TAB,
                ConfigReader.getProperty("sifre7"),Keys.TAB,Keys.ENTER);
        ReusableMethods.bekle(5);
        extentTest.info("Vendor giriş yapıldı");


        //Arama bölümüne  tıkla ve satın alınmak istenen ürünü yaz
        //"Seach" imlecine tıkla
        page.search.sendKeys("LOL DOL");
        page.imleç.click();
        extentTest.info("Arama bölümün yazıldı ve satın alınmak istenen ürün aratıldı");

        //Satın alınmak istenen ürünü seç
        //"BUY NOW" butonuna tıkla
        ReusableMethods.click( page.lolbaby);
        extentTest.info("Arama bölümüne  tıkla ve satın alınmak istenen ürün seçildi");

        //Ürünün sepete eklendiğini doğrula
        ReusableMethods.click(page.sepet);
        extentTest.fail("Ürünün sepete eklendiğini doğrulanamadı");


    }










}
