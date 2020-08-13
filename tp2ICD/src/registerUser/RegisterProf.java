package registerUser;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xmlWriter.XMLReadWrite;

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
			throw new IOException(
					"Username, password or verify_password can not be blank");
		}

		// TODO validar cenas

		// 1º voltar ao src, depois a tp2ICD, depois diretoria raiz do projeto.
		// De seguida descer a arvore ate ao ficheiro user.xml

		// TODO arranjar este path
		File f = new File(getServletContext()
				.getRequestDispatcher("../../../tp1ICD/xml/users.xml").toString());
		if (!f.exists()) {
			throw new IOException("Erro no path do ficheiro XML, path "
					+ f.getAbsolutePath() + " curr path "
					+ request.getRequestURL().toString());
		}

		String xmlStr = "<void method=\"add\">" + "<string>" + userName
				+ "</string>" + "</void>" + "<void method=\"add\">" + "<string>"
				+ pass1 + "</string>" + "</void>";

		XMLReadWrite.writeToDocumentFromString(xmlStr, f);
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
