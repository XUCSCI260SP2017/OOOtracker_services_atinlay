package edu.xavier.csci260.atinlay.domain.TimeOff;

import java.sql.Timestamp;

/**
 * This represents time that an employee is garenteed to have off. This should only be created after a request has been
 * approved by a manager
 * <p>
 * Created by Luke on 4/23/2017.
 */
public class TimeOff {

    // This id will be the same between TimeOff, TimeOffReq, and TimeOffResponse
    protected Long id;

    protected Timestamp startTimestamp;

    protected Timestamp endTimestamp;

    protected String employee;

    private String reason;

    public TimeOff(Timestamp startTimestamp, Timestamp endTimestamp, String employee, String reason) {

        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
        this.employee = employee;
        this.reason = reason;
    }

    public TimeOff() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Timestamp startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public Timestamp getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(Timestamp endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
