package com.xyx.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFile {
	
	public static void main(String[] args) throws Exception{
		FileInputStream fis=new FileInputStream("F:/test/logs/ips.properties");
		
		FileOutputStream fos=new FileOutputStream("F:/test/logs/xx.properties");
		
		FileChannel fic=fis.getChannel();
		FileChannel foc=fos.getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate( 1024 );
		
		while(true){
			buffer.clear();
			int r = fic.read( buffer );

			System.out.println(r);
			if (r==-1) {
			     break;
			}

			buffer.flip();
			foc.write( buffer );
		}
	}

}
