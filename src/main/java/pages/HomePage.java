package pages;

/**
 * Created by admin on 08.04.2015.
 */
public class HomePage {
    private static final By logout = By.linkText("logout");

    public void logout(){
        driver.findElement(logout.click());
    }
}
