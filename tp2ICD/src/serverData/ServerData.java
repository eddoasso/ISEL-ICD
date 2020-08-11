package serverData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.w3c.dom.Document;

import loginAluno.ClientServerAluno;
import loginProf.ClientServerProf;
import xmlWriter.XMLReadWrite;

public class ServerData implements ServletContextListener {

	private static ArrayList<ClientServerProf> profsConnected;
	private static Map<String, ArrayList<ClientServerAluno>> studentsConnectedByRoom;// map de key = pass sala,
																						// arrayList alunos connectados
	private static ArrayList<String> roomsCreated;// lista para quando prof cria sala com chave
	private static Map<String, String> profsConnectedByRoom;// map de key = pass sala, arrayList alunos connectados

	private static Document questionsDoc;

	// Notification that the servlet context is about to be shut down.
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	// do all the tasks that you need to perform just after the server starts
	// Notification that the web application initialization process is starting
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		profsConnected = new ArrayList<ClientServerProf>();
		studentsConnectedByRoom = new HashMap<String, ArrayList<ClientServerAluno>>();
		roomsCreated = new ArrayList<String>();
		profsConnectedByRoom = new HashMap<String, String>();

	}

	// guarda instancia do professor
	public static void storeProfConnected(ClientServerProf prof) {
		profsConnected.add(prof);
	}

	// remove o prof se o user e a pass não estiverem corretos
	public static void removeProfConnectedByName(String profName) {
		for (int i = profsConnected.size() - 1; i > -1; i--) {
			if (profsConnected.get(i).getProfName().equals(profName)) {
				profsConnected.remove(i);
			}
		}
	}

	// devolve instancia de prof pelo nome
	public static ClientServerProf getProfByName(String profName) {
		for (int i = profsConnected.size() - 1; i > -1; i--) {
			if (profsConnected.get(i).getProfName().equals(profName)) {
				return profsConnected.get(i);
			}
		}
		return null;
	}

	// devolve o indice na lista do prof(usado na mensagem do id)
	public static int getIndexProfByName(String profName) {
		for (int i = profsConnected.size() - 1; i > -1; i--) {
			if (profsConnected.get(i).getProfName().equals(profName)) {
				return i;
			}
		}
		return -1;
	}

	public static void setKeyOfRoom(String key) {
		roomsCreated.add(key);

	}

	// devolve se existe a chave para a sala ou não
	public static boolean checkExistingKey(String key) {
		for (int i = 0; i < roomsCreated.size(); i++) {
			if (roomsCreated.get(i).equals(key)) {
				return true;
			}
		}
		return false;
	}

	public static boolean storeStudentWithKey(ClientServerAluno aluno, String key) {
		if (studentsConnectedByRoom.get(key) != null) {
			ArrayList<ClientServerAluno> listStudents = studentsConnectedByRoom.get(key);
			for (int i = 0; i < listStudents.size(); i++) {
				if (listStudents.get(i).getStudentNumber().equals(aluno.getStudentNumber())) {
					return false;
				}
			}
			listStudents.add(aluno);
			studentsConnectedByRoom.put(key, listStudents);
			return true;

		} else {
			ArrayList<ClientServerAluno> listStudents = new ArrayList<ClientServerAluno>();
			listStudents.add(aluno);
			studentsConnectedByRoom.put(key, listStudents);
			return true;
		}
	}

	public static void storeTeacherWithKey(String profName, String key) {
		if (profsConnectedByRoom.get(key) == null) {
			profsConnectedByRoom.put(key, profName);
		}

	}

	public static boolean checkTeacherWithKey(String profName, String key) {
		if (profsConnectedByRoom.get(key) != null) {
			if (profsConnectedByRoom.get(key).equals(profName))
				return true;

		}
		return false;
	}

	public static void getQuestionsFromServer(String profName) {
		for (int i = 0; i < profsConnected.size(); i++) {
			if (profsConnected.get(i).getProfName().equals(profName)) {
				String str = "<request></request>";
				profsConnected.get(i).sendXMLToServer(str);

				try {
					for (;;) {
						Thread.sleep(200);
						if(profsConnected.get(i).getResponseReceived() != null) {
							Document doc = XMLReadWrite.documentFromString(profsConnected.get(i).getResponseReceived());
							questionsDoc = doc;
							break;
						}
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static boolean checkReceivedQuestionsFromServer(String profName) {
		if(questionsDoc != null) {//caso de ja estar guardado não faz pedido outra vez ao servidor
			return true;
		}
		
		getQuestionsFromServer(profName);//faz pedido
		
		if(questionsDoc != null) {
			return true;
		}
		return false;
	}
	
	public static Document getDocumentQuestions() {
		return questionsDoc;
	}
	
}
