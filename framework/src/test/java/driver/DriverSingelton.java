package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingelton {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            if (System.getProperty("browser") == null) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else

                switch (System.getProperty("browser")) {
                    case "firefox": {
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                    }
                    default: {
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                    }
                }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }
}
