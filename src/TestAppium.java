import java.io.File;
import java.net.URL;

import java.util.Date;
import java.util.concurrent.TimeUnit;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.Test;



public class TestAppium {

	/**
	 * @param args
	 */
	AppiumDriver driver;
	@Test
	public void testApp(){
		try{
			File app = new File("C:\\Users\\kumar.nipun\\Desktop\\WhatsApp.apk");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4.2");
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S4");
			capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, "com.whatsapp");
			capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, "com.whatsapp.Main");
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AndroidDriver(url,capabilities);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Thread.sleep(10000L);
			
			System.out.println("Taking screenshot...");
			String Screenshotpath = "C:\\Users\\kumar.nipun\\Desktop\\img2.jpg";
			
			long startTime  = (new Date()).getTime();			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(Screenshotpath));
			long endTime = (new Date()).getTime();
			
			System.out.println("Total time taken: " + (endTime - startTime) + " ms");
			
			driver.quit();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
	}*/

}
