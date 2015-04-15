package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;

public class HomePage extends SuperPage{

    private static final By logout = By.linkText("logout");
    private static final By testManagementURL = By.xpath(".//*[@id='test_plan_mgmt_topics']/a[1]");

    public HomePage(WebDriver driver) { super(driver); }

    public TestPlanManagementPage openTestManagement() {

        //find test management link & open page
        driver.switchTo().frame("mainframe");
        driver.findElement(testManagementURL).click();
        return new TestPlanManagementPage(driver);

    }

    public void logout() {

        driver.switchTo().frame("titlebar");
        driver.findElement(logout).click();
    }

}
