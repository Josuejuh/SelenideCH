package applaudo.test;

import applaudo.pageObject.*;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;
import utilities.ElementsExtension;
import java.io.IOException;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;


public class FooterInfo extends BaseE2E {
    //Create object type Home for doing the assertion of the Store Info
    Home checkInfo = new Home();
    @Test
    public void checkStoreInfo() throws IOException {
        //Locate the main element of the information of the store in the footer and scroll to it
        SelenideElement footerStore = ElementsExtension.scroll($("#block_contact_infos").should(exist));
        //First subElement on the footer section and assertion
        checkInfo.footerInfo(footerStore,"Selenium Framework, Research Triangle Park, North Carolina, USA");
        //Second subElement on the footer section and assertion
        checkInfo.footerInfo(footerStore,"(347) 466-7432");
        //Third subElement on the footer section and assertion
        checkInfo.footerInfo(footerStore,"support@seleniumframework.com");
    }


}
