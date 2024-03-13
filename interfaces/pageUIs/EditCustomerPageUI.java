

package pageUIs;
public class EditCustomerPageUI {
    public static final String CUSTOMER_ID_TEXTBOX = "//td[text()='Customer ID']/following-sibling::td/input";
    public static final String SUBMIT_BUTTON = "//input[@name='AccSubmit']";
    public static final String DYNAMIC_EDIT_CUSTOMER_TEXTBOX = "//td[text()='%s']/following-sibling::td/input";
    public static final String ADDRESS_TEXTAREA = "//td[text()='Address']/following-sibling::td/textarea";
    public static final String EDIT_CUSTOMER_ID_COMMON_ERROR = "//td[text()='Customer ID']/following::td//label[@id='message14' and contains(@style, 'visible')]";
    public static final String EDIT_CUSTOMER_TABLE = "//p[@class='heading3']";

}
 