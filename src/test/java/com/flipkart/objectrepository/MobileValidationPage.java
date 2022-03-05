package com.flipkart.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.resources.Commonactions;

public class MobileValidationPage extends Commonactions{
	
	public MobileValidationPage() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//button[text()='✕']")
	private WebElement loginCloser;
	
	@FindBy(name = "q")
	private WebElement search;
	
	@FindBys({
		@FindBy(xpath = "//input[@type = 'hidden']"),
		@FindBy(name = "lsd")
	})
	private WebElement demo;
	
	@FindAll({
		@FindBy(xpath = "//input[@type = 'hidden']"),
		@FindBy(name = "lsd")
	})
	private WebElement demo1;

	public WebElement getLoginCloser() {
		return loginCloser;
	}

	public WebElement getSearch() {
		return search;
	}
	
	

}
