package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected Wait<WebDriver> wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    protected void switchToIframe(String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }

    protected void switchBrowserViewTo(String nameOrHandle) {
        driver.switchTo().window(nameOrHandle);
    }

    protected void clickOn(WebElement element) {
        waitToBeClickable(element);
        element.click();
    }

    protected void writeIn(WebElement element, String text) {
        waitVisibilityOf(element);
        element.sendKeys(text);
    }

    protected void waitToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitVisibilityOf(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
