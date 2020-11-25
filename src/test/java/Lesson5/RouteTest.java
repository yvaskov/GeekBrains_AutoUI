package Lesson5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static org.junit.jupiter.api.Assertions.*;

public class RouteTest extends BaseTest {

    private static String URL = "https://yandex.ru/";
    private static String FROM_ADDRESS = "Красная площадь Москва";
    private static String TO_ADDRESS = "Государственная резиденция Ново-Огарёво";

    @Test
    @DisplayName("Find route")
    void findRoute() {

        driver.get(URL);

        s.findByXpath("//a[@data-id='maps']").click();
        assertEquals(2, driver.getWindowHandles().size());

        String curTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(curTab)) {
                driver.switchTo().window(tab);
                assertNotEquals(driver.getWindowHandle(), curTab);
            }
        }

        s.findByXpath("//div[@class='route-control']").click();
        s.findByXpath("//input[@placeholder='Откуда']")
                .sendKeys(FROM_ADDRESS + Keys.ENTER);
        s.findByXpath("//input[@placeholder='Куда']")
                .sendKeys(TO_ADDRESS + Keys.ENTER);
        s.findByXpath("//div[@class='route-travel-modes-view__mode _mode_pedestrian']").click();
        assertNotNull(s.findByXpath("//div[@class='pedestrian-route-snippet-view']"));
    }
}
