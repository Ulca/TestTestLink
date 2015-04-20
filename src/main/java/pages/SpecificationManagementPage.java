package pages;

import models.*;
import org.openqa.selenium.*;

/**
 * Created by Ulca on 20.04.2015.
 */
public class SpecificationManagementPage extends SuperWorkPage {

    public SpecificationManagementPage(WebDriver driver) {super(driver);}

    public static final By testSuiteCreateButton = By.id("new_testsuite");
    public static final By testCaseCreateButton = By.id("create_tc");
    public static final By testStepCreateButton = By.name("create_step");
    public static final By cog = By.xpath("/html/body/div/img[@src='gui/themes/default/images/cog.png']");

    public TestSuiteEditPage createTestSuite(){

        driver.findElement(testSuiteCreateButton).click();

        return new TestSuiteEditPage(driver);

    }

    public TestCaseEditPage createTestCase(){

        driver.findElement(testCaseCreateButton).click();

        return new TestCaseEditPage(driver);
    }

    public void showProjectControlPanel(){

        switchToWorkFrame();
        driver.findElement(cog).click();

    }

    public boolean suiteCreated(TestSuite testSuite){

        switchToTreeFrame();
        return (driver.findElements(By.xpath("//span[contains(text(),'"+testSuite.testSuiteName+"')]")).size() > 0);
    }

    public void goToSuite(TestSuite testSuite){

        switchToTreeFrame();
        driver.findElement(By.xpath("//span[contains(text(),'" + testSuite.testSuiteName + "')]")).click();
    }

    public boolean caseCreated(TestSuite testSuite, TestCase testCase){

        goToSuite(testSuite);
        switchToTreeFrame();
        driver.findElement(By.xpath("//span[contains(text(),'" + testSuite.testSuiteName + "')]/ancestor::li[@class='x-tree-node']/div/img[@class='x-tree-ec-icon x-tree-elbow-plus']")).click();
        boolean value2Return = driver.findElements(By.xpath("//span[contains(text(),'" + testCase.testCaseTitle + "')]")).size() > 0;
        return value2Return;
    }

    public void goToCase(TestCase testCase){

        switchToTreeFrame();
        driver.findElement(By.xpath("//span[contains(text(),'" + testCase.testCaseTitle + "')]")).click();
    }

    public TestStepEditPage createTestStep(){

        switchToWorkFrame();
        driver.findElement(testStepCreateButton).click();
        return new TestStepEditPage(driver);

    }

    public boolean stepCreated(){return true;
    }


}
