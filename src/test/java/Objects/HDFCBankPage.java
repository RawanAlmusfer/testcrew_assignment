package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HDFCBankPage {

    WebDriver driver;

    public HDFCBankPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement get_select_product_type_dropdown() {
        By selectType = By.xpath(
                "//a[text()=\"Select Product Type\"]"
        );
        return driver.findElement(selectType);
    }

    public WebElement get_product_type_from_dropdown(String type) {
        By selectedType = By.xpath(
                "//a[text()=\"Select Product Type\"]/following-sibling::ul/li[text()=\""
                + type + "\"]"
        );
        return driver.findElement(selectedType);
    }

    public WebElement get_select_product_dropdown() {
        By selectProduct = By.xpath("//a[text()=\"Select Product\"]");
        return driver.findElement(selectProduct);
    }

    public WebElement get_product_from_dropdown(String product) {
        By selectedProduct = By.xpath(
                "//a[text()=\"Select Product\"]/following-sibling::ul/li[text()=" +
                        "\"" + product + "\"]"
        );
        return driver.findElement(selectedProduct);
    }

}
