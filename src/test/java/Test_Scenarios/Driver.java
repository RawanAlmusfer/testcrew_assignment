package Test_Scenarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import java.util.concurrent.TimeUnit;

public class Driver {
        WebDriver driver;

    public WebDriver driverSetUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions capability = new ChromeOptions();
        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
        driver = new ChromeDriver(capability);
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        return driver;
    }
}
