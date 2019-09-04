package pl.qa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoadingPage extends BasePage {

    private static final String BASIC_URL = "https://cmegroup.com";

    private By searchExpander = By.cssSelector("button.searchExpander");
    private By inputSearch = By.name("search");
    private By searchButton = By.cssSelector("td.gsc-search-button");

    public LoadingPage(WebDriver driver) {
        super(driver, BASIC_URL);
    }

    public LoadingPage search(String searchInput) {
        driver.findElement(searchExpander).click();
        driver.findElement(inputSearch).sendKeys(searchInput);
        driver.findElement(searchButton).click();
        return this;
    }

}
