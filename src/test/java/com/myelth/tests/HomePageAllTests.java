package com.myelth.tests;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.myelth.PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageAllTests {
	
	public static WebDriver driver;
	
	  public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		JavascriptExecutor js  = (JavascriptExecutor) driver;
		PageObjects objects = new PageObjects(driver);
		driver.get("https://myelth.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				
		//Logo test
		System.out.println(objects.logo());
		boolean isLogoDisplayed = objects.logo().isDisplayed();
		System.out.println(isLogoDisplayed);
		Assert.assertTrue(isLogoDisplayed, "Error: Logo is not displayed.");
		
		//Home text test
		String homeText = objects.home().getText();
		System.out.println(homeText);
		Assert.assertEquals(homeText, "Home", "HomeText not found");
		
		//HomeTest
		objects.home().click();
		String homeTitle = driver.getTitle();
		System.out.println(homeTitle);
		Assert.assertEquals(homeTitle, "myelth | healthtech with a consumer focus");
		
		//Payers text test
		String payersText = objects.payer().getText();
		System.out.println(payersText);
		Assert.assertEquals(payersText,"Payers", "PayersText not found");
		
		//Payers test
		objects.payer().click();
		String payerTitle = driver.getTitle();
		System.out.println(payerTitle);
		Assert.assertEquals(payerTitle, "Payers | myelth");
		
		//blog text test
		String blogText = objects.blog().getText();
		System.out.println(blogText);
		Assert.assertEquals(blogText, "Blog", "BlogText not found");
		
		//blog test
		objects.blog().click();
		String blogTitle = driver.getTitle();
		System.out.println(blogTitle);
		Assert.assertEquals(blogTitle, "Blog | myelth");
		
		//News text test
		String newsText = objects.news().getText();
		System.out.println(newsText);
		Assert.assertEquals(newsText, "News", "NewsText not found");
		
		//News test
		objects.news().click();
		String newsTitle = driver.getTitle();
		System.out.println(newsTitle);
		Assert.assertEquals(newsTitle, "News | myelth");
		
		//Platform text test
		String platformText = objects.platform().getText();
		System.out.println(platformText);
		Assert.assertEquals(platformText, "Platform", "PlatformText not found");
		
		//Platfom test
		objects.platform().click();
		String platformTitle = driver.getTitle();
		System.out.println(platformTitle);
		Assert.assertEquals(platformTitle, "Platform | myelth");
		
		//Provider text test
		String providerText = objects.provider().getText();
		System.out.println(providerText);
		Assert.assertEquals(providerText, "Provider", "ProviderText not found");
		
		//Provider test
		objects.provider().click();
		String providerTitle = driver.getTitle();
		System.out.println(providerTitle);
		Assert.assertEquals(providerTitle, "Provider | myelth");
		
		//Employer text test
		String employerText = objects.employer().getText();
		System.out.println(employerText);
		Assert.assertEquals(employerText, "Employer", "EmployerText not found");
		
		//Employer test
		objects.employer().click();
		String employerTitle = driver.getTitle();
		System.out.println(employerTitle);
		Assert.assertEquals(employerTitle, "Employer | myelth");
		
		//Footer home text test
		String footerHomeText = objects.footerHome().getText();
		System.out.println(footerHomeText);
		Assert.assertEquals(footerHomeText, "HOME", "Footer Home Text not found");
		
		//Footer home test
		objects.footerHome().click();
		String footerHomeTitle = driver.getTitle();
		System.out.println(footerHomeTitle);
		Assert.assertEquals(footerHomeTitle, "myelth | healthtech with a consumer focus");
		
		//FAQs text test
		String faqsText = objects.faqs().getText();
		System.out.println(faqsText);
		Assert.assertEquals(faqsText, "FAQS", "Faqs Text not found");
		
		//FAQs test
		objects.faqs().click();
		String faqsTitle = driver.getTitle();
		System.out.println(faqsTitle);
		Assert.assertEquals(faqsTitle, "FAQs | myelth");
		
		//Privacy policy text test
		String privacyPolicyText = objects.privacyPolicy().getText();
		System.out.println(privacyPolicyText);
		Assert.assertEquals(privacyPolicyText, "PRIVACY POLICY", "Privacy Policy Text not found");
		
		//Privacy policy test
		objects.privacyPolicy().click();
		String privacyPolicyTitle = driver.getTitle();
		System.out.println(privacyPolicyTitle);
		Assert.assertEquals(privacyPolicyTitle, "Privacy Policy | myelth");
		
		//Terms and conditions text test
		String termsAndConditionsText = objects.termsAndConditions().getText();
		System.out.println(termsAndConditionsText);
		Assert.assertEquals(termsAndConditionsText, "TERMS & CONDITIONS", "Terms And Conditions Text not found");
		
		//Terms and conditions test
		objects.termsAndConditions().click();
		String termsAndConditionsTitle = driver.getTitle();
		System.out.println(termsAndConditionsTitle);
		Assert.assertEquals(termsAndConditionsTitle, "Terms & Conditions | myelth");
		
		//Contact us text test
		String contactUsText = objects.contactUs().getText();
		System.out.println(contactUsText);
		Assert.assertEquals(contactUsText, "CONTACT US", "Contact Us Text not found");
		
		//Contact us test
		objects.contactUs().click();
		String contactUsTitle = driver.getTitle();
		System.out.println(contactUsTitle);
		Assert.assertEquals(contactUsTitle, "Contact Us | myelth");
		
		//About us text test
		String aboutUsText = objects.aboutUs().getText();
		System.out.println(aboutUsText);
		Assert.assertEquals(aboutUsText, "ABOUT US", "About Us Text not found");
		
		//About us test
		objects.aboutUs().click();
		String aboutUsTitle = driver.getTitle();
		System.out.println(aboutUsTitle);
		Assert.assertEquals(aboutUsTitle, "About Us | myelth");
		
		objects.home().click();
		
		//Slider image test
		for (int i = 0; i <= 2; i++) {
			String slideControllersXpath = "//div[@data-active-slide='et_pb_slide_" + i + "']";
			System.out.println(slideControllersXpath);
			boolean isSliderDisplayed = false;
			try {
				if (driver.findElement(By.xpath(slideControllersXpath)).isDisplayed()) {
					isSliderDisplayed = true;
				}
			} catch (NoSuchElementException nse) {
				isSliderDisplayed = false;
			}

			if (isSliderDisplayed) {
				Assert.assertTrue(isSliderDisplayed, "Slider is not displayed");
			}

		}
		
		//Slider image text test
		Thread.sleep(4000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement element1 = (WebElement) jse
				.executeScript("return document.getElementsByClassName('et_pb_slide_title')[0];");
		WebElement element2 = (WebElement) jse
				.executeScript("return document.getElementsByClassName('et_pb_slide_title')[1];");
		WebElement element3 = (WebElement) jse
				.executeScript("return document.getElementsByClassName('et_pb_slide_title')[2];");
		boolean isTextPresent = false;
		if (element1.isDisplayed() || element2.isDisplayed()|| element3.isDisplayed()) {
			isTextPresent = true;
			System.out.println("Text present");
		} else {
			System.out.println("Text not found");
		}

		Assert.assertTrue(isTextPresent, "Text not found");
		
		// Previous - arrow test
		//driver.findElement(By.xpath("//a[@id='side_nav_item_id_0']")).click();
		Thread.sleep(3000);
		WebElement previousElement = driver.findElement(By.xpath("//a[@class='et-pb-arrow-prev']"));
		Thread.sleep(3000);
		boolean isPreviousArrowDisplayed = previousElement.isDisplayed();
		Assert.assertTrue(isPreviousArrowDisplayed, "not displayed");
		Thread.sleep(3000);
		WebElement mainSlider1 = driver.findElement(By.xpath("//div[@id='mainSlider']"));
		String previousImage1 = mainSlider1.getAttribute("data-active-slide");
		System.out.println(previousImage1);
		previousElement.click();
		String previousImage2 = mainSlider1.getAttribute("data-active-slide");
		System.out.println(previousImage2);
		Assert.assertNotEquals(previousImage1,previousImage2);
		
		//Next - arrow test
		WebElement nextElement = driver.findElement(By.xpath("//a[@class='et-pb-arrow-next']"));
		Thread.sleep(3000);
		boolean isnextArrowDisplayed = nextElement.isDisplayed();
		Assert.assertTrue(isnextArrowDisplayed, "not displayed");
		WebElement mainSlider2 = driver.findElement(By.xpath("//div[@id='mainSlider']"));
		String nextImage1 = mainSlider2.getAttribute("data-active-slide");
		System.out.println(nextImage1);
		nextElement.click();
		String nextImage2 = mainSlider2.getAttribute("data-active-slide");
		System.out.println(nextImage2);
		Assert.assertNotEquals(nextImage1, nextImage2);
		Thread.sleep(3000);
		
		//Slider Dots test() {
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
		
		
		//Video functionality test
		js.executeScript("document.getElementsByTagName('video')[0].play()");
		Thread.sleep(5000);
		js.executeScript("document.getElementsByTagName('video')[0].pause()");

		System.out.println(objects.videoDisplayed().isEnabled());
		
		//Video display test
		boolean isVideoDisplayed = driver.findElement(By.xpath("//video")).isDisplayed();
		System.out.println(driver.findElement(By.xpath("//video")).getText());
		Assert.assertTrue(isVideoDisplayed, "Video is not loaded on the home page.");
		
		//Side navigation dots test
		for (int i = 0; i <= 8; i++) {
			WebElement sideNavDot = driver.findElement(By.xpath("//a[@id='side_nav_item_id_" + i + "']"));
			if (i == 0) {
				sideNavDot.click();
				boolean isLogoDisplayed2 = driver.findElement(By.xpath("//img[@id='logo']")).isDisplayed();
				Assert.assertTrue(isLogoDisplayed2, "Side Navigation Dot 1 is not working");
			} else if (i == 1) {
				sideNavDot.click();
				boolean isimgDisplayed = driver.findElement(By.xpath("//div[@id='mainSlider']")).isDisplayed();
				Assert.assertTrue(isimgDisplayed, "Side Navigation Dot 2 is not working");
			} else if (i == 2) {
				sideNavDot.click();
				String howDoesItWorkText= driver.findElement(By.xpath("//div[@class='et_pb_row et_pb_row_1']//span/span"))
						.getText();
				Assert.assertEquals(howDoesItWorkText, "How Does It Work?");
			} else if (i == 3) {
				sideNavDot.click();
				String whyUsText= driver.findElement(By.xpath("//div[@id='whyus']/div//span/span")).getText();
				Assert.assertEquals(whyUsText, "Why Us?");
			} else if (i == 4) {
				sideNavDot.click();
				String featuresText = driver.findElement(By.xpath("//div[@class='et_pb_row et_pb_row_6']/div//span/span"))
						.getText();
				Assert.assertEquals(featuresText, "Features");
			} else if (i == 5) {
				sideNavDot.click();
				String certificatesText = driver.findElement(By.xpath("//div[@class='et_pb_row et_pb_row_13']/div//span/span"))
						.getText();
				Assert.assertEquals(certificatesText, "Certificates");
			} else if (i == 6) {
				sideNavDot.click();
			WebElement element=driver.findElement(By.cssSelector("div.download-content h2 span"));
	         // String	text=	e.getText();
		    String	downloadText=element.getAttribute("innerText");
			System.out.println(downloadText);
			Assert.assertEquals(downloadText, "Download the myElth app by clicking below:");
			 
			} else if (i == 7) {
				sideNavDot.click();
				System.out.println("Text is not displayed");
//				boolean text = driver.findElement(By.xpath("//div[@id='testimonials']")).isDisplayed();
			//	js.executeScript("window.scrollBy(0,500)");
//				Assert.assertTrue(text, "Side Navigation Dot 8 is not working");
				//WebElement img = driver.findElement(By.xpath("//img[@src='/wp-content/uploads/2019/02/appstore-icon.png']"));
			//	boolean isImageDisplayed = img.isDisplayed();
				//System.out.println(img.getAttribute("src"));
			//	Assert.assertTrue(isImageDisplayed, "image not displayed");

			} else if (i == 8) {
				sideNavDot.click();
				String PromoText = driver.findElement(By.xpath("//div[@class='et_pb_promo_description']/h2"))
						.getText();
				Assert.assertEquals(PromoText, "myelth empowers and engages consumers by providing easy access to information and deeper insights on cost of care, personal health records and coverage information.");
			}
		}
		
		//Search for care - read more button display test
		driver.findElement(By.xpath("//a[@id='side_nav_item_id_4']")).click();
		WebElement searchForCareElement = driver.findElement(By.xpath("//a[@href='/search-for-care/']"));
		
		boolean isSearchDisplayed = searchForCareElement.isDisplayed();
		Assert.assertTrue(isSearchDisplayed, "not displayed");
		Thread.sleep(2000);
		
		//Search for care - read more button test
		
		//driver.findElement(By.xpath("//a[@id='side_nav_item_id_4']")).click();
		WebElement readMoreButton=driver.findElement(By.xpath("//a[@href='/search-for-care/']"));
		js.executeScript("arguments[0].click()", readMoreButton);		
		Thread.sleep(2000);
		String searchForCareTitle = driver.getTitle();
		System.out.println(searchForCareTitle);
		Assert.assertEquals(searchForCareTitle, "Search for Care | myelth");
		driver.navigate().back();
		
		
		//Access to real-time-coverage - read more button display test
		driver.findElement(By.xpath("//a[@id='side_nav_item_id_4']")).click();
		WebElement accessToRealTimeCoverageElement = driver.findElement(By.xpath("//a[@class='et_pb_button et_pb_button_1 orange-button et_pb_bg_layout_light'and .='READ MORE']"));
		boolean isaccessDisplayed =  accessToRealTimeCoverageElement.isDisplayed();
		Assert.assertTrue(isaccessDisplayed, "not displayed");
		
		//Access to real-time-coverage  - read more button test
		Thread.sleep(3000);
		accessToRealTimeCoverageElement.click();
		String accessToRealTimeCoverageTitle = driver.getTitle();
		System.out.println(accessToRealTimeCoverageTitle);
		Assert.assertEquals(accessToRealTimeCoverageTitle, "Access to real-time Coverage | myelth");
		driver.navigate().back();
		
		//Aggregate - electronic - health - records - read more button display test
		WebElement aggregateElectronicHealthRecordsElement = driver.findElement(By.xpath("//a[@href='/aggregate-electronic-health-records']"));
		boolean isaggregateDisplayed = aggregateElectronicHealthRecordsElement.isDisplayed();
		Assert.assertTrue(isaggregateDisplayed, "not displayed");
		
		//Aggregate - electronic - health - records - read more button test
		aggregateElectronicHealthRecordsElement.click();
		String  aggregateElectronicHealthRecordsTitle = driver.getTitle();
		System.out.println( aggregateElectronicHealthRecordsTitle);
		Assert.assertEquals( aggregateElectronicHealthRecordsTitle, "Aggregate Electronic Health Records | myelth");
		driver.navigate().back();
		
		//Earn  rewards and incentives - read more button display test
		WebElement earnRewardsAndIncentivesElement = driver.findElement(By.xpath("//a[@href='/earn-rewards-and-incentives/']"));
		boolean isearnRewardsDisplayed = earnRewardsAndIncentivesElement .isDisplayed();
		Assert.assertTrue(isearnRewardsDisplayed, "not displayed");
		
		//Earn  rewards and incentives - read more button test
		earnRewardsAndIncentivesElement.click();
		String earnRewardsAndIncentivesTitle = driver.getTitle();
		System.out.println(earnRewardsAndIncentivesTitle);
		Assert.assertEquals(earnRewardsAndIncentivesTitle, "Earn Rewards and Incentives | myelth");
		driver.navigate().back();
		
	   //Share - health - information - read more button display test
		WebElement shareHealthInformationElement = driver.findElement(By.xpath("//a[@href='/share-health-information/']"));
		boolean isShareHealthDisplayed =  shareHealthInformationElement.isDisplayed();
		Assert.assertTrue(isShareHealthDisplayed, "not displayed");
		
		 //Share - health - information - read more button test
		shareHealthInformationElement.click();
		String shareHealthInformationTitle = driver.getTitle();
		System.out.println(shareHealthInformationTitle);
		Assert.assertEquals(shareHealthInformationTitle, "Share Health Information | myelth");
		driver.navigate().back();
		
		//Manage entire family's health -  read more button display test
		WebElement manageEntireFamilysHealthElement = driver.findElement(By.xpath("//a[@href='/manage-entire-familys-health/']"));
		boolean ismanageEntireFamilysHealthDisplayed = manageEntireFamilysHealthElement.isDisplayed();
		Assert.assertTrue(ismanageEntireFamilysHealthDisplayed , "not displayed");
		
		//Manage entire family's health -  read more button test
		manageEntireFamilysHealthElement.click();
		String manageEntireFamilysHealthTitle = driver.getTitle();
		System.out.println(manageEntireFamilysHealthTitle);
		Assert.assertEquals(manageEntireFamilysHealthTitle, "Manage entire family’s health | myelth");
		driver.navigate().back();
		
		//Certifications image display test
		driver.findElement(By.xpath("//a[@id='side_nav_item_id_5']")).click();
		Thread.sleep(3000);
		WebElement imgCertifications = driver.findElement(By.xpath("//img[@src='/wp-content/uploads/2019/02/ONC_Certification_HIT_2015Edition_HealthITModule_Stacked_RGB.png']"));
		boolean isCertificationsDisplayed = imgCertifications.isDisplayed();
		System.out.println(imgCertifications.getAttribute("src"));
		Assert.assertTrue(isCertificationsDisplayed, "Certifications not displayed");
		
		//Certifications image test
		driver.findElement(By.xpath("//a[@id='side_nav_item_id_5']")).click();
		Thread.sleep(3000);
		WebElement certificationsElement = driver.findElement(By.xpath(
				"//img[@src='/wp-content/uploads/2019/02/ONC_Certification_HIT_2015Edition_HealthITModule_Stacked_RGB.png']"));
			if (certificationsElement.isDisplayed()) {
				certificationsElement.click();
		} else {
			Thread.sleep(3000);
			if (certificationsElement.isDisplayed()) {
				certificationsElement.click();
			}
		}
		String certificationsTitle = driver.getTitle().trim();
		System.out.println(certificationsTitle);
		Assert.assertEquals(certificationsTitle, "Certifications | myelth");
		driver.navigate().back();
		
		//Available On AppStore image  display test
		driver.findElement(By.xpath("//a[@id='side_nav_item_id_6']")).click();
		Thread.sleep(3000);
		WebElement imgAppStore = driver.findElement(By.xpath("//img[@src='/wp-content/uploads/2019/02/appstore-icon.png']"));
		Actions act=new Actions(driver);
		act.moveToElement(imgAppStore).perform();
		boolean isAppStoreImageDisplayed = imgAppStore.isDisplayed();
		System.out.println(imgAppStore.getAttribute("src"));
		Assert.assertTrue(isAppStoreImageDisplayed, "AppStore image not displayed");
		Thread.sleep(2000);
			
		
		//Available On AppStore image test
		//driver.findElement(By.xpath("//a[@id='side_nav_item_id_6']")).click();
		WebElement appStoreElement = driver
				.findElement(By.xpath("//img[@src='/wp-content/uploads/2019/02/appstore-icon.png']"));
		Thread.sleep(3000);
		if (appStoreElement.isDisplayed()) {
			appStoreElement.click();
		} else {
			Thread.sleep(2000);
			if (appStoreElement.isDisplayed()) {
				appStoreElement.click();
			}
		}
		System.out.println("Current window handle: " + driver.getWindowHandle());
		ArrayList<String> newTab1 = new ArrayList<String>(driver.getWindowHandles());
		for (String tab : newTab1) {
			System.out.println("tab: " + tab);
		}
		driver.switchTo().window(newTab1.get(1));
		System.out.println("Current window handle: " + driver.getWindowHandle());
		String appStoreTitle = driver.getTitle().trim();
		String appStoreSubTitle = appStoreTitle.substring(1, appStoreTitle.length());
		System.out.println(appStoreSubTitle);
		Thread.sleep(3000);
		Assert.assertEquals(appStoreSubTitle, "Connecting to App Store");

		driver.close();
		
		
		//Get It On GooglePlay image display test
		
		driver.switchTo().window(newTab1.get(0));
		driver.findElement(By.xpath("//a[@id='side_nav_item_id_6']")).click();
		WebElement imgGetItOnGooglePlay = driver
				.findElement(By.xpath("//img[@src='/wp-content/uploads/2019/02/appstore-icon-mobile-retina.png']"));
		Actions act1=new Actions(driver);
		act1.moveToElement( imgGetItOnGooglePlay).perform();
		boolean isGetItOnGooglePlayImageDisplayed = imgGetItOnGooglePlay.isDisplayed();
		System.out.println(imgGetItOnGooglePlay.getAttribute("src"));
		Assert.assertTrue(isGetItOnGooglePlayImageDisplayed, "Get It On GooglePlay image not displayed");
		Thread.sleep(3000);
		
		//Get It On GooglePlay image test
		//driver.findElement(By.xpath("//a[@id='side_nav_item_id_6']")).click();
		WebElement getItOnGooglePlayElement = driver
				.findElement(By.xpath("//img[@src='/wp-content/uploads/2019/02/appstore-icon-mobile-retina.png']"));
		Thread.sleep(3000);
		if ( getItOnGooglePlayElement.isDisplayed()) {
			 getItOnGooglePlayElement.click();
		} else {
			Thread.sleep(2000);
			if ( getItOnGooglePlayElement.isDisplayed()) {
				 getItOnGooglePlayElement.click();
			}
		}
		System.out.println("Current window handle: " + driver.getWindowHandle());
		ArrayList<String> newTab2 = new ArrayList<String>(driver.getWindowHandles());
		for (String tab : newTab2) {
			System.out.println("tab: " + tab);
		}
		driver.switchTo().window(newTab2.get(1));
		System.out.println("Current window handle: " + driver.getWindowHandle());
		String appsOnGooglePlayTitle = driver.getTitle().trim();
		System.out.println(appsOnGooglePlayTitle);
		Assert.assertEquals(appsOnGooglePlayTitle, "myElth - Apps on Google Play");
		driver.close();
		driver.switchTo().window(newTab2.get(0));
		
			
		//Contact Us - button display test
		boolean isContactUsDisplayed = driver.findElement(By.xpath("//a[@href='/contact-us/']")).isDisplayed();
		Assert.assertTrue(isContactUsDisplayed, "Contact Us button not displayed");
		
		//Contact Us - button test
		driver.findElement(By.xpath("//a[@id='side_nav_item_id_8']")).click();
		WebElement contactUs_Element = driver.findElement(By.xpath("//a[@href='/contact-us/']"));
		Thread.sleep(2000);
		contactUs_Element.click();
		String contact_us_title = driver.getTitle();
		System.out.println( contact_us_title);
		Assert.assertEquals( contact_us_title, "Contact Us | myelth");
		Thread.sleep(2000);
		driver.navigate().back();
		driver.navigate().back();
		
		//CopyRight Test
		String copyRightText = driver.findElement(By.xpath("//div[@id='footer-info']")).getText();
		System.out.println(driver.findElement(By.xpath("//div[@id='footer-info']")).getText());
		String year = new SimpleDateFormat("yyyy").format(new Date());
		System.out.println(year);
		Assert.assertEquals(copyRightText, "© Copyright " + year + " | MyElth");
		
		//Facebook display test
		boolean isFacebookDisplayed = driver
				.findElement(By.xpath("//li[@class='et-social-icon et-social-facebook']//a")).isDisplayed();
		Assert.assertTrue(isFacebookDisplayed, "Facebook not displayed");
		
		//Facebook test
		WebElement facebookElement = driver.findElement(By.xpath("//li[@class='et-social-icon et-social-facebook']//a"));
		facebookElement .click();
		Thread.sleep(1000);
		String facebookTitle = driver.getTitle();
		System.out.println(facebookTitle);
		Assert.assertEquals(facebookTitle, "MyElth | Facebook");
		driver.navigate().back();
		
		//Twitter display test
		boolean istwitterDisplayed = driver.findElement(By.xpath("//li[@class='et-social-icon et-social-twitter']//a"))
				.isDisplayed();
		Assert.assertTrue(istwitterDisplayed, "Twitter not displayed");
		
		//Twitter test
		WebElement twitterElement = driver.findElement(By.xpath("//li[@class='et-social-icon et-social-twitter']//a"));
		twitterElement.click();
		Thread.sleep(1000);
		String twitterTitle = driver.getTitle();
		System.out.println(twitterTitle);
		Assert.assertEquals(twitterTitle, "myelth (@elth_my) / Twitter");
		driver.navigate().back();
		
		//Instagram display test
		boolean isInstagramDisplayed = driver
				.findElement(By.xpath("//li[@class='et-social-icon et-social-instagram']//a")).isDisplayed();
		Assert.assertTrue(isInstagramDisplayed, "Instagram not displayed");
		
		//Instagram test
		WebElement instagramElement = driver.findElement(By.xpath("//li[@class='et-social-icon et-social-instagram']//a"));
		instagramElement .click();
		Thread.sleep(1000);
		String instagramTitle = driver.getTitle();
		System.out.println(instagramTitle);
		Assert.assertEquals(instagramTitle, "myelth | healthtech with a consumer focus");
		driver.navigate().back();
	
		
		//close the browser
		
		driver.close();
		driver.quit();
							
			}
		
	public static boolean isElementPresent(By locatorKey, WebDriver driver) {
		
		try {
			driver.findElement(locatorKey);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException ex) {
			return false;
		}
	}

}
