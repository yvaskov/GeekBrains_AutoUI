package Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LegalPage extends BasePage {

    @FindBy (xpath = "//a[contains(@href,'inforetaining')]")
    private WebElement infoRetainingLink;

    public LegalPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LegalPage clickInfoRetainingLink() {
        visible(infoRetainingLink).click();
        return this;
    }
}
