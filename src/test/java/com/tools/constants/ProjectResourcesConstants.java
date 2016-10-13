package com.tools.constants;

import java.io.File;

import com.tools.mongo.reader.MongoReader;

public class ProjectResourcesConstants {

	public static final String GOURMONDO_TEST = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "servers" + File.separator + MongoReader.getHost() + File.separator;
	public static final String GOURMONDO_LOCALE = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "locale" + File.separator + MongoReader.getLanguage() + File.separator; 

}
