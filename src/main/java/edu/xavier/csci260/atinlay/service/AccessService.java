package edu.xavier.csci260.atinlay.service;

import edu.xavier.csci260.atinlay.domain.Employee;
import edu.xavier.csci260.atinlay.domain.Message;
import edu.xavier.csci260.atinlay.domain.RoleEnum;
import edu.xavier.csci260.atinlay.domain.TimeOff.*;

import java.sql.Date;
import java.sql.Timestamp;
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
     *  add employee
     *
     * @param id
     * @param email
     * @param pass
     * @param first
     * @param last
     * @param enabled
     * @return employee added
     */
    Employee addEmployee(long id, String email, String pass, String first, String last, boolean enabled, RoleEnum role);

    /**
     * add employee
     *
     * @param employee
     * @return employee added
     */
    Employee addEmployee(Employee employee);
    /**
     * returns employee with given email
     *
     * @param email
     *
     * @return
     */
    Employee getEmployee(String email);

    /**
     * returns employee with given email
     * @param e
     * @return
     */
    Employee getEmployee(Employee e);

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
    Employee deleteEmployee(Employee employee);
    /**
     * deletes employee by email
     * @param email
     * @return
     */
    Employee deleteEmployee(String email);

    /**
     * returns all employees
     */
    List<Employee> allEmployees();

    /**
     * ###############################################################
     * ###################Message  Service############################
     * ###############################################################
     */

    /**
     * create a message
     * @param fromUser
     * @param toUser
     * @param summary
     * @param text
     * @return
     */
    void createMessage(String fromUser, String toUser, String summary, String text);

    /**
     * gets message by ID
     * @param id
     * @return
     */
    Message getMessage(long id);

    /**
     * gets message by sender/recipient ID
     * BOOL = ISSENDER
     * T if sender
     * F if recipient
     *
     * @param username
     * @param isSender
     * @return
     */
    List<Message> getInbox(String username, boolean isSender);

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
    TimeOffResponse approveEvent(Employee sender, TimeOffReq event, String description, String reason, boolean isApproved);

    TimeOffReq requestEvent(String managerEmail, String requesteeEmail, String description, String reason, Timestamp startTime, Timestamp endTime);
}
