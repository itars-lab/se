package pl.qa.selenium.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    protected WebDriver driver;

    @BeforeAll
    public static void setUpEnv() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium-training\\chromedriver.exe");
    }

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void cleanUp() {
        driver.quit();
    }
}
