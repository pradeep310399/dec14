package december14;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.leafground.com/pages/selectable.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement source = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement target = driver.findElement(By.xpath("//li[text()='Item 4']"));
		Actions builder = new Actions(driver);
		builder.click().dragAndDrop(source, target).perform();
	
}
	
}


