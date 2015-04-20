package pages;

import models.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by admin on 08.04.2015.
 */
public class TestPlanManagementPage extends SuperWorkPage {

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

        driver.findElement(By.xpath("//a[contains(text(),'"+ testPlan.testPlanName +"')]/ancestor::tr/td/img[@alt='Delete the test plan?']")).click();
        driver.findElement(By.id("ext-gen20")).click();

    }

}
