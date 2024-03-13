

package com.guru99.customers;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
public class Com_Guru_03_Customer_Delete_Validation extends BaseTest {
    WebDriver driver;
    String customerID = "589";
    String pinInvalidValue, emailInvalidFormat, emailInvalidFormat1, phoneNumberInvalidFormat;
    String customerNameTextbox, customerGenderTextbox, dateOfBirthTextbox, cityTextbox, stateTextbox, pinTextbox, mobileNumberTextbox, emailTextbox, passwordTextbox;
    String newCustomerTab, editCustomerTab, deleteCustomerTab;
    String userID, password, numbericValue, specialCharacter;
    LoginPageObject loginPageObject;
    ManagerPageObject managerPageobject;
    NewCustomerPageObject newCustomerPageObject;
    EditCustomerPageObject editCustomerPageObject;
    DeleteCustomerPageObject deleteCustomerPageObject;
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
        deleteCustomerTab = "Delete Customer";
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
        managerPageobject.openNewPageByTabName(driver, deleteCustomerTab);
        deleteCustomerPageObject = PageGeneratorManager.getDeleteCustomerPage(driver);
    }
    @Test
    public void TC_DC1_CustomerID_Cannot_Be_Empty() {
        deleteCustomerPageObject.pressTABToCustomerIDTextbox();
        Assert.assertEquals(deleteCustomerPageObject.getCustomerIdError(), "Customer ID is required");
        Assert.assertTrue(deleteCustomerPageObject.isCustomerIdErrorDisplayed());
    }
    @Test
    public void TC_DC2_CustomerID_Must_Be_Numeric() {
        deleteCustomerPageObject.enterCharactorValueToCustomerFiled("charactor");
        Assert.assertEquals(deleteCustomerPageObject.getCustomerIdError(), "Characters are not allowed");
        Assert.assertTrue(deleteCustomerPageObject.isCustomerIdErrorDisplayed());
    }
    @Test
    public void TC_DC3_CustomerID_Cannot_Have_Special_Charater() {
        deleteCustomerPageObject.enterSpecialCharacterToCustomerIDField("@!#");
        Assert.assertEquals(deleteCustomerPageObject.getCustomerIdError(), "Special characters are not allowed");
        Assert.assertTrue(deleteCustomerPageObject.isCustomerIdErrorDisplayed());
    }
    @Test
    public void TC_DC4_CustomerID_Cannot_Have_Space_Charater_AT_The_Beginning() {
        deleteCustomerPageObject.enterSpaceCharacterToCustomerIDField();
        Assert.assertEquals(deleteCustomerPageObject.getCustomerIdError(), "First character can not have space");
        Assert.assertTrue(deleteCustomerPageObject.isCustomerIdErrorDisplayed());
    }

    //@Test
    public void TC_DC5_CustomerID_Valid_Value() {
        deleteCustomerPageObject.enterValidValueToCustomerIDField(customerID);
        deleteCustomerPageObject.clickToSubmitButton();
        deleteCustomerPageObject.clickToAcceptButtonOnConfirmALert();
        deleteCustomerPageObject = PageGeneratorManager.getDeleteCustomerPage(driver);
    }
    @Test
    public void TC_DC6_Cannot_Delete_The_Deleted_CustomerId() {
        deleteCustomerPageObject.enterValidValueToCustomerIDField(customerID);
        deleteCustomerPageObject.clickToSubmitButton();
        deleteCustomerPageObject.clickToAcceptButtonOnConfirmALert();
        Assert.assertEquals(deleteCustomerPageObject.getTheAlertText(), "Customer does not exist!!");
        deleteCustomerPageObject.clickToCofirmAlert();
    }

    //@AfterTest
    public void afterClass() {
        driver.quit();
    }
}
 