package com.tools.mongo.writer;

import java.net.UnknownHostException;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.tools.constants.ModelConstants;
import com.tools.constants.MongoConstants;
import com.tools.models.CustomerAccountModel;
import com.tools.mongo.MongoConnector;

public class MongoWriter extends MongoConnector{

	public MongoWriter() throws UnknownHostException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void saveGourmondoURL(String url){
		workingDB = mongoClient.getDatabase(MongoConstants.CONFIG);
		MongoCollection<Document> dbCollection = workingDB.getCollection(MongoConstants.GOURMONDO_SHOP);
		Document document = new Document();
		
		document.put(MongoConstants.URL, url);
		dbCollection.insertOne(document);
		
	}
	
	public static void saveBaseTestConfigs(String host, String language){
		workingDB = mongoClient.getDatabase(MongoConstants.CONFIG);
		MongoCollection<Document> dbCollection = workingDB.getCollection(MongoConstants.GOURMONDO_SHOP);
		Document document = new Document();
		
		document.put(MongoConstants.HOST, host);
		document.put(MongoConstants.LANGUAGE, language);
		dbCollection.insertOne(document);		
	}
	
	public static void saveCustomerRegistrationForm(CustomerAccountModel registrationFormModel, String dbName) {
		workingDB = mongoClient.getDatabase(MongoConstants.CUSTOMER_DB);
		MongoCollection<Document> dbCollection = workingDB.getCollection(MongoConstants.CUSTOMER_REGISTRATION_FORM);
		Document document = new Document();
		
		document.put(ModelConstants.SALUTATION, registrationFormModel.getSalutation());
		document.put(ModelConstants.FIRSTNAME, registrationFormModel.getFirstName());
		document.put(ModelConstants.LASTNAME, registrationFormModel.getLastName());
		document.put(ModelConstants.EMAIL_ADDRESS, registrationFormModel.getEmailAddress());
		document.put(ModelConstants.BIRTHDAY_DAY, registrationFormModel.getDay());
		document.put(ModelConstants.BIRTHDAY_MONTH, registrationFormModel.getMonth());
		document.put(ModelConstants.BIRTHDAY_YEAR, registrationFormModel.getYear());
		document.put(ModelConstants.PASSWORD, registrationFormModel.getPassword());
		dbCollection.insertOne(document);
		
	}
}
