package tests.register;

import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private By signupLoginButton = By.cssSelector("a[href='/login']");
    private By loggedInAsUsernameText = By.cssSelector("li:nth-child(10) > a");
    private By deleteAccountButton = By.cssSelector("a[href='/delete_account']");
    private By homePageLogo = By.cssSelector("div.logo.pull-left img[alt='Automation Exercise']");

    public void navigateToHomePage() {
        driver.get(Config.BASE_URL);
    }

    public boolean isHomePageVisible() {
        return wait.until(ExpectedConditions.urlToBe(Config.BASE_URL)) &&
                wait.until(ExpectedConditions.elementToBeClickable(signupLoginButton)).isDisplayed();
    }

    public void clickSignupLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(signupLoginButton)).click();
    }

    public String getLoggedInUsername() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInAsUsernameText)).getText();
    }

    public void clickDeleteAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteAccountButton)).click();
    }
}