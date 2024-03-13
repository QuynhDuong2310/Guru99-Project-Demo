

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

    public void getUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getCurrentPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getCurrentPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPreviousPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public void cancelAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public String getAlertText(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }

    public void sendKeyToAlert(WebDriver driver, String keyToSend) {
        driver.switchTo().alert().sendKeys(keyToSend);
    }

    public void waitAlertPresence(WebDriver driver) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        explicitWait.until(ExpectedConditions.alertIsPresent());
    }

    public void switchToWindowByTitle(WebDriver driver, String expectedWindowTitle) {
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

    public void switchToWindowByID(WebDriver driver, String expectedWindowID) {
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

    public void closeAllWindowsWithOutParent(WebDriver driver, String parentWindowID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String currentWindowID : allWindows) {
            if (!currentWindowID.equals(parentWindowID)) {
                driver.switchTo().window(currentWindowID).close();
            }
        }
        driver.switchTo().window(parentWindowID);
    }

    public WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByXpath(locator));
    }

    public WebElement getElement(WebDriver driver, String locator, String... values) {
        return driver.findElement(getByXpath(getDynamicLocator(locator, values)));
    }

    public List<WebElement> getElements(WebDriver driver, String locator) {
        return driver.findElements(By.xpath(locator));
    }

    public List<WebElement> getElements(WebDriver driver, String locator, String... values) {
        return driver.findElements(By.xpath(getDynamicLocator(locator, values)));
    }

    public By getByXpath(String locator) {
        return By.xpath(locator);
    }

    public void clickToElement(WebDriver driver, String locator) {
        element = getElement(driver, locator);
        element.click();
    }

    public void clickToElement(WebDriver driver, String locator, String... values) {
        element = getElement(driver, getDynamicLocator(locator, values));
        element.click();
    }

    public void sendKeyToElement(WebDriver driver, String locator, String keyToSend) {
        element = getElement(driver, locator);
        element.clear();
        element.sendKeys(keyToSend);
    }

    public void sendKeyToElement(WebDriver driver, String locator, String keyToSend, String... values) {
        element = getElement(driver, getDynamicLocator(locator, values));
        element.clear();
        element.sendKeys(keyToSend);
    }

    public void selectItemInDefaultDropList(WebDriver driver, String locator, String keyToSelect) {
        element = getElement(driver, locator);
        select = new Select(element);
        select.selectByVisibleText(keyToSelect);
    }

    public String getFirstSelectedItemInDropList(WebDriver driver, String locator, String keyToSelect) {
        element = getElement(driver, locator);
        select = new Select(element);
        select.selectByVisibleText(keyToSelect);
        return select.getFirstSelectedOption().getText();
    }

    public boolean isDropListMultiple(WebDriver driver, String locator) {
        element = getElement(driver, locator);
        select = new Select(element);
        return select.isMultiple();
    }

    public void selectItemInDropDownListByJs(WebDriver driver, String parentXpathLocator, String childLocator, String expectedItem) {
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

    public void selectItemInDroplist(WebDriver driver, String parentXpathLocator, String childXpathLocator, String expectedItem) {
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

    public void selectItemInDroplistByContainsExpectedItem(WebDriver driver, String parentXpathLocator, String childXpathLocator, String expectedItem) {
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

    public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
        element = getElement(driver, locator);
        return element.getAttribute(attributeName);
    }

    public String getElementText(WebDriver driver, String locator) {
        element = getElement(driver, locator);
        return element.getText();
    }

    public String getElementText(WebDriver driver, String locator, String... values) {
        element = getElement(driver, locator, values);
        return element.getText();
    }

    public int countElementSize(WebDriver driver, String locator) {
        return getElements(driver, locator).size();
    }

    public void checkToCheckBox(WebDriver driver, String locator) {
        element = getElement(driver, locator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void uncheckToCheckBox(WebDriver driver, String locator) {
        element = getElement(driver, locator);
        if (element.isSelected()) {
            element.click();
        }
    }

    public boolean isPageLoadedSuccess(WebDriver driver) {
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

    public boolean isElementDisplayed(WebDriver driver, String locator, String... values) {
        try {
            return getElement(driver, locator, values).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementEnabled(WebDriver driver, String locator, String... values) {
        return getElement(driver, getDynamicLocator(locator, values)).isEnabled();
    }

    public boolean isElementSelected(WebDriver driver, String locator, String... values) {
        return getElement(driver, getDynamicLocator(locator, values)).isSelected();
    }

    public boolean isElementDisplayed(WebDriver driver, String locator) {
        // Element always present in the DOM +  If findElement() method can find the element based on the locator >> Return the element's status (True/False)
        // Element does not present in the DOM >> If findElement() method can not find the element based on the locator >> Fail test case >> Catch this exception and return false)
        try {
            return getElement(driver, locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void overideImpliciwait(WebDriver driver, long timeInSecond) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSecond));
    }

    public boolean isElementUndisplyed(WebDriver driver, String locator) {
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

    public boolean isElementEnabled(WebDriver driver, String locator) {
        return getElement(driver, locator).isEnabled();
    }

    public boolean isElementSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    public void switchToFrame(WebDriver driver, String locator) {
        driver.switchTo().frame(getElement(driver, locator));
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void doubleClickToElement(WebDriver driver, String locator) {
        action = new Actions(driver);
        action.doubleClick(getElement(driver, locator)).perform();
    }

    public void doubleClickToElement(WebDriver driver, String locator, String... values) {
        action = new Actions(driver);
        action.doubleClick(getElement(driver, getDynamicLocator(locator, values))).perform();
    }

    public void rightClickElement(WebDriver driver, String locator) {
        action = new Actions(driver);
        action.contextClick(getElement(driver, locator)).perform();
    }

    public void hoverMouseElement(WebDriver driver, String locator) {
        action = new Actions(driver);
        action.moveToElement(getElement(driver, locator)).perform();
    }

    public void clickAndHoldElement(WebDriver driver, String locator) {
        action = new Actions(driver);
        action.clickAndHold(getElement(driver, locator)).perform();
    }

    public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
        action = new Actions(driver);
        action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
    }

    public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
        action = new Actions(driver);
        getElement(driver, locator).clear();
        action.sendKeys(getElement(driver, locator), key).perform();
    }

    public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key, String... values) {
        action = new Actions(driver);
        getElement(driver, locator, values).clear();
        action.sendKeys(getElement(driver, locator, values), key).perform();
    }

    public void clickToElementByJs(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, locator);
        jsExecutor.executeScript("arguments[0].click", element);
    }

    public void clickToElementByJs(WebDriver driver, String locator, String... values) {
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, getDynamicLocator(locator, values));
        jsExecutor.executeScript("arguments[0].click", element);
    }

    public void scrollToElementByJs(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, locator);
        jsExecutor.executeScript("arguments[0].scrollIntoView", element);
    }

    public void scrollToElementByJs(WebDriver driver, String locator, String... values) {
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, getDynamicLocator(locator, values));
        jsExecutor.executeScript("arguments[0].scrollIntoView", element);
    }

    public void sendKeyToElementByJs(WebDriver driver, String locator, String value) {
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, locator);
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
    }

    public void sendKeyToElementByJs(WebDriver driver, String locator, String value, String... values) {
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, getDynamicLocator(locator, values));
        jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeName) {
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, locator);
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeName + "');", element);
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeName, String... values) {
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, locator, values);
        jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeName + "');", element);
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        jsExecutor = (JavascriptExecutor) driver;
        WebElement element = getElement(driver, locator);
        boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidthv != \"undefined\" && argurments[0].naturalWidth > 0", element);
        if (status) {
            return true;
        }
        return false;
    }

    public void waitForElementVisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
    }

    public String getDynamicLocator(String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        return locator;
    }

    public void waitForElementVisible(WebDriver driver, String locator, String... values) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
    }

    public void waitForElementInvisible(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
        overideImpliciwait(driver, GlobalConstants.SHORT_TIMEOUT);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
        overideImpliciwait(driver, GlobalConstants.LONG_TIMEOUT);
    }

    public void waitForElementInvisible(WebDriver driver, String locator, String... values) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator, String... values) {
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, values))));
    }

    public void sleepInSecond(long second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public BasePage openNewTabByTabName(WebDriver driver, String tabName) {
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

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(9999);
    }
}
 