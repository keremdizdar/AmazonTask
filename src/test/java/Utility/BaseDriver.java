package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseDriver {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;

        }

    }

}