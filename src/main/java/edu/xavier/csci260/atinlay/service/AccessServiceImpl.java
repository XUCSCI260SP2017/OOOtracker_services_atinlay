package edu.xavier.csci260.atinlay.service;

import edu.xavier.csci260.atinlay.dal.EmployeeDAO;
import edu.xavier.csci260.atinlay.dal.EmployeeDAOImpl;
import edu.xavier.csci260.atinlay.dal.MessageDAO;
import edu.xavier.csci260.atinlay.dal.MessageDAOImpl;
import edu.xavier.csci260.atinlay.domain.*;
import edu.xavier.csci260.atinlay.domain.TimeOff.TimeOffReq;
import edu.xavier.csci260.atinlay.domain.TimeOff.TimeOffResponse;
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
        this.employeeDAO = new EmployeeDAOImpl(jdbcTemplate);
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
    public Employee addEmployee(long id, String email, String pass, String first, String last, boolean enabled, RoleEnum role) {
        Employee employee = null;

        if (this.getEmployee(email) != null) {
            employee = new Employee(id, email, pass, first, last, enabled, role);
            employeeDAO.createEmployee(employee);
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
                employee.getId(),
                employee.getUsername(),
                employee.getPassword(),
                employee.getFirst_name(),
                employee.getLast_name(),
                employee.isEnabled(),
                employee.getRole()
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
        return employeeDAO.getEmployeeByUsername(email);
    }

    /**
     * returns employee with given email
     *
     * @param e
     * @return
     */
    @Override
    public Employee getEmployee(Employee e) {
        return this.getEmployee(e.getUsername());
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
        employeeDAO.removeEmployee(employee);
        return employee;
    }

    /**
     * deletes employee by email
     *
     * @param email
     * @return
     */
    @Override
    public Employee deleteEmployee(String email) {
        Employee e = getEmployee(email);
        return deleteEmployee(e);
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
     * @returnH
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
    public TimeOffResponse approveEvent(Employee sender, TimeOffReq event, boolean isApproved) {
        TimeOffResponse e = null;

        if (sender.getRole() == RoleEnum.MANAGER || sender.getRole() == RoleEnum.HR) {
            if (isApproved) {
                e = new TimeOffResponse();
            } else {
                event.deny();
                e = event;
            }
        }

        return e;
    }
}
