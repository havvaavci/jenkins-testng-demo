package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriveFactory {

    public class DriverFactory {

        private static WebDriver driver;

        public static WebDriver getDriver() {

            String browser = System.getProperty("browser", "chrome");
            String headless = System.getProperty("headless", "false");

            System.out.println("JENKINS PARAMS -> browser="
                    + browser + " headless=" + headless);

            boolean isHeadless = headless.equalsIgnoreCase("true");

            if (browser.equalsIgnoreCase("chrome")) {

                ChromeOptions options = new ChromeOptions();

                if (isHeadless) {
                    options.addArguments("--headless=new");
                    options.addArguments("--window-size=1920,1080");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                }

                driver = new ChromeDriver(options);

            } else if (browser.equalsIgnoreCase("firefox")) {

                FirefoxOptions options = new FirefoxOptions();

                if (isHeadless) {
                    options.addArguments("--headless");
                }

                driver = new FirefoxDriver(options);
            }

            driver.manage().window().maximize();
            return driver;
        }

        public static void quitDriver() {
            if (driver != null) {
                driver.quit();
            }
        }
    }

}
