

package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.PageGeneratorManager;
import pageUIs.ManagerAbstractPageUI;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BasePage {
    private WebDriverWait explicitWait;
    private Actions action;
    private JavascriptExecutor jsExecutor;
    private WebElement element;
    private List<WebElement> elements;
    private Select select;

    protected void getUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    protected String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    protected String getCurrentPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    protected String getCurrentPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    protected void backToPreviousPage(WebDriver driver) {
        driver.navigate().back();
    }

    protected void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    protected void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    protected void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    protected void cancelAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    protected String getAlertText(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }

    protected void sendKeyToAlert(WebDriver driver, String keyToSend) {
        driver.switchTo().alert().sendKeys(keyToSend);
    }

    protected void waitAlertPresence(WebDriver driver) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    protected void switchToWindowByTitle(WebDriver driver, String expectedWindowTitle) {
        // Lấy hết tất cả ID của các window/tab
        Set<String> allWindows = driver.getWindowHandles();
        // Dùng vòng lặp duyệt qua set ID ở trên
        for (String id : allWindows) {
            // Cho switch vào từng ID
            driver.switchTo().window(id);
            // Lấy ra title của tab/window hiện tại
            String currentWindowTitle = driver.getTitle();
            if (currentWindowTitle.equals(expectedWindowTitle)) {
                break;
            }
        }
    }

    protected void switchToWindowByID(WebDriver driver, String expectedWindowID) {
        // Step 1. Declare expectedWindowID, currentWindowID.
        // Step 2. Get allWindowID
        // Step 3. Use "for" to interact with the list of collected window IDs
        Set<String> allWindowID = driver.getWindowHandles();
        for (String currentWindowID : allWindowID) {
            if (!currentWindowID.equals(expectedWindowID)) {
                driver.switchTo().window(currentWindowID);
                break;
            }
        }
    }

    protected void closeAllWindowsWithOutParent(WebDriver driver, String parentWindowID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String currentWindowID : allWindows) {
            if (!currentWindowID.equals(parentWindowID)) {
                driver.switchTo().window(currentWindowID).close();
            }
        }
        driver.switchTo().window(parentWindowID);
    }

    protected WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByXpath(locator));
    }

    protected WebElement getElement(WebDriver driver, String locator, String... values) {
        return driver.findElement(getByXpath(getDynamicLocator(locator, values)));
    }

    protected List<WebElement> getElements(WebDriver driver, String locator) {
        return driver.findElements(By.xpath(locator));
    }

    protected List<WebElement> getElements(WebDriver driver, String locator, String... values) {
        return driver.findElements(By.xpath(getDynamicLocator(locator, values)));
    }

    protected By getByXpath(String locator) {
        return By.xpath(locator);
    }

    protected void clickToElement(WebDriver driver, String locator) {
        element = getElement(driver, locator);
        element.click();
    }

    protected void clickToElement(WebDriver driver, String locator, String... values) {
        element = getElement(driver, getDynamicLocator(locator, values));
        element.click();
    }

    protected void sendKeyToElement(WebDriver driver, String locator, String keyToSend) {
        element = getElement(driver, locator);
        element.clear();
        element.sendKeys(keyToSend);
    }

    protected void sendKeyToElement(WebDriver driver, String locator, String keyToSend, String... values) {
        element = getElement(driver, getDynamicLocator(locator, values));
        element.clear();
        element.sendKeys(keyToSend);
    }

    protected void selectItemInDefaultDropList(WebDriver driver, String locator, String keyToSelect) {
        element = getElement(driver, locator);
        select = new Select(element);
        select.selectByVisibleText(keyToSelect);
    }

    protected String getFirstSelectedItemInDropList(WebDriver driver, String locator, String keyToSelect) {
        element = getElement(driver, locator);
        select = new Select(element);
        select.selectByVisibleText(keyToSelect);
        return select.getFirstSelectedOption().getText();
    }

    protected boolean isDropListMultiple(WebDriver driver, String locator) {
        element = getElement(driver, locator);
        select = new Select(element);
        return select.isMultiple();
    }

    protected void selectItemInDropDownListByJs(WebDriver driver, String parentXpathLocator, String childLocator, String expectedItem) {
        getElement(driver, parentXpathLocator).click();
        sleepInSecond(1);
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        elements = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childLocator)));
        for (WebElement item : elements) {
            if (item.getText().equals(expectedItem)) {
                jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
                item.click();
                sleepInSecond(1);
                break;
            }
        }
    }

    protected void selectItemInDroplist(WebDriver driver, String parentXpathLocator, String childXpathLocator, String expectedItem) {
        driver.findElement(By.xpath(parentXpathLocator)).click();
        sleepInSecond(2);
        List<WebElement> allITemsInDroplist = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpathLocator)));
        for (WebElement item : allITemsInDroplist) {
            if (item.getText().contains(expectedItem)) {
                item.click();
                sleepInSecond(2);
                break;
            }
        }
    }

    protected void selectItemInDroplistByContainsExpectedItem(WebDriver driver, String parentXpathLocator, String childXpathLocator, String expectedItem) {
        driver.findElement(By.xpath(parentXpathLocator)).click();
        sleepInSecond(2);
        List<WebElement> allITemsInDroplist = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpathLocator)));
        for (WebElement item : allITemsInDroplist) {
            if (item.getText().equals(expectedItem)) {
                item.click();
                sleepInSecond(2);
                break;
            }
        }
    }

    protected String getElementAttribute(WebDriver driver, String locator, String attributeName) {
        element = getElement(driver, locator);
        return element.getAttribute(attributeName);
    }

    protected String getElementText(WebDriver driver, String locator) {
        element = getElement(driver, locator);
        return element.getText();
    }

    protected String getElementText(WebDriver driver, String locator, String... values) {
        element = getElement(driver, locator, values);
        return element.getText();
    }

    protected int countElementSize(WebDriver driver, String locator) {
        return getElements(driver, locator).size();
    }

    protected void checkToCheckBox(WebDriver driver, String locator) {
        element = getElement(driver, locator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    protected void uncheckToCheckBox(WebDriver driver, String locator) {
        element = getElement(driver, locator);
        if (element.isSelected()) {
            element.click();
        }
    }

    protected boolean isPageLoadedSuccess(WebDriver driver) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        jsExecutor = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        };
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            }
        };
        return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
    }

    protected boolean isElementDisplayed(WebDriver driver, String locator, String... values) {
        try {
            return getElement(driver, locator, values).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isElementEnabled(WebDriver driver, String locator, String... values) {
        return getElement(driver, getDynamicLocator(locator, values)).isEnabled();
    }

    protected boolean isElementSelected(WebDriver driver, String locator, String... values) {
        return getElement(driver, getDynamicLocator(locator, values)).isSelected();
    }

    protected boolean isElementDisplayed(WebDriver driver, String locator) {
        // Element always present in the DOM +  If findElement() method can find the element based on the locator >> Return the element's status (True/False)
        // Element does not present in the DOM >> If findElement() method can not find the element based on the locator >> Fail test case >> Catch this exception and return false)
        try {
            return getElement(driver, locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected void overideImpliciwait(WebDriver driver, long timeInSecond) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSecond));
    }

    protected boolean isElementUndisplyed(WebDriver driver, String locator) {
        System.out.println("Start time" + new Date().toString());
        overideImpliciwait(driver, GlobalConstants.SHORT_TIMEOUT);
        elements = getElements(driver, locator);
        overideImpliciwait(driver, GlobalConstants.LONG_TIMEOUT);
        if (elements.size() == 0) {
            System.out.println("There is no element" + locator + "in DOM");
            System.out.println("Start time" + new Date().toString());
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            System.out.println("There is element " + locator + " in DOM but not displayed");
            System.out.println("Start time" + new Date().toString());
            return true;
        } else {
            System.out.println("Element is in DOM and Displayed");
            return false;
        }
    }

    protected boolean isElementEnabled(WebDriver driver, String locator) {
        return getElement(driver, locator).isEnabled();
    }

    protected boolean isElementSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    protected void switchToFrame(WebDriver driver, String locator) {
        driver.switchTo().frame(getElement(driver, locator));
    }

    protected void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    protected void doubleClickToElement(WebDriver driver, String locator) {
        action = new Actions(driver);
        action.doubleClick(getElement(driver, locator)).perform();
    }

    protected void doubleClickToElement(WebDriver driver, String locator, String... values) {
        action = new Actions(driver);
        action.doubleClick(getElement(driver, getDynamicLocator(locator, values))).perform();
    }

    protected void rightClickElement(WebDriver driver, String locator) {
        action = new Actions(driver);
        action.contextClick(getElement(driver, locator)).perform();
    }

    protected void hoverMouseElement(WebDriver driver, String locator) {
        action = new Actions(driver);
        action.moveToElement(getElement(driver, locator)).perform();
    }

    protected void clickAndHoldElement(WebDriver driver, String locator) {
        action = new Actions(driver);
        action.clickAndHold(getElement(driver, locator)).perform();
    }

    protected void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
        action = new Actions(driver);
        action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
    }

    protected void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
        action = new Actions(driver);
        getElement(driver, locator).clear();
        action.sendKeys(getElement(driver, locator), key).perform();
    }

    protected void sendKeyBoardToElement(WebDriver driver, String locator, Keys key, String... values) {
        action = new Actions(driver);
        getElement(driver, locator, values).clear();
        action.sendKeys(getElement(driver, locator, values), key).perform();
    }

    protected void clickToElementByJs(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, locator);
        jsExecutor.executeScript("arguments[0].click", element);
    }

    protected void clickToElementByJs(WebDriver driver, String locator, String... values) {
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, getDynamicLocator(locator, values));
        jsExecutor.executeScript("arguments[0].click", element);
    }

    protected void scrollToElementByJs(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, locator);
        jsExecutor.executeScript("arguments[0].scrollIntoView", element);
    }

    protected void scrollToElementByJs(WebDriver driver, String locator, String... values) {
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, getDynamicLocator(locator, values));
        jsExecutor.executeScript("arguments[0].scrollIntoView", element);
    }

    protected void sendKeyToElementByJs(WebDriver driver, String locator, String value) {
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, locator);
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
    }

    protected void sendKeyToElementByJs(WebDriver driver, String locator, String value, String... values) {
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, getDynamicLocator(locator, values));
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
    }

    protected void removeAttributeInDOM(WebDriver driver, String locator, String attributeName) {
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, locator);
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeName + "');", element);
    }

    protected void removeAttributeInDOM(WebDriver driver, String locator, String attributeName, String... values) {
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, locator, values);
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeName + "');", element);
    }

    protected boolean isImageLoaded(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, locator);
        boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidthv != \"undefined\" && argurments[0].naturalWidth > 0", element);
        if (status) {
            return true;
        }
        return false;
    }

    protected void waitForElementVisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }

    protected String getDynamicLocator(String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        return locator;
    }

    protected void waitForElementVisible(WebDriver driver, String locator, String... values) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
    }

    protected void waitForElementInvisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
        overideImpliciwait(driver, GlobalConstants.SHORT_TIMEOUT);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
        overideImpliciwait(driver, GlobalConstants.LONG_TIMEOUT);
    }

    protected void waitForElementInvisible(WebDriver driver, String locator, String... values) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
    }

    protected void waitForElementClickable(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
    }

    protected void waitForElementClickable(WebDriver driver, String locator, String... values) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, values))));
    }

    protected void sleepInSecond(long second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected BasePage openNewTabByTabName(WebDriver driver, String tabName) {
        waitForElementClickable(driver, ManagerAbstractPageUI.MENU_SUB_NAV_LINK, tabName);
        clickToElement(driver, ManagerAbstractPageUI.MENU_SUB_NAV_LINK, tabName);
        switch (tabName) {
            case "New Customer":
                return PageGeneratorManager.getNewCustomerPage(driver);
            default:
                return PageGeneratorManager.getManagerPage(driver);
        }
    }

    public void openNewPageByTabName(WebDriver driver, String tabName) {
        waitForElementClickable(driver, ManagerAbstractPageUI.MENU_SUB_NAV_LINK, tabName);
        clickToElement(driver, ManagerAbstractPageUI.MENU_SUB_NAV_LINK, tabName);
    }

    protected int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(9999);
    }
}
 