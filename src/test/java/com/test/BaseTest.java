package com.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import com.tools.constants.ConfigConstants;
import com.tools.constants.MongoConstants;
import com.tools.constants.ProjectResourcesConstants;
import com.tools.mongo.MongoConnector;
import com.tools.mongo.writer.MongoWriter;

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
		
		String host = ConfigConstants.GOURMONDO_UK_TEST;
		String language = ConfigConstants.UK;
		String url = "";
		
		try{
			mongoConnector = new MongoConnector();
			logger.info("Connecting to mongo database...");
		}catch(Exception e){
			logger.info("Cannot connect to mongo!");
			e.printStackTrace();
		}
		
		MongoConnector.cleanDatabase(MongoConstants.CONFIG);
		MongoWriter.saveBaseTestConfigs(host, language);
		logger.info("Host: " + host);
		logger.info("Language: " + language);
		
		Properties properties = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(ProjectResourcesConstants.SERVER + "config.properties");
			properties.load(input);
			url = properties.getProperty("baseUrl");
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
		
		MongoWriter.saveGourmondoURL(url);
		logger.info("Url: " + url);
	}
	
	
}
