package com.tools.utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import com.tools.mongo.reader.MongoReader;

public class StringUtils {

	public static String cleanPrice(String price) {
		String value = "";
		Number decimal = null;
		String language = MongoReader.getLanguage();
		String priceFormated = price.replaceAll("[^\\d\\.\\,]", "");

		if (language.contentEquals("en")) {
			NumberFormat nf = NumberFormat.getInstance(Locale.ENGLISH);
			try {
				decimal = nf.parse(priceFormated);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (language.contentEquals("de")) {
			NumberFormat nf = NumberFormat.getInstance(Locale.GERMAN);
			try {
				decimal = nf.parse(priceFormated);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		value = String.valueOf(decimal.doubleValue());
		
		return value;
	}
}
