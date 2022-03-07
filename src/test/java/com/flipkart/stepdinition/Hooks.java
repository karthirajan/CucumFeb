package com.flipkart.stepdinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.flipkart.resources.Commonactions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends Commonactions{
	
	Commonactions c = new Commonactions();
	
	static long startTime;
	
	@Before
	public void beforeScenario() {
		
		System.out.println("Before Scenario");
		c.launch("https://www.flipkart.com/");
		
		 startTime = System.currentTimeMillis();
	}
	
	@After
    public void afterScenario(Scenario scenario) {
		
		System.out.println("After Scenario");
		
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime - startTime);
		
		if(scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}else {
			final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		
		driver.quit();
		
		
	}
	

}
