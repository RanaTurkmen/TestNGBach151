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


    //Fatih-US-01-02
    //Hanife-US-03-04


    //Hanife-US-03-04
    //Kubra-US-05-06


    //Kubra-US-05-06
    //Furkan-US-07-08


    //Furkan-US-07-08
    //Rana-US-09-10


    //Ali-US-11-12
    //Ilyas-US-13-14


    //Ilyas-US-13-14
    //Oguzhan-US-15-16


    //Oguzhan-US-15-16
    //Sirma-US-17-18


    //Sirma-US-17-18
    //Mesut-US-19-20


    //Mesut-US-19-20


































































































































































































































































































































































































































































    //Ali 500-600
    @FindBy(xpath = "//*[@class='login inline-type']")
    public WebElement signInMainPage;
    @FindBy(xpath = "//*[@id='customer_login']")
    public WebElement signInPopUp;
    @FindBy(xpath = "//*[@id='username']")
    public WebElement eMailBox;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordBox;
    @FindBy(xpath = "//button[@value='Sign In']")
    public WebElement signInButton;
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
    @FindBy(xpath = "//span[text()='Sign Out']")
    public WebElement signOutButton;
    @FindBy(xpath = "//a[text()='Addresses']")
    public WebElement adressesText;
    @FindBy(xpath = "//h4[@class='icon-box-title text-normal']")
    public WebElement adressesPage;
    @FindBy(xpath = "//a[@class='edit btn btn-link btn-primary btn-underline mb-4']")
    public WebElement addText;
    @FindBy(xpath = "//h3[text()='Billing address']")
    public WebElement billingAddressPage;
    @FindBy(xpath = "//input[@id='billing_first_name']")
    public WebElement billingFirstName;
    @FindBy(xpath = "//input[@id='billing_last_name']")
    public WebElement billingLastName;
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
    @FindBy(xpath = "//table/tbody/tr[4]/td")
    public WebElement billingCity;
    @FindBy(xpath = "//table/tbody/tr[5]/td")
    public WebElement billingCountry;
    @FindBy(xpath = "//table/tbody/tr[6]/td")
    public WebElement billingPostCode;
    @FindBy(xpath = "//table/tbody/tr[7]/td")
    public WebElement billingPhone;
    @FindBy(xpath = "(//div/nav/ul/li)[position()>=1 and position()<=10]")
    public List<WebElement> dashboardMenuList;











}