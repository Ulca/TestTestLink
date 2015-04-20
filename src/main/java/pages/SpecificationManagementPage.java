package pages;

import models.*;
import org.openqa.selenium.*;

/**
 * Created by Ulca on 20.04.2015.
 */
public class SpecificationManagementPage extends SuperWorkPage {

    public SpecificationManagementPage(WebDriver driver) {super(driver);}
    public static final By cog = By.xpath("/html/body/div/img[@src='gui/themes/default/images/cog.png']");

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
        return (driver.findElements(By.xpath("//span[contains(text(),'" + testCase.testCaseTitle + "')]")).size() > 0);
    }

    public void goToCase(TestCase testCase){

        switchToTreeFrame();
        driver.findElement(By.xpath("//span[contains(text(),'" + testCase.testCaseTitle + "')]")).click();
    }


}
