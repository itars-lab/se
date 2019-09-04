package pl.qa.selenium.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.qa.selenium.pages.LoadingPage;

import java.util.regex.Pattern;

public class LandingPageTest extends BaseTest {

    private LoadingPage page;

    @BeforeEach
    public void setup() {
        super.setup();
        page = new LoadingPage(driver);
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
        page.find(By.cssSelector("sdjahsjkdhasd"));
        Assertions.assertEquals(page.getTitle(), "CME group");
    }

    @Test
    public void goToPortfolio() {
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


}
