package bank.Base;

import bank.Utilities.readConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class baseClass {
    readConfig readconfig = new readConfig();
    public String url = readconfig.getAppUrl();
    public String userID = readconfig.getUsername();
    public String pwd = readconfig.getPassword();
    public static WebDriver driver;
    public static Logger log;

    @Parameters("browser")
    @BeforeClass
    public void browserSetup(String br){
        log = Logger.getLogger("eBanking");
        PropertyConfigurator.configure("log4j.properties");

        if(br.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver();
            driver = new ChromeDriver();
        }
        else if(br.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver();
            driver = new FirefoxDriver();
        }
        else if (br.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(src,target);
        System.out.println("Screenshot taken");
    }
}
