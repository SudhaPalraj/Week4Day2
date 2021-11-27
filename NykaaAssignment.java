package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.nykaa.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebElement brandHover = driver.findElement(By.xpath("(//div[@class='css-1yqek2e']/ul)[2]"))	;	
		
		Actions action=new Actions(driver);
		
		action.moveToElement(brandHover).perform();
		
		//Mouseover on Brands and Search L'Oreal Paris
		
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
		
		
		driver.findElement(By.xpath("//div[@id='scroller-container']/div/a")).click();
		
		//Check the title contains L'Oreal Paris(Hint-GetTitle)
		
		String title = driver.getTitle();
		
		if (title.contains("L'Oreal Paris")) {
			
			System.out.println("Fetched correct title");
		}
		
		//To select sort by 
		
		driver.findElement(By.xpath("//button[@class=' css-p2rfnw']")).click();
		
		//to select customer rated 
		
		driver.findElement(By.xpath("(//div[@class='control-box css-1w85ogp'])[4]/label/div[2]")).click();
		
		//System.out.println("clicked");
		
		
		//To click category 
		
		driver.findElement(By.xpath("//div[@id='first-filter']//div[@class='filter-open css-nbw8dp']")).click();
		
		Thread.sleep(1000);
		
		//To click Hair 
		
		driver.findElement(By.xpath("//div[@id='first-filter']/ul//div")).click();
		
		Thread.sleep(2000);
		
		//To click Haircare 
		
		driver.findElement(By.xpath("//span[text()='Hair Care']/parent::div")).click();
		
		//to click shampoo
		
		driver.findElement(By.xpath("//label[@for='checkbox_Shampoo_316']/div[2]")).click();
		
		
		//to click concern
		
		driver.findElement(By.xpath("//div[@id='first-filter']/following-sibling::div[5]/div[@class='filter-open css-nbw8dp']")).click();
		
		Thread.sleep(2000);
		
		//to click color protection
		
		driver.findElement(By.xpath("//label[@for='checkbox_Color Protection_10764']/div[2]")).click();
		
		//check whether the Filter is applied with Shampoo
		
		String FilterText = driver.findElement(By.xpath("//span[text()='Shampoo']")).getText();
		
		if (FilterText.contains("Shampoo")) {
			
			System.out.println("Filter shampoo is applied successfully");
		}
		
		
		//to click Click on L'Oreal Paris Colour Protect Shampoo
		
		driver.findElement(By.xpath("//div[@id='product-list-wrap']/div/div/div/a")).click();
		
		//GO to the new window and select size as 175ml
		
	 Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> allWindowHandles=new ArrayList<String>(windowHandles);
		
		allWindowHandles.get(1);
		
		driver.switchTo().window(allWindowHandles.get(1));
		
		String title2 = driver.getTitle();
		
		System.out.println(title2);
		
		//to select size as 175 ml 
		
		WebElement mlSize = driver.findElement(By.xpath("//select[@title='SIZE']"));
		
		Select option=new Select(mlSize) ;
		
		option.selectByVisibleText("175ml");
		
		
		
		//To select mrp 
		
		String MRPTag = driver.findElement(By.xpath("//span[@class='css-12x6n3h']")).getText();
		
		System.out.println("Mrp is " +MRPTag);
		
		Thread.sleep(2000);
		
		//To click add to bag 
		
		driver.findElement(By.xpath("(//span[text()='ADD TO BAG'])[1]")).click();
		
		Thread.sleep(3000);
		
		//To click shopping bag 
		
		driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
		
		
		//to get grand total
		
		Thread.sleep(2000);
		
		//cart-iframe
		
		driver.switchTo().frame(0);
		
		
		
		//WebElement Grandtotal = driver.findElement(By.xpath("//div[@class='sticky-bottom proceed-cart-btn']//div[@class='first-col']/div"));
		
		//Grandtotal.getText();
		
		String Grandtotal = driver.findElement(By.xpath("//div[@class='sticky-bottom proceed-cart-btn']//div[@class='first-col']/div")).getText();
		
		
		
		System.out.println("The Grandtotal is " +Grandtotal);
		
		//To click proceed 
		
		driver.findElement(By.xpath("//div[@class='second-col']/button")).click();
	
		//To click continue as guest 
		
		//driver.switchTo().window(allWindowHandles.get(1));
		
		
		String newPageTitle = driver.getTitle();
		
		System.out.println(newPageTitle);
		
		
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		
		
		//To check grad total 
		
		String FinalTotal = driver.findElement(By.xpath("//div[@class='payment-details-container open']/div[2]/div[@class='value']")).getText();
		
		System.out.println("Final total is " + FinalTotal);
		
		if (Grandtotal.equals(FinalTotal)) {
			
			System.out.println("Both totals are same ");
			
		}
		
		else {
			
			System.out.println("Both totals are NOT  same ");
			
		}
		
		driver.close();
	}

}
