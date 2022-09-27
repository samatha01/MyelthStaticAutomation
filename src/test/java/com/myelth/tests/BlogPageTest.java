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

public class BlogPageTest {

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
		objects.blog().click();
	}

	@Test
	public void blogTitleTest() throws InterruptedException {
		String blogTitle = driver.getTitle();
		System.out.println(blogTitle);
		Assert.assertEquals(blogTitle, "Blog | myelth");
	}

	@Test
	public void readMoreBtnTest1() {// ReadMore1
		WebElement btnReadMore1 = driver.findElement(
				By.xpath("//a[@href='https://myelth.com/3-reasons-to-video-call-your-doctor/'][.='read more']"));
		btnReadMore1.click();
		String btnReadMore1Title = driver.getTitle();
		System.out.println(btnReadMore1Title);
		Assert.assertEquals(btnReadMore1Title, "3 Reasons to Video Call your Doctor | myelth");
		WebElement navPreviousElement = driver.findElement(By.xpath(
				"//span[@class='nav-previous']/a[@href='https://myelth.com/myelth-launches-healthcare-collaboration-platform/']"));
		navPreviousElement.click();
		String navPreviousElementTitle = driver.getTitle();
		System.out.println(navPreviousElementTitle);
		Assert.assertEquals(navPreviousElementTitle, "myElth launches Healthcare Collaboration Platform | myelth");
		driver.navigate().back();
		driver.navigate().back();
	}

	@Test
	public void readMoreBtnTest2() {
		WebElement btnReadMore2 = driver.findElement(By.xpath(
				"//a[@href='https://myelth.com/myelth-launches-healthcare-collaboration-platform/'][.='read more']"));
		btnReadMore2.click();
		String btnReadMore2Title = driver.getTitle();
		System.out.println(btnReadMore2Title);
		Assert.assertEquals(btnReadMore2Title, "myElth launches Healthcare Collaboration Platform | myelth");
		driver.navigate().back();
	}

	@Test
	public void readMoreBtnTest3() {
		WebElement btnReadMore3 = driver.findElement(By.xpath(
				"//a[@href='https://myelth.com/20-years-of-price-changes-in-the-united-states/'][.='read more']"));
		btnReadMore3.click();
		String btnReadMore3Title = driver.getTitle();
		System.out.println(btnReadMore3Title);
		Assert.assertEquals(btnReadMore3Title, "20 Years of Price Changes in The United States | myelth");
		WebElement searchElement = driver.findElement(By.xpath("//input[@type='text' and @id='s']"));
		searchElement.sendKeys("MyElth");
		WebElement searchSubmit = driver.findElement(By.xpath("//input[@type='submit' and @id='searchsubmit']"));
		searchSubmit.submit();
		WebElement platformElement = driver.findElement(By.xpath("//h2//a[.='Platform']"));
		platformElement.click();
		String platformElementTitle = driver.getTitle();
		System.out.println(platformElementTitle);
		Assert.assertEquals(platformElementTitle, "Platform | myelth");
		driver.navigate().back();
	}

	@AfterMethod
	public void closeAndQuit() {
		driver.close();
		driver.quit();
	}
}
