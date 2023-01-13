package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.Constant;
import utility.ExcelUtils;

public class TestSignIn {

	public static void main(String[] args) throws Exception {
		
		final long SHORT_DELAY = 1000; // short delay
		final long LONG_DELAY = 5000; // short delay
		
		//This is to open the Excel file. Excel path, file name and the sheet name are parameters to this method
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
				
		String email = ExcelUtils.getCellData(3, 1);
		String password = ExcelUtils.getCellData(3, 2);
		
		// Create a new instance of Chrome driver
	    WebDriver driver = new ChromeDriver();
	    
		// Maximize window
		driver.manage().window().maximize();
		
		// Launch the Website
		driver.navigate().to("https://www.worldtimebuddy.com");
		
		// Click Sign In link
		driver.findElement(By.id("tab_signin")).click();
		Thread.sleep(SHORT_DELAY);
		
		// Click Sign In with Email link
		driver.findElement(By.cssSelector("#tabs-func > li.dropdown > div > a.si_menuitem_last")).click();
		Thread.sleep(SHORT_DELAY);
		
		// Enter email address
		driver.findElement(By.cssSelector("#screen-login > form > input:nth-child(2)")).sendKeys(email);
		Thread.sleep(SHORT_DELAY);
		
		// Enter password
		driver.findElement(By.cssSelector("#screen-login > form > input:nth-child(4)")).sendKeys(password);
		Thread.sleep(SHORT_DELAY);
		
		// Click SignIn button
		driver.findElement(By.cssSelector("#screen-login > form > div:nth-child(6) > input")).click();
		Thread.sleep(LONG_DELAY);
				
		// Logout
		driver.findElement(By.cssSelector("#tab_account")).click();
		Thread.sleep(SHORT_DELAY);
		
		driver.findElement(By.cssSelector("#tabs-func > li.dropdown > div > a.si_menuitem_last")).click();
		Thread.sleep(LONG_DELAY);
		
		driver.quit();
		
		//This is to send the PASS value to the Excel sheet in the result column.
		ExcelUtils.setCellData("Pass", 3, 3);
				
				
				
	}

}
