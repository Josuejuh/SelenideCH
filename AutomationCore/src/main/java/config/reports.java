package config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

public class reports{

    public static ExtentReports report;
    public static ExtentTest test;

    @BeforeTest
    public void confReport() throws IOException {

        //Configurations report
        ExtentHtmlReporter reporter=new ExtentHtmlReporter("./reports/ReportFull.html");
        reporter.config().setReportName("Full Report");
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setDocumentTitle("Full Report");
        report = new ExtentReports();
        report.attachReporter(reporter);

    }

    @AfterTest
    public void finishReport(){
        report.flush();

    }

}
