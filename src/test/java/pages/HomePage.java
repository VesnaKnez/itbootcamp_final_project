package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[3]/span")
    private WebElement loginButton;

    @FindBy(className = "hidden-sm-and-down")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/a[4]/span")
    private WebElement signupButton;


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

}
