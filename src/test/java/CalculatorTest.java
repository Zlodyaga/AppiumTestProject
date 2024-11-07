import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.example.pages.Pages;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

class CalculatorTest {

    static AppiumDriver driver;
    static Pages pages;

    @BeforeEach
    public void setUp() {
        var options = new UiAutomator2Options()
                .setAutomationName("UiAutomator2")
                .setPlatformName("Android")
                .setPlatformVersion("15")
                .setDeviceName("emulator-5554")
                .setAppPackage("apps.r.calculator")
                .setAppActivity("apps.r.calculator.CalculatorActivity")
                .setNewCommandTimeout(Duration.ofMillis(3600));

        driver = new AppiumDriver(this.getUrl(), options);
        pages = new Pages(driver);
    }

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    void sampleTest() {
        pages.calculatorPage().tapToOne();
        pages.calculatorPage().tapToZero();
        pages.calculatorPage().tapToPlus(); // 10 + 23 = 33
        pages.calculatorPage().tapToTwo();
        pages.calculatorPage().tapToThree();
        pages.calculatorPage().tapToEquals();

        pages.calculatorPage().tapToClearAds();

        int plusResult = Integer.parseInt(pages.calculatorPage().getResultFromFormula());

        pages.calculatorPage().tapToFour();
        pages.calculatorPage().tapToFive();
        pages.calculatorPage().tapToMinus(); // 45 - 6,7 = 38.3
        pages.calculatorPage().tapToSix();
        pages.calculatorPage().tapToComma();
        pages.calculatorPage().tapToSeven();
        pages.calculatorPage().tapToEquals();

        double minusResult = Double.parseDouble(pages.calculatorPage().getResultFromFormula());

        pages.calculatorPage().tapToEight();
        pages.calculatorPage().tapToMultiply(); // 8 * 9 = 72
        pages.calculatorPage().tapToNine();
        pages.calculatorPage().tapToEquals();

        int multiplyResult = Integer.parseInt(pages.calculatorPage().getResultFromFormula());

        pages.calculatorPage().tapToDelete();

        pages.calculatorPage().tapToSix();
        pages.calculatorPage().tapToDivide(); // 6 / -3 = 2
        pages.calculatorPage().tapToMinus();
        pages.calculatorPage().tapToThree();
        pages.calculatorPage().tapToEquals();

        int divideResult = Integer.parseInt(pages.calculatorPage().getResultFromFormula());

        pages.calculatorPage().tapToDelete();

        Assertions.assertEquals(33, plusResult, "Plus result expected 33, but was " + plusResult);
        Assertions.assertEquals(38.3, minusResult, "Minus result expected 33, but was " + plusResult);
        Assertions.assertEquals(72, multiplyResult, "Multiply result expected 33, but was " + plusResult);
        Assertions.assertEquals(-2, divideResult, "Divide result expected 33, but was " + plusResult);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}