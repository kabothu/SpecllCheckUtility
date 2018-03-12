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
		System.setProperty("webdriver.chrome.driver", path
				+ "/DriverExe/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://vm-30600:41875/sites/impact/_layouts/impact/App/Issue/IssuePipeline.aspx");

		Thread.sleep(3000);
		String strInput = driver.findElement(By.tagName("body")).getText();
		String[] strParts = strInput.split("\\r?\\n|\\r");

		System.out
				.println("                      =========================================");
		System.out.println("			Total Words Found on URL : " + strParts.length
				+ "\n");
		System.out
				.println("                      =========================================");

		for (int j = 0; j < strParts.length; j++) {
			System.out.println("BODY VALUES ARE :\n" + strParts[j]);
		}
		System.out
				.println("                      =========================================");
		String strInputTable = driver.findElement(By.tagName("tbody"))
				.getText();
		String[] strPartsTable = strInputTable.split("\\r?\\n|\\r");

		for (int j = 0; j < strPartsTable.length; j++) {
			System.out.println("BODY VALUES ARE :\n" + strPartsTable[j]);
		}
		System.out
				.println("                      =========================================");
	}

}
