package org.example.pages;

import io.appium.java_client.AppiumDriver;

public class Pages {
    private static AppiumDriver driver;
    private static CalculatorPage calculatorPage;

    public Pages(AppiumDriver driver) {
        Pages.driver = driver;
    }

    public CalculatorPage calculatorPage() {
        if (calculatorPage == null) {
            calculatorPage = new CalculatorPage(driver);
        }
        return calculatorPage;
    }
}
