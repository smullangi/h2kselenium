package com.h2k.openmrs;
	 
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	 
	public class LoginPage {
	 
	    //Default driver has null
	    WebDriver driver;
	    public LoginPage(WebDriver driver)
	    {
	        this.driver = driver;
	    }
	    public boolean login(String uname,String pword)
	    {
	        driver.findElement(By.id("username")).sendKeys(uname);
	        driver.findElement(By.id("password")).sendKeys(pword);
	        driver.findElement(By.id("Inpatient Ward")).click();
	        driver.findElement(By.id("loginButton")).submit();
	      boolean result = driver.getTitle().contains("Home");
	       return result;
	    }
	}



