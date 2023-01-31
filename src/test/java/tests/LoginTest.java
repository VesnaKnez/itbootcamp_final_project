package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @BeforeMethod
    public void beforeMethod() {
      super.beforeMethod();
      homePage.openLoginPage();
    }

    @Test
    public void  VisitsТheLoginPage() {

        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/login"));

        driver.navigate().refresh();

        actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/login"));

    }
}
