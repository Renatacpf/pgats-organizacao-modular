package tests.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccountInformationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public AccountInformationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By enterAccountInformationText = By.cssSelector(".login-form h2 b");
    private By mrRadio = By.id("id_gender1");
    private By mrsRadio = By.id("id_gender2");
    private By passwordField = By.id("password");
    private By daysDropdown = By.id("days");
    private By monthsDropdown = By.id("months");
    private By yearsDropdown = By.id("years");
    private By newsletterCheckbox = By.id("newsletter");
    private By offersCheckbox = By.id("optin");

    public boolean isEnterAccountInformationVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(enterAccountInformationText)).isDisplayed();
    }

    public void fillAccountInformation(String title, String password, String day, String month, String year) {
        if (title.equalsIgnoreCase("Mr.")) {
            wait.until(ExpectedConditions.elementToBeClickable(mrRadio)).click();
        } else if (title.equalsIgnoreCase("Mrs.")) {
            wait.until(ExpectedConditions.elementToBeClickable(mrsRadio)).click();
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);

        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(daysDropdown))).selectByValue(day);
        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(monthsDropdown))).selectByVisibleText(month);
        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(yearsDropdown))).selectByValue(year);

        if (!wait.until(ExpectedConditions.visibilityOfElementLocated(newsletterCheckbox)).isSelected()) {
            wait.until(ExpectedConditions.elementToBeClickable(newsletterCheckbox)).click();
        }
        if (!wait.until(ExpectedConditions.visibilityOfElementLocated(offersCheckbox)).isSelected()) {
            wait.until(ExpectedConditions.elementToBeClickable(offersCheckbox)).click();
        }
    }
}