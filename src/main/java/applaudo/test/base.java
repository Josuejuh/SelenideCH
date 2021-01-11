package applaudo.test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class base
{

    public Properties prop;
    static ExtentReports report;

    @BeforeClass
    public void openBrowser() throws IOException {

        prop = new Properties();
        FileInputStream fis = new FileInputStream("files/data.properties");

        prop.load(fis);
        String namebr = prop.getProperty("browser");

        //TODO - Modificar basetest usando anotaciones de testNG
        Configuration.startMaximized = true;
        Configuration.holdBrowserOpen = true;
        Configuration.browser = "Firefox";
        //Configurations report
        ExtentHtmlReporter reporter=new ExtentHtmlReporter("./reports/ReportFull.html");
        reporter.config().setReportName("Full Report");
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setDocumentTitle("Full Report");
        report = new ExtentReports();
        report.attachReporter(reporter);

        //Open URL on browser
        open(prop.getProperty("url"));

    }

    @AfterClass
    public void closeBrowser(){
        report.flush();
        Selenide.closeWebDriver();
    }
}
