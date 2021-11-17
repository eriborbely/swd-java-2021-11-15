package components;

import extension.SeleniumTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SeleniumTest
class ComponentsTest {
    @Test
    void testNavigate(WebDriver driver, URL url) {
        driver.get(url + "/components");

        var checkbox = driver.findElement(By.cssSelector("#myform > input[type=checkbox]:nth-child(5)"));
        checkbox.click();

        assertTrue(checkbox.isSelected());

        var listbox = new Select(driver.findElement(By.id("dropdown")));
        listbox.selectByValue("option3");

        assertEquals("Option 3", listbox.getFirstSelectedOption().getText());

        var checkbox2 = driver.findElement(By.name("disabled-checkbox"));

        assertTrue(!checkbox2.isEnabled());


    }

}
