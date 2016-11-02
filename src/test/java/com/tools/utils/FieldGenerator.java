package com.tools.utils;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.mifmif.common.regex.Generex;

public class FieldGenerator {
	
	public static enum TypeOfString {
		ALPHA_CAPS, ALPHA, ALPHANUMERIC, NUMERIC, ALPHANUMERICSCHAR,EMAIL,
	}
	
	public static String generateStringValue(int lenght, TypeOfString type){
		
		String value = "";
		
			switch(type){
			
				case ALPHA_CAPS:
					value = "[A-Z]{" + lenght + "}";
					break;
					
				case ALPHA:
					value = "[A-Za-z]{" + lenght + "}";
					break;
				
				
				case NUMERIC:
					value = "[0-9]{" + lenght + "}";
					break;
					
				case ALPHANUMERIC:
					value = "[0-9a-zA-Z]{" + lenght + "}";
					break;
					
				case ALPHANUMERICSCHAR:
					value = "[^0-9a-zA-Z]{" + lenght + "}";
					break;
					
				case EMAIL:
					value = "[0-9a-z]{" + lenght + "}" ;
					
					break;
		}
		Generex generex = new Generex(value);
		value = generex.random();
		
		return value;
	}

	public static int generateIntValue(int lenght){
		int random;
		Generex generex = new Generex("[0-9]{" + lenght + "}");
		random = Integer.parseInt(generex.random());
		
		return random;
	}
	
	public static GregorianCalendar getRandomDate() {
		  	GregorianCalendar gc = new GregorianCalendar();

		  		//set random year
		        int year = randBetween(1926, 1997);
		        gc.set(Calendar.YEAR, year);

		        //set random day of year
		        int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
		        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
		       
		        return gc;
		    }
	public static int randBetween(int start, int end) {
		return start + (int)Math.round(Math.random() * (end - start));
		    }
}
