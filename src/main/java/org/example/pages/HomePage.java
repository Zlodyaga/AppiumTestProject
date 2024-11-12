package org.example.pages;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.example.base.PageTools;
import org.openqa.selenium.By;

public class HomePage extends PageTools {
    private static AppiumDriver driver;

    private static final By accountsWidget = By.xpath("//android.widget.LinearLayout[1]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView");
    private static final By accountFirst = By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout");
    private static final By accountSecond = By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout");

    HomePage(AppiumDriver driver) {
        HomePage.driver = driver;
    }

    @Step("Wait for account widget")
    public void waitForAccountsWidget() {
        waitForElementVisible(accountsWidget, driver);
    }

    @Step("Go to second account")
    public void clickAccountSecond() {
        driver.findElement(accountSecond).click();
    }
}
