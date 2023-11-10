package com.globant.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutomationDemoSitePage extends BasePage {

    @FindBy(className = "btn-danger")
    private WebElement displayAlertWithOkBtn;
    @FindBy(css = "a[href=\"#CancelTab\"]")
    private WebElement selectAlertWithCancelBtn;
    @FindBy(className = "btn-primary")
    private WebElement displayAlertWithCancelBtn;
    @FindBy(id = "demo")
    private WebElement cancelConfirmation;

    public AutomationDemoSitePage(WebDriver driver) {
        super(driver);
    }

    public boolean alertWasDismissed() {
        return cancelConfirmation.getText().equalsIgnoreCase("You Pressed Cancel");
    }

    public void clickingFirstAlert() {
        clickOn(displayAlertWithOkBtn);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void clickingSecondAlert() {
        clickOn(selectAlertWithCancelBtn);
        clickOn(displayAlertWithCancelBtn);
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
}
