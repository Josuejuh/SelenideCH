package applaudo.pageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utilities.ConditionExtension;
import utilities.ElementsExtension;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Home {


    public SelenideElement searchBar () {
        return $(By.id("search_query_top"));
    }

    public SelenideElement searchButton () {
        return $(By.name("submit_search"));
    }

    public void searchProcess (String chain){
         //Check if the elements are on the webpage
        searchBar().shouldBe(Condition.visible);
        searchButton().shouldBe(ConditionExtension.clickable());
        //Highlight, clear and write on the search bar
        ElementsExtension.highlightElement(searchBar()).clear();
        searchBar().sendKeys(chain);
        //Highlight and click on the button for doing the search
        ElementsExtension.highlightElement(searchButton()).click();
    }

    public void footerInfo (SelenideElement element, String txt){
        SelenideElement check = element.$(byText(txt));
        ElementsExtension.highlightElement(check).shouldBe(Condition.visible);
    }



}
