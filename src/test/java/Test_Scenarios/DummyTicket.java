package Test_Scenarios;

import Objects.DummyTicketPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static Test_Scenarios.Driver.takeSnapShot;

public class DummyTicket {
    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        this.driver = new Driver().driverSetUp();
        driver.manage().window().maximize();
        driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
    }

    @Test
    public void dummyTicketDatePicker() throws Exception {
        DummyTicketPage dummyTicketPage = new DummyTicketPage(driver);

        WebElement datapicker = dummyTicketPage.get_datepicker_field();

        Actions actions = new Actions(driver);
        actions.moveToElement(datapicker);
        datapicker.click();

        dummyTicketPage.get_months_field().click();
        dummyTicketPage.get_month_from_list("june").click();
        dummyTicketPage.get_years_field().click();
        dummyTicketPage.get_year_from_list(2005).click();
        dummyTicketPage.get_day_from_datepicker(30).click();
        Thread.sleep(2000);

        takeSnapShot(driver, "testcrew_assignment");

    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
