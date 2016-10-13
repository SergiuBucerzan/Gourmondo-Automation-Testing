package com.tools.mongo.reader;

import java.net.UnknownHostException;

import org.bson.Document;

import com.mongodb.client.MongoCursor;
import com.tools.constants.MongoConstants;
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
				url = checkField(document, MongoConstants.GOURMONDO_URL);
				if (!url.isEmpty()){
					break;
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
				host = checkField(document, MongoConstants.HOST);
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
				language = checkField(document, MongoConstants.LANGUAGE);
			}
		}finally {
			cursor.close();
		}
		
		return language;
	}
	
}
