package pl.qa.selenium.core;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import pl.qa.selenium.config.WebDriverProperties;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;

@Component
public class WebDriverLoader {
    private final WebDriverProperties drivers;
    private final ResourceLoader resourceLoader;

    WebDriverLoader(final WebDriverProperties drivers,
                    final ResourceLoader resourceLoader) {
        this.drivers = drivers;
        this.resourceLoader = resourceLoader;
    }

    File loadChromeDriver() {
        return loadDriver(drivers.getChrome().getDriverLocation());
    }

    File loadFirefoxDriver() {
        return loadDriver(drivers.getFirefox().getDriverLocation());
    }

    File loadInternetExplorerDriver() {
        return loadDriver(drivers.getIe().getDriverLocation());
    }

    private File loadDriver(final String driverLocation) {
        try {
            return resourceLoader.getResource(driverLocation).getFile();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
