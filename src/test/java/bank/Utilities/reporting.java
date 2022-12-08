package bank.Utilities;

// Listener Class used to generate the extent reports
// ---------------------------------------------------
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class reporting extends TestListenerAdapter {

    public ExtentReports extent;
    public ExtentTest test;
    public ExtentHtmlReporter htmlReporter;

    public void onStart(ITestContext testContext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // time stamp
        String reportName = "Test-Report-" + timeStamp + ".html";
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+ reportName); // Specify location of the report
        htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");

        extent = new ExtentReports();

        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host name","localhost");
        extent.setSystemInfo("Environment","QA");
        extent.setSystemInfo("user","Mostafa");

        htmlReporter.config().setDocumentTitle("e-Banking Test Report"); // title of the report
        htmlReporter.config().setReportName("Functional Automation Test Report"); // name of the report
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); // location of the chart
        htmlReporter.config().setTheme(Theme.DARK);
    }


    public void onTestSuccess(ITestResult tr) {
        test = extent.createTest(tr.getName()); // create new entry in the report
        test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information
    }


    public void onTestFailure(ITestResult tr) {
        test = extent.createTest(tr.getName()); // create new entry in the report
        test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
        String screenshotPath = System.getProperty("user.dir") + "/Screenshots/" + tr.getName() + ".png";
        File fl = new File(screenshotPath);
        if(fl.exists()){
            try {
                test.fail("Screenshot is below :" + test.addScreenCaptureFromPath(screenshotPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void onTestSkipped(ITestResult tr) {
        test = extent.createTest(tr.getName()); // create new entry in the report
        test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
    }


    public void onFinish(ITestContext testContext) {
        extent.flush();
    }
}
