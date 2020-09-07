package playingVideo;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

/**
 * Hello world!
 *
 */

public class YoutubeWatchAndCloseVideo extends Capabilities {

//
//	@Test
//	public void oneMethod() {
//		System.out.println("This is a test");
//
//
//	}


	public void oneBeforeTest() {
		System.out.println("This is a Before Test. Executed First");}

//	@Test
//	public void twoMethod() {
//		System.out.println("This is a Test 2");
//	}
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is a Before Method.Executes before every test");
	}
//	@AfterMethod
//	public void afterMethod() {
//		System.out.println("This is a After Method. Executes after every test");
//	}
	@AfterTest
	public void afterTest1() {
		System.out.println("This is a After Test and executes once after the first test");
	}


	@Test
	private static void letsee() throws MalformedURLException, InterruptedException {

		AndroidDriver<AndroidElement> driver = Capabilities();

		Thread.sleep(5000);
		driver.findElementByAccessibilityId("Search").click();
		driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.EditText[@text='Search YouTube']").sendKeys("Technopro Telugu");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		//driver.findElementByXPath("//android.widget.ImageView[@bounds='[0,308][1440,679]']").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//android.widget.ImageView[@bounds='[56,690][616,1005]']").click();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(30000);
		Dimension size = driver.manage().window().getSize();
		int start_x= (int)(size.getHeight());
		int start_y = (int)(size.getHeight());
		System.out.println("X-Axis Intial Value: "+ start_x);
		System.out.println("Y-Axis Intial Value: "+ start_y);
		
		int startx = (int)(size.getHeight()*0.30);
		int starty = (int)(size.getWidth()*0.50);
		System.out.println("X-Axis Value: "+ startx);
		System.out.println("Y-Axis Valye: "+ starty);
		
		
		new TouchAction(driver).press(PointOption.point(startx,starty))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(startx,starty+1500))
		.release()
		.perform();
		System.out.println("Swipe Completed");
		Thread.sleep(5000);
		new TouchAction(driver).press(PointOption.point(startx+563,starty+1340))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(startx-600,starty+1340))
		.release()
		.perform();
		System.out.println("Swipe Completed");


	}
}