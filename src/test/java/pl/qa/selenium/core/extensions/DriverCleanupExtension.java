package pl.qa.selenium.core.extensions;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import pl.qa.selenium.core.exceptions.NoDriverIntoTestClassException;
import pl.qa.selenium.core.interfaces.Observable;

public class DriverCleanupExtension implements Extension, AfterAllCallback {

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        ((Observable) extensionContext.getTestInstance().orElseThrow(NoDriverIntoTestClassException::new)).getDriver().quit();
    }
}
