package captureScreenshot;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import lib.Edge_ScreenshotUtility;
import lib.Edge_BrowserUtility;

public class Edge_FbScreenshot {
	WebDriver dr;
	
	@Test
	public void CaptureScreenshot() throws IOException, InterruptedException {
		dr = Edge_BrowserUtility.invokeBrowser("webdriver.edge.driver","C:\\Chetan\\Softs\\SeleniumSuite\\WebDrivers\\MSEdgeWebdriver\\MicrosoftWebDriver.exe","http://www.facebook.com");
		
		Edge_ScreenshotUtility.captureScreenshot(dr,"Edge/1_Main Page");
		
		dr.findElement(By.cssSelector("input[id^='u_0'][name='firstname']")).sendKeys("Himesh");
		Edge_ScreenshotUtility.captureScreenshot(dr,"Edge/2_Type_fname");
		
		dr.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Khanna");
		Edge_ScreenshotUtility.captureScreenshot(dr,"Edge/3_Type_lname");
		
		dr.findElement(By.xpath("//input[contains(@aria-label,'Mobile number or email')]")).sendKeys("4387127620");
		Edge_ScreenshotUtility.captureScreenshot(dr,"Edge/4_Type_phone");
		
		dr.findElement(By.xpath("//input[starts-with(@name,'reg_pass')]")).sendKeys("NoPassWord");
		Edge_ScreenshotUtility.captureScreenshot(dr,"Edge/5_Type_pass");
		
		WebElement wb = dr.findElement(By.id("month"));
		Select sel = new Select(wb);
		List<WebElement> list = sel.getOptions();
		for(int i=0; i<list.size(); i++) {
			sel.selectByIndex(i);
			Edge_ScreenshotUtility.captureScreenshot(dr,"Edge/6_Month_Page"+i);
		}

		wb = dr.findElement(By.id("day"));
		sel = new Select(wb);
		list = sel.getOptions();
		for(int i=0; i<list.size(); i++) {
			sel.selectByIndex(i);
			Edge_ScreenshotUtility.captureScreenshot(dr,"Edge/7_Day_Page"+i);
		}
		
		wb = dr.findElement(By.id("year"));
		sel = new Select(wb);
		list = sel.getOptions();
		for(int i=0; i<list.size(); i++) {
			sel.selectByIndex(i);
			Edge_ScreenshotUtility.captureScreenshot(dr,"Edge/8_Year_Page"+i);
		}
		
		dr.findElement(By.xpath("//input[@name='sex' and @value='1']")).click();
		Edge_ScreenshotUtility.captureScreenshot(dr,"Edge/9_Click_Female");

		dr.findElement(By.xpath("//input[@name='sex' and @value='2']")).click();
		Edge_ScreenshotUtility.captureScreenshot(dr,"Edge/10_Click_Male");

		dr.findElement(By.xpath("//a[contains(text(),'Forgot account?')]")).click();
		Edge_ScreenshotUtility.captureScreenshot(dr,"Edge/11_Click_ForgotAccount");
		
		dr.close();		
	}
	
}
