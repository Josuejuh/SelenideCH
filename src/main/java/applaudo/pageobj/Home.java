package applaudo.pageobj;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;

public class Home {


    public SelenideElement searchbar () {
        return $(By.id("search_query_top"));
    }

    public SelenideElement searchButton () {
        return $(By.name("submit_search"));
    }

    public SelenideElement contact01(){
        return $(By.xpath("//section[@id='block_contact_infos']/div[1]/ul[@class='toggle-footer']/li[1]"));
    }

    public SelenideElement contact02(){
        return $(By.xpath("//section[@id='block_contact_infos']/div[1]/ul[@class='toggle-footer']/li[2]/span[1]"));
    }

    public SelenideElement contact03(){
        return $(By.xpath("//section[@id='block_contact_infos']/div[1]/ul[@class='toggle-footer']/li[3]/span[1]/a[1]"));
    }

    public void scroll(SelenideElement element, WebDriver driver){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitHm() throws InterruptedException {
    Thread.sleep(3000);
    }

}
