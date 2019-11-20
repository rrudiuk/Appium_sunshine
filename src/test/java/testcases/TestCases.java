package testcases;

import org.testng.annotations.Test;
import pageobjects.MainActivityPO;

public class TestCases extends  BaseTestCase{

    @Test
    public void test() {
        MainActivityPO mainActivityPO = new MainActivityPO(driver);
        mainActivityPO.tapMoreOptions();
    }

}
