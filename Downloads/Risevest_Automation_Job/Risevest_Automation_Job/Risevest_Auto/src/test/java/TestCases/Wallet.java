package TestCases;


import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import BaseTest.BaseTest;

public class Wallet extends BaseTest {

	@Test(priority = 1)

	// access wallet and view wallet balance
	public void wallet_balance_visible() {

		driver.manage().window().maximize();

		driver.findElement(By.id(loc.getProperty("emailField"))).sendKeys("jibril4bi@gmail.com");
		driver.findElement(By.id(loc.getProperty("passwordField"))).sendKeys("Eurydice007$$");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement submitButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("submitButton"))));
		submitButton.click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(40));

		WebElement walletLink = wait1.until(ExpectedConditions
				.elementToBeClickable(By.xpath(loc.getProperty("walletlink"))));	
		walletLink.click();

	}
	

	@Test(priority = 2)

	// access wallet and hide wallet balance
	public void wallet_hide_balance() {

		driver.manage().window().maximize();

		driver.findElement(By.id(loc.getProperty("emailField"))).sendKeys("jibril4bi@gmail.com");
		driver.findElement(By.id(loc.getProperty("passwordField"))).sendKeys("Eurydice007$$");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement submitButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath(loc.getProperty("submitButton"))));
		submitButton.click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(40));

		WebElement walletLink = wait1.until(ExpectedConditions
				.elementToBeClickable(By.xpath(loc.getProperty("walletlink"))));	
		walletLink.click();
		
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(40));
        WebElement visibilityToggleIcon = wait2.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector(".text-primary > .MuiSvgIcon-root > path")
        ));
        visibilityToggleIcon.click();
	}
}