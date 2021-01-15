package applaudo.test;

import com.codeborne.selenide.Configuration;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

public class BaseE2E {

    public Properties prop;

    @BeforeTest
    public void openBrowser() throws IOException {
        //Reading the properties
        prop = new Properties();
        FileInputStream fis = new FileInputStream("files/properties/data.properties");
        //FileInputStream fis = new FileInputStream("files/properties/data.properties");
        prop.load(fis);
        //Declaring variables for each properties
        String nameBr = prop.getProperty("browser");
        String url = prop.getProperty("url");
        //Configurations of browser
        Configuration.startMaximized = true;
        Configuration.reportsFolder = "screenshots";
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
