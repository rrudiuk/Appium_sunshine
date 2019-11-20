package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.MainActivityPO;

public class TestCases extends BaseTestCase{

    @Test
    public void testMenu() {
        MainActivityPO mainActivityPO = new MainActivityPO(driver);

        // Check if ActionBar appears on the screen
        Assert.assertTrue(mainActivityPO.sizeMainActionBar() != 0);
        // Tap More Options icon
        mainActivityPO.tapMoreOptions();
    }

}
