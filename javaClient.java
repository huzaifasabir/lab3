package server;




//TCPClient.java
//A client program implementing TCP socket


import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.FileInputStream;
import java.security.MessageDigest;
public class javaClient {
	
	String calculate_checksum(){
		String datafile = "at.TXT";
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    FileInputStream fis = null;
		try {
			fis = new FileInputStream(datafile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    byte[] dataBytes = new byte[1024];
	 
	    int nread = 0; 
	 
	    try {
			while ((nread = fis.read(dataBytes)) != -1) {
			  md.update(dataBytes, 0, nread);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	 
	    byte[] mdbytes = md.digest();
	 
	    //convert the byte to hex format
	    StringBuffer sb = new StringBuffer("");
	    for (int i = 0; i < mdbytes.length; i++) {
	    	sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
	    }
	 
	    System.out.println("Digest(in hex format):: " + sb.toString());
		
		return sb.toString();
	}
	
	
	void client() throws Exception, IOException{
		javaClient s = new javaClient();
		
		  Socket sock = new Socket("127.0.0.1", 55555);
		  byte[] mybytearray = new byte[1024];
		  InputStream is = sock.getInputStream();
		  FileOutputStream file1 = new FileOutputStream("at.txt");
		  BufferedOutputStream buff1 = new BufferedOutputStream(file1);
		  int bytesRead = is.read(mybytearray, 0, mybytearray.length);
		  buff1.write(mybytearray, 0, bytesRead);
		  buff1.close();
		  sock.close();
		  
		  
	}
	

}

