package com.tools.gmail;

import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;

import com.tools.constants.GmailConstants;

public class GmailConnector {

	private String mailStoreProtocol = "";
	private String imaps = "";
	private String imapGmailCom = "";
	private String emailAddress = "";
	private String password = "";
	
	public GmailConnector() {
		mailStoreProtocol = GmailConstants.MAIL_STORE_PROTOCOL;
		imaps = GmailConstants.IMAPS;
		imapGmailCom = GmailConstants.IMAP_GMAIL;
		emailAddress = GmailConstants.EMAIL;
		password = GmailConstants.PASSWORD;
	}
	
	public String getLinkFromEmail(String emailtext, String begin, String end) {
		String value = "";
		
		Pattern pattern = Pattern.compile(begin + "(.*?)" + end);
		Matcher matcher = pattern.matcher(emailtext);
		if (matcher.find()) {
			value = matcher.group(1).trim();
		}else
			System.out.println("String doesn't match the pattern");
		
		return value;
	}
	
	// search for a specific email 
	public String searchEmail(String emailAddressFrom, String subject) {
		String emailText = "";
		Message[] message = getEmails();
		boolean messageReceived = false;
		
		outerloop:
		for (int i = 0; i < message.length; i++) {
			try {
				Address[] addresses =  message[i].getFrom();
	
			    for (Address address : addresses) {
	
			    	if (address.toString().contains(emailAddressFrom) && !(message[i].isSet(Flags.Flag.SEEN))
								&& message[i].getSubject().contains(subject)) {
							emailText = getTextFromMessage(message[i]);
							messageReceived = true;
							break outerloop;		
			    	}
					
				} 
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(!messageReceived) {
			System.out.println("Message was not received.");
		}

		return emailText;
	}

	//retrieve content
	private String getTextFromMessage(Message message) throws MessagingException, IOException {
		String emailText = "";
		if (message.isMimeType("text/plain")) {
			emailText = message.getContent().toString();
		} else if(message.isMimeType("multipart/*")) {
			MimeMultipart mimeMultiPart = (MimeMultipart) message.getContent();
			emailText = getTextFromMultiPart(mimeMultiPart);
		}

		return emailText;
	}

	//retrieve multipart content
	private String getTextFromMultiPart(MimeMultipart mimeMultiPart) throws MessagingException, IOException {
		String emailText = "";
		int count = mimeMultiPart.getCount();
		for (int i = 0; i < count; i++) {
			BodyPart bodyPart = mimeMultiPart.getBodyPart(i);
			if (bodyPart.isMimeType("text/plain")) {
				emailText = emailText + "\n" + bodyPart.getContent();
				break;
			} else if (bodyPart.isMimeType("text/html")) {
				String html = (String) bodyPart.getContent().toString();
				emailText = emailText + "\n" + org.jsoup.Jsoup.parse(html);
				System.out.println(emailText);
			} else if (bodyPart.getContent() instanceof MimeMultipart) {
				emailText = emailText + getTextFromMultiPart((MimeMultipart) bodyPart.getContent());
			}
		}

		return emailText;
	}

	//connecting to gmail inbox
	private Message[] getEmails() {
		Properties props = System.getProperties();
		props.setProperty(mailStoreProtocol, imaps);

		Session session = Session.getDefaultInstance(props, null);
		Message[] messages = null;
		try {
			Store store = session.getStore(imaps);
			store.connect(imapGmailCom, emailAddress, password);

			Folder folder = store.getFolder("INBOX");
			folder.open(Folder.READ_WRITE);
			messages = folder.getMessages();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return messages;

	}
}
