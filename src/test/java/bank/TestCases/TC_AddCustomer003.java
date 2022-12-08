package bank.TestCases;

import bank.Base.baseClass;
import bank.PageObjects.AddNewCustomer;
import bank.PageObjects.loginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_AddCustomer003 extends baseClass {

    @Test
    public void addCustomer() throws IOException {
        log.info("Url is opened");
        loginPage lp = new loginPage(driver);
        lp.txtUserName(userID);
        log.info("Entered the username");
        lp.txtPassword(pwd);
        log.info("Entered the password");
        lp.loginClick();
        if(driver.getTitle().equals("GTPL Bank Manager HomePage")){
            Assert.assertTrue(true);
            log.info("the test passed");
        }else{
            captureScreen(driver, "TC_Login001");
            log.info("the test failed");
            Assert.assertTrue(false);
        }

        AddNewCustomer addCust = new AddNewCustomer(driver);
        addCust.setNewCustomer();
        log.info("New Customer page");
        log.info("Providing customer details...");
        addCust.setCustomerName("Rimo");
        addCust.setGender("male");
        addCust.setDob("1990","08","12");
        addCust.setAddress("Hampden ave 657");
        addCust.setCity("Denver");
        addCust.setState("Co");
        addCust.setPin("445678");
        addCust.setPhoneNum("546789872");
        addCust.setEmail(randomString()+"@gmail.com");
        addCust.submitBtnClick();

        log.info("Validation started....");
        if (driver.getPageSource().contains("Customer Registered Successfully!!!")==true){
            Assert.assertTrue(true);
            log.info("Test is passed");
        }else{
            log.warn("Test is failed");
            captureScreen(driver,"addCustomer");
            Assert.assertTrue(false);
        }
    }

    public String randomString(){
        String generatedString = RandomStringUtils.randomAlphabetic(8);
        return generatedString;
    }

}
