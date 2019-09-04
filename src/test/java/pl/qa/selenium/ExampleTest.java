package pl.qa.selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.qa.selenium.tests.BaseTest;

public class ExampleTest extends BaseTest {


    @Test
    public void firstCmeTest() {
        driver.get("https://cmegroup.com");
        Assertions.assertEquals(driver.getTitle(), "CME Group",
                "Custom message in case of fail");
    }

    @Test
    public void secondCmeTest() {

    }


}
