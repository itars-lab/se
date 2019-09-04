package pl.qa.selenium.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected FluentWait fluentWait;
    private String pageUrl;

    public BasePage(WebDriver driver, String pageUrl) {
        this.driver = driver;
        this.pageUrl = pageUrl;
        this.wait = new WebDriverWait(driver, 10L);
        this.fluentWait = new FluentWait(driver)
                .ignoring(NoSuchElementException.class)
                .withTimeout(Duration.ZERO);
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

    /**
     * new Page().visit()
     */
    public BasePage visit() {
        this.driver.get(pageUrl);
        return this;
    }

}
