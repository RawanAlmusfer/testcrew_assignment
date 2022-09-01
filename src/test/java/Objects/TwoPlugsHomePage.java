package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TwoPlugsHomePage {
    WebDriver driver;

    public TwoPlugsHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement go_to_live_posting(){
        By livePostingBtn = By.xpath("//a[contains(text(), \"Live Posting\")]");
        return driver.findElement(livePostingBtn);
    }

    public WebElement get_location_input_field() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement locationInput;
        locationInput= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("autocomplete")));
        return locationInput;
    }

    public WebElement get_dropdown_list() {
        By dropdown = By.xpath(
                "//select[@name=\"category_id\"]/.."
//                "//select[@name="category_id"]/following-sibling::div[@class="jq-selectbox__dropdown"]/ul"
        );
        return driver.findElement(dropdown);
    }

    public List<WebElement> get_dropdown_list_items() {
        WebElement parent = driver.findElement( By.xpath("" +
                "//select[@name=\"category_id\"]")
        );
        List<WebElement> children = parent.findElements(By.xpath("*"));
        return children;
    }
}
