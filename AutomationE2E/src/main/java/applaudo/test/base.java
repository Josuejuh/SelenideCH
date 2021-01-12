package applaudo.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static com.codeborne.selenide.Selenide.open;

public class base
{

    public Properties prop;
    public static ExtentReports report;
    public static ExtentTest test;

    @BeforeTest
    public void openBrowser() throws IOException {

        //Reading the properties
        prop = new Properties();
        FileInputStream fis = new FileInputStream("files/data.properties");
        prop.load(fis);

        //Declaring variables for each properties
        String nameBr = prop.getProperty("browser");
        String url = prop.getProperty("url");

        //Configurations of browser
        Configuration.startMaximized = true;
        //Configuration.holdBrowserOpen = true;
        Configuration.timeout = 10000;

        //Parameter of the name of the browser in which we want to run the test
        Configuration.browser = nameBr;

        //Configurations report
        ExtentHtmlReporter reporter=new ExtentHtmlReporter("./reports/ReportFull.html");
        reporter.config().setReportName("Full Report");
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setDocumentTitle("Full Report");
        report = new ExtentReports();
        report.attachReporter(reporter);

        //Open URL on browser
        open(url);

    }

    @AfterTest
    public void closeBrowser(){
        //Ending report and closing browser
        //Selenide.closeWebDriver();
        report.flush();

    }
}
