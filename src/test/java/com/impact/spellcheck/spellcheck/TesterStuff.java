package com.impact.spellcheck.spellcheck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesterStuff {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "/DriverExe/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://vm-30600:41875/sites/impact/_layouts/impact/App/Issue/IssuePipeline.aspx");
		
		Thread.sleep(3000);
		String strInput = driver.findElement(By.tagName("body")).getText();
		String[] strParts = strInput.split("\\r?\\n|\\r");
		
		
		System.out.println("                      =========================================");
		System.out.println("			Total Words Found on URL : " + strParts.length+ "\n");
		System.out.println("                      =========================================");
		
		for(int j = 0; j<strParts.length;j++){
			System.out.println("BODY VALUES ARE :\n"+ strParts[j]);
		}
		System.out.println("                      =========================================");
		String strInputTable = driver.findElement(By.tagName("tbody")).getText();
		String[] strPartsTable = strInputTable.split("\\r?\\n|\\r");
		
		for(int j = 0; j<strPartsTable.length;j++){
			System.out.println("BODY VALUES ARE :\n"+ strPartsTable[j]);
		}
		System.out.println("                      =========================================");
		
		
//		int i =0;
//		List<String> finalTextList = new ArrayList<String>();
//		for(String s: strParts){
//			if(!strPartsTable[i].contains(s)){
//				finalTextList.add(strParts[i]);
//				System.out.println(finalTextList.get(i));
//				
//			}i++;
//		}
		
//		List<WebElement> strBodyParts = driver.findElements(By.tagName("body"));
		
		
//		List<WebElement> strTBodyParts = driver.findElements(By.tagName("tbody"));
		
//		System.out.println(driver.findElement(By.tagName("tbody")).getText());
		
//		List<WebElement> duplicateList = new ArrayList<WebElement>();
//		List<WebElement> finalTextList = new ArrayList<WebElement>();
//		for(int i=0;i<strBodyParts.size();i++){
//			System.out.println(strBodyParts.get(i).getText());
//		}
//		
//		
//		for(int i=0;i<strTBodyParts.size();i++){
//			System.out.println(strTBodyParts.get(i).getText());
//		}
//		
//		// Variable names edited for readability
//		for (WebElement item : strBodyParts) {
//		    if (strTBodyParts.contains(item)) {
//		    	System.out.println("Adding: "+ item);
//		        duplicateList.add(item);
//		    } else {
//		    	System.out.println("Adding to FINAL: "+ item);
//		    	finalTextList.add(item);
//		    }
//		}
//		for(int i=0;i<duplicateList.size();i++){
//			System.out.println(duplicateList.get(i).getText());
//		}
//
//		for(int i=0;i<finalTextList.size();i++){
//			System.out.println(finalTextList.get(i).getText());
//		}

	}

}
