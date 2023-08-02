package tests.Fatih.US001;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

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

        //1 Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        ReusableMethods.bekle(2);

        //2 Register butonuna tıkla
        page.registerButton.click();
        ReusableMethods.bekle(2);
        extentTest.info("Register butonuna tiklandi");

        //3	SIGN UP butonuna tıkla
        page.signUp.click();
        ReusableMethods.bekle(2);
        extentTest.info("Sign Up butonuna tiklandi");

        //4	"Lütfen bu alanı doldurun" mesajını doğrula(Username alanı)
        String msg = page.username.getAttribute("validationMessage");
        ReusableMethods.tumSayfaResmi("US001-TC02 Username");
        System.out.println(msg);
        ReusableMethods.bekle(2);
        softAssert.assertTrue(msg.contains("Please fill out this field."));
        extentTest.pass("Hata mesaji alindi ve test edildi");

        //5	Username alanına tıkla  username gir
        page.username.sendKeys(faker.name().firstName());
        ReusableMethods.bekle(2);
        extentTest.info("Username alanina tiklandi ve gecerli bir username girildi");

        //6	SİGN UP butonuna tıkla
        page.signUp.click();
        ReusableMethods.bekle(2);
        extentTest.info("Sign Up butonuna tiklandi");

        //7	"Lütfen bu alanı doldurun" mesajını doğrula(email alanı)
        String msg1 = page.emailClick.getAttribute("validationMessage");
        ReusableMethods.tumSayfaResmi("US001-TC02 Email");
        System.out.println(msg1);
        ReusableMethods.bekle(2);
        softAssert.assertTrue(msg1.contains("Please fill out this field."));
        extentTest.pass("Hata mesaji alindi ve test edildi");

        //8	e mail alanına  "@"  girmeden bır emaıl gır
        page.emailClick.sendKeys(ConfigReader.getProperty("yanlisMail"));
        ReusableMethods.bekle(2);
        extentTest.info("Email alanina tiklandi ve gecersiz bir email girildi");

        //9	SİGN UP butonuna tıkla
        page.signUp.click();
        ReusableMethods.bekle(2);
        extentTest.info("Sign Up butonuna tiklandi");

        //10	Lütfen e-posta adresine bir  @" işareti ekleyin" mesajını doğrula
        String msg2 = page.emailClick.getAttribute("validationMessage");
        ReusableMethods.tumSayfaResmi("US001-TC02 Email @ isareti");
        System.out.println(msg2);
        ReusableMethods.bekle(2);
        softAssert.assertTrue(msg2.contains("Please include an '@' in the email address. 'crowley.aadvikfixedfor' is missing an '@'."));
        extentTest.pass("Hata mesaji alindi ve test edildi");

        //11	email'in sonuna @ ekle
        page.emailClick.clear();
        ReusableMethods.bekle(2);
        page.emailClick.sendKeys(ConfigReader.getProperty("yanlisMail2"));
        ReusableMethods.bekle(2);
        extentTest.info("Email alanina tiklandi ve hatali email'in sonuna @ isareti eklendi");

        //12	SİGN UP butonuna tıkla
        page.signUp.click();
        ReusableMethods.bekle(2);
        extentTest.info("Sign Up butonuna tiklandi");

        //13	"Lütfen  "@" işaretinden sonra gelen kısmı ekleyin"  mesajını doğrula
        String msg3 = page.emailClick.getAttribute("validationMessage");
        ReusableMethods.tumSayfaResmi("US001-TC02 Email @ isaretinden sonra ki kisim");
        System.out.println(msg3);
        ReusableMethods.bekle(2);
        page.emailClick.clear();
        ReusableMethods.bekle(2);
        softAssert.assertTrue(msg3.contains("Please enter a part following '@'. 'crowley.aadvikfixedfor@' is incomplete."));
        extentTest.pass("Hata mesaji alindi ve test edildi");

        //14	email alanına unique bır email gir
        ReusableMethods.fakeMail();
        extentTest.info("Email alanina tiklandi ve gecerli bir email girildi");

        //15	SİGN UP butonuna tıkla
        page.signUp.click();
        ReusableMethods.bekle(2);
        extentTest.info("Sign Up butonuna tiklandi");

        //16	"Lütfen bu alanı doldurun" mesajınin yazisini dogrula(password alanı)
        String msg4 = page.passwordClick.getAttribute("validationMessage");
        ReusableMethods.tumSayfaResmi("US001-TC02 Password");
        System.out.println(msg4);
        ReusableMethods.bekle(2);
        softAssert.assertTrue(msg4.contains("Please fill out this field."));
        extentTest.pass("Hata mesaji alindi ve test edildi");

        //17	Password kriterlerine uymayan bir password gir.
        page.passwordClick.sendKeys(ConfigReader.getProperty("gecersizPassword"));
        ReusableMethods.bekle(2);
        extentTest.pass("Password kriterlerine uymayan hatali bir password girildi");

        //18    "Please enter a stronger password."mesajın görünürlüğünü dogrula.
        softAssert.assertTrue(page.passwordVerify.isDisplayed() , "Gecersiz password'de mesaj gorulmedi");
        extentTest.fail("Please enter a stronger password mesaji gorulmedi");
        softAssert.assertAll();

        //19    Hint: The password should be at least twelve characters long. To make it stronger, use upper and lower
        // case letters, numbers, and symbols like ! " ? $ % ^ & ). Mesajın gorundugunu dogrula
        softAssert.assertTrue(page.passwordUyariVerify.getText().
                contains("The password should be at least twelve characters long. To make it stronger, use upper and lower" +
                "case letters, numbers, and symbols like !  ? $ % ^ & )"));
        extentTest.fail("Uyari mesaji alindi ve gorunurlugu dogrulandi");

        //20    Sign Up botonunun tiklanamadigini dogrula
        softAssert.assertFalse(page.signUp.isEnabled() , "SIGN UP tiklanabilir");
        extentTest.fail("SIGN UP tiklanabilir");
        ReusableMethods.bekle(2);

        //21	Password alanındaki passwordu sil.
        page.passwordClick.clear();
        ReusableMethods.bekle(2);
        extentTest.info("Password alanindaki gecersiz password silindi");

        //22	Password alanına 12 karakterli en az bir harf , rakam, spesifik karakter içeren bir password gir.
        page.passwordClick.sendKeys(ConfigReader.getProperty("password"), Keys.ENTER);
        ReusableMethods.bekle(2);
        extentTest.info("Password alanina kriterlere uyan bir password basarili bir sekilde girildi");

        //23	SİGN UP butonuna tıkla
        js.executeScript("arguments[0].click();", page.signUpButton);
        ReusableMethods.bekle(5);
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();
        extentTest.info("Sign Up butonuna tiklandi");

        //24	İlerlemek istiyorsanız lütfen kutuyu işaretleyin mesajını doğrula
        String msg5 = Driver.getDriver().findElement(By.xpath("//*[@id='register-policy']")).getAttribute("validationMessage");
        System.out.println(msg5);
        ReusableMethods.bekle(2);
        softAssert.assertTrue(msg5.contains("Please check this box if you want to proceed."));
        extentTest.pass("Hata mesaji alindi ve test edildi");
        extentReports.flush();
    }
}
