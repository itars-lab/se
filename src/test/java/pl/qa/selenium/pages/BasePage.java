package pl.qa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

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
        this.visit();
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

    public WebElement find(By locator) {
        return this.driver.findElement(locator);
    }

    public WebElement findFileSafe(By locator) {
        List<WebElement> elements = this.driver.findElements(locator);
        if (elements.isEmpty()) {
            return null;
        }
        return elements.get(0);
    }

    public BasePage click(By locator) {
        this.find(locator).click();
        return this;
    }

    public BasePage clickFailSafe(By locator) {
        List<WebElement> elements = this.driver.findElements(locator);
        if (elements.isEmpty()) {
            return this;
        }
        elements.get(0).click();
        return this;
    }

    public Boolean waitFor(Function<WebDriver, Boolean> expectedCondition) {
        return (Boolean) fluentWait.until(expectedCondition);
    }

    public void waitFor(ExpectedCondition<WebElement> expectedCondition, Integer timoeout) {
        new WebDriverWait(driver, timoeout).until(expectedCondition);
    }

    public WebElement hover(By locator) {
        Actions actions = new Actions(driver);
        WebElement target = this.find(locator);
        actions.moveToElement(target).perform();
        return target;
    }


    /**
     * @param input
     * @param locator
     */
    public void type(String input, By locator) {
        find(locator).clear();
        find(locator).sendKeys(input);
    }

    public void submit(By locator) {
        find(locator).submit();
    }

    public String getTextOf(By locator) {
        return find(locator).getText();
    }

    /**
     * @param locator
     * @return
     */
    public Boolean isDisplayed(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * @param locator
     * @param timeout
     * @return
     */
    public Boolean waitForIsDisplayed(By locator, Integer timeout) {
        try {
            waitFor(ExpectedConditions.visibilityOfElementLocated(locator), timeout);
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public void doubleClick(By locator) {
        // todo You Actions class
    }

}
