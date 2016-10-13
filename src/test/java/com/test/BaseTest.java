package com.test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import com.tools.constants.MongoConstants;
import com.tools.mongo.MongoConnector;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.pages.Pages;

public class BaseTest {

	@Managed (uniqueSession=true)
	WebDriver webDriver;
	
	@ManagedPages (defaultUrl="https://uk-gourmondo-1.dev:9002")
	public Pages pages;
		
	final static Logger logger = Logger.getLogger(BaseTest.class);
	MongoConnector mongoConnector;
	
	@Before
	public void startup() throws IOException {
		try{
			mongoConnector = new MongoConnector();
			logger.info("Connecting to mongo database...");
		}catch(Exception e){
			logger.info("Cannot connect to mongo!");
			e.printStackTrace();
		}
		
		MongoConnector.cleanDatabase(MongoConstants.CONFIG);
	}
	
	
}
