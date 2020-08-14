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
