package november22;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tables {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://www.leafground.com/pages/table.html");
		
		//identifying tables total no.of columns
		List<WebElement> columnsCount = driver.findElements(By.xpath("//table[@id='table_id']//tr/th"));
		System.out.println(" Number of columns in the table :" + columnsCount.size());
		// identifying tables total no.of rows
		List<WebElement> rowCount = driver.findElements(By.xpath("//table[@id='table_id']//tr"));
		System.out.println(" Number of rows in the table :" + rowCount.size());
		//Get the progress value of learn to interact with elements
		String progressValue = driver.findElement(By.xpath("//td[text()='Learn to interact with Elements']/following-sibling::td")).getText();
		System.out.println(" progressValue :" + progressValue);
		
		// Check the vital task for the least completed progress.
		List<Integer> vitalTaskList = new ArrayList<Integer>();
		List<WebElement> progValueList = driver.findElements(By.xpath("//table[@id='table_id']//tr/td[2]"));
		for (int i = 0; i < progValueList.size(); i++) {
			String text = progValueList.get(i).getText();
			
		//	System.out.println(text);
			String replaceAll = text.replaceAll("%", "");
			
		//	System.out.println(replaceAll);
			int parseInt = Integer.parseInt(replaceAll);
			
		//	System.out.println(parseInt);
			vitalTaskList.add(parseInt);
		}
		
		Integer min = Collections.min(vitalTaskList);
		System.out.println(" Minimum value :" + min);
		
		driver.findElement(By.xpath("//td[contains(text(),"+min+")]/following-sibling::td/input")).click();
		
		
			
		
		}

	
		
}
