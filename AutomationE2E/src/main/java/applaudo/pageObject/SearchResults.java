package applaudo.pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchResults {


    public SelenideElement product(int i){
        return $(By.xpath("//ul[@class='product_list grid row']/li[" + i + "]"));
    }

    public SelenideElement addItem(){
        return $(By.xpath("//span[contains(text(),'Add to cart')]"));
    }

    public SelenideElement cart(){
        return $(By.cssSelector("a[title='View my shopping cart']"));
    }

    public SelenideElement exit () {
        return $(By.cssSelector("span[class='cross'][title='Close window']"));
    }

}
