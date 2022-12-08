package bank.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

    WebDriver driver;
    public loginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='uid']")
    WebElement userNameBox;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordBox;
    @FindBy(xpath = "//input[@name='btnLogin']") WebElement loginBtn;
    @FindBy(xpath = "//a[text()='Log out']") WebElement logOut;


    public void txtUserName(String user){
        userNameBox.clear();
        userNameBox.sendKeys(user);
    }
    public void txtPassword(String pwd){
        passwordBox.clear();
        passwordBox.sendKeys(pwd);
    }
    public void loginClick(){
        loginBtn.click();
    }

    public void logoutClick(){
        logOut.click();
    }
}
