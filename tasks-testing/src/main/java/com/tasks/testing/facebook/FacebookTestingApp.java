package com.tasks.testing.facebook;

import com.tasks.testing.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public static final String XPATH_REGISTER = "//a[@role=\"button\"]";
    public static final String XPATH_WAIT = "//select[1]";
    public static final String XPATH_DAY = "//div[@class=\"_5k_5\"]/span/span/select[1]";
    public static final String XPATH_MONTH = "//div[@class=\"_5k_5\"]/span/span/select[2]";
    public static final String XPATH_YEAR = "//div[@class=\"_5k_5\"]/span/span/select[3]";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        while (!driver.findElement(By.xpath(XPATH_REGISTER)).isDisplayed());

        WebElement webElement = driver.findElement(By.xpath(XPATH_REGISTER));
        webElement.click();
        Thread.sleep(1000);

        while (!driver.findElement(By.xpath(XPATH_WAIT)).isDisplayed());

        WebElement dayElement = driver.findElement(By.xpath(XPATH_DAY));
        Select selectDay = new Select(dayElement);
        selectDay.selectByIndex(3);

        WebElement monthElement = driver.findElement(By.xpath(XPATH_MONTH));
        Select selectMonth = new Select(monthElement);
        selectMonth.selectByIndex(5);

        WebElement yearElement = driver.findElement(By.xpath(XPATH_YEAR));
        Select selectYear = new Select(yearElement);
        selectYear.selectByIndex(5);
    }
}
