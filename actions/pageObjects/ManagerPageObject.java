

package pageObjects;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.ManagerAbstractPageUI;
public class ManagerPageObject extends BasePage {
    WebDriver driver;
    public ManagerPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void clickToNewCustomerPage(String tabName) {
        openNewPageByTabName(driver,tabName);
    }
}
 