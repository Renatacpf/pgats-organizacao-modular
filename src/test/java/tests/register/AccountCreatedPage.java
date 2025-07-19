package tests.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccountCreatedPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By accountCreatedText = By.cssSelector("h2[data-qa='account-created']");
    private By continueButton = By.cssSelector("a[data-qa='continue-button']");

    private By accountDeletedText = By.cssSelector("h2[data-qa='account-deleted']");

    public boolean isAccountCreatedVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreatedText)).isDisplayed();
    }

    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public boolean isAccountDeletedVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountDeletedText)).isDisplayed();
    }
}