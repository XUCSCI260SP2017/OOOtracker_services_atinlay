package edu.xavier.csci260.atinlay.domain.TimeOff;


/**
 * Created by derekburdick on 4/24/17.
 */
public class TimeOffMaster {
    private TimeOff timeOff;
    private TimeOffReq timeOffReq;
    private TimeOffResponse timeOffResponse;
    private String status; //a field to check the status of our object

    public TimeOffMaster(TimeOff timeOff, TimeOffReq timeOffReq, TimeOffResponse timeOffResponse){
        this.timeOff = timeOff;
        this.timeOffReq = timeOffReq;
        this.timeOffResponse = timeOffResponse;
    }

    public void decide(){
        //check which fields are null and determine the outcome of the response.

    }


}
