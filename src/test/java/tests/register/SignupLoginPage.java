package tests.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SignupLoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SignupLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By newUserSignupText = By.cssSelector(".signup-form > h2");
    private By nameField = By.name("name");
    private By emailField = By.cssSelector(".signup-form input[name='email']");
    private By signupButton = By.cssSelector(".signup-form button[type='submit']");

    public boolean isSignupLoginPageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(newUserSignupText)).isDisplayed();
    }

    public void enterNameAndEmailForSignup(String name, String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField)).sendKeys(name);
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
    }

    public void clickSignupButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signupButton)).click();
    }
}