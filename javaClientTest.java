package server;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class javaClientTest {

	@Test
	public void test() throws Exception {
		
		javaClient c = new javaClient();
		javaServer s = new javaServer();
		
		
		c.client();
		
		String ch = s.calculate_checksum();
		String ch1 = c.calculate_checksum();
		
		if(ch.equals(ch1)){
			
			System.out.println("CORRECT data transferred both checksum are same");
		}
		
		
	}

}
