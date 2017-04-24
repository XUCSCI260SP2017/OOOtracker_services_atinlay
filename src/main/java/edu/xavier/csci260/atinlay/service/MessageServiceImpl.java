package edu.xavier.csci260.atinlay.service;

import edu.xavier.csci260.atinlay.dal.MessageDAO;
import edu.xavier.csci260.atinlay.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by derekburdick on 3/27/17.
 */
@Component
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDAO messageDAO;

    @Override
    public Message createMessage(Long fromMe, Long toYou, String msgBody) {
        return null;
    }

    @Override
    public Message getMessageById(Long id) {
        return messageDAO.getMessageById(id).get(0);
    }
}
