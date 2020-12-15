package pages;

import driver.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.Action;

public class UsersGrid extends DriverManager {

    By btnNewUser = By.cssSelector("#btn-new");

    public void clickNewUsers() {
        Action.getVisibleElement(btnNewUser);
        getDriver().findElement(btnNewUser).click();
    }

    public void clickShowUser(String lastUser) {
        String elem = "btn-show_" + lastUser;
        By btnShowLastUser = By.id(elem);
        Action.getVisibleElement(btnShowLastUser);
        getDriver().findElement(btnShowLastUser).click();


    }

    public void clickEditUser(String lastUser) {
        String elem = "btn-edit_" + lastUser;
        By btnShowLastUser = By.id(elem);
        Action.getVisibleElement(btnShowLastUser);
        getDriver().findElement(btnShowLastUser).click();
    }

    public void clickDeleteUser(String lastUser) {
        String elem = "btn-delete_" + lastUser;
        By btnShowLastUser = By.id(elem);
        Action.getVisibleElement(btnShowLastUser);
        getDriver().findElement(btnShowLastUser).click();

    }

    public void clickConfirmDelete() {
        final Alert alert = getDriver().switchTo().alert();
        alert.accept();
    }

    public boolean getShowButton(String lastUser) {
        String elem = "btn-show_" + lastUser;
        By btnUserShow = By.id(elem);
       return Action.existElement(btnUserShow, 10);
        }
    }

