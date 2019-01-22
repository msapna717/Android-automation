package com.android.testing;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.MobileElement;



public class AndroidAutomation {
WebDriver driver;

  
@BeforeTest
public void setup() throws MalformedURLException {
	DesiredCapabilities capabilities= new DesiredCapabilities();
	capabilities = DesiredCapabilities.android();
	capabilities.setCapability("deviceName", "Moto G4");
	capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	capabilities.setCapability(CapabilityType.VERSION, "7.0");
	capabilities.setCapability("automationName", "Appium");
	capabilities.setCapability("platformName", "Android");
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
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	
}
@Test(priority=1, description="Test case 2: User registration")
public void registraion() {
	driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration")).click();
	System.out.println("User clicks on start user registration");
	
	driver.findElement(By.id("io.selendroid.testapp:id/inputUsername")).sendKeys("msapna717");
	System.out.println("User enters username");
	driver.findElement(By.id("io.selendroid.testapp:id/inputEmail")).sendKeys("msapna717@gmail.com");
	System.out.println("User enters email id");
	driver.findElement(By.id("io.selendroid.testapp:id/inputPassword")).sendKeys("12345678");
	System.out.println("User enters password");
	driver.findElement(By.id("io.selendroid.testapp:id/inputName")).clear();
	driver.findElement(By.id("io.selendroid.testapp:id/inputName")).sendKeys("Sapna Mishra");
	System.out.println("User enters name");
	driver.findElement(By.xpath("//android.widget.CheckedTextView[@id = 'android:id/text1']")).click();;
			driver.findElement(By.id("android:id/text1")).click();	    
	Select s =new Select(driver.findElement(By.xpath("//android.widget.CheckedTextView[@id = 'android:id/text1']")));
	s.selectByVisibleText("Java");
	System.out.println("User selects 'Java from dropdown");
	/*
	 driver.findElement(By.id("io.selendroid.testapp:id/input_adds"));
	if ( !driver.findElement(By.id("selectCheckBox")).isSelected() )
    {
         driver.findElement(By.id("selectCheckBox")).click();
    }
    */
	driver.findElement(By.id("io.selendroid.testapp:id/btnRegisterUser")).click();
	System.out.println("User click on register button");
	
	
}
	
}


