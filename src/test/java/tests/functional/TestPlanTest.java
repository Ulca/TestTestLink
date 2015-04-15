package tests.functional;

import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import models.*;
import pages.*;

import java.util.concurrent.TimeUnit;

public class TestPlanTest {

    private WebDriver driver;
    private HomePage homePage;
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
        homePage = loginPage.login(new User());

    }

    @Test
    public void createTestPlan(){

    //    HomePage homePage = new HomePage(driver); //new HomePage(driver);
        TestPlanManagementPage testPlanManagementPage = homePage.openTestManagement();
        TestPlanEditPage editPage = testPlanManagementPage.createTestPlan();

        TestPlan testPlan = new TestPlan();
        editPage.createTestPlan(testPlan);

        Assert.assertTrue(testPlanManagementPage.testPlanIsPresent(testPlan));

        deleteTestPlan(testPlan);

    }

    @AfterTest
    public void shutEnvironment(){
        logout();
        if (driver != null)
            driver.quit();
    }

    public void deleteTestPlan(TestPlan testPlan){

        TestPlanManagementPage mgmtPage = new TestPlanManagementPage(driver);//new TestPlanMgmtPage(driver);
        mgmtPage.deleteTestPlan(testPlan);

    }

    public void logout(){

        //HomePage homePage = new HomePage(driver);
        homePage.logout();

    }
}
