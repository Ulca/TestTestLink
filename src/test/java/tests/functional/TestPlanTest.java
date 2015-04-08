package tests.functional;

import models.*;
import pages.*;

import static org.testng.*;

public class TestPlanTest {

    WebDriver driver;

    @BeforeTest
    public void login(){
        driver = new FirefoxDriver();

        LoginPage loginPage = new LoginPage();
        loginPage.login(new User());

    }

    @Test
    public void createTestPlan(){

        HomePage homePage = new HomePage(driver);
        TestPlanMgmtPage testPlanMgmtPage = homePage.openTestManagement();
        TestPlanEditPage editPage = testPlanMgmtPage.createTestPlan();

        TestPlan testPlan = new TestPlan();
        editPage.createTestPlan(testPlan);

        Assert.assertTrue(testPlanMgmtPage.isTestPlanPresent(testPlan));

        deleteTestPlan(testPlan);

    }

    @AfterTest
    public void shutEnvironment(){
        logout();
        if (driver != null)
            driver.quit();
    }

    public void deleteTestPlan(TestPlan testPlan){

        TestPlanMgmtPage mgmtPage = new TestPlanMgmtPage(driver);
        mgmtPage.deleteTestPlan(testPlan);

    }

    public void logout(){

        HomePage homePage = new HomePage();
        homePage.logout();

    }
}
