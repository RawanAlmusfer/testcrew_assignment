package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleSearchPage {
    WebDriver driver;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement get_search_field(){
        By searchField = By.xpath("//input[@title=\"Search\"]");
        return driver.findElement(searchField);
    }

    public List<WebElement> get_auto_suggestions(){
        By suggestions = By.xpath(
                "//ul[@role=\"listbox\" and @class=\"G43f7e\"]/li//div[@role=\"option\"]/div[1]/span"
        );
        return driver.findElements(suggestions);
    }
}
