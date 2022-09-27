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

public class ContactUsPageTest {

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
	public void contactUsTitleTest() {
		objects.contactUs().click();
		String contactUsTitle = driver.getTitle();
		System.out.println(contactUsTitle);
		Assert.assertEquals(contactUsTitle, "Contact Us | myelth");
	}

	@Test(priority = 2)
	public void userDetails() throws NumberFormatException, InterruptedException {
		objects.contactUs().click();
		driver.findElement(By.xpath("//input[@type='text' and @id='et_pb_contact_first_0']")).sendKeys("Peter");
		driver.findElement(By.xpath("//input[@type='text' and @id='et_pb_contact_email_0']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//input[@type='text' and @id='et_pb_contact_last_0']")).sendKeys("Hudson");
		driver.findElement(By.xpath("//input[@type='text' and @id='et_pb_contact_phone_0']")).sendKeys("9999899993");
		driver.findElement(By.xpath("//textarea[@name='et_pb_contact_message_0']")).sendKeys("MyElth info");
		Thread.sleep(2000);

		// captcha
		WebElement element = driver.findElement(By.xpath("//span[@class='et_pb_contact_captcha_question']"));
		String str = element.getText();
		String s1 = str.substring(0, 2).trim();
		String s2 = str.substring(4, 6).trim();
		int i1 = Integer.parseInt(s1);
		int i2 = Integer.valueOf(s2);
		System.out.println("No:1 " + i1 + "  No:2 " + i2);
		int i = i1 + i2;
		String ans = String.valueOf(i);
		System.out.println("sum is: " + ans);
		element = driver.findElement(By.xpath("//input[@class='input et_pb_contact_captcha']"));
		element.sendKeys(ans);
		// driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@AfterMethod
	public void closeAndQuit() {
		driver.close();
		driver.quit();
	}

}
