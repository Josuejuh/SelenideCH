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
import java.net.URL;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

public class baseE2E extends reports{
    public Properties prop;

    @BeforeTest
    public void openBrowser() throws IOException {

        //Reading the properties
        prop = new Properties();
        FileInputStream fis = new FileInputStream("../AutomationCore/files/properties/data.properties");
        //FileInputStream fis = new FileInputStream("files/properties/data.properties");
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


        //Open URL on browser
        open(url);

    }

    @AfterTest
    public void closeBrowser(){
        //Closing browser
        //Selenide.closeWebDriver();


    }
}
