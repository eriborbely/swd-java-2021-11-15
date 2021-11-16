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
    void testLocators(WebDriver driver, URL url){
        driver.get(url + "/htmlintro");

        var headerOne  = driver.findElement(By.id("page-header")).getText();
        assertEquals("Intro html format", headerOne);

        var emailInput  = driver.findElement(By.name("email"));
        emailInput.sendKeys("test");

        var link = driver.findElement(By.partialLinkText("page"));
        assertEquals("Training360 page", link.getText());

        var headerByClass = driver.findElement(By.className("red"));
        assertEquals("Intro html format", headerByClass.getText());

        var headerTwo = driver.findElement(By.cssSelector("body > h1:nth-child(3)"));

        var linkByTagname = driver.findElement(By.tagName("a"));
        assertEquals("Training360 page", linkByTagname.getText());

        var headerByXpath = driver.findElement(By.xpath("/html/body/h1[2]"));
        assertEquals("Header two", headerByXpath.getText());

    }

    @Test
    void testTypeToInputThenCheckValue(WebDriver driver, URL url){
        driver.get(url + "/htmlintro");

        var input = driver.findElement(By.id("email-input"));
        input.sendKeys("example@example.com");

        //var text = input.getAttribute("value");
        var text = input.getDomProperty("value");
        assertEquals("example@example.com", text);

    }



}
