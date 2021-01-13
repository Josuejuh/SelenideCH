package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class highlight {
    public static WebDriver HighlightElement(WebDriver driver, WebElement element) {
        if (driver instanceof JavascriptExecutor) {
            //((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "background-color: yellow; border: 3px solid red;");
        }
        return driver;
    }

    public static WebDriver UnhighlightElement(WebDriver driver, WebElement element) {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", element);
        }
        return driver;
    }

}
