package orangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface seleniumInterface 

{
public void setText(WebElement element,String text);
public void click(WebElement element);
public String getTitle(WebDriver driver);
public String getURL(WebDriver driver);
}