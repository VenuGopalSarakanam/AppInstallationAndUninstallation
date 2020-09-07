package playingVideo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class GooglePlayCapability {
	@Test
	public static AndroidDriver<AndroidElement> GooglePlayCapability() throws MalformedURLException {

	DesiredCapabilities cap = new DesiredCapabilities();

	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "PIXELXL29");
	//cap.setCapability(MobileCapabilityType.APP, value);
	
	cap.setCapability("appPackage", "com.android.vending");
	cap.setCapability("appActivity", "com.android.vending.AssetBrowserActivity");
	
	
	AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	
	return driver;
	
}}
