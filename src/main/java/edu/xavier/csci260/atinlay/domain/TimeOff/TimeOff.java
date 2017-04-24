package edu.xavier.csci260.atinlay.domain.TimeOff;

import java.sql.Timestamp;

/**
 * class ___ is a member of the OOOtracker_services project.
 * <p>
 * Created by Luke on 4/23/2017.
 */
public class TimeOff {

    protected Long id;

    private Timestamp startTimestamp;

    private Timestamp endTimestamp;

    protected String employee;

    protected String manager;

    private String reason;

    public TimeOff(Timestamp startTimestamp, Timestamp endTimestamp, String employee, String manager, String reason) {

        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
        this.employee = employee;
        this.manager = manager;
        this.reason = reason;
    }

    public TimeOff() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeOff timeOff = (TimeOff) o;

        if (getId() != null ? !getId().equals(timeOff.getId()) : timeOff.getId() != null) return false;
        if (!getStartTimestamp().equals(timeOff.getStartTimestamp())) return false;
        if (!getEndTimestamp().equals(timeOff.getEndTimestamp())) return false;
        if (!getEmployee().equals(timeOff.getEmployee())) return false;
        if (!getManager().equals(timeOff.getManager())) return false;
        return getReason().equals(timeOff.getReason());
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getStartTimestamp().hashCode();
        result = 31 * result + getEndTimestamp().hashCode();
        result = 31 * result + getEmployee().hashCode();
        result = 31 * result + getManager().hashCode();
        result = 31 * result + getReason().hashCode();
        return result;
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

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
