package pl.qa.selenium.tests;

import java.util.Optional;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JTestWatcher implements TestWatcher, BeforeTestExecutionCallback {

  private static final Logger logger = LoggerFactory.getLogger(JTestWatcher.class);

  @Override
  public void testSuccessful(ExtensionContext context) {
    // No guarantee logger is configured here. Need to configure via properties file.
    logger.info("Test '{}' passed", context.getDisplayName());
  }

  @Override
  public void testDisabled(ExtensionContext context, Optional<String> reason) {
    logger.info("Test '{}' disabled because \"{}\"", context.getDisplayName(),
        reason.orElse("unspecified"));
  }
  
  @Override
  public void beforeTestExecution(ExtensionContext context) throws Exception {
    logger.info("Test '{}' about to start...", context.getDisplayName());
  }

}
