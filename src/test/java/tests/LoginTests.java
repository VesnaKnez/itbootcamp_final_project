package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        homePage.openLoginPage();
    }

    @Test
    public void visitsТheLoginPage() {

        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/login"));

        driver.navigate().refresh();

        actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/login"));

    }

    @Test
    public void checksInputTypes() {

        Assert.assertEquals(loginPage.getAttributeEmail(), "email");

        Assert.assertEquals(loginPage.getAttributePassword(), "password");

    }

    @Test
    public void displaysErrorsWhenUserDoesNotExist() {
        loginPage.fakerLogin();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")));

        Assert.assertEquals(loginPage.getMessage(), "User does not exists");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void displaysErrorsWhenPasswordIsWrong() {
        loginPage.login(" admin@admin.com", "123332");

        Assert.assertEquals(loginPage.getMessage(), "Wrong password");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));

    }

    @Test
    public void loginT() {
        loginPage.login("admin@admin.com", "12345");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[1]")));

        Assert.assertTrue(driver.getCurrentUrl().contains("/home"));

    }

    @Test
    public void logout() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("hidden-sm-and-down")));

        Assert.assertTrue(homePage.getLogoutButton().isDisplayed());


        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-btn--is-elevated")));
        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));

        driver.navigate().refresh();

        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("v-btn--is-elevated")));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));


    }


}

