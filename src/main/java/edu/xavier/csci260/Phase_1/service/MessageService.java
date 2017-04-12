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
     * This method adds the message to the sql table and should also create call upon the
     * hashMe to create the hash code for the string
     * @param fromMe
     * @param toYou
     * @param msgBody
     * @return
     */
    public Message createMessage(Employee fromMe, Employee toYou, String msgBody, String subject);



}
