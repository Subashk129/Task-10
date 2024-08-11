package Task10;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class Q3GuviTest {
	String url = "https://www.guvi.in/";
	WebDriver driver;
	@Test
	public void Launchguvi() {
		driver.findElement(By.xpath("//a[contains(text(),'Sign up')]")).click();
		driver.findElement(By.id("name")).sendKeys("Subash");
		driver.findElement(By.id("email")).sendKeys("testerat1229@gmail.com");
		driver.findElement(By.id("password")).sendKeys("A12345678a");
		driver.findElement(By.id("mobileNumber")).sendKeys("7667859310");
		driver.findElement(By.id("signup-btn")).click();


		//Login Guvi test
		driver.findElement(By.id("login-btn")).click();
		driver.findElement(By.id("email")).sendKeys("testerat1229@gmail.com");
		driver.findElement(By.id("password")).sendKeys("A12345678a");
		driver.findElement(By.id("login-btn")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	}
	@BeforeSuite
	public void LaunchingUrl() {

		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@AfterSuite
	public void ClosingSite() {
		driver.close();

	}

}
