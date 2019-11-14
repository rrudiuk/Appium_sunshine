package testcases;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertyUtils;
import utils.WaitUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseTestCase {

    public AndroidDriver driver;
    public static WaitUtils waitUtils = new WaitUtils();

    @BeforeMethod
    public void setUpAppium() throws MalformedURLException {
        String APPIUM_SERVER_URL = PropertyUtils.getProperty("appium.server.url");
        DesiredCapabilities capabilities = new
                DesiredCapabilities();
        setDesiredCapabilitiesForAndroid(capabilities);
        driver = new AndroidDriver(new URL(APPIUM_SERVER_URL), capabilities);
    }

//    @Parameters({"platformVersion", "deviceName", "port"})
//    @BeforeMethod
//    public void setUp(String platformVersion, String deviceName, String port) throws MalformedURLException {
//        AppiumDriverLocalService service = new AppiumServiceBuilder().usingPort(Integer.valueOf(port)).build();
//        service.start();
//
//        if (service == null || !service.isRunning()) {
//            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server node has not started");
//        }
//
//        DesiredCapabilities dc = new DesiredCapabilities();
//        setDesiredCapabilitiesForAndroid(dc);
//
//        driver = new AndroidDriver<AndroidElement>(service.getUrl(), dc);
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * It will set the DesiredCapabilities for the local
     * execution
     *
     * @param desiredCapabilities
     */
    private void setDesiredCapabilitiesForAndroid(DesiredCapabilities desiredCapabilities) {
        String PLATFORM_NAME = PropertyUtils.getProperty("android.platform");
        String PLATFORM_VERSION = PropertyUtils.getProperty("android.platform.version");
        String APP_NAME = PropertyUtils.getProperty("android.app.name");
        String APP_RELATIVE_PATH = PropertyUtils.getProperty("android.app.location");
        String APP_PATH = getAbsolutePath(APP_RELATIVE_PATH);
        String DEVICE_NAME = PropertyUtils.getProperty("android.device.name");
        String APP_PACKAGE_NAME = PropertyUtils.getProperty("android.app.packageName");
        String APP_ACTIVITY_NAME = PropertyUtils.getProperty("android.app.activityName");
        String APP_FULL_RESET = PropertyUtils.getProperty("android.app.full.reset");
        String APP_NO_RESET = PropertyUtils.getProperty("android.app.no.reset");

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, APP_PATH);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE_NAME);
//        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, APP_FULL_RESET);
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, APP_NO_RESET);
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);

    }

    private static String getAbsolutePath (String appRelativePath){
        File file = new File(appRelativePath);
        return file.getAbsolutePath();
    }

    /**
     * This will quite the android driver instance
     */
    @AfterMethod
    private void quitDriver() {
        try {
            this.driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}