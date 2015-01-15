package config;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import config.ServerProperties;


public class RunEncoder {
	
	private static final String FILE_NAME = "Properties.xml";

	public static void main(String[] args) {
		ClientProperties properties = new ClientProperties(8000, "127.0.0.1");
		
		XMLEncoder encoder = null;
		try {
			encoder = new XMLEncoder(new FileOutputStream(FILE_NAME));
			encoder.writeObject(properties);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			encoder.close();
		}		
	}
}
