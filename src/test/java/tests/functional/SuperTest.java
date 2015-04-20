package tests.functional;

import models.*;
import pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ulca on 20.04.2015.
 */
public class SuperTest {

    WebDriver driver;
    protected static WebDriverWait wait;

    @BeforeTest
    public void login(){
        driver = new FirefoxDriver();

        wait = new WebDriverWait(driver, 30);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(new User());

    }

    @AfterTest
    public void shutEnvironment() {
        logout();
        if (driver != null) {
           driver.quit();

            //  driver.quit();
        }

    }

    public void logout(){

        HomePage homePage = new HomePage(driver);
        homePage.logout();

    }

}
