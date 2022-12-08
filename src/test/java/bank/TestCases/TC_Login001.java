package bank.TestCases;

import bank.Base.baseClass;
import bank.PageObjects.loginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_Login001 extends baseClass {

    @Test
    public void loginTest() throws IOException {
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
            captureScreen(driver, "loginTest");
            log.info("the test failed");
            Assert.assertTrue(false);
        }

    }

}
