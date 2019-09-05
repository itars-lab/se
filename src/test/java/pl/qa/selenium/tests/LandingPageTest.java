package pl.qa.selenium.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.qa.selenium.data.jdbc.dto.PersonDTO;
import pl.qa.selenium.data.jdbc.model.CurrencyDbUtils;
import pl.qa.selenium.pages.LoadingPage;
import pl.qa.selenium.pages.LoadingPagePf;

import java.util.List;
import java.util.regex.Pattern;

public class LandingPageTest extends BaseTest {

    private LoadingPage page;
    private LoadingPagePf pageInitializedByPageFactory;

    @BeforeEach
    public void setup() {
        super.setup();
        page = new LoadingPage(driver);
//        LoadingPagePf p = new LoadingPagePf(driver);
//        PageFactory.initElements(driver, p);
        pageInitializedByPageFactory = PageFactory.initElements(driver, LoadingPagePf.class);
    }

    @Test
    public void firstCmeTest() {
        driver.get("https://cmegroup.com");
        Assertions.assertEquals("CME Group Search", driver.getTitle(),
                "Custom message in case of fail");
    }

    @Test
    public void searchTestCmeGroup() throws InterruptedException {
        page.search("test cme selenium");
        Assertions.assertEquals(page.getTitle(), "CME group");
    }

    @Test
    public void searchTestCmeGroupPageFactory() throws InterruptedException {
        pageInitializedByPageFactory.search("test cme selenium");
        Assertions.assertEquals(page.getTitle(), "CME group");
    }


    @ParameterizedTest
    @MethodSource(value = "getUserNamesValueSource")
    public void goToPortfolio(PersonDTO userName) {
        By contextMenuArrow = By.cssSelector("#cmeMenuLogin > a");
        By xpath = By.xpath("//div[@id='cmeMenu']//li/a[text()='Login']");
        page.find(xpath);
        WebElement menu = page.find(contextMenuArrow);
        page.hover(xpath);
        WebElement myPortfolio = menu.findElement(By.xpath("//a[text()='My Portfolio']"));
        //todo debug it
//        menu.findElements(By.xpath("//*")).stream().map(WebElement::getText).collect(Collectors.toList())
        myPortfolio.getText();
        page.waitFor(ExpectedConditions.textMatches(By.xpath(""), Pattern.compile("")));
    }

    public static List<PersonDTO> getUserNamesValueSource() {
        List<PersonDTO> persons = new CurrencyDbUtils().getAllCurrences();
        return persons;
    }


}
