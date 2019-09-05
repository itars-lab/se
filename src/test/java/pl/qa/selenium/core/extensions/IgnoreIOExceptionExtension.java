package pl.qa.selenium.core.extensions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import pl.qa.selenium.core.interfaces.markers.JUnitExceptionHandling;

import java.io.IOException;

@JUnitExceptionHandling
public class IgnoreIOExceptionExtension implements TestExecutionExceptionHandler {
    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable
            throwable)
            throws Throwable {
        if (throwable instanceof IOException) {
            return;
        }
        throw throwable;
    }
}
