package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import com.tools.constants.ConfigConstants;
import com.tools.constants.JavaMailAPIConstants;
import com.tools.constants.ProjectResourcesConstants;
import com.tools.email.JavaMailAPIConnector;
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
	public MongoConnector mongoConnector;
	
	protected static String shop = "";
	protected static String language = "";
    protected static String url = "";
	
	@Before
	public void startup() throws IOException {
	
		shop = ConfigConstants.GOURMONDO_DE_TEST;
		language = ConfigConstants.DE;
		logger.info("Shop: " + shop);
		logger.info("Language is: " + language);
		
		//connecting to mongo
		try{
			mongoConnector = new MongoConnector();
			
			logger.info("Connecting to mongo database...");
		}catch(Exception e){
			logger.info("Cannot connect to mongo!");
			e.printStackTrace();
		}
		
		//read and set url from config file
		setUrl();
		
		
	}
	
	public void setUrl() {
		Properties properties = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(ProjectResourcesConstants.SERVER + shop + File.separator +  "config.properties");
			properties.load(input);
			url = properties.getProperty("baseUrl");
			logger.info("Url: " + url);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (input != null)
				try {
					input.close();
				}catch (IOException e){
					e.printStackTrace();
				}
		}
	}
	
	public static String getUrl() {
		System.out.println("get url from global var");
		return url;
	}
	
	public static String getLanguage() {
		return language;
	}
	
	public static String getShop() {
		return shop;
	}
	
	
	
}
