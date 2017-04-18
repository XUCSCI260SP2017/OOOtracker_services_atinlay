package edu.xavier.csci260.atinlay.service;

import edu.xavier.csci260.atinlay.dal.EmployeeDAO;
import edu.xavier.csci260.atinlay.dal.EmployeeDAOImpl;
import edu.xavier.csci260.atinlay.dal.MessageDAO;
import edu.xavier.csci260.atinlay.dal.MessageDAOImpl;
import edu.xavier.csci260.atinlay.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

/**
 * Created by chris on 4/10/17.
 */
@Component
public class AccessServiceImpl implements AccessService {

    public EmployeeDAO employeeDAO;
    public MessageDAO messageDAO;
    public JdbcTemplate jdbcTemplate;

    @Autowired
    public AccessServiceImpl(JdbcTemplate jdbcTemplate) {
        this.employeeDAO = new EmployeeDAOImpl();
        this.messageDAO = new MessageDAOImpl();
        this.jdbcTemplate = jdbcTemplate;
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
    public Employee addEmployee(long id, String email, String pass, String first, String last, boolean enabled) {
        Employee employee = null;

        if (this.getEmployee(email).isEmpty()) {
            employee = new Employee(id, email, pass, first, last, enabled);
            employeeDAO.createUser(id, email, pass, first, last, enabled);
        }
        return employee;
    }

    /**
     * add employee
     *
     * @param employee
     * @return employee added
     */
    @Override
    public Employee addEmployee(Employee employee) {
        return this.addEmployee(
                employee.getID(),
                employee.getUsername(),
                employee.getPassword(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.isEnabled()
                );
    }

    /**
     * returns employee with given email
     *
     * @param email
     * @return
     */
    @Override
    public Employee getEmployee(String email) {
        return employeeDAO.findUser(email);
    }

    /**
     * returns employee with given email
     *
     * @param e
     * @return
     */
    @Override
    public Employee getEmployee(Employee e) {
        return employeeDAO.findUser(e);
    }

    /**
     * returns employee by id number
     *
     * @param id
     * @return
     */
    @Override
    public Employee getEmployee(long id) {
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
        Employee e = getEmployee(email);
        deleteEmployee(e);
        addEmployee(employee);
        return employee;
    }

    /**
     * deletes employee by employee
     *
     * @param employee
     * @return
     */
    @Override
    public Employee deleteEmployee(Employee employee) {
        return deleteEmployee(employee.getUsername());
    }

    /**
     * deletes employee by ID
     *
     * @param ID
     * @return
     */
    @Override
    public Employee deleteEmployee(long ID) {
        return employeeDAO.removeUser(ID);
    }

    /**
     * deletes employee by email
     *
     * @param email
     * @return
     */
    @Override
    public Employee deleteEmployee(String email) {
        return employeeDAO.removeUser(email);
    }

    /**
     * @return all employees in database
     */
    @Override
    public List<Employee> allEmployees() {
        return employeeDAO.findAll();
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
    public Message createMessage(long id, Date created, long toID, long fromID, String summary, String text) {
        return messageDAO.createMessage(id, created, toID, fromID, summary, text);
    }

    /**
     * gets message by ID
     *
     * @param id
     * @return
     */
    @Override
    public Message getMessage(long id) {
        return messageDAO.getMessage(id);
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
    public List<Message> getInbox(long id, boolean isSender) {
        // if isSender getMessageBySender
        // else getMessageByRecipient
        return isSender ? messageDAO.getMessagesBySender(id) : messageDAO.getMessagesByRecipient(id);
    }


    /**
     * approve day off. Only accessible by manager
     *
     * @param sender employee that is performing this action, sender
     * @param event
     * @param isApproved
     * @return
     */
    @Override
    public WorkEvent approveEvent(Employee sender, WorkEvent event, boolean isApproved) {
        WorkEvent e = null;

        if (sender.getRole() == RoleEnum.MANAGER) {
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
