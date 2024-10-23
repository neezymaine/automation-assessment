package TestCases;

import java.io.File;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
		

		SoftAssert softassert1 = new SoftAssert();
		String actual_error1 = driver.findElement(By.xpath(loc.getProperty("emptyEmail"))).getText();
		String expected_error1 = "Enter your email address";
		softassert1.assertEquals(actual_error1, expected_error1);
		softassert1.assertAll();


		SoftAssert softassert = new SoftAssert();
		String actual_error = driver.findElement(By.xpath(loc.getProperty("emptyPassword"))).getText();
		String expected_error = "Enter your password";
		softassert.assertEquals(actual_error, expected_error);
		softassert.assertAll();

	}

}