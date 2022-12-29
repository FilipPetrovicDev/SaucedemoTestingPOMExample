package pages;

import data.CommonStrings;
import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePageClass{

    private final String loginPageUrl = CommonStrings.LOGIN_PAGE_URL;
    private final By userNameTextFieldLocator = By.id("user-name");
    private final By passwordTextFieldLocator = By.id("password");
    private final By loginButtonLocator = By.id("login-button");
    private final By errorMessageLocator = By.xpath("//div[@class='error-message-container error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        openUrl(loginPageUrl);
        return this;
    }

    public LoginPage verifyLoginPage() {
        waitForUrlChange(loginPageUrl, Time.TIME_SHORTER);
        return this;
    }

    public LoginPage typeUserName(String username) {
        WebElement usernameTextField = waitForWebElementToBeVisible(userNameTextFieldLocator, Time.TIME_SHORTER);
        clearAndTypeTextToWebElement(usernameTextField, username);
        return this;
    }

    public LoginPage typePassword(String password) {
        WebElement passwordTextField = waitForWebElementToBeVisible(passwordTextFieldLocator, Time.TIME_SHORTER);
        clearAndTypeTextToWebElement(passwordTextField, password);
        return this;
    }

    public LoginPage clickLoginButtonNoProgress() {
        clickButton(loginButtonLocator);
        return this;
    }

    public AllItemsPage clickLoginButton() {
        clickButton(loginButtonLocator);
        AllItemsPage allItemsPage = new AllItemsPage(driver);
        return allItemsPage;
    }

    public String getErrorMessage() {
        WebElement element = waitForWebElementToBeVisible(errorMessageLocator, Time.TIME_SHORTER);
        return element.getText();
    }
}

