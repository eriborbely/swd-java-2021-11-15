package grid;

import extension.SeleniumTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.locators.RelativeLocator.with;


@SeleniumTest
class GridTest {

    @Test
    void test(WebDriver driver, URL url) {
        driver.get(url + "/grid");

        var row = driver.findElements(By.cssSelector("tr:nth-child(2) > td"));

        assertThat(row)
                .extracting(WebElement::getText)
                .containsExactly("4", "5", "6");

    }

    @Test
    void testRelative(WebDriver driver, URL url) {
        driver.get(url + "/grid");

        var cell5 = driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(2)"));
        var cell2 = driver.findElement(with(By.cssSelector("td")).below(cell5));

        assertEquals("2", cell2.getText());



    }

}


