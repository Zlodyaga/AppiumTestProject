package org.example.pages;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.example.base.PageTools;
import org.example.data.Transaction;
import org.openqa.selenium.By;

public class AccountPage extends PageTools {
    private static AppiumDriver driver;

    private static final By lastTransaction = By.xpath("//android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]");
    private static final By amountTransaction = By.xpath("//android.widget.TextView[@resource-id=\"com.nymbus.enterprise.mobile:id/amount\"]");
    private static final By dateTransaction = By.xpath("//android.widget.LinearLayout[2]/android.widget.TextView[2]");
    private static final By categoryTransaction = By.xpath("//android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[2]");
    private static final By noteTransaction = By.xpath("//android.widget.EditText[@resource-id=\"com.nymbus.enterprise.mobile:id/editNotes\"]");
    private static final By typeTransaction = By.xpath("//android.widget.LinearLayout[3]//android.widget.TextView[2]\n");

    AccountPage(AppiumDriver driver) {
        AccountPage.driver = driver;
    }

    @Step("Wait for last transaction")
    public void waitForLastTransaction() {
        waitForElementClickable(lastTransaction, driver);
    }

    @Step("Wait for category of transaction")
    public void waitForCategoryTransaction() {
        waitForElementClickable(categoryTransaction, driver);
    }

    @Step("Click on last transaction for detailed info")
    public void clickLastTransaction() {
        driver.findElement(lastTransaction).click();
    }

    @Step("Get amount of transaction")
    private String getAmountTransaction() {
        return getElementText(amountTransaction, driver);
    }

    @Step("Get date of transaction")
    private String getDateTransaction() {
        return getElementText(dateTransaction, driver);
    }

    @Step("Get category of transaction")
    private String getCategoryTransaction() {
        return getElementText(categoryTransaction, driver);
    }

    @Step("Get note of transaction")
    private String getNoteTransaction() {
        return getElementText(noteTransaction, driver);
    }

    @Step("Get type of transaction")
    private String getTypeTransaction() {
        return getElementText(typeTransaction, driver);
    }

    @Step("Get last transaction")
    public Transaction getLastTransaction() {
        return new Transaction(
                getAmountTransaction(),
                getTypeTransaction(),
                getDateTransaction(),
                getCategoryTransaction(),
                getNoteTransaction()
        );
    }
}
