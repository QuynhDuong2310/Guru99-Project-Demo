

package com.guru99.customers;
import commons.BasePage;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import java.util.Random;
public class Com_Guru_04_Customer_CRUD extends BaseTest {
    WebDriver driver;
    BasePage basePage = new BasePage();
    String customerID;
    String customerNameTextbox,dateOfBirthTextbox, cityTextbox, stateTextbox, pinTextbox, mobileNumberTextbox, emailTextbox, passwordTextbox;
    String userID, password, newCustomerTab, editCustomerTab, deleteCustomerTab;
    String validCustomerNameValue, validDateOfBirthValue, validAddressValue, validCityValue, validStateValue, validPinValue,validPhoneValue, randomEmailValue, validPasswordValue;
    String updatingPinValue;
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
        newCustomerTab = "New Customer";
        editCustomerTab = "Edit Customer";
        deleteCustomerTab = "Delete Customer";
        customerNameTextbox = "Customer Name";
        dateOfBirthTextbox = "Date of Birth";
        cityTextbox = "City";
        stateTextbox = "State";
        pinTextbox = "PIN";
        mobileNumberTextbox = "Mobile Number";
        emailTextbox = "E-mail";
        passwordTextbox = "Password";
        validCustomerNameValue = "Test"; validDateOfBirthValue = "10/10/1999"; validAddressValue = "47100 Bayside Pkwy"; validCityValue = "Fremont";  validStateValue = "California" ;
        validPinValue = "123456"; validPhoneValue = "4678898765"; randomEmailValue = getRandomEmailValue(); validPasswordValue= "123456";
        updatingPinValue ="654321";
        loginPageObject = PageGeneratorManager.getLoginPage(driver);
        loginPageObject.enterUserID(userID);
        loginPageObject.enterPassword(password);
        loginPageObject.clickToLoginButton();
        managerPageobject = PageGeneratorManager.getManagerPage(driver);
        managerPageobject.openNewPageByTabName(driver, newCustomerTab);
        newCustomerPageObject = PageGeneratorManager.getNewCustomerPage(driver);
    }
    @Test
    public void TC_CRUD1_Create_New_Customer_Successfully() {
        newCustomerPageObject.enterAnValidCustomerName(customerNameTextbox,validCustomerNameValue);
        newCustomerPageObject.enterDateOfBirth(dateOfBirthTextbox,validDateOfBirthValue);
        newCustomerPageObject.enterAnValidAddress(validAddressValue);
        newCustomerPageObject.enterAnValidCity(cityTextbox,validCityValue);
        newCustomerPageObject.enterAnValidState(stateTextbox,validStateValue);
        newCustomerPageObject.enterAnValidPin(pinTextbox,validPinValue);
        newCustomerPageObject.enterAnValidMobileNumber(mobileNumberTextbox,validPhoneValue);
        newCustomerPageObject.enterAnValidEmail(emailTextbox,randomEmailValue);
        newCustomerPageObject.enterAnValidPassword(passwordTextbox,validPasswordValue);
        newCustomerPageObject.clickToSubmitButton();
        customerID = newCustomerPageObject.getCustomerIDInformation("Customer ID");
        System.out.println(customerID);
        Assert.assertEquals(newCustomerPageObject.getCustomerNameInformation(customerNameTextbox), validCustomerNameValue);
        Assert.assertEquals(newCustomerPageObject.getCustomerAddressInformation("Address"), validAddressValue);
        Assert.assertEquals(newCustomerPageObject.getCustomerCityInformation(cityTextbox), validCityValue);
        Assert.assertEquals(newCustomerPageObject.getCustomerStateInformation(stateTextbox), validStateValue);
        Assert.assertEquals(newCustomerPageObject.getCustomerPinInformation("Pin"), validPinValue);
        Assert.assertEquals(newCustomerPageObject.getCustomerPhoneInformation("Mobile No."), validPhoneValue);
        Assert.assertEquals(newCustomerPageObject.getCustomerEmailInformation("Email"), randomEmailValue);
    }
    @Test
    public void TC_CRUD2_Edit_Newly_Created_Customer_Successfully() {
        newCustomerPageObject.openNewPageByTabName(driver, editCustomerTab);
        editCustomerPageObject = PageGeneratorManager.getEditCustomerPage(driver);
        editCustomerPageObject.enterValidValueToCustomerIDField(customerID);
        Assert.assertTrue(editCustomerPageObject.isEditCustomerFormDisplayed());
    }
    @Test
    public void TC_CRUD3_Delete_An_Existing_Customer_Successfully() {
        editCustomerPageObject.openNewPageByTabName(driver, deleteCustomerTab);
        deleteCustomerPageObject = PageGeneratorManager.getDeleteCustomerPage(driver);
        deleteCustomerPageObject.enterValidValueToCustomerIDField(customerID);
        deleteCustomerPageObject.clickToSubmitButton();
        deleteCustomerPageObject.clickToAcceptButtonOnConfirmALert();
    }


    @AfterTest
    public void afterClass() {
        driver.quit();
    }
    private String getRandomEmailValue(){
        Random random = new Random();
        return "Tester" +random.nextInt(9999) + "@gmail.com";
    }
}
 