package com.globant.tests;

import com.globant.pages.FrameAndWindowsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    @Parameters({ "browser", "url" })
    public void setUp(String browser, String url) {
        setUpDriver(browser);
        maximizeWindow();
        navigateTo(url);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    protected void navigateTo(String url) {
        driver.get(url);
    }

    protected void maximizeWindow() {
        driver.manage().window().maximize();
    }

    protected void setUpDriver(String browser) {
        switch (browser) {
            case "chrome" -> {
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                driver = new FirefoxDriver();
            }
            case "edge" -> {
                driver = new EdgeDriver();
            }
        }
    }

    protected FrameAndWindowsPage loadFirstPage() {
        return new FrameAndWindowsPage(driver);
    }
}
