package orangeHRM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class loginOrangeHRM1  {



	String [][] data=null;
	WebDriver driver;
	loginPO page1;
	//seleniumImplementation seleniumImplementation = new seleniumImplementation();

	@DataProvider(name="loginData")
	public String[][] loginDataProvider() throws BiffException, IOException{

		data = getExcelData1();
		return data;
	}

	public String[][] getExcelData() throws BiffException, IOException {
		FileInputStream excel = new FileInputStream("E:\\sample data.xls");
		Workbook workbook = Workbook.getWorkbook(excel);
		

		Sheet sheet = workbook.getSheet(0);
		int rowCount = sheet.getRows();
		int columnCount = sheet.getColumns();

		String testdata[][] = new String[rowCount-1][columnCount];
		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<columnCount;j++) {
				testdata[i-1][j]=sheet.getCell(j,i).getContents();
			}
		}




		return testdata;
	}
	
	
	public String[][] getExcelData1() throws IOException 
	{
		//String fileLocation="E:\\\\sample data.xls";
		FileInputStream excel = new FileInputStream("E:\\sample data.xls");
		HSSFWorkbook workbook=new HSSFWorkbook(excel);
		HSSFSheet sheet= workbook.getSheetAt(0);
		int lastRowNo= sheet.getLastRowNum();
		short lastCellNo= sheet.getRow(0).getLastCellNum();
		System.out.println(lastRowNo);
		System.out.println(lastCellNo);
		
		String[][] data= new String[lastRowNo][lastCellNo];
		
		for (int i = 1; i <= lastRowNo; i++) {
			HSSFRow row = sheet.getRow(i);
		
		for (int j = 0; j < lastCellNo; j++) 
		{
			HSSFCell cell = row.getCell(j);
			DataFormatter format=new DataFormatter();
			String value= format.formatCellValue(cell);
			data[i-1][j]=value;
		}
		
		}
		workbook.close();
		return data;
	}

	@BeforeTest
	public void beforeTest() throws IOException
	{
		//System.setProperty("webdriver.http.factory", "jdk-http-client");
		FileInputStream stream= new FileInputStream("config.properties");
		Properties properties= new  Properties();
		properties.load(stream);
		String browser=properties.getProperty("browser");
		String driverLocation=properties.getProperty("DriverLocation");
		
		
		if(browser.equalsIgnoreCase("Chrome")) 
		 {
		System.setProperty("webdriver.chrome.driver",driverLocation);
		driver = new ChromeDriver();
		page1 = new loginPO();
		String url=properties.getProperty("url");
		driver.get(url);
		}
		
	}
	
	@Test
	
	(dataProvider="loginData")

	//public void login3(String uname,String pword) throws InterruptedException
	/*
	 * public void login3() throws InterruptedException
	 * 
	 * {
	 * 
	 * 
	 * 
	 * 
	 * Thread.sleep(10000); PageFactory.initElements(driver, loginPO.class);
	 * 
	 * loginPO.username.sendKeys("Admin"); loginPO.password.sendKeys("admin123");
	 * loginPO.loginbutton.click();
	 * 
	 * }
	 */

	public void verifyLogin(String uname,String pword) throws InterruptedException
	{
		//Thread.sleep(5000);		
		//page1.validateLogin(uname, pword, driver);

		Assert.assertTrue(page1.validateLogin(uname, pword, driver, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));
	}
	

		 
		


	@AfterTest
	public void afterTest() throws InterruptedException {
		System.out.println("back to normal1");
		driver.quit(); 
	}

}









