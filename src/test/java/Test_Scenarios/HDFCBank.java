package Test_Scenarios;

import Objects.HDFCBankPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static Test_Scenarios.Driver.takeSnapShot;

public class HDFCBank {

    WebDriver driver;
    Driver driverManger;

    @BeforeTest
    public void beforeTest() {
        this.driverManger = new Driver();
        this.driver = driverManger.driverSetUp();
        driver.manage().window().maximize();
        driver.get("https://www.hdfcbank.com/");
    }

    @Test
    public void selectFromDropdown() throws Exception {
        HDFCBankPage hdfcBankPage = new HDFCBankPage(driver);
        Thread.sleep(2000);
        hdfcBankPage.get_select_product_type_dropdown().click();
        hdfcBankPage.get_product_type_from_dropdown("Accounts").click();
        hdfcBankPage.get_select_product_dropdown().click();
        hdfcBankPage.get_product_from_dropdown("Savings Accounts").click();

        takeSnapShot(driver, "testcrew_assignment");
    }


    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
