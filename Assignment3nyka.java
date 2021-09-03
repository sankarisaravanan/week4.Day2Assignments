package week4Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3nyka {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver  = new ChromeDriver();
		Actions builder = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		driver.get("https://www.nykaa.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		//WebElement brandtoClick = driver.findElement(By.linkText("brands"));
		WebElement brandtoClick = driver.findElement(By.xpath("//div[@id='brand_arrowUp']/preceding-sibling::a"));
		builder.moveToElement(brandtoClick).perform();
		driver.findElement(By.linkText("L'Oreal Paris")).click();
		String lorealpage = driver.getTitle();
		System.out.println(driver.getTitle());
		if(lorealpage.contains("L'Oreal Paris"))
			System.out.println("Title has L'Oreal Paris text");
		else
			System.out.println("Title is not having L'Oreal Paris text");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'Sort By')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'customer top rated')]")).click();
		
		//To Select Top Customer Rated Category & select option as Shampoo
		WebElement elementhair = driver.findElement(By.xpath("//div[@class='filter-sidebar__filter-wrap']/div"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", elementhair);
		WebElement ele = driver.findElement(By.xpath("//div[@class='filter-options-toggle']"));
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", ele);
		
		Thread.sleep(1000);
		WebElement ele1 = driver.findElement(By.xpath("(//div[@class='filter-options-toggle'])[2]"));
		jse.executeScript("arguments[0].click()", ele1);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='control__indicator']")).click();
		Thread.sleep(1000);
		
		//to check the filter applied as shampoo
		String filterText=driver.findElement(By.xpath("//ul[@class='pull-left applied-filter-lists']/li")).getText();
		System.out.println("Applied Filter : "+ filterText);
		
		if(filterText.contains("Shampoo"))
			System.out.println("Filter 'Shampoo' got applied successfully");
		else
			System.out.println("Filter 'Shampoo' not apllied");
		
		//Select L'Oreal colour protect shampoo and get the price & add to cart
		driver.findElement(By.id("SearchInputBox")).sendKeys("L'Oreal Paris Colour Protect Shampoo");
		driver.findElement(By.xpath("//div[@class='content']/b")).click();
		Thread.sleep(1000);
		WebElement options = driver.findElement(By.xpath("//select"));
		Select quantity = new Select(options);
		quantity.selectByVisibleText("175ml");
		String priceamt = driver.findElement(By.xpath("//span[@class='post-card__content-price-offer']")).getText();
		priceamt=priceamt.replaceAll("\\D", "");
		int price = Integer.parseInt(priceamt);
		System.out.println("Price of L'Oreal Colour Protect Shampoo : Rs."+priceamt);
		driver.findElement(By.xpath("//button[@class='combo-add-to-btn prdt-des-btn js--toggle-sbag nk-btn nk-btn-rnd atc-simple m-content__product-list__cart-btn  ']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='AddBagIcon']")).click();
		
		//Capture & Check the Grand total Amount before Proceed and in final page
		String grandTotalstr = driver.findElement(By.xpath("//div[@class='first-col']/div")).getText();
		grandTotalstr=grandTotalstr.replaceAll("\\D", "");
		int grandTot=Integer.parseInt(grandTotalstr);
		System.out.println("Grand Total before Proceed : Rs."+grandTot);
		WebElement proceedbtn = driver.findElement(By.xpath("//button[@class='btn full fill no-radius proceed ']"));
		jse.executeScript("arguments[0].click()", proceedbtn);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='btn full big']")).click();
		Thread.sleep(1000);
		String proceedTotalstr = driver.findElement(By.xpath("(//div[@class='payment-details-tbl grand-total-cell prl20']/div)[2]")).getText();
		proceedTotalstr = proceedTotalstr.replaceAll("\\D", "");
		int proceedtot=Integer.parseInt(proceedTotalstr);
		System.out.println("Grand Total after Proceed : Rs."+proceedtot);
		if(grandTot==proceedtot)
			System.out.println("Both Grand Total before & after Proceed are Equal");
		else
			System.out.println("Both Grand Total before & after Proceed are not Equal");
		driver.close();		
		
	}

}
