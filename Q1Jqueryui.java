package Task10;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class Q1Jqueryui {
	protected static String url="https://jqueryui.com/datepicker/";
	WebDriver driver;
	
  @Test
  public void LaunchSite() {
	  
	  WebElement element = driver.findElement(By.xpath("//iframe[@class ='demo-frame']"));
	  driver.switchTo().frame(element);
	  driver.findElement(By.id("datepicker")).click();
	  driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
	  driver.findElement(By.xpath("//a[contains(text(),'22')]")).click();
	                              
	  //Get values
	  String str = driver.findElement(By.xpath("//input[@id='datepicker']")).getAttribute("value");
	  System.out.println("The Selected Date is: "+ str);
	  
	  
  }
  @BeforeSuite
  public void openUrl() {
	  
	  //Launching URL
	  driver = new ChromeDriver();
	  driver.get(url);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterSuite
  public void closeUrl() {
	  //closing the browser
	  driver.quit();
  }

}
