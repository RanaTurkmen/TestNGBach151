package tests.Fatih.US001;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02_InvalidResgitserIslemi {
    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        Page page = new Page();
        SoftAssert softAssert = new SoftAssert();
        Faker faker = new Faker();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Actions actions = new Actions(Driver.getDriver());

        //Anasayfaya gittigini dogrula
        softAssert.assertTrue(page.anaSayfa.isDisplayed());

        //Register butonuna tıkla
        page.registerButton.click();

        //3	"I agree to the privacy policy" seçenegine tıkla
        page.IAgreeButton.click();

        //4	SIGN UP butonuna tıkla
        page.signUp.click();

        //5	"Lütfen bu alanı doldurun" mesajının görünürlüğünü doğrula(Username alanı)
        String msg = Driver.getDriver().findElement(By.id("username")).getAttribute("validationMessage");
        System.out.println(msg);
        ReusableMethods.bekle(2);
        softAssert.assertTrue(msg.contains("Please fill out this field."));

        //6	Username alanına tıkla  username gir
        page.username.sendKeys(faker.name().firstName());
        ReusableMethods.bekle(2);

        //7	SİGN UP butonuna tıkla
        page.signUp.click();
        ReusableMethods.bekle(2);

        //8	"Lütfen bu alanı doldurun" mesajının görünürlüğünü doğrula(email alanı)
        String msg1 = Driver.getDriver().findElement(By.xpath("(//*[@id='reg_email'])[1]")).getAttribute("validationMessage");
        System.out.println(msg1);
        ReusableMethods.bekle(2);
        softAssert.assertTrue(msg1.contains("Please fill out this field."));

        //9	e mail alanına  "@"  girmeden bır emaıl gır
        page.emailClick.sendKeys(ConfigReader.getProperty("yanlisMail"));
        ReusableMethods.bekle(2);

        //10	SİGN UP butonuna tıkla
        page.signUp.click();
        ReusableMethods.bekle(2);

        //11	Lütfen e-posta adresine bir  @" işareti ekleyin" mesajının görünür oldugunu doğrula
        String msg2 = Driver.getDriver().findElement(By.xpath("(//*[@id='reg_email'])[1]")).getAttribute("validationMessage");
        System.out.println(msg2);
        ReusableMethods.bekle(2);
        softAssert.assertTrue(msg2.contains("Please include an '@' in the email address. 'crowley.aadvikfixedfor' is missing an '@'."));

        //12	email'in sonuna @ ekle
        page.emailClick.clear();
        ReusableMethods.bekle(2);
        page.emailClick.sendKeys(ConfigReader.getProperty("yanlisMail2"));
        ReusableMethods.bekle(2);

        //13	SİGN UP butonuna tıkla
        page.signUp.click();
        ReusableMethods.bekle(2);

        //14	"Lütfen  "@" işaretinden sonra gelen kısmı ekleyin"  mesajını doğrula
        String msg3 = Driver.getDriver().findElement(By.xpath("(//*[@id='reg_email'])[1]")).getAttribute("validationMessage");
        System.out.println(msg3);
        ReusableMethods.bekle(2);
        page.emailClick.clear();
        ReusableMethods.bekle(2);
        softAssert.assertTrue(msg3.contains("Please enter a part following '@'. 'crowley.aadvikfixedfor@' is incomplete."));

        //15	email alanına gecerli bır email gir
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[1].toString());
        Driver.getDriver().get(ConfigReader.getProperty("fakeUrl"));
        page.fakeMailCopy.click();

        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[0].toString());
        ReusableMethods.bekle(2);
        page.emailClick.sendKeys(Keys.CONTROL, "v");
        ReusableMethods.bekle(2);

        //16	SİGN UP butonuna tıkla
        page.signUp.click();

        //17	"Lütfen bu alanı doldurun" mesajınin görünürlüğünü dogrula(password alanı)
        String msg4 = Driver.getDriver().findElement(By.id("password")).getAttribute("validationMessage");
        System.out.println(msg4);
        ReusableMethods.bekle(2);
        softAssert.assertTrue(msg4.contains("Please fill out this field."));

        //18	Password alanına 12 karakterden az bir password gir.
        page.passwordClick.sendKeys(ConfigReader.getProperty("yanlisPassword"));
        ReusableMethods.bekle(2);
        page.signUp.click();
        ReusableMethods.bekle(15);
        page.signOutButton.click();
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();
        js.executeScript("arguments[0].click();", page.cikisYap);
        ReusableMethods.bekle(2);
        Driver.getDriver().findElement(By.xpath("//*[@href='signup']")).click();
        ReusableMethods.bekle(2);
        Driver.getDriver().findElement(By.xpath("//*[@href='signup']")).click();
        ReusableMethods.bekle(2);
        page.username.sendKeys(faker.name().firstName());
        ReusableMethods.bekle(2);
        page.emailClick.sendKeys(faker.internet().emailAddress());
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        page.passwordClick.sendKeys(ConfigReader.getProperty("yanlisPassword"));
        ReusableMethods.bekle(2);

        //19	"Weak - Please enter a stronger password." mesajının görünürlüğünü dogrula
        softAssert.assertTrue(page.passwordVerify.isDisplayed());
        ReusableMethods.bekle(2);

        //20	"I agree to the privacy policy" seçenegine tıkla
        page.IAgreeButton.click();
        ReusableMethods.bekle(2);

        //21	Kayıt yapılamadığını doğrula
        js.executeScript("arguments[0].click();", page.signUp);
        softAssert.assertTrue(page.signUp.isEnabled());
        ReusableMethods.bekle(2);
        page.IAgreeButton.click();
        ReusableMethods.bekle(2);

        //22	Password alanındaki passwordu sil.
        page.passwordClick.clear();
        ReusableMethods.bekle(2);

        //23	Password alanına 12 karakterli en az bir harf , rakam, spesifik karakter içeren bir password gir.
        page.passwordClick.sendKeys(ConfigReader.getProperty("password"), Keys.ENTER);
        ReusableMethods.bekle(2);

        //24	İlerlemek istiyorsanız lütfen kutuyu işaretleyin mesajını göründüğünü doğrula
        String msg5 = Driver.getDriver().findElement(By.xpath("//*[@id='register-policy']")).getAttribute("validationMessage");
        System.out.println(msg5);
        ReusableMethods.bekle(2);
        softAssert.assertTrue(msg5.contains("Please check this box if you want to proceed."));

        //25	"I agree to the privacy policy" seçenegine tıkla
        js.executeScript("arguments[0].click();", page.IAgreeButton);
        ReusableMethods.bekle(2);

        //26	SİGN UP butonuna tıkla
        js.executeScript("arguments[0].click();", page.signUpButton);
        ReusableMethods.bekle(15);
        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP).perform();

        //27	My Account  sayfasını göründüğünü doğrula
        softAssert.assertTrue(page.MyAccount.isDisplayed());
        softAssert.assertAll();
    }
}
