package captureScreenshot;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import lib.IE_ScreenshotUtility;
import lib.IE_BrowserUtility;

public class IE_FbScreenshot {
	WebDriver dr;
	
	@Test
	public void CaptureScreenshot() throws IOException, InterruptedException {
		dr = IE_BrowserUtility.invokeBrowser("webdriver.ie.driver","C:\\Chetan\\Softs\\SeleniumSuite\\WebDrivers\\IEDriverServer_Win32_3.13.0\\IEDriverServer.exe","http://www.facebook.com");
		
		IE_ScreenshotUtility.captureScreenshot(dr,"IE/1_Main Page");
		
		dr.findElement(By.cssSelector("input[id^='u_0'][name='firstname']")).sendKeys("Himesh");
		IE_ScreenshotUtility.captureScreenshot(dr,"IE/2_Type_fname");
		
		dr.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Khanna");
		IE_ScreenshotUtility.captureScreenshot(dr,"IE/3_Type_lname");
		
		dr.findElement(By.xpath("//input[contains(@aria-label,'Mobile number or email')]")).sendKeys("4387127620");
		IE_ScreenshotUtility.captureScreenshot(dr,"IE/4_Type_phone");
		
		dr.findElement(By.xpath("//input[starts-with(@name,'reg_pass')]")).sendKeys("NoPassWord");
		IE_ScreenshotUtility.captureScreenshot(dr,"IE/5_Type_pass");
		
		WebElement wb = dr.findElement(By.id("month"));
		Select sel = new Select(wb);
		List<WebElement> list = sel.getOptions();
		for(int i=0; i<list.size(); i++) {
			sel.selectByIndex(i);
			IE_ScreenshotUtility.captureScreenshot(dr,"IE/6_Month_Page"+i);
		}

		wb = dr.findElement(By.id("day"));
		sel = new Select(wb);
		list = sel.getOptions();
		for(int i=0; i<list.size(); i++) {
			sel.selectByIndex(i);
			IE_ScreenshotUtility.captureScreenshot(dr,"IE/7_Day_Page"+i);
		}
		
		wb = dr.findElement(By.id("year"));
		sel = new Select(wb);
		list = sel.getOptions();
		for(int i=0; i<list.size(); i++) {
			sel.selectByIndex(i);
			IE_ScreenshotUtility.captureScreenshot(dr,"IE/8_Year_Page"+i);
		}
		
		dr.findElement(By.xpath("//input[@name='sex' and @value='1']")).click();
		IE_ScreenshotUtility.captureScreenshot(dr,"IE/9_Click_Female");

		dr.findElement(By.xpath("//input[@name='sex' and @value='2']")).click();
		IE_ScreenshotUtility.captureScreenshot(dr,"IE/10_Click_Male");

		dr.findElement(By.xpath("//a[contains(text(),'Forgot account?')]")).click();
		IE_ScreenshotUtility.captureScreenshot(dr,"IE/11_Click_ForgotAccount");
		
		dr.close();		
	}
	
}
