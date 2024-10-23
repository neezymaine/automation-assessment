package TestCases;


import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import BaseTest.BaseTest;

public class View_plan extends BaseTest {

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
		WebElement viewplan = wait4.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("VP"))));
		viewplan.click();
		
		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement pop = wait4.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("popbtn"))));
		pop.click();
		
}
	
}