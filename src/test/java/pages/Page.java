package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class Page {

  public Page(){ PageFactory.initElements(Driver.getDriver() , this);}

    //Fatih-US-01-02
    @FindBy(xpath = "//*[@class='logo']")
    public WebElement anaSayfa;
    @FindBy(xpath = "//*[@class='register inline-type']")
    public WebElement registerButton;
    @FindBy(xpath = "(//*[@id='reg_username'])[1]")
    public WebElement username;
    @FindBy(xpath = "(//*[@id='reg_email'])[1]")
    public WebElement emailClick;
    @FindBy(xpath = "//*[@id='reg_password']")
    public WebElement passwordClick;
    @FindBy(xpath = "//*[@id='register-policy']")
    public WebElement IAgreeButton;
    @FindBy(xpath = "(//*[@type='submit'])[2]")
    public WebElement signUp;
    @FindBy(xpath = "(//*[@class='w-icon-account'])[1]")
    public WebElement signOutButton;
    @FindBy(xpath = "(//*[@class='submit-status'])[2]")
    public WebElement kayitliHesap;
    @FindBy(xpath = "//*[@class='color cetc']")
    public WebElement fakeMailCopy;
    @FindBy(xpath = "(//*[@aria-live='polite'])[1]")
    public WebElement passwordVerify;
    @FindBy(xpath = "//*[@class='icon-box-icon icon-logout']")
    public WebElement cikisYap;
    @FindBy(xpath = "//*[@value='Sign Up']")
    public WebElement signUpButton;
    @FindBy(xpath = "//*[@class='woocommerce-password-hint']")
    public WebElement passwordUyariVerify;





























































//Hanife 


































































































  
    //Kubra-US-05-06



































































































//Furkan













































































  





















  //Rana
     @FindBy(xpath = "//a[@class='register inline-type']")
    public WebElement registion;
    @FindBy(xpath = "//span[.='Sign In']")
    public WebElement signIn;
    //@FindBy(xpath = "//a[.='Sign Up']")
    //public WebElement signUp;
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





















































    //Ali-US-11-12


































































































  //İlyas
    @FindBy(xpath = "//*[@class='login inline-type']")
    public WebElement singInButonu;
    @FindBy(xpath = "//*[@id='reg_username']")
    public WebElement usernameRegister;
    @FindBy(xpath = "//*[@id='reg_email']")
    public WebElement mail;
    @FindBy(xpath = "//*[@id='reg_password']")
    public WebElement passwordRegister;
    @FindBy(xpath = "//*[@id='register-policy']")
    public WebElement agree;
    @FindBy(xpath = "//*[@name='register']")
    public WebElement register;
    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement singOut;
    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/my-account-2/edit-address/'])[1]")
    public WebElement adresses;
    @FindBy(xpath = "//*[@href='https://allovercommerce.com/my-account-2/edit-address/shipping/']")
    public WebElement shippingAdd;
    @FindBy(xpath = "//*[@id='shipping_first_name']")
    public WebElement shippingName;
    @FindBy(xpath = "//*[@id='shipping_last_name']")
    public WebElement shippingLastName;
    @FindBy(xpath = "//*[@name='shipping_address_1']")
    public WebElement street;
    @FindBy(xpath = "//*[@id='shipping_postcode']")
    public WebElement zipCode;
    @FindBy(xpath = "//*[@id='select2-shipping_state-container']")
    public WebElement province;
    @FindBy(xpath = "//*[@name='save_address']")
    public WebElement save;
    @FindBy(xpath = "//*[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
    public WebElement succefully;
    @FindBy(xpath = "//*[@id='shipping_city']")
    public WebElement city;
    @FindBy(xpath = "//*[@id='shipping_state']")
    public WebElement state;
    @FindBy(xpath = "//*[@id='shipping_state']")
    public WebElement country;
    @FindBy(xpath = "//*[@id='shipping_country']")
    public WebElement region;



























































//Oğuzhan









































 

























































//Sırma



































































































//Mesut


























































    //Mesut-US-19-20
}
