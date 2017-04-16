package edu.xavier.csci260.atinlay.dal;

import edu.xavier.csci260.atinlay.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * class ___ is a member of the OOOtracker_services project.
 * <p>
 * Created by Luke on 4/15/2017.
 */
@SuppressWarnings("ALL")
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeDAOTest {

    @Autowired
    private EmployeeDAO sut;

    private Employee LUKE_EXPECTED = new Employee(
            new Long(2),
            "mcnameel@xavier.edu",
            "password",
            "Luke",
            "McNamee",
            true
    );

    // Employee "Not In DataBase"
    private Employee NIDB_EXPECTED = new Employee(
            new Long(3),
            "Not@in.database",
            "password",
            "NotIn",
            "Database",
            true
    );

    @Test
    public void getEmployeeByUsernameDotEquals() throws Exception {
        Employee LUKE_ACTUAL = sut.getEmployeeByUsername("mcnameel@xavier.edu");

        assertTrue(LUKE_EXPECTED.equals(LUKE_ACTUAL));

    }

    @Test
    public void getEmployeeByUsernameToString() throws Exception {

        Employee LUKE_ACTUAL = sut.getEmployeeByUsername("mcnameel@xavier.edu");

        assertEquals(LUKE_EXPECTED.toString(), LUKE_ACTUAL.toString());
    }

    @Test
    public void createEmployeeDotEquals() throws Exception {

        sut.createEmployee(
                new Employee(
                    NIDB_EXPECTED.getUsername(),
                    NIDB_EXPECTED.getPassword(),
                    NIDB_EXPECTED.getFirst_name(),
                    NIDB_EXPECTED.getLast_name())
        );

        Employee LUKE_ACTUAL = sut.getEmployeeByUsername(NIDB_EXPECTED.getUsername());

        assertTrue(NIDB_EXPECTED.equals(LUKE_ACTUAL));
    }

    @Test
    public void deleteFromDB() throws Exception {

        Boolean success = false;

        sut.createEmployee(new Employee("test", "test", "test", "test"));

        sut.removeEmployee(NIDB_EXPECTED);

        Employee ACTUAL = sut.getEmployeeByUsername("test");

        assertTrue(ACTUAL != null);
    }

    @Test
    public void createEmployeeToString() throws Exception {

        sut.removeEmployee(NIDB_EXPECTED);

        sut.createEmployee(NIDB_EXPECTED);

        Employee LUKE_ACTUAL = sut.getEmployeeByUsername(NIDB_EXPECTED.getUsername());

        NIDB_EXPECTED.setId(new Long(4));

        assertEquals(NIDB_EXPECTED.toString(), LUKE_ACTUAL.toString());
    }
}