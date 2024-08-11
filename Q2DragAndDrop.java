package Task10;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;

public class Q2DragAndDrop {
	
	String url = "https://jqueryui.com/droppable/";
	WebDriver driver;
  @Test
  public void LaunchDragAndDropTest() {
	  
	  //locating frame
	  WebElement element = driver.findElement(By.xpath("//iframe[contains(@class,'demo-frame')]"));
	  driver.switchTo().frame(element);
	  //selecting draggable element
	  WebElement draggelement = driver.findElement(By.xpath("//div[@id='draggable']"));
	  WebElement droppelement = driver.findElement(By.xpath("//div[@id='droppable']"));
	  
	  //Drag and Drop action
	  Actions action = new Actions(driver);
	  action.dragAndDrop(draggelement, droppelement).build().perform();
	  //After drop colour
	  String colourElement = driver.findElement(By.cssSelector("div#droppable")).getCssValue("background");
	  System.out.println(colourElement);
	  //Verifying target element is changed
	  String str = droppelement.getText();
	  System.out.println("element:" +str);
	  
	  
  } 
  
  @BeforeSuite
  public void LaunchingUrl() {
	  
	  driver = new ChromeDriver();
	  driver.get(url);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
  }

  @AfterSuite
  public void Closingwebsite() {
	  
	  driver.close();
  }

}
