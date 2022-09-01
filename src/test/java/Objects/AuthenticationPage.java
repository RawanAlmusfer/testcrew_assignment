package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AuthenticationPage {
    WebDriver driver;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> get_authentication_message() {
        By message = By.xpath("//p[contains(text(), \"Congratulations! You must have the proper credentials.\")]");
        return driver.findElements(message);
    }
}
