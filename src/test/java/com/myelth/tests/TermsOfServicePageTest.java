package com.myelth.tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.myelth.PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TermsOfServicePageTest {

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
		objects.privacyPolicy().click();
		WebElement element = driver.findElement(
				By.xpath("//a[@class='auto-generated-link' and @href='https://myelth.com/terms-of-service.']"));
		element.click();
		ArrayList<String> newTab1 = new ArrayList<String>(driver.getWindowHandles());
		for (String tab : newTab1) {
			System.out.println("tab: " + tab);
		}
		driver.switchTo().window(newTab1.get(1));
	}

	@Test(priority = 1)
	public void termsOfServicePageTitleTest() {
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Terms of Service | myelth", "404 Not Found");
	}

	@Test(priority = 2)
	public void searchFunctionalityTest() {
		driver.findElement(By.xpath("//form[@id='searchform']//input[@type='text']")).sendKeys("Hari Makkala");
		driver.findElement(By.xpath("//form[@id='searchform']//input[@type='submit']")).click();
		String searchResult = driver.findElement(By.xpath("//div[@id='left-area']/article/h2/a[.='Hari Makkala']")).getText();
		Assert.assertEquals(searchResult, "Hari Makkala");
	}
	
//	@Test
//	public void recentPostsTest() throws InterruptedException {
//		List<WebElement> lists = driver.findElements(By.xpath("//div[@id='recent-posts-2']/ul/li/a"));
//		Iterator ite = lists.iterator();
//		WebElement link;
//		String linkText;
//		while(ite.hasNext()) {
//			link = (WebElement) ite.next();
//			System.out.println(link);
//		    Thread.sleep(5000);
//			linkText = link.getText();
//			System.out.println(linkText);
//			link.click();
//			String title = driver.getTitle();
//			Assert.assertEquals(title, linkText+" | myelth");
//			driver.navigate().back();
//		}
	
	@Test
	public void threeReasonstoVideoCallYourDoctorTest() {
		driver.findElement(By.xpath("//a[.='3 Reasons to Video Call your Doctor']")).click();
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "3 Reasons to Video Call your Doctor | myelth");
	}
	
	@Test
	public void myElthLaunchesHealthcareCollaborationPlatformTest() {
		driver.findElement(By.xpath("//a[.='myElth launches Healthcare Collaboration Platform']")).click();
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "myElth launches Healthcare Collaboration Platform | myelth");
	}
	
	@Test
	public void twentyYearsOfPriceChangesInTheUnitedStatesTest() {
		driver.findElement(By.xpath("//a[.='20 Years of Price Changes in The United States']")).click();
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "20 Years of Price Changes in The United States | myelth");
	}
	@AfterMethod
	public void closeAndQuit() {
		driver.close();
		driver.quit();
	}

}
