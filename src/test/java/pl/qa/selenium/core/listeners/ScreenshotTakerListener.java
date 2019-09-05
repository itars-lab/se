package pl.qa.selenium.core.listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;
import pl.qa.selenium.core.interfaces.markers.ScreenshotTakerExample;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.Files;

/**
 *
 */
@ScreenshotTakerExample
public class ScreenshotTakerListener extends AbstractTestExecutionListener {

    private static final Logger log = LoggerFactory.getLogger(ScreenshotTakerListener.class);

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        log.info("Inside afterTestMethod");
        if (Boolean.parseBoolean(System.getProperty("webdriver.screenshots.enabled", "true"))) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) testContext.getApplicationContext()
                    .getBean(WebDriver.class);
            File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File dir = new File("target/screenshots");
            if (!dir.exists()) {
                Files.createDirectories(dir.toPath());
            }
            Method method = testContext.getTestMethod();
            File file = new File(dir, String.format("%s#%s.png", method.getDeclaringClass().getName(), method.getName()));
            FileUtils.deleteQuietly(file);
            FileUtils.moveFile(screenshot, file);
            log.info("saved screenshot as {}", file);
        }
    }
}
