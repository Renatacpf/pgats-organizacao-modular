package tests.cadastro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CadastroPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CadastroPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Elementos da página de Cadastro do Parabank
    // Baseado na imagem e na inspeção comum do site:
    private By campoFirstName = By.id("customer.firstName");
    private By campoLastName = By.id("customer.lastName");
    private By campoAddress = By.id("customer.address.street");
    private By campoCity = By.id("customer.address.city");
    private By campoState = By.id("customer.address.state");
    private By campoZipCode = By.id("customer.address.zipCode");
    private By campoPhone = By.id("customer.phoneNumber");
    private By campoSsn = By.id("customer.ssn");
    private By campoUsername = By.id("customer.username");
    private By campoPassword = By.id("customer.password");
    private By campoConfirmPassword = By.id("repeatedPassword");

    private By botaoRegister = By.xpath("//input[@type='submit' and @value='Register']");

    public void preencherFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoFirstName)).sendKeys(firstName);
    }

    public void preencherLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoLastName)).sendKeys(lastName);
    }

    public void preencherAddress(String address) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoAddress)).sendKeys(address);
    }

    public void preencherCity(String city) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoCity)).sendKeys(city);
    }

    public void preencherState(String state) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoState)).sendKeys(state);
    }

    public void preencherZipCode(String zipCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoZipCode)).sendKeys(zipCode);
    }

    public void preencherPhone(String phone) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoPhone)).sendKeys(phone);
    }

    public void preencherSsn(String ssn) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoSsn)).sendKeys(ssn);
    }

    public void preencherUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoUsername)).sendKeys(username);
    }

    public void preencherPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoPassword)).sendKeys(password);
    }

    public void preencherConfirmPassword(String confirmPassword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoConfirmPassword)).sendKeys(confirmPassword);
    }

    public void clicarNoBotaoRegister() {
        wait.until(ExpectedConditions.elementToBeClickable(botaoRegister)).click();
    }
}