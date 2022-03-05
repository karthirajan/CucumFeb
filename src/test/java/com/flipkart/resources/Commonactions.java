package com.flipkart.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Commonactions {
	
	public static WebDriver driver;
	
	//launch
	public void launch(String url) {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.setExperimentalOption("excludeSwitches",
        Arrays.asList("disable-popup-blocking"));
		//options.addArguments("headless");
	    driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	}
	
	
	//sendkeys
	public void insertText(WebElement ele,String input) {
         
		ele.sendKeys(input,Keys.ENTER);

	}
	
	
	//click
	public void button(WebElement ele) {
		
		ele.click();

	}
	
	
	
	//action
	public void moveToElement(WebElement source,WebElement target) {
		
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).build().perform();

	}
	
	//windowHandle
	public void windowHandle() throws InterruptedException {
		String parentURL = driver.getWindowHandle();
		   
		   Set<String> childURL = driver.getWindowHandles();
		   for (String child : childURL) {
			   
			   if(!parentURL.equals(child)) {
				   
				   driver.switchTo().window(child);
				   
			   }
			
		
		   }
		   Thread.sleep(2000);

	}
	
	//excelWrite
	public String excelWrite() throws Throwable {
		
		File file = new File(".//Excel//Mobile.xlsx");  
		 FileInputStream f = new FileInputStream(file);
		 
		 XSSFWorkbook w = new XSSFWorkbook(f);
		 XSSFSheet sheet = w.getSheet("mobile");
		 XSSFCell cell = sheet.getRow(4).getCell(0);
		 
		 String namefromexcel = cell.getStringCellValue();
		 
		 return namefromexcel;

	}

}
