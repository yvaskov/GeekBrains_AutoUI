package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AutoRoute {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        SeleniumUtilities s = new SeleniumUtilities(driver);

        driver.get("https://yandex.ru/");
        s.findByXpath("//a[@data-id='maps']").click();

        String curTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(curTab)) {
                driver.switchTo().window(tab);
            }
        }

        s.findByXpath("//div[@class='route-control']").click();
        s.findByXpath("//input[@placeholder='Откуда']")
                .sendKeys("Красная площадь Москва" + Keys.ENTER);
        s.findByXpath("//input[@placeholder='Куда']")
                .sendKeys("Государственная резиденция Ново-Огарёво" + Keys.ENTER);
        s.findByXpath("//div[@class='route-travel-modes-view__mode _mode_pedestrian']").click();
    }
}
