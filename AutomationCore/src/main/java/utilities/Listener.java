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
        ExtentHtmlReporter reporter = new ExtentHtmlReporter("../AutomationE2E/reports/ReportFull.html");
        //htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");

        reporter.config().setReportName("Full Report");
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setDocumentTitle("Full Report");

        report = new ExtentReports();
        report.attachReporter(reporter);

    }

    public void onTestSuccess(ITestResult tr)
    {
        logger=report.createTest(tr.getName()); // create new entry in th report
        logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted

        String pngFileName = screenshot(tr.getName());

        try {
            logger.pass("Screenshot is below:", MediaEntityBuilder.createScreenCaptureFromPath(pngFileName).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestFailure(ITestResult tr)
    {
        logger=report.createTest(tr.getName()); // create new entry in th report
        logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted

        String pngFileName = screenshot(tr.getName());
        try {
            logger.fail("Screenshot is below:" , MediaEntityBuilder.createScreenCaptureFromPath(pngFileName).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult tr)
    {
        logger=report.createTest(tr.getName()); // create new entry in th report
        logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
    }

    public void onFinish(ITestContext testContext)
    {
        report.flush();
    }

}