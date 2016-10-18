package com.tools.utils;

public class StringUtils {

	public static String cleanPrice(String price) {
		String value = "";
		value = price.replaceAll("[^\\d,]", "").replaceAll("[,]", ".");
		
		return value;
	}
}
