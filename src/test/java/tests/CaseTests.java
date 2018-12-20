package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MenuPage;
import pages.RegisterPage;
import utils.ExtentReports.ExtentTestManager;

/**
 * 
 * @author Oswaldo Buitrago SQA S.A - fabio.betancourt@sqasa.com
 */

public class CaseTests extends BaseTest {

// Información extra:
// 1) @BeforeClass declaramos las variables driver y wait
// 2) Enviamos estas variables de controlador y de espera a la clase de página con la siguiente declaración
// página de inicio = página de inicio nueva (controlador, espera);
// 3) el método super () en la clase de página transfiere el controlador y espera los valores de las variables a la clase BasePage.
    @Test(priority = 0, description = "Escenario de inicio de sesion")
    public void loginBootstrap() throws InterruptedException, Exception {
        //ExtentReports Descripcion
        ExtentTestManager.getTest().setDescription("Escenario de inicio de sesion");

        //************* Instacias *************
        HomePage homePage = new HomePage(driver, wait);
        LoginPage loginPage = new LoginPage(driver, wait);

        //************* Metodos********************
        //Abrir pagina
        homePage.goToN11();

        //Login Pagina
        loginPage.loginToN11("fabio.betancourt@sqasa.com", "1233903960");

        //************* ASSERTIONS ***********************
        Thread.sleep(500);
        //loginPage.verifyLoginPassword(("Su dirección de correo electrónico o contraseña es incorrecta"));
    }

    @Test(priority = 1, description = "Menu de sistema")
    public void menuBootstrap() throws InterruptedException {
        ExtentTestManager.getTest().setDescription("Escenario de menu Bootstrap");
        MenuPage menuPage = new MenuPage(driver, wait);    
        // Ir a registro
        menuPage.menuPagina();
    }

    @Test(priority = 2, description = "Registro en el Sistema")
    public void registroSistema() throws InterruptedException {
        ExtentTestManager.getTest().setDescription("Registro en Sistema");
        RegisterPage registerPage = new RegisterPage(driver, wait);
        // Registro en Sistema
        registerPage.registroPage("Oswaldo", "Buitrago", "fabio.betancourt@sqasa.com", "OswaldoBet99");
    }
    
    @Test(priority = 3, description = "Prueba Posicion")
    public void pruebaPosicion() {
        ExtentTestManager.getTest().setDescription("Prueba Posicion");
    }
    
}
