package pl.qa.selenium.core.extensions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class TestExecutionWatcher implements TestWatcher {

    private static final Logger logger = LoggerFactory.getLogger(TestExecutionWatcher.class);

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        logger.info("testDisbaled");
        System.err.println("testDisabled");
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        logger.info("testDisbaled");
        System.err.println("testSuccessful");
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        logger.warn("testAborted");
        System.err.println("testAborted");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        logger.error("testFailed");
        System.err.println("testFailed");
    }
}
