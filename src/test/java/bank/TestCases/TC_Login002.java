package bank.TestCases;

import bank.Base.baseClass;
import bank.PageObjects.loginPage;
import bank.Utilities.XlUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;

import org.testng.annotations.*;

import java.io.IOException;

public class TC_Login002 extends baseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = TC_Login002.class)
    public void loginDDT(String userN, String pass) throws InterruptedException {
        System.out.println(userN + " | " + pass);
        log.info("Url is opened");
        loginPage lp = new loginPage(driver);
        lp.txtUserName(userN);
        log.info("Username entered");
        lp.txtPassword(pass);
        log.info("Password entered");
        lp.loginClick();


        if(isAlertPresent()==true){
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            log.warn("Login failed!!");
            Assert.assertTrue(false);
        }
        else{
            Assert.assertTrue(true);
            log.info("login passed");
            lp.logoutClick();
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
            log.info("Log out passed");
        }

    }

    public boolean isAlertPresent(){  // user defined method created to check the alert is present or not
        try {
            driver.switchTo().alert();
            return true;
        }catch (NoAlertPresentException e){
            return false;
        }
    }


    @DataProvider(name = "LoginData")
     public String[][] getData() throws IOException {
            String path = System.getProperty("user.dir") + "/src/test/java/bank/TestData/data.xlsx";
            int totalRow = XlUtils.getRowCount(path, "Sheet1");
            int totalCol = XlUtils.getCellCount(path, "Sheet1", 1);
             String [][]loginData= new String[totalRow][totalCol];

            for (int i = 1; i <= totalRow; i++) {
                for (int j = 0; j < totalCol; j++) {
                    loginData[i - 1][j] = XlUtils.getCellData(path, "Sheet1", i, j);
                }
            }
        return loginData;

    }


}
