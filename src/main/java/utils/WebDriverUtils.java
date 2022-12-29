package utils;

import data.Time;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class WebDriverUtils {

    public static WebDriver setupWebDriver() {
        WebDriver driver = WebDriverManager.chromiumdriver().create();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Time.IMPLICIT_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Time.PAGE_LOAD_TIMEOUT));

        driver.manage().window().maximize();

        return driver;
    }

    public static void quitWebDriver(WebDriver driver) {
        driver.quit();
    }
}

