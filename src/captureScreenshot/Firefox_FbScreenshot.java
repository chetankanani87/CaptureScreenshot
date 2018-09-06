package captureScreenshot;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import lib.Firefox_ScreenshotUtility;
import lib.Firefox_BrowserUtility;

public class Firefox_FbScreenshot {
	WebDriver dr;
	
	@Test
	public void CaptureScreenshot() throws IOException, InterruptedException {
		dr = Firefox_BrowserUtility.invokeBrowser("webdriver.gecko.driver","C:\\Chetan\\Softs\\SeleniumSuite\\WebDrivers\\geckodriver.exe","http://www.facebook.com");
		
		Firefox_ScreenshotUtility.captureScreenshot(dr,"Firefox/1_Main Page");
		
		dr.findElement(By.cssSelector("input[id^='u_0'][name='firstname']")).sendKeys("Himesh");
		Firefox_ScreenshotUtility.captureScreenshot(dr,"Firefox/2_Type_fname");
		
		dr.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Khanna");
		Firefox_ScreenshotUtility.captureScreenshot(dr,"Firefox/3_Type_lname");
		
		dr.findElement(By.xpath("//input[contains(@aria-label,'Mobile number or email')]")).sendKeys("4387127620");
		Firefox_ScreenshotUtility.captureScreenshot(dr,"Firefox/4_Type_phone");
		
		dr.findElement(By.xpath("//input[starts-with(@name,'reg_pass')]")).sendKeys("NoPassWord");
		Firefox_ScreenshotUtility.captureScreenshot(dr,"Firefox/5_Type_pass");
		
		WebElement wb = dr.findElement(By.id("month"));
		Select sel = new Select(wb);
		List<WebElement> list = sel.getOptions();
		for(int i=0; i<list.size(); i++) {
			sel.selectByIndex(i);
			Firefox_ScreenshotUtility.captureScreenshot(dr,"Firefox/6_Month_Page"+i);
		}

		wb = dr.findElement(By.id("day"));
		sel = new Select(wb);
		list = sel.getOptions();
		for(int i=0; i<list.size(); i++) {
			sel.selectByIndex(i);
			Firefox_ScreenshotUtility.captureScreenshot(dr,"Firefox/7_Day_Page"+i);
		}
		
		wb = dr.findElement(By.id("year"));
		sel = new Select(wb);
		list = sel.getOptions();
		for(int i=0; i<list.size(); i++) {
			sel.selectByIndex(i);
			Firefox_ScreenshotUtility.captureScreenshot(dr,"Firefox/8_Year_Page"+i);
		}
		
		dr.findElement(By.xpath("//input[@name='sex' and @value='1']")).click();
		Firefox_ScreenshotUtility.captureScreenshot(dr,"Firefox/9_Click_Female");

		dr.findElement(By.xpath("//input[@name='sex' and @value='2']")).click();
		Firefox_ScreenshotUtility.captureScreenshot(dr,"Firefox/10_Click_Male");

		dr.findElement(By.xpath("//a[contains(text(),'Forgot account?')]")).click();
		Firefox_ScreenshotUtility.captureScreenshot(dr,"Firefox/11_Click_ForgotAccount");
		
		dr.close();		
	}
	
}
