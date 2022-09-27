package com.myelth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjects {
	
	WebDriver driver;
	public PageObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	By logo = By.xpath("//img[@id='logo']");
	By home = By.xpath("//ul[@id='top-menu']//a[.='Home']");
	By platform=By.xpath("//ul[@id='top-menu']//a[.='Platform']");
	By provider=By.xpath("//ul[@id='top-menu']//a[.='Provider']");
	By payer=By.xpath("//ul[@id='top-menu']//a[.='Payers']");
	By employer=By.xpath("//ul[@id='top-menu']//a[.='Employer']");
	By news=By.xpath("//ul[@id='top-menu']//a[.='News']");
	By blog=By.xpath("//ul[@id='top-menu']//a[.='Blog']");
	
	By footerHome=By.xpath("//ul[@id='menu-footer']//a[.='Home']");
	By faqs=By.xpath("//ul[@id='menu-footer']//a[.='FAQs']");
	By privacyPolicy=By.xpath("//ul[@id='menu-footer']//a[.='Privacy Policy']");
	By termsAndConditions=By.xpath("//ul[@id='menu-footer']//a[.='Terms & Conditions']");
	By contactUs=By.xpath("//ul[@id='menu-footer']//a[.='Contact Us']");
	By aboutUs=By.xpath("//ul[@id='menu-footer']//a[.='About Us']");
	
	String slideController = "By.xpath(\"//div[@data-active-slide='et_pb_slide_"+0+"'\"";
	By videoDisplayed =By.xpath("//div[@class='et_pb_row et_pb_row_2']//video");
	
	public WebElement videoDisplayed() {
		WebElement element=driver.findElement(videoDisplayed);
		return element;
	
	}
	
//	Header Elements
	
	public WebElement logo() {
	    WebElement element = driver.findElement(logo);
	    return element;
	}
	
	public WebElement home() {
		WebElement element = driver.findElement(home);
	    return element;
	}
	
	public WebElement platform() {
		WebElement element = driver.findElement(platform);
		return element;
	}
	
	public WebElement provider() {
		WebElement element = driver.findElement(provider);
		return element;
	}
	
	public WebElement payer() {
		WebElement element = driver.findElement(payer);
		return element;
	}
	
	public WebElement employer() {
		WebElement element = driver.findElement(employer);
		return element;
	}
	
	public WebElement news() {
		WebElement element = driver.findElement(news);
		return element;
	}
	
	public WebElement blog() {
		WebElement element = driver.findElement(blog);
		return element;
		
	}
	
//	Footer Elements
	
	public WebElement footerHome() {
      	WebElement element=driver.findElement(footerHome);
        return element;
	}
	
	public WebElement faqs() {
		WebElement element = driver.findElement(faqs);
		return element;
	}
	
	public WebElement privacyPolicy() {
		WebElement element = driver.findElement(privacyPolicy);
		return element;
	}
	
	public WebElement termsAndConditions() {
		WebElement element = driver.findElement(termsAndConditions);
		return element;
	}
	
	public WebElement contactUs() {
		WebElement element = driver.findElement(contactUs);
		return element;
	}
	
	public WebElement aboutUs() {
		WebElement element = driver.findElement(aboutUs);
		return element;
	}
	
}
