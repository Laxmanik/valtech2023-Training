package firstWeb;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DepartmentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private DepartmentDAO dept = new DepartmentDAOImpl();
	private EmployeeDAO emp = new EmployeeDAOImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			HttpSession sess = req.getSession(true);
			sess.setAttribute("current", dept.firstDept());
//			int deptId = Integer.parseInt(req.getParameter("current"));
			sess.setAttribute("dept", dept.getDepartment(dept.firstDept()));
			
			

//			sess.setAttribute("current", emps.getEmployeeByDeptId(deptId));
//			sess.setAttribute("emp", emp.getEmployeeByDeptId(1));

			getEmployeeByDeptId(req, resp);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void getEmployeeByDeptId(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		try {
			HttpSession sess = req.getSession();
			int current = (int) sess.getAttribute("current");
			List<Employee> getEmployeeByDeptId = emp.getEmployeeByDeptId(current);
			req.setAttribute("getEmployeeByDeptId", getEmployeeByDeptId);
			req.getRequestDispatcher("department.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession sess = req.getSession();
		int current = (int) sess.getAttribute("current");
		String submit = req.getParameter("submit");

		try {
			if ("First".equals(submit)) {
				current = dept.firstDept();
//				emp.getEmployeeByDeptId(current);
			} else if ("Last".equals(submit)) {
				current = dept.lastDept();
//				emp.getEmployeeByDeptId(current);
			} else if ("Previous".equals(submit)) {
				current = dept.previousDept(current);
//				emp.getEmployeeByDeptId(current);
			} else if ("Next".equals(submit)) {
				current = dept.nextDept(current);
//				emp.getEmployeeByDeptId(current);
			}

			System.out.println("Current =" + current);

			sess.setAttribute("current", current);
			sess.setAttribute("dept", dept.getDepartment(current));

//			sess.setAttribute("emp", emp.getEmployeeByDeptId(current));

			req.getRequestDispatcher("department.jsp").forward(req, resp);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
