package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button/span")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")
    private WebElement message;


    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);

    }

    public void login(String username, String password) {

        emailField.clear();
        emailField.sendKeys(username);

        passwordField.clear();
        passwordField.sendKeys(password);

        loginButton.click();
    }


    public String getAttributeEmail() {
        return emailField.getAttribute("type");
    }

    public String getAttributePassword() {
        return passwordField.getAttribute("type");
    }

    public void fakerLogin() {
        String email = faker.internet().emailAddress();
        emailField.sendKeys(email);

        String password = faker.internet().password();
        passwordField.sendKeys(password);

        loginButton.click();

    }

    public String getMessage() {
        return message.getText();
    }



}


