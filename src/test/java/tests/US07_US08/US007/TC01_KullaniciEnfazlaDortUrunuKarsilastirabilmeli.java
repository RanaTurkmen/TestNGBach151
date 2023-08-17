package tests.US07_US08.US007;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;

public class TC01_KullaniciEnfazlaDortUrunuKarsilastirabilmeli extends ExtentReport {



    @Test
    public void test01() throws InterruptedException {

        extentTest=extentReports.createTest("US_007","Allower Comerse sitesi test edilebilmeli");

//        AnaSayfaya Git
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Page page = new Page();
        extentTest.info("Anasayfaya gidildi");

//        Ana sayfa da bulunan bir urunun Compare butonuna tikla
        page.compareTikla.click();
        extentTest.info("Ana sayfa da bulunan bir urunun Compare butonuna tiklandi");

//        1. Urunun eklendigini dogrula
        Assert.assertTrue(page.urunDogrulama1.isDisplayed());
        extentTest.pass("1. Urunun eklendigi dogrulandi");

//        Compare products alanına denk gelmeyecek şekilde sayfaya  tıkla
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("Compare products alanına denk gelmeyecek şekilde sayfaya  tiklandi");

//        Ana sayfa da bulunan bir urunun Compare butonuna tikla
        page.earphoneTikla.click();
        page.earphoneCompare.click();
        extentTest.info("Ana sayfa da bulunan bir urunun Compare butonuna tiklandi");

//        2. Urunun eklendigini dogrula
        Assert.assertTrue(page.urunDogrulama2.isDisplayed());
        extentTest.pass("2. Urunun eklendigi dogrulandi");

//      Compare products alanına denk gelmeyecek şekilde sayfaya tıkla
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("Compare products alanına denk gelmeyecek şekilde sayfaya tıklandi");

//      Ana sayfa da bulunan bir urunun Compare butonuna tikla
        page.cVitaminiTikla.click();
        page.cVitaminiCompare.click();
        extentTest.info("Ana sayfa da bulunan bir urunun Compare butonuna tiklandi");

//        3. Urunun eklendigini dogrula
        Assert.assertTrue(page.urunDogrulama3.isDisplayed());
        extentTest.pass("3. Urunun eklendigini dogrulandi");

//      Compare products alanına denk gelmeyecek şekilde sayfaya tıkla
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("Compare products alanına denk gelmeyecek şekilde sayfaya tıklandi");

//      Ana sayfa da bulunan bir urunun Compare butonuna tikla
        page.chessTikla.click();
        page.chessCompare.click();
        extentTest.info("Ana sayfa da bulunan bir urunun Compare butonuna tiklandi");

//      4. Urunun eklendigini dogrula
        Assert.assertTrue(page.urunDogrulama4.isDisplayed());
        extentTest.pass("4. Urunun eklendigi dogrulandi");

//      Compare products alanına denk gelmeyecek şekilde sayfaya tıkla
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("Compare products alanına denk gelmeyecek şekilde sayfaya tıklandi");

//      Ana sayfa da bulunan bir urunun Compare butonuna tikla
        page.automaticCrusherTikla.click();
        page.automaticCrusherCompare.click();
        extentTest.info("Ana sayfa da bulunan bir urunun Compare butonuna tiklandi");

//      5. Urunun eklendigini dogrula
        Assert.assertTrue(page.urunDogrulama5.isDisplayed());
        extentTest.pass("5. Urunun eklendigi dogrulandi");

//      Compare Products (4 Products) yazisinin gorundugunu dogrula
        Assert.assertTrue(page.products4.isDisplayed());
        extentTest.pass("Compare Products (4 Products) yazisinin gorundugu dogrulandi");

//      Eklenen urunlerden ilkini X butonuna tiklayarak sil
        Thread.sleep(2000);
        page.xButtonDelete.click();
        extentTest.info("Eklenen urunlerden ilkini X butonuna tiklayarak silindi");

//      Compare Products (3 Products) yazisinin gorundugunu dogrula
        Assert.assertTrue(page.products3.isDisplayed());
        extentTest.pass("Compare Products (3 Products) yazisinin gorundugunu dogrulandi");

//      Clean All butonu tikla
        Thread.sleep(1000);
        page.cleanAllButton.click();
        extentTest.info("Clean All butonu tiklandi");

//      Compare Products (0 Products) yazisinin gorundugunu dogrula
        Thread.sleep(2000);
        Assert.assertTrue(page.products0.isDisplayed());
        extentTest.pass("Compare Products (0 Products) yazisinin gorundugunu dogrulandi");

//      Compare products alanına denk gelmeyecek şekilde sayfaya tıkla
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("Compare products alanına denk gelmeyecek şekilde sayfaya tıklandi");

//      Search bolumunde urun arat
        page.serachButton.sendKeys("pencil" + Keys.ENTER);
        extentTest.info("Search bolumunde urun aratildi");

//      Cikan ilk urune tikla,
        page.ilkUrunTikla.click();
        extentTest.info("Cikan ilk urune tiklandi");

//      Compare butonuna tikla
        page.compareTiklaKalem.click();
        extentTest.info("Compare butonuna tiklandi");

//      Onceki sayfaya geri git
        Thread.sleep(2000);
        Driver.getDriver().navigate().back();
        extentTest.info("Onceki sayfaya geri gidildi");

//      Cikan ikinci urune tikla
        Thread.sleep(2000);
        page.ikinciUrunTikla.click();
        extentTest.info("Cikan ikinci urune tiklandi");

//      Compare butonuna tikla
        page.compareTiklaKalem2.click();
        extentTest.info("Compare butonuna tiklandi");

//      START COMPARE ! Butonuna tikla
        Thread.sleep(5000);
        page.startCompareTikla.click();
        extentTest.info("START COMPARE ! Butonuna tiklandi");

//      Compare sayfasina gittigini dogrula
        Thread.sleep(2000);
        Assert.assertTrue(page.compareDogrula.isDisplayed());
        extentTest.pass("Compare sayfasina gittigini dogrulandi");

//      Urunlerin eklendigini dogrula
        Assert.assertTrue(page.urunEklendiginiDogrula.isDisplayed());
        extentTest.pass("Urunlerin eklendigini dogrulandi");

//      Urun ozelliklerini gorundugunu dogrula
        Assert.assertTrue(page.urunOzellikleriniDogrula.isDisplayed());
        extentTest.pass("Urun ozelliklerini gorundugunu dogrulandi");

//      Compare sayfasindaki ilk urunu X butonu ile kaldir
        page.ilkUrunKaldir.click();
        Thread.sleep(2000);
        page.ilkUrunKaldir.click();
        extentTest.info("Compare sayfasindaki ilk urunu X butonu ile kaldirildi");

//      Compare sayfasindaki ikinci urunu X butonu ile kaldir
        Thread.sleep(2000);
        page.ikinciUrunKaldir2.click();
        extentTest.info("Compare sayfasindaki ikinci urunu X butonu ile kaldirildi");

//      No products added to the compare yazisini dogrula
        Assert.assertTrue(page.noProductAdded.isDisplayed());
        extentTest.pass("No products added to the compare yazisi dogrulandi");

    }
}
