package com.py.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;

public class StringUtils {

	private static final Map<String, String> languageMap = new HashMap<>();

	static {
		Properties properties = new Properties();
		try {
			// properties.load(new
			// FileInputStream("language/mapping.properties"),"UTF-8");
//			properties.load(new InputStreamReader(new FileInputStream("language/mapping.properties"), "UTF-8"));
//			InputStream  inputStream = StringUtils.class.getResourceAsStream("classpath:language/mapping.properties");
			InputStream  inputStream = StringUtils.class.getResourceAsStream("/language/mapping.properties");
			
			BufferedReader bReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			String line = null;
			while ((line = bReader.readLine()) != null) {
				String[] array = line.split("\\s*=\\s*");
				String strKey = org.apache.commons.lang3.StringUtils.trim(array[0]);
				String strValue = org.apache.commons.lang3.StringUtils.trim(array[1]);
				// System.out.println(strKey + "=" + strValue);
				languageMap.put(strKey, strValue);
				
			}
//			List<String> list = FileUtils.readLines(ResourceUtils.getFile("classpath:language/mapping.properties"), "UTF-8");
//			for (String string : list) {
//				String[] array = string.split("\\s*=\\s*");
//				String strKey = org.apache.commons.lang3.StringUtils.trim(array[0]);
//				String strValue = org.apache.commons.lang3.StringUtils.trim(array[1]);
//				// System.out.println(strKey + "=" + strValue);
//				languageMap.put(strKey, strValue);
//			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public static String lower(String str) {

		if (str == null) {
			return str;
		}
		return str.toLowerCase();
	}

	public static String convert(String str) {

		if (str == null) {
			return str;
		}
		String result = languageMap.get(str);
		return result == null ? str : result;
	}

	public static void main(String[] args) {

		System.out.println(languageMap);
	}

}
