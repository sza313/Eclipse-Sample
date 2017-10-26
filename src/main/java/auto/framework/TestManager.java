package auto.framework;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class TestManager {

	public static String getBrowser() throws Exception{
		File src = new File("./src/test/resources/config.properties");
		FileInputStream fis = new FileInputStream(src);
		
		Properties property = new Properties();
		property.load(fis);
		
		String browser = property.getProperty("browser");
		System.out.println("Browser: " + browser);
		
		return browser;	
	}
	
	public static String getChromeDriverPath() throws Exception{
		File src = new File("./src/test/resources/config.properties");
		FileInputStream fis = new FileInputStream(src);
		
		Properties property = new Properties();
		property.load(fis);
		
		String chrDrPath = property.getProperty("chromeDriverPath");
		
		return chrDrPath;	
	}
	
	public static String getScreenshotPath() throws Exception{
		File src = new File("./src/test/resources/config.properties");
		FileInputStream fis = new FileInputStream(src);
		
		Properties property = new Properties();
		property.load(fis);
		
		String screenshotPath = property.getProperty("ssPath");
		
		return screenshotPath;		
	}
	
	public static String getDataPath() throws Exception{
		File src = new File("./src/test/resources/config.properties");
		FileInputStream fis = new FileInputStream(src);
		
		Properties property = new Properties();
		property.load(fis);
		
		String dataPath = property.getProperty("dataPath");
		
		return dataPath;		
	}
	
	public static Integer getImplicitWait() throws Exception{
		File src = new File("./src/test/resources/config.properties");
		FileInputStream fis = new FileInputStream(src);
		
		Properties property = new Properties();
		property.load(fis);
		
		String waitTime = property.getProperty("wait");	
		int wait = Integer.parseInt(waitTime);
		
		return wait;		
	}
	
	public static String getReportPath() throws Exception{
		File src = new File("./src/test/resources/config.properties");
		FileInputStream fis = new FileInputStream(src);
		
		Properties property = new Properties();
		property.load(fis);
		
		String reportPath = property.getProperty("reportPath");	
		
		return reportPath;		
	}
	
public static class Preferences {
		
		// envi > testng > config > default

		public static String getPreference(String property){
			return getPreference(property, null);
		}
		
		public static String getPreference(String property, String defaultValue){

			if( System.getProperties().containsKey( "env."+property ) ){
				return System.getProperty( "env."+property );
			}
			if( System.getProperties().containsKey(property) ){
				return System.getProperty( property );
			}

			if( System.getenv().containsKey( property ) ){
				return System.getenv( property );
			}
			return defaultValue;
		}
		
		private static String readConfig(String property) {
			String configPath = "./src/test/resources/config.properties";
			File configFile = new File( configPath );
			if(configFile.exists()){
				try {
					FileInputStream fileInput = new FileInputStream(configFile);
					Properties properties = new Properties();
					properties.load(fileInput);
					return properties.getProperty(property);
				} catch (Exception e) {
				}
			}
			return null;
		}
		
	}
}