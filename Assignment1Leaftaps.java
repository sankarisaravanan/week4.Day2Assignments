package week4Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1Leaftaps {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//driver.get("http://www.leafground.com/pages/sortable.html");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		Actions builder = new Actions(driver);
				
		//Sortable
		driver.get("http://www.leafground.com/pages/sortable.html");
		Thread.sleep(2000);
		WebElement srcitem = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement destitem = driver.findElement(By.xpath("//li[text()='Item 2']"));
		int destX = destitem.getLocation().getX();
		int destY = destitem.getLocation().getY();
		System.out.println(destX+" , "+destY);
		System.out.println("Destination item Location : "+destitem.getLocation());
		System.out.println("Source item Location : "+srcitem.getLocation());
		//builder.dragAndDrop(srcitem, destitem);
		builder.dragAndDropBy(srcitem, 50, 100).perform();
		Thread.sleep(3000);
		System.out.println("Items sorted successfully");
		driver.close();
		
		//MouseOver
		ChromeDriver driver1 = new ChromeDriver();
		Actions builder1 = new Actions(driver1);		
		driver1.get("http://www.leafground.com/pages/mouseOver.html");
		Thread.sleep(2000);
		WebElement courses = driver1.findElement(By.linkText("TestLeaf Courses"));
		builder1.moveToElement(courses).perform();
		List<WebElement> leafcourses = driver1.findElements(By.xpath("//a[@class='listener']"));
		System.out.println("Courses displayed under 'TestLeaf Courses' : ");
		for(WebElement i : leafcourses)
			System.out.println(i.getText());
		driver1.findElement(By.linkText("RPA")).click();
		Thread.sleep(1000);
		System.out.println("Clicked 'RPA' course successfully");
		Alert alert = driver1.switchTo().alert();
		alert.accept();
		driver1.close();
		
		
		//Selectable
		ChromeDriver driver2 = new ChromeDriver();
		Actions builder2 = new Actions(driver2);
		driver2.get("http://www.leafground.com/pages/selectable.html");
		driver2.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		WebElement item1 = driver2.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item2 = driver2.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement item3 = driver2.findElement(By.xpath("//li[text()='Item 3']"));
		builder2.clickAndHold(item1).perform();
		builder2.clickAndHold(item2).perform();
		builder2.clickAndHold(item3).perform();
		Thread.sleep(2000);
		driver2.close();
		
		//Droppable
		ChromeDriver driver3 = new ChromeDriver();
		driver3.get("http://www.leafground.com/pages/drop.html");
		Actions builder3 = new Actions(driver3);
		WebElement drag1 = driver3.findElement(By.id("draggable"));
		WebElement drop1 = driver3.findElement(By.id("droppable"));
		builder3.dragAndDrop(drag1, drop1).perform();
		Thread.sleep(2000);
		driver3.close();
		
		
		//Draggable
		ChromeDriver driver4 = new ChromeDriver();
		driver4.get("http://www.leafground.com/pages/drag.html");
		Actions builder4 = new Actions(driver4);
		WebElement dragElement = driver4.findElement(By.id("draggable"));
		builder4.dragAndDropBy(dragElement, 100, 100).perform();
		Thread.sleep(1000);
		builder4.dragAndDropBy(dragElement, -50, -50).perform();
		Thread.sleep(1000);
		driver4.close();
	}

}
