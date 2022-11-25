package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MyFirstSeleniumScript4 {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://ineuron-courses.vercel.app/login");
		driver.findElement(By.linkText("New user? Signup")).click();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Harshini");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("harshini@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Harshi@1234");
		//Select interest=new Select(driver.findElement(By.xpath("//label[@class='label-heading']")));
		//intrest.selectByVisibleText(("Testing");	
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("var123");
		driver.findElement(By.xpath("//lable[@contains(text()=testing]")).click();
		driver.findElement(By.xpath("//input[@id='gender']")).click();
		   }


	}
