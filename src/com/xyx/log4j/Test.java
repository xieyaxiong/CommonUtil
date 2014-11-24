package com.xyx.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Test {
	
	public static void main(String[] args) {
		 PropertyConfigurator.configure( "C:/Users/Administrator/git/CommonUtil/src/log4j.properties" );
	        Logger logger  =  Logger.getLogger(Test. class );
	        logger.debug( " debug " );
	        logger.error( " error " );
	}

}
