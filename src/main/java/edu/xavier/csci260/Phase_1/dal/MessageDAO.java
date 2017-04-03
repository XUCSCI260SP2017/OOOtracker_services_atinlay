package edu.xavier.csci260.Phase_1.dal;

import java.util.List;

import edu.xavier.csci260.Phase_1.domain.Employee;
import edu.xavier.csci260.Phase_1.domain.Message;

public interface MessageDAO {
	
	/**
	 * returns messages that have the specified employee as the sender
	 * 
	 * @param employee
	 * ******or******
	 * @param username
	 * @return list of messages
	 */
	List<Message> getMessagesBySender(String username);
	List<Message> getMessagesBySender(Employee sender);
	
	/**
	 * returns messages that have the specified recipient
	 * 
	 * @param employee
	 * ******or******
	 * @param username
	 * @return list of messages
	 */
	List<Message> getMessagesByRecipient(String username);
	List<Message> getMessagesByRecipient(Employee recipient);
	
	/**
	 * creates a new message
	 * @param sender
	 * @param recipient
	 * @return
	 */
	// TODO Message UID
	void createMessage(Employee sender, Employee recipient, String subject, String body);
	
}
