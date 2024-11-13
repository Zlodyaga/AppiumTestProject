package org.example.actions;

import io.appium.java_client.AppiumDriver;

public class Actions {

    private static AppiumDriver driver;
    private static LoginActions loginActions;
    private static MainActions mainActions;

    public Actions(AppiumDriver driver) {
        Actions.driver = driver;
    }

    public static LoginActions loginActions() {
        if (loginActions == null) {
            loginActions = new LoginActions(driver);
        }
        return loginActions;
    }

    public static MainActions mainActions() {
        if (mainActions == null) {
            mainActions = new MainActions(driver);
        }
        return mainActions;
    }
}
