package pages;

import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
public abstract class BasePageClass {

    protected WebDriver driver;
    public BasePageClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void openUrl(String url) {
        driver.get(url);
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected boolean waitForUrlChange(String url, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.urlToBe(url));
    }

    // METODE KOJE RADE WAIT-ove
    // 1. cekanje da web element bude vidljiv
    protected WebElement waitForWebElementToBeVisible(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForWebElementToBeVisible(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void typeTextToWebElement(WebElement element, String text) {
        waitForWebElementToBeVisible(element, Time.TIME_SHORTER);
        element.sendKeys(text);
    }

    protected void clearTextForWebElement(WebElement element) {
        waitForWebElementToBeVisible(element, Time.TIME_SHORTER);
        element.clear();
    }

    protected void clearAndTypeTextToWebElement(WebElement element, String text) {
        clearTextForWebElement(element);
        typeTextToWebElement(element, text);
    }

    protected void clickOnWebElement(WebElement element) {
        element.click();
    }

    protected void clickButton(By locator) {
        WebElement element = waitForWebElementToBeVisible(locator, Time.TIME_SHORTER);
        clickOnWebElement(element);
    }

    protected String getTextFromWebElement(WebElement element) {
        return element.getText();
    }
}

