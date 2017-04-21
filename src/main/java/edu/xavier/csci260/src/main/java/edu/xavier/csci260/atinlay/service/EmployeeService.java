package edu.xavier.csci260.atinlay.service;

import edu.xavier.csci260.atinlay.domain.Employee;
import edu.xavier.csci260.atinlay.domain.Message;
import edu.xavier.csci260.atinlay.domain.RoleEnum;

import java.util.List;

/**
 * class ___ is a member of the atinlay project.
 * <p>
 * Created by Luke on 3/20/2017.
 */
public interface EmployeeService {


    /**
     * this method will create an Employee
     * @param username regular constructors from superclass
     * @param first_name regular constructors from superclass
     * @param last_name regular constructors from superclass
     * @param password regular constructors from superclass
     * @param manager_id the username of the manager for this employee
     * @param role the authority of the employee
     */
    public void createEmployee(String username, String first_name, String last_name, String password, String manager_id, RoleEnum role);

        /**
         * not sure what you want for param
         *
         * @return  Get all messages which have not been opened
         */
    @Deprecated // will be implimented later upon need
    public List<Message> getNewMessages();

    /**
     * @param to user or username to whom the messages were sent
     * @return get all messages which are sent to this user
     */
    public List<Message> getInbox(Employee to);

    /**
     * @param from user or username from whom the messages were sent
     * @return get all messages which are sent from this user
     */
    public List<Message> getOutbox(Employee from);

    /**
     * get an employee by their username
     * @param username to query
     * @return employee to get
     */
    Employee getEmployee(String username);

    /**
     * This method adds the message to the sql table and should also create call upon the
     * hashMe to create the hash code for the string
     * @param from id of the sender
     * @param to id of the recipient
     * @param body string of the message
     * @param subject subject of the message
     * @return message that is created
     */
    public void createMessage(String from, String to, String body, String subject);
}