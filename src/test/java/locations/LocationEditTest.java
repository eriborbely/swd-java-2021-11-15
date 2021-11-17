package locations;

import extension.SeleniumTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@SeleniumTest
@Tag("locations")
public class LocationEditTest {

    @Test
    void testEdit(WebDriver driver) {
        new LocationPage(driver)
                .go();

        new LocationEditPage(driver)
                .clickOnEditLocation()
                .clickOnSubmitButton()
                .messageIs("Location has been modified");

    }
}
