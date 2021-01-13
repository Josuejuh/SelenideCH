package applaudo.test;


import applaudo.pageObject.*;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.codeborne.selenide.Condition;
import config.baseE2E;
import org.testng.annotations.*;
import utilities.highlight;
import utilities.screenshots;
import java.io.IOException;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class productFlow extends baseE2E {
    //Variables used in the class, the first one for saving screenshots and the second one to put more than one condition
    //for the element
    String ss = "";
    Condition clickable = and("can be clicked", visible, enabled);

    @Test ()
    public void search() throws IOException {
        //Create object to access the locators
        Home hm = new Home();
        //Create a new line on the report for save the steps for this test on the report
        test = report.createTest("Search Product");

         //Check if the elements are on the webpage
           hm.searchbar().shouldBe(Condition.visible);
           hm.searchButton().shouldBe(clickable);
                //Highlight and write on the search bar
                highlight.HighlightElement(getWebDriver(), hm.searchbar());
                hm.searchbar().sendKeys("#");
                //Highlight and click on the button for doing the search
                highlight.HighlightElement(getWebDriver(), hm.searchButton());
                hm.searchButton().click();
                //Take the screenshot and handle the report
                ss = screenshots.takeScreen(getWebDriver(), "search");
                test.pass("Search negative condition" , MediaEntityBuilder.createScreenCaptureFromPath(ss).build());

            //Check if the elements are on the webpage
            hm.searchbar().shouldBe(Condition.visible);
            hm.searchButton().shouldBe(clickable);
                //Highlight, clear and write on the search bar
                highlight.HighlightElement(getWebDriver(), hm.searchbar());
                hm.searchbar().clear();
                hm.searchbar().sendKeys("dress");
                //Highlight and click on the button for doing the search
                highlight.HighlightElement(getWebDriver(), hm.searchButton());
                hm.searchButton().click();
                //Take the screenshot and handle the report
                ss = screenshots.takeScreen(getWebDriver(), "search");
                test.pass("Search positive condition" , MediaEntityBuilder.createScreenCaptureFromPath(ss).build());

            report.flush();
    }

    @Test (priority = 1)
    public void cart() throws IOException {
        //Create both objects to interact with the locators
        Search sh = new Search();
        Cart ct = new Cart();
        //Create a new line on the report for save the steps for this test on the report
        test = report.createTest("Add/Delete from cart");

                //Click a product result of the search
                sh.product(1).shouldBe(clickable);
                highlight.HighlightElement(getWebDriver(), sh.product(1));
                sh.product(1).click();
                //Click a product result of the search
                sh.additem().shouldBe(clickable);
                highlight.HighlightElement(getWebDriver(), sh.additem());
                sh.additem().click();
                //Check if item is clickable on the webpage
                sh.exit().shouldBe(clickable).click();
                //Highlight and click to the cart button
                sh.cart().shouldBe(clickable);
                highlight.HighlightElement(getWebDriver(), sh.cart());
                sh.cart().click();

                //Check if the delete button of the cart is available, then take a screenshot and handle the report
                ct.btnDelete().shouldBe(clickable);
                ss = screenshots.takeScreen(getWebDriver(), "cart");
                test.pass("Product added successfully!" , MediaEntityBuilder.createScreenCaptureFromPath(ss).build());
                //Click and highlight the delete button
                highlight.HighlightElement(getWebDriver(), ct.btnDelete());
                ct.btnDelete().click();
                //Take the screenshot and handle the report
                ss = screenshots.takeScreen(getWebDriver(), "cartDel");
                test.pass("Product deleted successfully!" , MediaEntityBuilder.createScreenCaptureFromPath(ss).build());

            report.flush();

    }


}
