package applaudo.test;


import applaudo.pageObject.*;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import config.baseE2E;
import org.testng.annotations.Test;
import utilities.highlight;
import utilities.screenshots;
import java.io.IOException;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class footerInfo extends baseE2E {

    @Test
    public void storeInfo() throws IOException {
        //Create object Home for doing the scroll to the webElement
        Home ho = new Home();
        //Create a new line on the report for save the steps for this test on the report
        test = report.createTest("Store Information");

        //Locate the main element of the information of the store in the footer
        SelenideElement footerInfo = $("#block_contact_infos").should(exist);
        //Scroll to the element
        ho.scroll(footerInfo,getWebDriver());

        //First subElement on the footer section and assertion
        SelenideElement location = footerInfo.$(byText("Selenium Framework, Research Triangle Park, North Carolina, USA"));
        highlight.HighlightElement(getWebDriver(), location);
        location.shouldBe(Condition.visible);
        //Second subElement on the footer section and assertion
        SelenideElement number = footerInfo.$(byText("(347) 466-7432"));
        highlight.HighlightElement(getWebDriver(), number);
        number.shouldBe(Condition.visible);
        //Third subElement on the footer section and assertion
        SelenideElement mail = footerInfo.$(byText("support@seleniumframework.com"));
        highlight.HighlightElement(getWebDriver(), mail);
        mail.shouldBe(Condition.visible);

        //Taking and saving the screenshot and adding to the report
        String ss = screenshots.takeScreen(getWebDriver(), "cart");
        test.pass("Store information displayed correctly!" , MediaEntityBuilder.createScreenCaptureFromPath(ss).build());

        report.flush();

    }


}
