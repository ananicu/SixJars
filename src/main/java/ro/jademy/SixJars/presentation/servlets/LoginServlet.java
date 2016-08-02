package ro.jademy.SixJars.presentation.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ro.jademy.SixJars.Business.entities.User;
import ro.jademy.SixJars.Business.services.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		LoginService login = new LoginService();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = login.doLogin(username, password);
		if(user == null) {
			String nextJSP = "/loginFailure.jsp";
			RequestDispatcher dispatcher = getServletContext ().getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);
		} else {
			request.getSession().setAttribute("user", user);
			String nextJSP = "/menu";
			RequestDispatcher dispatcher = getServletContext().getNamedDispatcher(nextJSP);
			dispatcher.forward(request, response);
		}
	}

}
