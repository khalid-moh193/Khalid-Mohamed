package Web.Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;


public class AppDriver {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver SeleniumDriverSetup(String browser) throws Exception {
//         Check if parameter passed from web.xml is 'chrome'

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            if (PropertyReader.getProperty("enableHeadlessExecution").equalsIgnoreCase("yes"))
            {
                options.addArguments("--headless");
                options.addArguments("--window-size=1200,800");
            }
            driver.set(new ChromeDriver(options));
            driver.get().manage().window().maximize();
            return driver.get();
        }

//        Check if parameter passed from web.xml is 'firefox'
        else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            driver.set(new FirefoxDriver(options));
            driver.get().manage().window().maximize();
            return driver.get();
        }

//        Check if parameter passed from web.xml is 'safari'
        else if (browser.equalsIgnoreCase("safari")) {
            driver.set(new SafariDriver());
            driver.get().manage().window().maximize();
            return driver.get();
        } else {
            // If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
    }

}
