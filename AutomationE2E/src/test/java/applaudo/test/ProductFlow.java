package applaudo.test;

import applaudo.pageObject.*;
import org.testng.annotations.*;
import utilities.ConditionExtension;
import utilities.ElementsExtension;
import java.io.IOException;
import static com.codeborne.selenide.Condition.*;

public class ProductFlow extends BaseE2E {

    @Test ()
    public void searchNegativeResult() throws IOException {
        //Create object to access the locators
        Home hm = new Home();
        //Access process to do the search
        hm.searchProcess("#");

    }

    @Test (priority = 1)
    public void searchPositiveResult() throws IOException {
        //Create object to access the locators
        Home hm = new Home();
        //Access process to do the search
        hm.searchProcess("dress");

    }

    @Test (priority = 2)
    public void cartWithProduct() throws IOException {
        //Create both objects to interact with the locators
        SearchResults sh = new SearchResults();

                //Click a product result of the search
                sh.product(1).shouldBe(ConditionExtension.clickable());
                ElementsExtension.highlightElement(sh.product(1)).click();
                //Click a product result of the search
                sh.addItem().shouldBe(ConditionExtension.clickable());
                ElementsExtension.highlightElement(sh.addItem()).click();
                //Check if item is clickable and click on the webpage
                sh.exit().shouldBe(ConditionExtension.clickable()).click();
                //Highlight and click to the cart button
                sh.cart().shouldBe(ConditionExtension.clickable());;
                ElementsExtension.highlightElement(sh.cart()).click();

    }

    @Test (priority = 3)
    public void cartEmpty() throws IOException {
        //Create both objects to interact with the locators
        Cart ct = new Cart();

        //Check if the delete button of the cart is available, then wait until the button of delete disappear
        ct.btnDelete().shouldBe(ConditionExtension.clickable());
        ElementsExtension.highlightElement(ct.btnDelete()).click();
        ct.btnDelete().should(disappear);
    }


}
