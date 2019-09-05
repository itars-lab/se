package pl.qa.selenium.core.config;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.File;

/**
 * Remember to set spring.active.profile value
 */
@Configuration
public class WebDriverConfig {
    private static final Logger log = LoggerFactory.getLogger(WebDriverConfig.class);

    @Value("${chrome.binary.path}")
    public String chromeDriverLocation;

    @Value("${firefox.binary.path}")
    public String firefoxDriverLocation;

    @Value("${ie.binary.path}")
    public String internetExplorerDriverLocation;

    // alternative way
//    private final WebDriverLoader webDriverLoader;

    @Bean(destroyMethod = "quit")
    @Profile("firefox")
    public WebDriver driverFirefox(DesiredCapabilities desiredCapabilities) {
        System.setProperty("webdriver.gecko.driver", firefoxDriverLocation);
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(chromeDriverLocation);
        options.merge(desiredCapabilities);
        FirefoxDriver firefoxDriver = new FirefoxDriver(options);
        return firefoxDriver;
    }

    @Bean(destroyMethod = "quit")
    @Profile("ie")
    public WebDriver driverInternetExplorer(DesiredCapabilities desiredCapabilities) {
        System.setProperty("webdriver.ie.driver", internetExplorerDriverLocation);
        DesiredCapabilities capabilities = new DesiredCapabilities(desiredCapabilities);
        capabilities.setCapability("ignoreZoomSetting", true);
        final InternetExplorerOptions ieOptions = new InternetExplorerOptions(capabilities);
        ieOptions.introduceFlakinessByIgnoringSecurityDomains();
        ieOptions.requireWindowFocus();
        InternetExplorerDriver internetExplorerDriver = new InternetExplorerDriver(ieOptions);
        internetExplorerDriver.manage().window().maximize();
        return internetExplorerDriver;
    }

//    @Bean
//    @Profile("ie")
//    public WebDriver ieDriver(){
//        final InternetExplorerDriverService ieDriverService = new InternetExplorerDriverService.Builder()
//                .usingDriverExecutable(webDriverLoader.loadInternetExplorerDriver())
//                .build();
//
//        final InternetExplorerOptions ieOptions = new InternetExplorerOptions();
//        ieOptions.introduceFlakinessByIgnoringSecurityDomains();
//        ieOptions.requireWindowFocus();
//    }

    @Bean(destroyMethod = "quit")
    @Profile("chrome")
    public WebDriver chromeDriver(DesiredCapabilities desiredCapabilities) {
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
        ChromeOptions options = new ChromeOptions();
        options.setBinary(new File(chromeDriverLocation));
        options.merge(desiredCapabilities);
        ChromeDriver chromeDriver = new ChromeDriver(options);
        return chromeDriver;
    }

    /**
     * In case You want to have webDriver which is ready to spying just replace
     * in Your tests basic implementation of WebDriver by wrapped one
     * it is perfect tool for taking screenshots or logging actions
     *
     * @return
     */
//    @Bean
//    public EventFiringWebDriver listenableWebDriver(WebDriver driver){
//        EventFiringWebDriver wrappedDriver = new EventFiringWebDriver(driver);
//        wrappedDriver.register(new WebDriverEventListener());
//        return wrappedDriver;
//    }
    @Bean
    public DesiredCapabilities desiredCapabilities(@Value("${webdriver.capabilities.browserName:chrome}") String browserName,
                                                   @Value("${webdriver.capabilities.version:}") String version,
                                                   @Value("${webdriver.capabilities.platform:}") String platform) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities(browserName, version, Platform.fromString(platform));
//        desiredCapabilities.setCapability("ignoreZoomSetting", true);
        return desiredCapabilities;
    }
}
