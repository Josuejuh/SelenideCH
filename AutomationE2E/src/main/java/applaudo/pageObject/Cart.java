package applaudo.pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Cart {

    public SelenideElement btnDelete(){
        return $(By.cssSelector("a[title='Delete'][class='cart_quantity_delete']"));
    }



}
