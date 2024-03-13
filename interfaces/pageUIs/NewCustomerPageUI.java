

package pageUIs;
public class NewCustomerPageUI {
    public static final String DYNAMIC_NEW_CUSTOMER_TEXTBOX = "//td[text()='%s']/following-sibling::td/input";
    public static final String CUSTOMER_NAME_COMMON_ERROR = "//td[text()='Customer Name']/following::td//label[@id='message' and contains(@style, 'visible')]";
    public static final String ADDRESS_TEXTAREA = "//td[text()='Address']/following-sibling::td/textarea";
    public static final String ADDRESS_COMMON_ERROR = "//td[text()='Customer Name']/following::td//label[@id='message3' and contains(@style, 'visible')]";

    public static final String CITY_COMMON_ERROR = "//td[text()='City']/following::td//label[@id='message4' and contains(@style, 'visible')]";
    public static final String STATE_COMMON_ERROR = "//td[text()='City']/following::td//label[@id='message5' and contains(@style, 'visible')]";
    public static final String PIN_COMMON_ERROR = "//td[text()='City']/following::td//label[@id='message6' and contains(@style, 'visible')]";
    public static final String PHONE_COMMON_ERROR = "//td[text()='City']/following::td//label[@id='message7' and contains(@style, 'visible')]";
    public static final String EMAIL_COMMON_ERROR = "//td[text()='City']/following::td//label[@id='message9' and contains(@style, 'visible')]";
    public static final String SUBMIT_BUTTON = "//input[@value='Submit']";
    public static final String SUCCESS_MESSAGE = "//p[@class='heading3']";
    public static final String DYNAMIC_INFORMATION_CUSTOMER_TEXTBOX = "//table[@id='customer']/tbody/tr/td[text()='%s']/following-sibling::td";

}
 