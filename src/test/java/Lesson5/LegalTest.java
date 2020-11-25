package Lesson5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

public class LegalTest extends BaseTest {

    private static String URL = "https://www.google.com/";

    @Test
    @DisplayName("Check legal docs")
    void legalDocs() {

        driver.get(URL);
        driver.manage().window().maximize();

        s.findByXpath("//a[contains(@href,'com/privacy')]").click();
        assertTrue(driver.findElements(By.xpath("//a[contains(@href,'intro')]")).size() > 0);

        s.findByXpath("//a[contains(@href,'inforetaining')]").click();
        assertNotNull(s.findByXpath("//div[@id='inforetaining']"));
    }
}
