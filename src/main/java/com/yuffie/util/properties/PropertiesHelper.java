package com.yuffie.util.properties;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 配置文件读取
 * 
 * @author Yuffie
 *
 */
public class PropertiesHelper {
	/**
	 * 获取配置文件
	 * 
	 * @param filename
	 * @return Properties
	 */
	public static Properties getProperties(String filename) {
		try {
			InputStream in = null;
			Properties property = new Properties();
			in = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(filename);
			BufferedReader bf = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			property.load(bf);
			in.close();
			return property;
		} catch (Exception e) {
			// TODO add log here
			return null;
		}
	}
}
