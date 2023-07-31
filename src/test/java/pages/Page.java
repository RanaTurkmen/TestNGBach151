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
    @FindBy(xpath = "(//h2)")
    public WebElement MyAccount;





























































//Hanife 


































































































  
    //Kubra-US-05-06



































































































//Furkan
    @FindBy (xpath = "(//*[@class='compare btn-product-icon'])[1]")
    public WebElement compareTikla;
    @FindBy(xpath = "(//h3)[42]")
    public WebElement urunDogrulama1;
    @FindBy(xpath = "//*[.='earphone product']")
    public WebElement earphoneTikla;
    @FindBy(xpath = "//*[@class='compare btn-product-icon']")
    public WebElement earphoneCompare;
    @FindBy(xpath = "(//h3)[8]")
    public WebElement urunDogrulama2;
    @FindBy(xpath = "(//*[.='C Vitamini'])[2]")
    public WebElement cVitaminiTikla;
    @FindBy(xpath = "//*[@class='compare btn-product-icon']")
    public WebElement cVitaminiCompare;
    @FindBy(xpath = "(//h3)[11]")
    public WebElement urunDogrulama3;
    @FindBy(xpath = "(//*[.='Chess'])[4]")
    public WebElement chessTikla;
    @FindBy(xpath = "//*[@class='compare btn-product-icon']")
    public WebElement chessCompare;
    @FindBy(xpath = "//*[.='Compare Products']")
    public WebElement urunDogrulama4;
    @FindBy(xpath = "(//*[.='Automatic Crusher'])[4]")
    public WebElement automaticCrusherTikla;
    @FindBy(xpath = "//*[@class='compare btn-product-icon']")
    public WebElement automaticCrusherCompare;
    @FindBy(xpath = "(//h3)[11]")
    public WebElement urunDogrulama5;
    @FindBy(xpath = "(//*[@class='btn-remove remove_from_compare fas fa-times'])[1]")
    public WebElement xButtonDelete;
    @FindBy(xpath = "(//*[.='4'])[2]")
    public WebElement products4;
    @FindBy(xpath = "//*[@class='compare-clean']")
    public WebElement cleanAllButton;
    @FindBy(xpath = "(//*[.='3'])[2]")
    public WebElement products3;
    @FindBy(xpath = "(//*[.='0'])[7]")
    public WebElement products0;
    @FindBy(xpath = "//*[@type='search']")
    public WebElement serachButton;
    @FindBy(xpath = "(//*[.='Pencil6'])[2]")
    public WebElement ilkUrunTikla;
    @FindBy(xpath = "//*[@class='compare btn-product-icon']")
    public WebElement compareTiklaKalem;
    @FindBy(xpath = "(//*[.='Pencils 4'])[2]")
    public WebElement ikinciUrunTikla;
    @FindBy(xpath = "(//*[@class='compare btn-product-icon'])[1]")
    public WebElement compareTiklaKalem2;
    @FindBy(xpath = "//*[.='Start Compare !']")
    public WebElement startCompareTikla;
    @FindBy(xpath = "(//*[.='Compare'])[1]")
    public WebElement compareDogrula;
    @FindBy(xpath = "(//*[@class='compare-col compare-field'])[3]")
    public WebElement urunEklendiginiDogrula;
    @FindBy(xpath = "//*[@class='woocommerce-Price-currencySymbol']")
    public WebElement urunOzellikleriniDogrula;
    @FindBy(xpath = "(//*[@class='w-icon-times-solid'])[1]")
    public WebElement ilkUrunKaldir;
    @FindBy(xpath = "(//*[@class='w-icon-times-solid'])[1]")
    public WebElement ikinciUrunKaldir;
    @FindBy(xpath = "(//i)[11]")
    public WebElement ikinciUrunKaldir2;
    @FindBy(xpath = "//*[.='No products added to the compare']")
    public WebElement noProductAdded;
    @FindBy(xpath = "(//*[.='Men’s Clothing'])[2]")
    public WebElement mensClothingTikla;
    @FindBy(xpath = "(//*[@class='add_to_wishlist single_add_to_wishlist'])[1]")
    public WebElement kalpButtonTikla;
    @FindBy(xpath = "//*[@class='w-icon-heart']")
    public WebElement wishListButton;
    @FindBy(xpath = "(//*[.='Wishlist'])[2]")
    public WebElement wishListDogrula;
    @FindBy(xpath = "//*[.='Home']")
    public WebElement homeButtonTikla;
    @FindBy(xpath = "//*[@type='search']")
    public WebElement searchButtonUrunAra;
    @FindBy(xpath = "(//*[.='Iphone Case'])[2]")
    public WebElement cikanIlkUrunTikla;
    @FindBy(xpath = "(//*[@rel='nofollow'])[2]")
    public WebElement kalpButtonTikla2;
    @FindBy(xpath = "(//*[@class='btn btn-quickview btn-outline btn-default btn-rounded btn-sm mr-lg-2'])[1]")
    public WebElement quickviewClick;
    @FindBy(xpath = "//*[@class='posted_in']")
    public WebElement urunOzellikDogrulaCase;
    @FindBy(xpath = "//*[@name='add-to-cart']")
    public WebElement addToCartButton;
    @FindBy(xpath = "//*[@class='btn btn-sm btn-rounded']")
    public WebElement viewCartButton;
    @FindBy(xpath = "(//*[.='Shopping Cart'])[2]")
    public WebElement shoppingCartIsDisplay;
    @FindBy(xpath = "(//*[.='Iphone Case'])[4]")
    public WebElement urunSepeteEklendiginiDogrula;
    @FindBy(xpath = "(//*[@type='button'])[1]")
    public WebElement xButtonTikla;





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
















































































































































































































































    //    Furkan
    @FindBy(xpath = "(//*[.='Add to cart'])[2]")
    public WebElement addToCartButtonDogrula;
    @FindBy(xpath = "(//*[.='View cart'])[2]")
    public WebElement viewCartButtonTikla;
    @FindBy(xpath = "(//*[.='Add to cart'])[1]")
    public WebElement pc2SepeteEkle;
    @FindBy(xpath = "//*[@class='btn btn-sm btn-dark btn-rounded']")
    public WebElement checkoutButton;
    @FindBy(xpath = "//*[.='Billing details']")
    public WebElement billingDetails;
    @FindBy(xpath = "(//*[.='MacBook Air'])[4]")
    public WebElement mackbookTikla;
    @FindBy(xpath = "(//*[@type='submit'])[2]")
    public WebElement mackbookAddToCart;
    @FindBy(xpath = "(//*[.='View cart'])[2]")
    public WebElement viewCartIsDisplayed;
    @FindBy(xpath = "(//*[@class='w-icon-cart'])[1]")
    public WebElement cartButtonTiklaa;
    @FindBy(xpath = "//*[@class='button wc-forward']")
    public WebElement viewCartButton2;
    @FindBy(xpath = "//*[@class='button checkout wc-forward']")
    public WebElement checkoutButton2;
    @FindBy(xpath = "(//*[@type='text'])[3]")
    public WebElement firstName;
    @FindBy(xpath = "(//*[@type='submit'])[4]")
    public WebElement placeOrder;
    @FindBy(xpath = "//*[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']")
    public WebElement thankYou;
    @FindBy(xpath = "(//*[@type='submit'])[2]")
    public WebElement addToCartMens;
    @FindBy(xpath = "//*[@class='checkout-button button alt wc-forward']")
    public WebElement proceedToCheckout;
    @FindBy(xpath = "(//*[.='Checkout'])[2]")
    public WebElement checkoutUzerineTikla;
    @FindBy(xpath = "//*[text()='has been added to cart']")
    public WebElement hasBeenVerify;
    @FindBy(xpath = "//*[text()=' “Men’s Clothing” has been added to your cart.']")
    public WebElement hasBeenVerifyyy;


}
