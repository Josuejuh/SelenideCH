package utilities;

import java.io.IOException;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import static com.codeborne.selenide.Selenide.screenshot;

public class Listener extends TestListenerAdapter
{

    public ExtentReports report;
    public ExtentTest logger;


    public void onStart(ITestContext testContext)
    {
        //Configuration of report, path to save it
        ExtentHtmlReporter reporter = new ExtentHtmlReporter("../AutomationE2E/reports/ReportFull.html");
        //htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
        //Other configuration for the report
        reporter.config().setReportName("Full Report");
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setDocumentTitle("Full Report");
        report = new ExtentReports();
        report.attachReporter(reporter);

    }

    public void onTestSuccess(ITestResult tr)
    {
        //Create a new entry in the report
        logger=report.createTest(tr.getName());
        logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
        //Capture the screen at the end of the test
        String pngFileName = screenshot(tr.getName());
        //Add the screenshot to the report
        try {
            logger.pass("Screenshot is below:", MediaEntityBuilder.createScreenCaptureFromPath(pngFileName).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestFailure(ITestResult tr)
    {
        //Create a new entry in the report
        logger=report.createTest(tr.getName());
        logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
        //Capture the screen at the end of the test
        String pngFileName = screenshot(tr.getName());
        //Add the screenshot to the report
        try {
            logger.fail("Screenshot is below:" , MediaEntityBuilder.createScreenCaptureFromPath(pngFileName).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult tr)
    {
        //Create a new entry in the report
        logger=report.createTest(tr.getName());
        logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
    }

    public void onFinish(ITestContext testContext)
    {
        //Action to do on the final of each test
        report.flush();
    }

}