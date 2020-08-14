package registerUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loginProf.ClientServerProf;
import loginProf.xmlMessageConvert.MessagesConverter;
import otherServerInfo.ServerInfo;
import serverData.ServerData;

/**
 * Servlet implementation class registerProf
 */
@WebServlet(description = "Permite registar um professor na base de dados", urlPatterns = {
		"/handleNewProf"})
public class RegisterProf extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("username");
		String pass1 = request.getParameter("password");
		String pass2 = request.getParameter("verify_password");

		if (userName.isBlank() || pass1.isBlank() || pass2.isBlank()) {
			throw new ServletException(
					"Username, password or verify_password can not be blank");
		}

		// TODO validar pass e userName

		// 1º voltar ao src, depois a tp2ICD, depois diretoria raiz do projeto.
		// De seguida descer a arvore ate ao ficheiro user.xml

		// criar um novo professor e armazenar no servidor
		ClientServerProf prof = new ClientServerProf(userName);
		ServerData.storeProfConnected(prof);

		String xmlStr = MessagesConverter.resultRegisterProfXML(userName,
				pass1);

		prof.sendXMLToServer(xmlStr);
		response.sendRedirect(request.getContextPath() + "/index.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

class SocketHelper {
	private final String profName;
	private final String host;
	private final int port;

	private Socket socket;
	private BufferedReader in = null;
	private PrintWriter out = null;

	public SocketHelper(String profName) {
		host = ServerInfo.DEFAULT_HOSTNAME;// Maquina onde reside a aplicacao
											// servidora
		port = ServerInfo.DEFAULT_PORT; // Porto da aplicacao servidora
		createSocket();

		this.profName = profName;

	}

	private void createSocket() {
		try {
			socket = new Socket(host, port);

			// Stream para escrita no socket
			out = new PrintWriter(socket.getOutputStream(), true);

			// Stream para leitura do socket
			in = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));

		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
	public boolean writeToServer(String msg) {
		if (out != null) {
			out.println();

			return true;
		}
		return false;
	}
}
