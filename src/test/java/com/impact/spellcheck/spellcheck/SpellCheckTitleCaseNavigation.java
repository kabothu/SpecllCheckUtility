package com.impact.spellcheck.spellcheck;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class SpellCheckTitleCaseNavigation {
	public static WebDriver driver = null;
	
  @Test
  public void f() {
	  	
  }
  @BeforeTest
  public void beforeTest() {
	  
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "/DriverExe/chromedriver.exe");
		driver = new ChromeDriver();

		
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://vm-30600:41875/sites/impact/pages/default.aspx");
		
  }

  @AfterTest
  public void afterTest() throws Exception {
	  navigationHelper(driver);
  }
  
  public void navigationHelper(WebDriver driver) throws Exception{
	  List<WebElement> demovar = driver.findElements(By.tagName("a"));
		System.out.println("============================================================================");
		System.out.println("TOTAL LINK FOUND ON BASE URL : "+ demovar.size());
		System.out.println("============================================================================");
		
		ArrayList<String> hrefs = new ArrayList<String>(); 
		// List for storing all href values for 'a' tag
		for (WebElement var : demovar) {
			// used to get text present between the anchor tags
			System.out.println("LINK NAME: '"+var.getText()+ "' URL is ==>  "+var.getAttribute("href"));
			hrefs.add(var.getAttribute("href"));
			System.out.println("*************************************");
		}

		// Navigating to each link
		int i = 0;
		for (String href : hrefs) {
			driver.navigate().to(href);
			System.out.println("============================================================================");
			System.out.println((++i) + ": NAVIGATED TO URL with : '" + href +"'\n RESPONSE CODE: "+isLinkBroken(new URL(href)));
			System.out.println("============================================================================");
			Thread.sleep(3000); // To check if the navigation is happening properly.
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			isSpellCheck(driver);
			
			if(driver.findElements(By.tagName("a")).size()>1){
				ArrayList<String> hrefs1 = new ArrayList<String>(); 
				List<WebElement> demovar1 = driver.findElements(By.tagName("a"));
				for (WebElement var : demovar1) {
					// used to get text present between the anchor tags
					System.out.println("NESTED LINK NAME: '"+var.getText()+ "' With NESTED URL is ==>  "+var.getAttribute("href"));
					hrefs1.add(var.getAttribute("href"));
					System.out.println("*************************************");
				} 
						int j = 0;
						for (String href1 : hrefs1) {
							driver.navigate().to(href1);
							System.out.println("============================================================================");
							System.out.println((++j) + ": NAVIGATED TO URL with : '" + href1 +"'\n RESPONSE CODE: "+isLinkBroken(new URL(href1)));
							System.out.println("============================================================================");
							Thread.sleep(3000); // To check if the navigation is happening properly.
							System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
							isSpellCheck(driver);
					}
			}
			
		}
  }
  
  
  public static String isLinkBroken(URL url) throws Exception
	{ 
		String response = "";
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		try
		{
		    connection.connect();
		    response = connection.getResponseMessage();	        
		    connection.disconnect();
		    return response;
		}
		catch(Exception exp)
		{
			return exp.getMessage();
		}  				
	}
	

	public static String isSpellCheck(WebDriver driver) throws Exception
	{ 
		String response = "";
		try
		{
			String strInput = driver.findElement(By.tagName("body")).getText();
			String[] strParts = strInput.split("\\r?\\n|\\r");
			System.out.println("Total Words Found on URL : " + strParts.length+ "\n");
			
			for(int i=0;i<=strParts.length+1;i++){
				JazzySpellChecker jazzySpellChecker = new JazzySpellChecker();
				System.out.println("CORRECTION OPTION FOR TEXT '"+strParts[i] +"' is : "+jazzySpellChecker.getCorrectedText(strParts[i]));
				isTitleCase(strParts[i]);
			}
		}
		catch(Exception exp)
		{
			return exp.getMessage();
		}
		return response;  				
	}
	
	public static Boolean isTitleCase(String TestString) throws Exception
	{
		boolean flag= false;
		try {
			
			String camelCasePattern = "([A-Z]+[a-z]+\\w+)+"; 
			String [] TestStrings = TestString.split("\\s+");
			for(int i=0;i<TestStrings.length;i++){
//				System.out.println(TestStrings[i]);
				flag = TestStrings[i].matches(camelCasePattern);
				if(!flag){
					System.out.println(".");
					//System.out.println("TITLE CASE Check for String ' "+ TestString+ "' is : "+ flag);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

}
