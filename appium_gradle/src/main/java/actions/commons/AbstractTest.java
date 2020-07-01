package actions.commons;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public abstract class AbstractTest {
    @SuppressWarnings("rawtypes")
	private AppiumDriver driver;

    @SuppressWarnings("rawtypes")
	public AppiumDriver initApp() throws MalformedURLException {
    	File f = new File("src/test/java");
		File fs = new File(f, "./ApiDemos-debug.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		return driver;
	}

    @SuppressWarnings("rawtypes")
	public AppiumDriver getDriver() {
        return this.driver;
    }
}
