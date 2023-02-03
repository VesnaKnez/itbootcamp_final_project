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


}
