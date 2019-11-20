package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MainActivityPO extends BasePO {

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
    public MainActivityPO (AppiumDriver driver) {
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
        waitUtils.staticWait(3000);
        ActionBarMoreOptions.click();
    }

    /**
     * Find Map Location setting item
     */
    @AndroidFindBy(id = "com.example.android.sunshine:id/action_map")
    AndroidElement ActionBarMapLocation;

    /**
     * Find Settings setting item
     */
    @AndroidFindBy(id = "com.example.android.sunshine:id/action_settings")
    AndroidElement ActionBarSettings;

}
