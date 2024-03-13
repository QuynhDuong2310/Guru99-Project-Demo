

package commons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.time.Duration;
public class BaseTest {
    private WebDriver driver;
    // driver của lớp cha đang là private >> Mình không truy cập trực tiếp driver này được = cách sử dụng getBrowserName() method
    // mình hoàn toàn có thể lấy được thông qua việc return >> return driver statement.
    private String projectPath = System.getProperty("user.dir");

    protected WebDriver getBrowserName(String browsername) {
        if (browsername.equalsIgnoreCase("firefox_ui")) {
            //System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browsername.equalsIgnoreCase("chrome_ui")) {
            //System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browsername.equalsIgnoreCase("firefox_headless")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("headless");
            options.addArguments("window-size=1920x1080");
            // Create an object of WebDriver class and pass the Firefox Options object
            // as an argument
            driver = new FirefoxDriver(options);
        } else if (browsername.equalsIgnoreCase("chrome_headless")) {
            System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            options.addArguments("window-size=1920x1080");
            // Create an object of WebDriver class and pass the Firefox Options object
            // as an argument
            driver = new ChromeDriver(options);
        } else {
            throw new RuntimeException("Please enter a valid browser name!");
        }
        driver.get("https://demo.guru99.com/v4/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.manage().window().maximize();
        return driver;
    }
    protected WebDriver getBrowserName(String browsername, String url) {
        if (browsername.equalsIgnoreCase("firefox_ui")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browsername.equalsIgnoreCase("chrome_ui")) {
            System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browsername.equalsIgnoreCase("firefox_headless")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("headless");
            options.addArguments("window-size=1920x1080");
            // Create an object of WebDriver class and pass the Firefox Options object
            // as an argument
            driver = new FirefoxDriver(options);
        } else if (browsername.equalsIgnoreCase("chrome_headless")) {
            System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            options.addArguments("window-size=1920x1080");
            // Create an object of WebDriver class and pass the Firefox Options object
            // as an argument
            driver = new ChromeDriver(options);
        } else {
            throw new RuntimeException("Please enter a valid browser name!");
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.manage().window().maximize();
        return driver;
    }
}
 