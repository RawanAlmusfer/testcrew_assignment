package Test_Scenarios;

import Objects.SeleniumOverviewPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static Test_Scenarios.Driver.takeSnapShot;

public class SeleniumOverview {
    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        this.driver = new Driver().driverSetUp();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
    }

    @Test
    public void seleniumOverviewFrames() throws Exception {
        SeleniumOverviewPage seleniumOverviewPage = new SeleniumOverviewPage(driver);
        driver.switchTo().frame("packageListFrame");
        driver.switchTo().parentFrame();
        driver.switchTo().frame("packageFrame");
        driver.switchTo().parentFrame();
        driver.switchTo().frame("classFrame");
        seleniumOverviewPage.get_first_table_element().click();

        Thread.sleep(2000);
        takeSnapShot(driver, "testcrew_assignment");
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
