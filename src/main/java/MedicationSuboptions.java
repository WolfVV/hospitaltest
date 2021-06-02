import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import static org.testng.AssertJUnit.assertTrue;

public class MedicationSuboptions extends BasePattern{
    private static final String REQUESTS_BUTTON= "#ember853";
    private static final String COMPLETED_BUTTON = "[href='#/medication/completed']";
    private static final String NEW_REQUEST_BUTTON = "//span[@class='octicon octicon-plus']";
    private static final String RETURN_MEDICATION_BUTTON = "[href='#/medication/return/new']";

    @FindBy(xpath = REQUESTS_BUTTON)
    private WebElement request;
    @FindBy(css = COMPLETED_BUTTON)
    private WebElement completed;
    @FindBy(css = NEW_REQUEST_BUTTON)
    private WebElement newRequest;
    @FindBy(css = RETURN_MEDICATION_BUTTON)
    private WebElement returnMedicaton;




    public  MedicationSuboptions checkOfDisplayingRequestsButton () {
        String str = driver.findElement(By.cssSelector(REQUESTS_BUTTON)).getText();
        boolean isDisplayed = driver.findElement(By.cssSelector(REQUESTS_BUTTON)).isDisplayed();
        if (isDisplayed) {
            Assert.assertEquals(str,"Requests", "The \"Requests\" button isn't displayed");
        }
        System.out.println("The " + str + " element is displayed");
        return this;
    }

    public  MedicationSuboptions checkOfDisplayingCompletedButton () {
        String str = driver.findElement(By.cssSelector(COMPLETED_BUTTON)).getText();
        boolean isDisplayed = driver.findElement(By.cssSelector(COMPLETED_BUTTON)).isDisplayed();
        if (isDisplayed) {
            Assert.assertEquals(str,"Completed", "The \"Completed\" button isn't displayed");
        }
        System.out.println("The " + str + " element is displayed");
        return this;
    }
    public  MedicationSuboptions checkOfDisplayingNewRequestButton () {
        String str = driver.findElement(By.xpath(NEW_REQUEST_BUTTON)).getText();
        boolean isDisplayed = driver.findElement(By.xpath(NEW_REQUEST_BUTTON)).isDisplayed();
        if (isDisplayed) {
            Assert.assertEquals(str,"", "The \"New Request\" button isn't displayed");
        }
        System.out.println("The " + str + " element is displayed");
        return this;

    }
    public  MedicationSuboptions checkOfDisplayingReturnMedicationButton () {
        String str = driver.findElement(By.cssSelector(RETURN_MEDICATION_BUTTON)).getText();
        boolean isDisplayed = driver.findElement(By.cssSelector(RETURN_MEDICATION_BUTTON)).isDisplayed();
        if (isDisplayed) {
            Assert.assertEquals(str, "Return Medication", "The \"Return Medication\" button isn't displayed");
        }
        System.out.println("The " + str + " element is displayed");
        return this;
    }



    public  void clickNewRequest() {
        click(By.xpath(NEW_REQUEST_BUTTON));
    }
}
