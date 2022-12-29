import data.CommonStrings;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.File;
import java.io.IOException;

public class UnsuccessfulLoginWrongPassword extends BaseTestClass {
    private WebDriver driver;
    private String username;
    private String password;
    private String errorMessageExpected;

    @BeforeMethod
    public void setUpTest() {
        driver = setUpDriver();
        username = CommonStrings.STANDARD_USERNAME;
        password = CommonStrings.PASSWORD + "!";
    }

    @Test
    public void testUnsuccessfulLoginWrongPassword() throws IOException {
        LoginPage loginPage = new LoginPage(driver).open();
        String errorMessage = loginPage.typeUserName(username).typePassword(password).clickLoginButtonNoProgress().getErrorMessage();
        errorMessageExpected = CommonStrings.ERROR_MESSAGE; //+ "ewrwer";
        Assert.assertEquals(errorMessage, errorMessageExpected, "Error Message is not as expected!!!");
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("C:\\Users\\Lenovo\\Desktop\\SaucedemoTestingPOMExample\\screenshots\\"+driver.getTitle()+"-"+".png"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        quitDriver(driver);
    }
}
