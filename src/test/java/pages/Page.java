package pages;

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



































































































    //Rana-US-09-10
    //Ali-US-11-12



































































































    //Ali-US-11-12
    //Ilyas-US-13-14



































































































    //Ilyas-US-13-14
    //Oguzhan-US-15-16



































































































    //Oguzhan-US-15-16
    //Sirma-US-17-18



































































































    //Sirma-US-17-18
    //Mesut-US-19-20



































































































    //Mesut-US-19-20
}