package applaudo.pageObject;

import com.codeborne.selenide.SelenideElement;
import utilities.ElementsExtension;
import static com.codeborne.selenide.Selenide.$;


public class Cart {

    public SelenideElement btnDeleteProductsFromCart(){
        return ElementsExtension.highlightElement($("a[title='Delete'][class='cart_quantity_delete']"));
    }


}
