package com.myelth.tests;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

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

public class PrivacyPolicyPageTest {
	
	private static WebDriver driver;
	private JavascriptExecutor js;
	private PageObjects objects;
		
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
	    objects = new PageObjects(driver);
		driver.get("https://myelth.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}
	
	@Test(priority = 1)
	public void privacyPolicyTitleTest() {
		objects.privacyPolicy().click();
		String privacyPolicyTitle = driver.getTitle();
		System.out.println(privacyPolicyTitle);
		Assert.assertEquals(privacyPolicyTitle, "Privacy Policy | myelth");
	}	
	
	@Test(priority = 2)
	public void termsOfServicePageTitleTest() {
		objects.privacyPolicy().click();
        WebElement element=
        driver.findElement(By.xpath("//a[@class='auto-generated-link' and @href='https://myelth.com/terms-of-service.']"));
        element.click();
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Terms of Service | myelth", "404 Not Found");
	}
	
	@Test(priority = 3)
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
