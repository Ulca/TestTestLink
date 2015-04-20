package tests.functional;

import models.TestCase;
import models.TestSuite;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

/**
 * Created by Ulca on 20.04.2015.
 */
public class TestSuiteTests extends SuperTest {

    //create suite test
    @Test
    public void createSuiteTest(){

        //open Test Specifications page
        HomePage homePage = new HomePage(driver);
        SpecificationManagementPage specPage = homePage.openTestSpecificationPage();
        //open project control panel
        specPage.showProjectControlPanel();
        //open TS edit page & create TS
        driver.findElement(By.id("new_testsuite")).click();
        TestSuiteEditPage suiteEditPage = new TestSuiteEditPage(driver);
        TestSuite testSuite = new TestSuite();
        suiteEditPage.createTS(testSuite);
        Assert.assertTrue(specPage.suiteCreated(testSuite)); //check if TS exists

    }

    //create case test
    @Test (dependsOnMethods = {"createSuiteTest"})
    public void createTestTest(){


        TestSuite testSuite = new TestSuite();
        //display the TS
        SpecificationManagementPage specPage = new SpecificationManagementPage(driver);
        specPage.goToSuite(testSuite);
        //open project control panel
        specPage.showProjectControlPanel();
        //open TC edit page & create a test case
        driver.findElement(By.id("create_tc")).click();
        TestCaseEditPage caseEditPage = new TestCaseEditPage(driver);
        TestCase testCase = new TestCase();
        caseEditPage.createTC(testCase);
        Assert.assertTrue(specPage.caseCreated(testSuite, testCase)); //check if TC exists

    }

    //create step test
    @Test (dependsOnMethods = {"createTestTest"})
    public void createStepTest(){

    }

}
