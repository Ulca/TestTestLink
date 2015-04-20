package pages;

import org.openqa.selenium.*;

/**
 * Created by Ulca on 20.04.2015.
 */
public class SuperWorkPage extends SuperPage {

    private static final By titleFrame = By.name("titlebar");
    private static final By mainFrame = By.name("mainframe");
    private static final By workFrame = By.name("workframe");
    private static final By treeFrame = By.name("treeframe");
    private static final By iFrame = By.xpath("//iframe[@aria-describedby='cke_43']");

    SuperWorkPage(WebDriver driver) { super(driver); }

    protected void switchToTitleBar() {

        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(titleFrame));
    }

    protected void switchToMainFrame(){

        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));

    }

    protected void switchToWorkFrame(){

        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));
        driver.switchTo().frame(driver.findElement(workFrame));

    }

    protected void switchToIFrame(){

        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));
        driver.switchTo().frame(driver.findElement(iFrame));

    }

    protected void switchToIFrameFromWorkFrame(){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));
        driver.switchTo().frame(driver.findElement(workFrame));
        driver.switchTo().frame(driver.findElement(iFrame));
    }

    protected void switchToTreeFrame(){

        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(mainFrame));
        driver.switchTo().frame(driver.findElement(treeFrame));

    }

}
