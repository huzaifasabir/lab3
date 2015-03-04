


//for run in linux


import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class javaClientL {
  public static void main(String[] argv) throws Exception {
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

