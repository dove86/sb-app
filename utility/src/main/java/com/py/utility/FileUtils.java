package com.py.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class FileUtils {

	public static List<String> readFromClassPath(String relativePath,Charset charset){
		List<String> list = null;
		InputStream inputStream = null;
		BufferedReader bufferedReader = null;
    	try {
			inputStream = ResourceLoader.loadFromClassPath(relativePath);
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream, charset));
			list = new ArrayList<>();
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				list.add(line);
				
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
    	finally {
    		IOUtils.closeQuietly(bufferedReader);
			IOUtils.closeQuietly(inputStream);
		}
    	
    	return list;
	}
	public static List<String> readFromClassPath(String relativePath){
		return readFromClassPath(relativePath, Charset.forName("UTF-8"));
	}
}
