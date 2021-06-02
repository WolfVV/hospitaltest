import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverHolder {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    protected static WebDriver driver;

    public BasePattern basePattern;
    public LoginPage loginPage;
    public GearMenu gearMenu;
    public LeftSideBar leftSideBar;
    public MedicationSuboptions medicationSuboptions;
    public NewMedicationRequestApplication newMedicationRequestApplication;
    public MedicationRequestSavedPopup medicationRequestSavedPopup;

    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static final String CHROME_DRIVER_LOCATION = "src/test/WebDrivers/GoogleChrome/90.0.4430.24/chromedriver.exe";
    private static final String MOZILLA_DRIVER_LOCATION = "src/test/WebDrivers/MozillaFirefox/v0.29.0/x64/Windows/geckodriver.exe";
    private static final String MOZILLA_DRIVER_PROPERTY = "webdriver.gecko.driver";





    public static WebDriver getDriver () {
        return DRIVER.get();
    }

@BeforeTest
@Parameters("browser")
    public void start (String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty(MOZILLA_DRIVER_PROPERTY, MOZILLA_DRIVER_LOCATION);
            FirefoxOptions options = new FirefoxOptions();
//            options.setHeadless(true);
            driver = new FirefoxDriver();
            DRIVER.set(driver);
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty(CHROME_DRIVER_PROPERTY, CHROME_DRIVER_LOCATION);
            ChromeOptions options1 = new ChromeOptions();
            options1.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//            options.setHeadless(true);
            driver = new ChromeDriver();
            DRIVER.set(driver);
        }
        driver.manage().window().maximize();
        initElem();


    }







    public void initElem () {
        basePattern = PageFactory.initElements(driver, BasePattern.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        gearMenu = PageFactory.initElements(driver, GearMenu.class);
        leftSideBar = PageFactory.initElements(driver, LeftSideBar.class);
        medicationSuboptions = PageFactory.initElements(driver, MedicationSuboptions.class);
        newMedicationRequestApplication = PageFactory.initElements(driver, NewMedicationRequestApplication.class);
        medicationRequestSavedPopup = PageFactory.initElements(driver, MedicationRequestSavedPopup.class);
    }

//@AfterTest
//    public void finish() {
//        driver.close();
//    }






}
