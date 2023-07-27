package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Page {
    public Page(){
        PageFactory.initElements(Driver.getDriver() , this);
    }
























































































































































































































































































































































































































    @FindBy(xpath = "//a[@class='register inline-type']")
    public WebElement registion;
    @FindBy(xpath = "//span[.='Sign In']")
    public WebElement signIn;
    @FindBy(xpath = "//a[.='Sign Up']")
    public WebElement signUp;
    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/vendor-register/'])[2]")
    public WebElement BecomeVendor;
    @FindBy(xpath = "(//h2)[1]")
    public WebElement VendorRegistrationYazisi;
    @FindBy(xpath = "(//a[@title='Copy this email address'])[2]")
    public WebElement fakeEmailCopy;
    @FindBy(xpath = "//tr[@class='hidden-xs hidden-sm klikaciRadek newMail']")
    public WebElement fakeEmailCode;
    @FindBy(xpath = "(//span[@class='wcicon-status-cancelled'])[1]")
    public WebElement This_field_is_required;//4 mesajı tab yaparak dogrula
    @FindBy(xpath = "(//input)[3]")
    public WebElement email;
    @FindBy(xpath = "//div[@class='wcfm-message email_verification_message wcfm-success']")
    public WebElement verification;
    @FindBy(xpath = "//input[@name='wcfm_email_verified_input']")
    public WebElement veryficationCodeKutusu;
    @FindBy(xpath = "//strong[text()='Email']")
    public WebElement bosluk;
    @FindBy(xpath = "(//input)[5]")
    public WebElement resendCode;
    @FindBy(xpath = "(//input[@type='password'])[1]")
    public WebElement password;
    @FindBy(xpath = "(//input)[7]")
    public WebElement confirmPassword;
    @FindBy(css = "#wcfm_membership_register_button")
    public WebElement submit;
    @FindBy(id = "password_strength")
    public WebElement verifyPassword;
    @FindBy(xpath = "//*[@class='wcfm-message email_verification_message wcfm-success']")
    public WebElement successemail;
    @FindBy(xpath = "//div[@class='wcfm-message email_verification_message wcfm-error']")
    public WebElement erroremail;
    @FindBy(xpath = "//div[@class='wcfm-message wcfm-success']")
    public WebElement successlogin;
    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']")//confirm password altı
    public WebElement messageError;
    @FindBy(xpath = "(//h1)[2]")
    public WebElement welcome;
    @FindBy(xpath = "//b")
    public WebElement code;
    //Rana-US-09-10
















































    //Sirma-US-17-18
    //Mesut-US-19-20
















































    //Mesut-US-19-20
}