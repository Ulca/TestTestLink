package pages;

import models.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by admin on 08.04.2015.
 */
public class TestPlanEditPage extends SuperWorkPage {

    public static final By testPlanName = By.name("testplan_name");
    public static final By testPlanDescription = By.xpath("/html/body");
    public static final By testPlanActive = By.name("active");
    public static final By testPlanPublic = By.name("is_public");
    public static final By createTP = By.name("do_create");
    public static final By testPlanExists = By.xpath("//p[contains(text(),'There is already a Test Plan with this name. Please choose another name!')]");
    public static final By cancelButton = By.name("go_back");

    public TestPlanEditPage (WebDriver driver) { super(driver);}

    public void createTestPlan(TestPlan testPlan) {

        driver.findElement(testPlanName).sendKeys(testPlan.testPlanName);
        switchToIFrame();
        driver.findElement(testPlanDescription).sendKeys(testPlan.testPlanDescription);
        switchToMainFrame();

        if (testPlan.active) {
            driver.findElement(testPlanActive).click();
        }
        if (testPlan.pub) {
            driver.findElement(testPlanPublic).click();
        }
        driver.findElement(createTP).click();
        if (driver.findElements(testPlanExists).size() > 0) {
            driver.findElement(cancelButton).click();
        }


    }

}
