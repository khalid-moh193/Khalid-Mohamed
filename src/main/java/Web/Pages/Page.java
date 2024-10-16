package Web.Pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void openURL(String url) {
        driver.navigate().to(url);
        System.out.println("Navigating to: " + url);
        saveScreenshotPNG();
    }

    @Step("-get Page URL")
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected void clickElement(By element) {
        WebElement elementToBeClicked = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        highlightAndScreenshotElement(elementToBeClicked);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void selectElementFromDDL(By element, String optionValue) {
        WebElement elementToBeClicked = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        Select select = new Select(elementToBeClicked);
        highlightAndScreenshotElement(elementToBeClicked);
        select.selectByValue(optionValue);
    }

    public void clickElementUsingJS(By element) {
        WebElement elementToBeClicked = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        highlightAndScreenshotElement(elementToBeClicked);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", elementToBeClicked);
    }

    public String getElementTextUsingJS(By element) throws InterruptedException {
        WebElement hiddenElement = (WebElement) ((JavascriptExecutor) driver)
                .executeScript("return document.querySelector('#js_2mv');");
        Thread.sleep(1000);
//        WebElement elementToBeVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
//        highlightAndScreenshotElement(elementToBeVisible);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String elementText = (String) js.executeScript("return arguments[0].textContent;", hiddenElement);
        return elementText;
    }

    @Step("-Send Text")
    protected void sendText(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.sendKeys(text);
        highlightAndScreenshotElement(element);
    }

    public String getElementText(By element) {
        WebElement elementToGetText = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        highlightAndScreenshotElement(elementToGetText);
        return wait.until(ExpectedConditions.elementToBeClickable(element)).getText();
    }

    public void hoverOverElement(By element) {
        WebElement elementToHover = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover).perform();
        highlightAndScreenshotElement(elementToHover);
    }

    public void switchToIframe(By iframeElement) {
        WebElement iFrameToSwitchTo = wait.until(ExpectedConditions.visibilityOfElementLocated(iframeElement));
        driver.switchTo().frame(iFrameToSwitchTo);
    }

    // Switch back to the default content (main page)
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    private void highlightAndScreenshotElement(WebElement element) {
        /** A method to highlight an element, for better visibility while running the test, and also while taking screenshots */
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='5px solid red'", element);
        saveScreenshotPNG();
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", element);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
    }

}


