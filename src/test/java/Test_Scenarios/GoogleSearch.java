package Test_Scenarios;

import Objects.GoogleSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

import static Test_Scenarios.Driver.takeSnapShot;

public class GoogleSearch {
    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        this.driver = new Driver().driverSetUp();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/webhp?hl=en");
    }

    @Test
    public void googleSearchSuggestions() throws Exception {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(driver);
        WebElement searchField = googleSearchPage.get_search_field();
        searchField.sendKeys("java tutorial");
        searchField.click();
        Thread.sleep(2000);
        List<WebElement> items = googleSearchPage.get_auto_suggestions();
        for(WebElement element : items) {
            if (element.getText().contains("geeksforgeeks")){
                element.click();
                break;
            }
        }
        Thread.sleep(2000);
        takeSnapShot(driver, "testcrew_assignment");
    }


    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
