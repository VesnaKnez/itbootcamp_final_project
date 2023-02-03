package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends BasePage {

    @FindBy(name = "name")
    private WebElement nameField;

    @FindBy(name = "email")
    private WebElement email1Field;

    @FindBy(name = "password")
    private WebElement password1Field;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button/span")
    private WebElement signMeUpButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li")
    private WebElement messageExists;


    public SignUpPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public String getAttributeEmail1Field() {
        return email1Field.getAttribute("type");
    }

    public String getAttributePassword1Field() {
        return password1Field.getAttribute("type");
    }

    public String getAttributeConfirmPasswordField() {
        return confirmPasswordField.getAttribute("type");
    }

    public void signUp() {

        nameField.sendKeys("Test Test");
        email1Field.sendKeys("admin@admin.com");
        password1Field.sendKeys("123654");
        confirmPasswordField.sendKeys("123654");

        signMeUpButton.click();
    }

    public void signUp1(String name, String email, String password, String confirmpass) {
        nameField.sendKeys(name);
        email1Field.sendKeys(email);
        password1Field.sendKeys(password);
        confirmPasswordField.sendKeys(confirmpass);

        signMeUpButton.click();
    }

    public String getMessageExists() {
        return messageExists.getText();
    }
}

