package edu.xavier.csci260.Phase_1.dal;

import java.util.List;

import edu.xavier.csci260.Phase_1.domain.Employee;

/**
 * class ___ is a member of the Phase_1 project.
 * <p>
 * Created by Luke on 3/12/2017.
 */
public interface EmployeeDAO {
    List<Employee> findUser(String email);
    List<Employee> findUser(int id);
    List<Employee> findUser(Employee employee);

    Employee createUser(int id, String email, String pass, String first, String last, boolean enabled);

    Employee removeUser(int id);
    Employee removeUser(String email);

    List<Employee> findAll();

}
