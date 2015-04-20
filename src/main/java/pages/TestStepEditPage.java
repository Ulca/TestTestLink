package pages;

import models.TestStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by admin on 20.04.2015.
 */
public class TestStepEditPage extends SuperWorkPage {

    public TestStepEditPage(WebDriver driver) {super(driver);}

    private static final By actionIFrame = By.xpath("//iframe[@aria-describedby='cke_24']");
    private static final By resultsIFrame = By.xpath("//iframe[@aria-describedby='cke_49']");
    public static final By stepActions = By.xpath("/html/body");
    public static final By expectedResults = By.xpath("/html/body");
    public static final By saveAndExitBtn = By.id("do_update_step_and_exit");

    protected void switchToActionIFrame(){

        switchToWorkFrame();
        driver.switchTo().frame(driver.findElement(actionIFrame));

    }
    protected void switchToResultsIFrame(){

        switchToWorkFrame();
        driver.switchTo().frame(driver.findElement(resultsIFrame));

    }

    public void createTestStep(TestStep testStep){

        switchToWorkFrame();
        //add actions
        switchToActionIFrame();
        driver.findElement(stepActions).sendKeys(testStep.testStep);
        //add expected result
     //   switchToResultsIFrame();
    //    driver.findElement(expectedResults).sendKeys(testStep.testExpectedResult);
        switchToWorkFrame();
        driver.findElement(saveAndExitBtn).click();

    }
}
