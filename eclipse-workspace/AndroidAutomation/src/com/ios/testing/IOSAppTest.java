package com.ios.testing;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IOSAppTest {
	WebDriver driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException {
		DesiredCapabilities capabilities= new DesiredCapabilities();
		capabilities = DesiredCapabilities.ipad();
		capabilities.setCapability("deviceName", "iPad 9");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
		capabilities.setCapability(CapabilityType.VERSION, "5.1");
		capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("appPackage", "io.selendroid.testapp");
		capabilities.setCapability("appActivity",".HomeScreenActivity");
		driver=new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}

	@Test(priority=0, description="Test case 1: open mobile app and enter input data")
	public void mobile() {
		driver.findElement(By.id("io.selendroid.testapp:id/my_text_field")).clear();
		driver.findElement(By.id("io.selendroid.testapp:id/my_text_field")).sendKeys("Sapna Mishra");
		System.out.println("Input text is entered");
		driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration")).click();
		System.out.println("User clicks on start user registration");
	}
		
}
