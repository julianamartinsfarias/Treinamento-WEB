package pages;

import driver.DriverManager;
import org.openqa.selenium.By;

public class UsersShow extends DriverManager {


    private By btnBack = By.cssSelector(".ls-btn-primary-danger");
    private By lblNotice = By.id("notice");
    private By lblCode = By.id("codigo");
    private By lblLogin = By.id("login");
    private By lblFullName = By.id("full_name");
    private By lblEmail = By.id("email");
    private By lblAge = By.id("age");


    public void clickBack() {
        getDriver().findElement(btnBack).click();
    }

    public String getNotice() {

        return getDriver().findElement(lblNotice).getText();
    }

    public String getCode() {

        return getDriver().findElement(lblCode).getText();
    }

    public String fillField(String field) {
       String res = "";
        switch (field) {
            case "login": res = getLogin();break;
            case "nome completo": res = getFullName();break;
            case "email": res = getEmail(); break;
            case "idade": res = getAge(); break;

    }
    return res;
}

    private String getAge() {

        return getDriver().findElement(lblAge).getText();
    }

    private String getEmail() {

        return getDriver().findElement(lblEmail).getText();
    }

    private String getFullName() {

        return getDriver().findElement(lblFullName).getText();
    }

    private String getLogin() {

            return getDriver().findElement(lblLogin).getText();
    }
}

