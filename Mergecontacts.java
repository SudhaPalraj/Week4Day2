package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mergecontacts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/login");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();

		// Click contacts link

		driver.findElement(By.linkText("Contacts")).click();

		// Click Merge contacts

		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		// Click on Widget of From Contact

		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]")).click();

		// Get all window Handles

		Set<String> FindWindowTab = driver.getWindowHandles();

		int size = FindWindowTab.size();

		System.out.println("Number of windows is : " + size);

		List<String> newTab = new ArrayList<String>(FindWindowTab);

		driver.switchTo().window(newTab.get(1));

		String title = driver.getTitle();

		System.out.println("New opened tab title is " + title);

		// driver.manage().window().maximize();

		// to select 1st contact

		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']//tr/td[1]/div/a")).click();

		// driver.close();

		System.out.println("clicked");

		driver.switchTo().window(newTab.get(0));

		// to select 2nd widget

		Thread.sleep(2000);

		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();

		Set<String> FindWindowTab2 = driver.getWindowHandles();

		int size2 = FindWindowTab2.size();

		System.out.println("Number of windows is : " + size2);

		List<String> newTab2 = new ArrayList<String>(FindWindowTab2);

		driver.switchTo().window(newTab2.get(1));

		// to select 2nd contact

		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[2]//tr[1]/td/div/a")).click();

		System.out.println("2nd contact clicked");

		driver.switchTo().window(newTab2.get(0));

		driver.findElement(By.xpath("//a[text()='Merge']")).click();

		driver.switchTo().alert().accept();

		String title2 = driver.getTitle();

		System.out.println("current page title is " + title2);

	}

}
