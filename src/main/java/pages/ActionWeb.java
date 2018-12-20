/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

//import controller.FxmlNewSuitTestController;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * 
 * @author Oswaldo Buitrago SQA S.A - fabio.betancourt@sqasa.com
 */

public class ActionWeb {

    static WebDriver Driver;
    static WebElement Elemento;
    static Point point;

    static String FxmlNewSuitTestController = "AdherenciaCol";

    /**
     * ***************************************************************************
     * Método Para realizar la accion Click
     * ***************************************************************************
     * @param Url Direccion URl de busqueda
     * @param Navegador Navegador a ejecutar
     */
    public void AbrirNavegador(String Navegador, String Url) throws Exception {
        switch (Navegador) {
            case "Chrome":
                System.setProperty("webDriver.chrome.Driver", System.getProperty("user.dir") + "\\chromedriver.exe");
                Driver = new ChromeDriver();
                Driver.manage().window().maximize();
                Driver.get(Url); // URL utilizada        
                break;

            case "Mozilla":
                System.setProperty("webDriver.gecko.Driver", System.getProperty("user.dir") + "\\geckoDriver.exe");
                Driver = new FirefoxDriver();
                Driver.manage().window().maximize();
                Driver.get(Url); // URL utilizada
                break;

            case "Iexplorer":
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability("InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION", true);
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                capabilities.setCapability("ignoreZoomSetting", true);
                capabilities.setCapability("ignoreProtectedModeSettings", true);
                capabilities.setCapability("initialBrowserUrl", Url);
                Driver = new InternetExplorerDriver(capabilities);
                Driver.getWindowHandle();
                Driver.manage().timeouts().implicitlyWait(07, TimeUnit.SECONDS);
                Driver.manage().window().maximize();
                break;

        }
    }

    /**
     * ***************************************************************************
     * Métodos Para realizar la accion Click
     * ***************************************************************************
     * @param IdValueElemento Valor del elemento a buscar
     */
    public void ClickId(String IdValueElemento) throws Exception {
        try {
            Driver.findElement(By.id(IdValueElemento)).click();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void ClickName(String IdValueElemento) throws Exception {
        try {
            Driver.findElement(By.name(IdValueElemento)).click();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void ClickClassName(String IdValueElemento) throws Exception {
        Driver.findElement(By.className(IdValueElemento)).click();
    }

    public void ClickXpath(String IdValueElemento) throws Exception {
        Driver.findElement(By.xpath(IdValueElemento)).click();
    }

    public void ClickLinkText(String IdValueElemento) throws Exception {
        Driver.findElement(By.linkText(IdValueElemento)).click();
    }

    public void ClickPartianLinkText(String IdValueElemento) throws Exception {
        try {
            Driver.findElement(By.partialLinkText(IdValueElemento)).click();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void ClickTagName(String IdValueElemento) throws Exception {
        Driver.findElement(By.tagName(IdValueElemento)).click();
    }

    public void ClickCssSelector(String IdValueElemento) throws Exception {
        Driver.findElement(By.cssSelector(IdValueElemento)).click();
    }

    public void espera(int espera) {
        try {
            Thread.sleep(espera);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * ***************************************************************************
     * Métodos Para realizar la accion SendKey
     * ***************************************************************************
     * @param IdValueElemento Valor del elemento a buscar
     * @param ParametroString1 Texto a ingresar
     */
    public void SendkeyId(String IdValueElemento, String ParametroString1) throws Exception {
        Driver.findElement(By.id(IdValueElemento)).sendKeys(ParametroString1);
    }

    public void SendkeyName(String IdValueElemento, String ParametroString1) throws Exception {
        Driver.findElement(By.name(IdValueElemento)).sendKeys(ParametroString1);
    }

    public void SendKeyClassName(String IdValueElemento, String ParametroString1) throws Exception {
        Driver.findElement(By.className(IdValueElemento)).sendKeys(ParametroString1);

    }

    public void SendKeyXpath(String IdValueElemento, String ParametroString1) throws Exception {
        Driver.findElement(By.xpath(IdValueElemento)).sendKeys(ParametroString1);

    }

    public void SendKeyLinkText(String IdValueElemento, String ParametroString1) throws Exception {
        Driver.findElement(By.linkText(IdValueElemento)).sendKeys(ParametroString1);

    }

    public void SendKeyPartianLinkText(String IdValueElemento, String ParametroString1) throws Exception {
        Driver.findElement(By.partialLinkText(IdValueElemento)).sendKeys(ParametroString1);

    }

    public void SendKeyTagName(String IdValueElemento, String ParametroString1) throws Exception {
        Driver.findElement(By.tagName(IdValueElemento)).sendKeys(ParametroString1);
    }

    public void SendKeyCssSelector(String IdValueElemento, String ParametroString1) throws Exception {
        Driver.findElement(By.cssSelector(IdValueElemento)).sendKeys(ParametroString1);
    }

    /**
     * ***************************************************************************
     * Métodos Para realizar la accion Clear
     * ***************************************************************************
     * @param IdValueElemento Valor del elemento a buscar
     */
    public void ClearId(String IdValueElemento) throws Exception {
        Driver.findElement(By.id(IdValueElemento)).clear();

    }

    public void ClearName(String IdValueElemento) throws Exception {
        Driver.findElement(By.name(IdValueElemento)).clear();

    }

    public void ClearClassName(String IdValueElemento) throws Exception {
        Driver.findElement(By.className(IdValueElemento)).clear();

    }

    public void ClearXpath(String IdValueElemento) throws Exception {
        Driver.findElement(By.xpath(IdValueElemento)).clear();

    }

    public void ClearLinkText(String IdValueElemento) throws Exception {
        Driver.findElement(By.linkText(IdValueElemento)).clear();

    }

    public void ClearPartianLinkText(String IdValueElemento) throws Exception {
        Driver.findElement(By.partialLinkText(IdValueElemento)).clear();

    }

    public void ClearTagName(String IdValueElemento) throws Exception {
        Driver.findElement(By.tagName(IdValueElemento)).clear();
    }

    public void ClearCssSelector(String IdValueElemento) throws Exception {
        Driver.findElement(By.cssSelector(IdValueElemento)).clear();
    }

    /**
     * ***************************************************************************
     * Métodos Para realizar la accion Submit
     * ***************************************************************************
     * @param IdValueElemento Valor del elemento a buscar
     */
    public void SubmitId(String IdValueElemento) throws Exception {
        Driver.findElement(By.id(IdValueElemento)).submit();
    }

    public void SubmitName(String IdValueElemento) throws Exception {
        Driver.findElement(By.name(IdValueElemento)).submit();
    }

    public void SubmitClassName(String IdValueElemento) throws Exception {
        Driver.findElement(By.className(IdValueElemento)).submit();
    }

    public void SubmitXpath(String IdValueElemento) throws Exception {
        Driver.findElement(By.xpath(IdValueElemento)).submit();
    }

    public void SubmitLinkText(String IdValueElemento) throws Exception {
        Driver.findElement(By.linkText(IdValueElemento)).submit();
    }

    public void SubmitPartianLinkText(String IdValueElemento) throws Exception {
        Driver.findElement(By.partialLinkText(IdValueElemento)).submit();
    }

    public void SubmitTagName(String IdValueElemento) throws Exception {
        Driver.findElement(By.tagName(IdValueElemento)).submit();
    }

    public void SubmitCssSelector(String IdValueElemento) throws Exception {
        Driver.findElement(By.cssSelector(IdValueElemento)).submit();
    }

    /**
     * ***************************************************************************
     * Métodos Para realizar la accion getAttribute
     * ***************************************************************************
     * @param IdValueElemento Valor del elemento a buscar
     * @param ParametroString1 Valor del parametro a obtener
     */
    public void GetAttributeId(String IdValueElemento, String ParametroString1) throws Exception {
        Driver.findElement(By.id(IdValueElemento)).getAttribute(ParametroString1);
    }

    public void GetAttributeName(String IdValueElemento, String ParametroString1) throws Exception {
        Driver.findElement(By.name(IdValueElemento)).getAttribute(ParametroString1);
    }

    public void GetAttributeClassName(String IdValueElemento, String ParametroString1) throws Exception {
        Driver.findElement(By.className(IdValueElemento)).getAttribute(ParametroString1);
    }

    public void GetAttributeXpath(String IdValueElemento, String ParametroString1) throws Exception {
        Driver.findElement(By.xpath(IdValueElemento)).getAttribute(ParametroString1);

    }

    public void GetAttributeLinkText(String IdValueElemento, String ParametroString1) throws Exception {
        Driver.findElement(By.linkText(IdValueElemento)).getAttribute(ParametroString1);
    }

    public void GetAttributePartianLinkText(String IdValueElemento, String ParametroString1) throws Exception {
        Driver.findElement(By.partialLinkText(IdValueElemento)).getAttribute(ParametroString1);
    }

    public void GetAttributeTagName(String IdValueElemento, String ParametroString1) throws Exception {
        Driver.findElement(By.tagName(IdValueElemento)).getAttribute(ParametroString1);
    }

    public void GetAttributeCssSelector(String IdValueElemento, String ParametroString1) throws Exception {
        Driver.findElement(By.cssSelector(IdValueElemento)).getAttribute(ParametroString1);
    }

    /**
     * ***************************************************************************
     * Métodos Para realizar la accion getCssValue
     * ***************************************************************************
     * @param IdValueElemento Valor del elemento a buscar
     * @param ParametroString1 Valor del parametro a obtener
     */
    public void GetCssValueId(String IdValueElemento, String ParametroString1) throws Exception {
        Driver.findElement(By.id(IdValueElemento)).getCssValue(ParametroString1);
    }

    public void GetCssValueeName(String IdValueElemento, String ParametroString1) throws Exception {
        Driver.findElement(By.name(IdValueElemento)).getCssValue(ParametroString1);
    }

    public void GetCssValueeClassName(String IdValueElemento, String ParametroString1) throws Exception {
        Driver.findElement(By.className(IdValueElemento)).getCssValue(ParametroString1);
    }

    public void GetCssValueeXpath(String IdValueElemento, String ParametroString1) throws Exception {
        Driver.findElement(By.xpath(IdValueElemento)).getCssValue(ParametroString1);
    }

    public void GetCssValueeLinkText(String IdValueElemento, String ParametroString1) throws Exception {
        Driver.findElement(By.linkText(IdValueElemento)).getCssValue(ParametroString1);
    }

    public void GetCssValueePartianLinkText(String IdValueElemento, String ParametroString1) throws Exception {
        Driver.findElement(By.partialLinkText(IdValueElemento)).getCssValue(ParametroString1);
    }

    public void GetCssValueeTagName(String IdValueElemento, String ParametroString1) throws Exception {
        Driver.findElement(By.tagName(IdValueElemento)).getCssValue(ParametroString1);
    }

    public void GetCssValueeCssSelector(String IdValueElemento, String ParametroString1) throws Exception {
        Driver.findElement(By.cssSelector(IdValueElemento)).getCssValue(ParametroString1);
    }

    /**
     * ***************************************************************************
     * Métodos Para realizar la accion IsDisplayed
     * ***************************************************************************
     * @param IdValueElemento Valor del elemento a buscar
     * @return
     */
    public boolean IsDisplayedId(String IdValueElemento) throws Exception {
        return Driver.findElement(By.id(IdValueElemento)).isDisplayed();
    }

    public boolean IsDisplayeName(String IdValueElemento) throws Exception {
        return Driver.findElement(By.name(IdValueElemento)).isDisplayed();
    }

    public boolean IsDisplayeClassName(String IdValueElemento) throws Exception {
        return Driver.findElement(By.className(IdValueElemento)).isDisplayed();
    }

    public boolean IsDisplayeXpath(String IdValueElemento) throws Exception {
        return Driver.findElement(By.xpath(IdValueElemento)).isDisplayed();
    }

    public boolean IsDisplayeLinkText(String IdValueElemento) throws Exception {
        return Driver.findElement(By.linkText(IdValueElemento)).isDisplayed();
    }

    public boolean IsDisplayePartianLinkText(String IdValueElemento) throws Exception {
        return Driver.findElement(By.partialLinkText(IdValueElemento)).isDisplayed();
    }

    public boolean IsDisplayeTagName(String IdValueElemento) throws Exception {
        return Driver.findElement(By.tagName(IdValueElemento)).isDisplayed();
    }

    public boolean IsDisplayeCssSelector(String IdValueElemento) throws Exception {
        return Driver.findElement(By.cssSelector(IdValueElemento)).isDisplayed();
    }

    /**
     * ***************************************************************************
     * Métodos Para realizar la accion isSelected
     * ***************************************************************************
     * @param IdValueElemento Valor del elemento a buscar
     * @return
     */
    public boolean IsSelectedId(String IdValueElemento) throws Exception {
        return Driver.findElement(By.id(IdValueElemento)).isSelected();
    }

    public boolean IsSelectedName(String IdValueElemento) throws Exception {
        return Driver.findElement(By.name(IdValueElemento)).isSelected();
    }

    public boolean IsSelectedClassName(String IdValueElemento) throws Exception {
        return Driver.findElement(By.className(IdValueElemento)).isSelected();
    }

    public boolean IsSelectedXpath(String IdValueElemento) throws Exception {
        return Driver.findElement(By.xpath(IdValueElemento)).isSelected();
    }

    public boolean IsSelectedLinkText(String IdValueElemento) throws Exception {
        return Driver.findElement(By.linkText(IdValueElemento)).isSelected();
    }

    public boolean IsSelectedPartianLinkText(String IdValueElemento) throws Exception {
        return Driver.findElement(By.partialLinkText(IdValueElemento)).isSelected();
    }

    public boolean IsSelectedTagName(String IdValueElemento) throws Exception {
        return Driver.findElement(By.tagName(IdValueElemento)).isSelected();
    }

    public boolean IsSelectedCssSelector(String IdValueElemento) throws Exception {
        return Driver.findElement(By.cssSelector(IdValueElemento)).isSelected();
    }

    /**
     * ***************************************************************************
     * Métodos Para realizar la accion isEnabled
     * ***************************************************************************
     * @param IdValueElemento Valor del elemento a buscar
     * @return
     */
    public boolean isEnabledId(String IdValueElemento) throws Exception {
        return Driver.findElement(By.id(IdValueElemento)).isEnabled();
    }

    public boolean isEnabledName(String IdValueElemento) throws Exception {
        return Driver.findElement(By.name(IdValueElemento)).isEnabled();
    }

    public boolean isEnabledClassName(String IdValueElemento) throws Exception {
        return Driver.findElement(By.className(IdValueElemento)).isEnabled();
    }

    public boolean isEnabledXpath(String IdValueElemento) throws Exception {
        return Driver.findElement(By.xpath(IdValueElemento)).isEnabled();
    }

    public boolean isEnabledLinkText(String IdValueElemento) throws Exception {
        return Driver.findElement(By.linkText(IdValueElemento)).isEnabled();
    }

    public boolean isEnabledPartianLinkText(String IdValueElemento) throws Exception {
        return Driver.findElement(By.partialLinkText(IdValueElemento)).isEnabled();
    }

    public boolean isEnabledTagName(String IdValueElemento) throws Exception {
        return Driver.findElement(By.tagName(IdValueElemento)).isEnabled();
    }

    public boolean isEnabledCssSelector(String IdValueElemento) throws Exception {
        return Driver.findElement(By.cssSelector(IdValueElemento)).isEnabled();
    }

    /**
     * ***************************************************************************
     * Métodos Para realizar la accion isSelected
     * ***************************************************************************
     * @param IdValueElemento Valor del elemento a buscar
     */
    public void getTextId(String IdValueElemento) throws Exception {
        Driver.findElement(By.id(IdValueElemento)).getText();
    }

    public void getTextName(String IdValueElemento) throws Exception {
        Driver.findElement(By.name(IdValueElemento)).getText();
    }

    public void getTextClassName(String IdValueElemento) throws Exception {
        Driver.findElement(By.className(IdValueElemento)).getText();
    }

    public void getTextXpath(String IdValueElemento) throws Exception {
        Driver.findElement(By.xpath(IdValueElemento)).getText();
    }

    public void getTextLinkText(String IdValueElemento) throws Exception {
        Driver.findElement(By.linkText(IdValueElemento)).getText();
    }

    public void getTextPartianLinkText(String IdValueElemento) throws Exception {
        Driver.findElement(By.partialLinkText(IdValueElemento)).getText();
    }

    public void getTextTagName(String IdValueElemento) throws Exception {
        Driver.findElement(By.tagName(IdValueElemento)).getText();
    }

    public void getTextCssSelector(String IdValueElemento) throws Exception {
        Driver.findElement(By.cssSelector(IdValueElemento)).getText();
    }

    /**
     * ***************************************************************************
     * Métodos Para realizar la accion GetTagName
     * ***************************************************************************
     * @param IdValueElemento Valor del elemento a buscar
     */
    public void GetTagNameId(String IdValueElemento) throws Exception {
        Driver.findElement(By.id(IdValueElemento)).getTagName();
    }

    public void GetTagNameName(String IdValueElemento) throws Exception {
        Driver.findElement(By.name(IdValueElemento)).getTagName();
    }

    public void GetTagNameClassName(String IdValueElemento) throws Exception {
        Driver.findElement(By.className(IdValueElemento)).getTagName();
    }

    public void GetTagNameXpath(String IdValueElemento) throws Exception {
        Driver.findElement(By.xpath(IdValueElemento)).getTagName();
    }

    public void GetTagNameLinkText(String IdValueElemento) throws Exception {
        Driver.findElement(By.linkText(IdValueElemento)).getTagName();
    }

    public void GetTagNamePartianLinkText(String IdValueElemento) throws Exception {
        Driver.findElement(By.partialLinkText(IdValueElemento)).getTagName();
    }

    public void GetTagNameTagName(String IdValueElemento) throws Exception {
        Driver.findElement(By.tagName(IdValueElemento)).getTagName();
    }

    public void GetTagNameCssSelector(String IdValueElemento) throws Exception {
        Driver.findElement(By.cssSelector(IdValueElemento)).getTagName();
    }

    /**
     * ***************************************************************************
     * Métodos Para realizar la accion ContainsElementsId
     * ***************************************************************************
     * @param IdValueElemento Valor del elemento a buscar
     * @param Objeto elemento que se desea comparar con la lista
     * @return
     */
    public boolean ContainsElementsId(String IdValueElemento, Object Objeto) throws Exception {
        return Driver.findElements(By.id(IdValueElemento)).contains(Objeto);
    }

    public boolean ContainsElementsName(String IdValueElemento, Object Objeto) throws Exception {
        return Driver.findElements(By.name(IdValueElemento)).contains(Objeto);
    }

    public boolean ContainsElementsClassName(String IdValueElemento, Object Objeto) throws Exception {
        return Driver.findElements(By.className(IdValueElemento)).contains(Objeto);
    }

    public boolean ContainsElementsXpath(String IdValueElemento, Object Objeto) throws Exception {
        return Driver.findElements(By.xpath(IdValueElemento)).contains(Objeto);
    }

    public boolean ContainsElementsLinkText(String IdValueElemento, Object Objeto) throws Exception {
        return Driver.findElements(By.linkText(IdValueElemento)).contains(Objeto);
    }

    public boolean ContainsElementsPartianLinkText(String IdValueElemento, Object Objeto) throws Exception {
        return Driver.findElements(By.partialLinkText(IdValueElemento)).contains(Objeto);
    }

    public boolean ContainsElementsTagName(String IdValueElemento, Object Objeto) throws Exception {
        return Driver.findElements(By.tagName(IdValueElemento)).contains(Objeto);
    }

    public boolean ContainsElementsCssSelector(String IdValueElemento, Object Objeto) throws Exception {
        return Driver.findElements(By.cssSelector(IdValueElemento)).contains(Objeto);
    }

    public void CaptureFullScreen(String DateToStr) throws Exception {
        File directory = new File(System.getProperty("user.dir") + "\\Evidencia\\");

        if (directory.isDirectory()) {
            //Toma la captura de imagen
            File imagen = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
            //Mueve el archivo a la carga especificada con el respectivo nombre
            crearCarpetasCapturas(imagen, DateToStr, "full");
        } else {
            //Se lanza la excepcion cuando no encuentre el directorio
            throw new IOException("Error WEB (1008): No Fue Posible encontrar la ruta para almencear la captura de pantalla completa ::!");
        }
    }

    public void CaptureRegionScreenId(String IdValueElemento, String DateToStr) throws Exception {
        WebElement webElement = Driver.findElement(By.id(IdValueElemento));

        // Get entire page screenshot
        File screenshot = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);

        // Get the location of element on the page
        point = webElement.getLocation();

        // Get width and height of the element
        int eleWidth = webElement.getSize().getWidth();
        int eleHeight = webElement.getSize().getHeight();

        // Crop the entire page screenshot to get only element screenshot
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);

        crearCarpetasCapturas(screenshot, DateToStr, IdValueElemento);

    }

    public void CaptureRegionScreenName(String IdValueElemento, String DateToStr) throws Exception {
        WebElement webElement = Driver.findElement(By.name(IdValueElemento));

        // Get entire page screenshot
        File screenshot = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);

        // Get the location of element on the page
        point = webElement.getLocation();

        // Get width and height of the element
        int eleWidth = webElement.getSize().getWidth();
        int eleHeight = webElement.getSize().getHeight();

        // Crop the entire page screenshot to get only element screenshot
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);

        crearCarpetasCapturas(screenshot, DateToStr, IdValueElemento);

    }

    public void CaptureRegionScreenclassName(String IdValueElemento, String DateToStr) throws Exception {
        WebElement webElement = Driver.findElement(By.className(IdValueElemento));

        // Get entire page screenshot
        File screenshot = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);

        // Get the location of element on the page
        point = webElement.getLocation();

        // Get width and height of the element
        int eleWidth = webElement.getSize().getWidth();
        int eleHeight = webElement.getSize().getHeight();

        // Crop the entire page screenshot to get only element screenshot
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);

        crearCarpetasCapturas(screenshot, DateToStr, IdValueElemento);

    }

    public void CaptureRegionScreenxpath(String IdValueElemento, String DateToStr) throws Exception {

        WebElement webElement = Driver.findElement(By.xpath(IdValueElemento));

        // Get entire page screenshot
        File screenshot = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);

        // Get the location of element on the page
        point = webElement.getLocation();

        // Get width and height of the element
        int eleWidth = webElement.getSize().getWidth();
        int eleHeight = webElement.getSize().getHeight();

        // Crop the entire page screenshot to get only element screenshot
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);

        crearCarpetasCapturas(screenshot, DateToStr, IdValueElemento);
    }

    public void CaptureRegionScreenlinkText(String IdValueElemento, String DateToStr) throws Exception {

        WebElement webElement = Driver.findElement(By.linkText(IdValueElemento));

        // Get entire page screenshot
        File screenshot = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);

        // Get the location of element on the page
        point = webElement.getLocation();

        // Get width and height of the element
        int eleWidth = webElement.getSize().getWidth();
        int eleHeight = webElement.getSize().getHeight();

        // Crop the entire page screenshot to get only element screenshot
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);

        crearCarpetasCapturas(screenshot, DateToStr, IdValueElemento);

    }

    public void CaptureRegionScreenpartialLinkText(String IdValueElemento, String DateToStr) throws Exception {

        WebElement webElement = Driver.findElement(By.partialLinkText(IdValueElemento));

        // Get entire page screenshot
        File screenshot = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);

        // Get the location of element on the page
        point = webElement.getLocation();

        // Get width and height of the element
        int eleWidth = webElement.getSize().getWidth();
        int eleHeight = webElement.getSize().getHeight();

        // Crop the entire page screenshot to get only element screenshot
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);

        crearCarpetasCapturas(screenshot, DateToStr, IdValueElemento);

    }

    public void CaptureRegionScreentagName(String IdValueElemento, String DateToStr) throws Exception {

        WebElement webElement = Driver.findElement(By.tagName(IdValueElemento));

        // Get entire page screenshot
        File screenshot = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);

        // Get the location of element on the page
        point = webElement.getLocation();

        // Get width and height of the element
        int eleWidth = webElement.getSize().getWidth();
        int eleHeight = webElement.getSize().getHeight();

        // Crop the entire page screenshot to get only element screenshot
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);

        crearCarpetasCapturas(screenshot, DateToStr, IdValueElemento);

    }

    public void CaptureRegionScreencssSelector(String IdValueElemento, String DateToStr) throws Exception {

        WebElement webElement = Driver.findElement(By.cssSelector(IdValueElemento));

        // Get entire page screenshot
        File screenshot = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);

        // Get the location of element on the page
        point = webElement.getLocation();

        // Get width and height of the element
        int eleWidth = webElement.getSize().getWidth();
        int eleHeight = webElement.getSize().getHeight();

        // Crop the entire page screenshot to get only element screenshot
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);

        crearCarpetasCapturas(screenshot, DateToStr, IdValueElemento);
    }

    /**
     * ***************************************************************************
     * Métodos Para realizar la accion DobleClickId
     * ***************************************************************************
     * @param IdValueElemento Valor del elemento a buscar
     */
    public void DobleClickId(String IdValueElemento) throws Exception {
        Elemento = Driver.findElement(By.id(IdValueElemento));
        new Actions(Driver).doubleClick(Elemento).perform();

    }

    public void DobleClickName(String IdValueElemento) throws Exception {
        Elemento = Driver.findElement(By.name(IdValueElemento));
        new Actions(Driver).doubleClick(Elemento).perform();
    }

    public void DobleClickClassName(String IdValueElemento) throws Exception {
        Elemento = Driver.findElement(By.className(IdValueElemento));
        new Actions(Driver).doubleClick(Elemento).perform();
    }

    public void DobleClickXpath(String IdValueElemento) throws Exception {
        Elemento = Driver.findElement(By.xpath(IdValueElemento));
        new Actions(Driver).doubleClick(Elemento).perform();
    }

    public void DobleClickLinkText(String IdValueElemento) throws Exception {
        Elemento = Driver.findElement(By.linkText(IdValueElemento));
        new Actions(Driver).doubleClick(Elemento).perform();
    }

    public void DobleClickPartianLinkText(String IdValueElemento) throws Exception {
        Elemento = Driver.findElement(By.partialLinkText(IdValueElemento));
        new Actions(Driver).doubleClick(Elemento).perform();
    }

    public void DobleClickTagName(String IdValueElemento) throws Exception {
        Elemento = Driver.findElement(By.tagName(IdValueElemento));
        new Actions(Driver).doubleClick(Elemento).perform();
    }

    public void DobleClickCssSelector(String IdValueElemento) throws Exception {
        Elemento = Driver.findElement(By.cssSelector(IdValueElemento));
        new Actions(Driver).doubleClick(Elemento).perform();
    }

    /**
     * ***************************************************************************
     * Métodos Para realizar la accion RightClickId
     * ***************************************************************************
     * @param IdValueElemento Valor del elemento a buscar
     */
    public void RightClickId(String IdValueElemento) throws Exception {
        Elemento = Driver.findElement(By.id(IdValueElemento));
        new Actions(Driver).contextClick(Elemento).perform();

    }

    public void RightClickName(String IdValueElemento) throws Exception {
        Elemento = Driver.findElement(By.name(IdValueElemento));
        new Actions(Driver).contextClick(Elemento).perform();
    }

    public void RightClickClassName(String IdValueElemento) throws Exception {
        Elemento = Driver.findElement(By.className(IdValueElemento));
        new Actions(Driver).contextClick(Elemento).perform();
    }

    public void RightClickXpath(String IdValueElemento) throws Exception {
        Elemento = Driver.findElement(By.xpath(IdValueElemento));
        new Actions(Driver).contextClick(Elemento).perform();
    }

    public void RightClickLinkText(String IdValueElemento) throws Exception {
        Elemento = Driver.findElement(By.linkText(IdValueElemento));
        new Actions(Driver).contextClick(Elemento).perform();
    }

    public void RightClickPartianLinkText(String IdValueElemento) throws Exception {
        Elemento = Driver.findElement(By.partialLinkText(IdValueElemento));
        new Actions(Driver).contextClick(Elemento).perform();
    }

    public void RightClickTagName(String IdValueElemento) throws Exception {
        Elemento = Driver.findElement(By.tagName(IdValueElemento));
        new Actions(Driver).contextClick(Elemento).perform();
    }

    public void RightClickCssSelector(String IdValueElemento) throws Exception {
        Elemento = Driver.findElement(By.cssSelector(IdValueElemento));
        new Actions(Driver).contextClick(Elemento).perform();
    }

    /**
     * ***************************************************************************
     * Métodos Para realizar la accion MoveToElement
     * ***************************************************************************
     * @param IdValueElemento Valor del elemento a buscar
     */
    public void MoveToElementId(String IdValueElemento) throws Exception {
        Elemento = Driver.findElement(By.id(IdValueElemento));
        new Actions(Driver).moveToElement(Elemento).build().perform();

    }

    public void MoveToElementName(String IdValueElemento) throws Exception {
        Elemento = Driver.findElement(By.name(IdValueElemento));
        new Actions(Driver).moveToElement(Elemento).build().perform();

    }

    public void MoveToElementClassName(String IdValueElemento) throws Exception {
        Elemento = Driver.findElement(By.className(IdValueElemento));
        new Actions(Driver).moveToElement(Elemento).build().perform();
    }

    public void MoveToElementXpath(String IdValueElemento) throws Exception {
        Elemento = Driver.findElement(By.xpath(IdValueElemento));
        new Actions(Driver).moveToElement(Elemento).build().perform();
    }

    public void MoveToElementLinkText(String IdValueElemento) throws Exception {
        Elemento = Driver.findElement(By.linkText(IdValueElemento));
        new Actions(Driver).moveToElement(Elemento).build().perform();
    }

    public void MoveToElementPartianLinkText(String IdValueElemento) throws Exception {
        Elemento = Driver.findElement(By.partialLinkText(IdValueElemento));
        new Actions(Driver).moveToElement(Elemento).build().perform();
    }

    public void MoveToElementTagName(String IdValueElemento) throws Exception {
        Elemento = Driver.findElement(By.tagName(IdValueElemento));
        new Actions(Driver).moveToElement(Elemento).build().perform();
    }

    public void MoveToElementCssSelector(String IdValueElemento) throws Exception {
        Elemento = Driver.findElement(By.cssSelector(IdValueElemento));
        new Actions(Driver).moveToElement(Elemento).build().perform();
    }

    /**
     * ***************************************************************************
     * Métodos Para realizar la accion MoveToElementCoord
     * ***************************************************************************
     * @param IdValueElemento Valor del elemento a buscar
     * @param ParametroInt1 Valor x
     * @param ParametroInt2 Valor Y
     */
    public void MoveToElementCoordId(String IdValueElemento, int ParametroInt1, int ParametroInt2) throws Exception {
        Elemento = Driver.findElement(By.id(IdValueElemento));
        new Actions(Driver).moveToElement(Elemento, ParametroInt1, ParametroInt2).build().perform();

    }

    public void MoveToElementCoordName(String IdValueElemento, int ParametroInt1, int ParametroInt2) throws Exception {
        Elemento = Driver.findElement(By.name(IdValueElemento));
        new Actions(Driver).moveToElement(Elemento, ParametroInt1, ParametroInt2).build().perform();

    }

    public void MoveToElementCoordClassName(String IdValueElemento, int ParametroInt1, int ParametroInt2) throws Exception {
        Elemento = Driver.findElement(By.className(IdValueElemento));
        new Actions(Driver).moveToElement(Elemento, ParametroInt1, ParametroInt2).build().perform();
    }

    public void MoveToElementCoordXpath(String IdValueElemento, int ParametroInt1, int ParametroInt2) throws Exception {
        Elemento = Driver.findElement(By.xpath(IdValueElemento));
        new Actions(Driver).moveToElement(Elemento, ParametroInt1, ParametroInt2).build().perform();
    }

    public void MoveToElementCoordLinkText(String IdValueElemento, int ParametroInt1, int ParametroInt2) throws Exception {
        Elemento = Driver.findElement(By.linkText(IdValueElemento));
        new Actions(Driver).moveToElement(Elemento, ParametroInt1, ParametroInt2).build().perform();
    }

    public void MoveToElementCoordPartianLinkText(String IdValueElemento, int ParametroInt1, int ParametroInt2) throws Exception {
        Elemento = Driver.findElement(By.partialLinkText(IdValueElemento));
        new Actions(Driver).moveToElement(Elemento, ParametroInt1, ParametroInt2).build().perform();
    }

    public void MoveToElementCoordTagName(String IdValueElemento, int ParametroInt1, int ParametroInt2) throws Exception {
        Elemento = Driver.findElement(By.tagName(IdValueElemento));
        new Actions(Driver).moveToElement(Elemento, ParametroInt1, ParametroInt2).build().perform();
    }

    public void MoveToElementCoordCssSelector(String IdValueElemento, int ParametroInt1, int ParametroInt2) throws Exception {
        Elemento = Driver.findElement(By.cssSelector(IdValueElemento));
        new Actions(Driver).moveToElement(Elemento, ParametroInt1, ParametroInt2).build().perform();
    }

    /**
     * ***************************************************************************
     * Métodos Para realizar la accion SwitchTo
     * ***************************************************************************
     */
    public void SwitchToAlert() throws Exception {
        Driver.switchTo().alert();
    }

    public void SwitchToAlertText(String ParametroString1) throws Exception {
        Driver.switchTo().alert();
        Driver.switchTo().alert().sendKeys(ParametroString1);
    }

    public void SwitchToAlertAccept() throws Exception {
        Driver.switchTo().alert().accept();
    }

    public void SwitchToAlertDismiss() throws Exception {
        Driver.switchTo().alert().dismiss();
    }

    public void SwitchToAlertDefaultContent() throws Exception {
        Driver.switchTo().defaultContent();
    }

    public void SwitchToNewTab() throws Exception {
        String oldTab = Driver.getWindowHandle();
        ArrayList<String> newTab = new ArrayList<>(Driver.getWindowHandles());
        newTab.remove(oldTab);
        Driver.switchTo().window(newTab.get(0));
    }

    public void AbrirPestaña(String url) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver;
        jse.executeScript("var w = window.open('" + url + "');");
    }

    public void SwitchToBackTab() throws Exception {
        String oldTab = Driver.getWindowHandle();
        ArrayList<String> newTab = new ArrayList<>(Driver.getWindowHandles());
        newTab.remove(oldTab);
        Driver.switchTo().window(oldTab);
    }

    public void Scroll(int ParametroInt1, int ParametroInt2) throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) Driver;
        js.executeScript("window.scrollBy(" + ParametroInt1 + "," + ParametroInt2 + ")", "");
    }

    public void switchToFrameId(String IdValueElemento) throws Exception {
        Driver.switchTo().frame(Driver.findElement(By.id(IdValueElemento)));
    }

    public void switchToFrameName(String IdValueElemento) throws Exception {
        Driver.switchTo().frame(Driver.findElement(By.name(IdValueElemento)));
    }

    public void switchToFrameClassName(String IdValueElemento) throws Exception {
        Driver.switchTo().frame(Driver.findElement(By.className(IdValueElemento)));
    }

    public void switchToFrameXpath(String IdValueElemento) throws Exception {
        Driver.switchTo().frame(Driver.findElement(By.xpath(IdValueElemento)));
    }

    public void switchToFrameLinkText(String IdValueElemento) throws Exception {
        Driver.switchTo().frame(Driver.findElement(By.linkText(IdValueElemento)));
    }

    public void switchToFramePartianLinkText(String IdValueElemento) throws Exception {
        Driver.switchTo().frame(Driver.findElement(By.partialLinkText(IdValueElemento)));
    }

    public void switchToFrameTagName(String IdValueElemento) throws Exception {
        Driver.switchTo().frame(Driver.findElement(By.tagName(IdValueElemento)));
    }

    public void switchToFrameCssSelector(String IdValueElemento) throws Exception {
        Driver.switchTo().frame(Driver.findElement(By.cssSelector(IdValueElemento)));
    }

    public void implicitlyWait_SECONDS(int ParametroInt1) throws Exception {
        Driver.manage().timeouts().implicitlyWait(ParametroInt1, TimeUnit.SECONDS);
    }

    public void pageLoadTimeout_SECONDS(int ParametroInt1) throws Exception {
        Driver.manage().timeouts().pageLoadTimeout(ParametroInt1, TimeUnit.SECONDS);
    }

    /**
     * ***************************************************************************
     * Métodos Para realizar la accion wait
     * ***************************************************************************
     * @param IdValueElemento Valor del elemento a buscar
     */
    public void waitId(String IdValueElemento) throws Exception {
        Driver.findElement(By.id(IdValueElemento)).wait();
    }

    public void waitName(String IdValueElemento) throws Exception {
        Driver.findElement(By.name(IdValueElemento)).wait();
    }

    public void waitClassName(String IdValueElemento) throws Exception {
        Driver.findElement(By.className(IdValueElemento)).wait();
    }

    public void waitXpath(String IdValueElemento) throws Exception {
        Driver.findElement(By.xpath(IdValueElemento)).wait();
    }

    public void waitLinkText(String IdValueElemento) throws Exception {
        Driver.findElement(By.linkText(IdValueElemento)).wait();
    }

    public void waitPartianLinkText(String IdValueElemento) throws Exception {
        Driver.findElement(By.partialLinkText(IdValueElemento)).wait();
    }

    public void waitTagName(String IdValueElemento) throws Exception {
        Driver.findElement(By.tagName(IdValueElemento)).wait();
    }

    public void waitCssSelector(String IdValueElemento) throws Exception {
        Driver.findElement(By.cssSelector(IdValueElemento)).wait();
    }

    /**
     * ***************************************************************************
     * Métodos Para realizar la accion getLocation
     * ***************************************************************************
     * @param IdValueElemento Valor del elemento a buscar
     */
    public void getLocationId(String IdValueElemento) throws Exception {
        Driver.findElement(By.id(IdValueElemento)).getLocation();
    }

    public void getLocationName(String IdValueElemento) throws Exception {
        Driver.findElement(By.name(IdValueElemento)).getLocation();
    }

    public void getLocationClassName(String IdValueElemento) throws Exception {
        Driver.findElement(By.className(IdValueElemento)).getLocation();
    }

    public void getLocationXpath(String IdValueElemento) throws Exception {
        Driver.findElement(By.xpath(IdValueElemento)).getLocation();
    }

    public void getLocationLinkText(String IdValueElemento) throws Exception {
        Driver.findElement(By.linkText(IdValueElemento)).getLocation();
    }

    public void getLocationPartianLinkText(String IdValueElemento) throws Exception {
        Driver.findElement(By.partialLinkText(IdValueElemento)).getLocation();
    }

    public void getLocationTagName(String IdValueElemento) throws Exception {
        Driver.findElement(By.tagName(IdValueElemento)).getLocation();
    }

    public void getLocationCssSelector(String IdValueElemento) throws Exception {
        Driver.findElement(By.cssSelector(IdValueElemento)).getLocation();
    }

    public void BackPage() throws Exception {
        Driver.navigate().back();
    }

    public void forwardPage() throws Exception {
        Driver.navigate().forward();
    }

    public void f5Page() throws Exception {
        Driver.navigate().refresh();
    }

    public void Close() throws Exception {
        Driver.close();
    }

    public void crearCarpetasCapturas(File imagen, String date, String addName) throws IOException {
        String addNameFinal = addName.replaceAll("[^a-zA-Z0-9]+", "_");
        System.out.println("addName: " + addNameFinal);
        File directory = new File(System.getProperty("user.dir") + "\\Evidencia\\capturas\\");
        String strResultPath = directory + "\\" + FxmlNewSuitTestController;

        File f = new File(strResultPath);
        f.mkdirs();

        File f2 = new File(strResultPath + "\\" + date);
        f2.mkdirs();
        // Empieza a escribir el LOG
//        bw1 = new BufferedWriter(new FileWriter(htmlname1));
        FileUtils.copyFile(imagen, new File(f2.getAbsolutePath() + "\\" + FxmlNewSuitTestController + "_" + addNameFinal + "_" + date + ".png"));

    }

    public void DragAndDrop(WebElement Elemento1, WebElement Elemento2) throws Exception {
        WebElement element = Elemento1;
        WebElement target = Elemento2;
        (new Actions(Driver)).dragAndDrop(element, target).perform();
    }

    public void finalizarProcesos() {
        Driver.quit();
    }

    public void cerrarAplicacion() {
        Driver.close();
    }

    public void QuitDriver() throws IOException {
        // cierra las sesiones de Chrome driver
        String command = "TASKKILL /F /IM chromedriver.exe";
        Process child = Runtime.getRuntime().exec(command);
        child = Runtime.getRuntime().exec(command);
        //Driver.quit();       
    }

}
