package pl.qa.selenium.core.extensions;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.engine.execution.AfterEachMethodAdapter;
import org.junit.jupiter.engine.extension.ExtensionRegistry;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.qa.selenium.core.interfaces.Observable;

import java.io.File;
import java.util.Optional;

/**
 * The problem is there that driver close the session before callback methods are executed. We can skip driver closing
 * after each and every test but it can lead to uncontrolled browser processes
 */
public class ScreenshotTakerExtension implements TestWatcher, AfterTestExecutionCallback, AfterEachMethodAdapter {

    private static final Logger log = LoggerFactory.getLogger(ScreenshotTakerExtension.class);

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {

    }

    @Override
    public void testSuccessful(ExtensionContext context) {

    }

    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable cause) {
//        note: there is no easy way to take screenshots whenever test fail without spring, comprehensive context
        log.info("testFailed");
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        ;
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        log.info("afterTestExecution");
        TakesScreenshot driver = (TakesScreenshot) ((Observable) extensionContext.getTestInstance().get()).getDriver();
        File screenshot = driver.getScreenshotAs(OutputType.FILE);
        File targetFile = new File("target/screenshots", extensionContext.getTestClass().map(c -> c.getName()).orElse("unknown")
        + extensionContext.getTestMethod().map(m -> "_" + m.getName()).orElse("unknown_test") + ".png");
        FileUtils.deleteQuietly(targetFile);
        FileUtils.moveFile(screenshot, targetFile);
        log.info("Screenshot taken and avail under the path: " + targetFile.getPath());
    }

    @Override
    public void invokeAfterEachMethod(ExtensionContext extensionContext, ExtensionRegistry extensionRegistry) throws Throwable {
        log.info("invokeAfterEachMethod");


    }
}
