package locations;


import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationEditPage {

    private WebDriver driver;

    @FindBy(css = "#locations-table-tbody > tr:nth-child(1) > td:nth-child(6) > button.btn.btn-link")
    private WebElement editLink;

    @FindBy(id = "update-location-name")
    private WebElement nameInput;

    @FindBy(id = "update-location-coords")
    private WebElement coordsInput;

    @FindBy(css = "#update-location-form > p > input.btn.btn-primary")
    private WebElement submitButton;

    @FindBy(id = "message-div")
    private WebElement messageDiv;

    public LocationEditPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public LocationEditPage clickOnEditLocation() {
        editLink.click();
        return this;
    }

    public LocationEditPage enterLocationData(String name, String coords) {
        nameInput.sendKeys(name);
        coordsInput.sendKeys(coords);
        return this;
    }

    public LocationEditPage enterLocationData() {
        enterLocationData("Home", "1,1");
        return this;
    }

    public LocationEditPage clickOnSubmitButton() {
        submitButton.click();
        return this;
    }

    public LocationEditPage messageIs(String expectedMessage) {
        var wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(messageDiv));

        var message = messageDiv.getText();
        assertEquals(expectedMessage, message);
        return this;
    }
}

