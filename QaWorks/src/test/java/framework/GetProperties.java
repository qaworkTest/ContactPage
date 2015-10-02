package framework;

import java.io.FileInputStream;
import java.util.Properties;

public class GetProperties {
	private static Properties prop;
	private static String environment;


 	public static String getProperty(String desiredValue) {
 		if (prop == null)
 			getEnvironment();
 		return prop.getProperty(desiredValue);
 	}

	private static void getEnvironment() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(getPropertiesPath()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String getPropertiesPath() {
		if (environment == null)
			if (System.getProperty("environment") == null)
				environment = "staging";
			else
				environment = System.getProperty("environment");
		return "src\\test\\resources\\" + environment + ".properties";
	}

	public static void setEnvironment(String env) {
		environment = env;
	}
}
