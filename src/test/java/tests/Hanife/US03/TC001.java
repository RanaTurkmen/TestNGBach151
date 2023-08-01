package tests.Hanife.US03;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC001 {

    @Test
    public void test001() {


       // Ana sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("alloverUrl"));
        Page page=new Page();

        //Sign In butonuna tıkla
        page.sıgnIn.click();

        //Username ve password girip giriş yap
        page.username1.click();
        page.username1.sendKeys("Bahri"+ Keys.TAB+"Bahri1977."+Keys.ENTER);

       ReusableMethods.scrollEnd();

        ReusableMethods.bekle(2);

        //"My Account" buttonunu tıkla
        page.account.click();

        //"Addresses" seçeneğini seç
        page.adress.click();

        ReusableMethods.bekle(2);

        //"Billing Adresses" bölümünün altındaki "Edit" butonunu tıkla
        page.editAdress.click();

        //"Billing Adresses" kısmına "First Name"in otomatik geldiğini doğrula
        //"Billing Adresses" kısmına "Last Name"in otomatik geldiğini doğrula
         String isim = ReusableMethods.getValueByJS("billing_first_name","value");
        Assert.assertEquals(ConfigReader.getProperty("firstName"),isim);
       String soyisim = ReusableMethods.getValueByJS("billing_last_name","value");
      Assert.assertEquals(ConfigReader.getProperty("lastName"),soyisim);

        // "Billing Adresses" kısmından "Country"seç
        WebElement countrySelect = page.billingCountrySelect;
        Select select = new Select(countrySelect);
        select.selectByVisibleText("Russia");

        //"Billing Adresses" kısmına "Street address"gir
        //"Billing Adresses" kısmına "Town / City"gir
        //"Billing Adresses" kısmına "State"gir
        //"Billing Adresses" kısmına "Zip Code"gir
        //"Billing Adresses" kısmına "Phone"gir
        page.billingStreetAdress.click();
        page.billingStreetAdress.clear();
        page.billingStreetAdress.sendKeys("Armani"+ Keys.TAB+ Keys.TAB+"Newput" +Keys.TAB+"Moskova"+Keys.TAB+"1234"+Keys.TAB+"9876543");



        ReusableMethods.bekle(2);



        //Kayıtlı e-posta adresini otomatik olarak görüntüle
        String mail = ReusableMethods.getValueByJS("billing_email","value");
        Assert.assertEquals(ConfigReader.getProperty("email"),mail);


        //Fatura Adresini kaydetmek için "Save Address" düğmesine tıkla

        ReusableMethods.scroll(page.billingSaveAdress);
        ReusableMethods.click(page.billingSaveAdress);

        ReusableMethods.bekle(2);

        //Fatura Adresinin başarıyla kaydedildiğini doğrula
        ReusableMethods.visibleWait(page.billingAllert, 10);
       Assert.assertTrue(page.billingAllert.getText().contains("Address changed successfully."));




    }
}
