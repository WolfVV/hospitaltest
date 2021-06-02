import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

public class MedicationRequestSavedPopup extends BasePattern{
   // private static final String OK_BUTTON = "[class='btn btn-primary on-white ']";
    private static final String OK_BUTTON = "//button[text()='Ok']";
    private static final String X_BUTTON = "[class='octicon octicon-x']";
    private static final String MEDICATION_REQUEST_SAVED_TEXT = "//div[text()= 'The medication record has been saved.']";



//    public  String getXbutton() {
//        return driver.findElement(By.cssSelector(X_BUTTON)).getText();
//    }
//
//    public  String getOkButton() {
//        return driver.findElement(By.cssSelector(OK_BUTTON)).getText();
//    }

    public  MedicationRequestSavedPopup CrossButtonVisibility () {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        String str = driver.findElement(By.cssSelector(X_BUTTON)).getText();
        boolean isDisplayed = driver.findElement(By.cssSelector(X_BUTTON)).isDisplayed();
        if (isDisplayed) {
            Assert.assertEquals(str,"", "The \"X\" button isn't displayed");
        }
        System.out.println("The X button is displayed");
        return this;
    }

    public  MedicationRequestSavedPopup OkButtonVisibility () {
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        String str = driver.findElement(By.xpath(OK_BUTTON)).getText();
        boolean isDisplayed = driver.findElement(By.xpath(OK_BUTTON)).isDisplayed();
        if (isDisplayed) {
            Assert.assertEquals(str,"Ok", "The \"Ok\" button isn't displayed");
        }
        System.out.println("The" + str + " button is displayed");
        return this;
    }

    public MedicationRequestSavedPopup textRequestSavedIsDisplayed () {
        isElementDisplayed(By.xpath(MEDICATION_REQUEST_SAVED_TEXT));
        return this;
    }

    public  MedicationRequestSavedPopup clickOKbutton () {
        click(By.xpath(OK_BUTTON));
        return this;
    }
}
