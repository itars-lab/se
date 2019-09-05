package pl.qa.selenium.core.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.qa.selenium.core.interfaces.markers.ScreenshotTakerExample;

import java.io.File;

/**
 * Note: There is much more option of customizing. Please have a look on the list of ready to override methods
 * To use this listener You need to apply to Your tests EventFiringWebDriver driver instead of raw WebDriver
 */
@ScreenshotTakerExample
public class WebDriverEventListener extends AbstractWebDriverEventListener {
    private static final Logger log = LoggerFactory.getLogger(WebDriverEventListener.class);


    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        log.error("{} class made screenshot. Screenshot available under following location {}",
                this.getClass().getSimpleName(), screenshotFile.getAbsolutePath());
    }
}
