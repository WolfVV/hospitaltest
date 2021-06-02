import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class NewMedicationRequestApplication extends BasePattern {
    private static final String PATIENT_FIELD = "//input[starts-with(@id,'patientTypeAhead-ember')]";
    private static final String PATIENT_DATA_FIELD = "//div[text() = ' - P00201']";
    private static final String VISIT_FIELD = "[class='form-control ']";
    private static final String MEDICATION_FIELD = "//span/input[starts-with(@id,'inventoryItemTypeAhead-ember')]";
    private static final String PRESCRIPTION_FIELD = "//textarea[@class='form-control  ember-text-area ember-view']";
    private static final String PRESCRIPTION_DATE_FIELD = "//input[starts-with(@id,'display_prescriptionDate-ember')]";
    private static final String QUANTITY_REQUESTED = "//input[starts-with(@id,'quantity-ember')]";
    private static final String REFILLS = "//input[starts-with(@id,'refills-ember')]";
    private static final String FULFILL_REQUEST = "[id='shouldFulfillRequest-ember1274']";
    private static final String ADD_BUTTON = "[class='btn btn-primary on-white ']";

    public String patient_name = "Test Patient";
    public String medication_name = "Pramoxine";
    public String prescription_text = "Testing prescription";

    @FindBy(xpath = PATIENT_FIELD)
    WebElement patient;

    @FindBy(xpath = PRESCRIPTION_DATE_FIELD)
    private WebElement prescriptionDateField;

    @FindBy(xpath = QUANTITY_REQUESTED)
    private WebElement quantityRequested;

    @FindBy(xpath = REFILLS)
    private WebElement refills;



    public  NewMedicationRequestApplication fillOutThePatientName(WebElement webElement, String text) {
        webElement.clear();
        for (int i = 0; i < text.length(); i++) {
            webElement.sendKeys(String.valueOf(text.charAt(i)));
            try {
                sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this;
    }
    public  NewMedicationRequestApplication selectPatient () {
        click(By.xpath(PATIENT_DATA_FIELD));
        return this;
    }

    public  NewMedicationRequestApplication clickVisit () {
        click(By.cssSelector(VISIT_FIELD));
        return this;
    }
    public  NewMedicationRequestApplication selectDataOfVisit() {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        List<WebElement> list = driver.findElements(By.cssSelector("[value]"));
        int size = list.size();
        int rand = ThreadLocalRandom.current().nextInt(0, size);
        list.get(rand).click();
        return this;
    }

    public  NewMedicationRequestApplication fillOutTheMedicationName  () {
        typing(By.xpath(MEDICATION_FIELD),medication_name);
        return this;
    }

    public  NewMedicationRequestApplication selectMedication() {
        List<WebElement> listOfMedication = driver.findElements(By.xpath("//div[@class= 'tt-dataset tt-dataset-1']/*"));
        int size = listOfMedication.size();
        int rand = ThreadLocalRandom.current().nextInt(0, size);
        listOfMedication.get(rand).click();
        return this;
    }

    public  NewMedicationRequestApplication fillOutThePrescriptionField () {
        typing(By.xpath(PRESCRIPTION_FIELD),prescription_text);
        return this;
    }

    public  NewMedicationRequestApplication fillOutPrescriptionDate() throws ParseException {
        String d = "MM/dd/yyyy";
        DateFormat dataFormat = new SimpleDateFormat(d);
        Date currentDate = new Date();
        String yesterday = dataFormat.format(currentDate);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(simpleDateFormat.parse(yesterday));
        calendar.add(Calendar.DATE, -1);
        yesterday = simpleDateFormat.format(calendar.getTime());
        prescriptionDateField.clear();
        prescriptionDateField.sendKeys(yesterday);
        prescriptionDateField.sendKeys(Keys.TAB);
        return this;
    }

    public  NewMedicationRequestApplication fillOutQuantityRequested() {
        quantityRequested.sendKeys(Integer.toString(new Random().nextInt(5)+1));
        return this;
    }

    public  NewMedicationRequestApplication fillOutRefills() {
        refills.sendKeys(Integer.toString(new Random().nextInt(5)+5));
        return this;
    }

    public  NewMedicationRequestApplication clickAddButton () {
        click(By.cssSelector(ADD_BUTTON));
        return this;
    }

    public  NewMedicationRequestApplication checkApplicationIsSaved () {
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        Assert.assertNotEquals(driver.getCurrentUrl(),"http://demo.hospitalrun.io/#/medication/edit/new", " Medication Request Saved popup isn`t displayed and\n" +
                "User stayed on New Medication Request Page");
        return this;
    }
}
