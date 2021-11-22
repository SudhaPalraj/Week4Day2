package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesAssignment {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/pages/frame.html");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.switchTo().frame(0);

		WebElement clickMeSht = driver.findElement(By.xpath("//button[@id='Click']"));

		File source = clickMeSht.getScreenshotAs(OutputType.FILE);

		File dest = new File("Evidence/screenshot1.png");

		FileUtils.copyFile(source, dest);

		System.out.println("Taken screenshot");

		driver.switchTo().defaultContent();

		// To find number of frames

		List<WebElement> framesCount = driver.findElements(By.tagName("iframe"));

		int countofFrames = framesCount.size();

		System.out.println("Number of frames in this page :" + countofFrames);

		driver.close();
	}

}
