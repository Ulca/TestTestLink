package pages;

import models.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by admin on 08.04.2015.
 */
public class TestPlanManagementPage extends SuperPage {

    private static TestPlan testPlan;

    public static final By testPlanEditButton = By.name("create_testplan");

    public TestPlanManagementPage(WebDriver driver) { super(driver);}

    public TestPlanEditPage createTestPlan() {

        driver.findElement(testPlanEditButton).click();

        return new TestPlanEditPage(driver);
    }

    public boolean testPlanIsPresent(TestPlan testPlan){

        return (driver.findElement(By.linkText(testPlan.testPlanName)) != null);
    }

    public void deleteTestPlan(TestPlan testPlan) {

        if (driver.findElement(By.linkText(testPlan.testPlanName)) != null) {
            //delete test plan
            }


    }

}
