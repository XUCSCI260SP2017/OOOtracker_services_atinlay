package edu.xavier.csci260.atinlay.domain;

import java.io.Serializable;

/**
 * class ___ is a member of the atinlay project.
 * <p>
 * Created by Luke on 3/12/2017.
 */
public class Employee implements Serializable {

    private Long id;

    private String username, password;

    private String first_name, last_name;

    private boolean enabled;

    public Employee(Long id, String username, String password, String first_name, String last_name, boolean enabled) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.enabled = enabled;
    }

    public Employee(String username, String password, String first_name, String last_name) {
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.enabled = true;
    }

    public Employee() {
    }

    public Object[] asList() {
        return new Object[]{ username, password, first_name, last_name, enabled };
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", enabled=" + enabled +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (isEnabled() != employee.isEnabled()) return false;
        if (!getId().equals(employee.getId())) return false;
        if (!getUsername().equals(employee.getUsername())) return false;
        if (!getPassword().equals(employee.getPassword())) return false;
        if (getFirst_name() != null ? !getFirst_name().equals(employee.getFirst_name()) : employee.getFirst_name() != null)
            return false;
        return getLast_name() != null ? getLast_name().equals(employee.getLast_name()) : employee.getLast_name() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getUsername().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + (getFirst_name() != null ? getFirst_name().hashCode() : 0);
        result = 31 * result + (getLast_name() != null ? getLast_name().hashCode() : 0);
        result = 31 * result + (isEnabled() ? 1 : 0);
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

    public boolean isEnabled() {
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
}
