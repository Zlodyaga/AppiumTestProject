package org.example.pages;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.example.base.PageTools;
import org.openqa.selenium.By;

public class LoginPage extends PageTools {
    private static AppiumDriver driver;

    private static final By loginButtonStart = By.xpath("//android.widget.Button[@text=\"Login\"]");
    private static final By loginButtonFinal = By.xpath("//android.widget.Button[@resource-id=\"com.nymbus.enterprise.mobile:id/login\"]");
    private static final By usernameField = By.xpath("//android.widget.EditText[@resource-id=\"com.nymbus.enterprise.mobile:id/username\"]");
    private static final By passwordField = By.xpath("//android.widget.EditText[@resource-id=\"com.nymbus.enterprise.mobile:id/password\"]");

    LoginPage(AppiumDriver driver) {
        LoginPage.driver = driver;
    }

    @Step("Type password")
    public void typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Type username")
    public void typeUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    @Step("Open login form")
    public void openLoginForm() {
        driver.findElement(loginButtonStart).click();
    }

    @Step("Click on login button")
    public void clickLoginButton() {
        driver.findElement(loginButtonFinal).click();
    }

    @Step("Wait for button to show login form")
    public void waitForLoginButtonStart() {
        waitForElementClickable(loginButtonStart, driver);
    }

    @Step("Wait for username field")
    public void waitForUsernameField() {
        waitForElementClickable(usernameField, driver);
    }
}
