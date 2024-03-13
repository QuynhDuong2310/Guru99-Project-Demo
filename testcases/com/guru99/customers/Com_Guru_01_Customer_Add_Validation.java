

package com.guru99.customers;
import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.LoginPageObject;
import pageObjects.ManagerPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageGeneratorManager;
public class Com_Guru_01_Customer_Add_Validation extends BaseTest {
    WebDriver driver;
    BasePage basePage = new BasePage();
    public String customerID;
    String pinInvalidValue, emailInvalidFormat, emailInvalidFormat1, phoneNumberInvalidFormat;
    String customerNameTextbox, dateOfBirthTextbox, cityTextbox, stateTextbox, pinTextbox, mobileNumberTextbox, emailTextbox, passwordTextbox;
    String userID, password, newCustomerTab, numbericValue,  specialCharacter;
    LoginPageObject loginPageObject;
    ManagerPageObject managerPageobject;
    NewCustomerPageObject newCustomerPageObject;
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String urlValue) {
        driver = getBrowserName(browserName, urlValue);
        customerID = "33087";
        userID = "mngr556614";
        password = "umugEza";
        numbericValue = "123";
        specialCharacter = "^%$";
        newCustomerTab = "New Customer";
        customerNameTextbox = "Customer Name";
        dateOfBirthTextbox = "Date of Birth";
        cityTextbox = "City";
        stateTextbox = "State";
        pinTextbox = "PIN";
        mobileNumberTextbox = "Mobile Number";
        emailTextbox = "E-mail";
        passwordTextbox = "Password";
        pinInvalidValue = "123";
        emailInvalidFormat = "Guru@.com";
        emailInvalidFormat1 = "Gur u";
        phoneNumberInvalidFormat = "123 111";
        loginPageObject = PageGeneratorManager.getLoginPage(driver);
        loginPageObject.enterUserID(userID);
        loginPageObject.enterPassword(password);
        loginPageObject.clickToLoginButton();
        managerPageobject = PageGeneratorManager.getManagerPage(driver);
        managerPageobject.openNewPageByTabName(driver, newCustomerTab);
        newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
    }
    @Test
    public void TC_NC1_Name_Field_Cannot_Be_Empty() {
        newCustomerPageObject.pressTABAndMoveToNextField(customerNameTextbox);
        Assert.assertEquals(newCustomerPageObject.getCustomernameError(), "Customer name must not be blank");
        Assert.assertTrue(newCustomerPageObject.isCustomernameErrorDisplayed());
    }
    @Test
    public void TC_NC2_Name_Field_Cannot_Be_Numeric() {
        newCustomerPageObject.enterNumbericValueToCustomerNameFiled(customerNameTextbox, numbericValue);
        Assert.assertEquals(newCustomerPageObject.getCustomernameError(), "Numbers are not allowed");
        Assert.assertTrue(newCustomerPageObject.isCustomernameErrorDisplayed());
    }
    @Test
    public void TC_NC3_Name_Field_Cannot_Contains_Special_Characters() {
        newCustomerPageObject.enterSpecialCharacterToCustomerNameField(customerNameTextbox,specialCharacter);
        Assert.assertEquals(newCustomerPageObject.getCustomernameError(), "Special characters are not allowed");
        Assert.assertTrue(newCustomerPageObject.isCustomernameErrorDisplayed());
    }
    @Test
    public void TC_NC4_Name_Field_Cannot_Contains_Space_Characters_At_The_Beginning() {
        newCustomerPageObject.enterSpaceAsTheFirstCharacterToCustomerNameField(customerNameTextbox);
        Assert.assertEquals(newCustomerPageObject.getCustomernameError(), "First character can not have space");
        Assert.assertTrue(newCustomerPageObject.isCustomernameErrorDisplayed());
    }
    @Test
    public void TC_NC5_Address_Field_Cannot_Be_Empty() {
        newCustomerPageObject.pressTABToAddressFiledAndMoveToNextField();
        Assert.assertEquals(newCustomerPageObject.getAddressError(), "Address Field must not be blank");
        Assert.assertTrue(newCustomerPageObject.isAddressErrorDisplayed());
    }
    @Test
    public void TC_NC6_Address_Field_Cannot_Contains_Space_Characters_At_The_Beginning() {
        newCustomerPageObject.enterSpaceAsTheFirstCharacterToAddressField();
        Assert.assertEquals(newCustomerPageObject.getAddressError(), "First character can not have space");
        Assert.assertTrue(newCustomerPageObject.isAddressErrorDisplayed());
    }
    @Test
    public void TC_NC8_City_Field_Cannot_Be_Empty() {
        newCustomerPageObject.pressTABToCityFieldAndMoveToNextField(cityTextbox);
        Assert.assertEquals(newCustomerPageObject.getCityError(), "City Field must not be blank");
        Assert.assertTrue(newCustomerPageObject.isCityErrorDisplayed());
    }
    @Test
    public void TC_NC9_City_Field_Cannot_Be_Numeric() {
        newCustomerPageObject.enterNumbericValueToCityFiled(cityTextbox, numbericValue);
        Assert.assertEquals(newCustomerPageObject.getCityError(), "Numbers are not allowed");
        Assert.assertTrue(newCustomerPageObject.isCityErrorDisplayed());
    }
    @Test
    public void TC_NC10_City_Field_Cannot_Contains_Special_Characters() {
        newCustomerPageObject.enterSpecialCharacterToCityField(cityTextbox, specialCharacter);
        Assert.assertEquals(newCustomerPageObject.getCityError(), "Special characters are not allowed");
        Assert.assertTrue(newCustomerPageObject.isCityErrorDisplayed());
    }
    @Test
    public void TC_NC11_City_Field_Cannot_Contains_Space_Characters_At_The_Beginning() {
        newCustomerPageObject.enterSpaceAsTheFirstCharacterToCityField(cityTextbox);
        Assert.assertEquals(newCustomerPageObject.getCityError(), "First character can not have space");
        Assert.assertTrue(newCustomerPageObject.isCityErrorDisplayed());
    }
    @Test
    public void TC_NC12_State_Field_Cannot_Be_Empty() {
        newCustomerPageObject.pressTABToStateFieldAndMoveToNextField(stateTextbox);
        Assert.assertEquals(newCustomerPageObject.getStateError(), "State must not be blank");
        Assert.assertTrue(newCustomerPageObject.isStateErrorDisplayed());
    }
    @Test
    public void TC_NC13_State_Field_Cannot_Be_Numeric() {
        newCustomerPageObject.enterNumbericValueToStateFiled(stateTextbox, numbericValue);
        Assert.assertEquals(newCustomerPageObject.getStateError(), "Numbers are not allowed");
        Assert.assertTrue(newCustomerPageObject.isStateErrorDisplayed());
    }
    @Test
    public void TC_NC14_State_Field_Cannot_Contains_Special_Characters() {
        newCustomerPageObject.enterSpecialCharacterToStateyField(stateTextbox, specialCharacter);
        Assert.assertEquals(newCustomerPageObject.getStateError(), "Special characters are not allowed");
        Assert.assertTrue(newCustomerPageObject.isStateErrorDisplayed());
    }
    @Test
    public void TC_NC15_State_Field_Cannot_Contains_Space_Characters_At_The_Beginning() {
        newCustomerPageObject.enterSpaceAsTheFirstCharacterToStateField(stateTextbox);
        Assert.assertEquals(newCustomerPageObject.getStateError(), "First character can not have space");
        Assert.assertTrue(newCustomerPageObject.isStateErrorDisplayed());
    }
    @Test
    public void TC_NC16_Pin_Field_Cannot_Be_Empty() {
        newCustomerPageObject.pressTABToPinFieldAndMoveToNextField(pinTextbox);
        Assert.assertEquals(newCustomerPageObject.getPineError(), "PIN Code must not be blank");
        Assert.assertTrue(newCustomerPageObject.isPinErrorDisplayed());
    }
    @Test
    public void TC_NC17_Pin_Field_Must_Be_Numeric() {
        newCustomerPageObject.enterCharactorValueToPinFiled(pinTextbox, pinTextbox);
        Assert.assertEquals(newCustomerPageObject.getPineError(), "Characters are not allowed");
        Assert.assertTrue(newCustomerPageObject.isPinErrorDisplayed());
    }
    @Test
    public void TC_NC18_Pin_Field_Cannot_Contains_Special_Characters() {
        newCustomerPageObject.enterSpecialCharacterToPinField(pinTextbox, specialCharacter);
        Assert.assertEquals(newCustomerPageObject.getPineError(), "Special characters are not allowed");
        Assert.assertTrue(newCustomerPageObject.isPinErrorDisplayed());
    }
    @Test
    public void TC_NC19_Pin_Field_Cannot_Contains_Space_Characters_At_The_Beginning() {
        newCustomerPageObject.enterSpaceAsTheFirstCharacterToPinField(pinTextbox);
        Assert.assertEquals(newCustomerPageObject.getPineError(), "First character can not have space");
        Assert.assertTrue(newCustomerPageObject.isPinErrorDisplayed());
    }
    @Test
    public void TC_NC20_Pin_Field_Must_Have_6_Digits() {
        newCustomerPageObject.enterLessThan6DigitsToPinField(pinTextbox, pinInvalidValue);
        Assert.assertEquals(newCustomerPageObject.getPineError(), "PIN Code must have 6 Digits");
        Assert.assertTrue(newCustomerPageObject.isPinErrorDisplayed());
    }
    @Test
    public void TC_NC22_Phone_Field_Cannot_Be_Empty() {
        newCustomerPageObject.pressTABToPhoneFieldAndMoveToNextField(mobileNumberTextbox);
        Assert.assertEquals(newCustomerPageObject.getPhoneError(), "Mobile no must not be blank");
        Assert.assertTrue(newCustomerPageObject.isPhoneErrorDisplayed());
    }
    @Test
    public void TC_NC23_Phone_Field__Cannot_Contains_Space_Characters_At_The_Beginning() {
        newCustomerPageObject.enterSpaceAsTheFirstCharacterToPhoneField(mobileNumberTextbox);
        Assert.assertEquals(newCustomerPageObject.getPhoneError(), "First character can not have space");
        Assert.assertTrue(newCustomerPageObject.isPhoneErrorDisplayed());
    }
    @Test
    public void TC_NC24_Phone_Field_Cannot_Have_Space() {
        newCustomerPageObject.enterAnSpaceToPhoneField(mobileNumberTextbox, phoneNumberInvalidFormat);
        Assert.assertEquals(newCustomerPageObject.getPhoneError(), "Characters are not allowed");
        Assert.assertTrue(newCustomerPageObject.isPhoneErrorDisplayed());
    }
    @Test
    public void TC_NC25_Phone_Field_Cannot_Have_Space() {
        newCustomerPageObject.enterAnSpecialCharactorToPhoneField(mobileNumberTextbox, specialCharacter);
        Assert.assertEquals(newCustomerPageObject.getPhoneError(), "Special characters are not allowed");
        Assert.assertTrue(newCustomerPageObject.isPhoneErrorDisplayed());
    }
    @Test
    public void TC_NC26_Email_Field_Cannot_Be_Empty() {
        newCustomerPageObject.pressTABToEmailFieldAndMoveToNextField(emailTextbox);
        Assert.assertEquals(newCustomerPageObject.getEmailError(), "Email-ID must not be blank");
        Assert.assertTrue(newCustomerPageObject.isEmailErrorDisplayed());
    }
    @Test
    public void TC_NC27_Email_Field_Must_Be_Valid_Format() {
        newCustomerPageObject.enterInvalidFormatToEmailField(emailTextbox, emailInvalidFormat);
        Assert.assertEquals(newCustomerPageObject.getEmailError(), "Email-ID is not valid");
        Assert.assertTrue(newCustomerPageObject.isEmailErrorDisplayed());
    }
    @Test
    public void TC_NC28_Email_Field_Cannot_Have_Space() {
        newCustomerPageObject.enterAnSpaceToEmailField(emailTextbox, emailInvalidFormat1);
        Assert.assertEquals(newCustomerPageObject.getEmailError(), "Email-ID is not valid");
        Assert.assertTrue(newCustomerPageObject.isEmailErrorDisplayed());
    }
    @AfterTest
    public void afterClass() {
        driver.quit();
    }
}
 