package com.epam.lab;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleSearchTest {
	private final String url = "https://www.google.com.ua/";
	private WebDriver chromeDriver;

	@BeforeClass
	public void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		chromeDriver = new ChromeDriver();
	}

	@Test
	public void testSearchApple() {
		chromeDriver.get(url);
		WebElement element = chromeDriver.findElement(By.name("q"));
		element.sendKeys("Apple");
		element.submit();
		(new WebDriverWait(chromeDriver, 100)).until((dr) -> dr.getTitle().toLowerCase().startsWith("apple"));
		String pageTitle = chromeDriver.getTitle();
		assertTrue(pageTitle.contains("Apple"));
	}

	@AfterClass
	public void driverQuit() {
		chromeDriver.quit();
	}
}
