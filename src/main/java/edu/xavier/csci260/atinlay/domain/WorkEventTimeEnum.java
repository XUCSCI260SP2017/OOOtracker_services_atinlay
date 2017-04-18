package edu.xavier.csci260.atinlay.domain;

/**
 * Created by chris on 4/12/17.
 *
 * enum to handle half days vs full days
 */
public enum WorkEventTimeEnum {
    MORNING('M', 0.5, 8, 12),
    AFTERNOON('A', 0.5, 12, 16),
    FULL('F', 1.0, 8, 16);

    private char code;
    private double weight;
    private int startTime;
    private int endTime;

    WorkEventTimeEnum(char code, double weight, int startTime, int endTime) {
        this.code = code;
        this.weight = weight;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public char getCode() { return this.code; }

    public double getWeight() { return this.weight; }

    public int getStartTime() { return this.startTime; }

    public int getEndTime() { return this.endTime; }
}
