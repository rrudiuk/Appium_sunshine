package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.MainActivityPO;

public class TestCases extends BaseTestCase{

    @Test
    public void testMainElementsAppear() {

        // Create the page's driver
        MainActivityPO mainActivityPO = new MainActivityPO(driver);

        // Check if the layout that contains the MainActivity content appears
        Assert.assertTrue(mainActivityPO.sizeMainContentView() != 0);

        // Check if RecycleView element appear in MainActivity
        Assert.assertTrue(mainActivityPO.sizeRecyclerView() != 0);

    }

}
