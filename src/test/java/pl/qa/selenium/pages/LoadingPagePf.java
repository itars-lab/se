package pl.qa.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoadingPagePf extends BasePage {

    private static final String BASIC_URL = "https://cmegroup.com";

    @FindBy(css = "button.searchExpander")
    private WebElement searchExpander;
    @FindBy(name = "search")
    private WebElement inputSearch;
    @FindBy(css = "td.gsc-search-button")
    private WebElement searchButton;

    public LoadingPagePf(WebDriver driver) {
        super(driver, BASIC_URL);
    }

    public LoadingPagePf search(String searchInput) {
        searchExpander.click();
        inputSearch.sendKeys(searchInput);
        searchButton.click();
        return this;
    }

}
