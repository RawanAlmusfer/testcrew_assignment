package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
}
