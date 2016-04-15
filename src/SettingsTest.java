import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class SettingsTest {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.VERSION, "5.0.1");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.android.settings");
		capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.android.settings.Settings");
		
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void testSettings() throws Exception{
		/*driver.findElement(By.name("Bluetooth")).click();
		driver.findElement(By.className("android.widget.ImageButton")).click();*/
		
		driver.findElement(By.name("Data usage")).click();
		
		HashMap<String, Integer> keycode = new HashMap<String, Integer>();
		keycode.put("keycode", 4);
		((JavascriptExecutor ) (AppiumDriver)driver).executeScript("mobile: keyevent",keycode);
		/*Process p = Runtime.getRuntime().exec("cmd /K cd " +"E:\\android-sdk\\platform-tools");
		p.waitFor();
		Process p2 = Runtime.getRuntime().exec("cmd /C adb shell input keyevent 4");
		p2.waitFor();*/
        driver.findElement(By.name("Bluetooth")).click();
        driver.findElement(By.className("android.widget.ImageButton")).click();
		//driver.navigate().back();
		//driver.findElement(By.className("android.widget.ImageButton")).click();
		
	}
	
	@AfterClass
	public void teardown(){
		driver.quit();
	}
	
}
