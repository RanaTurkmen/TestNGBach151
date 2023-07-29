package pages;

import org.bouncycastle.pqc.crypto.newhope.NHOtherInfoGenerator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Page {
    public Page(){
        PageFactory.initElements(Driver.getDriver() , this);
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
    @FindBy(xpath = "(//*[@type='submit'])[2]")
    public WebElement signUp;
    @FindBy(xpath = "(//*[@class='w-icon-account'])[1]")
    public WebElement signOutButton;
    @FindBy(xpath = "(//*[@class='submit-status'])[2]")
    public WebElement kayitliHesap;
    @FindBy(xpath = "//*[@class='color cetc']")
    public WebElement fakeMailCopy;

























































































    //Fatih-US-01-02
    //Hanife-US-03-04



































































































    //Hanife-US-03-04
    //Kubra-US-05-06



































































































    //Kubra-US-05-06
    //Furkan-US-07-08



































































































    //Furkan-US-07-08
    //Rana-US-09-10






















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












































































    //Rana-US-09-10
    //Ali-US-11-12








































































    //Ali-US-11-12
    //Ilyas-US-13-14
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
    @FindBy(xpath = "//*[@href='signup']")
    public WebElement kayitliUsername;
    @FindBy(xpath = "//*[@id='password']")
    public WebElement kayitliPassword;
    @FindBy(xpath = "//*[@name='login']")
    public WebElement login;
    @FindBy(xpath = "//*[@class='register_as_vendor']")
    public WebElement vendor1;
    @FindBy(xpath = "//a[@class='register inline-type']")
    public WebElement registion;
    @FindBy(xpath = "//span[.='Sign In']")
    public WebElement signIn;
    @FindBy(xpath = "//a[.='Sign Up']")
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













    //Ilyas-US-13-14
    //Oguzhan-US-15-16



































































































    //Oguzhan-US-15-16
    //Sirma-US-17-18



































































































    //Sirma-US-17-18
    //Mesut-US-19-20



































































































    //Mesut-US-19-20
}