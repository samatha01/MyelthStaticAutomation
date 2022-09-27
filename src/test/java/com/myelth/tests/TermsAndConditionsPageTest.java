package com.myelth.tests;

import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
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

public class TermsAndConditionsPageTest {
	
	private static WebDriver driver;
	private JavascriptExecutor js;
	private PageObjects objects;
			
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		objects = new PageObjects(driver);
		driver.get("https://myelth.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		objects.termsAndConditions().click();
			}
						
	@Test
	public void termsAndConditionsTitleTest() {
		String termsAndConditionsTitle = driver.getTitle();
		System.out.println(termsAndConditionsTitle);
		Assert.assertEquals(termsAndConditionsTitle, "Terms & Conditions | myelth");
	}
	
	@Test
	public void imageTest() {
		WebElement image = driver.findElement(By.xpath("//img[@class='wp-image-174 alignnone size-full lazyloaded']"));
		boolean isImageDisplayed = false;
		try {

			if (image != null) {
				HttpClient client = HttpClientBuilder.create().build();
				HttpGet request = new HttpGet(image.getAttribute("src"));;
				try {
					HttpResponse response = client.execute(request);
					if (response.getStatusLine().getStatusCode() != 200) {
						isImageDisplayed = false;
					} else {
						isImageDisplayed = true;
					}
				} catch (UnknownHostException uhex) {
					isImageDisplayed = false;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			Assert.assertTrue(isImageDisplayed, "Image is not displayed");
		}

	}
	
	@Test
	public void copyRightTest() {
		String copyRightText = driver.findElement(By.xpath("//div[@id='footer-info']")).getText();
		System.out.println(driver.findElement(By.xpath("//div[@id='footer-info']")).getText());
		String year = new SimpleDateFormat("yyyy").format(new Date());
		System.out.println(year);
		Assert.assertEquals(copyRightText, "© Copyright " + year + " | MyElth");
	}
				
	@AfterMethod
	public void closeAndQuit() {
		driver.close();
		driver.quit();
	}
}
