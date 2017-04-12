package edu.xavier.csci260.Phase_1.domain;

import com.sun.xml.internal.ws.api.pipe.FiberContextSwitchInterceptor;

import java.util.ArrayList;
import java.util.List;

/**
 * class ___ is a member of the Phase_1 project.
 * <p>
 * Created by Luke on 3/12/2017.
 * refactored by chris on 4/10/2017
 */
public class Employee {
    private List<Message> inbox;
    private List<WorkEvent> events;

    private int id;
    private String email, firstName, lastName, password;
    private boolean enabled;

    public Employee(int id, String email, String pass, String first, String last, boolean enabled) {
        this.id = id;
        this.email = email;
        this.password = pass;
        this.firstName = first;
        this.lastName = last;
        this.enabled = enabled;

        inbox = new ArrayList<Message>();
        events = new ArrayList<WorkEvent>();
    }

    public List<Message> getInbox() {
        return inbox;
    }

    public void setInbox(List<Message> inbox) {
        this.inbox = inbox;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
