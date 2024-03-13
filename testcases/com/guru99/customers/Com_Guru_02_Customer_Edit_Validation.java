

package com.guru99.customers;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
public class Com_Guru_02_Customer_Edit_Validation extends BaseTest {
    WebDriver driver;
    String customerID = "97139";
    String pinInvalidValue, emailInvalidFormat, emailInvalidFormat1, phoneNumberInvalidFormat;
    String customerNameTextbox, customerGenderTextbox, dateOfBirthTextbox, cityTextbox, stateTextbox, pinTextbox, mobileNumberTextbox, emailTextbox, passwordTextbox;
    String newCustomerTab, editCustomerTab;
    String userID, password, numbericValue, specialCharacter;
    LoginPageObject loginPageObject;
    ManagerPageObject managerPageobject;
    NewCustomerPageObject newCustomerPageObject;
    EditCustomerPageObject editCustomerPageObject;
    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String urlValue) {
        driver = getBrowserName(browserName, urlValue);
        userID = "mngr556614";
        password = "umugEza";
        numbericValue = "123";
        specialCharacter = "^%$";
        newCustomerTab = "New Customer";
        editCustomerTab = "Edit Customer";
        customerNameTextbox = "Customer Name";
        customerGenderTextbox = "Gender";
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
        managerPageobject.openNewPageByTabName(driver, editCustomerTab);
        editCustomerPageObject = PageGeneratorManager.getEditCustomerPage(driver);
    }
    @Test
    public void TC_EC1_CustomerID_Cannot_Be_Empty() {
        editCustomerPageObject.pressTABToCustomerIDTextbox();
        Assert.assertEquals(editCustomerPageObject.getCustomerIdError(), "Customer ID is required");
        Assert.assertTrue(editCustomerPageObject.isCustomerIdErrorDisplayed());
    }
    @Test
    public void TC_EC2_CustomerID_Must_Be_Numeric() {
        editCustomerPageObject.enterCharactorValueToCustomerFiled("charactor");
        Assert.assertEquals(editCustomerPageObject.getCustomerIdError(), "Characters are not allowed");
        Assert.assertTrue(editCustomerPageObject.isCustomerIdErrorDisplayed());
    }
    @Test
    public void TC_EC3_CustomerID_Cannot_Have_Special_Charater() {
        editCustomerPageObject.enterSpecialCharacterToCustomerIDField("@!#");
        Assert.assertEquals(editCustomerPageObject.getCustomerIdError(), "Special characters are not allowed");
        Assert.assertTrue(editCustomerPageObject.isCustomerIdErrorDisplayed());
    }
    @Test
    public void TC_EC4_CustomerID_Valid_Value() {
        editCustomerPageObject.enterValidValueToCustomerIDField("97139");
        Assert.assertTrue(editCustomerPageObject.isEditCustomerFormDisplayed());
    }
    @Test
    public void TC_EC5_CustomerName_Is_Disabled() {
        Assert.assertTrue(editCustomerPageObject.isCustomerNameTextboxDisabled(customerNameTextbox));
    }

    @Test
    public void TC_EC6_CustomerGender_Is_Disabled() {
        Assert.assertTrue(editCustomerPageObject.isCustomerGenderTextboxDisabled(customerGenderTextbox));
    }
    @Test
    public void TC_EC7_CustomerDateOFBirth_Is_Disabled() {
        Assert.assertTrue(editCustomerPageObject.isCustomerDOBTextboxDisabled(dateOfBirthTextbox));
    }

    @AfterTest
    public void afterClass() {
        driver.quit();
    }
}
 