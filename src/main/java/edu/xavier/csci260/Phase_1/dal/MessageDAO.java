package edu.xavier.csci260.Phase_1.dal;

import edu.xavier.csci260.Phase_1.domain.Message;

import java.sql.Date;
import java.util.List;

public interface MessageDAO {
    /**
     * creates a message
     *
     * @param id
     * @param created
     * @param toID
     * @param fromID
     * @param summary
     * @param text
     * @return
     */
    Message createMessage(int id, Date created, int toID, int fromID, String summary, String text);

    /**
     * get message by message ID
     *
     * @param id
     * @return
     */
    Message getMessage(int id);

    /**
     * get messages by sender ID
     *
     * @param id
     * @return
     */
    List<Message> getMessagesBySender(int id);

    /**
     * get messages by recipient ID
     *
     * @param id
     * @return
     */
    List<Message> getMessagesByRecipient(int id);
}