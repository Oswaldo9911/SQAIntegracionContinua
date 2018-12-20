/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Oswaldo Buitrago SQA S.A - fabio.betancourt@sqasa.com
 */

public class MenuPage extends BasePage{
    
    String clickMenuPageId = "pagesDropdown";
    String clickMenuPageRegistroXpath = "//*[@id=\"wrapper\"]/ul/li[2]/div/a[2]";
    
    
    public MenuPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    
    public void menuPagina() throws InterruptedException{
        // Click menu 
        click(By.id(clickMenuPageId));
        Thread.sleep(500);
        // Click menu Registro
        click(By.xpath(clickMenuPageRegistroXpath));
    }
    
}
