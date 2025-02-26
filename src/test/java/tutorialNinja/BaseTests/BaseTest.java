package tutorialNinja.BaseTests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
	 public  WebDriver driver;
	public String alphaNum;
	public Logger logger;
	public Properties prop;
	FileInputStream fis;
	String br;

	@BeforeMethod(alwaysRun = true)
	//@Parameters({ "browser" })
	//public void setup(String br) throws IOException {
		public void setup() throws IOException {
		prop = new Properties();
		fis = new FileInputStream("./src//test//resources//data.properties");
		prop.load(fis);
		 br=System.getProperty("browser")!=null ? System.getProperty("browser"):prop.getProperty("browser");

		logger = LogManager.getLogger(this.getClass());
		logger.info("***Driver Setup ***");
		if(br.contains("chrome")) {
			ChromeOptions options=new ChromeOptions();
			if(br.contains("headless")){
			options.addArguments("headless");}
			driver = new ChromeDriver(options);
		}else if (br.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();	
		}else if (br.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else {
			System.out.println("Browser Does not exist");	
		}
		/*switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Browser Does not exist");
			return;
		}*/

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		// driver.get("https://tutorialsninja.com/demo/");
		driver.get(prop.getProperty("baseUrl"));
		driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

	public String getRandomAlphabet() {
		return RandomStringUtils.randomAlphabetic(8);
	}

	public String getRandomNumber() {
		return RandomStringUtils.randomNumeric(10);
	}

	public String getRandomPassword() {
		return alphaNum = RandomStringUtils.randomAlphanumeric(8);
	}
	
	public String getScreenshot(String methodName) throws IOException {
		String currentTimeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+methodName+"_"+currentTimeStamp+".png";
		File targetFile=new File(targetFilePath);
		FileUtils.copyFile(srcFile, targetFile);
		return targetFilePath; 
	}
}
