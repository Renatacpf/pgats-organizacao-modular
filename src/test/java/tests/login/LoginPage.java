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

    private By campoUsuario = By.name("username");
    private By campoSenha = By.name("password");
    private By botaoLogin = By.xpath("//input[@value='Log In']");

    public void preencherUsuario(String usuario) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoUsuario)).sendKeys(usuario);
    }

    public void preencherSenha(String senha) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoSenha)).sendKeys(senha);
    }

    public void clicarNoBotaoLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(botaoLogin)).click();
    }
}