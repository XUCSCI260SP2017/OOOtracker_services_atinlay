package edu.xavier.csci260.atinlay.domain.EmployeeModels;

import edu.xavier.csci260.atinlay.domain.Authority;
import edu.xavier.csci260.atinlay.domain.Employee;

public class Worker extends Employee {

    private final Authority authority = new Authority(username, "ROLE_WORKER");

    public Worker(Long id, String username, String password, String first_name, String last_name, boolean enabled, String manager_id) {

        super(id, username, password, first_name, last_name, enabled);

        this.manager_id = manager_id;
    }

    public Worker(String username, String password, String first_name, String last_name, String manager_id) {

        super(username, password, first_name, last_name);

        this.manager_id = manager_id;
    }

    public Worker() {
        super();
    }

    @Override
    public Boolean hasAuthority() {
        return true;
    }

    @Override
    public Authority getAuthority() {
        return this.authority;
    }}
