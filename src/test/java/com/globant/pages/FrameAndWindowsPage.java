package com.globant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public class FrameAndWindowsPage extends BasePage {

    @FindBy(id = "Open New Tab")
    private WebElement openNewTabLi;
    @FindBy(id = "Open New Window")
    private WebElement openNewWindowLi;
    @FindBy(id = "iFrame")
    private WebElement iFrameLi;
    @FindBy(css = "div[rel-title=\"Open New Tab\"] > .button")
    private WebElement newTabBtn;
    @FindBy(css = "div.information ~ .button")
    private WebElement newWindowBtn;
    @FindBy(id = "current_filter")
    private WebElement filter;
    @FindBy(css = "div[data-option-value=\".softwaretesting\"]")
    private WebElement softwareTestingOption;
    @FindBy(css = "img[alt = \"Manual Online Testing Training\"]")
    private WebElement manualTestingImg;
    @FindBy(css = ".page_heading > h1")
    private WebElement manualTestingTitle;
    @FindBy(css = "li#menu-item-2816 a")
    private WebElement alertsBtn;

    public FrameAndWindowsPage(WebDriver driver) {
        super(driver);
    }

    public boolean newWasOpen() {
        return driver.getWindowHandles().size() > 1;
    }
    public void openNewTab() {
        clickOn(openNewTabLi);
        clickOn(newTabBtn);
    }

    public void openNewWindow() {
        clickOn(openNewWindowLi);
        clickOn(newWindowBtn);
    }

    public boolean manualTestingPageIsDisplayed() {
        String title = "Manual Testing Training";
        wait.until(ExpectedConditions.textToBePresentInElement(manualTestingTitle, title));
        return manualTestingTitle.getText().equalsIgnoreCase(title);
    }

    public void navigateToManualTesting() {
        String IFrame = "globalSqa";
        Actions actions = new Actions(driver);
        switchBrowserViewTo(driver.getWindowHandles().iterator().next());
        clickOn(iFrameLi);
        switchToIframe(IFrame);
        waitVisibilityOf(filter);
        actions.moveToElement(filter).perform();
        clickOn(softwareTestingOption);
        clickOn(manualTestingImg);
    }

    public AutomationDemoSitePage goToAlertsPage() {
        String IFrame = "globalSqa";
        Actions actions = new Actions(driver);
        String currentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        windows.remove(currentWindow);
        switchBrowserViewTo(windows.iterator().next());
        clickOn(iFrameLi);
        switchToIframe(IFrame);
        waitVisibilityOf(filter);
        actions.moveToElement(filter).perform();
        clickOn(softwareTestingOption);
        clickOn(manualTestingImg);
        driver.switchTo().defaultContent();
        actions.moveToElement(alertsBtn).click().perform();
        driver.close();
        switchBrowserViewTo(currentWindow);
        driver.get(" https://demo.automationtesting.in/Alerts.html");
        return new AutomationDemoSitePage(driver);
    }
}
