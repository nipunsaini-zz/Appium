import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Demo {

	public WebDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.VERSION, "5.0.1");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.android.calculator2");
		capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
		
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
	@Test
	public void testCal(){
		WebElement two = driver.findElement(By.name("2"));
		two.click();
		WebElement plus = driver.findElement(By.name("+"));
		plus.click();
		WebElement four = driver.findElement(By.name("4"));
		four.click();
		WebElement equalTo = driver.findElement(By.name("="));
		equalTo.click();
		WebElement res = driver.findElement(By.id("com.android.calculator2:id/formula"));
		//System.out.println(res.getText());
		Assert.assertEquals(res.getText(), "6");
	}
	
	
	
	@AfterClass
	public void teardown(){
		driver.quit();
	}

}
