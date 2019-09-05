package pl.qa.selenium.core.runner;

import org.junit.runners.model.InitializationError;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.qa.selenium.core.config.WebDriverConfig;
import pl.qa.selenium.core.listeners.ScreenshotTakerListener;

/**
 * Not used for jUnit5
 */
@Deprecated
public class WebDriverRunner extends SpringJUnit4ClassRunner {

    public WebDriverRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
    }

    protected TestContextManager createTestContextManager(Class<?> clazz) {
        return super.createTestContextManager(ConfigShim.class);
    }

    @ContextConfiguration(classes = WebDriverConfig.class)
    @TestExecutionListeners(listeners = {ScreenshotTakerListener.class})
    static class ConfigShim {
    }
}
