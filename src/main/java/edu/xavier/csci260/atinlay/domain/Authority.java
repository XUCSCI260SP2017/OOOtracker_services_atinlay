package edu.xavier.csci260.atinlay.domain;

/**
 * class Authority is a member of the atinlay project.
 * Authorities are assigned to users and gives them access to different pages. Example: an EmployeeAbstract with an associated
 * authority "ROLE_HR" would be able to authorize adding extra vacation time to an employees yearly alotment and can
 * add employees to the database
 * <p>
 * Created by Luke on 4/13/2017.
 */
public class Authority {

    private String username, role;

    public Authority(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public Authority() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authority authority = (Authority) o;

        if (!getUsername().equals(authority.getUsername())) return false;
        return getRole().equals(authority.getRole());
    }

    @Override
    public int hashCode() {
        int result = getUsername().hashCode();
        result = 31 * result + getRole().hashCode();
        return result;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
