package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTest extends BaseTest {

    @Test
    public void testLocaleES() {
        homePage.selectLocaleES();

        Assert.assertTrue(homePage.getMessageES().contains("Página de aterrizaje"));
    }

    @Test
    public void testLocaleEN() {
        homePage.selectLocaleEN();

        Assert.assertTrue(homePage.getMessageEN().contains("Landing"));

    }

    @Test
    public void testLocaleFR() {
        homePage.selectLocaleFR();

        Assert.assertTrue(homePage.getMessageFR().contains("Page d'atterrissage"));

    }


}