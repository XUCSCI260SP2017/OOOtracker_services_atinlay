package edu.xavier.csci260.atinlay.domain.TimeOff;

import java.sql.Timestamp;

/**
 * class ___ is a member of the OOOtracker_services project.
 * <p>
 * Created by Luke on 4/23/2017.
 */
public class TimeOffReq extends TimeOff {

    private Timestamp created;

    private String description;

    private String manager;

    public TimeOffReq() {
        super();
    }

    public TimeOffReq(Timestamp startTimestamp, Timestamp endTimestamp, String employee, String manager, String reason,
                      String description) {

        super(startTimestamp, endTimestamp, employee, reason);

        this.id = id;
        this.manager = manager;
        this.description = description;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
