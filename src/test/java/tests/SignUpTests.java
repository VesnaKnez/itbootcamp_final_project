package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignUpTests extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        homePage.openSignUpPage();
    }

    @Test
    public void visitsTheSignupPage() {

        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/signup"));

        driver.navigate().refresh();

        actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/signup"));

    }

    @Test
    public void checksInputTypes() {
        Assert.assertEquals(signUpPage.getAttributeEmail1Field(), "email");

        Assert.assertEquals(signUpPage.getAttributePassword1Field(), "password");

        Assert.assertEquals(signUpPage.getAttributeConfirmPasswordField(), "password");
    }

    @Test
    public void displaysErrorsWhenUserAlreadyExists() {
        signUpPage.signUp();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li")));

        Assert.assertEquals(signUpPage.getMessageExists(), "E-mail already exists");
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));

    }

    @Test
    public void signUpTest() {
        signUpPage.signUp1("Vesna Knezevic", "vesna@gmail.com", "123456", "123456");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]")));

        Assert.assertTrue(homePage.getLogoutButton().isDisplayed());

    }


}
