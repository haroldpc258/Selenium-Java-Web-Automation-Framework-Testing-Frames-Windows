package com.globant.tests;

import com.globant.pages.AutomationDemoSitePage;
import com.globant.pages.FrameAndWindowsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GlobalSQATest extends BaseTest {

    @Test
    public void testOpenNewTab() {
        FrameAndWindowsPage firstPage = loadFirstPage();
        firstPage.openNewTab();
        Assert.assertTrue(firstPage.newWasOpen());
    }

    @Test
    public void testOpenNewWindow() {
        FrameAndWindowsPage firstPage = loadFirstPage();
        firstPage.openNewWindow();
        Assert.assertTrue(firstPage.newWasOpen());
    }

    @Test
    public void testIFrame() {
        FrameAndWindowsPage firstPage = loadFirstPage();
        firstPage.openNewTab();
        Assert.assertTrue(firstPage.newWasOpen());
        firstPage.navigateToManualTesting();
        Assert.assertTrue(firstPage.manualTestingPageIsDisplayed());
    }

    @Test
    public void testAlerts() {
        FrameAndWindowsPage firstPage = loadFirstPage();
        firstPage.openNewTab();
        AutomationDemoSitePage alertsPage = firstPage.goToAlertsPage();
        alertsPage.clickingFirstAlert();
        alertsPage.clickingSecondAlert();
        Assert.assertTrue(alertsPage.alertWasDismissed());
    }
}
