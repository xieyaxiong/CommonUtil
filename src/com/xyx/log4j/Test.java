package com.xyx.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Test {
	
	public static void main(String[] args) {
		String path=Test.class.getResource("/log4j.properties").getPath();
		 PropertyConfigurator.configure( path );
		 System.out.println(path);
	        Logger logger  =  Logger.getLogger(Test. class );
	        logger.debug( " debug " );
	        logger.error( " error " );
	}

}
