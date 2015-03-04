


//TCPServer.java
//A server program implementing TCP socket
import java.net.*;
import java.io.*;



import java.io.BufferedInputStream;
//for run in linux

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class javaServerL {
  public static void main(String[] args) throws IOException {
	  
    ServerSocket serversock = new ServerSocket(55555);
    System.out.println("....Server Running ....");
    File myFile = new File("sample1.txt");
    System.out.println(myFile.toString());
    
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
      
    }
  }
}





