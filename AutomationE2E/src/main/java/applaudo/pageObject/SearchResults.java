package applaudo.pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utilities.ElementsExtension;

import static com.codeborne.selenide.Selenide.$;
import static utilities.ConditionExtension.clickable;

public class SearchResults {


    public SelenideElement getProductInfoByIndex(int i) {
        return ElementsExtension.highlightElement($(By.xpath("//ul[@class='product_list grid row']/li[" + i + "]")).shouldBe(clickable));
    }

    public SelenideElement addItemToCart(){
        return ElementsExtension.highlightElement($(By.xpath("//span[contains(text(),'Add to cart')]")).shouldBe(clickable));
    }

    public SelenideElement cartProducts(){
        return ElementsExtension.highlightElement($(By.cssSelector("a[title='View my shopping cart']")).shouldBe(clickable));
    }

    public SelenideElement exitPopUp () {
        return $(By.cssSelector("span[class='cross'][title='Close window']")).shouldBe(clickable);
    }

}
