package edu.xavier.csci260.atinlay.dal;

import edu.xavier.csci260.atinlay.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * class EmployeeDAOImpl is a member of the atinlay project.
 * <p>
 * Created by Luke on 3/12/2017.
 */
@Component
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Employee getEmployeeByUsername(String username) {

        String sql = "SELECT * FROM users WHERE username = ?";

        return (Employee) jdbcTemplate.queryForObject(
                sql,
                new Object[] { username },
                new EmployeeRowMapper()
        );
    }

    @Override
    public void createEmployee(Employee employee) {

        String sqlStmt = "INSERT INTO users(username, password, first_name, last_name, enabled, role) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sqlStmt,
                employee.getUsername(),
                employee.getPassword(),
                employee.getFirst_name(),
                employee.getLast_name(),
                employee.isEnabled(),
                employee.getRole().toString());
    }

    @Override
    public void removeEmployee(Employee employee) {

        String sqlStmt = "DELETE FROM users WHERE username = ?";

        jdbcTemplate.update(sqlStmt, employee.getUsername());
    }

    @Override
    public List<Employee> findAll(){
        return null;
    }

}
