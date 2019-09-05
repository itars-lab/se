package pl.qa.selenium.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pl.qa.selenium.factories.DriverFactory;

public class BaseTestDriverFactory {

    protected WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = DriverFactory.getInstance();
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
