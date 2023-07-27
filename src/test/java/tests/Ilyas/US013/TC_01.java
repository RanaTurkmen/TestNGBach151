package tests.Ilyas.US013;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_01 {

    @Test
    public void test01() {
        Driver.getDriver().get("https://allovercommerce.com/");
        Page page = new Page();
        page.singInButonu.click();
        page.signUp.click();
        page.usernameRegister.sendKeys("ılyas0110");
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[1].toString());
        Driver.getDriver().get(ConfigReader.getProperty("fakeUrl"));
        page.fakeMailCopy.click();
        Driver.getDriver().switchTo().window(Driver.getDriver().getWindowHandles().toArray()[0].toString());
        ReusableMethods.bekle(2);
        page.mail.sendKeys(Keys.CONTROL , "v");
        ReusableMethods.bekle(2);
        page.passwordRegister.sendKeys("12345");
        page.agree.click();
        page.register.click();
        page.singOut.click();
        page.adresses.click();
        page.shippingAdd.click();
        page.shippingName.sendKeys("ilyas");
        page.shippingLastName.sendKeys("Çnz");
        ReusableMethods.scroll(page.region);
        ReusableMethods.bekle(2);
        ReusableMethods.ddmIndex(page.region,3);
        page.street.sendKeys("Cumhuriyet");
        page.city.sendKeys("Amasya");
        ReusableMethods.scroll(page.country);
        ReusableMethods.ddmIndex(page.country,5);
        page.zipCode.sendKeys("1234");
        page.save.click();
        ReusableMethods.bekle(2);
        Assert.assertTrue(page.succefully.isDisplayed());


    }

}
