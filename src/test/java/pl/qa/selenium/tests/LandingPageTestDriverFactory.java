package pl.qa.selenium.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import pl.qa.selenium.pages.LoadingPagePf;

public class LandingPageTestDriverFactory extends BaseTestDriverFactory {

    private LoadingPagePf pageInitializedByPageFactory;

    @BeforeEach
    public void setup() {
        super.setup();
        pageInitializedByPageFactory = PageFactory.initElements(driver, LoadingPagePf.class);
    }

    @Test
    public void searchTestCmeGroupPageFactory() throws InterruptedException {
        pageInitializedByPageFactory.search("test cme selenium");
        Assertions.assertEquals(pageInitializedByPageFactory.getTitle(), "CME group");
    }

}
