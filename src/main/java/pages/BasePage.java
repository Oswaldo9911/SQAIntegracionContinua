package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Oswaldo Buitrago SQA S.A - fabio.betancourt@sqasa.com
 */

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    
    //Constructor
    public BasePage (WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    //Metodo Click
    public void click (By elementLocation) {
        driver.findElement(elementLocation).click();
    }

    //Escribir Texto
    public void writeText (By elementLocation, String text) {
        driver.findElement(elementLocation).sendKeys(text);
    }

    //Leer Texto
    public String readText (By elementLocation) {
        return driver.findElement(elementLocation).getText();
    }
}
