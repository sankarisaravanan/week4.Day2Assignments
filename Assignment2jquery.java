package week4Assignments;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2jquery {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		Actions builder = new Actions(driver);
				
		// Draggable
		driver.get("https://jqueryui.com/draggable");
		Thread.sleep(1000);
		WebElement frame1 = driver.findElement(By.xpath("//div[@id='content']/iframe"));
		driver.switchTo().frame(frame1);
		WebElement dragElement = driver.findElement(By.id("draggable"));
		builder.dragAndDropBy(dragElement, 10, 10).perform();
		Thread.sleep(1000);
		builder.dragAndDropBy(dragElement, -15, -15).perform();
		Thread.sleep(1000);
		//driver.close();

		//Droppable 
		  driver.get("https://jqueryui.com/droppable"); 
		  Thread.sleep(2000);
		  frame1 = driver.findElement(By.xpath("//div[@id='content']/iframe"));
		  driver.switchTo().frame(frame1);
		  WebElement drag1 = driver.findElement(By.id("draggable"));
		  WebElement drop1 = driver.findElement(By.id("droppable"));
		  builder.dragAndDrop(drag1, drop1).perform(); 
		  Thread.sleep(2000);
		  //driver3.close();		 
		
		 //Resizable 
		  driver.get("https://jqueryui.com/resizable");
		  Thread.sleep(2000);
		  driver.manage().window().maximize();
		  Thread.sleep(1000);
		  Actions builder1 = new Actions(driver); 
		  frame1 = driver.findElement(By.xpath("//div[@id='content']/iframe"));
		  driver.switchTo().frame(frame1); 
		  WebElement resizeElement = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"
		  )); 
		  builder1.clickAndHold(resizeElement).perform();
		  builder1.moveByOffset(15, 15).perform();
		  Thread.sleep(2000);
		  
		  //Selectable 
		  driver.get("https://jqueryui.com/selectable");
		  Thread.sleep(2000);
		  frame1 = driver.findElement(By.xpath("//div[@id='content']/iframe"));
		  driver.switchTo().frame(frame1);
		  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		  WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		  WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		  WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		  builder.clickAndHold(item1).perform();
		  builder.clickAndHold(item2).perform();
		  builder.clickAndHold(item3).perform(); 
		  Thread.sleep(2000); 
		  //driver2.close();		 

		 // Sortable
		 driver.get("https://jqueryui.com/sortable");
		 Thread.sleep(2000);
		 frame1 = driver.findElement(By.xpath("//div[@id='content']/iframe"));
		 driver.switchTo().frame(frame1);
		 driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		 WebElement srcitem = driver.findElement(By.xpath("//li[text()='Item 1']")); 
		 WebElement destitem = driver.findElement(By.xpath("//li[text()='Item 2']")); 
		 int destX = destitem.getLocation().getX(); 
		 int destY = destitem.getLocation().getY();
		 System.out.println(destX+" , "+destY);
		 System.out.println("Destination item Location : "+destitem.getLocation());
		 System.out.println("Source item Location : "+srcitem.getLocation());
		 builder.dragAndDrop(srcitem, destitem); 
		 builder.dragAndDropBy(srcitem, 15, 50).perform(); 
		 Thread.sleep(3000);
		 System.out.println("Items sorted successfully"); 
		 driver.close(); 

	}

}
