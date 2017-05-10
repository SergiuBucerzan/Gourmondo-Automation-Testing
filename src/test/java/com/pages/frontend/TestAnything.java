package com.pages.frontend;

import java.util.Properties;

import com.tools.constants.JavaMailAPIConstants;
import com.tools.email.JavaMailAPIConnector;

public class TestAnything {

	public static void main(String[] args) {
		JavaMailAPIConnector emailConnector = new JavaMailAPIConnector(JavaMailAPIConstants.MAIL_STORE_PROTOCOL, JavaMailAPIConstants.IMAPS, JavaMailAPIConstants.IMAP_GMAIL, "ciprian.mocian@gmail.com", "No.Smoking.3");
		String text = emailConnector.searchEmail("info@gourmondo.de", "Mitteilung von www.gourmondo.de");
		//String link = emailConnector.getLinkFromEmail(text, "border-radius: 5px;\" href=\"", "\">PASSWORT");
		//String text = emailConnector.searchEmail("ciprian.mocian@evozon.com", "testest");
		
		System.out.println(text);

	}

}
