package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.MainActivityPO;

public class TestCases extends BaseTestCase{

    @Test
    public void testMenuMapLocation() {

        // Create the page's driver
        MainActivityPO mainActivityPO = new MainActivityPO(driver);

        // Check if ActionBar appears on the screen
        Assert.assertTrue(mainActivityPO.sizeMainActionBar() != 0);
        // Tap More Options icon
        mainActivityPO.tapMoreOptions();
        // Tap Map Location
        mainActivityPO.tapMapLocation();
        // Check if modal with available apps pops up
        Assert.assertTrue(mainActivityPO.sizeContentModal() != 0);
        // Close modal
        mainActivityPO.tapCancelModal();

    }

    @Test
    public void testMenuSettings() {

        // Create the page's driver
        MainActivityPO mainActivityPO = new MainActivityPO(driver);

        // Tap More Options icon
        mainActivityPO.tapMoreOptions();
        // Tap Map Location
        mainActivityPO.tapSettingsItem();
        // Check whether Settings screen is opened
        Assert.assertTrue(mainActivityPO.sizeSensineSettings() != 0);

    }

}
