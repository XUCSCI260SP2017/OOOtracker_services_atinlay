package edu.xavier.csci260.Phase_1.service;

import edu.xavier.csci260.Phase_1.dal.MessageDAOImpl;
import edu.xavier.csci260.Phase_1.domain.Employee;
import edu.xavier.csci260.Phase_1.domain.Message;

import javax.sql.DataSource;

/**
 * Created by derekburdick on 3/27/17.
 */
public class MessageServiceImpl implements MessageService {

    DataSource dataSource;
    @Override
    public Message createMessage(Employee fromMe, Employee toYou, String msgBody, String subject) {
        MessageDAOImpl messageDAOImpl = new MessageDAOImpl(dataSource);
        messageDAOImpl.createMessage(fromMe,toYou,subject,msgBody);

        return null;
    }


}
