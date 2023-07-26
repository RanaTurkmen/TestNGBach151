package tests.Fatih.US002;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01_InvalidRegisterIslemi {
    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        Page page = new Page();
        SoftAssert softAssert = new SoftAssert();

        //Anasayfaya gittigini dogrula
        softAssert.assertTrue(page.anaSayfa.isDisplayed());

        //Register butonuna tıkla
        page.registerButton.click();

        //Username alanına tıkla ve kayıtlı username gir
        page.username.sendKeys(ConfigReader.getProperty("kayitliusername"));

        //Email alanına tıkla  ve kayıtlı email gir
        page.emailClick.sendKeys(ConfigReader.getProperty("kayitliMail"));

        //Password alanına tıkla geçerli password gir
        page.passwordClick.sendKeys(ConfigReader.getProperty("password"));

        //"I agree to the privacy policy" seçenegine tıkla
        page.IAgreeButton.click();

        //SIGN UP butonuna tıkla
        page.signUp.click();
        ReusableMethods.bekle(2);

        //An account is already registered with your email address mesajının göründüğünü doğrula.
        softAssert.assertTrue(page.kayitliHesap.isDisplayed());

        // Email alanına tıkla  ve kayıtlı olmayan email gir
        page.emailClick.clear();
        ReusableMethods.bekle(2);
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[1].toString());
        Driver.getDriver().get(ConfigReader.getProperty("fakeUrl"));
        page.fakeMailCopy.click();
        ReusableMethods.bekle(3);
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[0].toString());
        ReusableMethods.bekle(2);
        page.emailClick.sendKeys(Keys.CONTROL , "v");
        ReusableMethods.bekle(2);

        //SIGN UP butonuna tıkla
        page.signUp.click();

        //"An account is already registered with that username. Please choose another." mesajının göründüğünü doğrula.
        softAssert.assertTrue(page.kayitliHesap.isDisplayed());
        softAssert.assertAll();
    }
}
