package edu.xavier.csci260.atinlay.service;

import edu.xavier.csci260.atinlay.domain.Authority;
import edu.xavier.csci260.atinlay.domain.Employee;
import edu.xavier.csci260.atinlay.domain.Message;

import java.util.List;

/**
 * class ___ is a member of the atinlay project.
 * <p>
 * Created by Luke on 3/20/2017.
 */
public interface EmployeeService {


    /**
     * this method will create a Worker
     * @param username regular constructors from superclass
     * @param first_name regular constructors from superclass
     * @param last_name regular constructors from superclass
     * @param password regular constructors from superclass
     * @param manager_id the username of the manager for this employee
     */
    public void createWorker(String username, String first_name, String last_name, String password, String manager_id);

    /**
     * this method will create a Manager
     * @param username regular constructors from superclass
     * @param first_name regular constructors from superclass
     * @param last_name regular constructors from superclass
     * @param password regular constructors from superclass
     */
    public void createManager(String username, String first_name, String last_name, String password);

    /**
     * this method will create a HumanResoucesManager
     * @param username regular constructors from superclass
     * @param first_name regular constructors from superclass
     * @param last_name regular constructors from superclass
     * @param password regular constructors from superclass
     * @param manager_id the username of the manager for this employee. If has no manager then give manager_id as self (this.username)
     */
    public void createHR(String username, String first_name, String last_name, String password, String manager_id);


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

    /**
     * we need this function to check the authorities of an employee (by calling the function from dal
     * @param employee to be used in query
     * @return the authorities associated with an employee
     */
    public Authority getAuthority(Employee employee);
}