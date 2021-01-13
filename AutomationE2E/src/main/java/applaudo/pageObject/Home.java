package applaudo.pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.$;

public class Home {


    public SelenideElement searchbar () {
        return $(By.id("search_query_top"));
    }

    public SelenideElement searchButton () {
        return $(By.name("submit_search"));
    }

    public void scroll(SelenideElement element, WebDriver driver){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
