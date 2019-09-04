package pl.qa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoadingPage {

    private static final String BASIC_URL = "https://cmegroup.com";

    private WebDriver driver;
    private By searchExpander = By.cssSelector("button.searchExpander");
    private By inputSearch = By.name("search");
    private By searchButton = By.cssSelector("td.gsc-search-button");

    public LoadingPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get(BASIC_URL);
    }


    public LoadingPage search(String searchInput) {
        driver.findElement(searchExpander).click();
        driver.findElement(inputSearch).sendKeys(searchInput);
        driver.findElement(searchButton).click();
        return this;
    }


    public String getTitle() {
        return driver.getTitle();
    }
}
