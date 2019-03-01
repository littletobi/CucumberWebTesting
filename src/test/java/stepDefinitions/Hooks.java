package stepDefinitions;

        import cucumber.api.Scenario;
        import cucumber.api.java.After;
        import cucumber.api.java.Before;
        import org.openqa.selenium.OutputType;
        import org.openqa.selenium.TakesScreenshot;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebDriverException;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.firefox.FirefoxDriver;
        import org.openqa.selenium.phantomjs.PhantomJSDriver;
        import org.openqa.selenium.phantomjs.PhantomJSDriverService;
        import org.openqa.selenium.remote.DesiredCapabilities;

        import java.net.MalformedURLException;

//http://www.seleniumframework.com/cucumber-jvm-3/parameterize-browser/
public class Hooks {

    public static WebDriver driver;
    private String path = System.getProperty("user.dir");

    @Before("@web")
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void openBrowser() throws MalformedURLException {
        String browser = System.getProperty("BROWSER");
        if (browser == null) {
            browser = System.getenv("BROWSER");
            if (browser == null) {
                browser = "chrome";
            }
        }
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", path + "\\Resources\\chromedriver_win32_2_46\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().fullscreen();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", path + "\\Resources\\geckodriver-v0.24.0-win64\\geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().fullscreen();
                break;
//            case "ie":
//                driver = new InternetExplorerDriver();
//                break;
//            case "safari":
//                driver = new SafariDriver();
//                break;
            case "phantomjs":
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,path + "\\Resources\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
                driver = new PhantomJSDriver(caps);
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
        System.out.println("Opening Browser...." + browser);
        driver.manage().deleteAllCookies();
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }
        }
        driver.quit();
    }
}
