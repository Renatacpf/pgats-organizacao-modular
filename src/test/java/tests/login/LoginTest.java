package tests.login;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.register.HomePage;
import tests.register.AccountCreatedPage;
import utils.TestDataLoader;

public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Deve falhar o login com credenciais inválidas")
    public void deveFalharLoginComCredenciaisInvalidas() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        homePage.navigateToHomePage();
        acceptCookiesIfPresent();
        Assertions.assertTrue(homePage.isHomePageVisible(), "Home page should be visible.");

        homePage.clickSignupLogin();
        Assertions.assertTrue(loginPage.isLoginPageVisible(), "Login page should be visible.");

        String invalidEmail = TestDataLoader.getLoginData("invalid", "email");
        String invalidPassword = TestDataLoader.getLoginData("invalid", "password");
        String expectedErrorMessage = TestDataLoader.getLoginData("invalid", "errorMessage");

        loginPage.enterLoginDetails(invalidEmail, invalidPassword);
        loginPage.clickLoginButton();

        Assertions.assertTrue(loginPage.isInvalidLoginMessageVisible(), "Mensagem de erro de login inválido deve estar visível.");
        Assertions.assertEquals(expectedErrorMessage, loginPage.getInvalidLoginMessageText(), "Texto da mensagem de erro está incorreto.");

        Assertions.assertTrue(loginPage.isLoginPageVisible(), "Deve permanecer na página de Login após login inválido.");
    }

    @Test
    @DisplayName("Deve realizar login com sucesso de um usuário existente")
    public void deveRealizarLoginComSucesso() {
        // Dados lidos do YAML
        String existingUserEmail = TestDataLoader.getLoginData("valid", "email");
        String existingUserPassword = TestDataLoader.getLoginData("valid", "password");
        String expectedLoggedInUserName = TestDataLoader.getLoginData("valid", "expectedUsername");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);

        homePage.navigateToHomePage();
        acceptCookiesIfPresent();
        Assertions.assertTrue(homePage.isHomePageVisible(), "Home page should be visible.");

        homePage.clickSignupLogin();
        Assertions.assertTrue(loginPage.isLoginPageVisible(), "Login page should be visible.");

        loginPage.enterLoginDetails(existingUserEmail, existingUserPassword);
        loginPage.clickLoginButton();

        String actualLoggedInText = homePage.getLoggedInUsername();
        Assertions.assertTrue(actualLoggedInText.contains(expectedLoggedInUserName),
                "O usuário '" + expectedLoggedInUserName + "' não está logado. Texto encontrado: " + actualLoggedInText);
    }
}