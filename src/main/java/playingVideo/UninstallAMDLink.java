package playingVideo;

import java.net.MalformedURLException;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element; 
import io.appium.java_client.TouchAction;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class UninstallAMDLink extends PixelHomeCapabilities{
	
	@Test
	public void Uninstall() throws MalformedURLException, InterruptedException {
	AndroidDriver<AndroidElement> driver = PixelHomeCapabilities();
	
//	Dimension size = driver.manage().window().getSize();
//	int start_x= (int)(size.getHeight()/7);
//	int width = (int)(size.getWidth()/7);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElementByAccessibilityId("Apps list").click();
	new TouchAction(driver).press(PointOption.point(690, 1704))
	.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
	.moveTo(PointOption.point(690, 325))
	.release()
	.perform();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	System.out.println(driver.findElementByAccessibilityId("AMD Link").isDisplayed());
	driver.findElementByClassName("android.view.View").click();
	TouchAction t = new TouchAction(driver);

	WebElement first = driver.findElementByAccessibilityId("AMD Link");
	new TouchAction(driver)
	.longPress(longPressOptions()
	.withElement(element(first))
	.withDuration(Duration.ofMillis(10000)))
	.release().perform();
    Thread.sleep(5000);
	
	//Act.longPress(longPressOptions)
	System.out.println("LongPressExucted");

	driver.findElementByXPath("//android.widget.TextView[0]").click();
	driver.findElementByXPath("//android.widget.Button[@text='Uninstall']").click();
	driver.findElementByXPath("//android.widget.Button[@text='OK']").click();

}}

