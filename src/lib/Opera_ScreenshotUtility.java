package lib;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Opera_ScreenshotUtility {

	public static void captureScreenshot(WebDriver driver, String screenshotName) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			Thread.sleep(500);
			File src = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./Screenshots/" + screenshotName + ".png"));
			System.out.println("Screenshot Successfully taken.");
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot: " + e.getMessage());
		}

	}

}
