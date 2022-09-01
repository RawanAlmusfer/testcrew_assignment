package Test_Scenarios;


import Objects.TwoPlugsHomePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TwoPlugs {
    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
       this.driver = new Driver().driverSetUp();
        driver.get("https://www.twoplugs.com/");
    }

    @Test
    public void twoPlugsGoogleAutoComplete() throws InterruptedException {
        TwoPlugsHomePage twoPlugsHome = new TwoPlugsHomePage(driver);
        twoPlugsHome.go_to_live_posting().click();
        WebElement inputField = twoPlugsHome.get_location_input_field();
        inputField.clear();
        inputField.click();
        inputField.sendKeys("Toronto, OH");
        Thread.sleep(1000);
        inputField.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_RIGHT);
        Thread.sleep(1000);
        String location = inputField.getAttribute("value");
        assert location.equals("Toronto, OH, USA");
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
