package tests.Sırma.US018;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC003 extends ExtentReport {
    @Test
    public void test01() {
        extentTest=extentReports.createTest("Sırma","Allovercommerce Test Edebilmeli");

        //Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));

        //Sayfaya Vendor olarak login ol
        Page page = new Page();
        page.singIns.click();
        page.emailAdres.sendKeys(ConfigReader.getProperty("emailAdres5"), Keys.TAB,
                ConfigReader.getProperty("sifre5"), Keys.TAB, Keys.ENTER);

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

        //"Add New"  butonuna tıkla
        page.couponsAdd2.click();

        //"code"  kutusuna tıkla
        //Kutucuğuna ürünün kodunu yaz
        //"Description" kutusuna geç
        //Kutucuğa ürünün açıklamasını yaz
        //"Discount Type" bölümündeki dropdown 'a geç
        //"Percetage discoun" seçeneğine seç
        //"Coupon Amount" bölümüne geç
        //İndirim oranına 100'den büyük bir sayı yaz

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        page.couponCode.sendKeys(ReusableMethods.couponName(), Keys.TAB,
                ConfigReader.getProperty("description"), Keys.TAB,
                "P", Keys.TAB,
                ConfigReader.getProperty("oran2"));

        //"Coupon expiry date" bölümüne geç
        page.tarih.click();

        //Açılan popup ekranında sağ taraftaki "Ok"  butonu  2 kez tıkla
        actions.doubleClick(page.nextSağ).perform();

        //Günlerden istenilen günü sayısına tıkla
        page.gün20.click();
       ReusableMethods.bekle(2);
        extentTest.info("Kupon bilgileri girildi");

        //Sayfa sonundaki "SUBMIT" butonuna tıkla
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(2);
        page.submiT.click();
        ReusableMethods.bekle(3);
        extentTest.info("Kupon oluşturuldu");

        //Sayfanın sağındaki "Cupouns" butonuna tıkla
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.visibleWait(page.coupons,5);
        page.coupons.click();

        //Oluşturulan kupon bligilerinin listede olduğunu doğrula
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(page.couponVerfyCouponAdı.isDisplayed());
        ReusableMethods.tumSayfaResmi("p1");
        extentTest.info("Oluşturulan kupon bligilerinin listede olduğunu doğrulandı");

        //"Amount" kısmında sayının "0" olduğunu doğrula
        Assert.assertEquals("0", page.couponVerfyOran.getText());
        ReusableMethods.webElementResmi(page.couponVerfyOran);
        extentTest.info("Percentace discount seçili iken Coupon Amount'ın 100 den büyük olmadığı doğrulandı");

        //Sayfayı kapat
        Driver.closeDriver();
        extentTest.info("Sayfa kapatıldı");


    }

}
