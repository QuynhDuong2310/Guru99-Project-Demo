

package pageObjects;
import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageUIs.DeleteCustomerPageUI;
public class DeleteCustomerPageObject extends BasePage {
    WebDriver driver;
    public DeleteCustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void pressTABToCustomerIDTextbox() {
        sendKeyBoardToElement(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX, Keys.TAB);
    }

    public String getCustomerIdError() {
        waitForElementVisible(driver, DeleteCustomerPageUI.DELETE_CCUSTOMER_COMMON_ERROR);
        return getElementText(driver, DeleteCustomerPageUI.DELETE_CCUSTOMER_COMMON_ERROR);

    }
    public boolean isCustomerIdErrorDisplayed() {
        waitForElementVisible(driver, DeleteCustomerPageUI.DELETE_CCUSTOMER_COMMON_ERROR);
        return isElementDisplayed(driver, DeleteCustomerPageUI.DELETE_CCUSTOMER_COMMON_ERROR);
    }

    public void enterCharactorValueToCustomerFiled(String charactor) {
        waitForElementVisible(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX, charactor);
        clickToElement(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX, charactor);
        sendKeyToElement(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX, charactor);
    }
    public void enterSpecialCharacterToCustomerIDField(String specialChar) {
        waitForElementVisible(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX, specialChar);
        clickToElement(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX, specialChar);
        sendKeyToElement(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX, specialChar);
    }

    public void enterSpaceCharacterToCustomerIDField() {
        sendKeyBoardToElement(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX, Keys.SPACE);
    }
    public void enterValidValueToCustomerIDField(String number) {
        waitForElementVisible(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX);
        clickToElement(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX);
        sendKeyToElement(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX, number);
    }
    public void clickToSubmitButton() {
        waitForElementClickable(driver, DeleteCustomerPageUI.SUBMIT_BUTTON);
        clickToElement(driver, DeleteCustomerPageUI.SUBMIT_BUTTON);
    }
    public void clickToCancelButtonOnConfirmALert() {
        waitAlertPresence(driver);
        sleepInSecond(3);
        cancelAlert(driver);
    }
    public void clickToAcceptButtonOnConfirmALert() {
        waitAlertPresence(driver);
        sleepInSecond(3);
        acceptAlert(driver);
    }
    public String getTheAlertText() {
        waitAlertPresence(driver);
        sleepInSecond(3);
        return getAlertText(driver);
    }
    public void sleepInSecond(long sleepInSecond) {
        try {
            Thread.sleep(1000 * sleepInSecond);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void clickToCofirmAlert() {
        waitAlertPresence(driver);
        acceptAlert(driver);
    }
}
 