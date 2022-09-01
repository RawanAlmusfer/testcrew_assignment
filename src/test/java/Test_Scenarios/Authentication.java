package Test_Scenarios;

import Objects.AuthenticationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Authentication {
    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        this.driver = new Driver().driverSetUp();
        driver.get("https://the-internet.herokuapp.com/basic_auth");
    }

    @Test
    public void authenticationPopup() throws InterruptedException {
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        String url = driver.getCurrentUrl().replaceAll("https://", "");
        String username = "admin";
        String password = "admin";
        String URL = "https://" + username  + ":" + password + "@" + url;
        driver.get(URL);
        Thread.sleep(3000);

        List<WebElement> messages = authenticationPage.get_authentication_message();
        assert messages.size() == 1;
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
