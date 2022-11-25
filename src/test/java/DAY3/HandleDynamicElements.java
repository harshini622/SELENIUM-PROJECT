package DAY3;

import java.time.Duration;
import java.util.Set;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HandleDynamicElements {



   public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://ineuron-courses.vercel.app/login\r\n");
        String parent=driver.getWindowHandle();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        
       driver.findElement(By.name("email1")).sendKeys("ineuron@ineuron.ai");
        driver.findElement(By.name("password1")).sendKeys("ineuron");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Actions action = new Actions(driver);
        WebElement ele=driver.findElement(By.xpath("//span[text()='Manage']"));
        action.moveToElement(ele).perform();
        
       driver.findElement(By.xpath("//span[text()='Manage Categories']")).click();
        Set<String> childs=driver.getWindowHandles();
        for(String c:childs) {
            if(!c.equals(parent)) {
                driver.switchTo().window(c);
                Thread.sleep(5000);
                driver.findElement(By.xpath("//button[text()='Add New Category ']")).click();
                WebDriverWait wb=new WebDriverWait(driver,Duration.ofSeconds(10));
                Alert alters=wb.until(ExpectedConditions.alertIsPresent());
                driver.switchTo().alert().sendKeys("SwitchTbas");
                alters.accept();
                driver.findElement(By.xpath("//td[text()='SwitchTbas']//following::td[1]")).click();
                driver.switchTo().alert().accept();
                driver.findElement(By.xpath("//button[text()='Delete']")).click();
          
                }            
        }
        
    
        
        
        




    }



}