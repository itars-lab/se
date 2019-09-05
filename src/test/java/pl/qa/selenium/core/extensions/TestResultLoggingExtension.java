package pl.qa.selenium.core.extensions;


import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * Note: new extension, released with 5.4.0, update Your maven pom definition
 */
public class TestResultLoggingExtension implements TestWatcher, BeforeTestExecutionCallback, AfterAllCallback {

    private static final Logger log = LoggerFactory.getLogger(TestResultLoggingExtension.class);
    private final List<TestResultStatus> testResultStatuses = new ArrayList<>();

    /**
     * Enum representation of a status of a test
     */
    private enum TestResultStatus {
        SUCCESSFUL, ABORTED, FAILED, DISABLED;
    }

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {

    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        Map<TestResultStatus, Long> summaryStatistics = testResultStatuses.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        log.info("Test result summary for {} {}", extensionContext.getDisplayName(), summaryStatistics.toString());
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        log.info("Test Disabled for test {}: with reason: {}", context.getDisplayName(), reason.orElse("No reason"));
        testResultStatuses.add(TestResultStatus.DISABLED);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        log.info("Test Successful for test {}: ", context.getDisplayName());

        testResultStatuses.add(TestResultStatus.SUCCESSFUL);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        log.info("Test Aborted for test {}: ", context.getDisplayName());

        testResultStatuses.add(TestResultStatus.ABORTED);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        log.info("Test Aborted for test {}: ", context.getDisplayName());

        testResultStatuses.add(TestResultStatus.FAILED);
    }
}
