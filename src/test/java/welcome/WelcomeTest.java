package htlmintro;

import extension.SeleniumTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SeleniumTest
class WelcomeTest {


    @Test
    void testTypeToInputThenCheckValue(WebDriver driver, URL url){
        driver.get(url + "/welcome");

        var input = driver.findElement(By.id("name-input"));
        input.sendKeys("teszt");

        var submit = driver.findElement(By.id("welcome-button"));
        submit.click();

        var text = driver.findElement(By.id("welcome-div"));

        assertEquals("Hello teszt!", text.getText());


    }



}
