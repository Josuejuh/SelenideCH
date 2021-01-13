package applaudo.test;


import applaudo.pageObject.*;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.codeborne.selenide.Condition;
import config.baseE2E;
import org.testng.annotations.Test;
import utilities.highlight;
import utilities.screenshots;
import java.io.IOException;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class footerInfo extends baseE2E {

    @Test
    public void storeInfo() throws IOException {
        Home ho = new Home();
        test = report.createTest("Store Information");
        ho.contact01().shouldBe(Condition.visible);

        ho.scroll(ho.contact01(),getWebDriver());
        highlight.HighlightElement(getWebDriver(), ho.contact01());
        highlight.HighlightElement(getWebDriver(), ho.contact02());
        highlight.HighlightElement(getWebDriver(), ho.contact03());

        ho.contact01().shouldHave(Condition.text("Selenium Framework, Research Triangle Park, North Carolina, USA"));
        ho.contact02().shouldHave(Condition.text("(347) 466-7432"));
        ho.contact03().shouldHave(Condition.text("support@seleniumframework.com"));

        String ss = screenshots.takeScreen(getWebDriver(), "cart");
        test.pass("Store information displayed correctly!" , MediaEntityBuilder.createScreenCaptureFromPath(ss).build());

        report.flush();

    }


}
