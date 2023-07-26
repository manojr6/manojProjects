package orangeHRM;

	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
	public class loginPO {
		
	@FindBy(name="username")	
	public static WebElement usernamePO;

	@FindBy(name="password")	
	public static WebElement passwordPO;

	@FindBy(xpath="//button[@type='submit']")	//button[@type='submit']   //*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button
	public static WebElement loginbutton;
	

	
	
	
	WebDriver driver;
	seleniumImplementation seleniumImplementation= new seleniumImplementation();
	testUtil util=new testUtil();
	
	public boolean validateLogin(String username,String password, WebDriver driver, String expectedURL) throws InterruptedException

	{


		Thread.sleep(5000);		
		PageFactory.initElements(driver, loginPO.class);
		
		seleniumImplementation.setText(usernamePO, username);
		seleniumImplementation.setText(passwordPO, password);
		seleniumImplementation.click(loginbutton);
		
		  String observedURL= seleniumImplementation.getURL(driver);
		  return util.validateText(expectedURL,observedURL);
		 
		
		/*loginPO.usernamePO.sendKeys("Admin");
		loginPO.passwordPO.sendKeys("admin123");
		loginPO.loginbutton.click();*/
		
	}
	
	}
