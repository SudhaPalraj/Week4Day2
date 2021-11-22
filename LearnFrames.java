package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrames {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Going to frame using id

		driver.switchTo().frame("frame1");

		driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input")).sendKeys("Learn Frames");

		// Taking next frame

		driver.switchTo().frame("frame3");

		// to click checkbox

		driver.findElement(By.xpath("//input[@id='a']")).click();

		Thread.sleep(2000);

		// to go to next frame

		// driver.switchTo().frame("frame2");

		driver.switchTo().defaultContent();

		String text = driver.findElement(By.xpath("//h1[text()='Frames Examples in Selenium Webdriver']")).getText();

		System.out.println("Lable text is " + text);

		// driver.switchTo().frame(2);

		driver.switchTo().frame("frame2");

		WebElement options = driver.findElement(By.xpath("//select[@id='animals']"));

		Select dd = new Select(options);

		dd.selectByValue("big baby cat");

		System.out.println("AllFrames are seleted");

	}
}
