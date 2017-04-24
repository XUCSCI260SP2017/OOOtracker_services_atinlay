package edu.xavier.csci260.atinlay.service;



import edu.xavier.csci260.atinlay.dal.EmployeeDAO;
import edu.xavier.csci260.atinlay.dal.EmployeeDAOImpl;
import edu.xavier.csci260.atinlay.dal.MessageDAO;
import edu.xavier.csci260.atinlay.dal.MessageDAOImpl;
import edu.xavier.csci260.atinlay.dal.TimeOff.*;
import edu.xavier.csci260.atinlay.domain.Employee;
import edu.xavier.csci260.atinlay.domain.Message;
import edu.xavier.csci260.atinlay.domain.RoleEnum;
import edu.xavier.csci260.atinlay.domain.TimeOff.TimeOffReq;
import edu.xavier.csci260.atinlay.domain.TimeOff.TimeOffResponse;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by chris on 4/10/17.
 */
@Component
public class AccessServiceImpl implements AccessService {

    public EmployeeDAO employeeDAO;
    public MessageDAO messageDAO;
    public JdbcTemplate jdbcTemplate;
    public TimeOffReqDAO timeOffReqDAO;
    public TimeOffDAO timeOffDAO;
    public TimeOffResponseDAO timeOffResponseDAO;

    @Autowired
    public AccessServiceImpl(JdbcTemplate jdbcTemplate) {
        this.employeeDAO = new EmployeeDAOImpl(jdbcTemplate);
        this.messageDAO = new MessageDAOImpl();
        this.jdbcTemplate = jdbcTemplate;
        this.timeOffDAO = new TimeOffDAOImpl();
        this.timeOffReqDAO = new TimeOffReqDAOImpl();
        this.timeOffResponseDAO = new TimeOffResponseDAOImpl();
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
     * @param toUser
     * @param fromUser
     * @param summary
     * @param text
     * @return
     */
    @Override
    public void createMessage(String fromUser,String toUser, String summary, String text) {
        Message message = new Message(fromUser,toUser,text,summary);
        messageDAO.createMessage(message);
    }

    /**
     * gets message by ID
     *
     * @param id
     * @returnH
     */
    @Override
    public Message getMessage(long id) {
        return messageDAO.getMessageById(id).get(0);
    }

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
    @Override
    public List<Message> getInbox(String username, boolean isSender) {
        // if isSender getMessageBySender
        // else getMessageByRecipient
        return isSender ? messageDAO.getMessagesBySender(username) : messageDAO.getMessagesByRecipient(username);
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
    public TimeOffResponse approveEvent(Employee sender, TimeOffReq event, String description, String reason, boolean isApproved) {
        TimeOffResponse e = null;

        if (sender.getRole() == RoleEnum.MANAGER || sender.getRole() == RoleEnum.HR) {
            e = new TimeOffResponse(event.getId(), isApproved, reason, description, sender.getUsername());
        }

        return e;
    }

    @Override
    public TimeOffReq requestEvent(String managerEmail, String requesteeEmail, String description, String reason, Timestamp startTime, Timestamp endTime) {
        TimeOffReq request = null;
        if (StringUtils.hasText(managerEmail) && StringUtils.hasText(requesteeEmail) && StringUtils.hasText(reason) && startTime != null && endTime != null) {
            request = new TimeOffReq(startTime, endTime, requesteeEmail, managerEmail, reason, description);
            timeOffReqDAO.createTimeOffReq(request);
        }

        return request;
    }
}
