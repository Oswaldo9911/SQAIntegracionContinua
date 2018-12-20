package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * 
 * @author Oswaldo Buitrago SQA S.A - fabio.betancourt@sqasa.com
 */

public class HomePage extends BasePage {

    //*********Constructor*********
    public HomePage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //********* Variables de Paginas *********
    String baseURL = "https://blackrockdigital.github.io/startbootstrap-sb-admin/login.html";

    //*********Elementos Web ********
    String signInButtonClass = "btnSignIn";


    //********* Metodos de Pagina *********

    //Ir a la página de inicio
    public void goToN11 (){
        driver.get(baseURL);
        //driver.navigate().to(baseURL)
    }

    //Ir a la página de LoginPage
    public void goToLoginPage (){
        click(By.className(signInButtonClass));
    }

}
