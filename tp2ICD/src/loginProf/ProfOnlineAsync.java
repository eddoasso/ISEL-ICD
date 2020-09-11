package loginProf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import serverData.ServerData;

public class ProfOnlineAsync extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session == null) {
			session = request.getSession();
		}
		if ((String) session.getAttribute("studentKey") == null || (String) session.getAttribute("studentKey") == "") {// sessão destruida
			session.setAttribute("errorSession", "");
			getServletContext().getRequestDispatcher("/TemplatesAluno/TemplateLoginAluno.jsp").forward(request,
					response);
		}

		
		String text = ServerData.checkProfIsOnline((String) session.getAttribute("studentKey"));
		String result = "";
		
		if(text == null) {
			result = "<li id=\"prof-connect\"><a id=\"see-correction\" href=\"#\" style=\"font-size:18px;color:#ff6666\">Teacher offline</a></li>";
		}else {
			result = "<li id=\"prof-connect\"><a id=\"see-correction\" href=\"#\" style=\"font-size:18px;color:#03C04A\">Teacher online</a></li>";
		}
		
	    response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    response.getWriter().write(result);       // Write response body.

	}

}