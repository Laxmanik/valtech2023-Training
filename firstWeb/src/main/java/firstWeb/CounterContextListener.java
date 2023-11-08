package firstWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CounterContextListener implements ServletContextListener{
	
	private Map<String, Integer> counterMap = new HashMap<>();
    private Connection connection;
    
    

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        initCounterMapFromDatabase();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        saveCounterMapToDatabase();
    }

    private void initCounterMapFromDatabase() {
        try {
        	
        	
        		try {
        			Class.forName("com.mysql.cj.jdbc.Driver");
        		} catch (ClassNotFoundException e) {
        			e.printStackTrace();
        		}
        	
        	
            // Initialize the database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech_2023?useSSL=false", "root", "root");

            // Retrieve counter values from the database
            String query = "SELECT URI, count FROM counter";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String uri = resultSet.getString("URI");
                int count = resultSet.getInt("count");
                counterMap.put(uri, count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveCounterMapToDatabase() {
        try {
            // Update counter values in the database
            String updateQuery = "UPDATE counter SET count = ? WHERE URI = ?";
            PreparedStatement updateStatement = connection.prepareStatement(updateQuery);

            for (Map.Entry<String, Integer> entry : counterMap.entrySet()) {
                updateStatement.setInt(1, entry.getValue());
                updateStatement.setString(2, entry.getKey());
                updateStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
