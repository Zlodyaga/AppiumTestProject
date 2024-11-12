import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.example.actions.Actions;
import org.example.pages.Pages;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.example.utils.Constants.*;

class TransferTest {

    static AppiumDriver driver;
    static Pages pages;

    @BeforeEach
    public void setUp() {
        var options = new UiAutomator2Options()
                .setAutomationName(ANDROID_DRIVER)
                .setPlatformName(PLATFORM_NAME_ANDROID)
                .setPlatformVersion(PLATFORM_VERSION)
                .setDeviceName(DEVICE_NAME)
                .setApp(APP_PATH)
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
        Actions.loginActions().login();
        Pages.homePage().waitForAccountsWidget();
        Pages.homePage().clickAccountSecond();

        Pages.accountPage().waitForLastTransaction();
        Pages.accountPage().clickLastTransaction();
        Pages.accountPage().waitForCategoryTransaction();
        System.out.println(Pages.accountPage().getLastTransaction());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}