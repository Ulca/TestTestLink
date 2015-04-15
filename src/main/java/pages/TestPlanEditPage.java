package pages;

import models.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by admin on 08.04.2015.
 */
public class TestPlanEditPage extends SuperPage{

    public static final By testPlanName = By.name("testplan_name");
    public static final By testPlanDescription = By.name("notes");
    public static final By testPlanActive = By.name("active");
    public static final By testPlanPublic = By.name("is_public");
    public static final By createTP = By.name("do_create");

    public TestPlanEditPage (WebDriver driver) { super(driver);}

    public void createTestPlan(TestPlan testPlan) {

        driver.findElement(testPlanName).sendKeys(testPlan.testPlanName);
    //    driver.findElement(testPlanDescription).sendKeys(testPlan.testPlanDescription);
        if (testPlan.active & !driver.findElement(testPlanActive).isSelected()) {
            driver.findElement(testPlanActive).click();
        }
        if (testPlan.pub & !driver.findElement(testPlanPublic).isSelected()) {
            driver.findElement(testPlanPublic).click();
        }
        driver.findElement(createTP).click();

    }

}
