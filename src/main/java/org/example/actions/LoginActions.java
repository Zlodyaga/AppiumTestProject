package org.example.actions;

import org.example.pages.Pages;

import static org.example.utils.Constants.LOGIN_PASSWORD;
import static org.example.utils.Constants.LOGIN_USERNAME;

public class LoginActions {

    public void login() {
        Pages.loginPage().waitForLoginButtonStart();
        Pages.loginPage().openLoginForm();
        Pages.loginPage().waitForUsernameField();
        Pages.loginPage().typeUsername(LOGIN_USERNAME);
        Pages.loginPage().typePassword(LOGIN_PASSWORD);
        Pages.loginPage().clickLoginButton();
    }
}
