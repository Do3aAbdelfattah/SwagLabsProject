package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {
    WebDriver driver;
    public PageBase (WebDriver driver)
    {
        this.driver = driver;
    }
    public void clickOnElement(By elementLocator)
    {
        waitUntilElementPrecense(elementLocator);
        scrollToElementView(elementLocator);
        WebElement elementToClick = driver.findElement(elementLocator);
        elementToClick.click();
        //forceClick(driver, elementToClick);
    }
    public static void forceClick(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }
    public void enterText(By elementLocator, String text)
    {
        waitUntilElementPrecense(elementLocator);
        scrollToElementView(elementLocator);
        //Enter the text into the field
        driver.findElement(elementLocator).sendKeys(text);
    }
    public void waitUntilElementPrecense(By elementLocator)
    {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(elementLocator));
    }
    public void scrollToElementView(By elementLocator)
    {
        WebElement element = driver.findElement(elementLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


}
