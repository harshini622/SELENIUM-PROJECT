package DAY2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlterElements {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2019/01/alert-demo.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert e= wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(2000);
		String msg = null;
			try 
			{
			if(msg.contains("Welcome to Selenium WebDriver Tutorials")) {
				System.out.println("sucesss");
			}else{
				System.out.println("Waiting for WebElement");
				Thread.sleep(1000);
			}
		}catch(Exception e1) {
			System.out.println("failed");
		}
		e.accept();
	}

}
