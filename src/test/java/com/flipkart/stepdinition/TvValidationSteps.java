package com.flipkart.stepdinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.flipkart.resources.Commonactions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TvValidationSteps extends Commonactions{
	
	
	static String tv = "LG";
	
	
	
	@When("user search tv")
	public void user_search_tv() throws IOException {
		
		  WebElement search = driver.findElement(By.name("q"));
		   search.sendKeys("LG",Keys.ENTER);
		   
	      excleWrite();   
	    
	}

	@When("user click on the tv name")
	public void user_click_on_the_tv_name() throws InterruptedException {
		
		WebElement mobiles = driver.findElement(By.xpath("(//div[contains(text(),'"+tv+"')])[4]"));
		mobiles.click();
		
		String parentURL = driver.getWindowHandle();
		   
		   Set<String> childURL = driver.getWindowHandles();
		   for (String child : childURL) {
			   
			   if(!parentURL.equals(child)) {
				   
				   driver.switchTo().window(child);
				   
			   }
			
		
		   }
		   Thread.sleep(2000);
	   
	}
	
	

	@Then("user validate the tv names")
	public void user_validate_the_tv_names() throws IOException {
		
		 WebElement mobileName2 = driver.findElement(By.xpath("//span[contains(text(),'"+tv+"')]"));
		   String name = mobileName2.getText();
		   System.out.println(name);
		   
		 File file = new File(".//Excel//Mobile.xlsx");  
		 FileInputStream f = new FileInputStream(file);
		 
		 XSSFWorkbook w = new XSSFWorkbook(f);
		 XSSFSheet sheet = w.getSheet("mobile");
		 XSSFCell cell = sheet.getRow(4).getCell(0);
		 
		 String namefromexcel = cell.getStringCellValue();
		 
		 
		 if(name.equals(namefromexcel)) {
			 System.out.println("pass");
		 }else {
			 System.out.println("fail");
		 }
		 
		// driver.quit();
	    
	}
	
	
public static void excleWrite() throws IOException {
		
		//write
		   File file = new File(".//Excel//Mobile.xlsx");
		   FileOutputStream f = new FileOutputStream(file);
		   
		   XSSFWorkbook w = new XSSFWorkbook();
		   XSSFSheet sheet = w.createSheet("mobile");
		   
		   List<WebElement> mobiles = driver.findElements(By.xpath("(//div[contains(text(),'"+tv+"')])"));
		   
		   for (int i = 1; i < mobiles.size(); i++) {
			   
			   WebElement mobile = mobiles.get(i);
			   String name = mobile.getText();
			   
			   XSSFRow row = sheet.createRow(i);
			   XSSFCell cell = row.createCell(0);
			   
			   cell.setCellValue(name);
			
		}
		   
		   w.write(f);
		   w.close();

	}


}


