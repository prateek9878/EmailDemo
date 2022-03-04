package com.demo.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigData {

	public Properties prop;

	public ConfigData() {
		File src = new File(System.getProperty("user.dir") + "/TestData/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			throw new AssertionError(e.getMessage());
		}
	}

}
