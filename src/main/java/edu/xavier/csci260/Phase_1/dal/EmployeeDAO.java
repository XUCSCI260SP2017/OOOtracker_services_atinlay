package edu.xavier.csci260.Phase_1.dal;

import java.util.List;

import edu.xavier.csci260.Phase_1.domain.Employee;

/**
 * class ___ is a member of the Phase_1 project.
 * <p>
 * Created by Luke on 3/12/2017.
 */
public interface EmployeeDAO {
    public List<Employee> findUser(String user_name);

    public void createUser(String user_name, String first_name, String last_name, String password);

    public List<Employee> findAll();

}
