package edu.xavier.csci260.Phase_1.service;

import edu.xavier.csci260.Phase_1.domain.Employee;

import java.util.List;

/**
 * class ___ is a member of the Phase_1 project.
 * <p>
 * Created by Luke on 3/20/2017.
 */

 // INSERT INTO user(id,email,password,first_name,last_name,enabled)
 // VALUES (0,'staudigelc@xavier.edu','password','Chris','Staudigel',true);
public interface AccessService {

    /**
    * add employee
    */
    void addEmployee(int id, String email, String pass, String first, String last, boolean enabled);

    /**
     * returns employee with given email
     *
     * @param email
     *
     * @return
     */
    List<Employee> getEmployee(String email);

    /**
     * returns employee with given email
     * @param e
     * @return
     */
    List<Employee> getEmployee(Employee e);

    /**
     * returns employee by id number
     * @param id
     * @return
     */
    List<Employee> getEmployee(int id);

    /**
     * grab employee by email, replace it with new employee
     *
     * @param email
     * @param employee
     */
    void updateEmployee(String email, Employee employee);

    /**
     * deletes employee by employee
     * @param employee
     * @return
     */
    List<Employee> deleteEmployee(Employee employee);

    /**
     * deletes employee by email
     * @param email
     * @return
     */
    List<Employee> deleteEmployee(String email);
}
