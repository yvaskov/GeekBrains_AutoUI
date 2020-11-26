package Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImagesResultsPage extends BasePage {

    @FindBy (xpath = "//div[@data-ri='0']")
    private WebElement firstResult;

    public ImagesResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ImagesResultsPage clickFirstResult() {
        visible(firstResult).click();
        return this;
    }
}
