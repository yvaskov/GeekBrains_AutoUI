package Lesson5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherTest extends BaseTest {

    private static String URL = "https://yandex.ru/";

    @Test
    @DisplayName("Check weather")
    void checkWeather() {

        driver.get(URL);

        s.findByLinkText("Погода").click();
        assertEquals(2, driver.getWindowHandles().size());

        String curTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(curTab)) {
                driver.switchTo().window(tab);
                assertNotEquals(driver.getWindowHandle(), curTab);
            }
        }

        s.findByXpath("//input[@placeholder='Город или район']")
                .sendKeys("Омск" + Keys.ENTER);
        s.findByLinkText("Омск, Омская область").click();
        s.findByLinkText("На месяц").click();
        assertNotNull(s.findByXpath("//h1[text()='Погода в Омске на месяц']+"));
    }
}
