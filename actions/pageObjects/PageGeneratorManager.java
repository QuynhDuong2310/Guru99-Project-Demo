

package pageObjects;
import org.openqa.selenium.WebDriver;
public class PageGeneratorManager {

    public static NewCustomerPageObject getNewCustomerPage(WebDriver driver) {
        return new NewCustomerPageObject(driver);
    }
    public static ManagerPageObject getManagerPage(WebDriver driver) {
        return new ManagerPageObject(driver);
    }
    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }
    public static EditCustomerPageObject getEditCustomerPage(WebDriver driver) {
        return new EditCustomerPageObject(driver);
    }
    public static DeleteCustomerPageObject getDeleteCustomerPage(WebDriver driver) {
        return new DeleteCustomerPageObject(driver);
    }
}
 