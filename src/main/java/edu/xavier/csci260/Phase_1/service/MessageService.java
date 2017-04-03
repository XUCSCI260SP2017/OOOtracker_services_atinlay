package edu.xavier.csci260.Phase_1.service;

import edu.xavier.csci260.Phase_1.domain.Employee;
import edu.xavier.csci260.Phase_1.domain.Message;

/**
 * class ___ is a member of the Phase_1 project.
 * <p>
 * Created by Luke on 3/23/2017.
 */
public interface MessageService {

    /**
     * This function takes a message and hashes the time sent with the sender's username to create a unique hash value
     * for our sql server to identify the message
     * @param hashMe
     * @return
     */
    public long hashMsg(Message hashMe);

    /**
     * This method adds the message to the sql table and should also create call upon the
     * hashMe to create the hash code for the string
     * @param fromMe
     * @param toYou
     * @param msgBody
     * @return
     */
    public Message createMessage(Employee fromMe, Employee toYou, String msgBody);



}
