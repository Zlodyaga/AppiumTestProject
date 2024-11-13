package org.example.pages;

import io.appium.java_client.AppiumDriver;
import org.example.base.PageTools;
import org.openqa.selenium.By;

public class NavigationPage extends PageTools {

    public static AppiumDriver driver;
    private static final By logOutButton = By.xpath("//android.widget.Button[@text=\"Log Out\"]");
    private static final By moreOnNavigationBar = By.xpath("//android.widget.FrameLayout[@content-desc=\"More\"]");

    NavigationPage(AppiumDriver driver) {
        NavigationPage.driver = driver;
    }

    public void clickOnMore() {
        driver.findElement(moreOnNavigationBar).click();
    }

    public void clickOnLogOutButton() {
        driver.findElement(logOutButton).click();
    }

    public void waitForLogOutButton() {
        waitForElementVisible(logOutButton, driver);
    }
}
