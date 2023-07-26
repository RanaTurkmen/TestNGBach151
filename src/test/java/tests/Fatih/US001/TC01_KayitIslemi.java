package tests.Fatih.US001;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01_KayitIslemi {
    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("alloverCommerceUrl"));
        Page page = new Page();
        SoftAssert softAssert = new SoftAssert();
        Faker faker= new Faker();

        //Anasayfaya gittigini dogrula
        softAssert.assertTrue(page.anaSayfa.isDisplayed());

        //Register butonuna tıkla
        page.registerButton.click();

        //Username alanına tıkla  username gir
        page.username.sendKeys(faker.name().firstName());

        //Email alanına tıkla  email gir
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[1].toString());
        Driver.getDriver().get(ConfigReader.getProperty("fakeUrl"));
        page.fakeMailCopy.click();

        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[0].toString());
        ReusableMethods.bekle(2);
        page.emailClick.sendKeys(Keys.CONTROL , "v");
        ReusableMethods.bekle(2);

        //Password en az 12 karakterli harf ve rakam içeren bir password gir
        page.passwordClick.sendKeys(ConfigReader.getProperty("password"));

        //"I agree to the privacy policy" seçenegine tıkla
        page.IAgreeButton.click();

        //SIGN UP butonuna tıkla
        page.signUp.click();
        ReusableMethods.bekle(10);

        //"My Account" yazısının görünürlüğünü dogrula
        softAssert.assertTrue(page.signOutButton.isDisplayed());
        softAssert.assertAll();
    }
}
