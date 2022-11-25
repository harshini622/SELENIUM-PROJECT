package DAY5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/upload");
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.id("file-uploaded"))).click().perform();
		Thread.sleep(3000);
		//Runtime.getRuntime().exec("C:\\Users\\harsm\\Desktop\\1stpgm.au3");

	}

}
