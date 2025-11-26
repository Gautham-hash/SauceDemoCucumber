package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;

public class LoginTest {

    WebDriver driver = Hooks.driver;

    @Given("I am on the SauceDemo login page")
    public void openLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    // Parameterization for username/password
    @When("I enter username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("I click login")
    public void clickLogin() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should land on the products page")
    public void verifyProductsPage() {
        boolean displayed = driver.findElement(By.className("title")).isDisplayed();
        System.out.println("Login Success: " + displayed);
    }

    // DataTable example
    @When("I enter the following users")
    public void enterUsers(DataTable table) {
        table.asMaps().forEach(row -> {
            driver.findElement(By.id("user-name")).sendKeys(row.get("username"));
            driver.findElement(By.id("password")).sendKeys(row.get("password"));
            driver.findElement(By.id("login-button")).click();
            System.out.println("Login attempted for: " + row.get("username"));
            driver.navigate().back(); // go back to login page for next data
        });
    }
}