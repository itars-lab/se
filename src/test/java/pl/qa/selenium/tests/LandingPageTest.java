package pl.qa.selenium.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.qa.selenium.pages.LoadingPage;

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
        Assertions.assertEquals(page.getTitle(), "CME group");
    }


}
