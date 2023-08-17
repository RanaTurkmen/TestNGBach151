package tests.US17_US18.US018;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;


public class TC001 extends ExtentReport {
    @Test
    public void test01() {
      extentTest = extentReports.createTest("Sırma" , "Allovercommerce Test Edebilmeli");

        //Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        extentTest.info("Allovercommerce sayfasına gidildi");

        //Sayfaya Vendor olarak login ol
        Page page=new Page();
        page.singIns.click();
        page.emailAdres.sendKeys(ConfigReader.getProperty("emailAdres6"), Keys.TAB,
                ConfigReader.getProperty("sifre6"),Keys.TAB,Keys.ENTER);

        extentTest.info("Vendor giriş yapıldı");


        //"SıgnOut" butonuna tıkla
        page.signOut1.click();

        //"Store Manager" butonuna tıkla
        page.storeManager1.click();

        //"Coupons" butonuna tıkla
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.visibleWait(page.coupons,5);
        page.coupons.click();

        //"Coupons Listing" bölümünde sağ üst köşedeki "Add New" butonuna tıkla
        page.couponsAdd.click();


        //Açılan "Add Coupon" sayfasındaki "code"  kutucuğuna benzersiz bir ürün kodu yaz
        //Kutucuğa ürünün kodunu yaz
        //"Description" kutusuna geç
        //Kutucuğa ürünün açıklamasını yaz
        //"Discount Type" bölümündeki dropdown 'a geç
        //"Percetage discoun" seçeneğine seç
        //"Coupon Amount" bölümüne geç
        //İndirim oranını yaz
        //"Coupon expiry date" bölümüne geç
        //Tarih bilgisini YYYY-MM-DD formatında yaz
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        page.couponCode.sendKeys(ReusableMethods.couponName(),Keys.TAB,
                ConfigReader.getProperty("description"),Keys.TAB,Keys.TAB,
                ConfigReader.getProperty("oran"),Keys.TAB,
                ConfigReader.getProperty("sonTarih"),Keys.TAB,Keys.TAB);

        extentTest.info("Kupon bilgileri girildi");
        ReusableMethods.tumSayfaResmi("p1");


        //"Allow free shipping" checkbox ına tıkla
        //Checkbox kutusunun tıklanılabilir olduğunu doğrula
        page.checkboxAlow.click();
        Assert.assertTrue(page.checkboxAlow.isSelected());
        ReusableMethods.tumSayfaResmi("p2");
        extentTest.info("Allow free shipping Checkbox kutusunun tıklanılabilir olduğunu doğrulandı");

        //"Show on store" checkbox ına tıkla
        //Checkbox kutusunun tıklanılabilir olduğunu doğrula
        page.checkboxShow.click();
        Assert.assertTrue(page.checkboxShow.isSelected());
        ReusableMethods.tumSayfaResmi("p3");
        extentTest.info("Show on store Checkbox kutusunun tıklanılabilir olduğunu doğrulandı");


        //Sayfa sonundaki "SUBMIT" butonuna tıkla
        ReusableMethods.click( page.submiT);
        extentTest.info("Kupon oluşturuldu");

        //Sayfa sonunda "Coupon Successfully Published." mesajı çıktığını doğrula
        Assert.assertEquals("Coupon Successfully Published.",page.submitVerify.getText());
        extentTest.info("Sayfa sonunda Coupon Successfully Published. mesajı çıktığını doğrulandı");


        //Edit Coupon yanında "Percentage discount" yazısı yazdığını doğrula
        ReusableMethods.bekle(2);
        Assert.assertEquals("Percentage discount",page.submitVerifyPercent.getText());
        ReusableMethods.tumSayfaResmi("p5");
        extentTest.info("Edit Coupon yanında Percentage discount yazısı yazdığını doğrulandı");

      //Sayfayı kapat
      Driver.closeDriver();
      extentTest.info("Sayfa kapatıldı");

    }

}

