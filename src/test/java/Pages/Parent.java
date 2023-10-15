package Pages;

import Utility.BaseDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Parent {

    public static WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(20));
    JavascriptExecutor js = (JavascriptExecutor) BaseDriver.getDriver();

    public void sendKeysFunction(WebElement element, String text) {
        scrollToElement(element);
        waitUntilVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public void clickFunction(WebElement element) {
        scrollToElement(element);
        waitUntilClickable(element);
        element.click();
    }

    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}