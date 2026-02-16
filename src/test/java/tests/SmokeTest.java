package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utils.DriveFactory;

public class SmokeTest {
    WebDriver driver;

    @Test
    public void openGoogle() {
        driver = DriveFactory.DriverFactory.getDriver();
        driver.get("https://www.google.com");
    }

    @AfterMethod
    public void tearDown() {
        DriveFactory.DriverFactory.quitDriver();
    }
}

