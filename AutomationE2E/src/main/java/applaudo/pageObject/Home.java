package applaudo.pageObject;


import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utilities.ElementsExtension;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static utilities.ConditionExtension.clickable;

public class Home {

    private String searchBar = "#search_query_top";

    public void searchProcess (String chain){
         //Highlight element, check if it is clickable and then send the text to it
        ElementsExtension.highlightElement($(searchBar).shouldBe(clickable)).val(chain);
        //Highlight element, check if it is clickable and then click the search button
        ElementsExtension.highlightElement($(By.name("submit_search")).shouldBe(clickable)).click();

    }

    public void footerInfoCheck (SelenideElement element, String txt){
        ElementsExtension.highlightElement(element.$(byText(txt))).shouldBe(visible);
    }



}
