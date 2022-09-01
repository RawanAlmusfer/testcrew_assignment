package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumOverviewPage {
    WebDriver driver;

    public SeleniumOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement get_first_table_element(){
        By element = By.xpath("//table[@class=\"overviewSummary\"]//th/a");
        return driver.findElement(element);
    }

}
