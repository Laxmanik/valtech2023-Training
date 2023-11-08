package firstWeb;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DisplayEmployeesServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6040923770464194640L;
	private EmployeeDAO dao = new EmployeeDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			List<Employee> employees = dao.getAllEmployees();
		    req.setAttribute("employees", employees);
		    req.getRequestDispatcher("displayEmployees.jsp").forward(req, resp);
		    System.out.println("Number of employees: " + employees.size());
		} catch (SQLException e) {
		    e.printStackTrace();
		    // Handle the exception, e.g., display an error message or redirect to an error page.
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
