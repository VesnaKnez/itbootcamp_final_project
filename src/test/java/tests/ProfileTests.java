package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {


    private String name = faker.name().fullName();
    private String phone = faker.phoneNumber().cellPhone();
    private String city = faker.address().city();
    private String country = faker.address().country();
    private String twitter =  faker.internet().url();
    private String github = faker.internet().url();


    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        driver.get("https://vue-demo.daniel-avellaneda.com/login");
        loginPage.login("admin@admin.com", "12345");
        homePage.myProfile();
    }

    @Test
    public void fillForm() {

        profilePage.fillProfile( name, phone, city, country, twitter, github);

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")));
        Assert.assertTrue(profilePage.getSuccessfulyMes().contains("Profile saved successfuly"));

        Assert.assertEquals(profilePage.getNameField().getAttribute("value"), name);
        Assert.assertEquals(profilePage.getPhoneField().getAttribute("value"), phone );
        Assert.assertEquals(profilePage.getCityField().getAttribute("value"), city );
        Assert.assertEquals(profilePage.getCountryField().getAttribute("value"), country );
        Assert.assertEquals(profilePage.getTwitterField().getAttribute("value"), twitter );
        Assert.assertEquals(profilePage.getGitHubField().getAttribute("value"), github );
    }
}
