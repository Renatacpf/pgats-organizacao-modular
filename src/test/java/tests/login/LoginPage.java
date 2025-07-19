package tests.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By loginToYourAccountText = By.cssSelector(".login-form h2");
    private By loginEmailField = By.cssSelector("input[data-qa='login-email']");
    private By loginPasswordField = By.cssSelector("input[data-qa='login-password']");
    private By loginButton = By.cssSelector("button[data-qa='login-button']");

    private By invalidLoginMessage = By.cssSelector(".login-form p[style='color: red;']");

    public boolean isLoginPageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginToYourAccountText)).isDisplayed();
    }

    public void enterLoginDetails(String email, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginEmailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPasswordField)).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public boolean isInvalidLoginMessageVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(invalidLoginMessage)).isDisplayed();
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public String getInvalidLoginMessageText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(invalidLoginMessage)).getText();
    }
}