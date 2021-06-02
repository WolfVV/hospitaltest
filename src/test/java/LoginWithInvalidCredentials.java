
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginWithInvalidCredentials extends DriverHolder {

    @Test
    public void LoginInvalidCredentials () {

        loginPage.goTo()
                .typeWrongUsername()
                .typeWrongPassword()
                .clickSignIn()
                .checkValidationFields();






    }
}
