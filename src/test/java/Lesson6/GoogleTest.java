package Lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class GoogleTest {

    private WebDriver driver;

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void getDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
    }

    @Test
    @DisplayName("Search Google for Bing")
    void googleSearch() {
        String REQUEST = "Bing";

        new GooglePage(driver)
                .search(REQUEST)
                .clickFirstResult();
        assertEquals("Bing", driver.getTitle());
    }

    @Test
    @DisplayName("Search Images for Omsk")
    void imageSearch() {
        String REQUEST = "Omsk";

        new GooglePage(driver)
                .clickImagesLink()
                .search(REQUEST)
                .clickFirstResult();
        assertNotNull(driver.findElement(By.xpath("//div[@data-query='" + REQUEST + "']")));
    }

    @Test
    @DisplayName("Find route from Kremlin to Novo-Ogarevo")
    void findRoute() {
        String FROM = "Красная площадь Москва";
        String TO = "Ново-Огарево";

        new GooglePage(driver)
                .clickAppsButton()
                .switchToAppsFrame()
                .clickMapsButton()
                .clickRouteButton()
                .inputFromAddress(FROM)
                .inputToAddress(TO)
                .clickOnFoot();
        assertNotNull(driver.findElement(By.xpath("//div[@data-trip-index='0']")));
    }

    @Test
    @DisplayName("Find Google's Information retaining policy")
    void checkPolicy() {
        new GooglePage(driver)
                .clickPrivacyLink()
                .clickInfoRetainingLink();
        assertNotNull(driver.findElement(By.xpath("//div[@id='inforetaining']")));
    }


    @AfterEach
    public void quitDriver() {
        driver.quit();
    }
}
