

package pageObjects;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;
import pageUIs.ManagerAbstractPageUI;
public class LoginPageObject extends BasePage {
    WebDriver driver;
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserID(String userID) {
        waitForElementClickable(driver, LoginPageUI.USERNAME_TEXTBOX);
        clickToElement(driver, LoginPageUI.USERNAME_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX, userID);
    }
    public void enterPassword(String passWord) {
        waitForElementClickable(driver, LoginPageUI.PASSWORD_TEXTBOX);
        clickToElement(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passWord);
    }

    public ManagerPageObject clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        waitForElementVisible(driver, ManagerAbstractPageUI.WELCOME_MESSAGE);
        return PageGeneratorManager.getManagerPage(driver);
    }
}
 