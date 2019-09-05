package pl.qa.selenium.factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

    public static WebDriver getInstance(){
        String desiredDriver = System.getProperty("browserType", "chrome");
        switch (desiredDriver) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Selenium-training\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                return new ChromeDriver(options);
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "target/geckodriver");
                return new FirefoxDriver();
            case "ie":
                return new InternetExplorerDriver();
            default:
                new IllegalStateException("You provided not supported type of browser. Use one of them: chrome, firefox, ie");
        }
        return null;
    }

}
