package com.myelth.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myelth.PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProviderPageTest {

	private static WebDriver driver;
	private JavascriptExecutor js;
	private PageObjects objects;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		objects = new PageObjects(driver);
		driver.get("https://myelth.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}

	@Test(priority = 1)
	public void providerTitleTest() {
		objects.provider().click();
		String providerTitle = driver.getTitle();
		System.out.println(providerTitle);
		Assert.assertEquals(providerTitle, "Provider | myelth");
	}

	@Test(priority = 2)
	public void contactUsButtonDisplayTest() {
		boolean isContactUsDisplayed = driver.findElement(By.xpath("//a[@href='/contact-us/']")).isDisplayed();
		Assert.assertTrue(isContactUsDisplayed, "Contact Us button not displayed");
	}

	@Test(priority = 3)
	public void contactUsButtonFunctionalityTest() {
		WebElement contactUs_Element = driver.findElement(By.xpath("//a[@href='/contact-us/']"));
//			Thread.sleep(2000);
		contactUs_Element.click();
		String contact_us_title = driver.getTitle();
		System.out.println(contact_us_title);
		Assert.assertEquals(contact_us_title, "Contact Us | myelth");
	}

	@AfterMethod
	public void closeAndQuit() {
		driver.close();
		driver.quit();
	}

}
