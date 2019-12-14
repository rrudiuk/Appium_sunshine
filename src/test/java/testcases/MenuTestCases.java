package testcases;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.MenuPO;

public class MenuTestCases extends BaseTestCase{

    @Test
    public void testMainMenuMapLocation() {

        // Create the page's driver
        MenuPO menuPO = new MenuPO(driver);

        // Check if ActionBar appears on the screen
        Assert.assertTrue(menuPO.sizeMainActionBar() != 0);
        // Tap More Options icon
        menuPO.tapMoreOptions();
        // Tap Map Location
        menuPO.tapMapLocation();
        // Check if modal with available apps pops up
        Assert.assertTrue(menuPO.sizeContentModal() != 0);
        // Close modal
        menuPO.tapCancelModal();

    }

    @Test
    public void testMainMenuSettings() {

        // Create the page's driver
        MenuPO menuPO = new MenuPO(driver);

        // Tap More Options icon
        menuPO.tapMoreOptions();
        // Tap Settings item
        menuPO.tapSettingsItem();
        // Check whether Settings screen is opened
        Assert.assertTrue(menuPO.sizeSunshineSettings() != 0);
        // Tap 'Arrow Back'
        menuPO.tapSettingsBackArrow();
        // Access Settings screen once again and then tap phone Back button
        menuPO.tapMoreOptions();
        menuPO.tapSettingsItem();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        // Verify that MainActivity is running by verifying that ActionBar appears on the screen
        Assert.assertTrue(menuPO.sizeMainActionBar() != 0);

    }

    @Test
    public void testTodayWeatherMenu() {

        // Create the page's driver
        MenuPO menuPO = new MenuPO(driver);

        // Access Details screen for today's weather
        menuPO.tapTodayWeatherDetails();
        // Compare actual title of ActionBar with expected
        Assert.assertEquals(menuPO.actualActionBarDetailsTitle(),
                menuPO.expectedActionBarDetailsTitle());
        // Tap 'Arrow Back' and return to MainActivity
        menuPO.tapSettingsBackArrow();
        // Access Details screen for today's weather and return to MainActivity by pressing phone Back button
        menuPO.tapTodayWeatherDetails();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        // Check if MainActivity is open by verifying that main ActionBar appears on the screen
        Assert.assertTrue(menuPO.sizeMainActionBar() != 0);

    }

    @Test
    public void testForecastWeatherItemMenu() {

        // Create the page's driver
        MenuPO menuPO = new MenuPO(driver);

        // Access Details screen for the first forecast item
        menuPO.tapTomorrowWeatherItem();
        // Compare actual title of ActionBar with expected
        Assert.assertEquals(menuPO.actualActionBarDetailsTitle(),
                menuPO.expectedActionBarDetailsTitle());
        // Tap 'Arrow Back' and return to MainActivity
        menuPO.tapSettingsBackArrow();
        // Access Details screen for the last forecast item and return to MainActivity by pressing phone Back button
        menuPO.tapTomorrowWeatherItem();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        // Check if MainActivity is open by verifying that main ActionBar appears on the screen
        Assert.assertTrue(menuPO.sizeMainActionBar() != 0);

    }

    @Test
    public void testDetailsMenuShare() {

        // Create the page's driver
        MenuPO menuPO = new MenuPO(driver);

        // Access Details screen for today's weather
        menuPO.tapTodayWeatherDetails();
        // Tap Share icon on ActionBar
        menuPO.tapShareItemActionBar();
        // Check if modal with available apps pops up
        Assert.assertTrue(menuPO.sizeContentModal() != 0);
        // Close modal
        menuPO.tapCancelModal();
        // Tap 'Arrow Back' and return to MainActivity
        menuPO.tapSettingsBackArrow();
        // Check if MainActivity is open by verifying that main ActionBar appears on the screen
        Assert.assertTrue(menuPO.sizeMainActionBar() != 0);

    }

    @Test
    public void testDetailsMenuSettings() {

        // Create the page's driver
        MenuPO menuPO = new MenuPO(driver);

        // Access Details screen for today's weather
        menuPO.tapTodayWeatherDetails();
        // Tap More Options icon
        menuPO.tapMoreOptions();
        // Tap Settings item
        menuPO.tapSettingsDetailsActionBar();
        // Check whether Settings screen is opened
        Assert.assertTrue(menuPO.sizeSunshineSettings() != 0);
        // Tap 'Arrow Back'
        menuPO.tapSettingsBackArrow();
        // Tap 'Arrow Back' and return to MainActivity
        menuPO.tapSettingsBackArrow();
        // Check if MainActivity is open by verifying that main ActionBar appears on the screen
        Assert.assertTrue(menuPO.sizeMainActionBar() != 0);

        // Access Details screen for today's weather
        menuPO.tapTodayWeatherDetails();
        // Tap More Options icon
        menuPO.tapMoreOptions();
        // Tap Settings item
        menuPO.tapSettingsDetailsActionBar();
        // Tap phone Back button twice
        waitUtils.staticWait(1000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        waitUtils.staticWait(1000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        // Check if MainActivity is open by verifying that main ActionBar appears on the screen
        Assert.assertTrue(menuPO.sizeMainActionBar() != 0);

    }

}
