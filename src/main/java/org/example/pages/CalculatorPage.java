package org.example.pages;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;

public class CalculatorPage {
    private static AppiumDriver driver;

    CalculatorPage(AppiumDriver driver) {
        CalculatorPage.driver = driver;
    }

    private void tap(Point point) {
        tap(point, Duration.ofMillis(400));
    }

    private void tap(Point point, Duration pauseTime) {
        var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), point.x, point.y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, pauseTime));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(tap));
    }

    @Step("Tap to X")
    public void tapToX() {
        tap(new Point(155, 1407));
    }

    @Step("Tap to brackets")
    public void tapToBrackets() {
        tap(new Point(465, 1401));
    }

    @Step("Tap to percent")
    public void tapToPercent() {
        tap(new Point(781, 1407));
    }

    @Step("Tap to comma")
    public void tapToComma() {
        tap(new Point(155, 2705));
    }

    @Step("Tap to delete")
    public void tapToDelete() {
        tap(new Point(1103, 1407));
        tap(new Point(1103, 1407), Duration.ofMillis(500));
    }

    @Step("Tap to zero")
    public void tapToZero() {
        tap(new Point(494, 2659));
    }

    @Step("Tap to one")
    public void tapToOne() {
        tap(new Point(161, 2355));
    }

    @Step("Tap to two")
    public void tapToTwo() {
        tap(new Point(471, 2320));
    }

    @Step("Tap to three")
    public void tapToThree() {
        tap(new Point(787, 2366));
    }

    @Step("Tap to four")
    public void tapToFour() {
        tap(new Point(195, 2079));
    }

    @Step("Tap to five")
    public void tapToFive() {
        tap(new Point(454, 2079));
    }

    @Step("Tap to six")
    public void tapToSix() {
        tap(new Point(787, 2039));
    }

    @Step("Tap to seven")
    public void tapToSeven() {
        tap(new Point(184, 1746));
    }

    @Step("Tap to eight")
    public void tapToEight() {
        tap(new Point(517, 1740));
    }

    @Step("Tap to nine")
    public void tapToNine() {
        tap(new Point(729, 1746));
    }

    @Step("Tap to equals")
    public void tapToEquals() {
        tap(new Point(821, 2682));
    }

    @Step("Tap to plus")
    public void tapToPlus() {
        tap(new Point(1080, 2682));
    }

    @Step("Tap to minus")
    public void tapToMinus() {
        tap(new Point(1126, 2395));
    }

    @Step("Tap to multiply")
    public void tapToMultiply() {
        tap(new Point(1154, 2090));
    }

    @Step("Tap to divide")
    public void tapToDivide() {
        tap(new Point(1126, 1757));
    }

    @Step("Tap to clear ads")
    public void tapToClearAds() {
        tap(new Point(115, 919), Duration.ofMillis(2000));
        tap(new Point(115, 919));
    }

    @Step("Get result for assertion")
    public String getResultFromFormula() {
        String result = driver.findElement(By.id("apps.r.calculator:id/formula")).getText();

        return result.replace(",", ".").replace("−", "-");

    }
}
