package htlmintro;

import extension.SeleniumTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SeleniumTest
class HtmlIntroTest {


    @Test
    void testTypeToInputThenCheckValue(WebDriver driver, URL url){
        driver.get(url + "/htmlintro");

        var input = driver.findElement(By.id("email-input"));
        input.sendKeys("example@example.com");


    }



}
