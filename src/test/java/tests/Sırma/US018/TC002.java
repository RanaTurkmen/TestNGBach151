package tests.Sırma.US018;

import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC002 extends ExtentReport {
    @Test
    public void test01()  {
        extentTest = extentReports.createTest("Sırma" , "Allovercommerce Test Edebilmeli");

        //Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Allovercommerce sayfasına gidildi");

        //Sayfaya Vendor olarak login ol
        Page page = new Page();
        page.singIns.click();
        page.emailAdres.sendKeys(ConfigReader.getProperty("emailAdres1"), Keys.TAB,
                ConfigReader.getProperty("sifre1"), Keys.TAB, Keys.ENTER);
        extentTest.info("Vendor giriş yapıldı");


        //"SıgnOut" butonuna tıkla
        page.signOut1.click();

        //"Store Manager" butonuna tıkla
        page.storeManager1.click();

        //"Coupons" butonunu üzerine gel
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);
        actions.moveToElement(page.coupons).perform();
        ReusableMethods.visibleWait(page.couponsAdd2,5);
        ReusableMethods.tumSayfaResmi("p1");

        //"Add New"  butonuna tıkla
        page.couponsAdd2.click();

        //"code" kutusuna tıkla ve bensersiz olacak şekilde  ürünün kodunu yaz
        //"Description" kutusuna geç
        //Kutucuğa ürünün açıklamasını yaz
        //"Discount Type" bölümündeki dropdown 'a geç
        //"Fixed Product Discount" seçeneğine seç
        //"Coupon Amount" bölümüne geç
        //İndirim fiyatını gir


        actions.sendKeys(Keys.PAGE_DOWN).perform();
        page.couponCode.sendKeys(ReusableMethods.couponName(), Keys.TAB,
                ConfigReader.getProperty("description"), Keys.TAB,
                "F", Keys.TAB,
                ConfigReader.getProperty("indirim"));

        //"Coupon expiry date" bölümüne geç
        //Açılan popup ekranında "Ay" dropdown'una tıkla
        //İstenilen ay'ı seç
        page.tarih.click();
        ReusableMethods.ddmIndex(page.selectAy, 8);

        //"Yıl" dropdown'una tıkla
        //İstenilen yılı seç
        ReusableMethods.ddmVisibleText(page.selecYıl, "2023");

        //Günlerden istenilen günü sayısına tıkla
        page.gün15.click();
        extentTest.info("Kupon bilgileri girildi");

        //"Allow free shipping" checkbox ına tıkla
        page.checkboxAlow.click();
        ReusableMethods.tumSayfaResmi("p2");

        //Sayfa sonundaki "SUBMIT" butonuna tıkla
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);
        page.submiT.click();
        extentTest.info("Kupon oluşturuldu");

        //Edit Coupon yanında "Fixed product discount" yazısı yazdığını doğrula
        ReusableMethods.bekle(2);
        Assert.assertEquals("Fixed product discount", page.submitVerifyFixed.getText());
        ReusableMethods.webElementResmi(page.submitVerifyFixed);
        extentTest.info("Edit Coupon yanında Fixed product discount yazısı yazdığını doğrulandı");

        //Sayfayı kapat
        Driver.closeDriver();
        extentTest.info("Sayfa kapatıldı");
    }


}
