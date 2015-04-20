package tests.functional;

import models.TestCase;
import models.TestStep;
import models.TestSuite;
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
        TestSuiteEditPage suiteEditPage = specPage.createTestSuite();
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
        TestCaseEditPage caseEditPage = specPage.createTestCase();
        TestCase testCase = new TestCase();
        caseEditPage.createTC(testCase);
        Assert.assertTrue(specPage.caseCreated(testSuite, testCase)); //check if TC exists

    }

    //create step test
    @Test (dependsOnMethods = {"createTestTest"})
    public void createStepTest(){

        TestCase testCase = new TestCase();
        TestStep testStep = new TestStep();
        //display the TC
        SpecificationManagementPage specPage = new SpecificationManagementPage(driver);
        specPage.goToCase(testCase);
        //click the button
        TestStepEditPage editStep = specPage.createTestStep();
        //open TC edit page & create a test case
        editStep.createTestStep(testStep);
//        Assert.assertTrue(specPage.stepCreated(testCase, testStep)); //check if TC exists

    }

}
