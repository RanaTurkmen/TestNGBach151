package tests.Fatih.US001;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.ReusableMethods;

public class TC02_InvalidResgitserIslemi extends ExtentReport {
    @Test
    public void test01() {
        extentTest = extentReports.createTest("Fatih" , "Allovercommerce Test Edebilmeli");
        Page page = new Page();
        SoftAssert softAssert = new SoftAssert();
        Faker faker = new Faker();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Actions actions = new Actions(Driver.getDriver());

        //Anasayfaya gittigini dogrula
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        softAssert.assertTrue(page.anaSayfa.isDisplayed());
        extentTest.pass("Ana Sayfaya gidildi ve dogrulandi");

        //Register butonuna tıkla
        page.registerButton.click();
        extentTest.info("Register butonuna tiklandi");

        //3	"I agree to the privacy policy" seçenegine tıkla
        page.IAgreeButton.click();
        extentTest.info("I Agree butonuna tiklandi");

        //4	SIGN UP butonuna tıkla
        page.signUp.click();
        extentTest.info("Sign Up butonuna tiklandi");

        //5	"Lütfen bu alanı doldurun" mesajının görünürlüğünü doğrula(Username alanı)
        String msg = Driver.getDriver().findElement(By.id("username")).getAttribute("validationMessage");
        System.out.println(msg);
        ReusableMethods.bekle(2);
        softAssert.assertTrue(msg.contains("Please fill out this field."));
        extentTest.pass("Hata mesaji alindi ve test edildi");

        //6	Username alanına tıkla  username gir
        page.username.sendKeys(faker.name().firstName());
        ReusableMethods.bekle(2);
        extentTest.info("Username alanina tiklandi ve gecerli bir username girildi");

        //7	SİGN UP butonuna tıkla
        page.signUp.click();
        ReusableMethods.bekle(2);
        extentTest.info("Sign Up butonuna tiklandi");

        //8	"Lütfen bu alanı doldurun" mesajının görünürlüğünü doğrula(email alanı)
        String msg1 = Driver.getDriver().findElement(By.xpath("(//*[@id='reg_email'])[1]")).getAttribute("validationMessage");
        System.out.println(msg1);
        ReusableMethods.bekle(2);
        softAssert.assertTrue(msg1.contains("Please fill out this field."));
        extentTest.pass("Hata mesaji alindi ve test edildi");

        //9	e mail alanına  "@"  girmeden bır emaıl gır
        page.emailClick.sendKeys(ConfigReader.getProperty("yanlisMail"));
        ReusableMethods.bekle(2);
        extentTest.info("Email alanina tiklandi ve gecersiz bir email girildi");

        //10	SİGN UP butonuna tıkla
        page.signUp.click();
        ReusableMethods.bekle(2);
        extentTest.info("Sign Up butonuna tiklandi");

        //11	Lütfen e-posta adresine bir  @" işareti ekleyin" mesajının görünür oldugunu doğrula
        String msg2 = Driver.getDriver().findElement(By.xpath("(//*[@id='reg_email'])[1]")).getAttribute("validationMessage");
        System.out.println(msg2);
        ReusableMethods.bekle(2);
        softAssert.assertTrue(msg2.contains("Please include an '@' in the email address. 'crowley.aadvikfixedfor' is missing an '@'."));
        extentTest.pass("Hata mesaji alindi ve test edildi");

        //12	email'in sonuna @ ekle
        page.emailClick.clear();
        ReusableMethods.bekle(2);
        page.emailClick.sendKeys(ConfigReader.getProperty("yanlisMail2"));
        ReusableMethods.bekle(2);
        extentTest.info("Email alanina tiklandi ve hatali email'in sonuna @ isareti eklendi");

        //13	SİGN UP butonuna tıkla
        page.signUp.click();
        ReusableMethods.bekle(2);
        extentTest.info("Sign Up butonuna tiklandi");

        //14	"Lütfen  "@" işaretinden sonra gelen kısmı ekleyin"  mesajını doğrula
        String msg3 = Driver.getDriver().findElement(By.xpath("(//*[@id='reg_email'])[1]")).getAttribute("validationMessage");
        System.out.println(msg3);
        ReusableMethods.bekle(2);
        page.emailClick.clear();
        ReusableMethods.bekle(2);
        softAssert.assertTrue(msg3.contains("Please enter a part following '@'. 'crowley.aadvikfixedfor@' is incomplete."));
        extentTest.pass("Hata mesaji alindi ve test edildi");

        //15	email alanına gecerli bır email gir
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[1].toString());
        Driver.getDriver().get(ConfigReader.getProperty("fakeUrl"));
        page.fakeMailCopy.click();
        extentTest.info("Fake mail sayfasina gidildi ve gecerli bir email alindi");

        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[0].toString());
        ReusableMethods.bekle(2);
        page.emailClick.sendKeys(Keys.CONTROL, "v");
        ReusableMethods.bekle(2);
        extentTest.info("Email alanina tiklandi ve gecerli bir email girildi");

        //16	SİGN UP butonuna tıkla
        page.signUp.click();
        extentTest.info("Sign Up butonuna tiklandi");

        //17	"Lütfen bu alanı doldurun" mesajınin görünürlüğünü dogrula(password alanı)
        String msg4 = Driver.getDriver().findElement(By.id("password")).getAttribute("validationMessage");
        System.out.println(msg4);
        ReusableMethods.bekle(2);
        softAssert.assertTrue(msg4.contains("Please fill out this field."));
        extentTest.pass("Hata mesaji alindi ve test edildi");

        //18	Password alanına 12 karakterden az bir password gir.
        page.passwordClick.sendKeys(ConfigReader.getProperty("yanlisPassword"));
        ReusableMethods.bekle(2);
        extentTest.pass("Password kriterlerine uymayan hatali bir password girildi");

        //19    Giris yapilmadigini dogrula
        js.executeScript("arguments[0].click();", page.signUp);
        ReusableMethods.bekle(15);
        ReusableMethods.tumSayfaResmi("Giris");
        extentTest.info("Ekran goruntusu alindi");
        softAssert.assertFalse(page.signOutButton.isDisplayed() , "GIRIS YAPILDI");
        extentTest.fail("Giris yapilmadi");
        softAssert.assertAll();

        //22	"Weak - Please enter a stronger password." mesajının görünürlüğünü dogrula
        softAssert.assertTrue(page.passwordVerify.isDisplayed());
        ReusableMethods.bekle(2);
        extentTest.info("Weak - Please enter a stronger password. mesaji alindi ve test edildi");

        //23	"I agree to the privacy policy" seçenegine tıkla
        js.executeScript("arguments[0].click();", page.IAgreeButton);
        ReusableMethods.bekle(2);
        extentTest.info("I Agree butonuna tiklandi");

        //24	Kayıt yapılamadığını doğrula
        js.executeScript("arguments[0].click();", page.signUp);
        softAssert.assertTrue(page.signUp.isEnabled());
        ReusableMethods.bekle(2);
        extentTest.pass("Kayit yapilamadigi dogrulandi");
        js.executeScript("arguments[0].click();", page.IAgreeButton);
        ReusableMethods.bekle(2);
        extentTest.info("I Agree butonuna tiklandi");

        //25	Password alanındaki passwordu sil.
        page.passwordClick.clear();
        ReusableMethods.bekle(2);
        extentTest.info("Password alanindaki hatali password silindi");

        //26	Password alanına 12 karakterli en az bir harf , rakam, spesifik karakter içeren bir password gir.
        page.passwordClick.sendKeys(ConfigReader.getProperty("password"), Keys.ENTER);
        ReusableMethods.bekle(2);
        extentTest.info("Password alanina kriterlere uyan bir password basarili bir sekilde girildi");

        //27	İlerlemek istiyorsanız lütfen kutuyu işaretleyin mesajını göründüğünü doğrula
        String msg5 = Driver.getDriver().findElement(By.xpath("//*[@id='register-policy']")).getAttribute("validationMessage");
        System.out.println(msg5);
        ReusableMethods.bekle(2);
        softAssert.assertTrue(msg5.contains("Please check this box if you want to proceed."));
        extentTest.pass("Hata mesaji alindi ve test edildi");

        //28	"I agree to the privacy policy" seçenegine tıkla
        js.executeScript("arguments[0].click();", page.IAgreeButton);
        ReusableMethods.bekle(2);
        extentTest.info("I Agree butonuna tiklandi");

        //29	SİGN UP butonuna tıkla
        js.executeScript("arguments[0].click();", page.signUpButton);
        ReusableMethods.bekle(15);
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();
        extentTest.info("Sign Up butonuna tiklandi");

        //30	My Account  sayfasını göründüğünü doğrula
        softAssert.assertTrue(page.MyAccount.isDisplayed());
        extentTest.pass("Hesaba basarili bir sekilde giris yapildi ve My Account yazisinin gorunurlugu test edildi");
        extentReports.flush();
    }
}
