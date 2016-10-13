package com.tools.mongo;

import java.net.UnknownHostException;

import org.apache.log4j.Logger;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.tools.constants.MongoConstants;



public class MongoConnector {

	final static Logger logger = Logger.getLogger(MongoConnector.class);
	public static MongoClient mongoClient;
	public static MongoDatabase workingDB;
	ServerAddress serverAddress = new ServerAddress();
	
	public MongoConnector() throws UnknownHostException{
		serverAddress = new ServerAddress(MongoConstants.LOCALHOST, 27017);
		if(mongoClient == null){
			mongoClient = new MongoClient(serverAddress);
		}
	}
	
	public static String checkField(Document document, String key){
		String value = "";
		if(document.containsKey(key) && document.get(key) != null){
			value = document.getString(key);
		}
		
		return value;
	}
	
	public static void cleanDatabase(String databaseName){
		mongoClient.dropDatabase(databaseName);
		logger.info("Database " + databaseName + " cleaned.");
	}
	
	public static void cleanCollection(String databaseName, String collectionName){
//		List<String> databaseNames = mongoClient.getDatabaseNames();
//		for (String dbs : databaseNames){
//			if (databaseName.contains(dbs)){
//				workingDB = mongoClient.getDatabase(dbs);
//				DBCollection dbCollection = (DBCollection) workingDB.getCollection(collectionName);
//				dbCollection.drop();
//			}
//		}
		workingDB = mongoClient.getDatabase(databaseName);
		workingDB.getCollection(collectionName).drop();
	}
	
}
