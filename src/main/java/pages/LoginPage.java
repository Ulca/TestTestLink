package pages;

import models.*;
import org.openqa.selenium.*;

public class LoginPage extends SuperPage {

    private static final String URL = "http://demo.testlink.org/latest/login.php";

    private static final By loginField = By.id("login");
    private static final By passwordField = By.name("tl_password");
    private static final By loginButton = By.name("login_submit");

    public LoginPage(WebDriver driver){ super(driver); }

    public HomePage login(User user) {

        driver.navigate().to(URL);
        driver.findElement(loginField).sendKeys(user.userName);
        driver.findElement(passwordField).sendKeys(user.userLogin);
        driver.findElement(loginButton).click();

        return new HomePage(driver);
    }

}
