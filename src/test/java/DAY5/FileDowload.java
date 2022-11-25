package DAY5;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileDowload {
	public static void main(String[] args) {
	

//	ChromeOptions options=new ChromeOptions();
//	options.setHeadless(true);
//	WebDriver driver=new ChromeDriver(options);
//	options.setExperimentalOption("prefs", chromePrefs);
//	WebDriver driver = new ChromeDriver(options);
//	driver.get("https://the-internet.herokuapp.com/download");
//	driver.findElement(By.xpath("//a[text()='Hello World.docx']")).click();
	
	HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
	chromePrefs.put("profile.default_content_settings.popups", 0);
	chromePrefs.put("download.default_directory", System.getProperty("C:\\Users\\harsm\\Downloads"));
	ChromeOptions options = new ChromeOptions();
	options.setExperimentalOption("prefs", chromePrefs);
	WebDriver driver = new ChromeDriver(options);
	driver.get("https://the-internet.herokuapp.com/download");
	driver.findElement(By.xpath("//a[text()='Hello World.docx']")).click();


	
	}

}
