package edu.xavier.csci260.atinlay.domain.TimeOff;

/**
 * class ___ is a member of the OOOtracker_services project.
 * <p>
 * Created by Luke on 4/24/2017.
 */
public class TimeOffResponse {

    private Long id;

    private Boolean approved;

    private String reason;

    private String description;

    public TimeOffResponse(Boolean approved, String reason, String description) {
        this.approved = approved;
        this.reason = reason;
        this.description = description;
    }

    public TimeOffResponse() {
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
