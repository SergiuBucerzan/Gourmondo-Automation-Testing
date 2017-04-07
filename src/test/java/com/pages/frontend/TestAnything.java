package com.pages.frontend;

import com.tools.constants.JavaMailAPIConstants;
import com.tools.gmail.JavaMailAPIConnector;

public class TestAnything {

	public static void main(String[] args) {
		JavaMailAPIConnector emailConnector = new JavaMailAPIConnector(JavaMailAPIConstants.IMAP_GMAIL, JavaMailAPIConstants.IMAPS, JavaMailAPIConstants.MAIL_STORE_PROTOCOL, JavaMailAPIConstants.EMAIL, JavaMailAPIConstants.PASSWORD);
		String text = emailConnector.searchEmail("info@gourmondo.de", "Mitteilung von www.gourmondo.de");
		String link = emailConnector.getLinkFromEmail(text, "border-radius: 5px;\" href=\"", "\">PASSWORT");
		System.out.println(link);

	}

}
