package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdminCitiesTests extends BaseTest {

    private String cityName = faker.address().city();

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        driver.get("https://vue-demo.daniel-avellaneda.com/login");
        loginPage.login("admin@admin.com", "12345");
    }

    @Test
    public void visitsTheAdminCitiesPageAndListCities() {
        homePage.openAdminPage();
        homePage.selectAdmin();

        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
        Assert.assertTrue(homePage.getLogoutButton().isDisplayed());
    }

    @Test
    public void createNewCity() {
        homePage.openAdminPage();
        homePage.selectAdmin();
        adminPage.createCity(cityName);

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));

        Assert.assertTrue(adminPage.getSuccessfullyMessage().contains("Saved successfully"));

    }

    @Test
    public void editCityTest() {
        homePage.openAdminPage();
        homePage.selectAdmin();
        //   adminPage.createCity(cityName);
        adminPage.searchCity(cityName);


        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btnSave")));

        //  adminPage.editCity(cityName);
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));
        Assert.assertTrue(adminPage.getSuccessfullyMessage().contains("Saved successfully"));
    }

    @Test
    public void searchCityTest() {

        homePage.openAdminPage();
        homePage.selectAdmin();
        adminPage.searchCity(cityName);

        String successfullyMessage = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]";
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(successfullyMessage)));

        System.out.println("!! " + cityName);
        Assert.assertTrue(adminPage.containsCityName(cityName));
    }

    @Test
    public void deleteCity() {
        searchCityTest();
        adminPage.delete();

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")));
        Assert.assertTrue(adminPage.getMessDelete().contains("Deleted successfully"));

    }

    @AfterMethod
    public void afterMethod() {
        adminPage.logout();
    }
}

