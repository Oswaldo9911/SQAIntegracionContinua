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

public class RegisterPage extends BasePage {

    String primerNombreId = "firstName";
    String primerApellidoId = "lastName";
    String correoElectronicoId = "inputEmail";
    String claveId = "inputPassword";
    String claveConfirmacionId = "confirmPassword";
    String botonRegistroClass = "btn-primary";

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void registroPage(String nombre, String apellido, String correo, String clave) throws InterruptedException {
        // Escribe Nombre
        writeText(By.id(primerNombreId), nombre);
        Thread.sleep(500);
        // Escribe Apellido
        writeText(By.id(primerApellidoId), apellido);
        Thread.sleep(500);

        // Escribe Email
        writeText(By.id(correoElectronicoId), correo);
        Thread.sleep(500);

        // Escribe Clave
        writeText(By.id(claveId), clave);
        Thread.sleep(500);

        // Confirma Clave
        writeText(By.id(claveConfirmacionId), clave);
        Thread.sleep(1000);

        // Button Registro
        click(By.className(botonRegistroClass));
        Thread.sleep(500);

    }

}
