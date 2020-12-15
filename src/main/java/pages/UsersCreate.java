package pages;

import driver.DriverManager;
import org.openqa.selenium.By;
import support.Action;

public class UsersCreate extends DriverManager {

    private By inputAge = By.id("user_age");
    private By inputEmail = By.id("user_email");
    private By inputFullName = By.id("user_full_name");
    private By inputLogin = By.id("user_login");
    private By btnSave = By.cssSelector("#btn-save");
    private String lastUser = ("");

    public void fillField(String field, String value) {
        switch (field){
            case "login": fillLogin(value); break;
            case "nome completo": fillFullName(value); break;
            case "email": fillEmail(value); break;
            case "idade": fillAge(value); break;
        }
    }

    private void fillAge(String value) {

        getDriver().findElement(inputAge).sendKeys(value);
    }

    private void fillEmail(String value) {

        getDriver().findElement(inputEmail).sendKeys(value);
    }

    private void fillFullName(String value) {
        getDriver().findElement(inputFullName).sendKeys(value);
    }

    private void fillLogin(String value) {
        Action.getVisibleElement(inputLogin);
        getDriver().findElement(inputLogin).sendKeys(value);

    }

    public void clickSave() {
        getDriver().findElement(btnSave).click();
    }

    public void setLastUser(String user) {
        lastUser = user;

    }
    public String getLastUser() {
        return lastUser;

    }
}
