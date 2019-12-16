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
    public boolean displayMainContentView() {

        waitUtils.staticWait(3000);
        return driver.findElementById("android:id/content").isDisplayed();

    }

    /**
     * Locate the RecyclerView that contains the weather forecast items
     */
    @AndroidFindBy(id = "com.example.android.sunshine:id/recyclerview_forecast")
    AndroidElement mainRecyclerView;

    /**
     * Check size of RecyclerView to identify if the element was found
     */
    public boolean displayRecyclerView() {

        waitUtils.staticWait(1000);
        return driver.findElementById("com.example.android.sunshine:id/recyclerview_forecast").isDisplayed();

    }

    /**
     * Check if Date (day) appears on MainActivity widget
     * @return true if so
     */
    public boolean sizeMainWidgetDate() {

        waitUtils.staticWait(3000);
        return driver.findElementById("com.example.android.sunshine:id/date").isDisplayed();

    }

    /**
     * Get value of Date (day)
     */
    public String valueMainWidgetDate() {

        return driver.findElementById("com.example.android.sunshine:id/date").getText();

    }

    /**
     * Check if Weather icon appears on MainActivity widget
     * @return true if so
     */
    public boolean sizeMainWeatherIcon() {

        // return driver.findElementsById("com.example.android.sunshine:id/weather_icon").size();
        return driver.findElementById("com.example.android.sunshine:id/weather_icon").isDisplayed();

    }

    /**
     * Check if High temperature value appears on MainActivity widget
     * @return true if so
     */
    public boolean sizeMainWidgetHighTemperature() {

        return driver.findElementById("com.example.android.sunshine:id/high_temperature").isDisplayed();

    }

    /**
     * Get value of High temperature
     */
    public String valueMainWidgetHighTemperature() {

        return driver.findElementById("com.example.android.sunshine:id/high_temperature").getText();

    }

    /**
     * Check if Weather Description appears on MainActivity widget
     * @return true if so
     */
    public boolean sizeMainWidgetWeatherDescription() {

        return driver.findElementById("com.example.android.sunshine:id/weather_description").isDisplayed();

    }

    /**
     * Get value of Weather Description
     */
    public String valueMainWidgetWeatherDescription() {

        return driver.findElementById("com.example.android.sunshine:id/weather_description").getText();

    }

    /**
     * Check if Low temperature value appears on MainActivity widget
     * @return true if so
     */
    public boolean sizeMainWidgetLowTemperature() {

        return driver.findElementById("com.example.android.sunshine:id/low_temperature").isDisplayed();

    }

    /**
     * Get value of Low temperature
     */
    public String valueMainWidgetLowTemperature() {

        return driver.findElementById("com.example.android.sunshine:id/low_temperature").getText();

    }

}