package applaudo.test;


import applaudo.pageObject.*;
import applaudo.utilities.*;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.codeborne.selenide.Condition;
import org.testng.annotations.*;
import java.io.IOException;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class productFlow extends base{

    String ss = "";
    Condition clickable = and("can be clicked", visible, enabled);
//    @BeforeClass
//    public void beforeClass()  {
//
//    }

    @Test ()
    public void search() throws IOException {
        Home hm = new Home();
        test = report.createTest("Search Product");


           hm.searchbar().shouldBe(Condition.visible);
           hm.searchButton().shouldBe(clickable);

                highlight.HighlightElement(getWebDriver(), hm.searchbar());
                hm.searchbar().sendKeys("#");

                highlight.HighlightElement(getWebDriver(), hm.searchButton());
                hm.searchButton().click();

                ss = screenshots.takeScreen(getWebDriver(), "search");
                test.pass("Search negative condition" , MediaEntityBuilder.createScreenCaptureFromPath(ss).build());

                hm.searchbar().shouldBe(Condition.visible);
                hm.searchButton().shouldBe(clickable);

                highlight.HighlightElement(getWebDriver(), hm.searchbar());
                hm.searchbar().clear();
                hm.searchbar().sendKeys("dress");

                highlight.HighlightElement(getWebDriver(), hm.searchButton());
                hm.searchButton().click();

                ss = screenshots.takeScreen(getWebDriver(), "search");
                test.pass("Search positive condition" , MediaEntityBuilder.createScreenCaptureFromPath(ss).build());

            report.flush();
    }

    @Test (priority = 1)
    public void cart() throws IOException {
        Search sh = new Search();
        Cart ct = new Cart();
        test = report.createTest("Add/Delete from cart");

                sh.product(1).shouldBe(clickable);
                highlight.HighlightElement(getWebDriver(), sh.product(1));
                sh.product(1).click();

                sh.additem().shouldBe(clickable);
                highlight.HighlightElement(getWebDriver(), sh.additem());
                sh.additem().click();

                sh.exit().shouldBe(clickable).click();

                sh.cart().shouldBe(clickable);
                highlight.HighlightElement(getWebDriver(), sh.cart());
                sh.cart().click();


                ct.btnDelete().shouldBe(clickable);
                ss = screenshots.takeScreen(getWebDriver(), "cart");
                test.pass("Product added successfully!" , MediaEntityBuilder.createScreenCaptureFromPath(ss).build());


                highlight.HighlightElement(getWebDriver(), ct.btnDelete());
                ct.btnDelete().click();

                ss = screenshots.takeScreen(getWebDriver(), "cartDel");
                test.pass("Product deleted successfully!" , MediaEntityBuilder.createScreenCaptureFromPath(ss).build());

            report.flush();

    }


//    @AfterClass
//    public void afterClass()
//    {
//
//    }
}
