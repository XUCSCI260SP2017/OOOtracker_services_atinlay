package edu.xavier.csci260.atinlay.service;

import edu.xavier.csci260.atinlay.domain.Message;

/**
 * class ___ is a member of the atinlay project.
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
    public Message createMessage(Long fromMe, Long toYou, String msgBody);


    Message getMessageById(Long id);
}
