package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * 
 * @author Oswaldo Buitrago SQA S.A - fabio.betancourt@sqasa.com
 */

public class LoginPage extends BasePage {

    //********* Constructor *********
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //********* Elementos web *********
    String usenameId = "inputEmail";
    String passwordId = "inputPassword";
    String loginButtonClass = "btn-primary";
    String errorMessageUsernameXpath = "//*[@id=\"inputEmail\"]";
    String errorMessagePasswordXpath = "//*[@id=\"inputPassword\"]";

    //********* Métodos de página *********
    public void loginToN11(String username, String password) throws Exception, Exception {
        //Enter Username(Email)
        writeText(By.id(usenameId), username);
        //Enter Password
        writeText(By.id(passwordId), password);
        //Click Login Button
        click(By.className(loginButtonClass));
        // Instacia Sikuli

        // Prueba de Escritorio
//        ActionDesktop ad = new ActionDesktop();
//        ad.iniciarApp("C:\\windows\\system32\\calc.exe", System.getProperty("user.dir") + "\\Winium.Desktop.Driver.exe");

    }

    //Verificar la condición del nombre de usuario
    public void verifyLoginUserName(String expectedText) {
        Assert.assertEquals(readText(By.xpath(errorMessageUsernameXpath)), expectedText);
    }

    //Verificar condición de contraseña
    public void verifyLoginPassword(String expectedText) {
        Assert.assertEquals(readText(By.xpath(errorMessagePasswordXpath)), expectedText);
    }

}
