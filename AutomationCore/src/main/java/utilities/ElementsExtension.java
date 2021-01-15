package utilities;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;


public class ElementsExtension {

    public static SelenideElement highlightElement(SelenideElement element) {
        String js = "arguments[0].setAttribute('style', 'background: yellow; border: 3px solid red;');";
        Selenide.executeJavaScript(js, element);
        return element;
    }

    public static SelenideElement unhighlightElement(SelenideElement element) {
        String js = "arguments[0].setAttribute('style', 'background: white; border: ''');";
        Selenide.executeJavaScript(js, element);
        return element;
    }

    public static void scroll(SelenideElement element){
        element.scrollIntoView(true);
    }

}
