package Day1;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFirstSeleniumScript {



   public static void main(String[] args) {
        
        EdgeDriver driver=new EdgeDriver();
        driver.get("http://microsoftedge.com");
        driver.findElement(By.name("q")).sendKeys("Harshini");
        String title=driver.getTitle();
        System.out.println("Title is "+title);
        String url=driver.getCurrentUrl();
        System.out.println("Url is "+url);
        //driver.quit();
        }



}
