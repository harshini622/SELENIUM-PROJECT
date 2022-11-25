package DAY2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAutoSuggestions {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
        driver.findElement(By.xpath("//input[@id='datepicker']")).click();
        driver.findElement(By.xpath("//td//a[contains(text(),'25')]")).click();
        
        driver.findElement(By.xpath("//input[@id='datepicker']")).click();
        List<WebElement> allElements=driver.findElements(By.xpath("//table[contains(@class,'calendar')]//td//a"));
        for(WebElement e: allElements) {
            System.out.println(e.getText());
             
        }
        }

	}

