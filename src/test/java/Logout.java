import org.testng.annotations.Test;

public class Logout extends DriverHolder {
    @Test
    public void LogOut() {
        loginPage.goTo()
                .typeUsername()
                .typePassword()
                .clickSignIn();
        leftSideBar.checkUserLoggedByURL()
                .clickGearIcon();
        gearMenu.clickTheLogOutButton();
        loginPage.checkStartPositionByURL();

    }
}
