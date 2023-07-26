package tests.Fatih.US001;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
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

        //Anasayfaya gittigini dogrula
        softAssert.assertTrue(page.anaSayfa.isDisplayed());

        //Register butonuna tıkla
        page.registerButton.click();

        //3	"I agree to the privacy policy" seçenegine tıkla
        page.IAgreeButton.click();

        //4	SIGN UP butonuna tıkla
        page.signUp.click();

        //5	"Lütfen bu alanı doldurun" mesajının görünürlüğünü doğrula(Username alanı)

        //6	Username alanına tıkla  username gir
        page.username.sendKeys(faker.name().firstName());

        //7	SİGN UP butonuna tıkla
        page.signUp.click();

        //8	"Lütfen bu alanı doldurun" mesajının görünürlüğünü doğrula(email alanı)


        //9	e mail alanına  "@"  girmeden bır emaıl gır
        //10	SİGN UP butonuna tıkla
        page.signUp.click();
        //11	Lütfen e-posta adresine bir  @" işareti ekleyin" mesajının görünür oldugunu doğrula
        //12	email'in sonuna @ ekle
        //13	SİGN UP butonuna tıkla
        page.signUp.click();
        //14	"Lütfen  "@" işaretinden sonra gelen kısmı ekleyin"  mesajını doğrula
        //15	email alanına gecerli bır email gir
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[1].toString());
        Driver.getDriver().get(ConfigReader.getProperty("fakeUrl"));
        page.fakeMailCopy.click();

        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[0].toString());
        ReusableMethods.bekle(2);
        page.emailClick.sendKeys(Keys.CONTROL , "v");
        ReusableMethods.bekle(2);

        //16	SİGN UP butonuna tıkla
        page.signUp.click();
        //17	"Lütfen bu alanı doldurun" mesajınin görünürlüğünü dogrula(password alanı)
        //18	Password alanına 9 karakterden az bir password gir.
        //19	"Weak - Please enter a stronger password." mesajının görünürlüğünü dogrula
        //20	"I agree to the privacy policy" seçenegine tıkla
        page.IAgreeButton.click();
        //21	SIGN UP butonuna tıkla
        page.signUp.click();
        //22	Kayıt yapılamadığını doğrula
        //23	Passwor alanındaki passwordu sil.
        page.passwordClick.clear();
        //24	Password alanına 12 karakterli en az bir harf , rakam, spesifik karakter içeren bir password gir.
        //25	SİGN UP butonuna tıkla
        page.signUp.click();
        //26	İlerlemek istiyorsanız lütfen kutuyu işaretleyin mesajını göründüğünü doğrula
        //27	"I agree to the privacy policy" seçenegine tıkla
        page.IAgreeButton.click();
        //28	SİGN UP butonuna tıkla
        page.signUp.click();
        //29	"Register successful, redirecting…" yazısının görünürlüğünü dogrula
        //30	My Account  sayfasını göründüğünü doğrula
    }
}
