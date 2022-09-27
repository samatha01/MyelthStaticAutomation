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

public class NewsPageTest {

	// div[@class='notfound']
	private static WebDriver driver;
	private static JavascriptExecutor js;
	private static PageObjects objects;

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
	public void newsTitleTest() {
		objects.news().click();
		String newsTitle = driver.getTitle();
		System.out.println(newsTitle);
		Assert.assertEquals(newsTitle, "News | myelth");
	}

	@Test(priority = 2)
	public void healthCareTechLinkTest() {
		objects.news().click();
		WebElement healthCareElement = driver.findElement(By.xpath(
				"//a[@href='https://communications.healthcaretechoutlook.com/vendors/top-healthcare-communication-solution-companies.html']"));
		String healthCareElementTitle = healthCareElement.getText();
		System.out.println(healthCareElementTitle);
		Assert.assertEquals(healthCareElementTitle, "Healthcare Tech Outlook");
		healthCareElement.click();
		System.out.println(driver.getTitle());
		driver.navigate().back();
	}

	@Test(priority = 3)
	public void howTheCompanyWasFoundedLink() {
		objects.news().click();
		WebElement hereElement = driver.findElement(By.xpath(
				"//a[@href='https://communications.healthcaretechoutlook.com/vendor/myelth-delivering-complete-control-to-the-consumer-cid-1818-mid-163.html'][.='here']"));
		String hereElementTitle = hereElement.getText();
		System.out.println(hereElementTitle);
		// Website is not currently available in your region or country
		hereElement.click();
		System.out.println(driver.getTitle());
		Assert.assertEquals(hereElementTitle, "How Myelth company was founded",
				"Website is not currently available in your region or country");
		driver.navigate().back();
	}

	@Test(priority = 4)
	public void healthCareSolutionProviderLogoLinkTest() {
		objects.news().click();
		WebElement img = driver.findElement(By.xpath(
				"//img[@src='https://secureservercdn.net/198.71.189.51/bnw.5eb.myftpupload.com/wp-content/uploads/2022/06/myElth-HC_Tech-Award_PNG.webp']"));
		img.click();
		String imgTitle = driver.getTitle();
		System.out.println(imgTitle);
		Assert.assertEquals(imgTitle, "Myelth Top Healthcare Communicatins Solution Providers",
				"Website is not currently available in your region or country");
		driver.navigate().back();
	}

//	@Test(priority = 5)
//	public void contactUsButtonDisplayTest() {
//		boolean isContactUsDisplayed = driver.findElement(By.xpath("//a[@href='/contact-us/']")).isDisplayed();
//		Assert.assertTrue(isContactUsDisplayed, "Contact Us button not displayed");
//	}
//
//	@Test(dependsOnMethods = "contactUsButtonDisplayTest")
//	public void contactUsButtonTest() {
//		WebElement contactUs_Element = driver.findElement(By.xpath("//a[@href='/contact-us/']"));
//    		Thread.sleep(2000);
//		contactUs_Element.click();
//		String contact_us_title = driver.getTitle();
//		System.out.println(contact_us_title);
//		Assert.assertEquals(contact_us_title, "Contact Us | myelth");
//	}

	@AfterMethod
	public void closeAndQuit() {
		driver.close();
		driver.quit();
	}

}
