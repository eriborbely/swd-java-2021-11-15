package simple;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class SimpleFixtureTest {

    WebDriver driver;


    @BeforeAll
    static void initDriverManager(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver(){
        var options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", List.of("enable-automation"));
        driver = new ChromeDriver();
    }

    @AfterEach
    void closeDriver(){
        driver.quit();
    }


    @Test
//  @RepeatedIfExceptionsTest(repeats = 3)
    void testHeader(){
        driver.get("https://eriborbely.github.io/swd-java-2021-11-15");

        log.info("test header");
        WebElement header = driver.findElement(By.tagName("h1"));

        String text = header.getText();

        log.debug("Text is: " + text);

        assertEquals("Welcome", text);

    }


    @Test
    void testTitle(){
        driver.get("https://eriborbely.github.io/swd-java-2021-11-15");
    }



}
