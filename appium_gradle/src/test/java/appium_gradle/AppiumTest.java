package appium_gradle;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import actions.commons.AbstractTest;
import actions.commons.ReportListener;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumTest extends AbstractTest {

	@SuppressWarnings("rawtypes")
	AppiumDriver driver;

	@BeforeMethod
	public void beforeMethod() throws IOException {
		driver = initApp();
	}

	@Test
	public void testCase01() throws Exception {
		ReportListener.logReport.log(Status.INFO, MarkupHelper.createLabel("Start APP", ExtentColor.CYAN));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		driver.findElementByClassName("android.widget.CheckBox").click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		driver.findElementById("android:id/edit").sendKeys("Nguyen Ngoc Thuong");
		driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();

		Thread.sleep(2000);
		driver.navigate().back();

		driver.findElement(By.xpath("//android.widget.TextView[@text='2. Launching preferences']")).click();
		String textTest = driver.findElement(By.xpath("//android.widget.LinearLayout//android.widget.TextView")).getText();
		Assert.assertEquals(textTest, "The counter value is 100");

		Thread.sleep(2000);
		driver.navigate().back();

		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Preferences from XML']")).click();

		scrollDown();
		Thread.sleep(2000);
		scrollUp();
	}

	@Test
	public void testCase02() throws Exception {
		ReportListener.logReport.log(Status.INFO, MarkupHelper.createLabel("Start APP", ExtentColor.CYAN));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		driver.findElementByClassName("android.widget.CheckBox").click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		driver.findElementById("android:id/edit").sendKeys("Nguyen Ngoc Thuong");
		driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();

		Thread.sleep(2000);
		driver.navigate().back();

		driver.findElement(By.xpath("//android.widget.TextView[@text='2. Launching preferences']")).click();
		String textTest = driver.findElement(By.xpath("//android.widget.LinearLayout//android.widget.TextView")).getText();
		Assert.assertEquals(textTest, "The counter value is 10");

		Thread.sleep(2000);
		driver.navigate().back();

		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Preferences from XML']")).click();

		scrollDown();
		Thread.sleep(2000);
		scrollUp();
	}

	@AfterMethod
	public void afterMethod() {
		driver.closeApp();
	}

	@SuppressWarnings("rawtypes")
	public void scrollDown()  {

		//The viewing size of the device
		Dimension size = driver.manage().window().getSize();

		//x position set to mid-screen horizontally
		int width = size.width / 2;

		//Starting y location set to 80% of the height (near bottom)
		int startPoint = (int) (size.getHeight() * 0.80);

		//Ending y location set to 20% of the height (near top)
		int endPoint = (int) (size.getHeight() * 0.20);

		new TouchAction(driver)
			.press(PointOption.point(width, startPoint))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
			.moveTo(PointOption.point(width, endPoint))
			.release()
			.perform();

	}

	@SuppressWarnings("rawtypes")
	public void scrollUp()  {

		//The viewing size of the device
		Dimension size = driver.manage().window().getSize();

		//x position set to mid-screen horizontally
		int width = size.width / 2;

		//Starting y location set to 80% of the height (near bottom)
		int startPoint = (int) (size.getHeight() * 0.80);

		//Ending y location set to 20% of the height (near top)
		int endPoint = (int) (size.getHeight() * 0.20);

		new TouchAction(driver)
			.press(PointOption.point(width, endPoint))
			.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
			.moveTo(PointOption.point(width, startPoint))
			.release()
			.perform();

	}
}
