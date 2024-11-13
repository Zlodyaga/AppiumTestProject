package org.example.actions;

import io.appium.java_client.AppiumDriver;
import org.example.pages.Pages;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;
import java.util.Map;

import static org.example.utils.Constants.LOGIN_PASSWORD;
import static org.example.utils.Constants.LOGIN_USERNAME;

public class MainActions {

    private static AppiumDriver driver;

    private static final Point UpPoint = new Point (672, 551);
    private static final Point DownPoint = new Point(672, 2182);

    MainActions(AppiumDriver driver) {
        MainActions.driver = driver;
    }

    public void pressBack() {
        driver.executeScript("mobile: pressKey", Map.ofEntries(Map.entry("keycode", 4)));
    }

    public void swipeDown() {
        swipe(DownPoint, UpPoint);
    }

    public void swipeUp() {
        swipe(UpPoint, DownPoint);
    }

    private void swipe(Point start, Point end) {
        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));
    }
}
