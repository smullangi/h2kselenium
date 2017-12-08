package com.h2k.openmrs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import junit.framework.Test;
import junit.framework.TestCase;
//import junit.framework.TestSuite;


/**
 * Unit test for simple App.
 */
public class OpenMRS 
    extends TestCase
    {
	@Test
	
	 
	public class OpenMrsLoginTests {
	 
	    WebDriver driver;
	    
	    public String url;
	    @Parameters({"browserType","url"})
	    @BeforeClass
	    public void invokeBrowser(String browserType,String url)
	    {
	 
	        if(browserType.equals("FF"))
	        {
	            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
	            driver = new FirefoxDriver();
	        }
	        else if(browserType.equals("IE"))
	        {
	            /**
	             * zoom should be 100%
	             * Protected mode should be enabled for all the security zones..
	             */
	            System.out.println("in IEEE");
	            System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
	            driver = new InternetExplorerDriver();
	        }
	        else if(browserType.equals("CH"))
	        {
	            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	            driver = new ChromeDriver();
	        } 
	        this.url=url;
	    }
	    @BeforeMethod
	    public void openBrowser()
	    {
	        driver.get(url); 
	    }
	     
	    @Test
	    public void verifyLogin()
	    {
	          
	        try{
	            LoginPage lPage = new LoginPage(driver);
	            boolean result = lPage.login("Admin", "Admin123");
	            Assert.assertTrue(result);
	        }
	        catch(Exception e)
	        {
	            Assert.fail(e.getMessage());
	        }
	 
	    }
	    @Test
	    public void verifyInvalidLogin()
	    { 
	        try{
	            LoginPage lPage = new LoginPage(driver);
	            boolean result = lPage.login("Admin123", "Admin123");
	            Assert.assertFalse(result);
	        }
	        catch(Exception e)
	        {
	            Assert.fail(e.getMessage());
	        }
	 
	    }
	 	 
	}


	


	
    }
/*{
    *//**
     * Create the test case
     *
     * @param testName name of the test case
     *//*
    public AppTest( String testName )
    {
        super( testName );
    }

    *//**
     * @return the suite of tests being tested
     *//*
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    *//**
     * Rigourous Test :-)
     *//*
    public void testApp()
    {
        assertTrue( true );
    }
}
*/