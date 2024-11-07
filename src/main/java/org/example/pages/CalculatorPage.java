package org.example.pages;

import io.appium.java_client.AppiumDriver;
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


    public void tapToX() {
        tap(new Point(155, 1407));
    }

    public void tapToBrackets() {
        tap(new Point(465, 1401));
    }

    public void tapToPercent() {
        tap(new Point(781, 1407));
    }

    public void tapToComma() {
        tap(new Point(155, 2705));
    }

    public void tapToDelete() {
        tap(new Point(1103, 1407));
        tap(new Point(1103, 1407), Duration.ofMillis(500));
    }

    public void tapToZero() {
        tap(new Point(494, 2659));
    }

    public void tapToOne() {
        tap(new Point(161, 2355));
    }

    public void tapToTwo() {
        tap(new Point(471, 2320));
    }

    public void tapToThree() {
        tap(new Point(787, 2366));
    }

    public void tapToFour() {
        tap(new Point(195, 2079));
    }

    public void tapToFive() {
        tap(new Point(454, 2079));
    }

    public void tapToSix() {
        tap(new Point(787, 2039));
    }

    public void tapToSeven() {
        tap(new Point(184, 1746));
    }

    public void tapToEight() {
        tap(new Point(517, 1740));
    }

    public void tapToNine() {
        tap(new Point(729, 1746));
    }

    public void tapToEquals() {
        tap(new Point(821, 2682));
    }

    public void tapToPlus() {
        tap(new Point(1080, 2682));
    }

    public void tapToMinus() {
        tap(new Point(1126, 2395));
    }

    public void tapToMultiply() {
        tap(new Point(1154, 2090));
    }

    public void tapToDivide() {
        tap(new Point(1126, 1757));
    }

    public void tapToClearAds() {
        tap(new Point(115, 919), Duration.ofMillis(2000));
        tap(new Point(115, 919));
    }

    public String getResultFromFormula() {
        String result = driver.findElement(By.id("apps.r.calculator:id/formula")).getText();

        return result.replace(",", ".").replace("−", "-");

    }
}
