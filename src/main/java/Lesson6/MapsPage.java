package Lesson6;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MapsPage extends BasePage {

    @FindBy (xpath = "//button[@id='searchbox-directions']")
    private WebElement routeButton;

    @FindBy (xpath = "//div[@id='directions-searchbox-0']//input")
    private WebElement fromAddress;

    @FindBy (xpath = "//div[@id='directions-searchbox-1']//input")
    private WebElement toAddress;

    @FindBy (xpath = "//div[@data-travel_mode='2']")
    private WebElement onFootButton;

    public MapsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MapsPage clickRouteButton() {
        visible(routeButton).click();
        return this;
    }

    public MapsPage inputFromAddress(String address) {
        visible(fromAddress).sendKeys(address + Keys.ENTER);
        return this;
    }

    public MapsPage inputToAddress(String address) {
        visible(toAddress).sendKeys(address + Keys.ENTER);
        return this;
    }

    public MapsPage clickOnFoot() {
        visible(onFootButton).click();
        return this;
    }
}
