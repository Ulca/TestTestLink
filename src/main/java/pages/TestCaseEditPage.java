package pages;

import models.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Ulca on 20.04.2015.
 */
public class TestCaseEditPage extends SuperWorkPage {

    public TestCaseEditPage(WebDriver driver) {super(driver);}

    public static final By caseTitle = By.id("testcase_name");
    public static final By caseSummary = By.xpath("/html/body");
    public static final By saveBtn = By.id("do_create_button");
    public static final By cancelBtn = By.id("go_back");
    public static final By caseExists = By.xpath("//p[contains(text(),'There was an error while adding the Test Case')]");

    public void createTC(TestCase testCase) {

        driver.findElement(caseTitle).sendKeys(testCase.testCaseTitle);
     //   switchToIFrameFromWorkFrame();
     //   driver.findElement(suiteDetails).sendKeys(testSuite.testSuiteDetails);
     //   switchToWorkFrame();
        driver.findElement(saveBtn).click();
        if (driver.findElements(caseExists).size() > 0) {
            driver.findElement(cancelBtn).click();
        }

    }
}
