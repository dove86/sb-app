package com.py.utility;

import java.io.InputStream;

public class ResourceLoader {

	public static InputStream loadFromClassPath(String path) {

		return ResourceLoader.class.getResourceAsStream("/" + path);
//		return ResourceLoader.class.getClassLoader().getResourceAsStream("/" + path);
	}
}
