package pages;

import models.*;
import org.openqa.selenium.WebDriver;

/**
 * Created by admin on 08.04.2015.
 */
public class TestPlanManagementPage extends SuperPage {

    public TestPlanManagementPage(WebDriver driver) { super(driver);}

    public TestPlanEditPage createTestPlan() {return null;}

    public boolean isTestPlanPresent(TestPlan testPlan){return true;}

    public void deleteTestPlan(TestPlan testPlan) {}

}
