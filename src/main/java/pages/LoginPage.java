package pages;

import driver.DriverManager;
import lombok.extern.log4j.Log4j2;
import report.Report;
import support.Verifications;
import org.openqa.selenium.By;



import java.util.Map;

@Log4j2
public class LoginPage extends DriverManager {

    private By txtUsuario = By.name("email");
    private By txtSenha = By.name("senha");
    private By btnEntrar = By.xpath("//button");


    public void acessaAplicacao(){

       getDriver().get(configuration.url());
        Verifications.verifyElementIsClickable(getDriver(),txtUsuario,
                Integer.parseInt(configuration.timeout()));
        Report.TakeScreenShot(getDriver());
        log.info("Acesso a aplicacao efetuado com sucesso");
    }

    public void executaLogin(Map data){
        getDriver().findElement(txtUsuario).sendKeys((CharSequence) data.get("usuario"));
        getDriver().findElement(txtSenha).sendKeys((CharSequence) data.get("senha"));
        Report.TakeScreenShot(getDriver());
        getDriver().findElement(btnEntrar).click();
        log.info("Login na aplicacao efetuado com sucesso");
    }


}
