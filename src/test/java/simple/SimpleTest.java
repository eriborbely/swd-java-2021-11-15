package simple;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SimpleTest {

    @Test
    @DisplayName("Add")
    void testAdd(){
        int a = 5;
        int b = 6;

        int c = a + b;

        assertEquals(11, c);
    }

    @Test
    @DisplayName("Header")
    void testHeader(){
        WebDriverManager.chromedriver().setup();

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://eriborbely.github.io/swd-java-2021-11-15");

        webDriver.quit();

    }
}
