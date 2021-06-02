import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePattern {
    private static final String USERNAME = "//*[@id='identification']";
    private static final String PASSWORD = "//*[@id='password']";
    private static final String SIGN_IN_BUTTON = "//button[contains(text(),'Sign in')]";
    private static final String SITE_URL = "http://demo.hospitalrun.io/";
    private static final String CREDENTIAL_USERNAME = "hr.doctor@hospitalrun.io";
    private static final String CREDENTIAL_PASSWORD = "HRt3st12";
    // credentials for negative tests
    private static final String WRONG_CRED_USERNAME = "hr.doctorhospitalrun.io";
    private static final String WRONG_CRED_PASSWORD = "1111";
    // validation - error messages
    private static final String ERROR_EMPTY_FIELDS = "[class='alert alert-danger form-signin-alert']";



    @FindBy(how = How.XPATH, using = USERNAME)
    private WebElement username;

    @FindBy(how = How.XPATH, using = PASSWORD)
    private WebElement password;

    @FindBy(how = How.XPATH, using = SIGN_IN_BUTTON)
    private WebElement signInButton;


    @Step ("main page opening")
    public  LoginPage goTo () {
        driver.get(SITE_URL);
        return this;
    }
    @Step ("entering a username in the field")
    public   LoginPage typeUsername () {
        typing(By.xpath(USERNAME),ConfProperties.getProperty("loginn"));
        return this;
    }

    @Step ("entering a password in the field")
    public LoginPage typePassword () {
        typing(By.xpath(PASSWORD),ConfProperties.getProperty("password"));
        return this;
    }
    @Step ("click the  Sign in button after login/password field  are filled out ")
    public  LoginPage clickSignIn () {
        click(By.xpath(SIGN_IN_BUTTON));
        return this;
    }


    // methods for negative tests
    public  LoginPage typeWrongUsername () {
        typing(By.xpath(USERNAME),ConfProperties.getProperty("wrongLogin"));
        return this;
    }

    public  LoginPage typeWrongPassword () {
        typing(By.xpath(PASSWORD),ConfProperties.getProperty("wrongPassword"));
        return this;
    }

    public  LoginPage checkValidationFields () {
        String str = driver.findElement(By.cssSelector(ERROR_EMPTY_FIELDS)).getText();
        boolean isDisplayed = driver.findElement(By.cssSelector(ERROR_EMPTY_FIELDS)).isDisplayed();
        if (isDisplayed) {
            Assert.assertEquals(str, "Username or password is incorrect.", "The \"Username or password is incorrect.\" error message isn't displayed");
        }
        System.out.println("The user stayed on Login Page & validation error is displayed: " + str );
        return this;
    }

    public LoginPage checkStartPositionByURL() {
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        compareElements( "http://demo.hospitalrun.io/#/login", "User is still logged" );
        System.out.println("User logged out. The Login page is displayed");
        return this;
    }

}

