package CoreJava.Day4;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDAO {

	long count() throws SQLException;

	void createDepartment(Department dept) throws SQLException;

	void updateDepartment(Department dept) throws SQLException;

	Department getDepartment(String id) throws SQLException;

	void deleteDepartment(String id) throws SQLException;

	List<Department> getAllDepartment() throws SQLException;

}