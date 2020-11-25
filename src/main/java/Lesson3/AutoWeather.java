package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AutoWeather {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        SeleniumUtilities s = new SeleniumUtilities(driver);

        driver.get("https://yandex.ru/");
        s.findByLinkText("Погода").click();

        String curTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(curTab)) {
                driver.switchTo().window(tab);
            }
        }

        s.findByXpath("//input[@placeholder='Город или район']")
                .sendKeys("Омск" + Keys.ENTER);
        s.findByLinkText("Омск, Омская область").click();
        s.findByLinkText("На месяц").click();
    }
}
