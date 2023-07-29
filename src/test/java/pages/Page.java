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



















    //Oguzhan Aydin
    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signIn;
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































































































 

























































//Sırma



































































































//Mesut


























































    //Mesut-US-19-20
}
