package pages;

import models.TestSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Ulca on 20.04.2015.
 */
public class TestSuiteEditPage extends SuperWorkPage {

    public TestSuiteEditPage (WebDriver driver) {super(driver);}

    public static final By suiteName = By.id("name");
    public static final By suiteDetails = By.xpath("/html/body");
    public static final By saveBtn = By.name("add_testsuite_button");
    public static final By cancelBtn = By.name("go_back");
    public static final By suiteExists = By.xpath("//p[contains(text(),'Failed to update database!')]");


    public void createTS(TestSuite testSuite){

        driver.findElement(suiteName).sendKeys(testSuite.testSuiteName);
        switchToIFrameFromWorkFrame();
        driver.findElement(suiteDetails).sendKeys(testSuite.testSuiteDetails);
        switchToWorkFrame();
        driver.findElement(saveBtn).click();
        if (driver.findElements(suiteExists).size() > 0) {
            driver.findElement(cancelBtn).click();
        }

    }
}
