import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class GearMenu extends BasePattern {
    private static final String LOG_OUT_BUTTON = "//a[contains(text(),'Logout')]";




    public  void clickTheLogOutButton() {
        click(By.xpath(LOG_OUT_BUTTON));
    }
}
