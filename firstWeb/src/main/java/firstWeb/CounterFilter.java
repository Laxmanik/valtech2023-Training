package firstWeb;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;



public class CounterFilter implements Filter {

	private Connection connection;
	
	@Override
	public void destroy() {
		System.out.println("Destroy of Counter Filter....");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Do Filter of Counter Filter....");
		
		Map<String, Integer> counters = (Map<String, Integer>) request.getServletContext().getAttribute("counters");
		HttpServletRequest req = (HttpServletRequest)request;
		String uri = req.getRequestURI();
		
//		counters.put(uri, counters.containsKey(uri) ? counters.get(uri) + 1 : 1);
		
		if(counters.containsKey(uri)) {
			//increment
			counters.put(uri, counters.get(uri) + 1);
		} else {
			counters.put(uri, 1);
		}
		try {
			printCounters(counters);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		chain.doFilter(request, response);
	}

	private void printCounters(Map<String, Integer> counters) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech_2023", "root", "root");
		PreparedStatement ps = connection.prepareStatement("UPDATE counter SET count = s? WHERE URI = ?");
		for(String s:counters.keySet()) {
			System.out.println("Uri ---> "+s+" Counter ----> "+counters.get(s));
			
			ps.setInt(1, counters.get(s));
			ps.setString(2, s);
			ps.executeUpdate();
		}
	}

//	private void saveMaptoCounterDatabase() {
//		private void printCounters(Map<String, Integer> counters) throws ClassNotFoundException, SQLException {
//	Class.forName("com.mysql.jdbc.Driver");
//	
//	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech_2023", "root", "root");
//	PreparedStatement ps = connection.prepareStatement("UPDATE counter SET count = ? WHERE URI = ?");
//	for(String s:counters.keySet()) {
//		System.out.println("Uri ---> "+s+" Counter ----> "+counters.get(s));
//		
//		ps.setInt(1, counters.get(s));
//		ps.setString(2, s);
//		ps.executeUpdate();
//	}
//	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Init of Counter Filter....");
		
		Map<String, Integer> counters = new HashMap<>();
		filterConfig.getServletContext().setAttribute("counters", counters);
	}

}
