package base;

import config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        if (Config.BROWSER.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
        } else {
            throw new IllegalArgumentException("Browser " + Config.BROWSER + " not supported.");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void acceptCookiesIfPresent() {
        By cookiesAcceptButton = By.id("LIVEChatButton");
        try {
            wait.withTimeout(Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(cookiesAcceptButton)).click();
            System.out.println("Pop-up de cookies/chat aceito/fechado.");
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("Nenhum pop-up de cookies/chat encontrado ou já foi lidado.");
        } catch (Exception e) {
            System.err.println("Erro ao tentar lidar com pop-up: " + e.getMessage());
        }
    }
}