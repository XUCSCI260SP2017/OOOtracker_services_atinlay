package edu.xavier.csci260.atinlay.dal;

import edu.xavier.csci260.atinlay.domain.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;


/**
 * class ___ is a member of the OOOtracker_services project.
 * <p>
 * Created by Luke on 4/15/2017.
 */
@SuppressWarnings("ALL")
@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageDAOTest {

    @Autowired
    private MessageDAO sut;

    @Test
    public void getMessagesBySender() throws Exception {
        List<Message> messages = sut.getMessagesBySender("mcnameel@xavier.edu");

        assertEquals(
                "[Message{id=110, created=2014-07-12 10:00:00.0, from='mcnameel@xavier.edu', " +
                        "to='ellisa4@xavier.edu', body='This message is for Joe', subject='Hello Joe'}, " +
                        "Message{id=111, created=2014-07-12 10:00:00.0, from='mcnameel@xavier.edu', " +
                        "to='ellisa4@xavier.edu', body='This message is for Joe', subject='Greetings Joe'}, " +
                        "Message{id=112, created=2014-07-12 10:00:00.0, from='mcnameel@xavier.edu', " +
                        "to='ellisa4@xavier.edu', body='This message is for Joe', subject='Is this secure?'}]",
                messages.toString());
    }

    @Test
    public void getMessagesByRecipient() throws Exception {
        List<Message> messages = sut.getMessagesByRecipient("ellisa4@xavier.edu");

        assertEquals(
                "[Message{id=110, created=2014-07-12 10:00:00.0, from='mcnameel@xavier.edu', " +
                        "to='ellisa4@xavier.edu', body='This message is for Joe', subject='Hello Joe'}, " +
                        "Message{id=111, created=2014-07-12 10:00:00.0, from='mcnameel@xavier.edu', " +
                        "to='ellisa4@xavier.edu', body='This message is for Joe', subject='Greetings Joe'}, " +
                        "Message{id=112, created=2014-07-12 10:00:00.0, from='mcnameel@xavier.edu', " +
                        "to='ellisa4@xavier.edu', body='This message is for Joe', subject='Is this secure?'}, " +
                        "Message{id=119, created=2017-04-18 17:33:48.385, from='test', " +
                        "to='ellisa4@xavier.edu', body='test', subject='test'}]",
                messages.toString());
    }

    @Test
    public void createMessage() throws Exception {

        sut.createMessage(new Message("test", "ellisa4@xavier.edu", "test", "test"));

        List<Message> messages = sut.getMessagesByRecipient("ellisa4@xavier.edu");

        assertEquals(
                "[Message{id=110, created=2014-07-12 10:00:00.0, from='mcnameel@xavier.edu', " +
                        "to='ellisa4@xavier.edu', body='This message is for Joe', subject='Hello Joe'}, " +
                        "Message{id=111, created=2014-07-12 10:00:00.0, from='mcnameel@xavier.edu', " +
                        "to='ellisa4@xavier.edu', body='This message is for Joe', subject='Greetings Joe'}, " +
                        "Message{id=112, created=2014-07-12 10:00:00.0, from='mcnameel@xavier.edu', " +
                        "to='ellisa4@xavier.edu', body='This message is for Joe', subject='Is this secure?'}, " +
                        "Message{id=119, created=2017-04-18 17:33:48.385, from='test', " +
                        "to='ellisa4@xavier.edu', body='test', subject='test'}]",
                messages.toString());
    }
}