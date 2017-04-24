package edu.xavier.csci260.atinlay.domain.TimeOff;

import java.sql.Timestamp;

/**
 * class ___ is a member of the OOOtracker_services project.
 * <p>
 * Created by Luke on 4/24/2017.
 */
public class TimeOffResponse {

    private Long id;

    private Boolean approved;

    private String reason;

    private String manager;

    private String description;

    private Timestamp closed;

    public TimeOffResponse(Long id, Boolean approved, String reason, String description, String manager) {

        this.id = id;
        this.approved = approved;
        this.reason = reason;
        this.description = description;
        this.manager = manager;
    }

    public TimeOffResponse() {
    }

    public Timestamp getClosed() {
        return closed;
    }

    public void setClosed(Timestamp closed) {
        this.closed = closed;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
