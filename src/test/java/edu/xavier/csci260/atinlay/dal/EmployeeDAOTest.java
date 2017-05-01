package edu.xavier.csci260.atinlay.dal;

import edu.xavier.csci260.atinlay.domain.Employee;
import edu.xavier.csci260.atinlay.domain.RoleEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * class ___ is a member of the OOOtracker_services project.
 * <p>
 * Created by Luke on 4/15/2017.
 */
@SuppressWarnings("ALL")
@RunWith(SpringRunner.class)
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:testSchema.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:data.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:tearDown.sql")
})
public class EmployeeDAOTest {

    @Autowired
    private EmployeeDAO sut;

    private Employee MANAGER_EXPECTED = new Employee(
            new Long(2),
            "manager",
            "password",
            "user",
            "user",
            true,
            RoleEnum.MANAGER
    );

    // Employee "Not In DataBase"
    private Employee NIDB_EXPECTED = new Employee(
            new Long(3),
            "Not@in.database",
            "password",
            "NotIn",
            "Database",
            true,
            RoleEnum.WORKER
    );

    @Test
    public void getEmployeeByUsernameDotEquals() throws Exception {
        Employee MANAGER_ACTUAL = sut.getEmployeeByUsername("manager");

        assertTrue(MANAGER_EXPECTED.equals(MANAGER_ACTUAL));
    }

    @Test
    public void getEmployeeByUsernameToString() throws Exception {

        Employee MANAGER_ACTUAL = sut.getEmployeeByUsername("manager");

        MANAGER_EXPECTED.setId(new Long(2));

        assertEquals(MANAGER_EXPECTED.toString(), MANAGER_ACTUAL.toString());
    }

    @Test
    public void createEmployeeDotEquals() throws Exception {

        sut.createEmployee(NIDB_EXPECTED);

        Employee NIDB_ACTUAL = sut.getEmployeeByUsername(NIDB_EXPECTED.getUsername());

        NIDB_ACTUAL.setId(NIDB_EXPECTED.getId());

        assertEquals(NIDB_EXPECTED, NIDB_ACTUAL);
    }

    @Test
    public void deleteFromDB() throws Exception {

        Boolean success = false;

        Employee DELETE_ME = new Employee("test", "test", "test", "test", RoleEnum.WORKER);

        sut.createEmployee(DELETE_ME);

        sut.removeEmployee(DELETE_ME);

        try {

            Employee ACTUAL = sut.getEmployeeByUsername("test");
        }
        catch (EmptyResultDataAccessException e) {

            success = true;
        }

        assertTrue(success);
    }

    @Test
    public void createEmployeeToString() throws Exception {

        sut.removeEmployee(NIDB_EXPECTED);

        sut.createEmployee(NIDB_EXPECTED);

        Employee NIDB_ACTUAL = sut.getEmployeeByUsername(NIDB_EXPECTED.getUsername());

        NIDB_EXPECTED.setId(NIDB_ACTUAL.getId());

        assertEquals(NIDB_EXPECTED.toString(), NIDB_ACTUAL.toString());
    }
}