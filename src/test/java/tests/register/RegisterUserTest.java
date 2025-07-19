package tests.register;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import tests.register.HomePage;
import tests.register.SignupLoginPage;
import tests.register.AccountInformationPage;
import tests.register.AccountDetailsPage;
import tests.register.AccountCreatedPage;

import utils.DataFactory;

import static java.sql.DriverManager.println;

public class RegisterUserTest extends BaseTest {

    private String generatedUserName;
    private String generatedUserEmail;
    private String generatedUserPassword;

    @Test
    @DisplayName("Deve registrar um novo usuário, realizar login e deletar a conta")
    public void testRegisterLoginDeleteUserFlow() {
        HomePage homePage = new HomePage(driver);
        SignupLoginPage signupLoginPage = new SignupLoginPage(driver);
        AccountInformationPage accountInformationPage = new AccountInformationPage(driver);
        AccountDetailsPage accountDetailsPage = new AccountDetailsPage(driver);
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);

        homePage.navigateToHomePage();
        acceptCookiesIfPresent();

        Assertions.assertTrue(homePage.isHomePageVisible(), "Home page should be visible.");

        homePage.clickSignupLogin();
        Assertions.assertTrue(signupLoginPage.isSignupLoginPageVisible(), "Signup / Login page should be visible.");

        generatedUserName = DataFactory.generateRandomName();
        println("Generated User Name: " + generatedUserName);
        generatedUserEmail = DataFactory.generateRandomEmail();
        println("Generated User Email: " + generatedUserEmail);
        generatedUserPassword = DataFactory.generateRandomPassword();
        println("Generated User Password: " + generatedUserPassword);

        signupLoginPage.enterNameAndEmailForSignup(generatedUserName, generatedUserEmail);
        signupLoginPage.clickSignupButton();

        Assertions.assertTrue(accountInformationPage.isEnterAccountInformationVisible(), "ENTER ACCOUNT INFORMATION should be visible.");
        accountInformationPage.fillAccountInformation(
                "Mr.",
                generatedUserPassword,
                "15",
                "May",
                "1990"
        );

        Assertions.assertTrue(accountDetailsPage.isAddressDetailsVisible(), "Address Details should be visible.");
        accountDetailsPage.fillAddressDetails(
                generatedUserName.split("_")[0],
                "SobrenomeTeste",
                "MinhaEmpresa",
                "123 Rua Principal",
                "Apto 101",
                "Canada",
                "Ontario",
                "Toronto",
                "A1A1A1",
                "9876543210"
        );

        accountDetailsPage.clickCreateAccount();

        Assertions.assertTrue(accountCreatedPage.isAccountCreatedVisible(), "ACCOUNT CREATED! message should be visible.");
        accountCreatedPage.clickContinueButton();

        String expectedLoggedInText = "Logged in as " + generatedUserName;
        Assertions.assertEquals(expectedLoggedInText, homePage.getLoggedInUsername(), "User should be logged in after registration.");

        homePage.clickDeleteAccount();
        Assertions.assertTrue(accountCreatedPage.isAccountDeletedVisible(), "ACCOUNT DELETED! message should be visible.");
        accountCreatedPage.clickContinueButton();
        Assertions.assertTrue(homePage.isHomePageVisible(), "Should return to Home Page after account deletion.");
    }
}