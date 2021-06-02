import org.testng.annotations.Test;

import java.text.ParseException;

public class RequestNewMedication extends DriverHolder {
    @Test
    public void RequestOfTheMedication() throws ParseException {
        loginPage.goTo()
                .typeUsername()
                .typePassword()
                .clickSignIn();
        leftSideBar.clickMedication();
        medicationSuboptions.checkOfDisplayingRequestsButton().checkOfDisplayingCompletedButton().checkOfDisplayingNewRequestButton().checkOfDisplayingReturnMedicationButton()
                .clickNewRequest();
        newMedicationRequestApplication.fillOutThePatientName(newMedicationRequestApplication.patient, newMedicationRequestApplication.patient_name)
                .selectPatient()
                .clickVisit()
                .selectDataOfVisit()
                .fillOutTheMedicationName()
                .selectMedication()
                .fillOutThePrescriptionField()
                .fillOutPrescriptionDate()
                .fillOutQuantityRequested()
                .fillOutRefills()
                .clickAddButton();
        medicationRequestSavedPopup.textRequestSavedIsDisplayed()
                .CrossButtonVisibility()
                .OkButtonVisibility()
                .clickOKbutton();
        newMedicationRequestApplication.checkApplicationIsSaved();


    }
}
