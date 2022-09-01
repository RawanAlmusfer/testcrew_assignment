package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.Map;

public class DummyTicketPage {
    WebDriver driver;
    Map<String, String> months = new HashMap<>();
    {
        months.put("january", "Jan");
        months.put("february", "Feb");
        months.put("march", "Mar");
        months.put("april", "Apr");
        months.put("may", "May");
        months.put("june", "Jun");
        months.put("july", "Jul");
        months.put("august", "Aug");
        months.put("september", "Sep");
        months.put("october", "Oct");
        months.put("november", "Nov");
        months.put("december", "Dec");
    }

    public DummyTicketPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement get_datepicker_field(){
        By dateField = By.xpath("//input[contains(@id, \"dob\")]");
        return driver.findElement(dateField);
    }

    public WebElement get_months_field(){
        By monthsField = By.xpath("//select[@class=\"ui-datepicker-month\"]");
        return driver.findElement(monthsField);
    }

    public WebElement get_month_from_list(String month){
        month = months.get(month.toLowerCase());
        By selectedMonth = By.xpath("//select[@class=\"ui-datepicker-month\"]/option[text()=\""
                + month +"\"]");
        return driver.findElement(selectedMonth);
    }

    public WebElement get_years_field(){
        By yearsField = By.xpath("//select[@class=\"ui-datepicker-year\"]");
        return driver.findElement(yearsField);
    }

    public WebElement get_year_from_list(int year){
        By selectedYear = By.xpath("//select[@class=\"ui-datepicker-year\"]/option[text()=\""
                + year +"\"]");
        return driver.findElement(selectedYear);
    }

    public WebElement get_day_from_datepicker(int day){
        By selectedDay = By.xpath("//a[text()=\""+ day +"\"]");
        return driver.findElement(selectedDay);
    }

}
