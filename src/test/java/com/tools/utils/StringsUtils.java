package com.tools.utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

import com.test.BaseTest;

public class StringsUtils {

	public static String cleanPrice(String price) {
		String value = "";
		Number decimal = null;
		String language = BaseTest.getLanguage();
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
	
	public static String cleanZeroLeadingStrings(String no) {
		String number = no.trim();
		if(no.startsWith("0")) {
			number = no.substring(1, 2);
		}
		
		return number;
	}
}
