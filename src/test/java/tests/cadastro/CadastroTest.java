package tests.cadastro;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;
import pages.cadastro.CadastroPage;
import config.Config;
import utils.DataFactory;
import org.junit.jupiter.api.BeforeEach;

import java.time.Duration;

public class CadastroTest extends BaseTest {
    private CadastroPage cadastroPage;
    private WebDriverWait wait;

    @BeforeEach
    public void specificSetUp() {
        driver.get(Config.BASE_URL);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer.firstName")));

        cadastroPage = new CadastroPage(driver);
    }

    @Test
    public void deveCadastrarUsuarioComDadosValidos() {
        String uniqueUsername = "user" + DataFactory.gerarEmailUnico().split("@")[0];
        String uniqueSsn = DataFactory.gerarSenhaForte().substring(0, 5);

        cadastroPage.preencherFirstName(DataFactory.gerarNome().split(" ")[0]);
        cadastroPage.preencherLastName(DataFactory.gerarNome().split(" ")[1]);
        cadastroPage.preencherAddress("123 Main St");
        cadastroPage.preencherCity("Anytown");
        cadastroPage.preencherState("AnyState");
        cadastroPage.preencherZipCode("12345");
        cadastroPage.preencherPhone("123-456-7890");
        cadastroPage.preencherSsn(uniqueSsn);

        cadastroPage.preencherUsername(uniqueUsername);
        cadastroPage.preencherPassword("Test@123");
        cadastroPage.preencherConfirmPassword("Test@123");

        cadastroPage.clicarNoBotaoRegister();

        wait.until(ExpectedConditions.urlContains("register.htm"));

        Assertions.assertTrue(driver.getPageSource().contains("Your account was created successfully."),
                "Mensagem de sucesso de cadastro não exibida.");
        Assertions.assertTrue(driver.findElement(By.className("title")).getText().contains("Welcome"),
                "Título da página de sucesso não é 'Welcome'.");
        Assertions.assertTrue(driver.getPageSource().contains(uniqueUsername),
                "O nome de usuário não aparece na página de boas-vindas.");
    }
}