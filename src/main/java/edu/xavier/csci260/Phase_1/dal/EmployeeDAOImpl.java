package edu.xavier.csci260.Phase_1.dal;

import edu.xavier.csci260.Phase_1.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

import java.util.Arrays;
import java.util.List;

/**
 * class ___ is a member of the Phase_1 project.
 * <p>
 * Created by Luke on 3/12/2017.
 */
@Component
public class EmployeeDAOImpl implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Employee> findUser(String user_name) {
        return null;//jdbcTemplate.query(

          /*      "SELECT user_name, password, first_name, last_name FROM users WHERE user_name = ?",
                new Object[]{user_name}, (rs, rowNum) -> new Employee(rs.getUser_name("user_name"),
                        rs.getPassword("password"), rs.getFirst_name("first_name"), rs.getLast_name("last_name"))
        );
*/    }

    @Override
    public void createUser(String user_name, String password, String first_name, String last_name) {
    	String sqlStmt = "INSERT INTO users(user_name, password, first_name, last_name) VALUES (?, ?, ?, ?);";
    	jdbcTemplate.update(sqlStmt, Arrays.asList(user_name, first_name, last_name, password));
    }

    @Override
    public List<Employee> findAll() {
        return null;
    }
}
