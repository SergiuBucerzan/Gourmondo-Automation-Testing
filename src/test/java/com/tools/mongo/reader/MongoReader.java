package com.tools.mongo.reader;

import java.net.UnknownHostException;

import org.bson.Document;

import com.mongodb.client.MongoCursor;
import com.tools.constants.ModelConstants;
import com.tools.constants.MongoConstants;
import com.tools.models.frontend.CustomerAccountModel;
import com.tools.models.hmc.HmcCustomerAccountModel;
import com.tools.mongo.MongoConnector;

public class MongoReader extends MongoConnector{

	public MongoReader() throws UnknownHostException {
		super();
	}

	public static String getGourmondoURL(){	
		Document document = null;
		String url="";
		
		workingDB = mongoClient.getDatabase(MongoConstants.CONFIG);
		MongoCursor<Document> cursor = workingDB.getCollection(MongoConstants.GOURMONDO_SHOP).find().iterator();
		try  {
			while(cursor.hasNext()){
				document = cursor.next();
				if (document.containsKey(MongoConstants.URL)) {
					url = checkField(document, MongoConstants.URL);
					if (!url.isEmpty()){
						break;
					}
				}
			}
			
		}finally{
			cursor.close();
		}
		
		return url;
	}
	
	public static String getHost(){
		Document document = null;
		String host = "";
		
		workingDB = mongoClient.getDatabase(MongoConstants.CONFIG);
		MongoCursor<Document> cursor = workingDB.getCollection(MongoConstants.GOURMONDO_SHOP).find().iterator();
		try {
			while (cursor.hasNext()){
				document = cursor.next();
				if (document.containsKey(MongoConstants.HOST)) {
					host = checkField(document, MongoConstants.HOST);
				}
			}
		}finally {
			cursor.close();
		}
		
		return host;
	}
	
	public static String getLanguage(){
		Document document = null;
		String language = "";
		
		workingDB = mongoClient.getDatabase(MongoConstants.CONFIG);
		MongoCursor<Document> cursor = workingDB.getCollection(MongoConstants.GOURMONDO_SHOP).find().iterator();
		try {
			while (cursor.hasNext()){
				document = cursor.next();
				if (document.containsKey(MongoConstants.LANGUAGE)) {
					language = checkField(document, MongoConstants.LANGUAGE);
					break;
				}
			}
		}finally {
			cursor.close();
		}
		
		return language;
	}
	
	public static CustomerAccountModel getCustomerRegistrationData() {
		CustomerAccountModel customerModel = new CustomerAccountModel();
		workingDB = mongoClient.getDatabase(MongoConstants.CUSTOMER_DB);
		Document document = null;
		try
		(MongoCursor<Document> cursor = workingDB.getCollection(MongoConstants.CUSTOMER_REGISTRATION_FORM).find().iterator()) {
			while(cursor.hasNext()) {
				document = cursor.next();
				customerModel.setEmailAddress(document.getString(ModelConstants.EMAIL_ADDRESS));
				customerModel.setFirstName(document.getString(ModelConstants.FIRSTNAME));
				customerModel.setLastName(document.getString(ModelConstants.LASTNAME));
				customerModel.setDay(document.getString(ModelConstants.BIRTHDAY_DAY));
				customerModel.setMonth(document.getString(ModelConstants.BIRTHDAY_MONTH));
				customerModel.setYear(document.getString(ModelConstants.BIRTHDAY_YEAR));				
			}
		}
		return customerModel;	
	}
}
