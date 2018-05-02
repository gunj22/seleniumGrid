package TestCases;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.filefilter.TrueFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Google_Search {
	
	//@Parameters("browser")
	@Test(dataProvider="getData")
	public void search(/*String b*/ String u,String p, String b) throws MalformedURLException {
		
		//DesiredCapabilities cap = new DesiredCapabilities();
		DesiredCapabilities cap = null;				
		if(b.equals("chrome")){	
		cap = DesiredCapabilities.chrome();
		cap.setBrowserName("chrome"); //chrome,iexplore
		cap.setJavascriptEnabled(true);
		cap.setPlatform(Platform.WINDOWS);
		}else if (b.equals("firefox")){
			cap =DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			//cap.setJavascriptEnabled(true);
			cap.setPlatform(Platform.ANY);		
			
		}
		
		
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		
		driver.get("https://facebook.com/");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(u);
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys(p);
		
		
		
		driver.quit();
		
		
	}
	
	@DataProvider(parallel=true)
	public Object[][] getData(){
		
		
		Object data[][] = new Object[4][3];
		
		data[0][0]="u1";
		data[0][1]="p1";
		data[0][2]="firefox";
		
		
		data[1][0]="u2";
		data[1][1]="p2";
		data[1][2]="chrome";
		
		data[2][0]="u1";
		data[2][1]="p1";
		data[2][2]="firefox";
		
		
		data[3][0]="u2";
		data[3][1]="p2";
		data[3][2]="chrome";
		
		
		return data;
	}
	
	
}
