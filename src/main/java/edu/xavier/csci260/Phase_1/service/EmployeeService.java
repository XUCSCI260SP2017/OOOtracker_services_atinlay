package edu.xavier.csci260.Phase_1.service;

import java.util.List;

import edu.xavier.csci260.Phase_1.domain.Employee;
import edu.xavier.csci260.Phase_1.domain.Message;

/**
 * class ___ is a member of the Phase_1 project.
 * <p>
 * Created by Luke on 3/20/2017.
 */
public interface EmployeeService {

    /**
     * not sure what you want for param
     * @return true if successfully created
     */
    public void createEmplyee(String user, String first, String last, String password);

    /**
     * not sure what you want for param
     * @return true if successfully created
     */
    // TODO Not sure what this is for
    public boolean pushEmployee();

    /**
     * not sure what you want for param
     *
     * @return  Get all messages which have not been opened
     */
    public List<Message> getNewMessages();

    /**
     * not sure what you want for param
     *
     * @return  Get all messages
     */
    public List<Message> getMessages();

    /**
     * not sure what you want for param
     * @return get specific message
     */
    public Message getMessage();
    
    Employee getEmployeeByUsername(String username);
}
