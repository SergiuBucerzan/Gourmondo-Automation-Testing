package com.pages.frontend;

import com.tools.constants.GmailConstants;
import com.tools.gmail.GmailConnector;
import com.tools.models.extern.EmailModel;

public class TestAnything {

	public static void main(String[] args) {
		EmailModel emailModel = new EmailModel();
		
		emailModel.setImapGmailCom(GmailConstants.IMAP_GMAIL);
		emailModel.setImaps(GmailConstants.IMAPS);
		emailModel.setMailStoreProtocol(GmailConstants.MAIL_STORE_PROTOCOL);
		emailModel.setPassword(GmailConstants.PASSWORD);
		emailModel.setEmailAddress(GmailConstants.EMAIL);
		
		GmailConnector connector = new GmailConnector(emailModel);
		String text = connector.searchEmail("info@gourmondo.de", "Mitteilung von www.gourmondo.de");
		//String link = connector.getLinkFromEmail(text, "border-radius: 5px;\" href=\"", "\">PASSWORT");
		System.out.println(text);

	}

}
