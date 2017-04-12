package edu.xavier.csci260.Phase_1.service;

import edu.xavier.csci260.Phase_1.domain.Employee;
import edu.xavier.csci260.Phase_1.domain.Manager;
import edu.xavier.csci260.Phase_1.domain.Message;
import edu.xavier.csci260.Phase_1.domain.WorkEvent;

import java.util.Date;
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
     * ###############################################################
     * ###################Employee Service############################
     * ###############################################################
     */

    /**
    * add employee
    */
    Employee addEmployee(int id, String email, String pass, String first, String last, boolean enabled);

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
    Employee updateEmployee(String email, Employee employee);

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

    /**
     * ###############################################################
     * ###################Message  Service############################
     * ###############################################################
     */

    /**
     * create a message
     * @param id
     * @param created
     * @param toID
     * @param fromID
     * @param summary
     * @param text
     * @return
     */
    Message createMessage(int id, Date created, int toID, int fromID, String summary, String text);

    /**
     * gets message by ID
     * @param id
     * @return
     */
    List<Message> getMessage(int id);

    /**
     * gets message by sender/recipient ID
     * BOOL = ISSENDER
     * T if sender
     * F if recipient
     *
     * @param id
     * @param isSender
     * @return
     */
    List<Message> getMessage(int id, boolean isSender);

    /**
     * ###############################################################
     * ###################Manager  Service############################
     * ###############################################################
     */

    /**
     * approve day off. Only accessible by manager
     *
     * @param sender employee that is performing this action
     * @param event
     * @param isApproved T if offday is approved
     * @return
     */
    WorkEvent approveEvent(Employee sender, WorkEvent event, boolean isApproved);
}
