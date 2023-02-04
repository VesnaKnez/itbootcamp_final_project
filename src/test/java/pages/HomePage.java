package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]/span")
    private WebElement loginButton;

    @FindBy(className = "hidden-sm-and-down")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[4]/span")
    private WebElement signupButton;

    @FindBy(className = "btnAdmin")
    private WebElement adminButton;

    @FindBy(className = "btnAdminCities")
    private WebElement adminCities;

    @FindBy(className = "btnLocaleActivation")
    private WebElement localeButton;

    @FindBy(className = "btnES")
    private WebElement localeESButton;

    @FindBy(className = "btnEN")
    private WebElement localeENButton;

    @FindBy(className = "btnFR")
    private WebElement localeFRButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement messageES;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement messageEN;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement messageFR;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]")
    private WebElement myProfileButton;



    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void openLoginPage () {
        loginButton.click();
    }
    public void openSignUpPage () {
        signupButton.click();
    }
    public WebElement getLogoutButton() {
        return logoutButton;
    }
    public void openAdminPage() {
        adminButton.click();
    }
    public void selectAdmin() {
        adminCities.click();
    }

    public void selectLocaleES () {
        localeButton.click();
        localeESButton.click();
    }

    public String getMessageES () {
        return messageES.getText();
    }

    public void selectLocaleEN () {
        localeButton.click();
        localeENButton.click();
    }
    public String getMessageEN () {
        return messageEN.getText();
    }
    public void selectLocaleFR () {
        localeButton.click();
        localeFRButton.click();
    }

    public String getMessageFR () {
        return messageFR.getText();
    }

    public void myProfile () {
        myProfileButton.click();
    }
    public void logout() {
        logoutButton.click();
    }


}
