package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverManager;

public class LoginStep {
	private final WebDriver driver=DriverManager.getDriver();
	private final WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	@Given("saucedemi site is opened")
	public void saucedemi_site_is_opened() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
	}

	@When("I login with {string} and {string}")
	public void i_login_with_and(String uname, String pass) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
		driver.findElement(By.id("user-name")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("login-button")).click();
	}

	@Then("the login should be {string}")
	public void the_login_should_be(String result) {
		if("success".contentEquals(result)) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inventory_item")));
			Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
		
		}
		else {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3[data-test='error']")));
		Assert.assertTrue(driver.findElement(By.cssSelector("h3[data-test='error']")).isDisplayed());

    }
		}
		


}

