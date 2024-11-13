package org.example.actions;

import io.appium.java_client.AppiumDriver;
import org.example.pages.Pages;

import static org.example.utils.Constants.LOGIN_PASSWORD;
import static org.example.utils.Constants.LOGIN_USERNAME;

public class LoginActions {

    private static AppiumDriver driver;

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
        Pages.navigationPage().clickOnMore();
        Actions.mainActions().swipeDown();
        Pages.navigationPage().waitForLogOutButton();
        Pages.navigationPage().clickOnLogOutButton();
        Pages.loginPage().waitForLoginButtonStart();
    }
}
