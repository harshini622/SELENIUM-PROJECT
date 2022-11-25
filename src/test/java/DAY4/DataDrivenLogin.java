package DAY4;

import java.time.Duration;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;



public class DataDrivenLogin {
    ChromeDriver driver;
    @BeforeMethod
    public void setup() {
        driver= new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        driver.get("https://ineuron-courses.vercel.app/login");
        
    }
    @AfterMethod
    public void Clearup() {
        driver.quit();
    }
    @Test(dataProvider="TestData")
    public void Test(String s1,String s2) {
//        ChromeDriver driver= new ChromeDriver();
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
//        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
//        driver.get("https://ineuron-courses.vercel.app/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.name("email1")).sendKeys(s1);
        driver.findElement(By.id("password1")).sendKeys(s2);    
        driver.findElement(By.className("submit-btn")).click();
        AssertJUnit.assertEquals(driver.findElement(By.xpath("//button[normalize-space()='Sign out']")).isDisplayed(), true);
    }
    @DataProvider(name="TestData")
    public Object[][] testData(){
        Object [][]arr=new Object[4][2];
        arr[0][0]="sample9@gmail.com";
        arr[0][1]="Mukesh1234";
        arr[1][0]="samplemukesh@gmail.com";
        arr[1][1]="Mukesh1234";
        arr[2][0]="samplemukesh1@gmail.com";
        arr[2][1]="Mukesh1234";
        arr[3][0]="samplemukesh2@gmail.com";
        arr[3][1]="Mukesh1234";
        
        
        return arr;
        
    }



}
