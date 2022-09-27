package com.myelth.tests;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.myelth.PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageTest {

	public static WebDriver driver;
	PageObjects objects;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		objects = new PageObjects(driver);
		driver.get("https://myelth.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}

	@Test(priority = 1)
	public void LogoTest() {
		System.out.println(objects.logo());
		boolean isLogoDisplayed = objects.logo().isDisplayed();
		System.out.println(isLogoDisplayed);
		Assert.assertTrue(isLogoDisplayed, "Error: Logo is not displayed.");

	}

	@Test(priority = 2)
	public void HomeTextTest() {
		String homeText = objects.home().getText();
		System.out.println(homeText);
		Assert.assertEquals(homeText, "Home", "HomeText not found");

	}
	@Test(priority = 3, dependsOnMethods="HomeTextTest")
	public void HomeTest() {
		objects.home().click();
		String text = driver.getTitle();
		System.out.println(text);
		Assert.assertEquals(text, "myelth | healthtech with a consumer focus");

	}
	@Test(priority = 4)
	public void PayersTextTest() {
		String payersText = objects.payer().getText();
		System.out.println(payersText);
		Assert.assertEquals(payersText,"Payers", "PayersText not found");
	}
	@Test(priority = 5, dependsOnMethods="PayersTextTest")
	public void  PayersTest() {
		objects.payer().click();
		String text = driver.getTitle();
		System.out.println(text);
		Assert.assertEquals(text, "Payers | myelth");

	}

	@Test(priority = 6)
	public void blogTextTest() {
		String blogText = objects.blog().getText();
		System.out.println(blogText);
		Assert.assertEquals(blogText, "Blog", "BlogText not found");
	}
	@Test(priority = 7, dependsOnMethods="blogTextTest")
	public void  BlogTest() {
		objects.blog().click();
		String text = driver.getTitle();
		System.out.println(text);
		Assert.assertEquals(text, "Blog | myelth");
	}
	

	@Test(priority = 8)
	public void NewsTextTest() {
		String newsText = objects.news().getText();
		System.out.println(newsText);
		Assert.assertEquals(newsText, "News", "NewsText not found");
	}
	@Test(priority = 9, dependsOnMethods="NewsTextTest")
	public void  NewsTest() {
		objects.news().click();
		String text = driver.getTitle();
		System.out.println(text);
		Assert.assertEquals(text, "News | myelth");
	}

	@Test(priority = 10)
	public void PlatformTextTest() {
		String platformText = objects.platform().getText();
		System.out.println(platformText);
		Assert.assertEquals(platformText, "Platform", "PlatformText not found");
	}
	@Test(priority = 11, dependsOnMethods="PlatformTextTest")
	public void PlatformTest() {
		objects.platform().click();
		String text = driver.getTitle();
		System.out.println(text);
		Assert.assertEquals(text, "Platform | myelth");
	}

	@Test(priority = 12)
	public void ProviderTextTest() {
		String providerText = objects.provider().getText();
		System.out.println(providerText);
		Assert.assertEquals(providerText, "Provider", "ProviderText not found");
	}
	@Test(priority = 13, dependsOnMethods="ProviderTextTest")
	public void  ProviderTest() {
		objects.provider().click();
		String text = driver.getTitle();
		System.out.println(text);
		Assert.assertEquals(text, "Provider | myelth");
	}
	@Test(priority = 14)
	public void EmployerTextTest() {
		String employerText = objects.employer().getText();
		System.out.println(employerText);
		Assert.assertEquals(employerText, "Employer", "EmployerText not found");
	}
	@Test(priority = 15, dependsOnMethods="EmployerTextTest")
	public void EmployerTest() {
		objects.employer().click();
		String text = driver.getTitle();
		System.out.println(text);
		Assert.assertEquals(text, "Employer | myelth");
	}

	@Test(priority = 16)
	public void footerHomeTextTest() {
		String footerHomeText = objects.footerHome().getText();
		System.out.println(footerHomeText);
		Assert.assertEquals(footerHomeText, "HOME", "Footer Home Text not found");
	}
	@Test(priority = 17, dependsOnMethods="footerHomeTextTest")
	public void footerHomeTest() {
		objects.footerHome().click();
		String text = driver.getTitle();
		System.out.println(text);
		Assert.assertEquals(text, "myelth | healthtech with a consumer focus");
	}

	@Test(priority = 18)
	public void faqsTextTest() {
		String faqsText = objects.faqs().getText();
		System.out.println(faqsText);
		Assert.assertEquals(faqsText, "FAQS", "Faqs Text not found");
	}
	@Test(priority = 19, dependsOnMethods="faqsTextTest")
	public void faqsTest() {
		objects.faqs().click();
		String text = driver.getTitle();
		System.out.println(text);
		Assert.assertEquals(text, "FAQs | myelth");
	}

	@Test(priority = 20)
	public void privacyPolicyTextTest() {
		String privacyPolicyText = objects.privacyPolicy().getText();
		System.out.println(privacyPolicyText);
		Assert.assertEquals(privacyPolicyText, "PRIVACY POLICY", "Privacy Policy Text not found");
	}
	@Test(priority = 21, dependsOnMethods="privacyPolicyTextTest")
	public void privacyPolicyTest() {
		objects.privacyPolicy().click();
		String text = driver.getTitle();
		System.out.println(text);
		Assert.assertEquals(text, "Privacy Policy | myelth");
	}

	@Test(priority = 22)
	public void TermsAndConditionsTextTest() {
		String termsAndConditionsText = objects.termsAndConditions().getText();
		System.out.println(termsAndConditionsText);
		Assert.assertEquals(termsAndConditionsText, "TERMS & CONDITIONS", "Terms And Conditions Text not found");
	}
	@Test(priority = 23, dependsOnMethods="TermsAndConditionsTextTest")
	public void TermsAndConditionsTest() {
		objects.termsAndConditions().click();
		String text = driver.getTitle();
		System.out.println(text);
		Assert.assertEquals(text, "Terms & Conditions | myelth");
	}

	@Test(priority = 24)
	public void contactUsTest() {
		String contactUsText = objects.contactUs().getText();
		System.out.println(contactUsText);
		Assert.assertEquals(contactUsText, "CONTACT US", "Contact Us Text not found");
	}
	@Test(priority = 25, dependsOnMethods="contactUsTest")
	public void contactUsTextTest() {
		objects.contactUs().click();
		String text = driver.getTitle();
		System.out.println(text);
		Assert.assertEquals(text, "Contact Us | myelth");
	}

	@Test(priority = 26)
	public void aboutUsTextTest() {
		String aboutUsText = objects.aboutUs().getText();
		System.out.println(aboutUsText);
		Assert.assertEquals(aboutUsText, "ABOUT US", "About Us Text not found");
	}
	@Test(priority = 27, dependsOnMethods="aboutUsTextTest")
	public void  aboutUsTest() {
		objects.aboutUs().click();
		String text = driver.getTitle();
		System.out.println(text);
		Assert.assertEquals(text, "About Us | myelth");
	}

	@Test(priority = 28)
	public void sliderImageTest() {

		for (int i = 0; i <= 2; i++) {
			String slideControllersXpath = "//div[@data-active-slide='et_pb_slide_" + i + "']";
			System.out.println(slideControllersXpath);
			boolean isSliderDisplayed = isElementPresent(By.xpath(slideControllersXpath));
			if (isSliderDisplayed) {
				Assert.assertTrue(isSliderDisplayed, "Slider is not displayed");
			}

		}
	}

	@Test(priority = 29)
	public void sliderTextTest() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element1 = (WebElement) js
				.executeScript("return document.getElementsByClassName('et_pb_slide_title')[0];");
		WebElement element2 = (WebElement) js
				.executeScript("return document.getElementsByClassName('et_pb_slide_title')[1];");
		WebElement element3 = (WebElement) js
				.executeScript("return document.getElementsByClassName('et_pb_slide_title')[2];");
		boolean isTextPresent = false;
		if (element1.isDisplayed() | element2.isDisplayed() | element3.isDisplayed()) {
			isTextPresent = true;
			System.out.println("Text present");
		} else {
			System.out.println("Text not found");
		}

		Assert.assertTrue(isTextPresent, "Text not found");

	}

	@Test(priority = 30, dependsOnMethods = "videoDisplayTest")
	public void videofunctionalityTest() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByTagName('video')[0].play()");
		Thread.sleep(3000);
		js.executeScript("document.getElementsByTagName('video')[0].pause()");
		System.out.println(objects.videoDisplayed().isEnabled());
	}

	@Test(priority = 31)
	public void videoDisplayTest() {

		boolean isVideoDisplayed = driver.findElement(By.xpath("//video")).isDisplayed();
		System.out.println(driver.findElement(By.xpath("//video")).getText());
		Assert.assertTrue(isVideoDisplayed, "Video is not loaded on the home page.");
	}

	@Test(priority = 32)
	public void sideNavDotsTest() throws InterruptedException {
		SoftAssert softAssert=new SoftAssert();
		for (int i = 0; i <= 8; i++) {
			driver.findElement(By.xpath("//a[@id='side_nav_item_id_" + i + "']"));
			if (i == 0) {
				boolean isLogoDisplayed = driver.findElement(By.xpath("//img[@id='logo']")).isDisplayed();
				Assert.assertTrue(isLogoDisplayed, "Side Navigation Dot 1 is not working");
			} else if (i == 1) {
				boolean isimgDisplayed = driver.findElement(By.xpath("//div[@id='mainSlider']")).isDisplayed();
				Assert.assertTrue(isimgDisplayed, "Side Navigation Dot 2 is not working");
			} else if (i == 2) {
				String howDoesItWorkText= driver.findElement(By.xpath("//div[@class='et_pb_row et_pb_row_1']//span/span"))
						.getText();
				Assert.assertEquals(howDoesItWorkText, "How Does It Work?");
			} else if (i == 3) {
				String whyUsText= driver.findElement(By.xpath("//div[@id='whyus']/div//span/span")).getText();
				Assert.assertEquals(whyUsText, "Why Us?");
			} else if (i == 4) {
				String featuresText = driver.findElement(By.xpath("//div[@class='et_pb_row et_pb_row_6']/div//span/span"))
						.getText();
				Assert.assertEquals(featuresText, "Features");
			} else if (i == 5) {
				String certificatesText = driver.findElement(By.xpath("//div[@class='et_pb_row et_pb_row_13']/div//span/span"))
						.getText();
				Assert.assertEquals(certificatesText, "Certificates");
			} else if (i == 6) {
			
			WebElement element=driver.findElement(By.cssSelector("div.download-content h2 span"));
	         // String	text=	e.getText();
		    String	downloadText=element.getAttribute("innerText");
			System.out.println(downloadText);
			Assert.assertEquals(downloadText, "Download the myElth app by clicking below:");
			 
			} else if (i == 7) {
				boolean text = driver.findElement(By.xpath("//div[@id='TestimonialsSlider']")).isDisplayed();
				//js.executeScript("window.scrollBy(0,500)");
				softAssert.assertTrue(text, "Reviews are not displayed");
				//WebElement img = driver.findElement(By.xpath("//img[@src='/wp-content/uploads/2019/02/appstore-icon.png']"));
			//	boolean isImageDisplayed = img.isDisplayed();
				//System.out.println(img.getAttribute("src"));
			//	Assert.assertTrue(isImageDisplayed, "image not displayed");

			} else if (i == 8) {
				String PromoText = driver.findElement(By.xpath("//div[@class='et_pb_promo_description']/h2"))
						.getText();
				System.out.println(PromoText);
				Assert.assertEquals(PromoText, "myelth empowers and engages consumers by providing easy access to information and deeper insights on cost of care, personal health records and coverage information.");
			}
		}

	}
	
	@Test
	public void sideNavBtn7Test() {
		boolean text = driver.findElement(By.xpath("//div[@id='TestimonialsSlider']")).isDisplayed();
		Assert.assertTrue(text, "Reviews are not displayed");
	}

	@Test(priority = 33)
	public void searchForCare_readMoreBtnDiplayTest() {
		WebElement element = driver.findElement(By.xpath("//a[@href='/search-for-care/']"));
		boolean isDisplayed = element.isDisplayed();
		Assert.assertTrue(isDisplayed, "not displayed");

	}

	@Test(priority = 34, dependsOnMethods = "searchForCare_readMoreBtnDiplayTest")
	public void searchForCare_readMoreBtnTest() {
		WebElement element = driver.findElement(By.xpath("//a[@href='/search-for-care/']"));
		element.click();
		String text = driver.getTitle();
		System.out.println(text);
		Assert.assertEquals(text, "Search for Care | myelth");
	}

	@Test(priority = 35)
	public void accessToRealtimeCoverage_readMoreBtnDisplayTest() {
		WebElement element = driver.findElement(By.xpath("//a[@href='/access-to-real-time-coverage/']"));
		boolean isDisplayed = element.isDisplayed();
		Assert.assertTrue(isDisplayed, "not displayed");
	}

	@Test(priority = 36, dependsOnMethods = "accessToRealtimeCoverage_readMoreBtnDisplayTest")
	public void accessToRealtimeCoverage_readMoreBtnTest() {
		WebElement element = driver.findElement(By.xpath("//a[@href='/access-to-real-time-coverage/']"));
		element.click();
		String text = driver.getTitle();
		System.out.println(text);
		Assert.assertEquals(text, "Access to real-time Coverage | myelth");
	}

	@Test(priority = 37)
	public void aggregateElectronicHealthRecords_readMoreBtnDisplayTest() {
		WebElement element = driver.findElement(By.xpath("//a[@href='/aggregate-electronic-health-records']"));
		boolean isDisplayed = element.isDisplayed();
		Assert.assertTrue(isDisplayed, "not displayed");
	}

	@Test(priority = 38, dependsOnMethods = "aggregateElectronicHealthRecords_readMoreBtnDisplayTest")
	public void aggregateElectronicHealthRecords_readMoreBtnTest() {
		WebElement element = driver.findElement(By.xpath("//a[@href='/aggregate-electronic-health-records']"));
		element.click();
		String text = driver.getTitle();
		System.out.println(text);
		Assert.assertEquals(text, "Aggregate Electronic Health Records | myelth");
	}

	@Test(priority = 39)
	public void earnRewardsAndIncentives_readMoreBtnDisplayTest() {
		WebElement element = driver.findElement(By.xpath("//a[@href='/earn-rewards-and-incentives/']"));
		boolean isDisplayed = element.isDisplayed();
		Assert.assertTrue(isDisplayed, "not displayed");
	}

	@Test(priority = 40, dependsOnMethods = "earnRewardsAndIncentives_readMoreBtnDisplayTest")
	public void earnRewardsAndIncentives_readMoreBtnTest() {
		WebElement element = driver.findElement(By.xpath("//a[@href='/earn-rewards-and-incentives/']"));
		element.click();
		String text = driver.getTitle();
		System.out.println(text);
		Assert.assertEquals(text, "Earn Rewards and Incentives | myelth");
	}

	@Test(priority = 41)
	public void shareHealthInformation_readMoreBtnDisplayTest() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//a[@href='/share-health-information/']"));
		boolean isDisplayed = element.isDisplayed();
		Assert.assertTrue(isDisplayed, "not displayed");
	}

	@Test(priority =42, dependsOnMethods = "shareHealthInformation_readMoreBtnDisplayTest")
	public void shareHealthInformation_readMoreBtnTest() {
		WebElement element = driver.findElement(By.xpath("//a[@href='/share-health-information/']"));
		element.click();
		String text = driver.getTitle();
		System.out.println(text);
		Assert.assertEquals(text, "Share Health Information | myelth");
	}

	@Test(priority = 43)
	public void manageEntireFamilysHealth_readMoreBtnDisplayTest() {
		WebElement element = driver.findElement(By.xpath("//a[@href='/manage-entire-familys-health/']"));
		boolean isDisplayed = element.isDisplayed();
		Assert.assertTrue(isDisplayed, "not displayed");
	}

	@Test(priority = 44, dependsOnMethods = "manageEntireFamilysHealth_readMoreBtnDisplayTest")
	public void manageEntireFamilysHealth_readMoreBtnTest() {
		WebElement element = driver.findElement(By.xpath("//a[@href='/manage-entire-familys-health/']"));
		element.click();
		String text = driver.getTitle();
		System.out.println(text);
		Assert.assertEquals(text, "Manage entire family’s health | myelth");
	}

	@Test(priority = 45)
	public void certificationsImageDisplayTest() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='side_nav_item_id_5']")).click();
		Thread.sleep(3000);
		WebElement img = driver.findElement(By.xpath(
				"//img[@src='/wp-content/uploads/2019/02/ONC_Certification_HIT_2015Edition_HealthITModule_Stacked_RGB.png']"));
		boolean isCertificationsDisplayed = img.isDisplayed();
		System.out.println(img.getAttribute("src"));
		Assert.assertTrue(isCertificationsDisplayed, "Certifications not displayed");

	}

	@Test(priority = 46, dependsOnMethods = "certificationsImageDisplayTest")
	public void certificationsImageTest() throws InterruptedException {

		driver.findElement(By.xpath("//a[@id='side_nav_item_id_5']")).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath(
				"//img[@src='/wp-content/uploads/2019/02/ONC_Certification_HIT_2015Edition_HealthITModule_Stacked_RGB.png']"));
			if (element.isDisplayed()) {
			element.click();
		} else {
			Thread.sleep(2000);
			if (element.isDisplayed()) {
				element.click();
			}
		}
		String title = driver.getTitle().trim();
		System.out.println(title);
		Assert.assertEquals(title, "Certifications | myelth");
	}

	@Test(priority = 47)
	public void availableOnAppStoreImageTest() {
		driver.findElement(By.xpath("//a[@id='side_nav_item_id_6']")).click();
		WebElement img = driver.findElement(By.xpath("//img[@src='/wp-content/uploads/2019/02/appstore-icon.png']"));
		boolean isImageDisplayed = img.isDisplayed();
		System.out.println(img.getAttribute("src"));
		Assert.assertTrue(isImageDisplayed, "image not displayed");
	}

	@Test(priority = 48, dependsOnMethods="availableOnAppStoreImageTest" )
		public void availableOnAppStoreTest() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='side_nav_item_id_6']")).click();
		WebElement element = driver
				.findElement(By.xpath("//img[@src='/wp-content/uploads/2019/02/appstore-icon.png']"));
		if (element.isDisplayed()) {
			element.click();
		} else {
			Thread.sleep(2000);
			if (element.isDisplayed()) {
				element.click();
			}
		}
		System.out.println("Current window handle: " + driver.getWindowHandle());
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		for (String tab : newTab) {
			System.out.println("tab: " + tab);
		}
		driver.switchTo().window(newTab.get(1));
		System.out.println("Current window handle: " + driver.getWindowHandle());
		String title = driver.getTitle().trim();
		String subTitle = title.substring(1, title.length());
		System.out.println(subTitle);
		Thread.sleep(3000);
		Assert.assertEquals(subTitle, "Connecting to App Store");
	}

	@Test(priority = 49)
	public void GetItOnGooglePlayImageTest() {

		driver.findElement(By.xpath("//a[@id='side_nav_item_id_6']")).click();
		WebElement img = driver
				.findElement(By.xpath("//img[@src='/wp-content/uploads/2019/02/appstore-icon-mobile-retina.png']"));
		boolean isImageDisplayed = img.isDisplayed();
		System.out.println(img.getAttribute("src"));
		Assert.assertTrue(isImageDisplayed, "image not displayed");
	}

	@Test(priority = 50, dependsOnMethods = "GetItOnGooglePlayImageTest")
	public void GetItOnGooglePlayTest() throws InterruptedException {

		driver.findElement(By.xpath("//a[@id='side_nav_item_id_6']")).click();
		WebElement element = driver
				.findElement(By.xpath("//img[@src='/wp-content/uploads/2019/02/appstore-icon-mobile-retina.png']"));
		if (element.isDisplayed()) {
			element.click();
		} else {
			Thread.sleep(2000);
			if (element.isDisplayed()) {
				element.click();
			}
		}
		System.out.println("Current window handle: " + driver.getWindowHandle());
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		for (String tab : newTab) {
			System.out.println("tab: " + tab);
		}
		driver.switchTo().window(newTab.get(1));
		System.out.println("Current window handle: " + driver.getWindowHandle());
		String title = driver.getTitle().trim();
		Assert.assertEquals(title, "myElth - Apps on Google Play");
	}

	@Test(priority = 51)
	public void copyRightTest() {
		String copyRightText = driver.findElement(By.xpath("//div[@id='footer-info']")).getText();
		System.out.println(driver.findElement(By.xpath("//div[@id='footer-info']")).getText());
		String year = new SimpleDateFormat("yyyy").format(new Date());
		System.out.println(year);
		Assert.assertEquals(copyRightText, "© Copyright " + year + " | MyElth");
	}

	@Test(priority = 52)
	public void facebookDisplayTest() {
		boolean isFacebookDisplayed = driver
				.findElement(By.xpath("//li[@class='et-social-icon et-social-facebook']//a")).isDisplayed();
		Assert.assertTrue(isFacebookDisplayed, "Facebook not displayed");
	}

	@Test(priority = 53, dependsOnMethods="facebookDisplayTest")
	public void facebookTest() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//li[@class='et-social-icon et-social-facebook']//a"));
		element.click();
		Thread.sleep(1000);
		String text = driver.getTitle();
		System.out.println(text);
		Assert.assertEquals(text, "MyElth | Facebook");
	}

	@Test(priority = 54)
	public void twitterDisplayTest() {
		boolean istwitterDisplayed = driver.findElement(By.xpath("//li[@class='et-social-icon et-social-twitter']//a"))
				.isDisplayed();
		Assert.assertTrue(istwitterDisplayed, "Twitter not displayed");
	}

	@Test(priority = 55, dependsOnMethods="twitterDisplayTest")
	public void twitterTest() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//li[@class='et-social-icon et-social-twitter']//a"));
		element.click();
		Thread.sleep(1000);
		String text = driver.getTitle();
		System.out.println(text);
		Assert.assertEquals(text, "myelth (@elth_my) / Twitter");
	}

	@Test(priority = 56)
	public void instagramDisplayTest() throws InterruptedException {
		boolean isInstagramDisplayed = driver
				.findElement(By.xpath("//li[@class='et-social-icon et-social-instagram']//a")).isDisplayed();
		Assert.assertTrue(isInstagramDisplayed, "Instagram not displayed");
	}

	@Test(priority = 57, dependsOnMethods="instagramDisplayTest")
	public void instagramTest() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//li[@class='et-social-icon et-social-instagram']//a"));
		element.click();
		Thread.sleep(1000);
		String text = driver.getTitle();
		System.out.println(text);
		Assert.assertEquals(text, "MyElth | Instagram");
	}

	@Test(priority = 58)
	public void contactUs_btnDisplayTest() {

		boolean isContactUsDisplayed = driver.findElement(By.xpath("//a[@href='/contact-us/']")).isDisplayed();

		Assert.assertTrue(isContactUsDisplayed, "Contact Us button not displayed");

	}

	@Test(priority = 59, dependsOnMethods = "contactUs_btnDisplayTest")
	public void contactUs_btnTest() {
		WebElement element = driver.findElement(By.xpath("//a[@href='/contact-us/']"));
		element.click();
		String text = driver.getTitle();
		System.out.println(text);
		Assert.assertEquals(text, "Contact Us | myelth");
	}

	@Test(priority = 60, dependsOnMethods = "sliderImageTest")
	public void arrowPreviousTest() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//a[@class='et-pb-arrow-prev']"));
		Thread.sleep(3000);
		// element.click();
		boolean isDisplayed = element.isDisplayed();
		Assert.assertTrue(isDisplayed, "not displayed");
		Thread.sleep(3000);
		WebElement mainSlider = driver.findElement(By.xpath("//div[@id='mainSlider']"));
		String image1 = mainSlider.getAttribute("data-active-slide");
		System.out.println(image1);
		element.click();
		String image2 = mainSlider.getAttribute("data-active-slide");
		System.out.println(image2);
		Assert.assertNotEquals(image1, image2);
	}

	    @Test(priority = 61, dependsOnMethods = "sliderImageTest")
		public void arrowNextTest() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//a[@class='et-pb-arrow-next']"));
		Thread.sleep(3000);
		boolean isDisplayed = element.isDisplayed();
		Assert.assertTrue(isDisplayed, "not displayed");
		Thread.sleep(3000);
		WebElement mainSlider = driver.findElement(By.xpath("//div[@id='mainSlider']"));
		String image1 = mainSlider.getAttribute("data-active-slide");
		System.out.println(image1);
		element.click();
		String image2 = mainSlider.getAttribute("data-active-slide");
		System.out.println(image2);
		Assert.assertNotEquals(image1, image2);
	}

	@Test(priority = 62)
	public void sliderDotsTest() {
		WebElement activeDot = driver
				.findElement(By.xpath("//div[@class='et-pb-controllers']/a[@class='et-pb-active-control']"));
		String activeDotText = activeDot.getText();
		int activeDotValue = Integer.parseInt(activeDotText);
		if (activeDotValue == 1) {
			driver.findElement(By.xpath("//div[@class='et-pb-controllers']/a[2]")).click();
			String dot2Text = driver.findElement(By.xpath("//div[@class='et-pb-controllers']/a[2]")).getText();
			Assert.assertNotEquals(activeDotText, dot2Text);
		} else if (activeDotValue == 2) {
			driver.findElement(By.xpath("//div[@class='et-pb-controllers']/a[3]")).click();
			String dot2Text = driver.findElement(By.xpath("//div[@class='et-pb-controllers']/a[3]")).getText();
			Assert.assertNotEquals(activeDotText, dot2Text);
		} else if (activeDotValue == 3) {
			driver.findElement(By.xpath("//div[@class='et-pb-controllers']/a[1]")).click();
			String dot2Text = driver.findElement(By.xpath("//div[@class='et-pb-controllers']/a[1]")).getText();
			Assert.assertNotEquals(activeDotText, dot2Text);
		}
	}

	@AfterMethod
	public void finalize() {
		driver.close();
		driver.quit();
	}

	public boolean isElementPresent(By locatorKey) {
		try {
			driver.findElement(locatorKey);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException ex) {
			return false;
		}
	}

}
