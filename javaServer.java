package server;




//TCPServer.java
//A server program implementing TCP socket
import java.net.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.FileInputStream;
import java.security.MessageDigest;
public class javaServer {
	
	
	String calculate_checksum(){
		String datafile = "sample1.TXT";
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
	
	void server() throws IOException{
		  ServerSocket serversock = new ServerSocket(55555);
		  System.out.println("....Server Running ....");
		  File myFile = new File("sample1.txt");
		  //System.out.println(myFile.toString());
		  javaServer s = new javaServer();
		  
		  
		  
		  while (true) {
		  	
		    Socket sock = serversock.accept();
		    byte[] bytearray = new byte[(int) myFile.length()];
		    BufferedInputStream buf = new BufferedInputStream(new FileInputStream(myFile));
		    buf.read(bytearray, 0, bytearray.length);
		    
		    OutputStream output = sock.getOutputStream();
		    System.out.println(bytearray);
		    output.write(bytearray, 0, bytearray.length);
		    output.flush();
		    sock.close();
		    
		    //System.out.println(".....Server Closed ....");
		  }
	}
	
	



}





