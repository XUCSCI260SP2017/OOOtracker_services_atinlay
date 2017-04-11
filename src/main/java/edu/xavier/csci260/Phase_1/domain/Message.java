package edu.xavier.csci260.Phase_1.domain;

import java.time.LocalDateTime;


/**
 * refactored by chris on 4/10/2017
 *
 * INSERT INTO message(id,created,to_id,from_id,summary,text)
 */
public class Message {
    private int id;
    private String created;
    private int toID, fromID;
    private String summary, text;

    public Message(int id, String created, int toID, int fromID, String summary, String text) {
        this.id = id;
        this.created = created;
        this.toID = toID;
        this.fromID = fromID;
        this.summary = summary;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public int getToID() {
        return toID;
    }

    public void setToID(int toID) {
        this.toID = toID;
    }

    public int getFromID() {
        return fromID;
    }

    public void setFromID(int fromID) {
        this.fromID = fromID;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

