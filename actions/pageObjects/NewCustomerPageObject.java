

package pageObjects;
import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageUIs.NewCustomerPageUI;
public class NewCustomerPageObject extends BasePage {
    WebDriver driver;
    public NewCustomerPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public void pressTABAndMoveToNextField(String customerName) {
        /*waitForElementClickable(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX,customerName);
        clickToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX,customerName);*/
        sendKeyBoardToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, Keys.TAB, customerName);
    }
    public boolean isCustomernameErrorDisplayed() {
        waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_COMMON_ERROR);
        return isElementDisplayed(driver, NewCustomerPageUI.CUSTOMER_NAME_COMMON_ERROR);
    }
    public void enterNumbericValueToCustomerNameFiled(String customerName, String numbericValue) {
        waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, customerName);
        clickToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, customerName);
        sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, numbericValue, customerName);
    }
    public String getCustomernameError() {
        waitForElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_COMMON_ERROR);
        return getElementText(driver, NewCustomerPageUI.CUSTOMER_NAME_COMMON_ERROR);
    }
    public void enterSpecialCharacterToCustomerNameField(String customerName, String specialCharacter) {
        waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, customerName);
        clickToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, customerName);
        sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, specialCharacter, customerName);
    }
    public void enterSpaceAsTheFirstCharacterToCustomerNameField(String customerName) {
        sendKeyBoardToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, Keys.SPACE, customerName);
    }
    public void enterSpaceAsTheFirstCharacterTAddressField(String customerName) {
        sendKeyBoardToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA, Keys.TAB, customerName);
    }
    public String getAddressError() {
        waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_COMMON_ERROR);
        return getElementText(driver, NewCustomerPageUI.ADDRESS_COMMON_ERROR);
    }
    public boolean isAddressErrorDisplayed() {
        waitForElementVisible(driver, NewCustomerPageUI.ADDRESS_COMMON_ERROR);
        return isElementDisplayed(driver, NewCustomerPageUI.ADDRESS_COMMON_ERROR);
    }
    public void pressTABToAddressFiledAndMoveToNextField() {
        sendKeyBoardToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA, Keys.TAB);
    }
    public void enterSpaceAsTheFirstCharacterToAddressField() {
        sendKeyBoardToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA, Keys.SPACE);
    }
    public void pressTABToCityFieldAndMoveToNextField(String cityTextbox) {
        sendKeyBoardToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, Keys.TAB, cityTextbox);
    }
    public String getCityError() {
        waitForElementVisible(driver, NewCustomerPageUI.CITY_COMMON_ERROR);
        return getElementText(driver, NewCustomerPageUI.CITY_COMMON_ERROR);
    }
    public boolean isCityErrorDisplayed() {
        waitForElementVisible(driver, NewCustomerPageUI.CITY_COMMON_ERROR);
        return isElementDisplayed(driver, NewCustomerPageUI.CITY_COMMON_ERROR);
    }
    public void enterNumbericValueToCityFiled(String cityTextbox, String numbericValue) {
        waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, cityTextbox);
        clickToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, cityTextbox);
        sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, numbericValue, cityTextbox);
    }
    public void enterSpecialCharacterToCityField(String cityTextbox, String specialCharacter) {
        waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, cityTextbox);
        clickToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, cityTextbox);
        sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, specialCharacter, cityTextbox);
    }
    public void enterSpaceAsTheFirstCharacterToCityField(String cityTextbox) {
        sendKeyBoardToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, Keys.SPACE, cityTextbox);
    }
    public void pressTABToStateFieldAndMoveToNextField(String stateTextbox) {
        sendKeyBoardToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, Keys.TAB, stateTextbox);
    }
    public void enterNumbericValueToStateFiled(String stateTextbox, String numbericValue) {
        waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, stateTextbox);
        clickToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, stateTextbox);
        sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, numbericValue, stateTextbox);
    }
    public String getStateError() {
        waitForElementVisible(driver, NewCustomerPageUI.STATE_COMMON_ERROR);
        return getElementText(driver, NewCustomerPageUI.STATE_COMMON_ERROR);
    }
    public boolean isStateErrorDisplayed() {
        waitForElementVisible(driver, NewCustomerPageUI.STATE_COMMON_ERROR);
        return isElementDisplayed(driver, NewCustomerPageUI.STATE_COMMON_ERROR);
    }
    public void enterSpecialCharacterToStateyField(String stateTextbox, String specialCharacter) {
        waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, stateTextbox);
        clickToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, stateTextbox);
        sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, specialCharacter, stateTextbox);
    }
    public void enterSpaceAsTheFirstCharacterToStateField(String stateTextbox) {
        sendKeyBoardToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, Keys.SPACE, stateTextbox);
    }
    public void pressTABToPinFieldAndMoveToNextField(String pinTextbox) {
        sendKeyBoardToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, Keys.TAB, pinTextbox);
    }
    public String getPineError() {
        waitForElementVisible(driver, NewCustomerPageUI.PIN_COMMON_ERROR);
        return getElementText(driver, NewCustomerPageUI.PIN_COMMON_ERROR);
    }
    public boolean isPinErrorDisplayed() {
        waitForElementVisible(driver, NewCustomerPageUI.PIN_COMMON_ERROR);
        return isElementDisplayed(driver, NewCustomerPageUI.PIN_COMMON_ERROR);
    }
    public void enterCharactorValueToPinFiled(String pinTextbox, String pinTextbox1) {
        waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, pinTextbox1);
        clickToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, pinTextbox1);
        sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, pinTextbox1, pinTextbox);
    }
    public void enterSpecialCharacterToPinField(String pinTextbox, String specialCharacter) {
        waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, pinTextbox);
        clickToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, pinTextbox);
        sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, specialCharacter, pinTextbox);
    }
    public void enterSpaceAsTheFirstCharacterToPinField(String pinTextbox) {
        sendKeyBoardToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, Keys.SPACE, pinTextbox);
    }
    public void enterLessThan6DigitsToPinField(String pinTextbox, String pinInvalidValue) {
        waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, pinTextbox);
        clickToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, pinTextbox);
        sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, pinInvalidValue, pinTextbox);
    }
    public String getEmailError() {
        waitForElementVisible(driver, NewCustomerPageUI.EMAIL_COMMON_ERROR);
        return getElementText(driver, NewCustomerPageUI.EMAIL_COMMON_ERROR);
    }
    public boolean isEmailErrorDisplayed() {
        waitForElementVisible(driver, NewCustomerPageUI.EMAIL_COMMON_ERROR);
        return isElementDisplayed(driver, NewCustomerPageUI.EMAIL_COMMON_ERROR);
    }
    public void pressTABToEmailFieldAndMoveToNextField(String emailTextbox) {
        sendKeyBoardToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, Keys.TAB, emailTextbox);
    }
    public void enterInvalidFormatToEmailField(String emailTextbox, String emailInvalidFormat) {
        waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, emailTextbox);
        clickToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, emailTextbox);
        sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, emailInvalidFormat, emailTextbox);
    }
    public void enterAnSpaceToEmailField(String emailTextbox, String emailInvalidFormat1) {
        waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, emailTextbox);
        clickToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, emailTextbox);
        sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, emailInvalidFormat1, emailTextbox);
    }
    public String getPhoneError() {
        waitForElementVisible(driver, NewCustomerPageUI.PHONE_COMMON_ERROR);
        return getElementText(driver, NewCustomerPageUI.PHONE_COMMON_ERROR);
    }
    public boolean isPhoneErrorDisplayed() {
        waitForElementVisible(driver, NewCustomerPageUI.PHONE_COMMON_ERROR);
        return isElementDisplayed(driver, NewCustomerPageUI.PHONE_COMMON_ERROR);
    }
    public void enterAnSpecialCharactorToPhoneField(String phoneTextbox, String specialCharacter) {
        waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, phoneTextbox);
        clickToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, phoneTextbox);
        sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, specialCharacter, phoneTextbox);
    }

    public void enterAnSpaceToPhoneField(String phoneTextbox, String phoneNumberInvalidFormat) {
        waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, phoneTextbox);
        clickToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, phoneTextbox);
        sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, phoneNumberInvalidFormat, phoneTextbox);
    }
    public void enterSpaceAsTheFirstCharacterToPhoneField(String mobileNumberTextbox) {
        sendKeyBoardToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, Keys.SPACE, mobileNumberTextbox);
    }

    public void pressTABToPhoneFieldAndMoveToNextField(String mobileNumberTextbox) {
        sendKeyBoardToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, Keys.TAB, mobileNumberTextbox);
    }

    public void enterAnValidCustomerName(String customerNameTextbox, String validCustomerNameValue) {
        clickToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, customerNameTextbox);
        sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, validCustomerNameValue, customerNameTextbox);
    }
    public void enterDateOfBirth(String dateOfBirthTextbox, String validDateValue) {
        // Remove the attribute type="date" >> In order to send value to Date of birth textbox.
        removeAttributeInDOM(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, "type", dateOfBirthTextbox);
        clickToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, dateOfBirthTextbox);
        sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, validDateValue, dateOfBirthTextbox);
    }

    public void enterAnValidAddress(String validAddressValue) {
        clickToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA, validAddressValue);
        sendKeyToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA, validAddressValue);
    }
    public void enterAnValidCity(String cityTextbox, String validCityValue) {
        clickToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, cityTextbox);
        sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, validCityValue, cityTextbox);
    }
    public void enterAnValidState(String stateTextbox, String validStateValue) {
        clickToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, stateTextbox);
        sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, validStateValue, stateTextbox);
    }
    public void enterAnValidPin(String pinTextbox, String validPinValue) {
        clickToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, pinTextbox);
        sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, validPinValue, pinTextbox);
    }
    public void enterAnValidMobileNumber(String mobileNumberTextbox, String validPhoneValue) {
        clickToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, mobileNumberTextbox);
        sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, validPhoneValue, mobileNumberTextbox);
    }
    public void enterAnValidEmail(String emailTextbox, String randomEmailValue) {
        clickToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, emailTextbox);
        sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, randomEmailValue, emailTextbox);
    }
    public void enterAnValidPassword(String passwordTextbox, String validPasswordValue) {
        clickToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, passwordTextbox);
        sendKeyToElement(driver, NewCustomerPageUI.DYNAMIC_NEW_CUSTOMER_TEXTBOX, validPasswordValue, passwordTextbox);
    }
    public void clickToSubmitButton() {
        waitForElementClickable(driver, NewCustomerPageUI.SUBMIT_BUTTON);
        clickToElement(driver, NewCustomerPageUI.SUBMIT_BUTTON);
        //acceptAlert(driver);
    }
    public String getNewCustomerCreatoinSuccessMessage() {
        waitForElementVisible(driver, NewCustomerPageUI.SUCCESS_MESSAGE);
        return getElementText(driver, NewCustomerPageUI.SUCCESS_MESSAGE);
    }
    public String getCustomerIDInformation(String customerID) {
        waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_INFORMATION_CUSTOMER_TEXTBOX, customerID);
        return getElementText(driver, NewCustomerPageUI.DYNAMIC_INFORMATION_CUSTOMER_TEXTBOX, customerID);
    }
    public String getCustomerNameInformation(String customerNameCol) {
        waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_INFORMATION_CUSTOMER_TEXTBOX, customerNameCol);
        return getElementText(driver, NewCustomerPageUI.DYNAMIC_INFORMATION_CUSTOMER_TEXTBOX, customerNameCol);
    }
    public String getCustomerAddressInformation(String address) {
        waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_INFORMATION_CUSTOMER_TEXTBOX, address);
        return getElementText(driver, NewCustomerPageUI.DYNAMIC_INFORMATION_CUSTOMER_TEXTBOX, address);
    }
    public String getCustomerCityInformation(String cityCol) {
        waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_INFORMATION_CUSTOMER_TEXTBOX, cityCol);
        return getElementText(driver, NewCustomerPageUI.DYNAMIC_INFORMATION_CUSTOMER_TEXTBOX, cityCol);
    }
    public String getCustomerStateInformation(String stateCol) {
        waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_INFORMATION_CUSTOMER_TEXTBOX, stateCol);
        return getElementText(driver, NewCustomerPageUI.DYNAMIC_INFORMATION_CUSTOMER_TEXTBOX, stateCol);
    }
    public String getCustomerPinInformation(String pinCol) {
        waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_INFORMATION_CUSTOMER_TEXTBOX, pinCol);
        return getElementText(driver, NewCustomerPageUI.DYNAMIC_INFORMATION_CUSTOMER_TEXTBOX, pinCol);
    }
    public String getCustomerPhoneInformation(String phoneCol) {
        waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_INFORMATION_CUSTOMER_TEXTBOX, phoneCol);
        return getElementText(driver, NewCustomerPageUI.DYNAMIC_INFORMATION_CUSTOMER_TEXTBOX, phoneCol);
    }
    public String getCustomerEmailInformation(String emailCol) {
        waitForElementVisible(driver, NewCustomerPageUI.DYNAMIC_INFORMATION_CUSTOMER_TEXTBOX, emailCol);
        return getElementText(driver, NewCustomerPageUI.DYNAMIC_INFORMATION_CUSTOMER_TEXTBOX, emailCol);
    }
}
 