package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AdminPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button/span")
    private WebElement newItemButton;

    @FindBy(name = "name")
    private WebElement inputNameField;

    @FindBy(className = "btnSave")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement successfullyMessage;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr")
    private List<WebElement> tableCity;

    @FindBy(className = "text-left")
    private WebElement textInFiled;

    @FindBy(id = "edit")
    private WebElement editButton;

    @FindBy(name = "name")
    private WebElement editName;

    @FindBy(className = "btnSave")
    private WebElement saveEditButton;

    @FindBy(className = "btnCancel")
    private WebElement cancelEditButton;

    @FindBy(className = "btnLogout")
    private WebElement logout;

    @FindBy(id = "search")
    private WebElement searchLine;

    @FindBy(id = "delete")
    private WebElement deleteButton;

    @FindBy(xpath = " //*[@id=\"app\"]/div[6]/div/div/div[2]/button[2]")
    private WebElement deleteD;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement messageDelete;


    public AdminPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void createCity(String cityName) {
        newItemButton.click();

        inputNameField.sendKeys(cityName);

        saveButton.click();

    }

    public String getSuccessfullyMessage() {
        return successfullyMessage.getText();
    }

  /*  public void editCity(String cityName) {
        editButton.click();
        editName.sendKeys("-edited");

        saveEditButton.click();
        cancelEditButton.click();
    }*/

    public String getField() {
        return textInFiled.getText();
    }

    public boolean containsCityName(String cityName) {

        for (WebElement tr : tableCity) {
            WebElement td2 = tr.findElement(By.className("text-left"));
            System.out.println(td2.getText());
            if (!td2.getText().contains(cityName)) {
                return false;
            }
        }
        return true;
    }

    public void logout() {
        logout.click();
    }

    public void searchCity(String cityName) {

        searchLine.sendKeys(cityName);
        editButton.click();
        editName.sendKeys("-edited");

        saveEditButton.click();
        cancelEditButton.click();
    }

    public void delete() {
        deleteButton.click();
        deleteD.click();

    }
    public String getMessDelete () {
        return messageDelete.getText();
    }
}
