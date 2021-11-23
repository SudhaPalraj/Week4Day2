package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizeable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/resizable/");
		
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.switchTo().frame(0);
		
		WebElement reSize = driver.findElement(By.xpath("//div[@id='resizable']/div[1]"));
		
		Point location = reSize.getLocation();
		
		System.out.println("Befoe resize" +location);
		
		Actions action=new Actions(driver);
		
		
		action.clickAndHold(reSize).dragAndDropBy(reSize, 190, 20).perform();
		
		
		System.out.println("dragged");
		
		System.out.println("After resize" +location);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
