package captureScreenshot;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import lib.Opera_ScreenshotUtility;
import lib.Opera_BrowserUtility;

public class Opera_FbScreenshot {
	WebDriver dr;
	
	@Test
	public void CaptureScreenshot() throws IOException, InterruptedException {
		dr = Opera_BrowserUtility.invokeBrowser("webdriver.opera.driver","C:\\Chetan\\Softs\\SeleniumSuite\\WebDrivers\\operadriver_win64\\operadriver.exe","http://www.facebook.com");
		
		Opera_ScreenshotUtility.captureScreenshot(dr,"Opera/1_Main Page");
		
		dr.findElement(By.cssSelector("input[id^='u_0'][name='firstname']")).sendKeys("Himesh");
		Opera_ScreenshotUtility.captureScreenshot(dr,"Opera/2_Type_fname");
		
		dr.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Khanna");
		Opera_ScreenshotUtility.captureScreenshot(dr,"Opera/3_Type_lname");
		
		dr.findElement(By.xpath("//input[contains(@aria-label,'Mobile number or email')]")).sendKeys("4387127620");
		Opera_ScreenshotUtility.captureScreenshot(dr,"Opera/4_Type_phone");
		
		dr.findElement(By.xpath("//input[starts-with(@name,'reg_pass')]")).sendKeys("NoPassWord");
		Opera_ScreenshotUtility.captureScreenshot(dr,"Opera/5_Type_pass");
		
		WebElement wb = dr.findElement(By.id("month"));
		Select sel = new Select(wb);
		List<WebElement> list = sel.getOptions();
		for(int i=0; i<list.size(); i++) {
			sel.selectByIndex(i);
			Opera_ScreenshotUtility.captureScreenshot(dr,"Opera/6_Month_Page"+i);
		}

		wb = dr.findElement(By.id("day"));
		sel = new Select(wb);
		list = sel.getOptions();
		for(int i=0; i<list.size(); i++) {
			sel.selectByIndex(i);
			Opera_ScreenshotUtility.captureScreenshot(dr,"Opera/7_Day_Page"+i);
		}
		
		wb = dr.findElement(By.id("year"));
		sel = new Select(wb);
		list = sel.getOptions();
		for(int i=0; i<list.size(); i++) {
			sel.selectByIndex(i);
			Opera_ScreenshotUtility.captureScreenshot(dr,"Opera/8_Year_Page"+i);
		}
		
		dr.findElement(By.xpath("//input[@name='sex' and @value='1']")).click();
		Opera_ScreenshotUtility.captureScreenshot(dr,"Opera/9_Click_Female");

		dr.findElement(By.xpath("//input[@name='sex' and @value='2']")).click();
		Opera_ScreenshotUtility.captureScreenshot(dr,"Opera/10_Click_Male");

		dr.findElement(By.xpath("//a[contains(text(),'Forgot account?')]")).click();
		Opera_ScreenshotUtility.captureScreenshot(dr,"Opera/11_Click_ForgotAccount");
		
		dr.close();		
	}
	
}
