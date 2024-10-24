package TestCases;



import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import BaseTest.BaseTest;

public class Create_Plan extends BaseTest {

	@Test(priority = 1)

	// to validate successful plan creation
	public void create_plan() {

		driver.manage().window().maximize();

		driver.findElement(By.id(loc.getProperty("emailField"))).sendKeys("jibril4bi@gmail.com");
		driver.findElement(By.id(loc.getProperty("passwordField"))).sendKeys("Eurydice007$$");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement submitButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("submitButton"))));
		submitButton.click();

		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement plan = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("plan"))));
		plan.click();

		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement newplan = wait4.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("newplan"))));
		newplan.click();

		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement element1 = wait5
				.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("GS_button"))));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		element1.click();

		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement cb = wait6.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("cont_buttn"))));
		cb.click();

		driver.findElement(By.id(loc.getProperty("plan_box"))).sendKeys("Dollar Investment");

		WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement element3 = wait7
				.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("submit_bttn"))));
		element3.click();

	}

	@Test(priority = 2)

	// to validate creation of plan with empty plan name
	public void create_plan_empty_planName() {

		driver.manage().window().maximize();

		driver.findElement(By.id(loc.getProperty("emailField"))).sendKeys("jibril4bi@gmail.com");
		driver.findElement(By.id(loc.getProperty("passwordField"))).sendKeys("Eurydice007$$");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement submitButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("submitButton"))));
		submitButton.click();

		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement plan = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("plan"))));
		plan.click();

		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement newplan = wait4.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("newplan"))));
		newplan.click();

		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement element1 = wait5
				.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("GS_button"))));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		element1.click();

		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement cb = wait6.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("cont_buttn"))));
		cb.click();

		driver.findElement(By.id(loc.getProperty("plan_box"))).sendKeys("");

		WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement element3 = wait7
				.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("submit_bttn"))));
		element3.click();
//soft assert in this test is for validation when making a negative checks during the automation, softassert ,i nstead of Assert, is used in case the test fails so it plows ahead. 
		SoftAssert softassert = new SoftAssert();
		String actual_error = driver.findElement(By.xpath(loc.getProperty("emptyplanerror"))).getText();
		String expected_error = "Enter a plan name to continue";
		softassert.assertEquals(actual_error, expected_error);
		softassert.assertAll();

	}
}