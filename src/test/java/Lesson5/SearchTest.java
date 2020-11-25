package Lesson5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static org.junit.jupiter.api.Assertions.*;

public class SearchTest extends BaseTest {

    private static String URL = "https://www.google.com/";

    @Test
    @DisplayName("Search for Bing")
    void searchBing() {

        driver.get(URL);

        s.findByXpath("//input[@type='text']")
                .sendKeys("Bing" + Keys.ENTER);
        assertNotNull(s.findByXpath("//div[@id='search']"));

        s.findByXpath("//a[@href='http://www.bing.com/']").click();
        assertNotNull(s.findByXpath("//h1[@class='logo_cont']"));
    }
}
