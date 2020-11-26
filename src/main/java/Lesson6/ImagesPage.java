package Lesson6;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImagesPage extends BasePage {

    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchField;

    public ImagesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ImagesResultsPage search(String request) {
        visible(searchField).sendKeys(request + Keys.ENTER);
        return new ImagesResultsPage(driver);
    }
}
