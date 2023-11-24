package org.test.insureme;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException
    {
    	
    System.out.println("Script Started");	
       //initializing the web driver
   //System.setProperty("webdriver.chrome.driver", "C:\\Users\\DURGA PRASAD\\Desktop\\devops\\softwares\\chromedriver-win64\\chromedriver2\\chromedriver.exe");
    WebDriverManager.chromedriver().setup();
    //setting properties
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("--headless");
    // open url
    System.out.println("Driver opening up the url in browser");	
    WebDriver driver = new ChromeDriver(chromeOptions);
    driver.get("http://34.227.99.99:8081/contact.html");	
    
    //invole implicit waits to load the page
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    
    System.out.println("Enter details in the form");
    //enter details
    //input name
   driver.findElement(By.name("your_name")).sendKeys("Prasad");
    Thread.sleep(1000);
      driver.findElement(By.name("phone_number")).sendKeys("9999999999");
    Thread.sleep(1000);
    
    driver.findElement(By.name("email_address")).sendKeys("prasad@xyz.com");
    Thread.sleep(1000);
    
    driver.findElement(By.name("your_message")).sendKeys("hello from prasad");
    Thread.sleep(1000);

    driver.findElement(By.id("my-button")).click();
    Thread.sleep(1000);
    
    
    String response = driver.findElement(By.id("response")).getText();
   
    System.out.println(response);
    
    System.out.println("test scripts executed");
    
    TakesScreenshot scrShot = ((TakesScreenshot)driver);
    System.out.println("Taking Screeshot");
    File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
    
  //  File destFile = new File("/user/durga prasad/desktop/test-reports.jpg");
    File destFile = new File("/var/lib/jenkins/workspace/insure-me-test-scripts/test-reports.jpg");
    
    
    FileUtils.copyFile(srcFile, destFile);
    
    Thread.sleep(1000);
    System.out.println("test-reported generated");
 
   
    driver.quit();
   System.out.println("Test Case execution completed"); 
    
    	
    	
    	
     
    }
}
