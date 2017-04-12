package edu.xavier.csci260.Phase_1.service;

import edu.xavier.csci260.Phase_1.dal.EmployeeDAO;
import edu.xavier.csci260.Phase_1.dal.EmployeeDAOImpl;
import edu.xavier.csci260.Phase_1.dal.MessageDAO;
import edu.xavier.csci260.Phase_1.dal.MessageDAOImpl;
import edu.xavier.csci260.Phase_1.domain.Employee;
import edu.xavier.csci260.Phase_1.domain.Manager;
import edu.xavier.csci260.Phase_1.domain.Message;
import edu.xavier.csci260.Phase_1.domain.WorkEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chris on 4/10/17.
 */
@Component
public class AccessServiceImpl implements AccessService {

    public EmployeeDAO employeeDAO;
    public MessageDAO messageDAO;

    @Autowired
    public AccessServiceImpl(DataSource dataSource) {
        employeeDAO = new EmployeeDAOImpl(dataSource);
        messageDAO = new MessageDAOImpl(dataSource);
    }

    /**
     * add employee
     *
     * @param id
     * @param email
     * @param pass
     * @param first
     * @param last
     * @param enabled
     */
    @Override
    public Employee addEmployee(int id, String email, String pass, String first, String last, boolean enabled) {
        Employee e = new Employee(id, email, pass, first, last, true);
        employeeDAO.createUser(e);
        return e;
    }

    /**
     * returns employee with given email
     *
     * @param email
     * @return
     */
    @Override
    public List<Employee> getEmployee(String email) {
        return employeeDAO.findUser(email);
    }

    /**
     * returns employee with given email
     *
     * @param e
     * @return
     */
    @Override
    public List<Employee> getEmployee(Employee e) {
        return employeeDAO.findUser(e);
    }

    /**
     * returns employee by id number
     *
     * @param id
     * @return
     */
    @Override
    public List<Employee> getEmployee(int id) {
        return employeeDAO.findUser(id);
    }

    /**
     * grab employee by email, replace it with new employee
     *
     * @param email
     * @param employee
     * @return Employee
     */
    @Override
    public Employee updateEmployee(String email, Employee employee) {
        Employee e = getEmployee(email).get(0);
        employeeDAO.removeUser(e);
        employeeDAO.createUser(employee);
        return employee;
    }

    /**
     * deletes employee by employee
     *
     * @param employee
     * @return
     */
    @Override
    public List<Employee> deleteEmployee(Employee employee) {
        return null;
    }

    /**
     * deletes employee by email
     *
     * @param email
     * @return
     */
    @Override
    public List<Employee> deleteEmployee(String email) {
        return null;
    }

    /**
     * create a message
     *
     * @param id
     * @param created
     * @param toID
     * @param fromID
     * @param summary
     * @param text
     * @return
     */
    @Override
    public Message createMessage(int id, Date created, int toID, int fromID, String summary, String text) {
        return messageDAO.createMessage(id, created, toID, fromID, summary, text);
    }

    /**
     * gets message by ID
     *
     * @param id
     * @return
     */
    @Override
    public List<Message> getMessage(int id) {
        return messageDAO.getMessagesByID(id);
    }

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
    @Override
    public List<Message> getMessage(int id, boolean isSender) {
        // if isSender getMessageBySender
        // else getMessageByRecipient
        return isSender ? messageDAO.getMessagesBySender(id) : messageDAO.getMessagesByRecipient(id);
    }

    /**
     * approve day off. Only accessible by manager
     *
     * @param sender employee that is performing this action
     * @param event
     * @return
     */
    @Override
    public WorkEvent approveEvent(Employee sender, WorkEvent event, boolean isApproved) {
        WorkEvent e = null;

        if (sender instanceof Manager) {
            if (isApproved) {
                event.approve();
                e = event;
            } else {
                event.deny();
                e = event;
            }
        }

        return e;
    }
}
