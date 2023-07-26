package orangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class seleniumImplementation implements seleniumInterface {

	public void setText(WebElement element, String text) {
		// TODO Auto-generated method stub
		element.sendKeys(text);
	}

	public void click(WebElement element) {
		// TODO Auto-generated method stub
		element.click();
	}

	public String getTitle(WebDriver driver) {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}

	public String getURL(WebDriver driver) {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl();
	}

}
