package zOwnProject;

import java.time.Duration;
import java.util.function.ToIntFunction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.ToString;

public class Assignments {

	public static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		   WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get("https://timesofindia.indiatimes.com/poll.cms");
			String bothNumbers = driver.findElement(By.xpath("//span[@id='mathq2']")).getText();
		    System.out.println("Total string length = "+bothNumbers.length());
			
			System.out.println(bothNumbers);
		    String Num1 = bothNumbers.substring(0, 1);
		    System.out.println("First Number = "+ Num1);
		    
		    String Num2 = bothNumbers.substring(4, 5);	
		    System.out.println("Second Number = "+ Num2);
		    int total = Integer.parseInt(Num1) + Integer.parseInt(Num2);  		    
		    driver.findElement(By.xpath("//input[@id='mathuserans2']")).sendKeys(Integer.toString(total));
		    
	}
}
