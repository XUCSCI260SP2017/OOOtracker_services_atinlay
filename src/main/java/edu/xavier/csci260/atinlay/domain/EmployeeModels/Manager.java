package edu.xavier.csci260.atinlay.domain.EmployeeModels;

import edu.xavier.csci260.atinlay.domain.Authority;
import edu.xavier.csci260.atinlay.domain.Employee;

public class Manager extends Employee {

    private final Authority authority = new Authority(username, "ROLE_MANAGER");

    public Manager() {
        super();
    }

    public Manager(Long id, String username, String password, String first_name, String last_name, boolean enabled) {

        super(id, username, password, first_name, last_name, enabled);

        this.manager_id = username;
    }

    public Manager(String username, String password, String first_name, String last_name) {

        super(username, password, first_name, last_name);

        this.manager_id = username;
    }

    @Override
    public Boolean hasAuthority() {
        return true;
    }

    @Override
    public Authority getAuthority() {
        return this.authority;
    }
}