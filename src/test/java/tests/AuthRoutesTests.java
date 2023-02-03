package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {

    @Test
    public void authRoutesTest1() {

        driver.get("https://vue-demo.daniel-avellaneda.com/home");

        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/login"));
    }

    @Test
    public void authRoutesTest2() {
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");

        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/login"));
    }

    @Test
    public void authRoutesTest3() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");

        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/login"));
    }

    @Test
    public void authRoutesTest4() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");

        String actualLink = driver.getCurrentUrl();
        Assert.assertTrue(actualLink.contains("/login"));

}
}



