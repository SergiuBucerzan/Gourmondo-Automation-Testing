package com.pages.frontend;

import com.tools.constants.JavaMailAPIConstants;
import com.tools.email.JavaMailAPIConnector;

public class TestAnything {

	public static void main(String[] args) {
		JavaMailAPIConnector emailConnector = new JavaMailAPIConnector(JavaMailAPIConstants.MAIL_STORE_PROTOCOL, JavaMailAPIConstants.IMAPS, JavaMailAPIConstants.IMAP_GMAIL, "gourmondoevotest@gmail.com", "Gourmondo.test");
		String text = emailConnector.searchEmail("info@gourmondo.de", "www.gourmondo.de - erfolgreiche Registrierung als Kunde");
		//String link = emailConnector.getLinkFromEmail(text, "border-radius: 5px;\" href=\"", "\">PASSWORT");
		//String text = emailConnector.searchEmail("ciprian.mocian@evozon.com", "testest");
		System.out.println(text);

	}

}
