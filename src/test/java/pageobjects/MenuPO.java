package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.PropertyUtils;

public class MenuPO extends BasePO{

    /**
     * A base constructor that sets the page's driver.
     *
     * The page structure is being used within this test in order to separate the
     * page actions from the test.
     *
     * Please use the AppiumFieldDecorator class within the page factory. This way annotations
     * like @AndroidFindBy within the page object.
     *
     *
     * @param driver the appium driver created in the beforesuite method.
     */
    public MenuPO (AppiumDriver driver) {
        super(driver);
    }

    /**
     * Find Menu on MainActivity
     */
    @AndroidFindBy(id = "com.example.android.sunshine:id/action_bar")
    AndroidElement MainActionBar;

    /**
     * Check size of MainActionBar to identify if the element was found
     */
    public int sizeMainActionBar() {
        waitUtils.staticWait(3000);
        return driver.findElementsById("com.example.android.sunshine:id/action_bar").size();
    }

    /**
     * Find More Options element on MainActivity > Main Menu
     */
    @AndroidFindBy(accessibility = "More options")
    AndroidElement ActionBarMoreOptions;

    /**
     * This method taps More Options item
     */
    public void tapMoreOptions() {
        waitUtils.staticWait(1000);
        ActionBarMoreOptions.click();
    }

    /**
     * Find Map Location setting item
     */
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget" +
            ".FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget" +
            ".LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
    AndroidElement ActionBarMapLocation;

    /**
     * Click Map Location Menu item
     */
    public void tapMapLocation() {
        waitUtils.staticWait(3000);
        ActionBarMapLocation.click();
    }

    /**
     * Check size of modal to identify if the element was found
     */
    public int sizeContentModal() {
        waitUtils.staticWait(2000);
        return driver.findElementsById("android:id/content").size();
    }

    /**
     * Find button to cancel modal
     */
    @AndroidFindBy(id = "android:id/button2")
    AndroidElement modalCancelButton;

    public void tapCancelModal() {
        waitUtils.staticWait(2000);
        modalCancelButton.click();
    }

    /**
     * Find Settings setting item
     */
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget" +
            ".FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]")
    AndroidElement ActionBarSettings;

    /**
     * Click Settings setting item
     */
    public void tapSettingsItem() {
        waitUtils.staticWait(3000);
        ActionBarSettings.click();
    }

    /**
     * Check size if Sunshine settings screen is opened and if Settings Menu is being shown
     */
    public int sizeSunshineSettings() {
        waitUtils.staticWait(3000);
        return driver.findElementsById("com.example.android.sunshine:id/action_bar_container").size();
    }

    /**
     * Find Back Arrow on Settings menu
     */
    @AndroidFindBy(accessibility = "Navigate up")
    AndroidElement ActionBarBackArrow;

    /**
     * Tap Back Arrow
     */
    public void tapSettingsBackArrow() {
        waitUtils.staticWait(3000);
        ActionBarBackArrow.click();
    }

    /**
     * Help Selector and method that allow to access Details screen for today's weather
     */
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget" +
            ".LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget." +
            "FrameLayout[2]/android.widget.FrameLayout/android.support.v7.widget" +
            ".RecyclerView/android.view.ViewGroup[1]")
    AndroidElement TodayWeatherDetails;

    public void tapTodayWeatherDetails() {
        waitUtils.staticWait(3000);
        TodayWeatherDetails.click();
    }

    /**
     * Find Details menu
     */
    @AndroidFindBy(id = "com.example.android.sunshine:id/action_bar")
    AndroidElement ActionBarDetails;

    /**
     * Find title of the Details menu
     */
    @AndroidFindBy(xpath = "/hierarchy/android.widget" +
            ".FrameLayout/android.widget.LinearLayout/android.widget" +
            ".FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android" +
            ".view.ViewGroup/android.widget.TextView")
    AndroidElement ActionBarDetailsTitle;

    /**
     * Get actual text of ActionBarDetailsTitle
     */
    public String actualActionBarDetailsTitle() {

        return ActionBarDetailsTitle.getText();
    }

    /**
     * Expected text of ActionBarDetailsTitle
     */
    public String expectedActionBarDetailsTitle() {

        return PropertyUtils.getProperty("details.menu.title");
    }

    /**
     * Locate Share icon on ActionBar
     */
    @AndroidFindBy(accessibility = "Share")
    AndroidElement ShareItemActionBar;

    /**
     * Tap Share icon
     */
    public void tapShareItemActionBar() {
        waitUtils.staticWait(3000);
        ShareItemActionBar.click();
    }
}
