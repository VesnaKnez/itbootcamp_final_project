package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "phone")
    private WebElement phoneField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "country")
    private WebElement countryField;

    @FindBy(id = "urlTwitter")
    private WebElement twitterField;

    @FindBy(id = "urlGitHub")
    private WebElement gitHubField;

    @FindBy(className = "btnSave")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement successfulyMes;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[3]/span/div/div/div[1]/div[2]/div/button")
    private WebElement phoneX;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[4]/span/div/div/div[1]/div[1]/div[1]/div/button")
    private WebElement cityX;

    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clearFields() {
        nameField.click();
        nameField.sendKeys(Keys.CONTROL + "a");
        nameField.sendKeys(Keys.DELETE);

        phoneX.click();

        cityX.click();

        countryField.sendKeys(Keys.CONTROL + "a");
        countryField.sendKeys(Keys.DELETE);
        twitterField.sendKeys(Keys.CONTROL + "a");
        twitterField.sendKeys(Keys.DELETE);
        gitHubField.sendKeys(Keys.CONTROL + "a");
        gitHubField.sendKeys(Keys.DELETE);


    }

    public void pickCity(String city) {

        cityField.click();
        cityField.sendKeys(Keys.CONTROL + "a");
        cityField.sendKeys("New York");
        cityField.sendKeys(Keys.ENTER);
    }

    public void fillProfile(String name, String phone, String city, String country, String twitter, String github) {

        clearFields();

        nameField.sendKeys(name);

        phoneField.sendKeys(phone);

        pickCity(city);

        countryField.sendKeys(country);

        twitterField.sendKeys(twitter);

        gitHubField.sendKeys(github);

        saveButton.click();

    }

    public String getSuccessfulyMes() {
        return successfulyMes.getText();
    }

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getPhoneField() {
        return phoneField;
    }

    public WebElement getCityField() {
        return cityField;
    }

    public WebElement getCountryField() {
        return countryField;
    }

    public WebElement getTwitterField() {
        return twitterField;
    }

    public WebElement getGitHubField() {
        return gitHubField;
    }
}
