package TestCases;


import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import BaseTest.BaseTest;

public class LoginTest extends BaseTest {

	@Test(priority = 1)

	// to validate successful login with valid credentials
	public void login_successful() {

		driver.manage().window().maximize();

		driver.findElement(By.id(loc.getProperty("emailField"))).sendKeys("jibril4bi@gmail.com");
		driver.findElement(By.id(loc.getProperty("passwordField"))).sendKeys("Eurydice007$$");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement submitButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("submitButton"))));
		submitButton.click();

	}

	@Test(priority = 2)

	// to validate login with invalid credentials,empty email
	public void login_emptyEmail() {

		driver.manage().window().maximize();

		driver.findElement(By.id(loc.getProperty("emailField"))).sendKeys("");
		driver.findElement(By.id(loc.getProperty("passwordField"))).sendKeys("Eurydice007$$");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement submitButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("submitButton"))));
		submitButton.click();


		//soft assert in this test is for validation when making a negative checks during the automation, softassert ,i nstead of Assert, is used in case the test fails so it plows ahead. 
		SoftAssert softassert = new SoftAssert();
		String actual_error = driver.findElement(By.xpath(loc.getProperty("emptyEmail"))).getText();
		String expected_error = "Enter your email address";
		softassert.assertEquals(actual_error, expected_error);
		softassert.assertAll();

	}

	@Test(priority = 3)

	// to validate login with invalid credentials, empty password
	public void login_emptyPassword() {

		driver.manage().window().maximize();

		driver.findElement(By.id(loc.getProperty("emailField"))).sendKeys("jibril4bi@gmail.com");
		driver.findElement(By.id(loc.getProperty("passwordField"))).sendKeys("");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement submitButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("submitButton"))));
		submitButton.click();

		//soft assert in this test is for validation when making a negative checks during the automation, softassert ,i nstead of Assert, is used in case the test fails so it plows ahead. 
		SoftAssert softassert = new SoftAssert();
		String actual_error = driver.findElement(By.xpath(loc.getProperty("emptyPassword"))).getText();
		String expected_error = "Enter your password";
		softassert.assertEquals(actual_error, expected_error);
		softassert.assertAll();

	}

	@Test(priority = 4)

	// to validate login with invalid credentials, empty password and empty password
	public void login_emptyPassword_emptyEmail() {

		driver.manage().window().maximize();

		driver.findElement(By.id(loc.getProperty("emailField"))).sendKeys("");
		driver.findElement(By.id(loc.getProperty("passwordField"))).sendKeys("");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement submitButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("submitButton"))));
		submitButton.click();
		//soft assert in this test is for validation when making a negative checks during the automation, softassert ,i nstead of Assert, is used in case the test fails so it plows ahead. 

		SoftAssert softassert1 = new SoftAssert();
		String actual_error1 = driver.findElement(By.xpath(loc.getProperty("emptyEmail"))).getText();
		String expected_error1 = "Enter your email address";
		softassert1.assertEquals(actual_error1, expected_error1);
		softassert1.assertAll();

//double assertion is used because there were two errror messages when this check was made
		SoftAssert softassert = new SoftAssert();
		String actual_error = driver.findElement(By.xpath(loc.getProperty("emptyPassword"))).getText();
		String expected_error = "Enter your password";
		softassert.assertEquals(actual_error, expected_error);
		softassert.assertAll();

	}

}