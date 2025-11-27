package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverManager;

public class Hooks {
	@Before
	public void start() {
		WebDriver driver=DriverManager.getDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.saucedemo.com/");
	}
	@After
	public void tearDown() {
		DriverManager.quitDriver();
	}
}

	
