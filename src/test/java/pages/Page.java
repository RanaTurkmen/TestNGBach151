package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


import java.util.List;

public class Page {

    public Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

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
    @FindBy(xpath = "//a[@href='signup']")
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
    @FindBy(xpath = "(//*[text()='My Account'])[2]") public WebElement account;
    @FindBy(xpath = "//*[text()='Sign In']") public WebElement sıgnIn;
    @FindBy(xpath = "//*[@id='username']") public WebElement username1;
    @FindBy(xpath = "(//*[@class='icon-box text-center'])[3]") public  WebElement adress;
    @FindBy(xpath = "(//*[text()='Add'])[1]") public WebElement addBilling;
    @FindBy(xpath = "//*[@id='billing_first_name']") public WebElement billingFirstName;
    @FindBy(xpath= "(//select)[1]") public WebElement billingCountrySelect;
    @FindBy(xpath = "//*[@id='billing_address_1']") public WebElement billingStreetAdress;
    @FindBy(xpath= "(//select)[2]") public WebElement billingProvice;
    @FindBy(xpath = "//input[@id='billing_email']") public WebElement billingEmail;
    @FindBy(xpath = "//*[@name='save_address']") public WebElement billingSaveAdress;
    @FindBy(xpath = "//*[text()='Edit Your Billing Address']") public WebElement editAdress;
    @FindBy(xpath= "//*[text()='Address changed successfully.']") public WebElement billingAllert;
    @FindBy(xpath = "//*[@id='billing_city']") public  WebElement billingCity;
    @FindBy(xpath = "//*[@id='billing_state']") public  WebElement billingState;
    @FindBy(xpath = "//*[@id='billing_postcode']") public  WebElement billingPostcode;
    @FindBy(xpath = "//*[@id='billing_phone']") public  WebElement billingPhone;
    @FindBy(xpath = "//*[@id='billing_last_name']") public WebElement billingLastName;
    @FindBy(xpath = "(//*[text()='Eklemek'])[2]") public WebElement addShipping;
    @FindBy(xpath = "//*[@id='shipping_first_name']") public WebElement shippingFirstName;
    @FindBy(xpath = "//select") public WebElement shippingCountry;
    @FindBy(xpath = "//*[@id='shipping_address_1']") public WebElement shippingStreetAdress;
    @FindBy(xpath = "//*[@id='select2-shipping_state-container']") public WebElement shippingProvince;
    @FindBy(xpath = "//*[@name='save_address']") public WebElement shippingSaveAdress;
    @FindBy(xpath = "//*[@class='alert']") public WebElement billingallertPhone;
    @FindBy(xpath = "(//*[@class='edit btn btn-link btn-primary btn-underline mb-4'])[2]") public WebElement shippingEditAdress;
    @FindBy(xpath = "//*[@id='shipping_last_name']") public WebElement shippingLastName1;
    @FindBy(xpath = "//*[@id='shipping_city']") public WebElement shippingCity;
    @FindBy(xpath = "//*[@id='shipping_state']") public WebElement shippingState;
    @FindBy(xpath = "//*[@id='shipping_postcode']") public WebElement shippingPostcode;
    @FindBy(xpath = "//*[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']") public WebElement shippingAllert;
    @FindBy(xpath = "//*[@class='woocommerce-error']") public WebElement billingPhoneAlert;
    @FindBy(xpath = "//*[text()='First name is a required field.']") public WebElement shippingFirstNameAllert;
    @FindBy(xpath = "//*[text()='Last name is a required field.']") public WebElement shippingLastNameAllert;
    @FindBy(xpath = "//*[text()='Street address is a required field.']") public WebElement shippingStreetAdressAllert;
    @FindBy(xpath = "//*[text()='Postcode is a required field.']") public WebElement shippingPostcodeAllert;
    @FindBy(xpath = "//*[text()='Suburb is a required field.']") public WebElement shippingSuburbAllert;
    @FindBy(xpath = "//*[text()='City is a required field.']") public WebElement shippingCityAllert;
    @FindBy(xpath = "//*[@class='woocommerce-error']") public WebElement billingPhoneAlertTC03;
    @FindBy(xpath = "//*[@data-id='billing_first_name']") public WebElement billingFirstNameAlert;
    @FindBy(xpath = "//*[@data-id='billing_last_name']") public WebElement billingLastNameAlert;
    @FindBy(xpath = "//*[@data-id='billing_address_1']") public WebElement billingStreetAdresAlert;
    @FindBy(xpath = "//*[@data-id='billing_city']") public WebElement billingTownCityAlert;
    @FindBy(xpath = "//*[@data-id='billing_phone']") public WebElement billingPhoneNumberAlert;
    @FindBy(xpath = "//*[@data-id='billing_postcode']") public WebElement billingPostCodeAlert;
    @FindBy(xpath = "//*[@class=' alert alert-simple alert-icon alert-close-top alert-danger']") public WebElement billingEmailBoxAlert;

















































  
  
  
  
     //kubra US 05-06
     @FindBy(xpath = "//a[@class='login inline-type']")
     public WebElement signInButton;
    //@FindBy(xpath = "//*[@id='username']")
    //public WebElement username;
    @FindBy(xpath = "//*[@id='password']")
    public WebElement passWord;
    @FindBy(xpath = "//*[@id='rememberme']")
    public WebElement rememberButton;
    @FindBy(xpath = "//*[@name='login']")
    public WebElement SignIn;
    @FindBy(xpath = "//div[@id='yith-wcwl-popup-message']")
    public WebElement mesajVerify;
    @FindBy(xpath = "//a[@class='login logout inline-type']")
    public WebElement signOut;
    @FindBy(tagName = "h2")
    public WebElement myAccount;
    @FindBy(linkText = "Account details")
    public WebElement accountDetails;
    @FindBy(tagName = "h4")
    public WebElement accountDetailsYazisi;
    @FindBy(xpath = "//*[@name='account_first_name']")
    public WebElement firstnameClear;
    @FindBy(xpath = "//*[@id='account_first_name']")
    public WebElement newFirstname;
    @FindBy(xpath = "//*[@id='account_last_name']")
    public WebElement lastnameClear;
    @FindBy(xpath = "//*[@name='account_last_name']")
    public WebElement newLastname;
    @FindBy(xpath = "//*[@id='account_display_name']")
    public WebElement displayNameClear;
    @FindBy(xpath = "//*[@name='account_display_name']")
    public WebElement newDisplayName;
    @FindBy(xpath = "//*[@id='account_email']")
    public WebElement emailClear;
    //@FindBy(xpath = "//*[@class='color cetc']")
    //public WebElement fakeMailCopy;
    @FindBy(xpath = "//*[@name='account_email']")
    public WebElement newEmail;
    @FindBy(tagName = "p")
    public WebElement metinAlani;
    @FindBy(xpath = "//*[@name='password_current']")
    public  WebElement currentPassword;
    @FindBy(xpath = "//*[@name='password_1']")
    public WebElement newPassword;
    @FindBy(xpath = "//*[@name='password_2']")
    public WebElement confirmPassWord;
    @FindBy(xpath = "//*[@name='save_account_details']")
    public WebElement saveChangesButton;
    @FindBy(xpath = "//div[@class='woocommerce-notices-wrapper']")
    public WebElement accountDetailsVerify;
    @FindBy(xpath = "//*[@role='alert']")
    public WebElement errorYazisi;
    @FindBy(xpath = "//*[@role='alert']")
    public WebElement errorPassword;
    @FindBy(xpath = "//*[@aria-label='Search']")
    public WebElement searchBox;
    @FindBy(tagName = "div")
    public WebElement aramaSonucYazisi;
    @FindBy(linkText = "T-Shirt")
    public WebElement ilkUrun;
    @FindBy(tagName = "h1")
    public WebElement hataVerify;
    @FindBy(linkText = "Erkek T-shirt")
    public WebElement ikinciUrun;
    @FindBy(xpath = "//*[@name='gri']")
    public WebElement urunRengi;
    @FindBy(xpath = "//*[@class='single_add_to_cart_button button alt']")
    public WebElement addToCartButton;
    @FindBy(xpath = "//div[@id='product-14255']")
    public WebElement urunVerify;
    @FindBy(xpath = "//span[@class='cart-label']")
    public WebElement sepetIkonu;
    @FindBy(xpath = "//*[@class='button wc-forward']")
    public WebElement viewCartButton;
    @FindBy(xpath = "//*[@title='Plus']")
    public WebElement urunArtirmaButton;
    @FindBy(xpath = "//*[@class='quantity-minus w-icon-minus']")
    public WebElement urunAzaltmaButton;
    @FindBy(xpath = "//*[@class='checkout-button button alt wc-forward']")
    public WebElement checkOutButton;
    @FindBy(xpath = "//div[@class='woocommerce-billing-fields']")
    public WebElement billingDetails;
    @FindBy(xpath = "//input[@id='payment_method_bacs']")
    public WebElement wireTransferEFT;
    @FindBy(xpath = "//*[@value='bacs']")
    public WebElement eftVerify;
    @FindBy(xpath = "//input[@id='payment_method_cod']")
    public WebElement payAtTheDoor;
    @FindBy(xpath = "//*[@id='place_order']")
    public WebElement placeOrderButton;
    @FindBy(xpath = "//*[@class='fas fa-check']")
    public WebElement siparisMesajVerify;
    @FindBy(xpath = "//*[@class='woocommerce-order-details']")
    public WebElement orderDetails;
    @FindBy(xpath = "//*[@class='woocommerce-customer-details']") public WebElement billingDetailss;




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
    //@FindBy(xpath = "//*[@name='add-to-cart']")
    //public WebElement addToCartButton;
    //@FindBy(xpath = "//*[@class='btn btn-sm btn-rounded']")
    //public WebElement viewCartButton;
    @FindBy(xpath = "(//*[.='Shopping Cart'])[2]")
    public WebElement shoppingCartIsDisplay;
    @FindBy(xpath = "(//*[.='Iphone Case'])[4]")
    public WebElement urunSepeteEklendiginiDogrula;
    @FindBy(xpath = "(//*[@type='button'])[1]")
    public WebElement xButtonTikla;





  //Rana
    @FindBy(xpath = "//a[@class='register inline-type']")
    public WebElement registion;
    // @FindBy(xpath = "//span[.='Sign In']")
    // public WebElement signIn;
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
    @FindBy(xpath = "//input[@value='Register']")
    public WebElement submit;
    @FindBy(id = "password_strength")
    public WebElement verifyPassword;
    @FindBy(xpath = "//div[@class='wcfm-message email_verification_message wcfm-error']")
    public WebElement erroremail;
    @FindBy(xpath = "//*[.='Registration Successfully Completed.']")
    public WebElement successlogin;
    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']")//confirm password altı
    public WebElement messageError;
    @FindBy(xpath = "(//h1)[2]")
    public WebElement welcome;
    @FindBy(xpath = "//b")
    public WebElement code;
    @FindBy(css = ".login-popup")
    public WebElement become;

    //Rana-US-09-10

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    //ilyas
    @FindBy(xpath = "//*[@id='wcfm_new_cat']")
    public WebElement categoriName;
    @FindBy(xpath = "(//*[@class='button wcfm_add_category_bt wcfm_add_taxonomy_bt'])[1]")
    public WebElement add;
    @FindBy(xpath = "(//*[@class='wcfm_add_new_category_box wcfm_add_new_taxonomy_box'])[2]")
    public WebElement addProductBrands;
    @FindBy(xpath = "//*[@id='wcfm_new_product_brand']")
    public WebElement brandsName;
    @FindBy(xpath = "(//*[@class='button wcfm_add_category_bt wcfm_add_taxonomy_bt'])[2]")
    public WebElement addBrands;
    @FindBy(xpath = "//*[@id='featured_img_display']")
    public WebElement bild;
    @FindBy(xpath = "//*[@id='menu-item-upload']dgdgd")
    public WebElement upload;
    @FindBy(xpath = "")
    public WebElement selectFile;
    @FindBy(xpath = "//*[@id='__wp-uploader-id-1']")
    public WebElement selectButonu;
    @FindBy(xpath = "//*[@class='button load-more button-primary']")
    public WebElement loadMore;
    @FindBy(xpath = "//*[@id='menu-item-upload']")
    public WebElement uploadButonu;
    @FindBy(xpath = "//*[@id='menu-item-browse']")
    public WebElement media;
    @FindBy(xpath = "//*[@class='button media-button button-primary button-large media-button-select']")
    public WebElement button;
    @FindBy(xpath = "//*[@class='button load-more button-primary']")
    public WebElement loadMoreButton;
    //Ilyas-US-13-14

//Ali-US-11-12


































































































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
    public WebElement save;
    @FindBy(xpath = "//*[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
    public WebElement succefully;
    @FindBy(xpath = "//*[@id='shipping_city']")
    public WebElement city;
    @FindBy(xpath = "//*[@id='shipping_state']")
    public WebElement country;
    @FindBy(xpath = "//*[@id='shipping_country']")
    public WebElement region;










    //Oguzhan Aydin
    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signIn;
    @FindBy(xpath = "//*[@href='signup']")
    public WebElement kayitliUsername;
    @FindBy(xpath = "//*[@id='password']")
    public WebElement kayitliPassword;
    @FindBy(xpath = "//*[@name='login']")
    public WebElement login;
    @FindBy(xpath = "//*[@class='register_as_vendor']")
    public WebElement vendor1;
    // @FindBy(xpath = "//a[@class='register inline-type']")
    // public WebElement registion;
    //@FindBy(xpath = "//span[.='Sign In']")
    //public WebElement signIn;
    //@FindBy(xpath = "//a[.='Sign Up']")
    //public WebElement BecomeVendor;
    //@FindBy(xpath = "(//h2)[1]")
    //public WebElement VendorRegistrationYazisi;
    //@FindBy(xpath = "(//a[@title='Copy this email address'])[2]")
    //public WebElement fakeEmailCopy;
    //@FindBy(xpath = "//tr[@class='hidden-xs hidden-sm klikaciRadek newMail']")
    //public WebElement fakeEmailCode;
    @FindBy(xpath = "(//span[@class='wcicon-status-cancelled'])[1]")
    public WebElement This_field_is_required;//4 mesajı tab yaparak dogrula
    // @FindBy(xpath = "(//input)[3]")
    // public WebElement email;
    // @FindBy(xpath = "//div[@class='wcfm-message email_verification_message wcfm-success']")
    // public WebElement verification;
    // @FindBy(xpath = "//input[@name='wcfm_email_verified_input']")
    // public WebElement veryficationCodeKutusu;
    // @FindBy(xpath = "//strong[text()='Email']")
    // public WebElement bosluk;
    @FindBy(xpath = "//b")
    public WebElement code2;
    @FindBy(xpath = "//*[@class='button button-large']")
    public WebElement notRightNow;
    @FindBy(xpath = "(//h3)[1]")
    public WebElement welcomeDashboard;
    @FindBy(xpath = "//*[@class='wcfmfa fa-power-off']")
    public WebElement dasboardLoginOut;
    @FindBy(xpath = "(//*[@class='wcfm_menu_item '])[3]")
    public WebElement pruducts;
    @FindBy(xpath = "//*[@id='dropdown_product_type']")
    public WebElement allProduct;
    @FindBy(xpath = "//*[@class='register_as_vendor']")
    public WebElement verdor;
    @FindBy(xpath = "//*[@class='wcfm_sub_menu_items wcfm_sub_menu_items_product_manage moz_class']")
    public WebElement productsAddNew;
    @FindBy(xpath = "//*[@id='pro_title']")
    public WebElement productTitle;
    @FindBy(xpath = "(//*[@id='tinymce'])[1]")
    public WebElement shortDescription;
    @FindBy(xpath = "//*[@data-id='description']")
    public WebElement description;
    @FindBy(xpath = "(//*[@type='submit'])[3]")
    public WebElement draft;
    @FindBy(xpath = "(//*[text()='Categories'])[1]")
    public WebElement categories;
    @FindBy(xpath = "(//*[@data-super_parent='15'])[1]")
    public WebElement uncatogorizied;
    @FindBy(xpath = "(//*[@class='wcfm_add_new_category_box wcfm_add_new_taxonomy_box'])[1]")
    public WebElement addNewCatagories;
    //Oguzhan Aydin
    // @FindBy(xpath = "//*[text()='Sign In']")
    // public WebElement signIn;
    //  @FindBy(xpath = "//*[@id='username']")
    //  public WebElement username;
    @FindBy(xpath = "(//*[@class='w-icon-account'])[1]")
    public WebElement profileButton;
    @FindBy(xpath = "//*[*='Store Manager']")
    public WebElement storeManager;
    @FindBy(xpath = "(//*[contains(text(), 'Products')])[1]")
    public WebElement products;
    @FindBy(xpath = "(//*[text()='Add New'])[1]")
    public WebElement addNewProduct;
    @FindBy(xpath = "//*[text()='Inventory']")
    public WebElement idventory;
    @FindBy(xpath = "//*[text()='Shipping']")
    public WebElement shipping;
    @FindBy(xpath = "(//*[text()='Attributes'])[1]")
    public WebElement attributes;
    @FindBy(xpath = "//*[text()='Linked']")
    public WebElement linked;
    @FindBy(xpath = "//*[contains(text(), 'SEO')]")
    public WebElement seo;
    @FindBy(xpath = "(//*[*='Advanced'])[2]")
    public WebElement advanced;
    @FindBy(xpath = "//*[@id='sku']")
    public WebElement skuInput;
    @FindBy(xpath = "//*[@id='manage_stock']")
    public WebElement manageSkuCheckbox;
    @FindBy(xpath = "//*[@id='stock_qty']")
    public WebElement stockQty;
    @FindBy(xpath = "//*[@id='sold_individually']")
    public WebElement soldIndividuallyCheckbox;
    @FindBy(xpath = "//*[@id='backorders']")
    public WebElement allowBackorders;
    @FindBy(xpath = "//*[@id='weight']")
    public WebElement weight;
    @FindBy(xpath = "//*[@id='shipping_class']")
    public WebElement shippingClass;
    @FindBy(xpath = "//*[@id='_wcfmmp_processing_time']")
    public WebElement processingTime;
    @FindBy(xpath = "//*[@id='attributes_is_active_1']")
    public WebElement colorCheckbox;
    @FindBy(xpath = "(//*[@class='select2-selection select2-selection--multiple'])[2]")
    public WebElement colorDropDown;
    @FindBy(xpath = "//*[@id='attributes_is_visible_1']")
    public WebElement attributesVisibleOnProductPageCheckbox;
    @FindBy(xpath = "(//*[text()='Select all'])[1]")
    public WebElement attributesSelectAllButton;
    @FindBy(xpath = "(//*[text()='Select none'])[1]")
    public WebElement attributesSelectNoneButton;
    @FindBy(xpath = "(//*[text()='Add New'])[2]")
    public WebElement attributesAddNewButton;
    @FindBy(xpath = "//*[@id='attributes_is_active_2']")
    public WebElement sizeCheckbox;
    @FindBy(xpath = "(//*[@class='select2-selection__rendered'])[3]")
    public WebElement sizeInput;
    @FindBy(xpath = "(//*[text()='Select all'])[2]")
    public WebElement sizeSelectAllButton;
    @FindBy(xpath = "(//*[text()='Select none'])[2]")
    public WebElement sizeSelectNoneButton;
    @FindBy(xpath = "(//*[text()='Add New'])[3]")
    public WebElement sizeAddNewButton;
    @FindBy(xpath = "//*[@id='attributes_is_visible_2']")
    public WebElement sizeVisibleOnProductPageCheckbox;
    @FindBy(xpath = "//*[@class='button wcfm_add_attribute']")
    public WebElement addAttributeButton;
    @FindBy(xpath = "//*[@id='attributes_name_3']")
    public WebElement addAttributeName;
    @FindBy(xpath = "//*[@id='attributes_value_3']")
    public WebElement addAttributeValue;
    @FindBy(xpath = "//*[@id='product_type']")
    public WebElement productType;
    @FindBy(xpath = "//*[@id='is_virtual']")
    public WebElement virtualCheckbox;
    @FindBy(xpath = "//*[@id='is_downloadable']")
    public WebElement downloadableCheckbox;
    @FindBy(xpath = "//*[@id='pro_title']")
    public WebElement productTitleInput;
    @FindBy(xpath = "(//*[contains(text(), 'schedule')])[1]")
    public WebElement schedule;
    @FindBy(xpath = "//*[@id='sale_date_from']")
    public WebElement dateFrom;
    @FindBy(xpath = "//*[@id='menu-item-browse']")
    public WebElement mediaLibrary;
    @FindBy(xpath = "(//div[@class='thumbnail'])[1]")
    public WebElement firstLibraryPicture;
    @FindBy(xpath = "(//*[*='Insert into post'])[2]")
    public WebElement insertPictureIntoPostButton;
    @FindBy(xpath = "(//iframe)[1]")
    public WebElement shortDescriptonInput;
    @FindBy(xpath = "(//*[@class='button insert-media add_media'])[1]")
    public WebElement descriptionAddMedia;
    @FindBy(xpath = "(//iframe)[2]")
    public WebElement descriptionInput;
    @FindBy(xpath = "//*[@id='featured_img_display']")
    public WebElement addBigPicture;
    @FindBy(xpath = "(//*[*='Select'])[4]")
    public WebElement bigPictureSelectFileButton;
    @FindBy(xpath = "(//*[@data-id='22264'])[3]")
    public WebElement bigPicture;
    @FindBy(xpath = "//*[@id='gallery_img_gimage_0_display']")
    public WebElement addSmallPicture;
    @FindBy(xpath = "(//*[text()='Add to Gallery'])[3]")
    public WebElement smallPictureAddToGalleryButton;
    @FindBy(xpath = "//*[@data-super_parent='608']")
    public WebElement vakkoCheckBox;
    @FindBy(xpath = "//*[@data-super_parent='569']")
    public WebElement lcwCheckBox;
    @FindBy(xpath = "//*[@id='product_tags']")
    public WebElement productTags;
    @FindBy(xpath = "//*[@id='catalog_visibility']")
    public WebElement catalogVisibility;
    @FindBy(xpath = "//*[@id='wcfm_products_simple_submit_button']")
    public WebElement submitProductButton;
    @FindBy(xpath = "//*[@class='wcicon-status-cancelled']")
    public WebElement failMessage;
    @FindBy(xpath = "//*[@class='wcfmfa fa-cloud-download-alt']")
    public WebElement downloadable;
    @FindBy(xpath = "//*[@id='downloadable_files_name_0']")
    public WebElement downloadableName;
    @FindBy(xpath = "//*[@id='downloadable_files_file_0_button']")
    public WebElement downloadableUpload;
    @FindBy(xpath = "(//*[*='Select'])[8]")
    public WebElement downloadableSelect;
    @FindBy(xpath = "//*[*='Published']")
    public WebElement publishedMessage;
    @FindBy(xpath = "//*[@id='__wp-uploader-id-7']")
    public WebElement addPicFromPc;
    @FindBy(xpath = "(//*[@id='menu-item-upload'])[3]")
    public WebElement uploadPic;
    @FindBy(xpath = "//*[@id='__wp-uploader-id-10']")
    public WebElement smallPicUpload;
    @FindBy(xpath = "(//*[@id='menu-item-upload'])[4]")
    public WebElement smallPicSelectFile;
    @FindBy(xpath = "//*[@id='__wp-uploader-id-1']")
    public WebElement descriptionSelectPic;
    //Oguzhan Aydin bitis
    //Sırma  850
    @FindBy(xpath = "//*[@id='username']")
    public  WebElement emailAdres;
    //@FindBy(xpath = "//*[@id='menu-item-1079']")
    //public  WebElement myAccount;
    @FindBy(xpath = "(//*[.='Orders'])[2]")
    public  WebElement orders;
    @FindBy(css = "[class='woocommerce-Button button btn btn-link btn-underline btn-icon-right']")
    public  WebElement browseProduct;
    @FindBy(xpath= "(//input)[2]")
    public  WebElement search;
    @FindBy(xpath= "//*[@href='?add-to-cart=13277']")
    public  WebElement addToCartApple;
    @FindBy(xpath= "//*[text()='has been added to cart']")
    public  WebElement popupMesaj;
    @FindBy(css= "[class='btn btn-sm btn-dark btn-rounded']")
    public  WebElement checkoutPopup;
    @FindBy(xpath= "(//input)[4]")
    public  WebElement firstName;
    @FindBy(xpath= "(//input)[7]")
    public  WebElement bilingDetails;
    @FindBy(xpath= "//*[@id='billing_phone']")
    public  WebElement phoneName;
    @FindBy(xpath= "//*[@id='billing_postcode']")
    public  WebElement zipKod;
    @FindBy(xpath= "(//*[.='Women'])[1]")
    public  WebElement woman;
    @FindBy(xpath= "(//*[.='Bags'])[2]")
    public  WebElement bags;
    @FindBy(xpath= "//*[@href='?add-to-cart=13257']")
    public  WebElement bag1;
    @FindBy(xpath= "//*[@href='?add-to-cart=13278']")
    public  WebElement bag2;
    @FindBy(xpath= "(//*[.='View cart'])[2]")
    public  WebElement bagViewCart;
    @FindBy(xpath= "/(//*[@class='cart-count'])[1]")
    public  WebElement sepetSayısı;
    @FindBy(xpath= "(//*[@class='w-icon-cart'])[1]")
    public  WebElement sepet;
    @FindBy(xpath= "//*[.='Checkout']")
    public  WebElement checkoutButton;
    @FindBy(xpath= "//*[@id='place_order']")
    public  WebElement placOrder;
    @FindBy(xpath= "(//li)[7]")
    public  WebElement hata1;
    @FindBy(xpath= "(//li)[8]")
    public  WebElement hata2;
    @FindBy(xpath= "(//li)[9]")
    public  WebElement hata3;
    @FindBy(xpath= "(//li)[10]")
    public  WebElement hata4;
    @FindBy(xpath= "(//li)[11]")
    public  WebElement hata5;
    @FindBy(xpath= "(//li)[12]")
    public  WebElement hata6;
    @FindBy(xpath= "(//li)[13]")
    public  WebElement hata7;
    @FindBy(xpath= "(//button)[1]")
    public  WebElement imleç;
    @FindBy(xpath= "(//*[.='Women’s Summer Casual Dress'])[2]")
    public  WebElement ürün2;
    @FindBy(xpath= "(//button)[9]")
    public  WebElement yellow;
    @FindBy(xpath= "(//button)[13]")
    public  WebElement mideum;
    @FindBy(xpath= "(//*[@type='submit'])[2]")
    public  WebElement addToCart;
    @FindBy(xpath= " //*[@role='alert']")
    public  WebElement viewCartMesaj;
    @FindBy(xpath= "//*[.='View cart']")
    public  WebElement viewCart;
    @FindBy(css= "[class='btn btn-dark btn-rounded btn-icon-left continue-shopping mb-4 mr-auto']")
    public  WebElement continueShopping;
    @FindBy(xpath= "(//*[.='16 ” MacBook Pro'])[2]")
    public  WebElement macPro;
    @FindBy(xpath= "(//*[@href='https://allovercommerce.com/checkout-2/'])[3]")
    public  WebElement proceedToCheckout;
    @FindBy(xpath= "//*[@class='next page-numbers']")
    public  WebElement next;
    @FindBy(xpath= "(//*[@class='page-numbers'])[2]")
    public  WebElement next3;
    @FindBy(xpath= "(//*[@class='page-numbers'])[4]")
    public  WebElement next5;
    @FindBy(xpath= "(//*[.='ebby paten'])[2]")
    public  WebElement pattern;
    @FindBy(xpath= "//*[@class='quantity-plus w-icon-plus']")
    public  WebElement artı;
    @FindBy(xpath= "//*[@class='quantity-minus w-icon-minus']")
    public  WebElement eksi;
    @FindBy(xpath= "(//*[@value='1'])[1]")
    public  WebElement ürünAdedi;
    @FindBy(xpath= "//*[@class='stock in-stock']")
    public  WebElement stokAdedi;
    @FindBy(xpath= "//*[@class='woocommerce-product-details__short-description']")
    public  WebElement uyarıMesajı;
    @FindBy(xpath= "(//*[@class='quantity'])[1]")
    public  WebElement ürünSayısıSepet;
    @FindBy(xpath= "(//button)[3]")
    public  WebElement placeOrder;
    @FindBy(xpath= "//*[@data-id='billing_postcode']")
    public  WebElement hata8;
    @FindBy(xpath= "//*[@data-id='billing_phone']")
    public  WebElement hata9;
    @FindBy(xpath= "(//*[@class='product-name'])[2]")
    public  WebElement yourOrder;
    @FindBy(xpath= "(//*[.='Multi Functional Apple iPhone'])[3]")
    public  WebElement multiFoncTel;
    @FindBy(xpath= "//*[@id='payment_method_cod']")
    public  WebElement payAddTheDoor;
    @FindBy(xpath= "//*[.='Thank you. Your order has been received.']")
    public  WebElement thankYou;
    @FindBy(xpath= "//*[@href='https://allovercommerce.com/my-account-2/view-order/31280/']")
    public  WebElement siparisKodu;
    @FindBy(xpath= "(//*[.='View'])[1]")
    public  WebElement siparisKodu2;
    @FindBy(xpath= "(//p)[4]")
    public  WebElement sevkiyat;
    @FindBy(xpath= "(//p)[3]")
    public  WebElement baslıkSiparis;
    @FindBy(xpath= "(//td)[10]")
    public  WebElement ürünNote;
    @FindBy(xpath= "(//tr//td)[9]")
    public  WebElement ordersTotalFiyat;
    @FindBy(xpath= "(//*[@class='woocommerce-Price-amount amount'])[4]")
    public  WebElement billingTotalFiyat;
    @FindBy(xpath= "//*[@class='quantity']")
    public  WebElement shoppingCartÜrünAdetleri;
    @FindBy(xpath= "(//*[@class='cart-count'])[1]")
    public  WebElement sepetUstSayı;
    @FindBy(xpath= "(//*[.='ebby paten'])[2]")
    public  WebElement popupBabyPattern;
    //US18 LOCATE
    //@FindBy(xpath= "//*[.='Sign Out']")
    //public  WebElement signOut;
    @FindBy(xpath= "//*[.='Store Manager']")
    public  WebElement storeManager1;
    @FindBy(xpath= "//*[@class='wcfmfa fa-gift']")
    public  WebElement coupons;
    @FindBy(xpath= "//*[@id='add_new_coupon_dashboard']")
    public  WebElement couponsAdd;
    @FindBy(xpath= "(//input)[3]")
    public  WebElement couponCode;
    @FindBy(xpath= "(//input)[7]")
    public  WebElement checkboxAlow;
    @FindBy(xpath= "(//input)[8]")
    public  WebElement checkboxShow;
    @FindBy(xpath= "//*[@value='Submit']")
    public  WebElement submiT;
    @FindBy(xpath= "//*[@class='wcfm-message wcfm-success']")
    public  WebElement submitVerify;
    @FindBy(xpath= "//*[text()='Coupon Successfully Published.']]")
    public  WebElement submitVerify2;
    @FindBy(xpath= "(//*[.='Percentage discount'])[1]")
    public  WebElement submitVerifyPercent;
    @FindBy(xpath= "(//h2)[2]")
    public  WebElement editCoupon;
    @FindBy(css= "[class='coupon-types coupon-types-fixed_product']")
    public  WebElement submitVerifyFixed;
    @FindBy(xpath= "//*[@class='wcfm_sub_menu_items wcfm_sub_menu_items_coupon_manage moz_class']")
    public  WebElement couponsAdd2;
    @FindBy(xpath= "//*[@class='ui-datepicker-month']")
    public  WebElement selectAy;
    @FindBy(xpath= "(//select)[7]")
    public  WebElement selecYıl;
    @FindBy(xpath= "//*[text()='15']")
    public  WebElement gün15;
    @FindBy(xpath= "//*[@placeholder='YYYY-MM-DD']")
    public  WebElement tarih;
    @FindBy(xpath= "//*[@data-handler='next']")
    public  WebElement nextSağ;
    @FindBy(xpath= "//*[text()='20']")
    public  WebElement gün20;
    @FindBy(xpath= "(//td//a)[1]")
    public  WebElement couponVerfyCouponAdı;
    @FindBy(xpath= "(//td)[3]")
    public  WebElement couponVerfyOran;
    @FindBy(xpath= "//input[@id='quantity_64c8a932ab881']")
    public  WebElement artıEksi;
    @FindBy(xpath= "//*[@id='quantity_64c8ca12b06ce']")
    public  WebElement xxxx;




















    //Sırma
    //Mesut

    @FindBy(xpath = "//*[@class='login inline-type']")
    public WebElement signInButtonHP;
    @FindBy(id="username")
    public WebElement emailBox;
    @FindBy(xpath = "(//li[@class='product-wrap'])[1]")
    public WebElement pencil6;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement verifyingOfAddingProductToCart;
    @FindBy(xpath = "(//i[@class='w-icon-cart'])[1]")
    public WebElement cartLogo;
    @FindBy(xpath = "//button[@title='Plus']")
    public WebElement plusIcon;
    @FindBy(xpath = "//button[@name='update_cart']")
    public WebElement updateCart;
    @FindBy(xpath = "(//span[@class='cart-count'])[1]")
    public WebElement cartQuantity;
    @FindBy(xpath = "//button[@class='quantity-minus w-icon-minus']")
    public WebElement minusIcon;
    @FindBy(xpath = "//*[@name='coupon_code']")
    public WebElement couponCodeTextArea;
    @FindBy(xpath = "//*[.='Apply coupon']")
    public WebElement applyCoupon;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement verifyCoupon;
    @FindBy(xpath ="//a[@class='woocommerce-remove-coupon']")
    public WebElement removeCoupon;


    @FindBy(xpath = "//a[@class='showcoupon']")
    public WebElement enterYourCodeButton;

    @FindBy(xpath = "//*[@id='billing_first_name']")
    public WebElement firstNameTextArea;
    @FindBy(xpath = "//select[@id='billing_country']")
    public WebElement countryRegionDdm;
    @FindBy(xpath = "//*[@id='billing_address_1']")
    public WebElement streetAdress;
    @FindBy(xpath = "//*[@id='select2-billing_state-container']")
    public WebElement stateDdm;


    @FindBy(xpath = "//*[.='Thank you. Your order has been received.']")
    public WebElement verifyOrder;
    @FindBy(xpath = "(//*[@class='btn btn-search'])[1]")
    public WebElement searchButton;
    @FindBy(xpath = "(//h3)[1]")
    public WebElement billingDetailsText;
    @FindBy(xpath = "//ul[@role='alert']")
    public WebElement usedCouponVerifying;
    @FindBy(xpath = "(//span[@class='woocommerce-Price-amount amount'])[6]")
    public WebElement totalAmount;
    @FindBy(xpath = "//*[.='My Orders']")
    public WebElement myOrdersButton;
    @FindBy(xpath ="//*[.='Checkout']")
    public WebElement checoutButton1;

    @FindBy(xpath ="//*[@class='woocommerce-button btn btn-default btn-rounded btn-outline btn-sm btn-block view']")
    public WebElement viewButton;

    @FindBy(xpath = "(//a[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link'])[7]")
    public WebElement macbookAir;









































































    //Mesut-US-19-20







































































    //    Furkan
    @FindBy(xpath = "(//*[.='Add to cart'])[2]")
    public WebElement addToCartButtonDogrula;
    @FindBy(xpath = "(//*[.='View cart'])[2]")
    public WebElement viewCartButtonTikla;
    @FindBy(xpath = "(//*[.='Add to cart'])[1]")
    public WebElement pc2SepeteEkle;
    //@FindBy(xpath = "//*[@class='btn btn-sm btn-dark btn-rounded']")
    //public WebElement checkoutButton;
    //@FindBy(xpath = "//*[.='Billing details']")
    //public WebElement billingDetails;
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
    //@FindBy(xpath = "(//*[@type='text'])[3]")
    //public WebElement firstName;
    //@FindBy(xpath = "(//*[@type='submit'])[4]")
    //public WebElement placeOrder;
    //@FindBy(xpath = "//*[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']")
    //public WebElement thankYou;
    @FindBy(xpath = "(//*[@type='submit'])[2]")
    public WebElement addToCartMens;
    //@FindBy(xpath = "//*[@class='checkout-button button alt wc-forward']")
    //public WebElement proceedToCheckout;
    @FindBy(xpath = "(//*[.='Checkout'])[2]")
    public WebElement checkoutUzerineTikla;
    @FindBy(xpath = "//*[text()='has been added to cart']")
    public WebElement hasBeenVerify;
    @FindBy(xpath = "//*[text()=' “Men’s Clothing” has been added to your cart.']")
    public WebElement hasBeenVerifyyy;




    //Ali 500-600
    @FindBy(xpath = "//*[@class='login inline-type']")
    public WebElement signInMainPage;
    @FindBy(xpath = "//*[@id='customer_login']")
    public WebElement signInPopUp;
    @FindBy(xpath = "//*[@id='username']")
    public WebElement eMailBox;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordBox;
    //@FindBy(xpath = "//button[@value='Sign In']")
    //public WebElement signInButton;
    @FindBy(xpath = "(//p[@class='submit-status'])[1]")
    public WebElement alertTextWrongUser;
    @FindBy(xpath = "//p[@class='submit-status loading']")
    public WebElement alertTextPleaseWait;
    @FindBy(xpath = "//h2[@class='page-title']")
    public WebElement myAccountText;
    @FindBy(xpath = "//a[text()='Dashboard']")
    public WebElement dashboardText;
    @FindBy(xpath = "//*[.='Store Manager']")
    public WebElement storeManagerText;
    @FindBy(xpath = "//*[.='Orders']")
    public WebElement orderText;
    @FindBy(xpath = "//*[.='Downloads']")
    public WebElement downloadsText;
    @FindBy(xpath = "//*[.='Addresses']")
    public WebElement addressesText;
    @FindBy(xpath = "//*[.='Account details']")
    public WebElement accountDetailsText;
    @FindBy(xpath = "//*[.='Wishlist']")
    public WebElement wishlistText;
    @FindBy(xpath = "//*[.='Support Tickets']")
    public WebElement supportTicketsText;
    @FindBy(xpath = "//*[.='Followings']")
    public WebElement followingsText;
    @FindBy(xpath = "//*[.='Logout']")
    public WebElement logoutText;
    //@FindBy(xpath = "//span[text()='Sign Out']")
    //public WebElement signOutButton;
    @FindBy(xpath = "//a[text()='Addresses']")
    public WebElement adressesText;
    @FindBy(xpath = "//h4[@class='icon-box-title text-normal']")
    public WebElement adressesPage;
    @FindBy(xpath = "//a[@class='edit btn btn-link btn-primary btn-underline mb-4']")
    public WebElement addText;
    @FindBy(xpath = "//h3[text()='Billing address']")
    public WebElement billingAddressPage;
    //@FindBy(xpath = "//input[@id='billing_first_name']")
    //public WebElement billingFirstName;
    //@FindBy(xpath = "//input[@id='billing_last_name']")
    //public WebElement billingLastName;
    @FindBy(xpath = "//select[@id='billing_country']")
    public WebElement countryDdm;
    @FindBy(xpath = "//input[@id='billing_address_1']")
    public WebElement streetAddress;
    @FindBy(xpath = "//input[@id='billing_address_2']")
    public WebElement streetAddress2;
    @FindBy(xpath = "//input[@id='billing_postcode']")
    public WebElement postcode;
    @FindBy(xpath = "//input[@id='billing_city']")
    public WebElement town;
    @FindBy(xpath = "//button[@class='btn btn-dark btn-rounded btn-sm']")
    public WebElement saveAddressButton;
    @FindBy(xpath = "//input[@id='billing_phone']")
    public WebElement phoneNumber;
    @FindBy(xpath = "//input[@id='billing_email']")
    public WebElement billingMail;
    @FindBy(xpath = "//select[@id='billing_state']")
    public WebElement provinceDdm;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement addressChanged;
    @FindBy(xpath = "(//*/tbody/tr[1]/td[1])[1]")
    public WebElement billingName;
    @FindBy(xpath = "(//table/tbody/tr[3]/td)[1]")
    public WebElement billingAddress;
    //@FindBy(xpath = "//table/tbody/tr[4]/td")
    //public WebElement billingCity;
    @FindBy(xpath = "//table/tbody/tr[5]/td")
    public WebElement billingCountry;
    @FindBy(xpath = "//table/tbody/tr[6]/td")
    public WebElement billingPostCode;
    //@FindBy(xpath = "//table/tbody/tr[7]/td")
    //public WebElement billingPhone;
    @FindBy(xpath = "(//div/nav/ul/li)[position()>=1 and position()<=10]")
    public List<WebElement> dashboardMenuList;












}
