package testcases;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.MenuPO;

public class MenuTestCases extends BaseTestCase{

    @Test
    public void testMenuMapLocation() {

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
    public void testMenuSettings() {

        // Create the page's driver
        MenuPO menuPO = new MenuPO(driver);

        // Tap More Options icon
        menuPO.tapMoreOptions();
        // Tap Map Location
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

}
