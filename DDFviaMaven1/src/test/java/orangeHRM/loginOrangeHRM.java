package orangeHRM;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class loginOrangeHRM {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream stream= new FileInputStream("config.properties");
		Properties properties= new  Properties();
		properties.load(stream);
		String browser=properties.getProperty("browser");
		String driverLocation=properties.getProperty("DriverLocation");
		String url=properties.getProperty("url");
		System.setProperty("webdriver.chrome.driver",driverLocation);
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		Thread.sleep(5000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		
		//driver.quit();

	}
}
	

