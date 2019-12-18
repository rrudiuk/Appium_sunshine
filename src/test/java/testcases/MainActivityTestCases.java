package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.MainActivityPO;

public class MainActivityTestCases extends BaseTestCase{

    @Test
    public void testMainElementsAppear() {

        // Create the page's driver
        MainActivityPO mainActivityPO = new MainActivityPO(driver);

        // Check if the layout that contains the MainActivity content appears
        Assert.assertTrue(mainActivityPO.displayMainContentView());

        // Check if RecycleView element appear in MainActivity
        Assert.assertTrue(mainActivityPO.displayRecyclerView());

    }

    @Test
    public void testMainActivityWidgetElements() {

        // Create the page's driver
        MainActivityPO mainActivityPO = new MainActivityPO(driver);

        // Check if Date (day) appears on MainActivity widget
        Assert.assertTrue(mainActivityPO.sizeMainWidgetDate());
        // Check if value Date (day) isn't null
        Assert.assertNotNull(mainActivityPO.valueMainWidgetDate());

        // Check if Weather icon is displayed on MainActivity widget
        Assert.assertTrue(mainActivityPO.sizeMainWeatherIcon());

        // Check if High temperature value appears on MainActivity widget
        Assert.assertTrue(mainActivityPO.sizeMainWidgetHighTemperature());
        // Check if High temperature value isn't null
        Assert.assertNotNull(mainActivityPO.valueMainWidgetHighTemperature());

        // Check if Weather Description appears on MainActivity widget
        Assert.assertTrue(mainActivityPO.sizeMainWidgetWeatherDescription());
        // Check if Weather Description isn't null
        Assert.assertNotNull(mainActivityPO.valueMainWidgetWeatherDescription());

        // Check if Low temperature value appears on MainActivity widget
        Assert.assertTrue(mainActivityPO.sizeMainWidgetLowTemperature());
        // Check if Low temperature value isn't null
        Assert.assertNotNull(mainActivityPO.valueMainWidgetLowTemperature());

    }

}
