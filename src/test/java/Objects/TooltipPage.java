package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TooltipPage {
    WebDriver driver;

    public TooltipPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement get_age_input_field(){
        By ageField = By.xpath("//input[contains(@id, \"age\")]");
        return driver.findElement(ageField);
    }

    public WebElement get_tooltip() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement tooltip= wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//html/descendant-or-self::div[@role=\"tooltip\"]/div")
                )
        );
        return tooltip;
    }
}
