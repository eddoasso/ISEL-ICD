package server.xml;

import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import PathAndExpressions.Expression;
import PathAndExpressions.Path;
import xml.XMLReadWrite;

public class DocumentXML {

	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;

	public DocumentXML() throws ParserConfigurationException, SAXException, IOException {
		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			document = builder.parse(Path.pathXML+"dados.xml");
			if (ValidatorXML.validDoc(document, Path.pathXML + "dados.xsd", XMLConstants.W3C_XML_SCHEMA_NS_URI))
				System.out.println("Validação do XML feita com sucesso");// Validação com XSD realizada com sucesso!
			else
				System.out.println("O documento XML não é válido para o documento XSD");// Falhou a validação com XSD

		} catch (Exception e) {
			e.printStackTrace(System.out);
			System.out.print("Erro ao analisar o documento XML.");
		}
	}

	//retorna o XML em formato String sem o header
	public String xmlDocStringFormat() {
		return getClearXMLString(XMLReadWrite.documentToString(document));
	}

	//envia perguntas do XML em formato String sem header
	public String questionXMLFormat(String strXML) {
		Document doc = XMLReadWrite.documentFromString(strXML);

		NodeList request = (NodeList) doc.getElementsByTagName("pergunta");

		NodeList questions = document.getElementsByTagName("pergunta");

		String id = request.item(0).getAttributes().getNamedItem("id").getNodeValue();
		
		String theme = "";
		NodeList categories = document.getElementsByTagName("categoria");
		for (int i = 0; i < categories.getLength(); i++) {
			Element elemCat = (Element) categories.item(i);
			NodeList cate = elemCat.getElementsByTagName("pergunta");
			for (int j = 0; j < cate.getLength(); j++) {
				if(cate.item(j).getAttributes().getNamedItem("id").getNodeValue().equals(id)) {
					theme = categories.item(i).getAttributes().getNamedItem("tema").getNodeValue();
					break;
				}
			}
			if(theme != "")
				break;
		}
		
		for (int i = 0; i < questions.getLength(); i++) {
			if (questions.item(i).getAttributes().getNamedItem("id").getNodeValue().equals(id)) {
				Node node = questions.item(i);
				Document newDocument = builder.newDocument();
				Node importedNode = newDocument.importNode(node, true);
				newDocument.appendChild(importedNode);
				return getClearXMLString(XMLReadWrite.documentToString(newDocument))+theme;
			}
		}

		return null;
	}
	//função para limpar o header
	private String getClearXMLString(String strXML) {
		strXML = strXML.substring(61,strXML.length());
		return strXML.replace("\n", "").replace("\r", "");
	}
	
	//função que envia o xml em String corrigido
	public String sendResultWithCorrection(String strXML) {
		System.out.println(strXML);
		Document doc = XMLReadWrite.documentFromString(strXML);
		
		

		String number = doc.getElementsByTagName("aluno").item(0).getAttributes().getNamedItem("numero").getNodeValue();
		String st = Expression.sendResultOfQuestions;
		st = st+"<aluno numero=\""+number+"\">";
		
		NodeList request = (NodeList) doc.getElementsByTagName("pergunta");
		for(int i = 0;i < request.getLength(); i++) {
			String id = request.item(i).getAttributes().getNamedItem("id").getNodeValue();
			if(request.item(i).hasChildNodes()) {
				int index = 0;
				NodeList res = document.getElementsByTagName("pergunta");
				for(int j = 0;j < res.getLength(); j++) {
					if(res.item(j).getAttributes().getNamedItem("id").getNodeValue().equals(id)) {
						index = j;
						break;
					}
				}
				Element elemRes = (Element) request.item(i);
				NodeList respostas = elemRes.getElementsByTagName("resposta");
				Element opcao = (Element)res.item(index);
				NodeList opcoes = opcao.getElementsByTagName("opcao");
				st = st+"<pergunta id=\""+id+"\">";
				for(int j = 0;j < respostas.getLength(); j++) {
					st = st+"<resposta correcao=\"";
					int indice = Integer.parseInt(respostas.item(j).getAttributes().getNamedItem("indice").getNodeValue());
					st = st+opcoes.item(indice).getAttributes().getNamedItem("resposta").getNodeValue();
					st = st+"\"/>";
				}
				st = st+"</pergunta>";
			}
			else
				st = st+"<pergunta id=\""+id+"\"/>";
			
		}
		st = st+"</aluno>";
		return st+Expression.sendResultOfQuestionsEnd;
		
	}

}
