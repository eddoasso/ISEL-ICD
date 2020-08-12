package server.xml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import PathAndExpressions.Path;

public class SerializeObjectsXML {
	
	private static final String FILENAME = Path.pathXML+"users.xml";
	
	public static boolean addUser(String username,  String password) {
		try {
			
			final XMLDecoder decoder = new XMLDecoder(new FileInputStream(FILENAME));
			@SuppressWarnings("unchecked")
			final List<String> listFromFile = (List<String>) decoder.readObject();
			decoder.close();
			
			for(int i = 0; i < listFromFile.size();i++) {
				if(listFromFile.get(i).equals(username)) {
					return false;
				}
				else
					i++;
			}

			listFromFile.add(username);
			listFromFile.add(password);
			// serializar para XML
			final XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(FILENAME)));
			encoder.writeObject(listFromFile);
			encoder.close();
			return true;
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean validateUser(String username,  String password) {
		try {
			
			final XMLDecoder decoder = new XMLDecoder(new FileInputStream(FILENAME));
			@SuppressWarnings("unchecked")
			final List<String> listFromFile = (List<String>) decoder.readObject();
			decoder.close();

			for(int i = 0; i < listFromFile.size();i++) {
				if(listFromFile.get(i).equals(username)) {
					if(listFromFile.get(i+1).equals(password)) 
						return true;
					return false;
				}else 
					i++;
				
			}
			return false;
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/*public static void main(String[] args) {
		SerializeObjectsXML a = new SerializeObjectsXML();
		/*a.addUser("deus", "1234567");
		a.addUser("miguel", "123456");
		a.addUser("pedro", "123456");
		a.addUser("corrida", "123456");
		a.addUser("deus", "123456");
		//a.addUser("stor", "123456");
		
		System.out.println(a.validateUser("stor", "1234567"));
	}*/
}