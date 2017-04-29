package edu.xavier.csci260.atinlay.dal;

import edu.xavier.csci260.atinlay.domain.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * class ___ is a member of the atinlay project.
 * <p>
 * Created by Luke on 3/12/2017.
 */
public interface EmployeeDAO {

    Employee getEmployeeByUsername(String username);

    void createEmployee(Employee employee);

    void removeEmployee(Employee employee);

    List<Employee> findAll();

    /**
     * Custom RowMapper to correctly handle employee requests to the database
     */
    class EmployeeRowMapper implements RowMapper {
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

            Employee employee = new Employee();

            employee.setId(rs.getLong("id"));
            employee.setUsername(rs.getString("username"));
            employee.setPassword(rs.getString("password"));
            employee.setFirst_name(rs.getString("first_name"));
            employee.setLast_name(rs.getString("last_name"));
            employee.setEnabled(rs.getBoolean("enabled"));
            employee.setRole(rs.getString("role"));

            return employee;
        }
    }
}
