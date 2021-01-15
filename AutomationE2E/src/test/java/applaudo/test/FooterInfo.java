package applaudo.test;

import applaudo.pageObject.*;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;
import utilities.ElementsExtension;
import java.io.IOException;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;


public class FooterInfo extends BaseE2E {

    @Test
    public void checkStoreInfo() throws IOException {
        //Create object Home for doing the scroll to the webElement
        Home ho = new Home();
        //Locate the main element of the information of the store in the footer
        SelenideElement footerInfo = $("#block_contact_infos").should(exist);
        //Scroll to the element
        ElementsExtension.scroll(footerInfo);

        //First subElement on the footer section and assertion
        ho.footerInfo(footerInfo,"Selenium Framework, Research Triangle Park, North Carolina, USA");
        //Second subElement on the footer section and assertion
        ho.footerInfo(footerInfo,"(347) 466-7432");
        //Third subElement on the footer section and assertion
        ho.footerInfo(footerInfo,"support@seleniumframework.com");

    }


}
