package Test_Scenarios;


import Objects.TwoPlugsHomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class TwoPlugs {
    WebDriver driver;
    Map<Integer, String> dropdownItems = new HashMap<>();

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

    @Test
    public void twoPlugsSortDropdown() {
        TwoPlugsHomePage twoPlugsHome = new TwoPlugsHomePage(driver);
        twoPlugsHome.go_to_live_posting().click();
        twoPlugsHome.get_dropdown_list().click();
        List<WebElement> items = twoPlugsHome.get_dropdown_list_items();
        for(WebElement element : items) {
            int value = Integer.parseInt(element.getAttribute("value"));
            dropdownItems.put(value, element.getText());
        }
        sortList(dropdownItems);
    }

    public void sortList(Map<Integer, String> list)
    {
        TreeMap<Integer, String> items_asc = new TreeMap<>(list);

        System.out.println("List in Ascending order: ");
        for (Map.Entry<Integer, String> entry : items_asc.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());

        System.out.println("List in Descending order: ");
        for(int key : items_asc.descendingKeySet()){
            System.out.println("Key = " + key +
                    ", Value = " + items_asc.get(key));
        }
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
