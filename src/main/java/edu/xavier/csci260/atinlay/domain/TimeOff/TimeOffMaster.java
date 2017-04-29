package edu.xavier.csci260.atinlay.domain.TimeOff;


/**
 * Created by derekburdick on 4/24/17.
 */
public class TimeOffMaster extends TimeOff {
    private TimeOff timeOff;
    private TimeOffReq timeOffReq;
    private TimeOffResponse timeOffResponse;
    private String status; //a field to check the status of our object

    public TimeOffMaster(TimeOff timeOff, TimeOffReq timeOffReq, TimeOffResponse timeOffResponse){
        this.timeOff = timeOff;
        this.timeOffReq = timeOffReq;
        this.timeOffResponse = timeOffResponse;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TimeOffReq getTimeOffReq() {
        return timeOffReq;
    }

    public void setTimeOffReq(TimeOffReq timeOffReq) {
        this.timeOffReq = timeOffReq;
    }

    public TimeOffResponse getTimeOffResponse() {
        return timeOffResponse;
    }

    public void setTimeOffResponse(TimeOffResponse timeOffResponse) {
        this.timeOffResponse = timeOffResponse;
    }
}
