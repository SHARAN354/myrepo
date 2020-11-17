package step_Definitions;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basic {
	public static WebDriver d;
	
	public static Properties property() {
		try
		{
		Properties p = new Properties();
		FileInputStream fi = new FileInputStream(
				"D:\\JavaForTesters_Synechron_11thJuly2018\\Cucumber\\src\\test\\java\\step_Definitions\\variables.properties");
		p.load(fi);
		return p;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	
	public static void reusable(){
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		d.navigate().to(property().getProperty("url"));
		
	}

	
}
