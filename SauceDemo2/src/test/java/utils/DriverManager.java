package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
	
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		if(driver==null) {
			
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--stat--maximized");
		driver=new ChromeDriver(options);
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
		return driver;
}
	public static void quitDriver() {
		if(driver!=null) {
			try {
				driver.quit();
			}catch(Exception ignored) {
				
			}
			driver=null;
			
		}
	}
	
}
