package tests.register;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccountDetailsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public AccountDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By companyField = By.id("company");
    private By address1Field = By.id("address1");
    private By address2Field = By.id("address2");
    private By countryDropdown = By.id("country");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipCodeField = By.id("zipcode");
    private By mobileNumberField = By.id("mobile_number");
    private By createAccountButton = By.cssSelector("button[data-qa='create-account']");

    public boolean isAddressDetailsVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).isDisplayed();
    }

    public void fillAddressDetails(
            String firstName,
            String lastName,
            String company,
            String address1,
            String address2,
            String country,
            String state,
            String city,
            String zipCode,
            String mobileNumber
    ) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(companyField)).sendKeys(company);
        wait.until(ExpectedConditions.visibilityOfElementLocated(address1Field)).sendKeys(address1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(address2Field)).sendKeys(address2);

        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(countryDropdown))).selectByVisibleText(country);

        wait.until(ExpectedConditions.visibilityOfElementLocated(stateField)).sendKeys(state);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cityField)).sendKeys(city);
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipCodeField)).sendKeys(zipCode);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumberField)).sendKeys(mobileNumber);
    }

    public void clickCreateAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(createAccountButton)).click();
    }
}