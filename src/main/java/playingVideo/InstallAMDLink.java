package playingVideo;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
public class InstallAMDLink extends GooglePlayCapability{
	
	@Test
	public void DownloadAndUninstallAMDLink() throws MalformedURLException, InterruptedException {

		AndroidDriver<AndroidElement> driver = GooglePlayCapability();
		
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		Thread.sleep(30000);
		driver.findElementByXPath("//android.widget.TextView[@text='Search for apps & games']").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("AMD Link");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElementByXPath("//android.widget.Button[@text='Install']").click();
		Thread.sleep(30000);
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		Thread.sleep(100000);
		
		
		
		
		//driver.findElementByXPath("//android.widget.Button[@text='Open']").click();
		
		
		

	
	}
	
	

}
