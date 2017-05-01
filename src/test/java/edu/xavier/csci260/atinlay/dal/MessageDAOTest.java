package edu.xavier.csci260.atinlay.dal;

import edu.xavier.csci260.atinlay.domain.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
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
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:testSchema.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:data.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:tearDown.sql")
})
public class MessageDAOTest {

    @Autowired
    private MessageDAO sut;

    @Test
    public void getMessagesBySender() throws Exception {

        List<Message> messages = sut.getMessagesBySender("manager");

        assertEquals(
                "[Message{id=1, created=2014-07-10 14:35:00.0, from='manager', to='worker', " +
                        "body='This message is for Rob', subject='Hello Luke'}, " +
                        "Message{id=3, created=2014-07-11 21:15:00.0, from='manager', to='hr', " +
                        "body='This message is for Rob', subject='Is this secure?'}]",
                messages.toString());
    }

    @Test
    public void getMessagesByRecipient() throws Exception {

        List<Message> messages = sut.getMessagesByRecipient("hr");

        assertEquals(
                "[Message{id=3, created=2014-07-11 21:15:00.0, from='manager', to='hr', " +
                        "body='This message is for Rob', subject='Is this secure?'}, " +
                        "Message{id=5, created=2014-07-12 10:00:00.0, from='worker', to='hr', " +
                        "body='This message is for Joe', subject='Greetings Joe'}]",
                messages.toString());
    }

    @Test
    public void createMessage() throws Exception {

        Message Actual = new Message("test", "worker", "test", "test");

        sut.createMessage(Actual);

        List<Message> messages = sut.getMessagesByRecipient("worker");

        Message message = messages.get(messages.size()-1);

        Actual.setCreated(message.getCreated());
        Actual.setId(message.getId());

        assertEquals(Actual, message);
    }
}