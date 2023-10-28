package firstWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Counter {
	
	private String uri;
	private int count;
	
	public Counter() {
		super();
	}

	public Counter(String uri, int count) {
		super();
		this.uri = uri;
		this.count = count;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CounterDatabase [uri=" + uri + ", count=" + count + "]";
	}
	
//	static {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	private Connection getConnection() throws SQLException {
//		return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech_2023?useSSL=false", "root", "root");
//	}
	
	
	
	public static void main(String[] args) {
		
	}
}
