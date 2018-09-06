package captureScreenshot;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import lib.Chrome_ScreenshotUtility;
import lib.Chrome_BrowserUtility;

public class Chrome_FbScreenshot {
	WebDriver dr;
	
	@Test
	public void CaptureScreenshot() throws IOException, InterruptedException {
		dr = Chrome_BrowserUtility.invokeBrowser("webdriver.chrome.driver",
				"C:\\Chetan\\Softs\\SeleniumSuite\\WebDrivers\\chromedriver.exe","http://www.facebook.com");
		
		Chrome_ScreenshotUtility.captureScreenshot(dr,"Chrome/1_Main Page");
		
		dr.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Himesh");
		Chrome_ScreenshotUtility.captureScreenshot(dr,"Chrome/2_Type_fname");
		
		dr.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Khanna");
		Chrome_ScreenshotUtility.captureScreenshot(dr,"Chrome/3_Type_lname");
		
		dr.findElement(By.xpath("//input[contains(@aria-label,'Mobile number or email')]")).sendKeys("4387127620");
		Chrome_ScreenshotUtility.captureScreenshot(dr,"Chrome/4_Type_phone");
		
		dr.findElement(By.xpath("//input[starts-with(@name,'reg_pass')]")).sendKeys("NoPassWord");
		Chrome_ScreenshotUtility.captureScreenshot(dr,"Chrome/5_Type_pass");
		
		WebElement wb = dr.findElement(By.id("month"));
		Select sel = new Select(wb);
		List<WebElement> list = sel.getOptions();
		for(int i=0; i<list.size(); i++) {
			sel.selectByIndex(i);
			Chrome_ScreenshotUtility.captureScreenshot(dr,"Chrome/6_Month_Page"+i);
		}

		wb = dr.findElement(By.id("day"));
		sel = new Select(wb);
		list = sel.getOptions();
		for(int i=0; i<list.size(); i++) {
			sel.selectByIndex(i);
			Chrome_ScreenshotUtility.captureScreenshot(dr,"Chrome/7_Day_Page"+i);
		}
		
		wb = dr.findElement(By.id("year"));
		sel = new Select(wb);
		list = sel.getOptions();
		for(int i=0; i<list.size(); i++) {
			sel.selectByIndex(i);
			Chrome_ScreenshotUtility.captureScreenshot(dr,"Chrome/8_Year_Page"+i);
		}
		
		dr.findElement(By.xpath("//input[@name='sex' and @value='1']")).click();
		Chrome_ScreenshotUtility.captureScreenshot(dr,"Chrome/9_Click_Female");

		dr.findElement(By.xpath("//input[@name='sex' and @value='2']")).click();
		Chrome_ScreenshotUtility.captureScreenshot(dr,"Chrome/10_Click_Male");

		dr.findElement(By.xpath("//a[contains(text(),'Forgot account?')]")).click();
		Chrome_ScreenshotUtility.captureScreenshot(dr,"Chrome/11_Click_ForgotAccount");
		
		dr.close();		
	}
	
}
