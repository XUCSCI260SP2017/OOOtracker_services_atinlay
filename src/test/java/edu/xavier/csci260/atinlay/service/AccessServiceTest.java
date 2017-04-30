package edu.xavier.csci260.atinlay.service;

import edu.xavier.csci260.atinlay.dal.EmployeeDAOImpl;
import edu.xavier.csci260.atinlay.domain.Employee;
import edu.xavier.csci260.atinlay.domain.RoleEnum;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static edu.xavier.csci260.atinlay.domain.RoleEnum.MANAGER;
import static org.junit.Assert.*;

/**
 * Created by derekburdick on 4/30/17.
 */
public class AccessServiceTest {

    @Autowired
    private EmployeeDAOImpl employeeDAO;

    @Autowired
    private AccessService accessService;

    private Employee employee = new Employee(
            new Long (1234),
            "test@usr.com",
            "password",
            "derek",
            "burdick",
            true,
            MANAGER );
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void addEmployee() throws Exception {
        accessService.addEmployee(employee.getId(),employee.getUsername(),
        employee.getPassword(), employee.getFirst_name(), employee.getLast_name(),employee.getEnabled(), employee.getRole());
        assertSame(employeeDAO.getEmployeeByUsername(employee.getUsername()), employee);
    }

    @Test
    public void addEmployee1() {

    }

    @Test
    public void getEmployee() {

    }

    @Test
    public void getEmployee1() {

    }

    @Test
    public void updateEmployee() {

    }

    @Test
    public void deleteEmployee() {

    }

    @Test
    public void deleteEmployee1() {

    }

    @Test
    public void allEmployees() {

    }

    @Test
    public void createMessage() {

    }

    @Test
    public void getMessage() {

    }

    @Test
    public void getInbox() {

    }

    @Test
    public void approveEvent()  {

    }

    @Test
    public void requestEvent() {

    }

}