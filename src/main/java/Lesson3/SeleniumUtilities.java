package Lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumUtilities {

    WebDriver driver;

    public SeleniumUtilities(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement findByLinkText(String linkText) {
        return driver.findElement(By.linkText(linkText));
    }
}
