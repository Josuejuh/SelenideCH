package applaudo.test;


import org.openqa.selenium.WebDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class base
{
    public WebDriver driver;
    public Properties prop;


    public void initilizeDrive() throws IOException {

        prop = new Properties();
        FileInputStream fis = new FileInputStream("files/data.properties");

        prop.load(fis);
        String namebr = prop.getProperty("browser");

        if (namebr.equalsIgnoreCase("Chrome")) {
            // Chrome
            System.setProperty("webdriver.chrome.driver", "files/chromedriver.exe");
            System.setProperty("selenide.browser", "Chrome");

        } else if (namebr.equalsIgnoreCase("Firefox")) {
            // Firefox
            System.setProperty("webdriver.gecko.driver", "files/geckodriver.exe");
            System.setProperty("selenide.browser", "Firefox");


        } else if (namebr.equalsIgnoreCase("Explorer")) {
            System.setProperty("webdriver.ie.driver", "files/IEDriverServer.exe");
            System.setProperty("selenide.browser", "Internet Explorer");


        } else if (namebr.equalsIgnoreCase("Edge")) {
            // Edge
            System.setProperty("webdriver.edge.driver", "files/msedgedriver.exe");
            System.setProperty("selenide.browser", "Edge");


        }

    }
}
