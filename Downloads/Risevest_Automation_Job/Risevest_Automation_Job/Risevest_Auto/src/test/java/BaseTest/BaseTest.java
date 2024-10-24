package BaseTest;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    public static WebDriver driver;
    public static Properties prop = new Properties();
    public static Properties loc = new Properties();
    public static FileReader fr;
    public static FileReader fr1;

    @BeforeMethod
    public void setup() throws IOException {

        if (driver == null) {
            System.out.println();
            fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\Configfiles\\config.properties");
            fr1 = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\Configfiles\\locator.properties");

            prop.load(fr);
            loc.load(fr1);
        }

        if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\browserdrivers\\chromedriver.exe");
            // WebDriverManager.chromedriver().setup();

            // Set Chrome options to disable notifications
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2); // 1 to allow, 2 to block
            options.setExperimentalOption("prefs", prefs);

            // Initialize ChromeDriver with options
            driver = new ChromeDriver(options);
            driver.get(prop.getProperty("testurl"));
        }
        else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();

            // Set Firefox options to disable notifications
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("dom.webnotifications.enabled", false);

            // Initialize FirefoxDriver with options
            driver = new FirefoxDriver(options);
            driver.get(prop.getProperty("testurl"));
        }
    }

    @AfterMethod
    public void teardown() {
   
         //   driver.quit();  // Closes all browser windows and ends the WebDriver session
        
        System.out.println("teardown successful");
    }
}
