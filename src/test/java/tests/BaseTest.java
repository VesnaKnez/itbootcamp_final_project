package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public  abstract class BaseTest {

        protected WebDriver driver;
        protected WebDriverWait driverWait;
        protected LoginPage loginPage;
        protected HomePage homePage;
        protected Faker faker;

        @BeforeClass
        public void beforeClass() {
            System.setProperty("webdriver.chrome.driver", "D:\\New folder\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            loginPage = new LoginPage(driver, driverWait);
            homePage = new HomePage(driver, driverWait);
            faker = new Faker();
        }

        @BeforeMethod
        public void beforeMethod() {
            driver.get("https://vue-demo.daniel-avellaneda.com");

        }

        @AfterClass
        public void afterClass() {
            driver.quit();
        }
    }
