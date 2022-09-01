package Test_Scenarios;

import Objects.TooltipPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Tooltip {
    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        this.driver = new Driver().driverSetUp();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/tooltip/");
    }

    @Test
    public void captureTooltip() throws InterruptedException {
        TooltipPage tooltipPage = new TooltipPage(driver);
        Thread.sleep(1000);
        WebElement iFrame = driver.findElements(By.tagName("iframe")).get(0);
        driver.switchTo().frame(iFrame);
        WebElement ageField = tooltipPage.get_age_input_field();
        Actions action = new Actions(driver);
        action.moveToElement(ageField).build().perform();
        WebElement toolTip = tooltipPage.get_tooltip();
        String toolTipText = toolTip.getText();
        assert toolTipText.equals("We ask for your age only for statistical purposes.");
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
