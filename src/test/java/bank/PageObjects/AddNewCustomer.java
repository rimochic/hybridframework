package bank.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {
    WebDriver driver;

    public AddNewCustomer(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='New Customer']") WebElement NewCustomer;
    @FindBy(xpath = "//input[@name='name']") WebElement CustomerName;
    @FindBy(xpath = "//input[@name='rad1']") WebElement gender;
    @FindBy(xpath = "//input[@id='dob']") WebElement dob;
    @FindBy(xpath = "//textarea[@name='addr']") WebElement address;
    @FindBy(xpath = "//input[@name='city']") WebElement txtCity;
    @FindBy(xpath = "//input[@name='state']") WebElement txtState;
    @FindBy(xpath = "//input[@name='pinno']") WebElement txtPin;
    @FindBy(xpath = "//input[@name='telephoneno']") WebElement phoneNum;
    @FindBy(xpath = "//input[@name='emailid']") WebElement txtEmail;
    @FindBy(xpath = "//input[@name='sub']") WebElement submitBtn;

    public void setNewCustomer(){
        NewCustomer.click();
    }
    public void setCustomerName(String name){
        CustomerName.clear();
        CustomerName.sendKeys(name);
    }
    public void setGender(String Gender){
       gender.click();
    }
    public void setDob(String year, String month, String day){
        dob.sendKeys(day);
        dob.sendKeys(month);
        dob.sendKeys(year);
    }
    public void setAddress(String adr){
        address.sendKeys(adr);
    }
    public void setCity(String city){
        txtCity.sendKeys(city);
    }
    public void setState(String state){
        txtState.sendKeys(state);
    }
    public void setPin(String pin){
        txtPin.sendKeys(String.valueOf(pin));
    }
    public void setPhoneNum(String phoneN){
        phoneNum.sendKeys(phoneN);
    }
    public void setEmail(String email){
        txtEmail.sendKeys(email);
    }
    public void submitBtnClick(){
        submitBtn.click();
    }
}
