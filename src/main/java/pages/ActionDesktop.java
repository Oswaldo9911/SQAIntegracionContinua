package pages;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;
//import selenium.webdriver.common.action_chains;

/**
 * 
 * @author Oswaldo Buitrago SQA S.A - fabio.betancourt@sqasa.com
 */

public class ActionDesktop {

    public static WiniumDriver driver;
    public static WiniumDriverService service;
    public static Actions action;
    public static Robot robot;
//    ActionChains actions = ActionChains(driver);

    /**
     * Constructor para iniciar objeto con el WiniunDriver
     *
     * @param args
     * @throws java.lang.InterruptedException
     */
//    public static void main(String[] args) throws InterruptedException {
//
//        ActionDesktop ad = new ActionDesktop();
//        ad.iniciarApp("C:\\Program Files (x86)\\SAP\\FrontEnd\\SAPgui\\saplogon.exe", System.getProperty("user.dir") + "\\Winium.Desktop.Driver.exe");
//        ad.clickName("Maximizar");
//        ad.doubleClickName("ERP CALIDAD");
//        Thread.sleep(5000);
//
//    }

    public ActionDesktop() {

    }

    public void espera(int espera) throws InterruptedException {
        Thread.sleep(espera);
    }

    /**
     * MÃ©todo para iniciar la App
     *
     * @param path ruta del .exe de la app a ejecutar
     * @param instancia ruta del .exe del winiumDriver
     */
    public void iniciarApp(String path, String instancia) {
        try {
            DesktopOptions options = new DesktopOptions();
            options.setApplicationPath(path);
            File file = new File(instancia);
            service = new WiniumDriverService.Builder().usingDriverExecutable(file).usingPort(9999).withVerbose(true).withSilent(true).buildDesktopService();
            service.start();
            driver = new WiniumDriver(service, options);
            action = new Actions(driver);
            robot = new Robot();
        } catch (Exception e) {
            //
            System.out.println("Error DESKTOP(2000): No Fue Posible Iniciar La Aplicacion " + e.getMessage());
        }
    }

    /**
     * MÃ©todo que selecciona la acciÃ³n a realizar segun el nombre de la misma
     *
     * @param accion nombre del mÃ©tod a ejecutar
     * @param elemento valor del atributo con el que se realiza la busqueda del
     * @param elemento2 valor del atributo con el que se realiza la busqueda del
     * WebElement
     * @param element WebElement ya encontrado
     * @param element2 WebElement ya encontrado
     * @param text texto a ingresar en un WebElement
     * @param attrValue nombre del atributo o valor por el que se desea buscar
     * @param obj Objeto con el que se desea realizar la accion en List< WebElement
     * >
     * @param x valor del eje x o el indice que se desea utilizar
     * @param y valor del eje y que se desea utilizar
     */
    public void realizarAccion(String accion, String elemento, String elemento2, WebElement element, WebElement element2, String text, String attrValue, Object obj, int x, int y) {
        switch (accion) {
            case "elementByName":
                elementByName(elemento);
                break;
            case "elementById":
                elementById(elemento);
                break;
            case "elementByClassName":
                elementByClassName(elemento);
                break;
            case "elementByCssSelector":
                elementByCssSelector(elemento);
                break;
            case "elementByLinkText":
                elementByLinkText(elemento);
                break;
            case "elementByPartialLinkText":
                elementByPartialLinkText(elemento);
                break;
            case "elementByTagName":
                elementByTagName(elemento);
                break;
            case "elementByXpath":
                elementByXpath(elemento);
                break;
            case "clickName":
                clickName(elemento);
                break;
            case "clickId":
                clickId(elemento);
                break;
            case "clickClassName":
                clickClassName(elemento);
                break;
            case "clickCssSelector":
                clickCssSelector(elemento);
                break;
            case "clickLinkText":
                clickLinkText(elemento);
                break;
            case "clickPartialLinkText":
                clickPartialLinkText(elemento);
                break;
            case "clickTagName":
                clickTagName(elemento);
                break;
            case "clickXpath":
                clickXpath(elemento);
                break;
            case "clearName":
                clearName(elemento);
                break;
            case "clearId":
                clearId(elemento);
                break;
            case "clearClassName":
                clearClassName(elemento);
                break;
            case "clearCssSelector":
                clearCssSelector(elemento);
                break;
            case "clearLinkText":
                clearLinkText(elemento);
                break;
            case "clearTagName":
                clearTagName(elemento);
                break;
            case "clearXpath":
                clearXpath(elemento);
                break;
            case "submitName":
                submitName(elemento);
                break;
            case "submitId":
                submitId(elemento);
                break;
            case "submitClassName":
                submitClassName(elemento);
                break;
            case "submitCssSelector":
                submitCssSelector(elemento);
                break;
            case "submitLinkText":
                submitLinkText(elemento);
                break;
            case "submitPartialLinkText":
                submitPartialLinkText(elemento);
                break;
            case "submitTagName":
                submitTagName(elemento);
                break;
            case "submitXpath":
                submitXpath(elemento);
                break;
            case "sendKeysName":
                sendKeysName(elemento, text);
                break;
            case "sendKeysId":
                sendKeysId(elemento, text);
                break;
            case "sendKeysClassName":
                sendKeysClassName(elemento, text);
                break;
            case "sendKeysCssSelector":
                sendKeysCssSelector(elemento, text);
                break;
            case "sendKeysLinkText":
                sendKeysLinkText(elemento, text);
                break;
            case "sendKeysPartialLinkText":
                sendKeysPartialLinkText(elemento, text);
                break;
            case "sendKeysTagName":
                sendKeysTagName(elemento, text);
                break;
            case "sendKeysXpath":
                sendKeysXpath(elemento, text);
                break;
            case "getAttributeName":
                getAttributeName(elemento, attrValue);
                break;
            case "getAttributeId":
                getAttributeId(elemento, attrValue);
                break;
            case "getAttributeClassName":
                getAttributeClassName(elemento, attrValue);
                break;
            case "getAttributeCssSelector":
                getAttributeCssSelector(elemento, attrValue);
                break;
            case "getAttributeLinkText":
                getAttributeLinkText(elemento, attrValue);
                break;
            case "getAttributePartialLinkText":
                getAttributePartialLinkText(elemento, attrValue);
                break;
            case "getAttributeTagName":
                getAttributeTagName(elemento, attrValue);
                break;
            case "getAttributeXpath":
                getAttributeXpath(elemento, attrValue);
                break;
            case "getCssValueName":
                getCssValueName(elemento, attrValue);
                break;
            case "getCssValueId":
                getCssValueId(elemento, attrValue);
                break;
            case "getCssValueClassName":
                getCssValueClassName(elemento, attrValue);
                break;
            case "getCssValueCssSelector":
                getCssValueCssSelector(elemento, attrValue);
                break;
            case "getCssValueLinkText":
                getCssValueLinkText(elemento, attrValue);
                break;
            case "getCssValuePartialLinkText":
                getCssValuePartialLinkText(elemento, attrValue);
                break;
            case "getCssValueTagName":
                getCssValueTagName(elemento, attrValue);
                break;
            case "getCssValueXpath":
                getCssValueXpath(elemento, attrValue);
                break;
            case "isDisplayedName":
                isDisplayedName(elemento);
                break;
            case "isDisplayedId":
                isDisplayedId(elemento);
                break;
            case "isDisplayedClassName":
                isDisplayedClassName(elemento);
                break;
            case "isDisplayedCssSelector":
                isDisplayedCssSelector(elemento);
                break;
            case "isDisplayedLinkText":
                isDisplayedLinkText(elemento);
                break;
            case "isDisplayedPartialLinkText":
                isDisplayedPartialLinkText(elemento);
                break;
            case "isDisplayedTagName":
                isDisplayedTagName(elemento);
                break;
            case "isDisplayedXpath":
                isDisplayedXpath(elemento);
                break;
            case "isSelectedName":
                isSelectedName(elemento);
                break;
            case "isSelectedId":
                isSelectedId(elemento);
                break;
            case "isSelectedClassName":
                isSelectedClassName(elemento);
                break;
            case "isSelectedCssSelector":
                isSelectedCssSelector(elemento);
                break;
            case "isSelectedLinkText":
                isSelectedLinkText(elemento);
                break;
            case "isSelectedPartialLinkText":
                isSelectedPartialLinkText(elemento);
                break;
            case "isSelectedTagName":
                isSelectedTagName(elemento);
                break;
            case "isSelectedXpath":
                isSelectedXpath(elemento);
                break;
            case "isEnabledName":
                isEnabledName(elemento);
                break;
            case "isEnabledId":
                isEnabledId(elemento);
                break;
            case "isEnabledClassName":
                isEnabledClassName(elemento);
                break;
            case "isEnabledCssSelector":
                isEnabledCssSelector(elemento);
                break;
            case "isEnabledLinkText":
                isEnabledLinkText(elemento);
                break;
            case "isEnabledPartialLinkText":
                isEnabledPartialLinkText(elemento);
                break;
            case "isEnabledTagName":
                isEnabledTagName(elemento);
                break;
            case "isEnabledXpath":
                isEnabledXpath(elemento);
                break;
            case "getTextName":
                getTextName(elemento);
                break;
            case "getTextId":
                getTextId(elemento);
                break;
            case "getTextClassName":
                getTextClassName(elemento);
                break;
            case "getTextCssSelector":
                getTextCssSelector(elemento);
                break;
            case "getTextLinkText":
                getTextLinkText(elemento);
                break;
            case "getTextPartialLinkText":
                getTextPartialLinkText(elemento);
                break;
            case "getTextTagName":
                getTextTagName(elemento);
                break;
            case "getTextXpath":
                getTextXpath(elemento);
                break;
            case "getTagNameName":
                getTagNameName(elemento);
                break;
            case "getTagNameId":
                getTagNameId(elemento);
                break;
            case "getTagNameClassName":
                getTagNameClassName(elemento);
                break;
            case "getTagNameCssSelector":
                getTagNameCssSelector(elemento);
                break;
            case "getTagNameLinkText":
                getTagNameLinkText(elemento);
                break;
            case "getTagNamePartialLinkText":
                getTagNamePartialLinkText(elemento);
                break;
            case "getTagNameTagName":
                getTagNameTagName(elemento);
                break;
            case "getTagNameXpath":
                getTagNameXpath(elemento);
                break;
            case "getSizeName":
                getSizeName(elemento);
                break;
            case "getSizeId":
                getSizeId(elemento);
                break;
            case "getSizeClassName":
                getSizeClassName(elemento);
                break;
            case "getSizeCssSelector":
                getSizeCssSelector(elemento);
                break;
            case "getSizeLinkText":
                getSizeLinkText(elemento);
                break;
            case "getSizePartialLinkText":
                getSizePartialLinkText(elemento);
                break;
            case "getSizeTagName":
                getSizeTagName(elemento);
                break;
            case "getSizeXpath":
                getSizeXpath(elemento);
                break;
            case "getSizeWidthName":
                getSizeWidthName(elemento);
                break;
            case "getSizeWidthId":
                getSizeWidthId(elemento);
                break;
            case "getSizeWidthClassName":
                getSizeWidthClassName(elemento);
                break;
            case "getSizeWidthCssSelector":
                getSizeWidthCssSelector(elemento);
                break;
            case "getSizeWidthLinkText":
                getSizeWidthLinkText(elemento);
                break;
            case "getSizeWidthPartialLinkText":
                getSizeWidthPartialLinkText(elemento);
                break;
            case "getSizeWidthTagName":
                getSizeWidthTagName(elemento);
                break;
            case "getSizeWidthXpath":
                getSizeWidthXpath(elemento);
                break;
            case "getSizeHeightName":
                getSizeHeightName(elemento);
                break;
            case "getSizeHeightId":
                getSizeHeightId(elemento);
                break;
            case "getSizeHeightClassName":
                getSizeHeightClassName(elemento);
                break;
            case "getSizeHeightCssSelector":
                getSizeHeightCssSelector(elemento);
                break;
            case "getSizeHeightLinkText":
                getSizeHeightLinkText(elemento);
                break;
            case "getSizeHeightPartialLinkText":
                getSizeHeightPartialLinkText(elemento);
                break;
            case "getSizeHeightTagName":
                getSizeHeightTagName(elemento);
                break;
            case "getSizeHeightXpath":
                getSizeHeightXpath(elemento);
                break;
            case "getRectName":
                getRectName(elemento);
                break;
            case "getRectId":
                getRectId(elemento);
                break;
            case "getRectClassName":
                getRectClassName(elemento);
                break;
            case "getRectCssSelector":
                getRectCssSelector(elemento);
                break;
            case "getRectLinkText":
                getRectLinkText(elemento);
                break;
            case "getRectPartialLinkText":
                getRectPartialLinkText(elemento);
                break;
            case "getRectTagName":
                getRectTagName(elemento);
                break;
            case "getRectXpath":
                getRectXpath(elemento);
                break;
            case "getRectWidthName":
                getRectWidthName(elemento);
                break;
            case "getRectWidthId":
                getRectWidthId(elemento);
                break;
            case "getRectWidthClassName":
                getRectWidthClassName(elemento);
                break;
            case "getRectWidthCssSelector":
                getRectWidthCssSelector(elemento);
                break;
            case "getRectWidthLinkText":
                getRectWidthLinkText(elemento);
                break;
            case "getRectWidthPartialLinkText":
                getRectWidthPartialLinkText(elemento);
                break;
            case "getRectWidthTagName":
                getRectWidthTagName(elemento);
                break;
            case "getRectWidthXpath":
                getRectWidthXpath(elemento);
                break;
            case "getRectHeightName":
                getRectHeightName(elemento);
                break;
            case "getRectHeightId":
                getRectHeightId(elemento);
                break;
            case "getRectHeightClassName":
                getRectHeightClassName(elemento);
                break;
            case "getRectHeightCssSelector":
                getRectHeightCssSelector(elemento);
                break;
            case "getRectHeightLinkText":
                getRectHeightLinkText(elemento);
                break;
            case "getRectHeightPartialLinkText":
                getRectHeightPartialLinkText(elemento);
                break;
            case "getRectHeightTagName":
                getRectHeightTagName(elemento);
                break;
            case "getRectHeightXpath":
                getRectHeightXpath(elemento);
                break;
            case "getRectXName":
                getRectXName(elemento);
                break;
            case "getRectXId":
                getRectXId(elemento);
                break;
            case "getRectXClassName":
                getRectXClassName(elemento);
                break;
            case "getRectXCssSelector":
                getRectXCssSelector(elemento);
                break;
            case "getRectXLinkText":
                getRectXLinkText(elemento);
                break;
            case "getRectXPartialLinkText":
                getRectXPartialLinkText(elemento);
                break;
            case "getRectXTagName":
                getRectXTagName(elemento);
                break;
            case "getRectXXpath":
                getRectXXpath(elemento);
                break;
            case "getRectYName":
                getRectYName(elemento);
                break;
            case "getRectYId":
                getRectYId(elemento);
                break;
            case "getRectYClassName":
                getRectYClassName(elemento);
                break;
            case "getRectYCssSelector":
                getRectYCssSelector(elemento);
                break;
            case "getRectYLinkText":
                getRectYLinkText(elemento);
                break;
            case "getRectYPartialLinkText":
                getRectYPartialLinkText(elemento);
                break;
            case "getRectYTagName":
                getRectYTagName(elemento);
                break;
            case "getRectYXpath":
                getRectYXpath(elemento);
                break;
            case "clickElement":
                clickElement(element);
                break;
            case "clearElement":
                clearElement(element);
                break;
            case "submitElement":
                submitElement(element);
                break;
            case "sendKeysElement":
                sendKeysElement(element, text);
                break;
            case "getAttributeElement":
                getAttributeElement(element, attrValue);
                break;
            case "getCssValueElement":
                getCssValueElement(element, attrValue);
                break;
            case "isDisplayedElement":
                isDisplayedElement(element);
                break;
            case "isSelectedElement":
                isSelectedElement(element);
                break;
            case "isEnabledElement":
                isEnabledElement(element);
                break;
            case "getTextElement":
                getTextElement(element);
                break;
            case "getTagNameElement":
                getTagNameElement(element);
                break;
            case "getSizeElement":
                getSizeElement(element);
                break;
            case "getSizeWidthElement":
                getSizeWidthElement(element);
                break;
            case "getSizeHeightElement":
                getSizeHeightElement(element);
                break;
            case "getRectElement":
                getRectElement(element);
                break;
            case "getRectWidthElement":
                getRectWidthElement(element);
                break;
            case "getRectHeightElement":
                getRectHeightElement(element);
                break;
            case "getRectXElement":
                getRectXElement(element);
                break;
            case "getRectYElement":
                getRectYElement(element);
                break;
            case "elementsByName":
                elementsByName(elemento);
                break;
            case "elementsById":
                elementsById(elemento);
                break;
            case "elementsByClassName":
                elementsByClassName(elemento);
                break;
            case "elementsByCssSelector":
                elementsByCssSelector(elemento);
                break;
            case "elementsByLinkText":
                elementsByLinkText(elemento);
                break;
            case "elementsByPartialLinkText":
                elementsByPartialLinkText(elemento);
                break;
            case "elementsByTagName":
                elementsByTagName(elemento);
                break;
            case "elementsByXpath":
                elementsByXpath(elemento);
                break;
            case "clearElementsByName":
                clearElementsByName(elemento);
                break;
            case "clearElementsById":
                clearElementsById(elemento);
                break;
            case "clearElementsByClassName":
                clearElementsByClassName(elemento);
                break;
            case "clearElementsByCssSelector":
                clearElementsByCssSelector(elemento);
                break;
            case "clearElementsByLinkText":
                clearElementsByLinkText(elemento);
                break;
            case "clearElementsByPartialLinkText":
                clearElementsByPartialLinkText(elemento);
                break;
            case "clearElementsByTagName":
                clearElementsByTagName(elemento);
                break;
            case "clearElementsByXpath":
                clearElementsByXpath(elemento);
                break;
            case "sizeElementsByName":
                sizeElementsByName(elemento);
                break;
            case "sizeElementsById":
                sizeElementsById(elemento);
                break;
            case "sizeElementsByClassName":
                sizeElementsByClassName(elemento);
                break;
            case "sizeElementsByCssSelector":
                sizeElementsByCssSelector(elemento);
                break;
            case "sizeElementsByLinkText":
                sizeElementsByLinkText(elemento);
                break;
            case "sizeElementsByPartialLinkText":
                sizeElementsByPartialLinkText(elemento);
                break;
            case "sizeElementsByTagName":
                sizeElementsByTagName(elemento);
                break;
            case "sizeElementsByXpath":
                sizeElementsByXpath(elemento);
                break;
            case "addElementsByName":
                addElementsByName(elemento, element);
                break;
            case "addElementsById":
                addElementsById(elemento, element);
                break;
            case "addElementsByClassName":
                addElementsByClassName(elemento, element);
                break;
            case "addElementsByCssSelector":
                addElementsByCssSelector(elemento, element);
                break;
            case "addElementsByLinkText":
                addElementsByLinkText(elemento, element);
                break;
            case "addElementsByPartialLinkText":
                addElementsByPartialLinkText(elemento, element);
                break;
            case "addElementsByTagName":
                addElementsByTagName(elemento, element);
                break;
            case "addElementsByXpath":
                addElementsByXpath(elemento, element);
                break;
            case "addElementsInByName":
                addElementsInByName(elemento, x, element);
                break;
            case "addElementsInById":
                addElementsInById(elemento, x, element);
                break;
            case "addElementsInByClassName":
                addElementsInByClassName(elemento, x, element);
                break;
            case "addElementsInByCssSelector":
                addElementsInByCssSelector(elemento, x, element);
                break;
            case "addElementsInByLinkText":
                addElementsInByLinkText(elemento, x, element);
                break;
            case "addElementsInByPartialLinkText":
                addElementsInByPartialLinkText(elemento, x, element);
                break;
            case "addElementsInByTagName":
                addElementsInByTagName(elemento, x, element);
                break;
            case "addElementsInByXpath":
                addElementsInByXpath(elemento, x, element);
                break;
            case "containsElementsByName":
                containsElementsByName(elemento, obj);
                break;
            case "containsElementsById":
                containsElementsById(elemento, obj);
                break;
            case "containsElementsByClassName":
                containsElementsByClassName(elemento, obj);
                break;
            case "containsElementsByCssSelector":
                containsElementsByCssSelector(elemento, obj);
                break;
            case "containsElementsByLinkText":
                containsElementsByLinkText(elemento, obj);
                break;
            case "containsElementsByPartialLinkText":
                containsElementsByPartialLinkText(elemento, obj);
                break;
            case "containsElementsByTagName":
                containsElementsByTagName(elemento, obj);
                break;
            case "containsElementsByXpath":
                containsElementsByXpath(elemento, obj);
                break;
            case "isEmptyElementsByName":
                isEmptyElementsByName(elemento);
                break;
            case "isEmptyElementsById":
                isEmptyElementsById(elemento);
                break;
            case "isEmptyElementsByClassName":
                isEmptyElementsByClassName(elemento);
                break;
            case "isEmptyElementsByCssSelector":
                isEmptyElementsByCssSelector(elemento);
                break;
            case "isEmptyElementsByLinkText":
                isEmptyElementsByLinkText(elemento);
                break;
            case "isEmptyElementsByPartialLinkText":
                isEmptyElementsByPartialLinkText(elemento);
                break;
            case "isEmptyElementsByTagName":
                isEmptyElementsByTagName(elemento);
                break;
            case "isEmptyElementsByXpath":
                isEmptyElementsByXpath(elemento);
                break;
            case "equalsElementsByName":
                equalsElementsByName(elemento, obj);
                break;
            case "equalsElementsById":
                equalsElementsById(elemento, obj);
                break;
            case "equalsElementsByClassName":
                equalsElementsByClassName(elemento, obj);
                break;
            case "equalsElementsByCssSelector":
                equalsElementsByCssSelector(elemento, obj);
                break;
            case "equalsElementsByLinkText":
                equalsElementsByLinkText(elemento, obj);
                break;
            case "equalsElementsByPartialLinkText":
                equalsElementsByPartialLinkText(elemento, obj);
                break;
            case "equalsElementsByTagName":
                equalsElementsByTagName(elemento, obj);
                break;
            case "equalsElementsByXpath":
                equalsElementsByXpath(elemento, obj);
                break;
            case "removeElementsByName":
                removeElementsByName(elemento, obj);
                break;
            case "removeElementsById":
                removeElementsById(elemento, obj);
                break;
            case "removeElementsByClassName":
                removeElementsByClassName(elemento, obj);
                break;
            case "removeElementsByCssSelector":
                removeElementsByCssSelector(elemento, obj);
                break;
            case "removeElementsByLinkText":
                removeElementsByLinkText(elemento, obj);
                break;
            case "removeElementsByPartialLinkText":
                removeElementsByPartialLinkText(elemento, obj);
                break;
            case "removeElementsByTagName":
                removeElementsByTagName(elemento, obj);
                break;
            case "removeElementsByXpath":
                removeElementsByXpath(elemento, obj);
                break;
            case "getElementsByName":
                getElementsByName(elemento, x);
                break;
            case "getElementsById":
                getElementsById(elemento, x);
                break;
            case "getElementsByClassName":
                getElementsByClassName(elemento, x);
                break;
            case "getElementsByCssSelector":
                getElementsByCssSelector(elemento, x);
                break;
            case "getElementsByLinkText":
                getElementsByLinkText(elemento, x);
                break;
            case "getElementsByPartialLinkText":
                getElementsByPartialLinkText(elemento, x);
                break;
            case "getElementsByTagName":
                getElementsByTagName(elemento, x);
                break;
            case "getElementsByXpath":
                getElementsByXpath(elemento, x);
                break;
            case "doubleClickName":
                doubleClickName(elemento);
                break;
            case "doubleClickId":
                doubleClickId(elemento);
                break;
            case "doubleClickClassName":
                doubleClickClassName(elemento);
                break;
            case "doubleClickCssSelector":
                doubleClickCssSelector(elemento);
                break;
            case "doubleClickLinkText":
                doubleClickLinkText(elemento);
                break;
            case "doubleClickPartialLinkText":
                doubleClickPartialLinkText(elemento);
                break;
            case "doubleClickTagName":
                doubleClickTagName(elemento);
                break;
            case "doubleClickXpath":
                doubleClickXpath(elemento);
                break;
            case "doubleClickElement":
                doubleClickElement(element);
                break;
            case "moveToElementName":
                moveToElementName(elemento);
                break;
            case "moveToElementId":
                moveToElementId(elemento);
                break;
            case "moveToElementClassName":
                moveToElementClassName(elemento);
                break;
            case "moveToElementCssSelector":
                moveToElementCssSelector(elemento);
                break;
            case "moveToElementLinkText":
                moveToElementLinkText(elemento);
                break;
            case "moveToElementPartialLinkText":
                moveToElementPartialLinkText(elemento);
                break;
            case "moveToElementTagName":
                moveToElementTagName(elemento);
                break;
            case "moveToElementXpath":
                moveToElementXpath(elemento);
                break;
            case "moveToElementElement":
                moveToElementElement(element);
                break;
            case "rightClickName":
                rightClickName(elemento);
                break;
            case "rightClickId":
                rightClickId(elemento);
                break;
            case "rightClickClassName":
                rightClickClassName(elemento);
                break;
            case "rightClickCssSelector":
                rightClickCssSelector(elemento);
                break;
            case "rightClickLinkText":
                rightClickLinkText(elemento);
                break;
            case "rightClickPartialLinkText":
                rightClickPartialLinkText(elemento);
                break;
            case "rightClickTagName":
                rightClickTagName(elemento);
                break;
            case "rightClickXpath":
                rightClickXpath(elemento);
                break;
            case "rightClickElement":
                rightClickElement(element);
                break;
            case "dragAndDropNameName":
                dragAndDropNameName(elemento, elemento2);
                break;
            case "dragAndDropNameId":
                dragAndDropNameId(elemento, elemento2);
                break;
            case "dragAndDropNameClassName":
                dragAndDropNameClassName(elemento, elemento2);
                break;
            case "dragAndDropNameCssSelector":
                dragAndDropNameCssSelector(elemento, elemento2);
                break;
            case "dragAndDropNameLinkText":
                dragAndDropNameLinkText(elemento, elemento2);
                break;
            case "dragAndDropNamePartialLinkText":
                dragAndDropNamePartialLinkText(elemento, elemento2);
                break;
            case "dragAndDropNameTagName":
                dragAndDropNameTagName(elemento, elemento2);
                break;
            case "dragAndDropNameXpath":
                dragAndDropNameXpath(elemento, elemento2);
                break;
            case "dragAndDropNameElement":
                dragAndDropNameElement(elemento, element);
                break;
            case "dragAndDropIdName":
                dragAndDropIdName(elemento, elemento2);
                break;
            case "dragAndDropIdId":
                dragAndDropIdId(elemento, elemento2);
                break;
            case "dragAndDropIdClassName":
                dragAndDropIdClassName(elemento, elemento2);
                break;
            case "dragAndDropIdCssSelector":
                dragAndDropIdCssSelector(elemento, elemento2);
                break;
            case "dragAndDropIdLinkText":
                dragAndDropIdLinkText(elemento, elemento2);
                break;
            case "dragAndDropIdPartialLinkText":
                dragAndDropIdPartialLinkText(elemento, elemento2);
                break;
            case "dragAndDropIdTagName":
                dragAndDropIdTagName(elemento, elemento2);
                break;
            case "dragAndDropIdXpath":
                dragAndDropIdXpath(elemento, elemento2);
                break;
            case "dragAndDropIdElement":
                dragAndDropIdElement(elemento, element);
                break;
            case "dragAndDropClassNameName":
                dragAndDropClassNameName(elemento, elemento2);
                break;
            case "dragAndDropClassNameId":
                dragAndDropClassNameId(elemento, elemento2);
                break;
            case "dragAndDropClassNameClassName":
                dragAndDropClassNameClassName(elemento, elemento2);
                break;
            case "dragAndDropClassNameCssSelector":
                dragAndDropClassNameCssSelector(elemento, elemento2);
                break;
            case "dragAndDropClassNameLinkText":
                dragAndDropClassNameLinkText(elemento, elemento2);
                break;
            case "dragAndDropClassNamePartialLinkText":
                dragAndDropClassNamePartialLinkText(elemento, elemento2);
                break;
            case "dragAndDropClassNameTagName":
                dragAndDropClassNameTagName(elemento, elemento2);
                break;
            case "dragAndDropClassNameXpath":
                dragAndDropClassNameXpath(elemento, elemento2);
                break;
            case "dragAndDropClassNameElement":
                dragAndDropClassNameElement(elemento, element);
                break;
            case "dragAndDropCssSelectorName":
                dragAndDropCssSelectorName(elemento, elemento2);
                break;
            case "dragAndDropCssSelectorId":
                dragAndDropCssSelectorId(elemento, elemento2);
                break;
            case "dragAndDropCssSelectorClassName":
                dragAndDropCssSelectorClassName(elemento, elemento2);
                break;
            case "dragAndDropCssSelectorCssSelector":
                dragAndDropCssSelectorCssSelector(elemento, elemento2);
                break;
            case "dragAndDropCssSelectorLinkText":
                dragAndDropCssSelectorLinkText(elemento, elemento2);
                break;
            case "dragAndDropCssSelectorPartialLinkText":
                dragAndDropCssSelectorPartialLinkText(elemento, elemento2);
                break;
            case "dragAndDropCssSelectorTagName":
                dragAndDropCssSelectorTagName(elemento, elemento2);
                break;
            case "dragAndDropCssSelectorXpath":
                dragAndDropCssSelectorXpath(elemento, elemento2);
                break;
            case "dragAndDropCssSelectorElement":
                dragAndDropCssSelectorElement(elemento, element);
                break;
            case "dragAndDropLinkTextName":
                dragAndDropLinkTextName(elemento, elemento2);
                break;
            case "dragAndDropLinkTextId":
                dragAndDropLinkTextId(elemento, elemento2);
                break;
            case "dragAndDropLinkTextClassName":
                dragAndDropLinkTextClassName(elemento, elemento2);
                break;
            case "dragAndDropLinkTextCssSelector":
                dragAndDropLinkTextCssSelector(elemento, elemento2);
                break;
            case "dragAndDropLinkTextLinkText":
                dragAndDropLinkTextLinkText(elemento, elemento2);
                break;
            case "dragAndDropLinkTextPartialLinkText":
                dragAndDropLinkTextPartialLinkText(elemento, elemento2);
                break;
            case "dragAndDropLinkTextTagName":
                dragAndDropLinkTextTagName(elemento, elemento2);
                break;
            case "dragAndDropLinkTextXpath":
                dragAndDropLinkTextXpath(elemento, elemento2);
                break;
            case "dragAndDropLinkTextElement":
                dragAndDropLinkTextElement(elemento, element);
                break;
            case "dragAndDropPartialLinkTextName":
                dragAndDropPartialLinkTextName(elemento, elemento2);
                break;
            case "dragAndDropPartialLinkTextId":
                dragAndDropPartialLinkTextId(elemento, elemento2);
                break;
            case "dragAndDropPartialLinkTextClassName":
                dragAndDropPartialLinkTextClassName(elemento, elemento2);
                break;
            case "dragAndDropPartialLinkTextCssSelector":
                dragAndDropPartialLinkTextCssSelector(elemento, elemento2);
                break;
            case "dragAndDropPartialLinkTextLinkText":
                dragAndDropPartialLinkTextLinkText(elemento, elemento2);
                break;
            case "dragAndDropPartialLinkTextPartialLinkText":
                dragAndDropPartialLinkTextPartialLinkText(elemento, elemento2);
                break;
            case "dragAndDropPartialLinkTextTagName":
                dragAndDropPartialLinkTextTagName(elemento, elemento2);
                break;
            case "dragAndDropPartialLinkTextXpath":
                dragAndDropPartialLinkTextXpath(elemento, elemento2);
                break;
            case "dragAndDropPartialLinkTextElement":
                dragAndDropPartialLinkTextElement(elemento, element);
                break;
            case "dragAndDropXpathName":
                dragAndDropXpathName(elemento, elemento2);
                break;
            case "dragAndDropXpathId":
                dragAndDropXpathId(elemento, elemento2);
                break;
            case "dragAndDropXpathClassName":
                dragAndDropXpathClassName(elemento, elemento2);
                break;
            case "dragAndDropXpathCssSelector":
                dragAndDropXpathCssSelector(elemento, elemento2);
                break;
            case "dragAndDropXpathLinkText":
                dragAndDropXpathLinkText(elemento, elemento2);
                break;
            case "dragAndDropXpathPartialLinkText":
                dragAndDropXpathPartialLinkText(elemento, elemento2);
                break;
            case "dragAndDropXpathTagName":
                dragAndDropXpathTagName(elemento, elemento2);
                break;
            case "dragAndDropXpathXpath":
                dragAndDropXpathXpath(elemento, elemento2);
                break;
            case "dragAndDropXpathElement":
                dragAndDropXpathElement(elemento, element);
                break;
            case "dragAndDropElementName":
                dragAndDropElementName(element, elemento2);
                break;
            case "dragAndDropElementId":
                dragAndDropElementId(element, elemento2);
                break;
            case "dragAndDropElementClassName":
                dragAndDropElementClassName(element, elemento2);
                break;
            case "dragAndDropElementCssSelector":
                dragAndDropElementCssSelector(element, elemento2);
                break;
            case "dragAndDropElementLinkText":
                dragAndDropElementLinkText(element, elemento2);
                break;
            case "dragAndDropElementPartialLinkText":
                dragAndDropElementPartialLinkText(element, elemento2);
                break;
            case "dragAndDropElementTagName":
                dragAndDropElementTagName(element, elemento2);
                break;
            case "dragAndDropElementXpath":
                dragAndDropElementXpath(element, elemento2);
                break;
            case "dragAndDropElementElement":
                dragAndDropElementElement(element, element2);
                break;
            case "CaptureRegionScreenByName":
                CaptureRegionScreenByName(elemento);
                break;
            case "CaptureRegionScreenById":
                CaptureRegionScreenById(elemento);
                break;
            case "CaptureRegionScreenByClassName":
                CaptureRegionScreenByClassName(elemento);
                break;
            case "CaptureRegionScreenByCssSelecto":
                CaptureRegionScreenByCssSelector(elemento);
                break;
            case "CaptureRegionScreenByLinkText":
                CaptureRegionScreenByLinkText(elemento);
                break;
            case "CaptureRegionScreenByPartialLinkText":
                CaptureRegionScreenByPartialLinkText(elemento);
                break;
            case "CaptureRegionScreenByTagName":
                CaptureRegionScreenByTagName(elemento);
                break;
            case "CaptureRegionScreenByXpath":
                CaptureRegionScreenByXpath(elemento);
                break;
            case "CaptureRegionScreenByElement":
                CaptureRegionScreenElement(element);
                break;
            case "CaptureRegionScreen":
                CaptureFullScreen();
                break;
        }
    }

    /**
     * MÃ©todo que selecciona la funciÃ³n del teclado a ejecutar
     *
     * @param func nombre de la funcion del teclado a realizar
     */
    public void funcionTeclado(String func) {
        switch (func) {
            case "enter":
                enter();
                break;
            case "escape":
                escape();
                break;
            case "tab":
                tab();
                break;
            case "backSpace":
                backSpace();
                break;
            case "home":
                home();
                break;
            case "end":
                end();
                break;
            case "delete":
                delete();
                break;
            case "copy":
                copy();
                break;
            case "cut":
                cut();
                break;
            case "paste":
                paste();
                break;
            case "selectAllA":
                selectAllA();
                break;
            case "selectAllE":
                selectAllE();
                break;
            case "findF":
                findF();
                break;
            case "findB":
                findB();
                break;
            case "closeTab":
                closeTab();
                break;
            case "next":
                next();
                break;
            case "back":
                back();
                break;
            case "closeAll":
                closeAll();
                break;
        }
    }

    /**
     * MÃ©todo para realizar la busqueda del elemento por Name
     *
     * @param elemento el valor del objeto que se desea buscar
     * @return el WebElement encontrado
     */
    public WebElement elementByName(String elemento) {
        try {
            return driver.findElement(By.name(elemento));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2001): No Fue Posible Encontrar El Elemento [" + elemento + "]::[elementByName]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar la busqueda del elemento por ID
     *
     * @param elemento el valor del objeto que se desea buscar
     * @return el WebElement encontrado
     */
    public WebElement elementById(String elemento) {
        try {
            return driver.findElement(By.id(elemento));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2002): No Fue Posible Encontrar El Elemento [" + elemento + "]::[elementById]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar la busqueda del elemento por ClassName
     *
     * @param elemento el valor del objeto que se desea buscar
     * @return el WebElement encontrado
     */
    public WebElement elementByClassName(String elemento) {
        try {
            return driver.findElement(By.className(elemento));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2003): No Fue Posible Encontrar El Elemento [" + elemento + "]::[elementByClassName]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar la busqueda del elemento por CssSelector
     *
     * @param elemento el valor del objeto que se desea buscar
     * @return el WebElement encontrado
     */
    public WebElement elementByCssSelector(String elemento) {
        try {
            return driver.findElement(By.cssSelector(elemento));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2004): No Fue Posible Encontrar El Elemento [" + elemento + "]::[elementByCssSelector]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar la busqueda del elemento por LinkText
     *
     * @param elemento el valor del objeto que se desea buscar
     * @return el WebElement encontrado
     */
    public WebElement elementByLinkText(String elemento) {
        try {
            return driver.findElement(By.linkText(elemento));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2005): No Fue Posible Encontrar El Elemento [" + elemento + "]::[elementByLinkText]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar la busqueda del elemento por PartialLinkText
     *
     * @param elemento el valor del objeto que se desea buscar
     * @return el WebElement encontrado
     */
    public WebElement elementByPartialLinkText(String elemento) {
        try {
            return driver.findElement(By.partialLinkText(elemento));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2006): No Fue Posible Encontrar El Elemento [" + elemento + "]::[elementByPartialLinkText]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar la busqueda del elemento por TagName
     *
     * @param elemento el valor del objeto que se desea buscar
     * @return el WebElement encontrado
     */
    public WebElement elementByTagName(String elemento) {
        try {
            return driver.findElement(By.tagName(elemento));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2007): No Fue Posible Encontrar El Elemento [" + elemento + "]::[elementByTagName]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar la busqueda del elemento por Xpath
     *
     * @param elemento el valor del objeto que se desea buscar
     * @return el WebElement encontrado
     */
    public WebElement elementByXpath(String elemento) {
        try {
            return driver.findElement(By.xpath(elemento));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2008): No Fue Posible Encontrar El Elemento [" + elemento + "]::[elementByXpath]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar click al elemento buscandolo por Name
     *
     * @param elemento el valor del objeto que se desea realizar click
     */
    public void clickName(String elemento) {
        try {
            driver.findElement(By.name(elemento)).click();
        } catch (Exception e) {
            //
            System.out.println("Error DESKTOP(2009): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[clickName]");
        }
    }

    /**
     * MÃ©todo para realizar click al elemento buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea realizar click
     */
    public void clickId(String elemento) {
        try {
            driver.findElement(By.id(elemento)).click();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2010): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[clickId]");
        }
    }

    /**
     * MÃ©todo para realizar click al elemento buscandolo por ClassName
     *
     * @param elemento el valor del objeto que se desea realizar click
     */
    public void clickClassName(String elemento) {
        try {
            driver.findElement(By.className(elemento)).click();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2011): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[clickClassName]" + e.getMessage());
        }
    }

    /**
     * MÃ©todo para realizar click al elemento buscandolo por CssSelector
     *
     * @param elemento el valor del objeto que se desea realizar click
     */
    public void clickCssSelector(String elemento) {
        try {
            driver.findElement(By.cssSelector(elemento)).click();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2012): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[clickCssSelector]");
        }
    }

    /**
     * MÃ©todo para realizar click al elemento buscandolo por LinkText
     *
     * @param elemento el valor del objeto que se desea realizar click
     */
    public void clickLinkText(String elemento) {
        try {
            driver.findElement(By.linkText(elemento)).click();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2013): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[clickLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar click al elemento buscandolo por PartialLinkText
     *
     * @param elemento el valor del objeto que se desea realizar click
     */
    public void clickPartialLinkText(String elemento) {
        try {
            driver.findElement(By.partialLinkText(elemento)).click();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2014): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[clickPartialLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar click al elemento buscandolo por TagName
     *
     * @param elemento el valor del objeto que se desea realizar click
     */
    public void clickTagName(String elemento) {
        try {
            driver.findElement(By.tagName(elemento)).click();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2015): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[clickTagName]");
        }
    }

    /**
     * MÃ©todo para realizar click al elemento buscandolo por Xpath
     *
     * @param elemento el valor del objeto que se desea realizar click
     */
    public void clickXpath(String elemento) {
        try {
            driver.findElement(By.xpath(elemento)).click();
        } catch (Exception e) {
            //
            System.out.println("Error DESKTOP(2016): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[clickXpath]");
        }
    }

    /**
     * MÃ©todo para realizar clear al elemento buscandolo por Name
     *
     * @param elemento el valor del objeto que se desea realizar clear
     */
    public void clearName(String elemento) {
        try {
            driver.findElement(By.name(elemento)).clear();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2017): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[clearName]");
        }
    }

    /**
     * MÃ©todo para realizar clear al elemento buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea realizar clear
     */
    public void clearId(String elemento) {
        try {
            driver.findElement(By.id(elemento)).clear();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2018): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[clearId]");
        }
    }

    /**
     * MÃ©todo para realizar clear al elemento buscandolo por ClassName
     *
     * @param elemento el valor del objeto que se desea realizar clear
     */
    public void clearClassName(String elemento) {
        try {
            driver.findElement(By.className(elemento)).clear();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2019): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[clearClassName]");
        }
    }

    /**
     * MÃ©todo para realizar clear al elemento buscandolo por CssSelector
     *
     * @param elemento el valor del objeto que se desea realizar clear
     */
    public void clearCssSelector(String elemento) {
        try {
            driver.findElement(By.cssSelector(elemento)).clear();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2020): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[clearCssSelector]");
        }
    }

    /**
     * MÃ©todo para realizar clear al elemento buscandolo por LinkText
     *
     * @param elemento el valor del objeto que se desea realizar clear
     */
    public void clearLinkText(String elemento) {
        try {
            driver.findElement(By.linkText(elemento)).clear();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2021): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[clearLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar clear al elemento buscandolo por PartialLinkText
     *
     * @param elemento el valor del objeto que se desea realizar clear
     */
    public void clearPartialLinkText(String elemento) {
        try {
            driver.findElement(By.partialLinkText(elemento)).clear();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2022): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[clearPartialLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar clear al elemento buscandolo por TagName
     *
     * @param elemento el valor del objeto que se desea realizar clear
     */
    public void clearTagName(String elemento) {
        try {
            driver.findElement(By.tagName(elemento)).clear();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2023): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[clearTagName]");
        }
    }

    /**
     * MÃ©todo para realizar clear al elemento buscandolo por Xpath
     *
     * @param elemento el valor del objeto que se desea realizar clear
     */
    public void clearXpath(String elemento) {
        try {
            driver.findElement(By.xpath(elemento)).clear();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2024): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[clearXpath]");
        }
    }

    /**
     * MÃ©todo para realizar submit al elemento buscandolo por Name
     *
     * @param elemento el valor del objeto que se desea realizar submit
     */
    public void submitName(String elemento) {
        try {
            driver.findElement(By.name(elemento)).submit();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2025): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[submitName]");
        }
    }

    /**
     * MÃ©todo para realizar submit al elemento buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea realizar submit
     */
    public void submitId(String elemento) {
        try {
            driver.findElement(By.id(elemento)).submit();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2026): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[submitId]");
        }
    }

    /**
     * MÃ©todo para realizar submit al elemento buscandolo por ClassName
     *
     * @param elemento el valor del objeto que se desea realizar submit
     */
    public void submitClassName(String elemento) {
        try {
            driver.findElement(By.className(elemento)).submit();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2027): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[submitClassName]");
        }
    }

    /**
     * MÃ©todo para realizar submit al elemento buscandolo por CssSelector
     *
     * @param elemento el valor del objeto que se desea realizar submit
     */
    public void submitCssSelector(String elemento) {
        try {
            driver.findElement(By.cssSelector(elemento)).submit();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2028): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[submitCssSelector]");
        }
    }

    /**
     * MÃ©todo para realizar submit al elemento buscandolo por LinkText
     *
     * @param elemento el valor del objeto que se desea realizar submit
     */
    public void submitLinkText(String elemento) {
        try {
            driver.findElement(By.linkText(elemento)).submit();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2029): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[submitLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar submit al elemento buscandolo por PartialLinkText
     *
     * @param elemento el valor del objeto que se desea realizar submit
     */
    public void submitPartialLinkText(String elemento) {
        try {
            driver.findElement(By.partialLinkText(elemento)).submit();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2030): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[submitPartialLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar submit al elemento buscandolo por TagName
     *
     * @param elemento el valor del objeto que se desea realizar submit
     */
    public void submitTagName(String elemento) {
        try {
            driver.findElement(By.tagName(elemento)).submit();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2031): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[submitTagName]");
        }
    }

    /**
     * MÃ©todo para realizar submit al elemento buscandolo por Xpath
     *
     * @param elemento el valor del objeto que se desea realizar submit
     */
    public void submitXpath(String elemento) {
        try {
            driver.findElement(By.xpath(elemento)).submit();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2032): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[submitXpath]");
        }
    }

    /**
     * MÃ©todo para realizar sendKeys al elemento buscandolo por Name
     *
     * @param elemento el valor del objeto que se desea realizar sendKeys
     * @param texto valor a escribir en el objeto seleccionado
     */
    public void sendKeysName(String elemento, String texto) {
        try {
            driver.findElement(By.name(elemento)).sendKeys(texto);
        } catch (Exception e) {
            //
            System.out.println("Error DESKTOP(2033): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[sendKeysName]");
        }
    }

    /**
     * MÃ©todo para realizar sendKeys al elemento buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea realizar sendKeys
     * @param texto valor a escribir en el objeto seleccionado
     */
    public void sendKeysId(String elemento, String texto) {
        try {
            driver.findElement(By.id(elemento)).sendKeys(texto);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2034): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[sendKeysId]");
        }
    }

    /**
     * MÃ©todo para realizar sendKeys al elemento buscandolo por ClassName
     *
     * @param elemento el valor del objeto que se desea realizar sendKeys
     * @param texto valor a escribir en el objeto seleccionado
     */
    public void sendKeysClassName(String elemento, String texto) {
        try {
            driver.findElement(By.className(elemento)).sendKeys(texto);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2035): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[sendKeysClassName]");
        }
    }

    /**
     * MÃ©todo para realizar sendKeys al elemento buscandolo por CssSelector
     *
     * @param elemento el valor del objeto que se desea realizar sendKeys
     * @param texto valor a escribir en el objeto seleccionado
     */
    public void sendKeysCssSelector(String elemento, String texto) {
        try {
            driver.findElement(By.cssSelector(elemento)).sendKeys(texto);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2036): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[sendKeysCssSelector]");
        }
    }

    /**
     * MÃ©todo para realizar sendKeys al elemento buscandolo por LinkText
     *
     * @param elemento el valor del objeto que se desea realizar sendKeys
     * @param texto valor a escribir en el objeto seleccionado
     */
    public void sendKeysLinkText(String elemento, String texto) {
        try {
            driver.findElement(By.linkText(elemento)).sendKeys(texto);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2037): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[sendKeysLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar sendKeys al elemento buscandolo por PartialLinkText
     *
     * @param elemento el valor del objeto que se desea realizar sendKeys
     * @param texto valor a escribir en el objeto seleccionado
     */
    public void sendKeysPartialLinkText(String elemento, String texto) {
        try {
            driver.findElement(By.partialLinkText(elemento)).sendKeys(texto);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2038): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[sendKeysPartialLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar sendKeys al elemento buscandolo por TagName
     *
     * @param elemento el valor del objeto que se desea realizar sendKeys
     * @param texto valor a escribir en el objeto seleccionado
     */
    public void sendKeysTagName(String elemento, String texto) {
        try {
            driver.findElement(By.tagName(elemento)).sendKeys(texto);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2039): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[sendKeysTagName]");
        }
    }

    /**
     * MÃ©todo para realizar sendKeys al elemento buscandolo por Xpath
     *
     * @param elemento el valor del objeto que se desea realizar sendKeys
     * @param texto valor a escribir en el objeto seleccionado
     */
    public void sendKeysXpath(String elemento, String texto) {
        try {
            driver.findElement(By.xpath(elemento)).sendKeys(texto);
        } catch (Exception e) {
            //
            System.out.println("Error DESKTOP(2040): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[sendKeysXpath]");
        }
    }

    /**
     * MÃ©todo para realizar getAttribute al elemento buscandolo por Name
     *
     * @param elemento el valor del objeto que se desea realizar getAttribute
     * @param atributo que se desea obtener del elemento seleccionado
     * @return valor del atributo buscado
     */
    public String getAttributeName(String elemento, String atributo) {
        try {
            return driver.findElement(By.name(elemento)).getAttribute(atributo);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2041): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getAttributeName]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getAttribute al elemento buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea realizar getAttribute
     * @param atributo que se desea obtener del elemento seleccionado
     * @return valor del atributo buscado
     */
    public String getAttributeId(String elemento, String atributo) {
        try {
            return driver.findElement(By.id(elemento)).getAttribute(atributo);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2042): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getAttributeId]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getAttribute al elemento buscandolo por ClassName
     *
     * @param elemento el valor del objeto que se desea realizar getAttribute
     * @param atributo que se desea obtener del elemento seleccionado
     * @return valor del atributo buscado
     */
    public String getAttributeClassName(String elemento, String atributo) {
        try {
            return driver.findElement(By.className(elemento)).getAttribute(atributo);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2043): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getAttributeClassName]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getAttribute al elemento buscandolo por CssSelector
     *
     * @param elemento el valor del objeto que se desea realizar getAttribute
     * @param atributo que se desea obtener del elemento seleccionado
     * @return valor del atributo buscado
     */
    public String getAttributeCssSelector(String elemento, String atributo) {
        try {
            return driver.findElement(By.cssSelector(elemento)).getAttribute(atributo);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2044): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getAttributeCssSelector]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getAttribute al elemento buscandolo por LinkText
     *
     * @param elemento el valor del objeto que se desea realizar getAttribute
     * @param atributo que se desea obtener del elemento seleccionado
     * @return valor del atributo buscado
     */
    public String getAttributeLinkText(String elemento, String atributo) {
        try {
            return driver.findElement(By.linkText(elemento)).getAttribute(atributo);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2045): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getAttributeLinkText]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getAttribute al elemento buscandolo por
     * PartialLinkText
     *
     * @param elemento el valor del objeto que se desea realizar getAttribute
     * @param atributo que se desea obtener del elemento seleccionado
     * @return valor del atributo buscado
     */
    public String getAttributePartialLinkText(String elemento, String atributo) {
        try {
            return driver.findElement(By.partialLinkText(elemento)).getAttribute(atributo);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2046): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getAttributePartialLinkText]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getAttribute al elemento buscandolo por TagName
     *
     * @param elemento el valor del objeto que se desea realizar getAttribute
     * @param atributo que se desea obtener del elemento seleccionado
     * @return valor del atributo buscado
     */
    public String getAttributeTagName(String elemento, String atributo) {
        try {
            return driver.findElement(By.tagName(elemento)).getAttribute(atributo);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2047): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getAttributeTagName]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getAttribute al elemento buscandolo por Xpath
     *
     * @param elemento el valor del objeto que se desea realizar getAttribute
     * @param atributo que se desea obtener del elemento seleccionado
     * @return valor del atributo buscado
     */
    public String getAttributeXpath(String elemento, String atributo) {
        try {
            return driver.findElement(By.xpath(elemento)).getAttribute(atributo);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2048): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getAttributeXpath]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getCssValue al elemento buscandolo por Name
     *
     * @param elemento el valor del objeto que se desea realizar getCssValue
     * @param value que se desea obtener del elemento seleccionado
     * @return valor del atributo buscado
     */
    public String getCssValueName(String elemento, String value) {
        try {
            return driver.findElement(By.name(elemento)).getCssValue(value);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2049): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getCssValueName]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getCssValue al elemento buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea realizar getCssValue
     * @param value que se desea obtener del elemento seleccionado
     * @return valor del atributo buscado
     */
    public String getCssValueId(String elemento, String value) {
        try {
            return driver.findElement(By.id(elemento)).getCssValue(value);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2050): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getCssValueId]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getCssValue al elemento buscandolo por ClassName
     *
     * @param elemento el valor del objeto que se desea realizar getCssValue
     * @param value que se desea obtener del elemento seleccionado
     * @return valor del atributo buscado
     */
    public String getCssValueClassName(String elemento, String value) {
        try {
            return driver.findElement(By.className(elemento)).getCssValue(value);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2051): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getCssValueClassName]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getCssValue al elemento buscandolo por CssSelector
     *
     * @param elemento el valor del objeto que se desea realizar getCssValue
     * @param value que se desea obtener del elemento seleccionado
     * @return valor del atributo buscado
     */
    public String getCssValueCssSelector(String elemento, String value) {
        try {
            return driver.findElement(By.cssSelector(elemento)).getCssValue(value);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2052): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getCssValueCssSelector]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getCssValue al elemento buscandolo por LinkText
     *
     * @param elemento el valor del objeto que se desea realizar getCssValue
     * @param value que se desea obtener del elemento seleccionado
     * @return valor del atributo buscado
     */
    public String getCssValueLinkText(String elemento, String value) {
        try {
            return driver.findElement(By.linkText(elemento)).getCssValue(value);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2053): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getCssValueLinkText]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getCssValue al elemento buscandolo por
     * PartialLinkText
     *
     * @param elemento el valor del objeto que se desea realizar getCssValue
     * @param value que se desea obtener del elemento seleccionado
     * @return valor del atributo buscado
     */
    public String getCssValuePartialLinkText(String elemento, String value) {
        try {
            return driver.findElement(By.partialLinkText(elemento)).getCssValue(value);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2054): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getCssValuePartialLinkText]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getCssValue al elemento buscandolo por TagName
     *
     * @param elemento el valor del objeto que se desea realizar getCssValue
     * @param value que se desea obtener del elemento seleccionado
     * @return valor del atributo buscado
     */
    public String getCssValueTagName(String elemento, String value) {
        try {
            return driver.findElement(By.tagName(elemento)).getCssValue(value);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2055): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getCssValueTagName]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getCssValue al elemento buscandolo por Xpath
     *
     * @param elemento el valor del objeto que se desea realizar getCssValue
     * @param value que se desea obtener del elemento seleccionado
     * @return valor del atributo buscado
     */
    public String getCssValueXpath(String elemento, String value) {
        try {
            return driver.findElement(By.xpath(elemento)).getCssValue(value);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2056): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getCssValueXpath]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar isDisplayed al elemento buscandolo por Name
     *
     * @param elemento el valor del objeto que se desea realizar isDisplayed
     * @return un valor booleano si el elemento se encuentra display
     */
    public boolean isDisplayedName(String elemento) {
        try {
            return driver.findElement(By.name(elemento)).isDisplayed();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2057): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isDisplayedName]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar isDisplayed al elemento buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea realizar isDisplayed
     * @return un valor booleano si el elemento se encuentra display
     */
    public boolean isDisplayedId(String elemento) {
        try {
            return driver.findElement(By.id(elemento)).isDisplayed();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2058): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isDisplayedId]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar isDisplayed al elemento buscandolo por ClassName
     *
     * @param elemento el valor del objeto que se desea realizar isDisplayed
     * @return un valor booleano si el elemento se encuentra display
     */
    public boolean isDisplayedClassName(String elemento) {
        try {
            return driver.findElement(By.className(elemento)).isDisplayed();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2059): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isDisplayedClassName]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar isDisplayed al elemento buscandolo por CssSelector
     *
     * @param elemento el valor del objeto que se desea realizar isDisplayed
     * @return un valor booleano si el elemento se encuentra display
     */
    public boolean isDisplayedCssSelector(String elemento) {
        try {
            return driver.findElement(By.cssSelector(elemento)).isDisplayed();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2060): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isDisplayedCssSelector]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar isDisplayed al elemento buscandolo por LinkText
     *
     * @param elemento el valor del objeto que se desea realizar isDisplayed
     * @return un valor booleano si el elemento se encuentra display
     */
    public boolean isDisplayedLinkText(String elemento) {
        try {
            return driver.findElement(By.linkText(elemento)).isDisplayed();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2061): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isDisplayedLinkText]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar isDisplayed al elemento buscandolo por
     * PartialLinkText
     *
     * @param elemento el valor del objeto que se desea realizar isDisplayed
     * @return un valor booleano si el elemento se encuentra display
     */
    public boolean isDisplayedPartialLinkText(String elemento) {
        try {
            return driver.findElement(By.partialLinkText(elemento)).isDisplayed();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2062): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isDisplayedPartialLinkText]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar isDisplayed al elemento buscandolo por TagName
     *
     * @param elemento el valor del objeto que se desea realizar isDisplayed
     * @return un valor booleano si el elemento se encuentra display
     */
    public boolean isDisplayedTagName(String elemento) {
        try {
            return driver.findElement(By.tagName(elemento)).isDisplayed();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2063): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isDisplayedTagName]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar isDisplayed al elemento buscandolo por Xpath
     *
     * @param elemento el valor del objeto que se desea realizar isDisplayed
     * @return un valor booleano si el elemento se encuentra display
     */
    public boolean isDisplayedXpath(String elemento) {
        try {
            return driver.findElement(By.xpath(elemento)).isDisplayed();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2064): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isDisplayedXpath]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar isSelected al elemento buscandolo por Name
     *
     * @param elemento el valor del objeto que se desea realizar isSelected
     * @return un valor booleano si el elemento se encuentra select
     */
    public boolean isSelectedName(String elemento) {
        try {
            return driver.findElement(By.name(elemento)).isSelected();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2065): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isSelectedName]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar isSelected al elemento buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea realizar isSelected
     * @return un valor booleano si el elemento se encuentra select
     */
    public boolean isSelectedId(String elemento) {
        try {
            return driver.findElement(By.id(elemento)).isSelected();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2066): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isSelectedId]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar isSelected al elemento buscandolo por ClassName
     *
     * @param elemento el valor del objeto que se desea realizar isSelected
     * @return un valor booleano si el elemento se encuentra select
     */
    public boolean isSelectedClassName(String elemento) {
        try {
            return driver.findElement(By.className(elemento)).isSelected();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2067): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isSelectedClassName]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar isSelected al elemento buscandolo por CssSelector
     *
     * @param elemento el valor del objeto que se desea realizar isSelected
     * @return un valor booleano si el elemento se encuentra select
     */
    public boolean isSelectedCssSelector(String elemento) {
        try {
            return driver.findElement(By.cssSelector(elemento)).isSelected();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2068): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isSelectedCssSelector]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar isSelected al elemento buscandolo por LinkText
     *
     * @param elemento el valor del objeto que se desea realizar isSelected
     * @return un valor booleano si el elemento se encuentra select
     */
    public boolean isSelectedLinkText(String elemento) {
        try {
            return driver.findElement(By.linkText(elemento)).isSelected();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2069): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isSelectedLinkText]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar isSelected al elemento buscandolo por
     * PartialLinkText
     *
     * @param elemento el valor del objeto que se desea realizar isSelected
     * @return un valor booleano si el elemento se encuentra select
     */
    public boolean isSelectedPartialLinkText(String elemento) {
        try {
            return driver.findElement(By.partialLinkText(elemento)).isSelected();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2070): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isSelectedPartialLinkText]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar isSelected al elemento buscandolo por TagName
     *
     * @param elemento el valor del objeto que se desea realizar isSelected
     * @return un valor booleano si el elemento se encuentra select
     */
    public boolean isSelectedTagName(String elemento) {
        try {
            return driver.findElement(By.tagName(elemento)).isSelected();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2071): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isSelectedTagName]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar isSelected al elemento buscandolo por Xpath
     *
     * @param elemento el valor del objeto que se desea realizar isSelected
     * @return un valor booleano si el elemento se encuentra select
     */
    public boolean isSelectedXpath(String elemento) {
        try {
            return driver.findElement(By.xpath(elemento)).isSelected();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2072): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isSelectedXpath]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar isEnabled al elemento buscandolo por Name
     *
     * @param elemento el valor del objeto que se desea realizar isEnabled
     * @return un valor booleano si el elemento se encuentra enable
     */
    public boolean isEnabledName(String elemento) {
        try {
            return driver.findElement(By.name(elemento)).isEnabled();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2073): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isEnabledName]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar isEnabled al elemento buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea realizar isEnabled
     * @return un valor booleano si el elemento se encuentra enable
     */
    public boolean isEnabledId(String elemento) {
        try {
            return driver.findElement(By.id(elemento)).isEnabled();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2074): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isEnabledId]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar isEnabled al elemento buscandolo por ClassName
     *
     * @param elemento el valor del objeto que se desea realizar isEnabled
     * @return un valor booleano si el elemento se encuentra enable
     */
    public boolean isEnabledClassName(String elemento) {
        try {
            return driver.findElement(By.className(elemento)).isEnabled();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2075): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isEnabledClassName]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar isEnabled al elemento buscandolo por CssSelector
     *
     * @param elemento el valor del objeto que se desea realizar isEnabled
     * @return un valor booleano si el elemento se encuentra enable
     */
    public boolean isEnabledCssSelector(String elemento) {
        try {
            return driver.findElement(By.cssSelector(elemento)).isEnabled();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2076): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isEnabledCssSelector]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar isEnabled al elemento buscandolo por LinkText
     *
     * @param elemento el valor del objeto que se desea realizar isEnabled
     * @return un valor booleano si el elemento se encuentra enable
     */
    public boolean isEnabledLinkText(String elemento) {
        try {
            return driver.findElement(By.linkText(elemento)).isEnabled();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2077): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isEnabledLinkText]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar isEnabled al elemento buscandolo por
     * PartialLinkText
     *
     * @param elemento el valor del objeto que se desea realizar isEnabled
     * @return un valor booleano si el elemento se encuentra enable
     */
    public boolean isEnabledPartialLinkText(String elemento) {
        try {
            return driver.findElement(By.partialLinkText(elemento)).isEnabled();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2078): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isEnabledPartialLinkText]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar isEnabled al elemento buscandolo por TagName
     *
     * @param elemento el valor del objeto que se desea realizar isEnabled
     * @return un valor booleano si el elemento se encuentra enable
     */
    public boolean isEnabledTagName(String elemento) {
        try {
            return driver.findElement(By.tagName(elemento)).isEnabled();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2079): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isEnabledTagName]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar isEnabled al elemento buscandolo por Xpath
     *
     * @param elemento el valor del objeto que se desea realizar isEnabled
     * @return un valor booleano si el elemento se encuentra enable
     */
    public boolean isEnabledXpath(String elemento) {
        try {
            return driver.findElement(By.xpath(elemento)).isEnabled();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2080): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isEnabledXpath]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar getText al elemento buscandolo por Name
     *
     * @param elemento el valor del objeto que se desea realizar getText
     * @return el texto que contiene el elemento seleccionado
     */
    public String getTextName(String elemento) {
        try {
            return driver.findElement(By.name(elemento)).getText();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2081): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getTextName]");
        }
        return "";
    }

    /**
     * MÃ©todo para realizar getText al elemento buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea realizar getText
     * @return el texto que contiene el elemento seleccionado
     */
    public String getTextId(String elemento) {
        try {
            return driver.findElement(By.id(elemento)).getText();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2082): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getTextId]");
        }
        return "";
    }

    /**
     * MÃ©todo para realizar getText al elemento buscandolo por ClassName
     *
     * @param elemento el valor del objeto que se desea realizar getText
     * @return el texto que contiene el elemento seleccionado
     */
    public String getTextClassName(String elemento) {
        try {
            return driver.findElement(By.className(elemento)).getText();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2083): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getTextClassName]");
        }
        return "";
    }

    /**
     * MÃ©todo para realizar getText al elemento buscandolo por CssSelector
     *
     * @param elemento el valor del objeto que se desea realizar getText
     * @return el texto que contiene el elemento seleccionado
     */
    public String getTextCssSelector(String elemento) {
        try {
            return driver.findElement(By.cssSelector(elemento)).getText();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2084): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getTextCssSelector]");
        }
        return "";
    }

    /**
     * MÃ©todo para realizar getText al elemento buscandolo por LinkText
     *
     * @param elemento el valor del objeto que se desea realizar getText
     * @return el texto que contiene el elemento seleccionado
     */
    public String getTextLinkText(String elemento) {
        try {
            return driver.findElement(By.linkText(elemento)).getText();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2085): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getTextLinkText]");
        }
        return "";
    }

    /**
     * MÃ©todo para realizar getText al elemento buscandolo por PartialLinkText
     *
     * @param elemento el valor del objeto que se desea realizar getText
     * @return el texto que contiene el elemento seleccionado
     */
    public String getTextPartialLinkText(String elemento) {
        try {
            return driver.findElement(By.partialLinkText(elemento)).getText();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2086): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getTextPartialLinkText]");
        }
        return "";
    }

    /**
     * MÃ©todo para realizar getText al elemento buscandolo por TagName
     *
     * @param elemento el valor del objeto que se desea realizar getText
     * @return el texto que contiene el elemento seleccionado
     */
    public String getTextTagName(String elemento) {
        try {
            return driver.findElement(By.tagName(elemento)).getText();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2087): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getTextTagName]");
        }
        return "";
    }

    /**
     * MÃ©todo para realizar getText al elemento buscandolo por Xpath
     *
     * @param elemento el valor del objeto que se desea realizar getText
     * @return el texto que contiene el elemento seleccionado
     */
    public String getTextXpath(String elemento) {
        try {
            return driver.findElement(By.xpath(elemento)).getText();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2088): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getTextXpath]");
        }
        return "";
    }

    /**
     * MÃ©todo para realizar getTagName al elemento buscandolo por Name
     *
     * @param elemento el valor del objeto que se desea realizar getTagName
     * @return el tagName del elemento seleccionado
     */
    public String getTagNameName(String elemento) {
        try {
            return driver.findElement(By.name(elemento)).getTagName();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2089): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getTagNameName]");
        }
        return "";
    }

    /**
     * MÃ©todo para realizar getTagName al elemento buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea realizar getTagName
     * @return el tagName del elemento seleccionado
     */
    public String getTagNameId(String elemento) {
        try {
            return driver.findElement(By.id(elemento)).getTagName();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2090): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getTagNameId]");
        }
        return "";
    }

    /**
     * MÃ©todo para realizar getTagName al elemento buscandolo por ClassName
     *
     * @param elemento el valor del objeto que se desea realizar getTagName
     * @return el tagName del elemento seleccionado
     */
    public String getTagNameClassName(String elemento) {
        try {
            return driver.findElement(By.className(elemento)).getTagName();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2091): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getTagNameClassName]");
        }
        return "";
    }

    /**
     * MÃ©todo para realizar getTagName al elemento buscandolo por CssSelector
     *
     * @param elemento el valor del objeto que se desea realizar getTagName
     * @return el tagName del elemento seleccionado
     */
    public String getTagNameCssSelector(String elemento) {
        try {
            return driver.findElement(By.cssSelector(elemento)).getTagName();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2092): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getTagNameCssSelector]");
        }
        return "";
    }

    /**
     * MÃ©todo para realizar getTagName al elemento buscandolo por LinkText
     *
     * @param elemento el valor del objeto que se desea realizar getTagName
     * @return el tagName del elemento seleccionado
     */
    public String getTagNameLinkText(String elemento) {
        try {
            return driver.findElement(By.linkText(elemento)).getTagName();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2093): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getTagNameLinkText]");
        }
        return "";
    }

    /**
     * MÃ©todo para realizar getTagName al elemento buscandolo por
     * PartialLinkText
     *
     * @param elemento el valor del objeto que se desea realizar getTagName
     * @return el tagName del elemento seleccionado
     */
    public String getTagNamePartialLinkText(String elemento) {
        try {
            return driver.findElement(By.partialLinkText(elemento)).getTagName();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2094): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getTagNamePartialLinkText]");
        }
        return "";
    }

    /**
     * MÃ©todo para realizar getTagName al elemento buscandolo por TagName
     *
     * @param elemento el valor del objeto que se desea realizar getTagName
     * @return el tagName del elemento seleccionado
     */
    public String getTagNameTagName(String elemento) {
        try {
            return driver.findElement(By.tagName(elemento)).getTagName();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2095): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getTagNameTagName]");
        }
        return "";
    }

    /**
     * MÃ©todo para realizar getTagName al elemento buscandolo por Xpath
     *
     * @param elemento el valor del objeto que se desea realizar getTagName
     * @return el tagName del elemento seleccionado
     */
    public String getTagNameXpath(String elemento) {
        try {
            return driver.findElement(By.xpath(elemento)).getTagName();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2096): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getTagNameXpath]");
        }
        return "";
    }

    /**
     * MÃ©todo para realizar getSize al elemento buscandolo por Name
     *
     * @param elemento el valor del objeto que se desea realizar getSize
     * @return el valor del Size del elemento seleccionado
     */
    public Dimension getSizeName(String elemento) {
        try {
            return driver.findElement(By.name(elemento)).getSize();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2097): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getSizeName]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getSize al elemento buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea realizar getSize
     * @return el valor del Size del elemento seleccionado
     */
    public Dimension getSizeId(String elemento) {
        try {
            return driver.findElement(By.id(elemento)).getSize();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2098): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getSizeId]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getSize al elemento buscandolo por ClassName
     *
     * @param elemento el valor del objeto que se desea realizar getSize
     * @return el valor del Size del elemento seleccionado
     */
    public Dimension getSizeClassName(String elemento) {
        try {
            return driver.findElement(By.className(elemento)).getSize();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2099): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getSizeClassName]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getSize al elemento buscandolo por CssSelector
     *
     * @param elemento el valor del objeto que se desea realizar getSize
     * @return el valor del Size del elemento seleccionado
     */
    public Dimension getSizeCssSelector(String elemento) {
        try {
            return driver.findElement(By.cssSelector(elemento)).getSize();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2100): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getSizeCssSelector]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getSize al elemento buscandolo por LinkText
     *
     * @param elemento el valor del objeto que se desea realizar getSize
     * @return el valor del Size del elemento seleccionado
     */
    public Dimension getSizeLinkText(String elemento) {
        try {
            return driver.findElement(By.linkText(elemento)).getSize();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2101): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getSizeLinkText]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getSize al elemento buscandolo por PartialLinkText
     *
     * @param elemento el valor del objeto que se desea realizar getSize
     * @return el valor del Size del elemento seleccionado
     */
    public Dimension getSizePartialLinkText(String elemento) {
        try {
            return driver.findElement(By.partialLinkText(elemento)).getSize();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2102): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getSizePartialLinkText]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getSize al elemento buscandolo por TagName
     *
     * @param elemento el valor del objeto que se desea realizar getSize
     * @return el valor del Size del elemento seleccionado
     */
    public Dimension getSizeTagName(String elemento) {
        try {
            return driver.findElement(By.tagName(elemento)).getSize();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2103): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getSizeTagName]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getSize al elemento buscandolo por Xpath
     *
     * @param elemento el valor del objeto que se desea realizar getSize
     * @return el valor del Size del elemento seleccionado
     */
    public Dimension getSizeXpath(String elemento) {
        try {
            return driver.findElement(By.xpath(elemento)).getSize();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2104): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getSizeXpath]");
        }
        return null;
    }

    /**
     * MÃ©todo para obtener el ancho de las dimensiones del elemento buscandolo
     * por Name
     *
     * @param elemento el valor del objeto que se desea realizar getSize
     * @return el valor del ancho de la dimension del del elemento seleccionado
     */
    public int getSizeWidthName(String elemento) {
        try {
            return driver.findElement(By.name(elemento)).getSize().getWidth();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2105): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getSizeWidthName]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el ancho de las dimensiones del elemento buscandolo
     * por ID
     *
     * @param elemento el valor del objeto que se desea realizar getSize
     * @return el valor del ancho de la dimension del del elemento seleccionado
     */
    public int getSizeWidthId(String elemento) {
        try {
            return driver.findElement(By.id(elemento)).getSize().getWidth();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2106): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getSizeWidthId]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el ancho de las dimensiones del elemento buscandolo
     * por ClassName
     *
     * @param elemento el valor del objeto que se desea realizar getSize
     * @return el valor del ancho de la dimension del del elemento seleccionado
     */
    public int getSizeWidthClassName(String elemento) {
        try {
            return driver.findElement(By.className(elemento)).getSize().getWidth();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2107): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getSizeWidthClassName]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el ancho de las dimensiones del elemento buscandolo
     * por CssSelector
     *
     * @param elemento el valor del objeto que se desea realizar getSize
     * @return el valor del ancho de la dimension del del elemento seleccionado
     */
    public int getSizeWidthCssSelector(String elemento) {
        try {
            return driver.findElement(By.cssSelector(elemento)).getSize().getWidth();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2108): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getSizeWidthCssSelector]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el ancho de las dimensiones del elemento buscandolo
     * por LinkText
     *
     * @param elemento el valor del objeto que se desea realizar getSize
     * @return el valor del ancho de la dimension del del elemento seleccionado
     */
    public int getSizeWidthLinkText(String elemento) {
        try {
            return driver.findElement(By.linkText(elemento)).getSize().getWidth();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2109): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getSizeWidthLinkText]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el ancho de las dimensiones del elemento buscandolo
     * por PartialLinkText
     *
     * @param elemento el valor del objeto que se desea realizar getSize
     * @return el valor del ancho de la dimension del del elemento seleccionado
     */
    public int getSizeWidthPartialLinkText(String elemento) {
        try {
            return driver.findElement(By.partialLinkText(elemento)).getSize().getWidth();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2110): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getSizeWidthPartialLinkText]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el ancho de las dimensiones del elemento buscandolo
     * por TagName
     *
     * @param elemento el valor del objeto que se desea realizar getSize
     * @return el valor del ancho de la dimension del del elemento seleccionado
     */
    public int getSizeWidthTagName(String elemento) {
        try {
            return driver.findElement(By.tagName(elemento)).getSize().getWidth();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2111): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getSizeWidthTagName]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el ancho de las dimensiones del elemento buscandolo
     * por Xpath
     *
     * @param elemento el valor del objeto que se desea realizar getSize
     * @return el valor del ancho de la dimension del del elemento seleccionado
     */
    public int getSizeWidthXpath(String elemento) {
        try {
            return driver.findElement(By.xpath(elemento)).getSize().getWidth();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2112): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getSizeWidthXpath]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el alto de las dimensiones del elemento buscandolo
     * por Name
     *
     * @param elemento el valor del objeto que se desea realizar getSize
     * @return el valor del alto de la dimension del del elemento seleccionado
     */
    public int getSizeHeightName(String elemento) {
        try {
            return driver.findElement(By.name(elemento)).getSize().getHeight();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2113): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getSizeHeightName]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el alto de las dimensiones del elemento buscandolo
     * por ID
     *
     * @param elemento el valor del objeto que se desea realizar getSize
     * @return el valor del alto de la dimension del del elemento seleccionado
     */
    public int getSizeHeightId(String elemento) {
        try {
            return driver.findElement(By.id(elemento)).getSize().getHeight();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2114): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getSizeHeightId]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el alto de las dimensiones del elemento buscandolo
     * por ClassName
     *
     * @param elemento el valor del objeto que se desea realizar getSize
     * @return el valor del alto de la dimension del del elemento seleccionado
     */
    public int getSizeHeightClassName(String elemento) {
        try {
            return driver.findElement(By.className(elemento)).getSize().getHeight();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2115): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getSizeHeightClassName]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el alto de las dimensiones del elemento buscandolo
     * por CssSelector
     *
     * @param elemento el valor del objeto que se desea realizar getSize
     * @return el valor del alto de la dimension del del elemento seleccionado
     */
    public int getSizeHeightCssSelector(String elemento) {
        try {
            return driver.findElement(By.cssSelector(elemento)).getSize().getHeight();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2116): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getSizeHeightCssSelector]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el alto de las dimensiones del elemento buscandolo
     * por LinkText
     *
     * @param elemento el valor del objeto que se desea realizar getSize
     * @return el valor del alto de la dimension del del elemento seleccionado
     */
    public int getSizeHeightLinkText(String elemento) {
        try {
            return driver.findElement(By.linkText(elemento)).getSize().getHeight();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2117): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getSizeHeightLinkText]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el alto de las dimensiones del elemento buscandolo
     * por PartialLinkText
     *
     * @param elemento el valor del objeto que se desea realizar getSize
     * @return el valor del alto de la dimension del del elemento seleccionado
     */
    public int getSizeHeightPartialLinkText(String elemento) {
        try {
            return driver.findElement(By.partialLinkText(elemento)).getSize().getHeight();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2118): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getSizeHeightPartialLinkText]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el alto de las dimensiones del elemento buscandolo
     * por TagName
     *
     * @param elemento el valor del objeto que se desea realizar getSize
     * @return el valor del alto de la dimension del del elemento seleccionado
     */
    public int getSizeHeightTagName(String elemento) {
        try {
            return driver.findElement(By.tagName(elemento)).getSize().getHeight();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2119): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getSizeHeightTagName]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el alto de las dimensiones del elemento buscandolo
     * por Xpath
     *
     * @param elemento el valor del objeto que se desea realizar getSize
     * @return el valor del alto de la dimension del del elemento seleccionado
     */
    public int getSizeHeightXpath(String elemento) {
        try {
            return driver.findElement(By.xpath(elemento)).getSize().getHeight();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2120): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getSizeHeightXpath]");
        }
        return 0;
    }

    /**
     * MÃ©todo para realizar getRect al elemento buscandolo por Name
     *
     * @param IdValueElemento el valor del objeto que se desea realizar getRect
     * @return el valor del Size del elemento seleccionado
     */
    public String getRectName(String IdValueElemento) {
        try {
            return GetRectString(driver.findElement(By.name(IdValueElemento)));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2121): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getRectName]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getRect al elemento buscandolo por ID
     *
     * @param IdValueElemento el valor del objeto que se desea realizar getRect
     * @return el valor del Size del elemento seleccionado
     */
    public String getRectId(String IdValueElemento) {
        try {
            return GetRectString(driver.findElement(By.id(IdValueElemento)));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2122): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getRectId]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getRect al elemento buscandolo por ClassName
     *
     * @param IdValueElemento el valor del objeto que se desea realizar getRect
     * @return el valor del Size del elemento seleccionado
     */
    public String getRectClassName(String IdValueElemento) {
        try {
            return GetRectString(driver.findElement(By.className(IdValueElemento)));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2123): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getRectClassName]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getRect al elemento buscandolo por CssSelector
     *
     * @param IdValueElemento el valor del objeto que se desea realizar getRect
     * @return el valor del Size del elemento seleccionado
     */
    public String getRectCssSelector(String IdValueElemento) {
        try {
            return GetRectString(driver.findElement(By.cssSelector(IdValueElemento)));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2124): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getRectCssSelector]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getRect al elemento buscandolo por LinkText
     *
     * @param IdValueElemento el valor del objeto que se desea realizar getRect
     * @return el valor del Size del elemento seleccionado
     */
    public String getRectLinkText(String IdValueElemento) {
        try {
            return GetRectString(driver.findElement(By.linkText(IdValueElemento)));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2125): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getRectLinkText]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getRect al elemento buscandolo por PartialLinkText
     *
     * @param IdValueElemento el valor del objeto que se desea realizar getRect
     * @return el valor del Size del elemento seleccionado
     */
    public String getRectPartialLinkText(String IdValueElemento) {
        try {
            return GetRectString(driver.findElement(By.partialLinkText(IdValueElemento)));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2126): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getRectPartialLinkText]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getRect al elemento buscandolo por TagName
     *
     * @param IdValueElemento el valor del objeto que se desea realizar getRect
     * @return el valor del Size del elemento seleccionado
     */
    public String getRectTagName(String IdValueElemento) {
        try {
            return GetRectString(driver.findElement(By.tagName(IdValueElemento)));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2127): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getRectTagName]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getRect al elemento buscandolo por Xpath
     *
     * @param IdValueElemento el valor del objeto que se desea realizar getRect
     * @return el valor del Size del elemento seleccionado
     */
    public String getRectXpath(String IdValueElemento) {
        try {
            return GetRectString(driver.findElement(By.xpath(IdValueElemento)));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2128): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getRectXpath]");
        }
        return null;
    }

    /**
     * MÃ©todo para obtener la localizaciÃ³n del elemento buscandolo por Name
     *
     * @param IdValueElemento el valor del objeto que se desea obtener el ancho
     * del rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public Point getLocationName(String IdValueElemento) {
        try {
            return getLocation(driver.findElement(By.name(IdValueElemento)));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2129): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getLocationName]");
        }
        return null;
    }

    /**
     * MÃ©todo para obtener la localizaciÃ³n del elemento buscandolo por ID
     *
     * @param IdValueElemento el valor del objeto que se desea obtener el ancho
     * del rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public Point getLocationId(String IdValueElemento) {
        try {
            return getLocation(driver.findElement(By.name(IdValueElemento)));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2130): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getLocationId]");
        }
        return null;
    }

    /**
     * MÃ©todo para obtener la localizaciÃ³n del elemento buscandolo por
     * ClassName
     *
     * @param IdValueElemento el valor del objeto que se desea obtener el ancho
     * del rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public Point getLocationClassName(String IdValueElemento) {
        try {
            return getLocation(driver.findElement(By.name(IdValueElemento)));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2131): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getLocationClassName]");
        }
        return null;
    }

    /**
     * MÃ©todo para obtener la localizaciÃ³n del elemento buscandolo por
     * CssSelector
     *
     * @param IdValueElemento el valor del objeto que se desea obtener el ancho
     * del rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public Point getLocationCssSelector(String IdValueElemento) {
        try {
            return getLocation(driver.findElement(By.cssSelector(IdValueElemento)));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2132): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getLocationCssSelector]");
        }
        return null;
    }

    /**
     * MÃ©todo para obtener la localizaciÃ³n del elemento buscandolo por
     * LinkText
     *
     * @param IdValueElemento el valor del objeto que se desea obtener el ancho
     * del rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public Point getLocationLinkText(String IdValueElemento) {
        try {
            return getLocation(driver.findElement(By.linkText(IdValueElemento)));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2133): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getLocationLinkText]");
        }
        return null;
    }

    /**
     * MÃ©todo para obtener la localizaciÃ³n del elemento buscandolo por
     * PartialLinkText
     *
     * @param IdValueElemento el valor del objeto que se desea obtener el ancho
     * del rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public Point getLocationPartialLinkText(String IdValueElemento) {
        try {
            return getLocation(driver.findElement(By.name(IdValueElemento)));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2134): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getLocationPartialLinkText]");
        }
        return null;
    }

    /**
     * MÃ©todo para obtener la localizaciÃ³n del elemento buscandolo por TagName
     *
     * @param IdValueElemento el valor del objeto que se desea obtener el ancho
     * del rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public Point getLocationTagName(String IdValueElemento) {
        try {
            return getLocation(driver.findElement(By.tagName(IdValueElemento)));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2135): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getLocationTagName]");
        }
        return null;
    }

    /**
     * MÃ©todo para obtener la localizaciÃ³n del elemento buscandolo por Xpath
     *
     * @param IdValueElemento el valor del objeto que se desea obtener el ancho
     * del rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public Point getLocationXpath(String IdValueElemento) {
        try {
            return getLocation(driver.findElement(By.xpath(IdValueElemento)));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2136): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getLocationXpath]");
        }
        return null;
    }

    /**
     * MÃ©todo para obtener la posicion x del elemento buscandolo por Name
     *
     * @param IdValueElemento el valor del objeto que se desea obtener el alto
     * del rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public Double getLocationXName(String IdValueElemento) {
        try {
            return getLocation(driver.findElement(By.name(IdValueElemento))).getX();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2137): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getLocationXName]");
        }
        return 0.0;
    }

    /**
     * MÃ©todo para obtener la posicion x del elemento buscandolo por ID
     *
     * @param IdValueElemento el valor del objeto que se desea obtener el alto
     * del rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public Double getLocationXId(String IdValueElemento) {
        try {
            return getLocation(driver.findElement(By.id(IdValueElemento))).getX();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2138): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getLocationXId]");
        }
        return 0.0;
    }

    /**
     * MÃ©todo para obtener la posicion x del elemento buscandolo por ClassName
     *
     * @param IdValueElemento el valor del objeto que se desea obtener el alto
     * del rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public Double getLocationXClassName(String IdValueElemento) {
        try {
            return getLocation(driver.findElement(By.className(IdValueElemento))).getX();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2139): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getLocationXClassName]");
        }
        return 0.0;
    }

    /**
     * MÃ©todo para obtener la posicion x del elemento buscandolo por
     * CssSelector
     *
     * @param IdValueElemento el valor del objeto que se desea obtener el alto
     * del rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public Double getLocationXCssSelector(String IdValueElemento) {
        try {
            return getLocation(driver.findElement(By.cssSelector(IdValueElemento))).getX();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2140): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getLocationXCssSelector]");
        }
        return 0.0;
    }

    /**
     * MÃ©todo para obtener la posicion x del elemento buscandolo por LinkText
     *
     * @param IdValueElemento el valor del objeto que se desea obtener el alto
     * del rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public Double getLocationXLinkText(String IdValueElemento) {
        try {
            return getLocation(driver.findElement(By.linkText(IdValueElemento))).getX();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2141): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getLocationXLinkText]");
        }
        return 0.0;
    }

    /**
     * MÃ©todo para obtener la posicion x del elemento buscandolo por
     * PartialLinkText
     *
     * @param IdValueElemento el valor del objeto que se desea obtener el alto
     * del rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public Double getLocationXPartialLinkText(String IdValueElemento) {
        try {
            return getLocation(driver.findElement(By.partialLinkText(IdValueElemento))).getX();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2142): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getLocationXPartialLinkText]");
        }
        return 0.0;
    }

    /**
     * MÃ©todo para obtener la posicion x del elemento buscandolo por TagName
     *
     * @param IdValueElemento el valor del objeto que se desea obtener el alto
     * del rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public Double getLocationXTagName(String IdValueElemento) {
        try {
            return getLocation(driver.findElement(By.tagName(IdValueElemento))).getX();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2143): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getLocationXTagName]");
        }
        return 0.0;
    }

    /**
     * MÃ©todo para obtener la posicion x del elemento buscandolo por Xpath
     *
     * @param IdValueElemento el valor del objeto que se desea obtener el alto
     * del rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public Double getLocationXXpath(String IdValueElemento) {
        try {
            return getLocation(driver.findElement(By.xpath(IdValueElemento))).getX();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2144): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getLocationXXpath]");
        }
        return 0.0;
    }

    /**
     * MÃ©todo para obtener la posicion y del rectagulo del elemento buscandolo
     * por Name
     *
     * @param IdValueElemento el valor del objeto que se desea obtener el valor
     * del eje x del rectangulo
     * @return el valor del eje y del elemento seleccionado
     */
    public double getLocationYName(String IdValueElemento) {
        try {
            return getLocation(driver.findElement(By.name(IdValueElemento))).getY();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2145): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getLocationYName]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener la posicion y del rectagulo del elemento buscandolo
     * por ID
     *
     * @param IdValueElemento el valor del objeto que se desea obtener el valor
     * del eje x del rectangulo
     * @return el valor del eje y del elemento seleccionado
     */
    public double getLocationYId(String IdValueElemento) {
        try {
            return getLocation(driver.findElement(By.id(IdValueElemento))).getY();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2146): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getLocationYId]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener la posicion y del rectagulo del elemento buscandolo
     * por ClassName
     *
     * @param IdValueElemento el valor del objeto que se desea obtener el valor
     * del eje x del rectangulo
     * @return el valor del eje y del elemento seleccionado
     */
    public double getLocationYClassName(String IdValueElemento) {
        try {
            return getLocation(driver.findElement(By.className(IdValueElemento))).getY();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2147): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getLocationYClassName]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener la posicion y del rectagulo del elemento buscandolo
     * por CssSelector
     *
     * @param IdValueElemento el valor del objeto que se desea obtener el valor
     * del eje x del rectangulo
     * @return el valor del eje y del elemento seleccionado
     */
    public double getLocationYCssSelector(String IdValueElemento) {
        try {
            return getLocation(driver.findElement(By.cssSelector(IdValueElemento))).getY();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2148): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getLocationYCssSelector]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener la posicion y del rectagulo del elemento buscandolo
     * por LinkText
     *
     * @param IdValueElemento el valor del objeto que se desea obtener el valor
     * del eje x del rectangulo
     * @return el valor del eje y del elemento seleccionado
     */
    public double getLocationYLinkText(String IdValueElemento) {
        try {
            return getLocation(driver.findElement(By.linkText(IdValueElemento))).getY();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2149): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getLocationYLinkText]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener la posicion y del rectagulo del elemento buscandolo
     * por PartialLinkText
     *
     * @param IdValueElemento el valor del objeto que se desea obtener el valor
     * del eje x del rectangulo
     * @return el valor del eje y del elemento seleccionado
     */
    public double getLocationYPartialLinkText(String IdValueElemento) {
        try {
            return getLocation(driver.findElement(By.partialLinkText(IdValueElemento))).getY();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2150): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getLocationYPartialLinkText]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener la posicion y del rectagulo del elemento buscandolo
     * por TagName
     *
     * @param IdValueElemento el valor del objeto que se desea obtener el valor
     * del eje x del rectangulo
     * @return el valor del eje y del elemento seleccionado
     */
    public double getLocationYTagName(String IdValueElemento) {
        try {
            return getLocation(driver.findElement(By.tagName(IdValueElemento))).getY();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2151): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getLocationYTagName]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener la posicion y del rectagulo del elemento buscandolo
     * por Xpath
     *
     * @param IdValueElemento el valor del objeto que se desea obtener el valor
     * del eje x del rectangulo
     * @return el valor del eje y del elemento seleccionado
     */
    public double getLocationYXpath(String IdValueElemento) {
        try {
            return getLocation(driver.findElement(By.xpath(IdValueElemento))).getY();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2152): No Fue Posible Realizar La Accion Sobre El Elemento [" + IdValueElemento + "]::[getLocationYXpath]");
        }
        return 0;
    }

    ///////////////////////////////
    //FIN LOCATION
    ///////////////////////////////
    /**
     * MÃ©todo para obtener el ancho del rectagulo del elemento buscandolo por
     * Name
     *
     * @param elemento el valor del objeto que se desea obtener el ancho del
     * rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public int getRectWidthName(String elemento) {
        try {
            return driver.findElement(By.name(elemento)).getRect().getWidth();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2129): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectWidthName]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el ancho del rectagulo del elemento buscandolo por
     * ID
     *
     * @param elemento el valor del objeto que se desea obtener el ancho del
     * rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public int getRectWidthId(String elemento) {
        try {
            return driver.findElement(By.id(elemento)).getRect().getWidth();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2130): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectWidthId]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el ancho del rectagulo del elemento buscandolo por
     * ClassName
     *
     * @param elemento el valor del objeto que se desea obtener el ancho del
     * rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public int getRectWidthClassName(String elemento) {
        try {
            return driver.findElement(By.className(elemento)).getRect().getWidth();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2131): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectWidthClassName]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el ancho del rectagulo del elemento buscandolo por
     * CssSelector
     *
     * @param elemento el valor del objeto que se desea obtener el ancho del
     * rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public int getRectWidthCssSelector(String elemento) {
        try {
            return driver.findElement(By.cssSelector(elemento)).getRect().getWidth();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2132): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectWidthCssSelector]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el ancho del rectagulo del elemento buscandolo por
     * LinkText
     *
     * @param elemento el valor del objeto que se desea obtener el ancho del
     * rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public int getRectWidthLinkText(String elemento) {
        try {
            return driver.findElement(By.linkText(elemento)).getRect().getWidth();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2133): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectWidthLinkText]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el ancho del rectagulo del elemento buscandolo por
     * PartialLinkText
     *
     * @param elemento el valor del objeto que se desea obtener el ancho del
     * rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public int getRectWidthPartialLinkText(String elemento) {
        try {
            return driver.findElement(By.partialLinkText(elemento)).getRect().getWidth();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2134): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectWidthPartialLinkText]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el ancho del rectagulo del elemento buscandolo por
     * TagName
     *
     * @param elemento el valor del objeto que se desea obtener el ancho del
     * rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public int getRectWidthTagName(String elemento) {
        try {
            return driver.findElement(By.tagName(elemento)).getRect().getWidth();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2135): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectWidthTagName]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el ancho del rectagulo del elemento buscandolo por
     * Xpath
     *
     * @param elemento el valor del objeto que se desea obtener el ancho del
     * rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public int getRectWidthXpath(String elemento) {
        try {
            return driver.findElement(By.xpath(elemento)).getRect().getWidth();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2136): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectWidthXpath]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el alto del rectagulo del elemento buscandolo por
     * Name
     *
     * @param elemento el valor del objeto que se desea obtener el alto del
     * rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public int getRectHeightName(String elemento) {
        try {
            return driver.findElement(By.name(elemento)).getRect().getHeight();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2137): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectHeightName]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el alto del rectagulo del elemento buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea obtener el alto del
     * rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public int getRectHeightId(String elemento) {
        try {
            return driver.findElement(By.id(elemento)).getRect().getHeight();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2138): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectHeightId]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el alto del rectagulo del elemento buscandolo por
     * ClassName
     *
     * @param elemento el valor del objeto que se desea obtener el alto del
     * rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public int getRectHeightClassName(String elemento) {
        try {
            return driver.findElement(By.className(elemento)).getRect().getHeight();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2139): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectHeightClassName]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el alto del rectagulo del elemento buscandolo por
     * CssSelector
     *
     * @param elemento el valor del objeto que se desea obtener el alto del
     * rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public int getRectHeightCssSelector(String elemento) {
        try {
            return driver.findElement(By.cssSelector(elemento)).getRect().getHeight();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2140): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectHeightCssSelector]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el alto del rectagulo del elemento buscandolo por
     * LinkText
     *
     * @param elemento el valor del objeto que se desea obtener el alto del
     * rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public int getRectHeightLinkText(String elemento) {
        try {
            return driver.findElement(By.linkText(elemento)).getRect().getHeight();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2141): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectHeightLinkText]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el alto del rectagulo del elemento buscandolo por
     * PartialLinkText
     *
     * @param elemento el valor del objeto que se desea obtener el alto del
     * rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public int getRectHeightPartialLinkText(String elemento) {
        try {
            return driver.findElement(By.partialLinkText(elemento)).getRect().getHeight();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2142): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectHeightPartialLinkText]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el alto del rectagulo del elemento buscandolo por
     * TagName
     *
     * @param elemento el valor del objeto que se desea obtener el alto del
     * rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public int getRectHeightTagName(String elemento) {
        try {
            return driver.findElement(By.tagName(elemento)).getRect().getHeight();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2143): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectHeightTagName]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el alto del rectagulo del elemento buscandolo por
     * Xpath
     *
     * @param elemento el valor del objeto que se desea obtener el alto del
     * rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public int getRectHeightXpath(String elemento) {
        try {
            return driver.findElement(By.xpath(elemento)).getRect().getHeight();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2144): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectHeightXpath]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el valor del eje x del rectagulo del elemento
     * buscandolo por Name
     *
     * @param elemento el valor del objeto que se desea obtener el valor del eje
     * x del rectangulo
     * @return el valor del eje x del elemento seleccionado
     */
    public int getRectXName(String elemento) {
        try {
            return driver.findElement(By.name(elemento)).getRect().getX();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2145): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectXName]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el valor del eje x del rectagulo del elemento
     * buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea obtener el valor del eje
     * x del rectangulo
     * @return el valor del eje x del elemento seleccionado
     */
    public int getRectXId(String elemento) {
        try {
            return driver.findElement(By.id(elemento)).getRect().getX();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2146): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectXId]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el valor del eje x del rectagulo del elemento
     * buscandolo por ClassName
     *
     * @param elemento el valor del objeto que se desea obtener el valor del eje
     * x del rectangulo
     * @return el valor del eje x del elemento seleccionado
     */
    public int getRectXClassName(String elemento) {
        try {
            return driver.findElement(By.className(elemento)).getRect().getX();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2147): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectXClassName]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el valor del eje x del rectagulo del elemento
     * buscandolo por CssSelector
     *
     * @param elemento el valor del objeto que se desea obtener el valor del eje
     * x del rectangulo
     * @return el valor del eje x del elemento seleccionado
     */
    public int getRectXCssSelector(String elemento) {
        try {
            return driver.findElement(By.cssSelector(elemento)).getRect().getX();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2148): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectXCssSelector]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el valor del eje x del rectagulo del elemento
     * buscandolo por LinkText
     *
     * @param elemento el valor del objeto que se desea obtener el valor del eje
     * x del rectangulo
     * @return el valor del eje x del elemento seleccionado
     */
    public int getRectXLinkText(String elemento) {
        try {
            return driver.findElement(By.linkText(elemento)).getRect().getX();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2149): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectXLinkText]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el valor del eje x del rectagulo del elemento
     * buscandolo por PartialLinkText
     *
     * @param elemento el valor del objeto que se desea obtener el valor del eje
     * x del rectangulo
     * @return el valor del eje x del elemento seleccionado
     */
    public int getRectXPartialLinkText(String elemento) {
        try {
            return driver.findElement(By.partialLinkText(elemento)).getRect().getX();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2150): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectXPartialLinkText]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el valor del eje x del rectagulo del elemento
     * buscandolo por TagName
     *
     * @param elemento el valor del objeto que se desea obtener el valor del eje
     * x del rectangulo
     * @return el valor del eje x del elemento seleccionado
     */
    public int getRectXTagName(String elemento) {
        try {
            return driver.findElement(By.tagName(elemento)).getRect().getX();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2151): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectXTagName]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el valor del eje x del rectagulo del elemento
     * buscandolo por Xpath
     *
     * @param elemento el valor del objeto que se desea obtener el valor del eje
     * x del rectangulo
     * @return el valor del eje x del elemento seleccionado
     */
    public int getRectXXpath(String elemento) {
        try {
            return driver.findElement(By.xpath(elemento)).getRect().getX();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2152): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectXXpath]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el valor del eje y del rectagulo del elemento
     * buscandolo por Name
     *
     * @param elemento el valor del objeto que se desea obtener el valor del eje
     * y del rectangulo
     * @return el valor del eje y del elemento seleccionado
     */
    public int getRectYName(String elemento) {
        try {
            return driver.findElement(By.name(elemento)).getRect().getY();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2153): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectYName]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el valor del eje y del rectagulo del elemento
     * buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea obtener el valor del eje
     * y del rectangulo
     * @return el valor del eje y del elemento seleccionado
     */
    public int getRectYId(String elemento) {
        try {
            return driver.findElement(By.id(elemento)).getRect().getY();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2154): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectYId]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el valor del eje y del rectagulo del elemento
     * buscandolo por ClassName
     *
     * @param elemento el valor del objeto que se desea obtener el valor del eje
     * y del rectangulo
     * @return el valor del eje y del elemento seleccionado
     */
    public int getRectYClassName(String elemento) {
        try {
            return driver.findElement(By.className(elemento)).getRect().getY();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2155): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectYClassName]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el valor del eje y del rectagulo del elemento
     * buscandolo por CssSelector
     *
     * @param elemento el valor del objeto que se desea obtener el valor del eje
     * y del rectangulo
     * @return el valor del eje y del elemento seleccionado
     */
    public int getRectYCssSelector(String elemento) {
        try {
            return driver.findElement(By.cssSelector(elemento)).getRect().getY();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2156): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectYCssSelector]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el valor del eje y del rectagulo del elemento
     * buscandolo por LinkText
     *
     * @param elemento el valor del objeto que se desea obtener el valor del eje
     * y del rectangulo
     * @return el valor del eje y del elemento seleccionado
     */
    public int getRectYLinkText(String elemento) {
        try {
            return driver.findElement(By.linkText(elemento)).getRect().getY();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2157): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectYLinkText]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el valor del eje y del rectagulo del elemento
     * buscandolo por PartialLinkText
     *
     * @param elemento el valor del objeto que se desea obtener el valor del eje
     * y del rectangulo
     * @return el valor del eje y del elemento seleccionado
     */
    public int getRectYPartialLinkText(String elemento) {
        try {
            return driver.findElement(By.partialLinkText(elemento)).getRect().getY();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2158): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectYPartialLinkText]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el valor del eje y del rectagulo del elemento
     * buscandolo por TagName
     *
     * @param elemento el valor del objeto que se desea obtener el valor del eje
     * y del rectangulo
     * @return el valor del eje y del elemento seleccionado
     */
    public int getRectYTagName(String elemento) {
        try {
            return driver.findElement(By.tagName(elemento)).getRect().getY();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2159): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectYTagName]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el valor del eje y del rectagulo del elemento
     * buscandolo por Xpath
     *
     * @param elemento el valor del objeto que se desea obtener el valor del eje
     * y del rectangulo
     * @return el valor del eje y del elemento seleccionado
     */
    public int getRectYXpath(String elemento) {
        try {
            return driver.findElement(By.xpath(elemento)).getRect().getY();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2160): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[getRectYXpath]");
        }
        return 0;
    }

    /**
     * MÃ©todo para realizar click al elemento buscandolo por Name
     *
     * @param elemento el objeto tipo WebElement que se desea realizar click
     */
    public void clickElement(WebElement elemento) {
        try {
            elemento.click();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2161): No Fue Posible Realizar La Accion Sobre El Elemento [" + getAttributeValue(elemento) + "]::[clickElement]");
        }
    }

    /**
     * MÃ©todo para realizar clear al elemento buscandolo por Name
     *
     * @param elemento el objeto tipo WebElement que se desea realizar clear
     */
    public void clearElement(WebElement elemento) {
        try {
            elemento.clear();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2162): No Fue Posible Realizar La Accion Sobre El Elemento [" + getAttributeValue(elemento) + "]::[clearElement]");
        }
    }

    /**
     * MÃ©todo para realizar submit al elemento buscandolo por Name
     *
     * @param elemento el objeto tipo WebElement que se desea realizar submit
     */
    public void submitElement(WebElement elemento) {
        try {
            elemento.submit();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2163): No Fue Posible Realizar La Accion Sobre El Elemento [" + getAttributeValue(elemento) + "]::[submitElement]");
        }
    }

    /**
     * MÃ©todo para realizar sendKeys al elemento buscandolo por Name
     *
     * @param elemento el objeto tipo WebElement que se desea realizar sendKeys
     * @param texto valor a escribir en el objeto seleccionado
     */
    public void sendKeysElement(WebElement elemento, String texto) {
        try {
            elemento.sendKeys(texto);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2164): No Fue Posible Realizar La Accion Sobre El Elemento [" + getAttributeValue(elemento) + "]::[sendKeysElement]");
        }
    }

    /**
     * MÃ©todo para realizar getAttribute al elemento buscandolo por Name
     *
     * @param elemento el objeto tipo WebElement que se desea realizar
     * getAttribute
     * @param atributo que se desea obtener del elemento seleccionado
     * @return valor del atributo buscado
     */
    public String getAttributeElement(WebElement elemento, String atributo) {
        try {
            return elemento.getAttribute(atributo);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2165): No Fue Posible Realizar La Accion Sobre El Elemento [" + getAttributeValue(elemento) + "]::[getAttributeElement]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar getCssValue al elemento buscandolo por Name
     *
     * @param elemento el objeto tipo WebElement que se desea realizar
     * getCssValue
     * @param value que se desea obtener del elemento seleccionado
     * @return valor del atributo buscado
     */
    public String getCssValueElement(WebElement elemento, String value) {
        try {
            return elemento.getCssValue(value);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2166): No Fue Posible Realizar La Accion Sobre El Elemento [" + getAttributeValue(elemento) + "]::[getCssValueElement]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar isDisplayed al elemento buscandolo por Name
     *
     * @param elemento el objeto tipo WebElement que se desea realizar
     * isDisplayed
     * @return un valor booleano si el elemento se encuentra display
     */
    public boolean isDisplayedElement(WebElement elemento) {
        try {
            return elemento.isDisplayed();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2167): No Fue Posible Realizar La Accion Sobre El Elemento [" + getAttributeValue(elemento) + "]::[isDisplayedElement]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar isSelected al elemento buscandolo por Name
     *
     * @param elemento el objeto tipo WebElement que se desea realizar
     * isSelected
     * @return un valor booleano si el elemento se encuentra select
     */
    public boolean isSelectedElement(WebElement elemento) {
        try {
            return elemento.isSelected();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2168): No Fue Posible Realizar La Accion Sobre El Elemento [" + getAttributeValue(elemento) + "]::[isSelectedElement]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar isEnabled al elemento buscandolo por Name
     *
     * @param elemento el objeto tipo WebElement que se desea realizar isEnabled
     * @return un valor booleano si el elemento se encuentra enable
     */
    public boolean isEnabledElement(WebElement elemento) {
        try {
            return elemento.isEnabled();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2169): No Fue Posible Realizar La Accion Sobre El Elemento [" + getAttributeValue(elemento) + "]::[isEnabledElement]");
        }
        return false;
    }

    /**
     * MÃ©todo para realizar getText al elemento buscandolo por Name
     *
     * @param elemento el objeto tipo WebElement que se desea realizar getText
     * @return el texto que contiene el elemento seleccionado
     */
    public String getTextElement(WebElement elemento) {
        try {
            return elemento.getText();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2170): No Fue Posible Realizar La Accion Sobre El Elemento [" + getAttributeValue(elemento) + "]::[getTextElement]");
        }
        return "";
    }

    /**
     * MÃ©todo para realizar getTagName al elemento buscandolo por Name
     *
     * @param elemento el objeto tipo WebElement que se desea realizar
     * getTagName
     * @return el tagName del elemento seleccionado
     */
    public String getTagNameElement(WebElement elemento) {
        try {
            return elemento.getTagName();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2171): No Fue Posible Realizar La Accion Sobre El Elemento [" + getAttributeValue(elemento) + "]::[getTagNameElement]");
        }
        return "";
    }

    /**
     * MÃ©todo para obtener el alto de las dimensiones del elemento buscandolo
     * por LinkText
     *
     * @param elemento el valor del objeto que se desea realizar getSize
     * @return el valor de la dimension del elemento seleccionado
     */
    public Dimension getSizeElement(WebElement elemento) {
        try {
            return elemento.getSize();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2172): No Fue Posible Realizar La Accion Sobre El Elemento [" + getAttributeValue(elemento) + "]::[getSizeElement]");
        }
        return null;
    }

    /**
     * MÃ©todo para obtener el ancho de las dimensiones del elemento buscandolo
     * por Name
     *
     * @param elemento el objeto tipo WebElement que se desea realizar getSize
     * @return el valor del ancho de la dimension del del elemento seleccionado
     */
    public int getSizeWidthElement(WebElement elemento) {
        try {
            return elemento.getSize().getWidth();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2173): No Fue Posible Realizar La Accion Sobre El Elemento [" + getAttributeValue(elemento) + "]::[getSizeWidthElement]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el alto de las dimensiones del elemento buscandolo
     * por Name
     *
     * @param elemento el objeto tipo WebElement que se desea realizar getSize
     * @return el valor del alto de la dimension del del elemento seleccionado
     */
    public int getSizeHeightElement(WebElement elemento) {
        try {
            return elemento.getSize().getHeight();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2174): No Fue Posible Realizar La Accion Sobre El Elemento [" + getAttributeValue(elemento) + "]::[getSizeHeightElement]");
        }
        return 0;
    }

    /**
     * MÃ©todo para realizar getRect al elemento buscandolo por Name
     *
     * @param elemento el objeto tipo WebElement que se desea realizar getRect
     * @return el valor del Size del elemento seleccionado
     */
    public Rectangle getRectElement(WebElement elemento) {
        try {
            return elemento.getRect();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2175): No Fue Posible Realizar La Accion Sobre El Elemento [" + getAttributeValue(elemento) + "]::[getRectElement]");
        }
        return null;
    }

    /**
     * MÃ©todo para obtener el ancho del rectagulo del elemento buscandolo por
     * Name
     *
     * @param elemento el objeto tipo WebElement que se desea obtener el ancho
     * del rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public int getRectWidthElement(WebElement elemento) {
        try {
            return elemento.getRect().getWidth();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2176): No Fue Posible Realizar La Accion Sobre El Elemento [" + getAttributeValue(elemento) + "]::[getRectWidthElement]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el alto del rectagulo del elemento buscandolo por
     * Name
     *
     * @param elemento el objeto tipo WebElement que se desea obtener el alto
     * del rectangulo
     * @return el valor del Size del elemento seleccionado
     */
    public int getRectHeightElement(WebElement elemento) {
        try {
            return elemento.getRect().getHeight();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2177): No Fue Posible Realizar La Accion Sobre El Elemento [" + getAttributeValue(elemento) + "]::[getRectHeightElement]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el valor del eje x del rectagulo del elemento
     * buscandolo por Name
     *
     * @param elemento el objeto tipo WebElement que se desea obtener el valor
     * del eje x del rectangulo
     * @return el valor del eje x del elemento seleccionado
     */
    public int getRectXElement(WebElement elemento) {
        try {
            return elemento.getRect().getX();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2178): No Fue Posible Realizar La Accion Sobre El Elemento [" + getAttributeValue(elemento) + "]::[getRectXElement]");
        }
        return 0;
    }

    /**
     * MÃ©todo para obtener el valor del eje y del rectagulo del elemento
     * buscandolo por Name
     *
     * @param elemento el objeto tipo WebElement que se desea obtener el valor
     * del eje y del rectangulo
     * @return el valor del eje y del elemento seleccionado
     */
    public int getRectYElement(WebElement elemento) {
        try {
            return elemento.getRect().getY();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2179): No Fue Posible Realizar La Accion Sobre El Elemento [" + getAttributeValue(elemento) + "]::[getRectYElement]");
        }
        return 0;
    }

    /**
     * MÃ©todo para realizar la busqueda de los elementos por Name
     *
     * @param elemento el valor de los objetos que se desean buscar
     * @return la lista de WebElements encontrados
     */
    public List<WebElement> elementsByName(String elemento) {
        try {
            return driver.findElements(By.name(elemento));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2180): No Fue Posible Encontrar La Lista Del Elemento [" + elemento + "]::[elementsByName]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar la busqueda de los elementos por ID
     *
     * @param elemento el valor de los objetos que se desean buscar
     * @return la lista de WebElements encontrados
     */
    public List<WebElement> elementsById(String elemento) {
        try {
            return driver.findElements(By.id(elemento));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2181): No Fue Posible Encontrar La Lista Del Elemento [" + elemento + "]::[elementsById]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar la busqueda de los elementos por ClassName
     *
     * @param elemento el valor de los objetos que se desean buscar
     * @return la lista de WebElements encontrados
     */
    public List<WebElement> elementsByClassName(String elemento) {
        try {
            return driver.findElements(By.className(elemento));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2182): No Fue Posible Encontrar La Lista Del Elemento [" + elemento + "]::[elementsByClassName]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar la busqueda de los elementos por CssSelector
     *
     * @param elemento el valor de los objetos que se desean buscar
     * @return la lista de WebElements encontrados
     */
    public List<WebElement> elementsByCssSelector(String elemento) {
        try {
            return driver.findElements(By.cssSelector(elemento));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2183): No Fue Posible Encontrar La Lista Del Elemento [" + elemento + "]::[elementsByCssSelector]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar la busqueda de los elementos por LinkText
     *
     * @param elemento el valor de los objetos que se desean buscar
     * @return la lista de WebElements encontrados
     */
    public List<WebElement> elementsByLinkText(String elemento) {
        try {
            return driver.findElements(By.linkText(elemento));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2184): No Fue Posible Encontrar La Lista Del Elemento [" + elemento + "]::[elementsByLinkText]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar la busqueda de los elementos por PartialLinkText
     *
     * @param elemento el valor de los objetos que se desean buscar
     * @return la lista de WebElements encontrados
     */
    public List<WebElement> elementsByPartialLinkText(String elemento) {
        try {
            return driver.findElements(By.partialLinkText(elemento));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2185): No Fue Posible Encontrar La Lista Del Elemento [" + elemento + "]::[elementsByPartialLinkText]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar la busqueda de los elementos por TagName
     *
     * @param elemento el valor de los objetos que se desean buscar
     * @return la lista de WebElements encontrados
     */
    public List<WebElement> elementsByTagName(String elemento) {
        try {
            return driver.findElements(By.tagName(elemento));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2186): No Fue Posible Encontrar La Lista Del Elemento [" + elemento + "]::[elementsByTagName]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar la busqueda de los elementos por Xpath
     *
     * @param elemento el valor de los objetos que se desean buscar
     * @return la lista de WebElements encontrados
     */
    public List<WebElement> elementsByXpath(String elemento) {
        try {
            return driver.findElements(By.xpath(elemento));
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2187): No Fue Posible Encontrar La Lista Del Elemento [" + elemento + "]::[elementsByXpath]");
        }
        return null;
    }

    /**
     * MÃ©todo para remover todos los elementos de la lista por Name
     *
     * @param elemento el valor de los objetos que se desean remover
     */
    public void clearElementsByName(String elemento) {
        try {
            driver.findElements(By.name(elemento)).clear();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2188): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[clearElementsByName]");
        }

    }

    /**
     * MÃ©todo para remover todos los elementos de la lista por ID
     *
     * @param elemento el valor de los objetos que se desean remover
     */
    public void clearElementsById(String elemento) {
        try {
            driver.findElements(By.id(elemento)).clear();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2189): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[clearElementsById]");
        }

    }

    /**
     * MÃ©todo para remover todos los elementos de la lista por ClassName
     *
     * @param elemento el valor de los objetos que se desean remover
     */
    public void clearElementsByClassName(String elemento) {
        try {
            driver.findElements(By.className(elemento)).clear();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2190): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[clearElementsByClassName]");
        }

    }

    /**
     * MÃ©todo para remover todos los elementos de la lista por CssSelector
     *
     * @param elemento el valor de los objetos que se desean remover
     */
    public void clearElementsByCssSelector(String elemento) {
        try {
            driver.findElements(By.cssSelector(elemento)).clear();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2191): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[clearElementsByCssSelector]");
        }

    }

    /**
     * MÃ©todo para remover todos los elementos de la lista por LinkText
     *
     * @param elemento el valor de los objetos que se desean remover
     */
    public void clearElementsByLinkText(String elemento) {
        try {
            driver.findElements(By.linkText(elemento)).clear();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2192): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[clearElementsByLinkText]");
        }

    }

    /**
     * MÃ©todo para remover todos los elementos de la lista por PartialLinkText
     *
     * @param elemento el valor de los objetos que se desean remover
     */
    public void clearElementsByPartialLinkText(String elemento) {
        try {
            driver.findElements(By.partialLinkText(elemento)).clear();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2293): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[clearElementsByPartialLinkText]");
        }

    }

    /**
     * MÃ©todo para remover todos los elementos de la lista por TagName
     *
     * @param elemento el valor de los objetos que se desean remover
     */
    public void clearElementsByTagName(String elemento) {
        try {
            driver.findElements(By.tagName(elemento)).clear();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2194): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[clearElementsByTagName]");
        }

    }

    /**
     * MÃ©todo para remover todos los elementos de la lista por Xpath
     *
     * @param elemento el valor de los objetos que se desean remover
     */
    public void clearElementsByXpath(String elemento) {
        try {
            driver.findElements(By.xpath(elemento)).clear();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2195): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[clearElementsByXpath]");
        }

    }

    /**
     * MÃ©todo para contar todos los elementos de la lista por Name
     *
     * @param elemento el valor de los objetos que se desean contar
     * @return cantidad de elementos de la lista
     */
    public int sizeElementsByName(String elemento) {
        try {
            return driver.findElements(By.name(elemento)).size();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2196): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[sizeElementsByName]");
        }
        return 0;
    }

    /**
     * MÃ©todo para contar todos los elementos de la lista por ID
     *
     * @param elemento el valor de los objetos que se desean contar
     * @return cantidad de elementos de la lista
     */
    public int sizeElementsById(String elemento) {
        try {
            return driver.findElements(By.id(elemento)).size();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2197): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[sizeElementsById]");
        }
        return 0;
    }

    /**
     * MÃ©todo para contar todos los elementos de la lista por ClassName
     *
     * @param elemento el valor de los objetos que se desean contar
     * @return cantidad de elementos de la lista
     */
    public int sizeElementsByClassName(String elemento) {
        try {
            return driver.findElements(By.className(elemento)).size();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2198): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[sizeElementsByClassName]");
        }
        return 0;
    }

    /**
     * MÃ©todo para contar todos los elementos de la lista por CssSelector
     *
     * @param elemento el valor de los objetos que se desean contar
     * @return cantidad de elementos de la lista
     */
    public int sizeElementsByCssSelector(String elemento) {
        try {
            return driver.findElements(By.cssSelector(elemento)).size();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2199): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[sizeElementsByCssSelector]");
        }
        return 0;
    }

    /**
     * MÃ©todo para contar todos los elementos de la lista por LinkText
     *
     * @param elemento el valor de los objetos que se desean contar
     * @return cantidad de elementos de la lista
     */
    public int sizeElementsByLinkText(String elemento) {
        try {
            return driver.findElements(By.linkText(elemento)).size();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2200): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[sizeElementsByLinkText]");
        }
        return 0;
    }

    /**
     * MÃ©todo para contar todos los elementos de la lista por PartialLinkText
     *
     * @param elemento el valor de los objetos que se desean contar
     * @return cantidad de elementos de la lista
     */
    public int sizeElementsByPartialLinkText(String elemento) {
        try {
            return driver.findElements(By.partialLinkText(elemento)).size();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2201): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[sizeElementsByPartialLinkText]");
        }
        return 0;
    }

    /**
     * MÃ©todo para contar todos los elementos de la lista por TagName
     *
     * @param elemento el valor de los objetos que se desean contar
     * @return cantidad de elementos de la lista
     */
    public int sizeElementsByTagName(String elemento) {
        try {
            return driver.findElements(By.tagName(elemento)).size();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2202): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[sizeElementsByTagName]");
        }
        return 0;
    }

    /**
     * MÃ©todo para contar todos los elementos de la lista por Xpath
     *
     * @param elemento el valor de los objetos que se desean contar
     * @return cantidad de elementos de la lista
     */
    public int sizeElementsByXpath(String elemento) {
        try {
            return driver.findElements(By.xpath(elemento)).size();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2203): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[sizeElementsByXpath]");
        }
        return 0;
    }

    /**
     * MÃ©todo para agregar un WebElement a la lista que se busca por Name
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * agragarle otro
     * @param webElemento que se desea agragar a la lista encontrada
     * @return cantidad de elementos de la lista
     */
    public boolean addElementsByName(String elemento, WebElement webElemento) {
        try {
            return driver.findElements(By.name(elemento)).add(webElemento);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2204): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[addElementsByName]");
        }
        return false;
    }

    /**
     * MÃ©todo para agregar un WebElement a la lista que se busca por ID
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * agragarle otro
     * @param webElemento que se desea agragar a la lista encontrada
     * @return cantidad de elementos de la lista
     */
    public boolean addElementsById(String elemento, WebElement webElemento) {
        try {
            return driver.findElements(By.id(elemento)).add(webElemento);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2205): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[addElementsById]");
        }
        return false;
    }

    /**
     * MÃ©todo para agregar un WebElement a la lista que se busca por ClassName
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * agragarle otro
     * @param webElemento que se desea agragar a la lista encontrada
     * @return cantidad de elementos de la lista
     */
    public boolean addElementsByClassName(String elemento, WebElement webElemento) {
        try {
            return driver.findElements(By.className(elemento)).add(webElemento);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2206): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[addElementsByClassName]");
        }
        return false;
    }

    /**
     * MÃ©todo para agregar un WebElement a la lista que se busca por
     * CssSelector
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * agragarle otro
     * @param webElemento que se desea agragar a la lista encontrada
     * @return cantidad de elementos de la lista
     */
    public boolean addElementsByCssSelector(String elemento, WebElement webElemento) {
        try {
            return driver.findElements(By.cssSelector(elemento)).add(webElemento);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2207): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[addElementsByCssSelector]");
        }
        return false;
    }

    /**
     * MÃ©todo para agregar un WebElement a la lista que se busca por LinkText
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * agragarle otro
     * @param webElemento que se desea agragar a la lista encontrada
     * @return cantidad de elementos de la lista
     */
    public boolean addElementsByLinkText(String elemento, WebElement webElemento) {
        try {
            return driver.findElements(By.linkText(elemento)).add(webElemento);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2208): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[addElementsByLinkText]");
        }
        return false;
    }

    /**
     * MÃ©todo para agregar un WebElement a la lista que se busca por
     * PartialLinkText
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * agragarle otro
     * @param webElemento que se desea agragar a la lista encontrada
     * @return cantidad de elementos de la lista
     */
    public boolean addElementsByPartialLinkText(String elemento, WebElement webElemento) {
        try {
            return driver.findElements(By.partialLinkText(elemento)).add(webElemento);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2209): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[addElementsByPartialLinkText]");
        }
        return false;
    }

    /**
     * MÃ©todo para agregar un WebElement a la lista que se busca por TagName
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * agragarle otro
     * @param webElemento que se desea agragar a la lista encontrada
     * @return cantidad de elementos de la lista
     */
    public boolean addElementsByTagName(String elemento, WebElement webElemento) {
        try {
            return driver.findElements(By.tagName(elemento)).add(webElemento);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2210): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[addElementsByTagName]");
        }
        return false;
    }

    /**
     * MÃ©todo para agregar un WebElement a la lista que se busca por Xpath
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * agragarle otro
     * @param webElemento que se desea agragar a la lista encontrada
     * @return cantidad de elementos de la lista
     */
    public boolean addElementsByXpath(String elemento, WebElement webElemento) {
        try {
            return driver.findElements(By.xpath(elemento)).add(webElemento);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2211): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[addElementsByXpath]");
        }
        return false;
    }

    /**
     * MÃ©todo para agregar un WebElement a la lista que se busca por Name
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * agragarle otro
     * @param index posiciÃ³n de la lisca en que desea adicionar el elemento
     * @param webElemento que se desea agragar a la lista encontrada
     */
    public void addElementsInByName(String elemento, int index, WebElement webElemento) {
        try {
            driver.findElements(By.name(elemento)).add(index, webElemento);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2212): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[addElementsInByName]");
        }
    }

    /**
     * MÃ©todo para agregar un WebElement a la lista que se busca por ID
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * agragarle otro
     * @param index posiciÃ³n de la lisca en que desea adicionar el elemento
     * @param webElemento que se desea agragar a la lista encontrada
     */
    public void addElementsInById(String elemento, int index, WebElement webElemento) {
        try {
            driver.findElements(By.id(elemento)).add(index, webElemento);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2213): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[addElementsInById]");
        }
    }

    /**
     * MÃ©todo para agregar un WebElement a la lista que se busca por ClassName
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * agragarle otro
     * @param index posiciÃ³n de la lisca en que desea adicionar el elemento
     * @param webElemento que se desea agragar a la lista encontrada
     */
    public void addElementsInByClassName(String elemento, int index, WebElement webElemento) {
        try {
            driver.findElements(By.className(elemento)).add(index, webElemento);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2214): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[addElementsInByClassName]");
        }
    }

    /**
     * MÃ©todo para agregar un WebElement a la lista que se busca por
     * CssSelector
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * agragarle otro
     * @param index posiciÃ³n de la lisca en que desea adicionar el elemento
     * @param webElemento que se desea agragar a la lista encontrada
     */
    public void addElementsInByCssSelector(String elemento, int index, WebElement webElemento) {
        try {
            driver.findElements(By.cssSelector(elemento)).add(index, webElemento);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2215): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[addElementsInByCssSelector]");
        }
    }

    /**
     * MÃ©todo para agregar un WebElement a la lista que se busca por LinkText
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * agragarle otro
     * @param index posiciÃ³n de la lisca en que desea adicionar el elemento
     * @param webElemento que se desea agragar a la lista encontrada
     */
    public void addElementsInByLinkText(String elemento, int index, WebElement webElemento) {
        try {
            driver.findElements(By.linkText(elemento)).add(index, webElemento);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2216): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[addElementsInByLinkText]");
        }
    }

    /**
     * MÃ©todo para agregar un WebElement a la lista que se busca por
     * PartialLinkText
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * agragarle otro
     * @param index posiciÃ³n de la lisca en que desea adicionar el elemento
     * @param webElemento que se desea agragar a la lista encontrada
     */
    public void addElementsInByPartialLinkText(String elemento, int index, WebElement webElemento) {
        try {
            driver.findElements(By.partialLinkText(elemento)).add(index, webElemento);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2217): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[addElementsInByPartialLinkText]");
        }
    }

    /**
     * MÃ©todo para agregar un WebElement a la lista que se busca por TagName
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * agragarle otro
     * @param index posiciÃ³n de la lisca en que desea adicionar el elemento
     * @param webElemento que se desea agragar a la lista encontrada
     */
    public void addElementsInByTagName(String elemento, int index, WebElement webElemento) {
        try {
            driver.findElements(By.tagName(elemento)).add(index, webElemento);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2218): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[addElementsInByTagName]");
        }
    }

    /**
     * MÃ©todo para agregar un WebElement a la lista que se busca por Xpath
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * agragarle otro
     * @param index posiciÃ³n de la lisca en que desea adicionar el elemento
     * @param webElemento que se desea agragar a la lista encontrada
     */
    public void addElementsInByXpath(String elemento, int index, WebElement webElemento) {
        try {
            driver.findElements(By.xpath(elemento)).add(index, webElemento);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2219): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[addElementsInByXpath]");
        }
    }

    /**
     * MÃ©todo para comparar un objeto a la lista que se busca por Name
     *
     * @param elemento el valor de los objetos que se desean buscar para evaluar
     * si contiene
     * @param obj elemento que se desea comparar con la lista
     * @return un valor booleano confirmando el contenido
     */
    public boolean containsElementsByName(String elemento, Object obj) {
        try {
            return driver.findElements(By.name(elemento)).contains(obj);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2220): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[containsElementsByName]");
        }
        return false;
    }

    /**
     * MÃ©todo para comparar un objeto a la lista que se busca por ID
     *
     * @param elemento el valor de los objetos que se desean buscar para evaluar
     * si contiene
     * @param obj elemento que se desea comparar con la lista
     * @return un valor booleano confirmando el contenido
     */
    public boolean containsElementsById(String elemento, Object obj) {
        try {
            return driver.findElements(By.id(elemento)).contains(obj);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2221): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[containsElementsById]");
        }
        return false;
    }

    /**
     * MÃ©todo para comparar un objeto a la lista que se busca por ClassName
     *
     * @param elemento el valor de los objetos que se desean buscar para evaluar
     * si contiene
     * @param obj elemento que se desea comparar con la lista
     * @return un valor booleano confirmando el contenido
     */
    public boolean containsElementsByClassName(String elemento, Object obj) {
        try {
            return driver.findElements(By.className(elemento)).contains(obj);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2222): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[containsElementsByClassName]");
        }
        return false;
    }

    /**
     * MÃ©todo para comparar un objeto a la lista que se busca por CssSelector
     *
     * @param elemento el valor de los objetos que se desean buscar para evaluar
     * si contiene
     * @param obj elemento que se desea comparar con la lista
     * @return un valor booleano confirmando el contenido
     */
    public boolean containsElementsByCssSelector(String elemento, Object obj) {
        try {
            return driver.findElements(By.cssSelector(elemento)).contains(obj);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2223): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[containsElementsByCssSelector]");
        }
        return false;
    }

    /**
     * MÃ©todo para comparar un objeto a la lista que se busca por LinkText
     *
     * @param elemento el valor de los objetos que se desean buscar para evaluar
     * si contiene
     * @param obj elemento que se desea comparar con la lista
     * @return un valor booleano confirmando el contenido
     */
    public boolean containsElementsByLinkText(String elemento, Object obj) {
        try {
            return driver.findElements(By.linkText(elemento)).contains(obj);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2224): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[containsElementsByLinkText]");
        }
        return false;
    }

    /**
     * MÃ©todo para comparar un objeto a la lista que se busca por
     * PartialLinkText
     *
     * @param elemento el valor de los objetos que se desean buscar para evaluar
     * si contiene
     * @param obj elemento que se desea comparar con la lista
     * @return un valor booleano confirmando el contenido
     */
    public boolean containsElementsByPartialLinkText(String elemento, Object obj) {
        try {
            return driver.findElements(By.partialLinkText(elemento)).contains(obj);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2225): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[containsElementsByPartialLinkText]");
        }
        return false;
    }

    /**
     * MÃ©todo para comparar un objeto a la lista que se busca por TagName
     *
     * @param elemento el valor de los objetos que se desean buscar para evaluar
     * si contiene
     * @param obj elemento que se desea comparar con la lista
     * @return un valor booleano confirmando el contenido
     */
    public boolean containsElementsByTagName(String elemento, Object obj) {
        try {
            return driver.findElements(By.tagName(elemento)).contains(obj);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2226): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[containsElementsByTagName]");
        }
        return false;
    }

    /**
     * MÃ©todo para comparar un objeto a la lista que se busca por Xpath
     *
     * @param elemento el valor de los objetos que se desean buscar para evaluar
     * si contiene
     * @param obj elemento que se desea comparar con la lista
     * @return un valor booleano confirmando el contenido
     */
    public boolean containsElementsByXpath(String elemento, Object obj) {
        try {
            return driver.findElements(By.xpath(elemento)).contains(obj);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2227): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[containsElementsByXpath]");
        }
        return false;
    }

    /**
     * MÃ©todo para saber si se encuentra vacia la lista que se busca por Name
     *
     * @param elemento el valor de los objetos que se desean buscar para evaluar
     * si se encuentra vacia
     * @return un valor booleano confirmando si se encuentra vacia la lista
     */
    public boolean isEmptyElementsByName(String elemento) {
        try {
            return driver.findElements(By.name(elemento)).isEmpty();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2228): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isEmptyElementsByName]");
        }
        return false;
    }

    /**
     * MÃ©todo para saber si se encuentra vacia la lista que se busca por ID
     *
     * @param elemento el valor de los objetos que se desean buscar para evaluar
     * si se encuentra vacia
     * @return un valor booleano confirmando si se encuentra vacia la lista
     */
    public boolean isEmptyElementsById(String elemento) {
        try {
            return driver.findElements(By.id(elemento)).isEmpty();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2229): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isEmptyElementsById]");
        }
        return false;
    }

    /**
     * MÃ©todo para saber si se encuentra vacia la lista que se busca por
     * ClassName
     *
     * @param elemento el valor de los objetos que se desean buscar para evaluar
     * si se encuentra vacia
     * @return un valor booleano confirmando si se encuentra vacia la lista
     */
    public boolean isEmptyElementsByClassName(String elemento) {
        try {
            return driver.findElements(By.className(elemento)).isEmpty();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2230): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isEmptyElementsByClassName]");
        }
        return false;
    }

    /**
     * MÃ©todo para saber si se encuentra vacia la lista que se busca por
     * CssSelector
     *
     * @param elemento el valor de los objetos que se desean buscar para evaluar
     * si se encuentra vacia
     * @return un valor booleano confirmando si se encuentra vacia la lista
     */
    public boolean isEmptyElementsByCssSelector(String elemento) {
        try {
            return driver.findElements(By.cssSelector(elemento)).isEmpty();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2231): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isEmptyElementsByCssSelector]");
        }
        return false;
    }

    /**
     * MÃ©todo para saber si se encuentra vacia la lista que se busca por
     * LinkText
     *
     * @param elemento el valor de los objetos que se desean buscar para evaluar
     * si se encuentra vacia
     * @return un valor booleano confirmando si se encuentra vacia la lista
     */
    public boolean isEmptyElementsByLinkText(String elemento) {
        try {
            return driver.findElements(By.linkText(elemento)).isEmpty();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2232): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isEmptyElementsByLinkText]");
        }
        return false;
    }

    /**
     * MÃ©todo para saber si se encuentra vacia la lista que se busca por
     * PartialLinkText
     *
     * @param elemento el valor de los objetos que se desean buscar para evaluar
     * si se encuentra vacia
     * @return un valor booleano confirmando si se encuentra vacia la lista
     */
    public boolean isEmptyElementsByPartialLinkText(String elemento) {
        try {
            return driver.findElements(By.partialLinkText(elemento)).isEmpty();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2233): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isEmptyElementsByPartialLinkText]");
        }
        return false;
    }

    /**
     * MÃ©todo para saber si se encuentra vacia la lista que se busca por
     * TagName
     *
     * @param elemento el valor de los objetos que se desean buscar para evaluar
     * si se encuentra vacia
     * @return un valor booleano confirmando si se encuentra vacia la lista
     */
    public boolean isEmptyElementsByTagName(String elemento) {
        try {
            return driver.findElements(By.tagName(elemento)).isEmpty();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2234): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isEmptyElementsByTagName]");
        }
        return false;
    }

    /**
     * MÃ©todo para saber si se encuentra vacia la lista que se busca por Xpath
     *
     * @param elemento el valor de los objetos que se desean buscar para evaluar
     * si se encuentra vacia
     * @return un valor booleano confirmando si se encuentra vacia la lista
     */
    public boolean isEmptyElementsByXpath(String elemento) {
        try {
            return driver.findElements(By.xpath(elemento)).isEmpty();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2235): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[isEmptyElementsByXpath]");
        }
        return false;
    }

    /**
     * MÃ©todo para comparar el objeto con los elementos de la lista que se
     * busca por Name
     *
     * @param elemento el valor de los objetos que se desean buscar para evaluar
     * si se encuentra vacia
     * @param obj elemento que se desea comparar en la lista
     * @return un valor booleano confirmando si exite un elemento igual al
     * objeto
     */
    public boolean equalsElementsByName(String elemento, Object obj) {
        try {
            return driver.findElements(By.name(elemento)).equals(obj);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2236): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[equalsElementsByName]");
        }
        return false;
    }

    /**
     * MÃ©todo para comparar el objeto con los elementos de la lista que se
     * busca por ID
     *
     * @param elemento el valor de los objetos que se desean buscar para evaluar
     * si se encuentra vacia
     * @param obj elemento que se desea comparar en la lista
     * @return un valor booleano confirmando si exite un elemento igual al
     * objeto
     */
    public boolean equalsElementsById(String elemento, Object obj) {
        try {
            return driver.findElements(By.id(elemento)).equals(obj);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2237): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[equalsElementsById]");
        }
        return false;
    }

    /**
     * MÃ©todo para comparar el objeto con los elementos de la lista que se
     * busca por ClassName
     *
     * @param elemento el valor de los objetos que se desean buscar para evaluar
     * si se encuentra vacia
     * @param obj elemento que se desea comparar en la lista
     * @return un valor booleano confirmando si exite un elemento igual al
     * objeto
     */
    public boolean equalsElementsByClassName(String elemento, Object obj) {
        try {
            return driver.findElements(By.className(elemento)).equals(obj);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2238): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[equalsElementsByClassName]");
        }
        return false;
    }

    /**
     * MÃ©todo para comparar el objeto con los elementos de la lista que se
     * busca por CssSelector
     *
     * @param elemento el valor de los objetos que se desean buscar para evaluar
     * si se encuentra vacia
     * @param obj elemento que se desea comparar en la lista
     * @return un valor booleano confirmando si exite un elemento igual al
     * objeto
     */
    public boolean equalsElementsByCssSelector(String elemento, Object obj) {
        try {
            return driver.findElements(By.cssSelector(elemento)).equals(obj);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2239): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[equalsElementsByCssSelector]");
        }
        return false;
    }

    /**
     * MÃ©todo para comparar el objeto con los elementos de la lista que se
     * busca por LinkText
     *
     * @param elemento el valor de los objetos que se desean buscar para evaluar
     * si se encuentra vacia
     * @param obj elemento que se desea comparar en la lista
     * @return un valor booleano confirmando si exite un elemento igual al
     * objeto
     */
    public boolean equalsElementsByLinkText(String elemento, Object obj) {
        try {
            return driver.findElements(By.linkText(elemento)).equals(obj);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2240): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[equalsElementsByLinkText]");
        }
        return false;
    }

    /**
     * MÃ©todo para comparar el objeto con los elementos de la lista que se
     * busca por PartialLinkText
     *
     * @param elemento el valor de los objetos que se desean buscar para evaluar
     * si se encuentra vacia
     * @param obj elemento que se desea comparar en la lista
     * @return un valor booleano confirmando si exite un elemento igual al
     * objeto
     */
    public boolean equalsElementsByPartialLinkText(String elemento, Object obj) {
        try {
            return driver.findElements(By.partialLinkText(elemento)).equals(obj);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2241): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[equalsElementsByPartialLinkText]");
        }
        return false;
    }

    /**
     * MÃ©todo para comparar el objeto con los elementos de la lista que se
     * busca por TagName
     *
     * @param elemento el valor de los objetos que se desean buscar para evaluar
     * si se encuentra vacia
     * @param obj elemento que se desea comparar en la lista
     * @return un valor booleano confirmando si exite un elemento igual al
     * objeto
     */
    public boolean equalsElementsByTagName(String elemento, Object obj) {
        try {
            return driver.findElements(By.tagName(elemento)).equals(obj);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2242): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[equalsElementsByTagName]");
        }
        return false;
    }

    /**
     * MÃ©todo para comparar el objeto con los elementos de la lista que se
     * busca por Xpath
     *
     * @param elemento el valor de los objetos que se desean buscar para evaluar
     * si se encuentra vacia
     * @param obj elemento que se desea comparar en la lista
     * @return un valor booleano confirmando si exite un elemento igual al
     * objeto
     */
    public boolean equalsElementsByXpath(String elemento, Object obj) {
        try {
            return driver.findElements(By.xpath(elemento)).equals(obj);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2243): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[equalsElementsByXpath]");
        }
        return false;
    }

    /**
     * MÃ©todo para remover el objeto de la lista de elementos que se busca por
     * Name
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * removerlo
     *
     * @param obj elemento que se desea remover de la lista
     * @return un valor booleano confirmando si removiÃ³ el objeto de la lista
     */
    public boolean removeElementsByName(String elemento, Object obj) {
        try {
            return driver.findElements(By.name(elemento)).remove(obj);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2244): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[removeElementsByName]");
        }
        return false;
    }

    /**
     * MÃ©todo para remover el objeto de la lista de elementos que se busca por
     * ID
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * removerlo
     *
     * @param obj elemento que se desea remover de la lista
     * @return un valor booleano confirmando si removiÃ³ el objeto de la lista
     */
    public boolean removeElementsById(String elemento, Object obj) {
        try {
            return driver.findElements(By.id(elemento)).remove(obj);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2245): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[removeElementsById]");
        }
        return false;
    }

    /**
     * MÃ©todo para remover el objeto de la lista de elementos que se busca por
     * ClassName
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * removerlo
     *
     * @param obj elemento que se desea remover de la lista
     * @return un valor booleano confirmando si removiÃ³ el objeto de la lista
     */
    public boolean removeElementsByClassName(String elemento, Object obj) {
        try {
            return driver.findElements(By.className(elemento)).remove(obj);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2246): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[removeElementsByClassName]");
        }
        return false;
    }

    /**
     * MÃ©todo para remover el objeto de la lista de elementos que se busca por
     * CssSelector
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * removerlo
     *
     * @param obj elemento que se desea remover de la lista
     * @return un valor booleano confirmando si removiÃ³ el objeto de la lista
     */
    public boolean removeElementsByCssSelector(String elemento, Object obj) {
        try {
            return driver.findElements(By.cssSelector(elemento)).remove(obj);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2247): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[removeElementsByCssSelector]");
        }
        return false;
    }

    /**
     * MÃ©todo para remover el objeto de la lista de elementos que se busca por
     * LinkText
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * removerlo
     *
     * @param obj elemento que se desea remover de la lista
     * @return un valor booleano confirmando si removiÃ³ el objeto de la lista
     */
    public boolean removeElementsByLinkText(String elemento, Object obj) {
        try {
            return driver.findElements(By.linkText(elemento)).remove(obj);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2248): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[removeElementsByLinkText]");
        }
        return false;
    }

    /**
     * MÃ©todo para remover el objeto de la lista de elementos que se busca por
     * PartialLinkText
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * removerlo
     *
     * @param obj elemento que se desea remover de la lista
     * @return un valor booleano confirmando si removiÃ³ el objeto de la lista
     */
    public boolean removeElementsByPartialLinkText(String elemento, Object obj) {
        try {
            return driver.findElements(By.partialLinkText(elemento)).remove(obj);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2249): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[removeElementsByPartialLinkText]");
        }
        return false;
    }

    /**
     * MÃ©todo para remover el objeto de la lista de elementos que se busca por
     * TagName
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * removerlo
     *
     * @param obj elemento que se desea remover de la lista
     * @return un valor booleano confirmando si removiÃ³ el objeto de la lista
     */
    public boolean removeElementsByTagName(String elemento, Object obj) {
        try {
            return driver.findElements(By.tagName(elemento)).remove(obj);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2250): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[removeElementsByTagName]");
        }
        return false;
    }

    /**
     * MÃ©todo para remover el objeto de la lista de elementos que se busca por
     * Xpath
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * removerlo
     *
     * @param obj elemento que se desea remover de la lista
     * @return un valor booleano confirmando si removiÃ³ el objeto de la lista
     */
    public boolean removeElementsByXpath(String elemento, Object obj) {
        try {
            return driver.findElements(By.xpath(elemento)).remove(obj);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2251): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[removeElementsByXpath]");
        }
        return false;
    }

    /**
     * MÃ©todo para obtener el objeto de la lista de elementos que se busca por
     * Name
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * obtenerlo
     * @param index posiciÃ³n del elemento que se desea obtener
     * @return un valor booleano confirmando si removiÃ³ el objeto de la lista
     */
    public WebElement getElementsByName(String elemento, int index) {
        try {
            return driver.findElements(By.name(elemento)).get(index);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2252): No Fue Posible Encontrar El Elemento [" + elemento + "]::[getElementsByName]");
        }
        return null;
    }

    /**
     * MÃ©todo para obtener el objeto de la lista de elementos que se busca por
     * ID
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * obtenerlo
     * @param index posiciÃ³n del elemento que se desea obtener
     * @return un valor booleano confirmando si removiÃ³ el objeto de la lista
     */
    public WebElement getElementsById(String elemento, int index) {
        try {
            return driver.findElements(By.id(elemento)).get(index);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2253): No Fue Posible Encontrar El Elemento [" + elemento + "]::[getElementsById]");
        }
        return null;
    }

    /**
     * MÃ©todo para obtener el objeto de la lista de elementos que se busca por
     * ClassName
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * obtenerlo
     * @param index posiciÃ³n del elemento que se desea obtener
     * @return un valor booleano confirmando si removiÃ³ el objeto de la lista
     */
    public WebElement getElementsByClassName(String elemento, int index) {
        try {
            return driver.findElements(By.className(elemento)).get(index);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2254): No Fue Posible Encontrar El Elemento [" + elemento + "]::[getElementsByClassName]");
        }
        return null;
    }

    /**
     * MÃ©todo para obtener el objeto de la lista de elementos que se busca por
     * CssSelector
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * obtenerlo
     * @param index posiciÃ³n del elemento que se desea obtener
     * @return un valor booleano confirmando si removiÃ³ el objeto de la lista
     */
    public WebElement getElementsByCssSelector(String elemento, int index) {
        try {
            return driver.findElements(By.cssSelector(elemento)).get(index);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2255): No Fue Posible Encontrar El Elemento [" + elemento + "]::[elementByTagName]");
        }
        return null;
    }

    /**
     * MÃ©todo para obtener el objeto de la lista de elementos que se busca por
     * LinkText
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * obtenerlo
     * @param index posiciÃ³n del elemento que se desea obtener
     * @return un valor booleano confirmando si removiÃ³ el objeto de la lista
     */
    public WebElement getElementsByLinkText(String elemento, int index) {
        try {
            return driver.findElements(By.linkText(elemento)).get(index);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2256): No Fue Posible Encontrar El Elemento [" + elemento + "]::[getElementsByLinkText]");
        }
        return null;
    }

    /**
     * MÃ©todo para obtener el objeto de la lista de elementos que se busca por
     * PartialLinkText
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * obtenerlo
     * @param index posiciÃ³n del elemento que se desea obtener
     * @return un valor booleano confirmando si removiÃ³ el objeto de la lista
     */
    public WebElement getElementsByPartialLinkText(String elemento, int index) {
        try {
            return driver.findElements(By.partialLinkText(elemento)).get(index);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2257): No Fue Posible Encontrar El Elemento [" + elemento + "]::[getElementsByPartialLinkText]");
        }
        return null;
    }

    /**
     * MÃ©todo para obtener el objeto de la lista de elementos que se busca por
     * TagName
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * obtenerlo
     * @param index posiciÃ³n del elemento que se desea obtener
     * @return un valor booleano confirmando si removiÃ³ el objeto de la lista
     */
    public WebElement getElementsByTagName(String elemento, int index) {
        try {
            return driver.findElements(By.tagName(elemento)).get(index);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2258): No Fue Posible Encontrar El Elemento [" + elemento + "]::[getElementsByTagName]");
        }
        return null;
    }

    /**
     * MÃ©todo para obtener el objeto de la lista de elementos que se busca por
     * Xpath
     *
     * @param elemento el valor de los objetos que se desean buscar para
     * obtenerlo
     * @param index posiciÃ³n del elemento que se desea obtener
     * @return un valor booleano confirmando si removiÃ³ el objeto de la lista
     */
    public WebElement getElementsByXpath(String elemento, int index) {
        try {
            return driver.findElements(By.xpath(elemento)).get(index);
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2259): No Fue Posible Encontrar El Elemento [" + elemento + "]::[getElementsByXpath]");
        }
        return null;
    }

    /**
     * MÃ©todo para realizar doubleClick al elemento buscandolo por Name
     *
     * @param elemento el valor del objeto que se desea realizar doubleClick
     */
    public void doubleClickName(String elemento) {
        try {
            action.doubleClick(driver.findElement(By.name(elemento))).perform();
        } catch (Exception e) {
            //
            System.out.println("Error DESKTOP(2260): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[doubleClickName]");
        }
    }

    /**
     * MÃ©todo para realizar doubleClick al elemento buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea realizar doubleClick
     */
    public void doubleClickId(String elemento) {
        try {
            action.doubleClick(driver.findElement(By.id(elemento))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2261): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[doubleClickId]");
        }
    }

    /**
     * MÃ©todo para realizar doubleClick al elemento buscandolo por ClassName
     *
     * @param elemento el valor del objeto que se desea realizar doubleClick
     */
    public void doubleClickClassName(String elemento) {
        try {
            action.doubleClick(driver.findElement(By.className(elemento))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2262): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[doubleClickClassName]");
        }
    }

    /**
     * MÃ©todo para realizar doubleClick al elemento buscandolo por CssSelector
     *
     * @param elemento el valor del objeto que se desea realizar doubleClick
     */
    public void doubleClickCssSelector(String elemento) {
        try {
            action.doubleClick(driver.findElement(By.cssSelector(elemento))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2263): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[doubleClickCssSelector]");
        }
    }

    /**
     * MÃ©todo para realizar doubleClick al elemento buscandolo por LinkText
     *
     * @param elemento el valor del objeto que se desea realizar doubleClick
     */
    public void doubleClickLinkText(String elemento) {
        try {
            action.doubleClick(driver.findElement(By.linkText(elemento))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2264): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[doubleClickLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar doubleClick al elemento buscandolo por
     * PartialLinkText
     *
     * @param elemento el valor del objeto que se desea realizar doubleClick
     */
    public void doubleClickPartialLinkText(String elemento) {
        try {
            action.doubleClick(driver.findElement(By.partialLinkText(elemento))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2265): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[doubleClickPartialLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar doubleClick al elemento buscandolo por TagName
     *
     * @param elemento el valor del objeto que se desea realizar doubleClick
     */
    public void doubleClickTagName(String elemento) {
        try {
            action.doubleClick(driver.findElement(By.tagName(elemento))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2266): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[doubleClickTagName]");
        }
    }

    /**
     * MÃ©todo para realizar doubleClick al elemento buscandolo por Xpath
     *
     * @param elemento el valor del objeto que se desea realizar doubleClick
     */
    public void doubleClickXpath(String elemento) {
        try {
            action.doubleClick(driver.findElement(By.xpath(elemento))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2267): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[doubleClickXpath]");
        }
    }

    /**
     * MÃ©todo para realizar doubleClick al elemento ingresado
     *
     * @param elemento el valor del objeto que se desea realizar doubleClick
     */
    public void doubleClickElement(WebElement elemento) {
        try {
            action.doubleClick(elemento).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2268): No Fue Posible Realizar La Accion Sobre El Elemento [" + getAttributeValue(elemento) + "]::[doubleClickElement]");
        }
    }

    /**
     * MÃ©todo para realizar moveToElement al elemento buscandolo por Name
     *
     * @param elemento el valor del objeto que se desea realizar moveToElement
     */
    public void moveToElementName(String elemento) {
        try {
            action.moveToElement(driver.findElement(By.name(elemento))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2269): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[moveToElementName]");
        }
    }

    /**
     * MÃ©todo para realizar moveToElement al elemento buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea realizar moveToElement
     */
    public void moveToElementId(String elemento) {
        try {
            action.moveToElement(driver.findElement(By.id(elemento))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2270): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[moveToElementId]");
        }
    }

    /**
     * MÃ©todo para realizar moveToElement al elemento buscandolo por ClassName
     *
     * @param elemento el valor del objeto que se desea realizar moveToElement
     */
    public void moveToElementClassName(String elemento) {
        try {
            action.moveToElement(driver.findElement(By.className(elemento))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2271): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[moveToElementClassName]");
        }
    }

    /**
     * MÃ©todo para realizar moveToElement al elemento buscandolo por
     * CssSelector
     *
     * @param elemento el valor del objeto que se desea realizar moveToElement
     */
    public void moveToElementCssSelector(String elemento) {
        try {
            action.moveToElement(driver.findElement(By.cssSelector(elemento))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2272): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[moveToElementCssSelector]");
        }
    }

    /**
     * MÃ©todo para realizar moveToElement al elemento buscandolo por LinkText
     *
     * @param elemento el valor del objeto que se desea realizar moveToElement
     */
    public void moveToElementLinkText(String elemento) {
        try {
            action.moveToElement(driver.findElement(By.linkText(elemento))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2273): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[moveToElementLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar moveToElement al elemento buscandolo por
     * PartialLinkText
     *
     * @param elemento el valor del objeto que se desea realizar moveToElement
     */
    public void moveToElementPartialLinkText(String elemento) {
        try {
            action.moveToElement(driver.findElement(By.partialLinkText(elemento))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2274): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[moveToElementPartialLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar moveToElement al elemento buscandolo por TagName
     *
     * @param elemento el valor del objeto que se desea realizar moveToElement
     */
    public void moveToElementTagName(String elemento) {
        try {
            action.moveToElement(driver.findElement(By.tagName(elemento))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2275): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[moveToElementTagName]");
        }
    }

    /**
     * MÃ©todo para realizar moveToElement al elemento buscandolo por Xpath
     *
     * @param elemento el valor del objeto que se desea realizar moveToElement
     */
    public void moveToElementXpath(String elemento) {
        try {
            action.moveToElement(driver.findElement(By.xpath(elemento))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2276): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[moveToElementXpath]");
        }
    }

    /**
     * MÃ©todo para realizar moveToElement al elemento ingresado
     *
     * @param elemento el valor del objeto que se desea realizar moveToElement
     */
    public void moveToElementElement(WebElement elemento) {
        try {
            action.moveToElement(elemento).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2277): No Fue Posible Realizar La Accion Sobre El Elemento [" + getAttributeValue(elemento) + "]::[moveToElementElement]");
        }
    }

    /**
     * MÃ©todo para realizar rightClick al elemento buscandolo por Name
     *
     * @param elemento el valor del objeto que se desea realizar rightClick
     */
    public void rightClickName(String elemento) {
        try {
            action.contextClick(driver.findElement(By.name(elemento))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2278): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[rightClickName]");
        }
    }

    /**
     * MÃ©todo para realizar rightClick al elemento buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea realizar rightClick
     */
    public void rightClickId(String elemento) {
        try {
            action.contextClick(driver.findElement(By.id(elemento))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2279): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[rightClickId]");
        }
    }

    /**
     * MÃ©todo para realizar rightClick al elemento buscandolo por ClassName
     *
     * @param elemento el valor del objeto que se desea realizar rightClick
     */
    public void rightClickClassName(String elemento) {
        try {
            action.contextClick(driver.findElement(By.className(elemento))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2280): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[rightClickClassName]");
        }
    }

    /**
     * MÃ©todo para realizar rightClick al elemento buscandolo por CssSelector
     *
     * @param elemento el valor del objeto que se desea realizar rightClick
     */
    public void rightClickCssSelector(String elemento) {
        try {
            action.contextClick(driver.findElement(By.cssSelector(elemento))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2281): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[rightClickCssSelector]");
        }
    }

    /**
     * MÃ©todo para realizar rightClick al elemento buscandolo por LinkText
     *
     * @param elemento el valor del objeto que se desea realizar rightClick
     */
    public void rightClickLinkText(String elemento) {
        try {
            action.contextClick(driver.findElement(By.linkText(elemento))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2282): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[rightClickLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar rightClick al elemento buscandolo por
     * PartialLinkText
     *
     * @param elemento el valor del objeto que se desea realizar rightClick
     */
    public void rightClickPartialLinkText(String elemento) {
        try {
            action.contextClick(driver.findElement(By.partialLinkText(elemento))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2283): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[rightClickPartialLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar rightClick al elemento buscandolo por TagName
     *
     * @param elemento el valor del objeto que se desea realizar rightClick
     */
    public void rightClickTagName(String elemento) {
        try {
            action.contextClick(driver.findElement(By.tagName(elemento))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2284): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[rightClickTagName]");
        }
    }

    /**
     * MÃ©todo para realizar rightClick al elemento buscandolo por Xpath
     *
     * @param elemento el valor del objeto que se desea realizar rightClick
     */
    public void rightClickXpath(String elemento) {
        try {
            action.contextClick(driver.findElement(By.xpath(elemento))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2285): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[rightClickXpath]");
        }
    }

    /**
     * MÃ©todo para realizar rightClick al elemento ingresado
     *
     * @param elemento el valor del objeto que se desea realizar rightClick
     */
    public void rightClickElement(WebElement elemento) {
        try {
            action.contextClick(elemento).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2286): No Fue Posible Realizar La Accion Sobre El Elemento [" + getAttributeValue(elemento) + "]::[rightClickElement]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por Name
     *
     * @param elemento el valor del objeto que se desea arrastrar
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropNameName(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.name(elemento)), driver.findElement(By.name(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2287): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropNameName]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por Name
     *
     * @param elemento el valor del objeto que se desea arrastrar
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropNameId(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.name(elemento)), driver.findElement(By.id(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2288): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropNameId]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por Name
     *
     * @param elemento el valor del objeto que se desea arrastrar
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropNameClassName(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.name(elemento)), driver.findElement(By.className(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2289): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropNameClassName]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por Name
     *
     * @param elemento el valor del objeto que se desea arrastrar
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropNameCssSelector(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.name(elemento)), driver.findElement(By.cssSelector(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2290): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropNameCssSelector]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por Name
     *
     * @param elemento el valor del objeto que se desea arrastrar
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropNameLinkText(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.name(elemento)), driver.findElement(By.linkText(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2291): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropNameLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por Name
     *
     * @param elemento el valor del objeto que se desea arrastrar
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropNamePartialLinkText(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.name(elemento)), driver.findElement(By.partialLinkText(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2292): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropNamePartialLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por Name
     *
     * @param elemento el valor del objeto que se desea arrastrar
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropNameTagName(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.name(elemento)), driver.findElement(By.tagName(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2293): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropNameTagName]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por Name
     *
     * @param elemento el valor del objeto que se desea arrastrar
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropNameXpath(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.name(elemento)), driver.findElement(By.xpath(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2294): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropNameXpath]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por Name
     *
     * @param elemento el valor del objeto que se desea arrastrar
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropNameElement(String elemento, WebElement elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.name(elemento)), elemento2).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2295): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropNameElement]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropIdName(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.id(elemento)), driver.findElement(By.name(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2296): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropIdName]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropIdId(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.id(elemento)), driver.findElement(By.id(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2297): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropIdId]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropIdClassName(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.id(elemento)), driver.findElement(By.className(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2298): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropIdClassName]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropIdCssSelector(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.id(elemento)), driver.findElement(By.cssSelector(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2299): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropIdCssSelector]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropIdLinkText(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.id(elemento)), driver.findElement(By.linkText(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2300): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropIdLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropIdPartialLinkText(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.id(elemento)), driver.findElement(By.partialLinkText(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2301): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropIdPartialLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropIdTagName(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.id(elemento)), driver.findElement(By.tagName(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2302): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropIdTagName]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropIdXpath(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.id(elemento)), driver.findElement(By.xpath(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2303): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropIdXpath]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por ID
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropIdElement(String elemento, WebElement elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.id(elemento)), elemento2).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2304): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropIdElement]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por className
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropClassNameName(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.className(elemento)), driver.findElement(By.name(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2305): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropClassNameName]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por className
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropClassNameId(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.className(elemento)), driver.findElement(By.id(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2306): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropClassNameId]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por className
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropClassNameClassName(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.className(elemento)), driver.findElement(By.className(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2307): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropClassNameClassName]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por className
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropClassNameCssSelector(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.className(elemento)), driver.findElement(By.cssSelector(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2308): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropClassNameCssSelector]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por className
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropClassNameLinkText(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.className(elemento)), driver.findElement(By.linkText(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2309): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropClassNameLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por className
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropClassNamePartialLinkText(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.className(elemento)), driver.findElement(By.partialLinkText(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2310): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropClassNamePartialLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por className
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropClassNameTagName(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.className(elemento)), driver.findElement(By.tagName(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2311): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropClassNameTagName]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por className
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropClassNameXpath(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.className(elemento)), driver.findElement(By.xpath(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2312): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropClassNameXpath]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por className
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropClassNameElement(String elemento, WebElement elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.className(elemento)), elemento2).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2313): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropClassNameElement]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por CssSelector
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropCssSelectorName(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.cssSelector(elemento)), driver.findElement(By.name(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2314): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropCssSelectorName]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por CssSelector
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropCssSelectorId(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.cssSelector(elemento)), driver.findElement(By.id(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2315): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropCssSelectorId]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por CssSelector
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropCssSelectorClassName(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.cssSelector(elemento)), driver.findElement(By.className(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2316): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropCssSelectorClassName]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por CssSelector
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropCssSelectorCssSelector(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.cssSelector(elemento)), driver.findElement(By.cssSelector(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2317): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropCssSelectorCssSelector]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por CssSelector
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropCssSelectorLinkText(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.cssSelector(elemento)), driver.findElement(By.linkText(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2318): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropCssSelectorLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por CssSelector
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropCssSelectorPartialLinkText(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.cssSelector(elemento)), driver.findElement(By.partialLinkText(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2319): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropCssSelectorPartialLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por CssSelector
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropCssSelectorTagName(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.cssSelector(elemento)), driver.findElement(By.tagName(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2320): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropCssSelectorTagName]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por CssSelector
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropCssSelectorXpath(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.cssSelector(elemento)), driver.findElement(By.xpath(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2321): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropCssSelectorXpath]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por CssSelector
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropCssSelectorElement(String elemento, WebElement elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.cssSelector(elemento)), elemento2).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2322): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropCssSelectorElement]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por linkText
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropLinkTextName(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.linkText(elemento)), driver.findElement(By.name(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2323): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropLinkTextName]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por linkText
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropLinkTextId(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.linkText(elemento)), driver.findElement(By.id(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2334): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropLinkTextId]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por linkText
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropLinkTextClassName(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.linkText(elemento)), driver.findElement(By.className(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2325): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropLinkTextClassName]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por linkText
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropLinkTextCssSelector(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.linkText(elemento)), driver.findElement(By.cssSelector(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2326): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropLinkTextCssSelector]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por linkText
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropLinkTextLinkText(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.linkText(elemento)), driver.findElement(By.linkText(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2327): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropLinkTextLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por linkText
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropLinkTextPartialLinkText(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.linkText(elemento)), driver.findElement(By.partialLinkText(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2328): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropLinkTextPartialLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por linkText
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropLinkTextTagName(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.linkText(elemento)), driver.findElement(By.tagName(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2329): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropLinkTextTagName]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por linkText
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropLinkTextXpath(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.linkText(elemento)), driver.findElement(By.xpath(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2330): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropLinkTextXpath]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por linkText
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropLinkTextElement(String elemento, WebElement elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.linkText(elemento)), elemento2).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2331): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropLinkTextElement]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por
     * partialLinkText
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropPartialLinkTextName(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.partialLinkText(elemento)), driver.findElement(By.name(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2332): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropPartialLinkTextName]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por
     * partialLinkText
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropPartialLinkTextId(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.partialLinkText(elemento)), driver.findElement(By.id(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2333): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropPartialLinkTextId]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por
     * partialLinkText
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropPartialLinkTextClassName(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.partialLinkText(elemento)), driver.findElement(By.className(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2334): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropPartialLinkTextClassName]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por
     * partialLinkText
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropPartialLinkTextCssSelector(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.partialLinkText(elemento)), driver.findElement(By.cssSelector(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2335): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropPartialLinkTextCssSelector]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por
     * partialLinkText
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropPartialLinkTextLinkText(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.partialLinkText(elemento)), driver.findElement(By.linkText(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2336): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropPartialLinkTextLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por
     * partialLinkText
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropPartialLinkTextPartialLinkText(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.partialLinkText(elemento)), driver.findElement(By.partialLinkText(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2337): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropPartialLinkTextPartialLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por
     * partialLinkText
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropPartialLinkTextTagName(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.partialLinkText(elemento)), driver.findElement(By.tagName(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2338): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropPartialLinkTextTagName]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por
     * partialLinkText
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropPartialLinkTextXpath(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.partialLinkText(elemento)), driver.findElement(By.xpath(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2339): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropPartialLinkTextXpath]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por
     * partialLinkText
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropPartialLinkTextElement(String elemento, WebElement elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.partialLinkText(elemento)), elemento2).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2340): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropPartialLinkTextElement]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por xpath
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropXpathName(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.xpath(elemento)), driver.findElement(By.name(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2341): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropXpathName]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por xpath
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropXpathId(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.xpath(elemento)), driver.findElement(By.id(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2342): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropXpathId]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por xpath
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropXpathClassName(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.xpath(elemento)), driver.findElement(By.className(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2343): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropXpathClassName]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por xpath
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropXpathCssSelector(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.xpath(elemento)), driver.findElement(By.cssSelector(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2344): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropXpathCssSelector]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por xpath
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropXpathLinkText(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.xpath(elemento)), driver.findElement(By.linkText(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2345): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropXpathLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por xpath
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropXpathPartialLinkText(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.xpath(elemento)), driver.findElement(By.partialLinkText(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2346): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropXpathPartialLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por xpath
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropXpathTagName(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.xpath(elemento)), driver.findElement(By.tagName(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2347): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropXpathTagName]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por xpath
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropXpathXpath(String elemento, String elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.xpath(elemento)), driver.findElement(By.xpath(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2348): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropXpathXpath]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por xpath
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropXpathElement(String elemento, WebElement elemento2) {
        try {
            action.dragAndDrop(driver.findElement(By.xpath(elemento)), elemento2).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2349): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropXpathElement]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por WebElement
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropElementName(WebElement elemento, String elemento2) {
        try {
            action.dragAndDrop(elemento, driver.findElement(By.name(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2350): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropElementName]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por WebElement
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropElementId(WebElement elemento, String elemento2) {
        try {
            action.dragAndDrop(elemento, driver.findElement(By.id(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2351): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropElementId]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por WebElement
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropElementClassName(WebElement elemento, String elemento2) {
        try {
            action.dragAndDrop(elemento, driver.findElement(By.className(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2352): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropElementClassName]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por WebElement
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropElementCssSelector(WebElement elemento, String elemento2) {
        try {
            action.dragAndDrop(elemento, driver.findElement(By.cssSelector(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2353): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropElementCssSelector]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por WebElement
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropElementLinkText(WebElement elemento, String elemento2) {
        try {
            action.dragAndDrop(elemento, driver.findElement(By.linkText(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2354): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropElementLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por WebElement
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropElementPartialLinkText(WebElement elemento, String elemento2) {
        try {
            action.dragAndDrop(elemento, driver.findElement(By.partialLinkText(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2355): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropElementPartialLinkText]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por WebElement
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropElementTagName(WebElement elemento, String elemento2) {
        try {
            action.dragAndDrop(elemento, driver.findElement(By.tagName(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2356): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropElementTagName]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por WebElement
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropElementXpath(WebElement elemento, String elemento2) {
        try {
            action.dragAndDrop(elemento, driver.findElement(By.xpath(elemento2))).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2357): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropElementXpath]");
        }
    }

    /**
     * MÃ©todo para realizar dragAndDrop al elemento buscandolo por WebElement
     *
     * @param elemento el valor del objeto que se desea realizar dragAndDrop
     * @param elemento2 el valor del objeto donde se desea soltar
     */
    public void dragAndDropElementElement(WebElement elemento, WebElement elemento2) {
        try {
            action.dragAndDrop(elemento, elemento2).perform();
        } catch (Exception e) {

            System.out.println("Error DESKTOP(2358): No Fue Posible Realizar La Accion Sobre El Elemento [" + elemento + "]::[dragAndDropElementElement]");
        }
    }

    /**
     * MÃ©todo para realizar la catura de la imagen de un elemento que se esta
     * buscando por Name
     *
     * @param elemento valor del name del elemento a buscar
     *
     */
    public void CaptureRegionScreenByName(String elemento) {
        WebElement element = driver.findElement(By.name(elemento));
        Date curDate = new Date();
        //SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh-mm-ss");
        String DateToStr = format.format(curDate);
        try {
            File compFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage image = ImageIO.read(compFile);

            // Get the location of mouse pointer
            java.awt.Point punto = MouseInfo.getPointerInfo().getLocation();

            // Crop the entire page screenshot to get only element screenshot
            BufferedImage elmImg = image.getSubimage(((int) punto.getX() - (element.getSize().getWidth() / 2)), ((int) punto.getY() - (element.getSize().getHeight() / 2)), element.getSize().getWidth() + 1, element.getSize().getHeight() + 1);
            ImageIO.write(elmImg, "png", compFile);

            // Copy the element screenshot to disk
            File screenshotLocation = new File(System.getProperty("user.dir") + "\\Evidencia\\" + "\\Escritorio\\" + DateToStr + ".png ");
            File ruta = screenshotLocation;
            System.out.print(ruta + "captura region ");
            FileUtils.copyFile(compFile, screenshotLocation);
            System.out.println("");
        } catch (IOException e) {

            System.out.println("Error DESKTOP (2359): No Fue Posible Realizar La Captura Del Elemento [" + elemento + "]::[CaptureRegionScreenByName]" + "PRUEBA");
        }

    }

    /**
     * MÃ©todo para realizar la catura de la imagen de un elemento que se esta
     * buscando por Id
     *
     * @param elemento valor del id del elemento a buscar
     *
     */
    public void CaptureRegionScreenById(String elemento) {
        WebElement element = driver.findElement(By.id(elemento));
        Date curDate = new Date();
        //SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh-mm-ss");
        String DateToStr = format.format(curDate);
        try {
            File compFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage image = ImageIO.read(compFile);

            // Get the location of mouse pointer
            java.awt.Point punto = MouseInfo.getPointerInfo().getLocation();

            // Crop the entire page screenshot to get only element screenshot
            BufferedImage elmImg = image.getSubimage(((int) punto.getX() - (element.getSize().getWidth() / 2)), ((int) punto.getY() - (element.getSize().getHeight() / 2)), element.getSize().getWidth() + 1, element.getSize().getHeight() + 1);
            ImageIO.write(elmImg, "png", compFile);

            // Copy the element screenshot to disk
            File screenshotLocation = new File(System.getProperty("user.dir") + "\\Evidencia\\" + "\\Escritorio\\" + DateToStr + ".png ");
            File ruta = screenshotLocation;
            System.out.print(ruta + "captura region ");
            FileUtils.copyFile(compFile, screenshotLocation);

        } catch (IOException e) {

            System.out.println("Error DESKTOP (2360): No Fue Posible Realizar La Captura Del Elemento [" + elemento + "]::[CaptureRegionScreenById]" + e.getMessage());
        }

    }

    /**
     * MÃ©todo para realizar la catura de la imagen de un elemento que se esta
     * buscando por ClassName
     *
     * @param elemento valor del className del elemento a buscar
     *
     */
    public void CaptureRegionScreenByClassName(String elemento) {
        WebElement element = driver.findElement(By.className(elemento));
        Date curDate = new Date();
        //SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh-mm-ss");
        String DateToStr = format.format(curDate);
        try {

            File compFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage image = ImageIO.read(compFile);

            // Get the location of mouse pointer
            java.awt.Point punto = MouseInfo.getPointerInfo().getLocation();

            // Crop the entire page screenshot to get only element screenshot
            BufferedImage elmImg = image.getSubimage(((int) punto.getX() - (element.getSize().getWidth() / 2)), ((int) punto.getY() - (element.getSize().getHeight() / 2)), element.getSize().getWidth() + 1, element.getSize().getHeight() + 1);
            ImageIO.write(elmImg, "png", compFile);

            // Copy the element screenshot to disk
            File screenshotLocation = new File(System.getProperty("user.dir") + "\\Evidencia\\" + "\\Escritorio\\" + DateToStr + ".png");
            File ruta = screenshotLocation;
            System.out.print(ruta + " captura region");
            FileUtils.copyFile(compFile, screenshotLocation);

        } catch (IOException e) {

            System.out.println("Error DESKTOP (2361): No Fue Posible Realizar La Captura Del Elemento [" + elemento + "]::[CaptureRegionScreenByClassName]");
        }

    }

    /**
     * MÃ©todo para realizar la catura de la imagen de un elemento que se esta
     * buscando por CssSelector
     *
     * @param elemento valor del cssSelector del elemento a buscar
     *
     */
    public void CaptureRegionScreenByCssSelector(String elemento) {
        WebElement element = driver.findElement(By.cssSelector(elemento));
        Date curDate = new Date();
        //SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh-mm-ss");
        String DateToStr = format.format(curDate);
        try {
            File compFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage image = ImageIO.read(compFile);

            // Get the location of mouse pointer
            java.awt.Point punto = MouseInfo.getPointerInfo().getLocation();

            // Crop the entire page screenshot to get only element screenshot
            BufferedImage elmImg = image.getSubimage(((int) punto.getX() - (element.getSize().getWidth() / 2)), ((int) punto.getY() - (element.getSize().getHeight() / 2)), element.getSize().getWidth() + 1, element.getSize().getHeight() + 1);
            ImageIO.write(elmImg, "png", compFile);

            // Copy the element screenshot to disk
            File screenshotLocation = new File(System.getProperty("user.dir") + "\\Evidencia\\" + "\\Escritorio\\" + DateToStr + ".png");
            File ruta = screenshotLocation;
            System.out.print(ruta + " captura region");
            FileUtils.copyFile(compFile, screenshotLocation);

        } catch (IOException e) {

            System.out.println("Error DESKTOP (2362): No Fue Posible Realizar La Captura Del Elemento [" + elemento + "]::[CaptureRegionScreenByCssSelector]");
        }

    }

    /**
     * MÃ©todo para realizar la catura de la imagen de un elemento que se esta
     * buscando por LinkText
     *
     * @param elemento valor del linkText del elemento a buscar
     *
     */
    public void CaptureRegionScreenByLinkText(String elemento) {
        WebElement element = driver.findElement(By.linkText(elemento));
        Date curDate = new Date();
        //SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh-mm-ss");
        String DateToStr = format.format(curDate);
        try {
            File compFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage image = ImageIO.read(compFile);

            // Get the location of mouse pointer
            java.awt.Point punto = MouseInfo.getPointerInfo().getLocation();

            // Crop the entire page screenshot to get only element screenshot
            BufferedImage elmImg = image.getSubimage(((int) punto.getX() - (element.getSize().getWidth() / 2)), ((int) punto.getY() - (element.getSize().getHeight() / 2)), element.getSize().getWidth() + 1, element.getSize().getHeight() + 1);
            ImageIO.write(elmImg, "png", compFile);

            // Copy the element screenshot to disk
            File screenshotLocation = new File(System.getProperty("user.dir") + "\\Evidencia\\" + "\\Escritorio\\" + DateToStr + ".png");
            File ruta = screenshotLocation;
            System.out.print(ruta + " captura region");
            FileUtils.copyFile(compFile, screenshotLocation);

        } catch (IOException e) {

            System.out.println("Error DESKTOP (2363): No Fue Posible Realizar La Captura Del Elemento [" + elemento + "]::[CaptureRegionScreenByLinkText]");
        }

    }

    /**
     * MÃ©todo para realizar la catura de la imagen de un elemento que se esta
     * buscando por PartialLinkText
     *
     * @param elemento valor del partialLinkText del elemento a buscar
     *
     */
    public void CaptureRegionScreenByPartialLinkText(String elemento) {
        WebElement element = driver.findElement(By.partialLinkText(elemento));
        Date curDate = new Date();
        //SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh-mm-ss");
        String DateToStr = format.format(curDate);
        try {
            File compFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage image = ImageIO.read(compFile);

            // Get the location of mouse pointer
            java.awt.Point punto = MouseInfo.getPointerInfo().getLocation();

            // Crop the entire page screenshot to get only element screenshot
            BufferedImage elmImg = image.getSubimage(((int) punto.getX() - (element.getSize().getWidth() / 2)), ((int) punto.getY() - (element.getSize().getHeight() / 2)), element.getSize().getWidth() + 1, element.getSize().getHeight() + 1);
            ImageIO.write(elmImg, "png", compFile);

            // Copy the element screenshot to disk
            File screenshotLocation = new File(System.getProperty("user.dir") + "\\Evidencia\\" + "\\Escritorio\\" + DateToStr + ".png");
            File ruta = screenshotLocation;
            System.out.print(ruta + " captura region");
            FileUtils.copyFile(compFile, screenshotLocation);

        } catch (IOException e) {

            System.out.println("Error DESKTOP (2364): No Fue Posible Realizar La Captura Del Elemento [" + elemento + "]::[CaptureRegionScreenByPartialLinkText]");
        }

    }

    /**
     * MÃ©todo para realizar la catura de la imagen de un elemento que se esta
     * buscando por TagName
     *
     * @param elemento valor del tagName del elemento a buscar
     *
     */
    public void CaptureRegionScreenByTagName(String elemento) {
        WebElement element = driver.findElement(By.tagName(elemento));
        Date curDate = new Date();
        //SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh-mm-ss");
        String DateToStr = format.format(curDate);
        try {
            File compFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage image = ImageIO.read(compFile);

            // Get the location of mouse pointer
            java.awt.Point punto = MouseInfo.getPointerInfo().getLocation();

            // Crop the entire page screenshot to get only element screenshot
            BufferedImage elmImg = image.getSubimage(((int) punto.getX() - (element.getSize().getWidth() / 2)), ((int) punto.getY() - (element.getSize().getHeight() / 2)), element.getSize().getWidth() + 1, element.getSize().getHeight() + 1);
            ImageIO.write(elmImg, "png", compFile);

            // Copy the element screenshot to disk
            File screenshotLocation = new File(System.getProperty("user.dir") + "\\Evidencia\\" + "\\Escritorio\\" + DateToStr + ".png");
            File ruta = screenshotLocation;
            System.out.print(ruta + " captura region");
            FileUtils.copyFile(compFile, screenshotLocation);

        } catch (IOException e) {

            System.out.println("Error DESKTOP (2365): No Fue Posible Realizar La Captura Del Elemento [" + elemento + "]::[CaptureRegionScreenByTagName]");
        }

    }

    /**
     * MÃ©todo para realizar la catura de la imagen de un elemento que se esta
     * buscando por Xpath
     *
     * @param elemento valor del xpath del elemento a buscar
     *
     */
    public void CaptureRegionScreenByXpath(String elemento) {
        WebElement element = driver.findElement(By.xpath(elemento));
        Date curDate = new Date();
        //SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh-mm-ss");
        String DateToStr = format.format(curDate);
        try {
            File compFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage image = ImageIO.read(compFile);

            // Get the location of mouse pointer
            java.awt.Point punto = MouseInfo.getPointerInfo().getLocation();

            // Crop the entire page screenshot to get only element screenshot
            BufferedImage elmImg = image.getSubimage(((int) punto.getX() - (element.getSize().getWidth() / 2)), ((int) punto.getY() - (element.getSize().getHeight() / 2)), element.getSize().getWidth() + 1, element.getSize().getHeight() + 1);
            ImageIO.write(elmImg, "png", compFile);

            // Copy the element screenshot to disk
            File screenshotLocation = new File(System.getProperty("user.dir") + "\\Evidencia\\" + "\\Escritorio\\" + DateToStr + ".png");
            File ruta = screenshotLocation;
            System.out.print(ruta + " captura region");
            FileUtils.copyFile(compFile, screenshotLocation);

        } catch (IOException e) {

            System.out.println("Error DESKTOP (2366): No Fue Posible Realizar La Captura Del Elemento [" + elemento + "]::[CaptureRegionScreenByXpath]");
        }

    }

    /**
     * MÃ©todo para realizar la catura de la imagen de un elemento
     *
     * @param element objeto tipo WebElement que se desea capturar
     *
     */
    public void CaptureRegionScreenElement(WebElement element) {
        Date curDate = new Date();
        //SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh-mm-ss");
        String DateToStr = format.format(curDate);
        try {
            File compFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage image = ImageIO.read(compFile);

            // Get the location of mouse pointer
            java.awt.Point punto = MouseInfo.getPointerInfo().getLocation();

            // Crop the entire page screenshot to get only element screenshot
            BufferedImage elmImg = image.getSubimage(((int) punto.getX() - (element.getSize().getWidth() / 2)), ((int) punto.getY() - (element.getSize().getHeight() / 2)), element.getSize().getWidth() + 1, element.getSize().getHeight() + 1);
            ImageIO.write(elmImg, "png", compFile);

            // Copy the element screenshot to disk
            File screenshotLocation = new File(System.getProperty("user.dir") + "\\Evidencia\\" + "\\Escritorio\\" + DateToStr + ".png");
            File ruta = screenshotLocation;
            System.out.print(ruta + "captura region ");
            FileUtils.copyFile(compFile, screenshotLocation);

        } catch (IOException e) {

            System.out.println("Error DESKTOP (2367): No Fue Posible Realizar La Captura Del Elemento [" + getAttributeValue(element) + "]::[CaptureRegionScreenByXpath]");
        }
    }

    public void CaptureFullScreen() {

        Date curDate = new Date();
        //SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh-mm-ss");
        String DateToStr = format.format(curDate);
        File directory = new File(System.getProperty("user.dir") + "\\Evidencia\\");
        try {
            if (directory.isDirectory()) {
                //Toma la captura de imagen
                File imagen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                //Mueve el archivo a la carga especificada con el respectivo nombre
                FileUtils.copyFile(imagen, new File(directory.getAbsolutePath() + "\\Escritorio\\" + "FullScreen_" + DateToStr + ".png"));
                System.out.println("");
            } else {
                //Se lanza la excepcion cuando no encuentre el directorio
                throw new IOException("Error WEB (2368): No Fue Posible encontrar la ruta para almencear la captura de pantalla completa ::[CaptureFullScreen]");
            }
        } catch (IOException e) {

            System.out.println("Error WEB (2369): No Fue Posible Realizar La captura de pantalla completa ::[CaptureFullScreen]");
        }
    }

    /**
     * MÃ©todo para extraer un atributo del WebElement ingresado
     *
     * @param elemento en el que se esta realizando la acciÃ³n
     * @return valor del atributo
     */
    public String getAttributeValue(WebElement elemento) {
        if (!elemento.getAttribute("name").equals("") && elemento.getAttribute("name").length() > 0) {
            return elemento.getTagName() + "[name: " + elemento.getAttribute("name") + "]";
        } else if (!elemento.getAttribute("id").equals("") && elemento.getAttribute("id").length() > 0) {
            return elemento.getTagName() + "[id: " + elemento.getAttribute("id") + "]";
        } else if (!elemento.getAttribute("class").equals("") && elemento.getAttribute("class").length() > 0) {
            return elemento.getTagName() + "[class: " + elemento.getAttribute("class") + "]";
        }
        return elemento.getTagName();
    }

    public void enter() {
        try {
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            //
            System.out.println("No se pudo realizar la accion [enter] " + e.getMessage());
        }
    }

    public void escape() {
        try {
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
        } catch (Exception e) {

            System.out.println("No se pudo realizar la accion [escape] " + e.getMessage());
        }

    }

    public void tab() {
        try {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        } catch (Exception e) {
            //
            System.out.println("No se pudo realizar la accion [tab] " + e.getMessage());
        }
    }

    public void backSpace() {
        try {
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
            robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        } catch (Exception e) {

            System.out.println("No se pudo realizar la accion [backSpace] " + e.getMessage());
        }

    }

    public void home() {
        try {
            robot.keyPress(KeyEvent.VK_HOME);
            robot.keyRelease(KeyEvent.VK_HOME);
        } catch (Exception e) {

            System.out.println("No se pudo realizar la accion [home] " + e.getMessage());
        }
    }

    public void end() {
        try {
            robot.keyPress(KeyEvent.VK_END);
            robot.keyRelease(KeyEvent.VK_END);
        } catch (Exception e) {

            System.out.println("No se pudo realizar la accion [end] " + e.getMessage());
        }
    }

    public void delete() {
        try {
            robot.keyPress(KeyEvent.VK_DELETE);
            robot.keyPress(KeyEvent.VK_DELETE);
        } catch (Exception e) {

            System.out.println("No se pudo realizar la accion [delete] " + e.getMessage());
        }
    }

    public void copy() {
        try {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        } catch (Exception e) {

            System.out.println("No se pudo realizar la accion [copy] " + e.getMessage());
        }
    }

    public void cut() {
        try {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_X);
            robot.keyRelease(KeyEvent.VK_X);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        } catch (Exception e) {

            System.out.println("No se pudo realizar la accion [cut] " + e.getMessage());
        }
    }

    public void paste() {
        try {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        } catch (Exception e) {

            System.out.println("No se pudo realizar la accion [paste] " + e.getMessage());
        }
    }

    public void selectAllA() {
        try {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        } catch (Exception e) {

            System.out.println("No se pudo realizar la accion [selectAllA] " + e.getMessage());
        }
    }

    public void selectAllE() {
        try {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_E);
            robot.keyRelease(KeyEvent.VK_E);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        } catch (Exception e) {

            System.out.println("No se pudo realizar la accion [selectAllE] " + e.getMessage());
        }
    }

    public void findF() {
        try {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_F);
            robot.keyRelease(KeyEvent.VK_F);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        } catch (Exception e) {

            System.out.println("No se pudo realizar la accion [findF] " + e.getMessage());
        }
    }

    public void findB() {
        try {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_B);
            robot.keyRelease(KeyEvent.VK_B);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        } catch (Exception e) {

            System.out.println("No se pudo realizar la accion [findB] " + e.getMessage());
        }
    }

    public void next() {
        try {
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_RIGHT);
            robot.keyRelease(KeyEvent.VK_RIGHT);
            robot.keyRelease(KeyEvent.VK_ALT);
        } catch (Exception e) {

            System.out.println("No se pudo realizar la accion [next] " + e.getMessage());
        }
    }

    public void back() {
        try {
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_LEFT);
            robot.keyRelease(KeyEvent.VK_LEFT);
            robot.keyRelease(KeyEvent.VK_ALT);
        } catch (Exception e) {

            System.out.println("No se pudo realizar la accion [back] " + e.getMessage());
        }
    }

    public void closeTab() {
        try {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_W);
            robot.keyRelease(KeyEvent.VK_W);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        } catch (Exception e) {

            System.out.println("No se pudo realizar la accion [closeTab] " + e.getMessage());
        }
    }

    public void closeAll() {
        try {
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_ALT);
        } catch (Exception e) {

            System.out.println("No se pudo realizar la accion [closeAll] " + e.getMessage());
        }
    }

    public void setDriver(WiniumDriver driver) {
        this.driver = driver;
    }

    public void setAction(Actions action) {
        this.action = action;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    private Point getLocation(WebElement elm) {
        action.moveToElement(elm).perform();
        Point punto = MouseInfo.getPointerInfo().getLocation();
        int x = ((int) punto.getX() - (elm.getSize().getWidth() / 2));
        int y = ((int) punto.getY() - (elm.getSize().getHeight() / 2));
        Point loc = new Point(x, y);
        return loc;
    }

    private String GetRectString(WebElement Elemento1) {
        action.moveToElement(Elemento1).perform();
        Point punto = MouseInfo.getPointerInfo().getLocation();
        int x = ((int) punto.getX() - (Elemento1.getSize().getWidth() / 2));
        int y = ((int) punto.getY() - (Elemento1.getSize().getHeight() / 2));
        int w = Elemento1.getSize().getWidth();
        int h = Elemento1.getSize().getHeight();
        System.out.println(Elemento1.getSize());
        return x + "," + y + "," + w + "," + h + ",";
    }

}
