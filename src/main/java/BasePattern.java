import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import java.sql.DriverManager;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.logging.Logger;

import static org.testng.AssertJUnit.assertTrue;

public class BasePattern {

    protected WebDriver driver;
    protected  WebDriverWait wait;
//    public static Logger log = Logger.getLogger("devpinoyLogger");



    public BasePattern() {
//        this.driver = driver;
//        log = Logger.getLogger(this.getClass().getCanonicalName());
        driver = DriverHolder.getDriver();
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,15);
    }

//    public WebDriver getDriver() {
//        return driver;
//    }

    protected  void waitVisibility (By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }


    protected  void waitClickableElement (By elementBy) {
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    protected  void click (By elementBy) {
        waitClickableElement(elementBy);
        driver.findElement(elementBy).click();
    }

    protected  void typing (By elementBy,String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    protected  void isElementDisplayed (By elementBy) {
        waitVisibility(elementBy);
        assertTrue(driver.findElement(elementBy).isDisplayed());

    }







    protected void windowsSwitcher () {
        String winHandleBefore = driver.getWindowHandle();
        Set<String> otherWindowHandles = driver.getWindowHandles();
        for(String winHandle : otherWindowHandles){
            driver.switchTo().window(winHandle);
        }
    }

    protected  void windowsSwitcherBack () {
        String winHandleBefore = driver.getWindowHandle();
        driver.switchTo().window(winHandleBefore);
    }

    protected  void compareElements (String elementReal,String exeption) {
        Assert.assertEquals(driver.getCurrentUrl(),elementReal, exeption);
        }
    }

