package com.py.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ResourceLoader {

	/**
	 * relativePath class path relative path
	 * 
	 * @param relativePath
	 * @return
	 */
	public static InputStream loadFromClassPath(String relativePath) {

		return ResourceLoader.class.getResourceAsStream("/" + relativePath);
		// return ResourceLoader.class.getClassLoader().getResourceAsStream("/"
		// + path);
	}

	public static InputStream load(String path) {

		try {
			return new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		InputStream inputStream = load("relatvie/mapping.properties");
		System.out.println(inputStream);
	}
}
