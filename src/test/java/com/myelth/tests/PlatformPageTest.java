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

public class PlatformPageTest {

	private static WebDriver driver;
	private PageObjects objects;
	private JavascriptExecutor js;

	@BeforeMethod
	public void setup() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		objects = new PageObjects(driver);
		driver.get("https://myelth.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}

	@Test(priority = 1)
	public void platformPageTitle() {
		objects.platform().click();
		String platformTitle = driver.getTitle();
		System.out.println(platformTitle);
		Assert.assertEquals(platformTitle, "Platform | myelth");
	}

	@Test(priority = 2)
	public void platformVideoTest() {
		boolean isVideoDisplayed = driver.findElement(By.xpath("//div[@class='et_pb_row et_pb_row_4']")).isDisplayed();
		System.out.println(driver.findElement(By.xpath("//div[@class='et_pb_row et_pb_row_4']")).getText());
		Assert.assertTrue(isVideoDisplayed, "Video is not loaded on the Platform page.");
	}

	@Test(priority = 3)
	public void platformVideoFunctionalityTest() throws InterruptedException {
		js.executeScript("document.getElementsByTagName('video')[0].play()");
		Thread.sleep(6000);
		js.executeScript("document.getElementsByTagName('video')[0].pause()");
	}

	@Test(priority = 4)
	public void contactUsButtonDisplayTest() {
		boolean isContactUsDisplayed = driver.findElement(By.xpath("//a[@href='/contact-us/']")).isDisplayed();
		Assert.assertTrue(isContactUsDisplayed, "Contact Us button not displayed");
	}

	@Test(dependsOnMethods="contactUsButtonDisplayTest")
	public void contactUsButtonFunctionalityTest() {
		WebElement contactUs_Element = driver.findElement(By.xpath("//a[@href='/contact-us/']"));
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
