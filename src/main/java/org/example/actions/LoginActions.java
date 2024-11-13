package org.example.actions;

import io.appium.java_client.AppiumDriver;
import org.example.pages.Pages;
import org.openqa.selenium.By;

import static org.example.utils.Constants.LOGIN_PASSWORD;
import static org.example.utils.Constants.LOGIN_USERNAME;

public class LoginActions {

    private static AppiumDriver driver;
    private static final By moreOnNavigationBar = By.xpath("//android.widget.FrameLayout[@content-desc=\"More\"]");
    private static final By logOutButton = By.xpath("//android.widget.Button[@text=\"Log Out\"]");

    LoginActions(AppiumDriver driver) {
        LoginActions.driver = driver;
    }

    public void login() {
        Pages.loginPage().waitForLoginButtonStart();
        Pages.loginPage().openLoginForm();
        Pages.loginPage().waitForUsernameField();
        Pages.loginPage().typeUsername(LOGIN_USERNAME);
        Pages.loginPage().typePassword(LOGIN_PASSWORD);
        Pages.loginPage().clickLoginButton();
    }

    public void logout() {
        driver.findElement(moreOnNavigationBar).click();
        Actions.mainActions().swipeDown();
        driver.findElement(logOutButton).click();
    }
}
