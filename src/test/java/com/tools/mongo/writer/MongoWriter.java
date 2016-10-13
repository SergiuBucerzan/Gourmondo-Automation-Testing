package com.tools.mongo.writer;

import java.net.UnknownHostException;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.tools.constants.MongoConstants;
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
		
		document.put(MongoConstants.GOURMONDO_URL, url);
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
	
	
}
