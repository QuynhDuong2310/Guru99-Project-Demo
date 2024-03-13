

package pageObjects;
import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageUIs.EditCustomerPageUI;

public class EditCustomerPageObject extends BasePage {
    WebDriver driver;
    public EditCustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void pressTABToCustomerIDTextbox() {
        sendKeyBoardToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, Keys.TAB);
    }
    public String getCustomerIdError() {
        waitForElementVisible(driver, EditCustomerPageUI.EDIT_CUSTOMER_ID_COMMON_ERROR);
        return getElementText(driver, EditCustomerPageUI.EDIT_CUSTOMER_ID_COMMON_ERROR);
    }
    public boolean isCustomerIdErrorDisplayed() {
        waitForElementVisible(driver, EditCustomerPageUI.EDIT_CUSTOMER_ID_COMMON_ERROR);
        return isElementDisplayed(driver, EditCustomerPageUI.EDIT_CUSTOMER_ID_COMMON_ERROR);
    }
    public void enterCharactorValueToCustomerFiled(String charactor) {
        waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, charactor);
        clickToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, charactor);
        sendKeyToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, charactor);
    }

    public void enterSpecialCharacterToCustomerIDField(String specialCharactrr) {
        waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, specialCharactrr);
        clickToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, specialCharactrr);
        sendKeyToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, specialCharactrr);
    }
    public void enterValidValueToCustomerIDField(String validNumber) {
        waitForElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, validNumber);
        clickToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, validNumber);
        sendKeyToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, validNumber);
        clickToElement(driver, EditCustomerPageUI.SUBMIT_BUTTON);
    }
    public boolean isEditCustomerFormDisplayed() {
        waitForElementVisible(driver, EditCustomerPageUI.EDIT_CUSTOMER_TABLE);
        return isElementDisplayed(driver, EditCustomerPageUI.EDIT_CUSTOMER_TABLE);
    }
    public boolean isCustomerNameTextboxDisabled(String customerNameTextbox) {
        waitForElementVisible(driver, EditCustomerPageUI.DYNAMIC_EDIT_CUSTOMER_TEXTBOX, customerNameTextbox);
        return isElementEnabled(driver, EditCustomerPageUI.EDIT_CUSTOMER_TABLE, customerNameTextbox);
    }
    public boolean isCustomerGenderTextboxDisabled(String customerGenderTextbox) {
        waitForElementVisible(driver, EditCustomerPageUI.DYNAMIC_EDIT_CUSTOMER_TEXTBOX, customerGenderTextbox);
        if(isElementEnabled(driver, EditCustomerPageUI.EDIT_CUSTOMER_TABLE, customerGenderTextbox)){
            return true;
        } return false;
    }
    public boolean isCustomerDOBTextboxDisabled(String dateOfBirthTextbox) {
        waitForElementVisible(driver, EditCustomerPageUI.DYNAMIC_EDIT_CUSTOMER_TEXTBOX, dateOfBirthTextbox);
        return isElementEnabled(driver, EditCustomerPageUI.EDIT_CUSTOMER_TABLE, dateOfBirthTextbox);
    }
}
 