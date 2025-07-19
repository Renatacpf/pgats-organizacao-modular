package tests.login;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.register.HomePage;
import tests.register.AccountCreatedPage;

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

        loginPage.enterLoginDetails("usuario.naoexiste@invalido.com", "senhaerrada123");
        loginPage.clickLoginButton();

        Assertions.assertTrue(loginPage.isInvalidLoginMessageVisible(), "Mensagem de erro de login inválido deve estar visível.");
        Assertions.assertEquals("Your email or password is incorrect!", loginPage.getInvalidLoginMessageText(), "Texto da mensagem de erro está incorreto.");

        Assertions.assertTrue(loginPage.isLoginPageVisible(), "Deve permanecer na página de Login após login inválido.");
    }

    @Test
    @DisplayName("Deve realizar login com sucesso de um usuário existente")
    public void deveRealizarLoginComSucesso() {
        String existingUserEmail = "test_4d00b840@example.com";
        String existingUserPassword = "Password5877";
        String expectedLoggedInUserName = "User_8f2896ca";

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