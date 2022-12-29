import org.openqa.selenium.WebDriver;
import utils.WebDriverUtils;

public class BaseTestClass {

    protected WebDriver setUpDriver() {
        return WebDriverUtils.setupWebDriver();
    }

    protected void quitDriver(WebDriver driver) {
        WebDriverUtils.quitWebDriver(driver);
    }
}

