package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnDraggable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/draggable/");
		
		

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.switchTo().frame(0);
		
		WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
		
		
		Actions mouseClk=new Actions(driver);
		
		mouseClk.dragAndDropBy(draggable, 100, 100).perform();
		
		Point location = draggable.getLocation();
		
		System.out.println(location);
		
		System.out.println("Draggable");
		
		//driver.close();
		
		//Drag and Drop 
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.linkText("Droppable")).click();
		
		String title = driver.getTitle();
		
		System.out.println(title);
		
		
		//To select element in side frame 
		
		driver.switchTo().frame(0);
		
		WebElement dragElement = driver.findElement(By.xpath("//div[@id='draggable']"));
		
		WebElement dropElement =driver.findElement(By.xpath("//div[@id='droppable']"));
		
		
		mouseClk.dragAndDrop(dragElement, dropElement).perform();
		
		
		
		
		
		
		
	}

}
