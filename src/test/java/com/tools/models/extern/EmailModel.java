package com.tools.models.extern;

public class EmailModel {

	private String mailStoreProtocol = "";
	private String imaps = "";
	private String imapGmailCom = "";
	private String emailAddress = "";
	private String password = "";
	
	public String getMailStoreProtocol() {
		return mailStoreProtocol;
	}
	public void setMailStoreProtocol(String mailStoreProtocol) {
		this.mailStoreProtocol = mailStoreProtocol;
	}
	public String getImaps() {
		return imaps;
	}
	public void setImaps(String imaps) {
		this.imaps = imaps;
	}
	public String getImapGmailCom() {
		return imapGmailCom;
	}
	public void setImapGmailCom(String imapGmailCom) {
		this.imapGmailCom = imapGmailCom;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
