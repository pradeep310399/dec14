package december14;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobilebackcase for pocox2",Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='Amazon Brand - Solimo']")).click();
		List<WebElement> Brand = driver.findElements(By.xpath("//span[text()='Amazon Brand - Solimo']"));
		Brand.size();
	    System.out.println(Brand.size());
	    driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[3]")).click();
	    //WINDOW HANDLING
	    Set<String> win = driver.getWindowHandles();
	    List<String>Mobile = new ArrayList<String>(win);
	    driver.switchTo().window(Mobile.get(1));
	    driver.findElement(By.xpath("(//div[@id='imgTagWrapperId' or @class='imgTagWrapper'])[1]"));
	    //to take the screenshot
	    File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
	    File target = new File("./report/img.png");	
	    FileUtils.copyFile(screenshotAs, target);
	    System.out.println("CLICKED SNAPSHOT");
	    
	    driver.quit();
	    
		
		
	}

}
