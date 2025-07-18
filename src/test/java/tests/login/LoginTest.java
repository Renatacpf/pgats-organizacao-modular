package tests.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import tests.BaseTest;
import config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private WebDriverWait wait;

    @BeforeEach
    public void setupLoginTest() {
        driver.get(Config.BASE_URL);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
    }

    @Test
    public void deveRealizarLoginComSucesso() {
        loginPage.preencherUsuario("john");
        loginPage.preencherSenha("demo");
        loginPage.clicarNoBotaoLogin();

        wait.until(ExpectedConditions.urlContains("overview.htm"));

        Assertions.assertTrue(driver.findElement(By.cssSelector("h1.title")).getText().contains("Accounts Overview"),
                "O título da página após o login não é 'Accounts Overview'.");
        Assertions.assertTrue(driver.findElement(By.id("leftPanel")).isDisplayed(),
                "O painel de navegação esquerdo não está visível após o login.");
    }
}