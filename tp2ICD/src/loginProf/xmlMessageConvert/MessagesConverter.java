package loginProf.xmlMessageConvert;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import xmlWriter.XMLReadWrite;

public class MessagesConverter {
	
	
	//da mensagem do servidor retorna a string de resposta (correto, incorreto) no formato <info id=0 client="prof"><answer>correto</answer></info>
	public static  String resultResponseProfInfo(String xmlReceived) {
		Document doc = XMLReadWrite.documentFromString(xmlReceived);
		
		NodeList request = (NodeList) doc.getElementsByTagName("answer");
		return request.item(0).getTextContent();
	}

}
