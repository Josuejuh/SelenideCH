package applaudo.test;

import applaudo.pageObject.*;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.io.IOException;
import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selenide.$;
import static utilities.ConditionExtension.clickable;

public class ProductFlow extends BaseE2E {
    //Create objects to interact with the respective locators and actions
    Home searching = new Home();
    SearchResults resultsHandle = new SearchResults();
    Cart deleteProductsOnCart = new Cart();

    @Test ()
    public void searchNegativeResult() throws IOException {
        //Access process to do the search
        searching.searchProcess("#");
        //Assertion to check if the search doesn't return anything
        $(By.xpath("//p[contains(text(),'No results were found for your search')]")).shouldBe(visible);
    }

    @Test (priority = 1)
    public void searchPositiveResult() throws IOException {
        //Access process to do the search
        searching.searchProcess("dress");
        //Assertion to check if the search return something
        resultsHandle.getProductInfoByIndex(1).shouldBe(visible);
    }

    @Test(priority = 2)
    public void cartWithProduct() throws IOException {
        //Click a product result of the search
        resultsHandle.getProductInfoByIndex(1).click();
        //Add item to cart
        resultsHandle.addItemToCart().click();
        //Check if item is clickable and close thw windows popUp
        resultsHandle.exitPopUp().click();
        //Highlight and click to the cart button
        resultsHandle.productsOnCart().click();
        //Assertion to check if the cart contains something
        deleteProductsOnCart.btnDeleteProductsFromCart().shouldBe(visible);
    }

    @Test (priority = 3)
    public void cartEmpty() throws IOException {
        //Check if the delete button of the cart is available
        deleteProductsOnCart.btnDeleteProductsFromCart().shouldBe(clickable).click();
        //Then wait until the button of delete disappear, assertion if the cart is empty
        deleteProductsOnCart.btnDeleteProductsFromCart().shouldBe(disappear);
    }


}
