package edu.xavier.csci260.atinlay.domain;

import java.sql.Date;

/**
 * Created by chris on 4/11/17.
 */
public class WorkEvent {
    private Date date;
    private int startTime;
    private int endTime;
    private WorkEventTimeEnum timeEnum;
    private boolean approved;

    public WorkEvent(Date date, WorkEventTimeEnum time) {
        this.date = date;
        this.timeEnum = time;
        this.startTime = time.getStartTime();
        this.endTime = time.getEndTime();
        this.approved = false;
    }

    public void approve() { this.approved = true; }
    public void deny() { this.approved = false; }

    public Date getDate() {
        return date;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public WorkEventTimeEnum getTimeEnum() {
        return timeEnum;
    }

    public boolean isApproved() {
        return approved;
    }
}
