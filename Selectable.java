package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/selectable/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.switchTo().frame(0);

		WebElement Option1 = driver.findElement(By.xpath("//*[@id='selectable']/li"));

		WebElement Option2 = driver.findElement(By.xpath("(//*[@id='selectable']/li)[2]"));

		WebElement Option3 = driver.findElement(By.xpath("(//*[@id='selectable']/li)[3]"));

		WebElement Option4 = driver.findElement(By.xpath("(//*[@id='selectable']/li)[4]"));

		Actions action = new Actions(driver);

		action.keyDown(Keys.CONTROL).click(Option1).click(Option2).click(Option3).click(Option4).keyUp(Keys.CONTROL)
				.perform();

	}

}
