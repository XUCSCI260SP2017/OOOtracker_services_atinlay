package edu.xavier.csci260.atinlay.domain;

import java.io.Serializable;

/**
 * class ___ is a member of the OOOtracker_services project.
 * <p>
 * Created by Luke on 4/16/2017.
 */
public class Employee implements Serializable {

    private Long id;

    private String username, password;

    private String first_name, last_name;

    private Boolean enabled;

    private String manager_id;

    private RoleEnum role;

    public void setVars(String username, String password, String first_name, String last_name) {
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Employee(Long id, String username, String password, String first_name, String last_name, Boolean enabled, RoleEnum role) {
        this.id = id;
        setVars(username, password, first_name, last_name);
        this.enabled = enabled;
        this.role = role;
    }

    public Employee(String username, String password, String first_name, String last_name, RoleEnum role) {
        setVars(username, password, first_name, last_name);

        this.enabled = true;
        this.role = role;
    }

    public Employee() {
    }

    public Object[] asList() {
        return new Object[]{username, password, first_name, last_name, enabled, role};
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return (getId() != null ? getId().equals(employee.getId()) : employee.getId() == null)
                && getUsername().equals(employee.getUsername())
                && getPassword().equals(employee.getPassword())
                && getFirst_name().equals(employee.getFirst_name())
                && getLast_name().equals(employee.getLast_name())
                && (isEnabled() != null ? isEnabled().equals(employee.isEnabled()) : employee.isEnabled() == null)
                && getManager_id().equals(employee.getManager_id())
                && role == employee.role;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getUsername().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getFirst_name().hashCode();
        result = 31 * result + getLast_name().hashCode();
        result = 31 * result + (isEnabled() != null ? isEnabled().hashCode() : 0);
        result = 31 * result + getManager_id().hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getManager_id() {
        return manager_id;
    }

    public void setManager_id(String manager_id) {
        this.manager_id = manager_id;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public void setRole(String role) {
        switch (role) {
            case "ROLE_WORKER":
                this.role = RoleEnum.WORKER;

            case "ROLE_MANAGER":
                this.role = RoleEnum.MANAGER;

            case "ROLE_HR":
                this.role = RoleEnum.HR;

            default:
                throw new RoleDoesNotExistError();
        }
    }

    private class RoleDoesNotExistError extends RuntimeException {

        // Log that the role does not exist. This probably happened in the sql statement
    }
}


