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
     * Locate the layout that contains the MainActivity content
     */
    @AndroidFindBy(id="android:id/content")
    AndroidElement mainContentView;

    /**
     * Check size of mainContentView to identify if the element was found
     */
    public int sizeMainContentView() {

        waitUtils.staticWait(3000);
        return driver.findElementsById("android:id/content").size();

    }

    /**
     * Locate the RecyclerView that contains the weather forecast items
     */
    @AndroidFindBy(id = "com.example.android.sunshine:id/recyclerview_forecast")
    AndroidElement mainRecyclerView;

    /**
     * Check size of RecyclerView to identify if the element was found
     */
    public int sizeRecyclerView() {

        waitUtils.staticWait(1000);
        return driver.findElementsById("com.example.android.sunshine:id/recyclerview_forecast").size();

    }



}