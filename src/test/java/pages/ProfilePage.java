package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage{

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "phone")
    private WebElement phoneField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id= "country")
    private WebElement countryField;

    @FindBy(id = "urlTwitter")
    private WebElement twitterField;

    @FindBy(id = "urlGitHub")
    private WebElement gitHubField;

    @FindBy(className = "btnSave")
    private WebElement saveButton;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement successfulyMes;

    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void fillProfile ( String name, String phone, String city, String country, String twitter, String github) {

        nameField.clear();
        nameField.sendKeys( name);

        phoneField.clear();
        phoneField.sendKeys(phone);

        cityField.clear();

        this.cityField.sendKeys(Keys.SPACE);
        this.cityField.sendKeys(Keys.CONTROL + "a");
        this.cityField.sendKeys(city);
        this.cityField.sendKeys(Keys.ARROW_DOWN);
        this.cityField.sendKeys(Keys.ENTER);



        countryField.clear();
        countryField.sendKeys(country);

        twitterField.clear();
        twitterField.sendKeys(twitter);

        gitHubField.clear();
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
