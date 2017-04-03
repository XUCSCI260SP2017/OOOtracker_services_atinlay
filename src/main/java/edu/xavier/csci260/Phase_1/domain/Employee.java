package edu.xavier.csci260.Phase_1.domain;

import java.util.ArrayList;

/**
 * class ___ is a member of the Phase_1 project.
 * <p>
 * Created by Luke on 3/12/2017.
 */
public class Employee {

    private ArrayList<Message> inbox;

    private String user_name;
    private String password;
    private String first_name;
    private String last_name;
   // Integer manager_id; // NEVER use primative types on a edu.xavier.csci260.Phase_1.domain object, spring need to initialze values to null

    public Employee(String user_name, String first_name, String last_name, String password) {

        inbox = new ArrayList<>();

        this.user_name = user_name;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
    //    this.manager_id = manager_id;
    }

    public Employee() {
        inbox = new ArrayList<Message>();
    }

    public ArrayList<Message> getInbox() {
        return null;
    }

    public boolean refreshInbox() {
        //dal.getMessages();
        //if successful
        return true;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
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
