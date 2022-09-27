package com.myelth.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import com.myelth.PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AboutUsPageTest {

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
		objects.aboutUs().click();
	}

	@Test(priority = 1)
	public void aboutUsTitleTest() {
		String aboutUsTitle = driver.getTitle();
		System.out.println(aboutUsTitle);
		Assert.assertEquals(aboutUsTitle, "About Us | myelth");
		// objects.home().click();
	}

	@Test(priority = 2)
	public void individualProfileTest() {
		String name = null;
		for (int i = 6; i <= 15; i++) {
			String profileXpath1 = "//div[@class='et_pb_column et_pb_column_1_4 et_pb_column_" + i
					+ "  et_pb_css_mix_blend_mode_passthrough']";
			if (i == 9) {
				name = driver.findElement(By.xpath(
						"//div[@class='et_pb_column et_pb_column_1_4 et_pb_column_9  et_pb_css_mix_blend_mode_passthrough et-last-child']//h5[@class='et_pb_module_header']/span"))
						.getText();
				driver.findElement(By.xpath(
						"//div[@class='et_pb_column et_pb_column_1_4 et_pb_column_9  et_pb_css_mix_blend_mode_passthrough et-last-child']//h5[@class='et_pb_module_header']/span"))
						.click();
			} else if (i < 9) {
				name = driver.findElement(By.xpath(profileXpath1 + "//h5[@class='et_pb_module_header']/span"))
						.getText();
				driver.findElement(By.xpath(profileXpath1)).click();
			} else if (i != 14 && (i >= 11 && i <= 15)) {
				name = driver.findElement(By.xpath(profileXpath1 + "/div/div/div[2]//a")).getText();
				driver.findElement(By.xpath(profileXpath1 + "/div/div/div[2]//a")).click();
				if (i == 12) {
					System.out.println(name);
					String title = driver.getTitle();
					Assert.assertEquals(title, name + ", MD | myelth");
					driver.navigate().back();
					continue;
				}
			} else if (i == 14) {
				name = driver.findElement(By.xpath(
						"//div[@class='et_pb_column et_pb_column_1_4 et_pb_column_14  et_pb_css_mix_blend_mode_passthrough et-last-child']/div/div/div[2]//a"))
						.getText();
				driver.findElement(By.xpath(
						"//div[@class='et_pb_column et_pb_column_1_4 et_pb_column_14  et_pb_css_mix_blend_mode_passthrough et-last-child']/div/div/div[2]//a"))
						.click();
				System.out.println(name);
				String title = driver.getTitle();
				Assert.assertEquals(title, name + ", MD | myelth");
				driver.navigate().back();
				continue;
			} else if (i == 10) {
				continue;
			} else if (i == 15) {
				continue;
			}
			System.out.println(name);
			String title = driver.getTitle();
			Assert.assertEquals(title, name + " | myelth");
			driver.navigate().back();
		}
	}

	@AfterMethod
	public void closeAndQuit() {
		driver.close();
		driver.quit();
	}

}
