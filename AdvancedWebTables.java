package december14;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdvancedWebTables {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://www.leafground.com/pages/sorttable.html");
		
		List<String>names = new ArrayList<String>();
		List<String>names2 = new ArrayList<String>();
		List<WebElement> findElements = driver.findElements(By.xpath("//table[@id='table_id']/tbody/tr"));
		int size = findElements.size();
		
			for (int i = 1; i <= size; i++) {
				String text = driver.findElement(By.xpath("//table[@id='table_id']/tbody/tr["+i+"]/td[2]")).getText();
			    names.add(text);
			  //table[@id='table_id']/tbody/tr["+i+"]/td[2]
				
		}
			Collections.sort(names);
		
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//th[text()='Name']")).click(); for (int i = 1;
		  i <= size; i++) { String text2 =
		  driver.findElement(By.xpath("//table[@id='table_id']/tbody/tr["+i+"]/td[2]")).getText();
		  names2.add(text2); }
		 
				
		  System.out.println(names);
		
		  System.out.println(names2); 
		  if (names.equals(names2)) {
		  System.out.println("success"); 
		  } else { System.out.println("failed");
		  
		  }
		 

		
	}
	
	
}
