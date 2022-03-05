package com.flipkart.stepdinition;

import com.flipkart.resources.Commonactions;

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
    public void afterScenario() {
		
		System.out.println("After Scenario");
		MobilevalidationSteps.driver.quit();
		long endTime = System.currentTimeMillis();
		
		System.out.println(endTime - startTime);
	}
	

}
