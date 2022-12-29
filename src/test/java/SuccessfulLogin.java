import data.CommonStrings;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AllItemsPage;
import pages.LoginPage;

public class SuccessfulLogin extends BaseTestClass {

    private WebDriver driver;
    private String username;
    private String password;

    @BeforeMethod
    public void setUpTest() {
        driver = setUpDriver();
        username = CommonStrings.STANDARD_USERNAME;
        password = CommonStrings.PASSWORD;
    }

    @Test
    public void testSuccessfullLogin() {
        LoginPage loginPage = new LoginPage(driver).open();

        AllItemsPage allItemsPage = loginPage.typeUserName(username).typePassword(password).clickLoginButton();
        Assert.assertTrue(allItemsPage.verifyAllItemsPage(), "Url is not as expected!!!");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownTest() {
        quitDriver(driver);
    }
}

