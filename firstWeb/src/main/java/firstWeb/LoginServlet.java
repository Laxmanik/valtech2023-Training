package firstWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
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
		response.getWriter().print("Username = "+request.getParameter("name")+" Pass Word = "+request.getParameter("pass"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * TODO if name and pass is wrong show the login page again with msg...
	 * if name is less than 4 chars then add msg and login page
	 * if pass is less than 8 chars then add msg and login page
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		super.doPost(request, response);
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
//		if("scott".equals(name) && "tiger".equals(pass)) {
//			request.setAttribute("message", "Hi Scott.. How have you been");
//		} else {
//			request.setAttribute("message", "Only scott is a Valid User");
//		}
//		request.getRequestDispatcher("loginresults.jsp").forward(request, response);
		
		
		
		
		if(name.length()<4) {
			String errorMsg = "Username should have more than 4 characters";
			request.setAttribute("message2", errorMsg);
		}
		else if (pass.length()<4) {
			String errorMsg = "Password should have more than 4 characters";
			request.setAttribute("message1", errorMsg);
		}else {
			String errorMsg = "Username & Password are wrong";
			request.setAttribute("message3", errorMsg);
		}
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
}
	
	

