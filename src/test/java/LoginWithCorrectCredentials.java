import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginWithCorrectCredentials extends DriverHolder {
    @Test(priority = 1, description = "checking of login with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Allure - Checking of login with valid credentials" )
    @Story("Login flow")

    public void LoginPositiveCase () {

      loginPage.goTo()
              .typeUsername()
              .typePassword()
              .clickSignIn();

      leftSideBar.checkUserLoggedByURL();



    }

}