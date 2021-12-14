package december14;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VitalTask {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table_id']//tr"));
		int totalRow = rows.size();

		String value = driver.findElement(By.xpath("//td[text()='Learn to interact with Elements']/following-sibling::td")).getText();
		//String value = driver.findElement(By.xpath("//table[@id='table_id']//tr[3]/td[2]")).getText();
		System.out.println("Progress value of 'Learn to Interact with elements' " + value);

		List<Integer> progress = new ArrayList<Integer>();

		for (int i = 2; i <= totalRow; i++)

		{
			String progressValue = driver.findElement(By.xpath("//table[@id='table_id']//tr[" + i + "]/td[2]")).getText();
			String newValue = progressValue.replaceAll("[%]", "");
			int parseInt = Integer.parseInt(newValue);

			progress.add(parseInt);
		}

		
		Collections.sort(progress);
		System.out.println(progress);
		
		Integer a = progress.get(0);
		driver.findElement(By.xpath("//td[text()='"+a+"%']/following-sibling::td/input")).click();
		System.out.println("Least progress value is checked");

		// Check the vital task for the least completed progress

		/*
		 * int input = newList.get(0);
		 * driver.findElement(By.xpath("//td[contains(text(),'" + input +
		 * "')]/following::input")).click();
		 */
	}



	}


