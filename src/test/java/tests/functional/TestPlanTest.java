package tests.functional;

import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import models.*;
import pages.*;

import java.util.concurrent.TimeUnit;

public class TestPlanTest extends SuperTest {

    @Test
    public void createTestPlanTest(){

        HomePage homePage = new HomePage(driver);
        TestPlan testPlan = new TestPlan();

        TestPlanManagementPage testPlanManagementPage = homePage.openTestPlanManagement(); //open Test Plan Mgmt page
        createTestPlan(testPlan); //create new test plan
        Assert.assertTrue(testPlanManagementPage.testPlanIsPresent(testPlan)); //check if TP exists
        deleteTestPlan(testPlan); //delete TP for cleanup

    }

    public void createTestPlan(TestPlan testPlan){

        TestPlanManagementPage mgmtPage = new TestPlanManagementPage(driver);
        TestPlanEditPage editPage = mgmtPage.createTestPlan();
        editPage.createTestPlan(testPlan);
    }

    public void deleteTestPlan(TestPlan testPlan){

        TestPlanManagementPage mgmtPage = new TestPlanManagementPage(driver);
        mgmtPage.deleteTestPlan(testPlan);

    }

}
