package applaudo.test;

import applaudo.pageobj.*;
import applaudo.utilities.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;
import java.io.IOException;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class FullTest extends base
{
    static ExtentReports report;
    static ExtentTest test;

    @BeforeClass
    public void before() throws IOException {
        //Configurations for browser
        //initilizeDrive();
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
        //getWebDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test ()
    public void search()
    {
        Home hm = new Home();
        //highlight hti = new highlight();
        test = report.createTest("Search Product");

        try {
            if(hm.searchbar().isEnabled()) {
                highlight.HighlightElement(getWebDriver(), hm.searchbar());
                hm.searchbar().sendKeys("#");

                highlight.HighlightElement(getWebDriver(), hm.searchButton());
                hm.searchButton().click();
                hm.waitHm();
                String ss = screenshots.takeScreen(getWebDriver(), "search");
                test.pass("Search negative condition" , MediaEntityBuilder.createScreenCaptureFromPath(ss).build());
            }else{
                test.log(Status.FAIL, "Process error!");
            }

            if(hm.searchbar().isEnabled()) {
                highlight.HighlightElement(getWebDriver(), hm.searchbar());
                hm.searchbar().clear();
                hm.searchbar().sendKeys("dress");

                highlight.HighlightElement(getWebDriver(), hm.searchButton());
                hm.searchButton().click();
                hm.waitHm();
                String ss = screenshots.takeScreen(getWebDriver(), "search");
                test.pass("Search positive condition" , MediaEntityBuilder.createScreenCaptureFromPath(ss).build());
            }else{
                test.log(Status.FAIL, "Process error!");
            }

            report.flush();

        }catch (Exception e){
            test.log(Status.FAIL, e.getMessage());
            report.flush();
        }


    }

    @Test (priority = 1)
    public void cart()
    {
        Search sh = new Search();
        Cart ct = new Cart();
        //highlight hti = new highlight();
        test = report.createTest("Add/Delete from cart");

        try {
            if(sh.product(1).isEnabled()) {
                highlight.HighlightElement(getWebDriver(), sh.product(1));
                sh.product(1).click();
                sh.waitsh();
                highlight.HighlightElement(getWebDriver(), sh.additem());
                sh.additem().click();
                sh.waitsh();
                sh.exit().click();
                highlight.HighlightElement(getWebDriver(), sh.cart());
                sh.cart().click();
                sh.waitsh();
                if(ct.btnDelete().isEnabled()){
                    String ss = screenshots.takeScreen(getWebDriver(), "cart");
                    test.pass("Product added successfully!" , MediaEntityBuilder.createScreenCaptureFromPath(ss).build());
                }
                else{
                    test.log(Status.FAIL, "Product not added, error!");
                }

                if(ct.btnDelete().isEnabled()){
                    highlight.HighlightElement(getWebDriver(), ct.btnDelete());
                    ct.btnDelete().click();
                    sh.waitsh();
                    String ss = screenshots.takeScreen(getWebDriver(), "cartDel");
                    test.pass("Product deleted successfully!" , MediaEntityBuilder.createScreenCaptureFromPath(ss).build());
                }
                else{
                    test.log(Status.FAIL, "Product not deleted, error!");
                }

            }else{
                test.log(Status.FAIL, "Process error!");
            }


            report.flush();

        }catch (Exception e){
            test.log(Status.FAIL, e.getMessage());
            report.flush();
        }


    }

    @Test (priority = 2)
    public void storeInfo()
    {
        Home ho = new Home();
        //highlight hti = new highlight();
        test = report.createTest("Store Information");

        try {
            if(ho.contact01().isDisplayed()) {
                ho.scroll(ho.contact01(),getWebDriver());
                highlight.HighlightElement(getWebDriver(), ho.contact01());
                highlight.HighlightElement(getWebDriver(), ho.contact02());
                highlight.HighlightElement(getWebDriver(), ho.contact03());

                ho.contact01().shouldHave(Condition.text("Selenium Framework, Research Triangle Park, North Carolina, USA"));
                ho.contact02().shouldHave(Condition.text("(347) 466-7432"));
                ho.contact03().shouldHave(Condition.text("support@seleniumframework.com"));

                String ss = screenshots.takeScreen(getWebDriver(), "cart");
                test.pass("Store information displayed correctly!" , MediaEntityBuilder.createScreenCaptureFromPath(ss).build());

            }else{
                test.log(Status.FAIL, "Process error!");
            }


            report.flush();

        }catch (Exception e){
            test.log(Status.FAIL, e.getMessage());
            report.flush();
        }


    }

    @AfterClass
    public void after()
    {
        report.flush();
        getWebDriver().quit();
    }
}
