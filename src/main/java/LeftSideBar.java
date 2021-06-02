import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class LeftSideBar extends BasePattern{


    private static final String PATIENT_BUTTON = "[id='ember727']";
    private static final String MEDICATION = "//*[@id='ember767']";
    private static final String GEAR_ICON = "//span[@class='mega-octicon octicon-gear']";


    public  LeftSideBar clickGearIcon () {
        click(By.xpath(GEAR_ICON));
        return this;
    }

    public  LeftSideBar clickMedication () {
        click(By.xpath(MEDICATION));
        return this;
    }


    public  LeftSideBar checkUserLoggedByURL () {
//        if ( wait.until(ExpectedConditions.urlToBe("http://demo.hospitalrun.io/#/patients"))) {
//            String str = driver.getCurrentUrl();
//            Assert.assertEquals(str, "http://demo.hospitalrun.io/#/patients", "The \"URL\" isn't correct.User isn't logged in");
//        } else {
//            String str = driver.getCurrentUrl();
//            Assert.assertEquals(str, "http://demo.hospitalrun.io/#/patients", "The \"URL\" isn't correct.User isn't logged in");
//        }
//        System.out.println("User is logged in and Patient Listing page is displayed" );

//        wait.until(ExpectedConditions.urlToBe("http://demo.hospitalrun.io/#/patients"));

        boolean isDisplayed = wait.until(ExpectedConditions.urlToBe("http://demo.hospitalrun.io/#/patients"));
        if (isDisplayed) {
            String str = driver.getCurrentUrl();
            Assert.assertEquals(str, "http://demo.hospitalrun.io/#/patients", "The \"URL\" isn't correct");
            System.out.println("User is logged in and Patient Listing page is displayed" );
        }
//        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//        String str = driver.getCurrentUrl();
//        System.out.println(str);
//        Assert.assertEquals(str, "http://demo.hospitalrun.io/#/patients", "The \"URL\" isn't correct");
//        System.out.println("User is logged in and Patient Listing page is displayed" );
        return this;


    }
}
