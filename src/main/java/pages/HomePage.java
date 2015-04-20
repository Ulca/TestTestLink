package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends SuperWorkPage {

    private static final By logout = By.xpath("//a[@accesskey='q']");
    private static final By testPlanManagementLink = By.xpath(".//*[@id='test_plan_mgmt_topics']/a[1]");
    private static final By testPlanSpecLink = By.xpath(".//*[@id='testspecification_topics']/a[1]");

    public HomePage(WebDriver driver) { super(driver); }

    public TestPlanManagementPage openTestPlanManagement() {

        //find test management link & open page
        switchToMainFrame();
        driver.findElement(testPlanManagementLink).click();
        return new TestPlanManagementPage(driver);

    }

    public SpecificationManagementPage openTestSpecificationPage() {

        //find test spec link & open page
        switchToMainFrame();
        driver.findElement(testPlanSpecLink).click();
        return new SpecificationManagementPage(driver);

    }

    public void logout() {

        switchToTitleBar();
        driver.findElement(logout).click();
    }

}
