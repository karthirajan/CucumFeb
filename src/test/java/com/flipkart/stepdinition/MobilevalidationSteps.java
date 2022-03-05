package com.flipkart.stepdinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.flipkart.objectrepository.MobileValidationPage;
import com.flipkart.resources.Commonactions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobilevalidationSteps extends Commonactions{
	
	Commonactions c = new Commonactions();
	MobileValidationPage m = new MobileValidationPage();
	
	static String mobile = "realme";
	
	@Given("user launches flipkart application")
	public void user_launches_flipkart_application() {
		
	}

	@Given("user login by entering valid crendentials")
	public void user_login_by_entering_valid_crendentials() {
		
		 try {
			 
			  
			   m.getLoginCloser().isDisplayed();
			   c.button(m.getLoginCloser());
			
	    	} catch (Exception e) {
	    		
			System.out.println("pop up is not displayed");
			
	    	}
	   
	}

	@When("user search mobile")
	public void user_search_mobile() throws IOException {
		
		  
		  c.insertText(m.getSearch(), mobile);
		   
	       excleWrite();   
	    
	}

	@When("user click on the mobile name")
	public void user_click_on_the_mobile_name() throws InterruptedException {
		
		WebElement mobiles = driver.findElement(By.xpath("(//div[contains(text(),'"+mobile+"')])[4]"));
		c.button(mobiles);
		
		c.windowHandle();
	   
	}
	
	

	@Then("user validate the mobile names")
	public void user_validate_the_mobile_names() throws Throwable {
		
		 WebElement mobileName2 = driver.findElement(By.xpath("//span[contains(text(),'"+mobile+"')]"));
		   String name = mobileName2.getText();
		   System.out.println(name);
		   
		String namefromexcel = c.excelWrite();
		 
		 
		 if(name.equals(namefromexcel)) {
			 System.out.println("pass");
		 }else {
			 System.out.println("fail");
		 }
		 
		// driver.quit();
	    
	}
	
	@When("user search mobile by one dim list")
	public void user_search_mobile_by_one_dim_list(DataTable datas) throws IOException {
		
		List<String> mobileName = datas.asList();
		
		mobile = mobileName.get(1);
		
		 WebElement search = driver.findElement(By.name("q"));
		   search.sendKeys(mobile,Keys.ENTER);
		   
		   excleWrite();
	    
	}
	
	@When("user search mobile by one dim map")
	public void user_search_mobile_by_one_dim_map(DataTable datas) throws IOException {
		
		Map<String, String> mobileName = datas.asMap(String.class, String.class);
		
		mobile = mobileName.get("3");
		
		 WebElement search = driver.findElement(By.name("q"));
		   search.sendKeys(mobile,Keys.ENTER);
		   
		   excleWrite();
	    
	}
	
	@When("user search mobile {string}")
	public void user_search_mobile(String phoneNames) throws IOException {
		
		
		mobile = phoneNames;
		
		 WebElement search = driver.findElement(By.name("q"));
		   search.sendKeys(mobile,Keys.ENTER);
		   
		   excleWrite();
	    
	}
	
	public static void excleWrite() throws IOException {
		
		//write
		   File file = new File(".//Excel//Mobile.xlsx");
		   FileOutputStream f = new FileOutputStream(file);
		   
		   XSSFWorkbook w = new XSSFWorkbook();
		   XSSFSheet sheet = w.createSheet("mobile");
		   
		   List<WebElement> mobiles = driver.findElements(By.xpath("(//div[contains(text(),'"+mobile+"')])"));
		   
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
