package com.pages.frontend;

import com.tools.gmail.GmailConnector;

public class TestAnything {

	public static void main(String[] args) {
		GmailConnector connector = new GmailConnector();
		String text = connector.searchEmail("info@gourmondo.de", "Mitteilung von www.gourmondo.de");
		String link = connector.getLinkFromEmail(text, "border-radius: 5px;\" href=\"", "\">PASSWORT");
		System.out.println(link);

	}

}
