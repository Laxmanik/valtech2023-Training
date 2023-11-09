package com.valtech.training.firstspringboot.components;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

//CRUD
//Create
//Read
//Update
//Delete

@Component
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private DataSource dataSource;

	public class EmployeeRowMapper implements RowMapper<Employee> {

		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
//			SELECT ID, NAME, AGE, EXPERIENCE, SENIORITY, SALARY, DEPTID FROM EMPLOYEE
			Employee e = new Employee();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setAge(rs.getInt(3));
			e.setExperience(rs.getInt(4));
			e.setSeniority(rs.getInt(5));
			e.setSalary(rs.getInt(6));
			e.setDeptId(rs.getInt(7));
			return e;
		}

	}

	@Override
	public long count() {
		String countQuery = "SELECT COUNT(ID) FROM EMPLOYEE";
		return new JdbcTemplate(dataSource).queryForObject(countQuery, Long.class);
	}

	@Override
	public void deleteEmployee(int id) {
		String deleteQuery = "DELETE FROM EMPLOYEE WHERE ID = ?";
		new JdbcTemplate(dataSource).update(deleteQuery, id);
	}

	@Override
	public void updateEmployee(Employee emp) {
		String updateQuery = "UPDATE EMPLOYEE SET NAME = ?, AGE = ?, EXPERIENCE = ?, SENIORITY = ?, SALARY = ? DEPTID = ? WHERE ID = ?";
		new JdbcTemplate(dataSource).update(updateQuery, emp.getName(), emp.getAge(), emp.getExperience(),
				emp.getSeniority(), emp.getSalary(), emp.getDeptId());
	}

	@Override
	public void createEmployee(Employee emp) {
		String createQuery = "INSERT INTO EMPLOYEE (NAME, AGE, EXPERIENCE, SENIORITY, SALARY, DEPTID) VALUES (?,?,?,?,?,?)";
		new JdbcTemplate(dataSource).update(createQuery, emp.getName(), emp.getAge(), emp.getExperience(),
				emp.getSeniority(), emp.getSalary(), emp.getDeptId());
	}

	@Override
	public List<Employee> getAllEmployees() {
		String getAllEmployeesQuery = "SELECT ID, NAME, AGE, EXPERIENCE, SENIORITY, SALARY, DEPTID FROM EMPLOYEE";
		return new JdbcTemplate(dataSource).query(getAllEmployeesQuery, new EmployeeRowMapper());
	}

	@Override
	public Employee getEmployee(int id) {
		String getEmployeeQuery = "SELECT ID, NAME, AGE, EXPERIENCE, SENIORITY, SALARY, DEPTID FROM EMPLOYEE WHERE ID = ?";
		return (Employee) new JdbcTemplate(dataSource).query(getEmployeeQuery, new EmployeeRowMapper());
	}

}

//org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'com.valtech.training.first_spring_boot.FirstSpringBootApplicationTests': Unsatisfied dependency expressed through field 'employeeDAO'; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.valtech.training.first_spring_boot.components.EmployeeDAO' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
