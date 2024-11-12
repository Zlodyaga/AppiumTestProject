package org.example.pages;

import io.appium.java_client.AppiumDriver;

public class Pages {
    private static AppiumDriver driver;
    private static HomePage homePage;
    private static LoginPage loginPage;
    private static AccountPage accountPage;

    public Pages(AppiumDriver driver) {
        Pages.driver = driver;
    }

    public static HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public static LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public static AccountPage accountPage() {
        if (accountPage == null) {
            accountPage = new AccountPage(driver);
        }
        return accountPage;
    }
}
