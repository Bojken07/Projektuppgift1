package se.reky.hakan.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
public class PlayerControllerTest {

    ChromeDriver driver;

    @BeforeAll
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void setUp () {
        driver = new ChromeDriver();
    }
    @AfterEach
    public void tearDown () {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void testPlayerAmount () {
        // Besöker sidan där spelare listas.
        driver.get("http://localhost:8080/players");
        // Hittar alla <li> element som representerar spelare.
        List<WebElement> elements = driver.findElements(By.tagName("li"));
        // Kontrollerar att antalet <li> element är 2.
        assertEquals(2, elements.size());
    }
    @Test
    public void testPlayerDisplayed () {
        // Besöker sidan där spelare listas.
        driver.get("http://localhost:8080/players");
        // Hittar det första <li> elementet som representerar en spelare.
        WebElement element = driver.findElement(By.tagName("li"));
        // Kontrollerar om elementet är synligt på sidan.
        assertTrue(element.isDisplayed());
    }
    @Test
    public void testTitle () {
        // Besöker sidan där spelare listas.
        driver.get("http://localhost:8080/players");
        // Hämtar titeln på sidan.
        String element = driver.getTitle();
        // Kontrollerar att titeln är korrekt.
        assertEquals("Players List", element);
    }
    @Test
    public void testButton () {
        // Besöker sidan där spelare listas.
        driver.get("http://localhost:8080/players");
        // Hittar knappen på sidan.
        WebElement element = driver.findElement(By.tagName("button"));
        // Kontrollerar att knappens text är "Logga in".
        assertEquals("Logga in", element.getText());
    }
    @Test
    public void testClick () {
        // Besöker sidan där spelare listas.
        driver.get("http://localhost:8080/players");
        // Skapar en väntan för att vänta på att elementet blir synligt.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Hittar alla länkar på sidan.
        List <WebElement> elements = driver.findElements(By.tagName("a"));
        // Klickar på den första länken.
        elements.get(0).click();
        // Väntar på att en rubrik blir synlig på den nya sidan.
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));
        // Kontrollerar att rubriken har rätt text.
        assertTrue(element.isDisplayed());
        assertEquals("Kalle", element.getText());
    }

    //VG delen.
    @Test
    public void shouldReturnExpOnClickedEndPoint () {
        driver.get("http://localhost:8080/players");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List <WebElement> elements = driver.findElements(By.tagName("a"));

        elements.get(0).click();

        List<WebElement> webElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.tagName("span")));

        webElements.get(2);

        assertEquals("35", webElements.get(2).getText());

    }
}
