package Lesson6;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage extends BasePage {

    @FindBy (xpath = "//input[@type='text']")
    private WebElement searchField;

    @FindBy (xpath = "//a[contains(@href,'products')]")
    private WebElement appsButton;

    @FindBy (xpath = "//iframe")
    private WebElement appsFrame;

    @FindBy (xpath = "//a[contains(@href,'maps')]")
    private WebElement mapsButton;

    @FindBy (xpath = "//a[contains(@href,'img')]")
    private WebElement imagesLink;

    @FindBy (xpath = "//a[contains(@href,'com/privacy')]")
    private WebElement privacyLink;

    public GooglePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GooglePage clickAppsButton() {
        visible(appsButton).click();
        return this;
    }

    public GooglePage switchToAppsFrame() {
        driver.switchTo().frame(appsFrame);
        return this;
    }

    public MapsPage clickMapsButton() {
        visible(mapsButton).click();
        return new MapsPage(driver);
    }

    public SearchResultsPage search(String request) {
        visible(searchField).sendKeys(request + Keys.ENTER);
        return new SearchResultsPage(driver);
    }

    public ImagesPage clickImagesLink() {
        visible(imagesLink).click();
        return new ImagesPage(driver);
    }

    public LegalPage clickPrivacyLink() {
        visible(privacyLink).click();
        return new LegalPage(driver);
    }
}
